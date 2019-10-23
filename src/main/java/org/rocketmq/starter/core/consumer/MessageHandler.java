package org.rocketmq.starter.core.consumer;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.message.MessageQueue;
import org.rocketmq.starter.RocketMQConsumerListener;
import org.rocketmq.starter.exception.ConsumeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

/**
 * 消息处理器
 *
 * @author He Jialin
 */
public class MessageHandler {

    private static final Logger log = LoggerFactory.getLogger(MessageHandler.class);

    public static ConsumeStatus handleMessage(final RocketMQConsumerListener listener,
                                              final List<MessageExt> msgs, final MessageQueue messageQueue) {
        try {
            for (MessageExt msg : msgs) {
                byte[] body = msg.getBody();
                int reconsumeTimes = msg.getReconsumeTimes();
                final MessageContext messageContext = new MessageContext();
                messageContext.setMessageExt(msg);
                messageContext.setMessageQueue(messageQueue);
                if (log.isDebugEnabled()) {
                    log.debug("开始消费，msg={}", msg);
                }
                try {
                    String str = new String(body,"UTF-8");
//                    JSONObject jsonStr = JSONObject.parseObject(str);
                    String string = JSONObject.toJSONString(str);
                    Map<String, Class<?>> tags = listener.getConsumerConfig().getTags();
                    Class<?> messageClass = tags.get(msg.getTags());
                    listener.onMessage(JSON.parseObject(string,
                            messageClass), messageContext);
//                    listener.onMessage(msg,messageContext);
                } catch (Exception e) {
//                    listener.onMessage(new String(body, "UTF-8"), messageContext);
                    int retryTimes = listener.getConsumerConfig().getRetryTimes();
                    if(reconsumeTimes >= retryTimes){
                        log.info("第" + (reconsumeTimes + 1) + "次重试，不再重试");
                        return ConsumeStatus.SUCCESS;
                    }else {
                        log.info("重试第" + (reconsumeTimes + 1) + "次");
                        return ConsumeStatus.RETRY;
                    }
                }
                if (log.isDebugEnabled()) {
                    log.debug("消费完成");
                }
            }
        } catch (Exception e) {
            return handleException(e);
        }
        return ConsumeStatus.SUCCESS;
    }

    /**
     * 异常处理
     *
     * @param e 捕获的异常
     * @return 消息消费结果
     */
    private static ConsumeStatus handleException(final Exception e) {
        Class exceptionClass = e.getClass();
        if (exceptionClass.equals(UnsupportedEncodingException.class)) {
            log.error(e.getMessage());
        } else if (exceptionClass.equals(ConsumeException.class)) {
            log.error(e.getMessage());
        }
        return ConsumeStatus.RETRY;
    }


}

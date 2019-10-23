package org.rocketmq.starter.core.consumer;

import java.lang.reflect.Method;
import java.util.*;

/**
 *
 * @author He Jialin
 */
public class SubscriptionGroup {

    private String topic;

    private List<String> tagList;

    private Object target;

    private Map<String, Method> tagMethods;

    SubscriptionGroup(String topic) {
        this.tagList = new ArrayList<>();
        this.tagMethods = new HashMap<>();
        this.topic = topic;
    }

    public void putTagToGroup(String tag, Method method) {
        if (tagList.contains(tag)) {
            throw new IllegalArgumentException("重复的消费者");
        }
        tagList.add(tag);
        tagMethods.put(tag, method);
    }

    public Method getMethod(String tag) {
        return tagMethods.get(tag);
    }

    public Collection<Method> getAllMethods() {
        return tagMethods.values();
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public List<String> getTagList() {
        return tagList;
    }

    public void setTagList(List<String> tagList) {
        this.tagList = tagList;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Map<String, Method> getTagMethods() {
        return tagMethods;
    }

    public void setTagMethods(Map<String, Method> tagMethods) {
        this.tagMethods = tagMethods;
    }
}

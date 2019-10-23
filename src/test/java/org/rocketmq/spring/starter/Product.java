package org.rocketmq.spring.starter;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author helisen
 * @since 2019-09-29
 */
public class Product implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 基础商品ID
     */

    private Long productId;

    /**
     * 基础商品货号
     */
    private String productNo;

    /**
     * 基础商品名称
     */
    private String productName;

    /**
     * 品牌id
     */
    private String brandId;

    /**
     * 基础商品分类
     */
    private Long categoryId;

    /**
     * 制造商
     */
    private String manufacturer;

    /**
     * 制造商地址
     */
    private String manufacturerAddress;

    /**
     * 原厂地
     */
    private String goodsArea;

    /**
     * 是否扫码
     */
    private Boolean isScan;

    /**
     * 审核状态
     */
    private String auditStatus;

    /**
     * 是否启用
     */
    private Boolean isUsed;

    /**
     * 是否删除
     */
    private Boolean isDeleted;

    /**
     * 创建人
     */
    private String createdUser;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新人
     */
    private String updatedUser;

    /**
     * 更新时间
     */
    private Date updatedTime;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getManufacturerAddress() {
        return manufacturerAddress;
    }

    public void setManufacturerAddress(String manufacturerAddress) {
        this.manufacturerAddress = manufacturerAddress;
    }

    public String getGoodsArea() {
        return goodsArea;
    }

    public void setGoodsArea(String goodsArea) {
        this.goodsArea = goodsArea;
    }

    public Boolean getScan() {
        return isScan;
    }

    public void setScan(Boolean scan) {
        isScan = scan;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Boolean getUsed() {
        return isUsed;
    }

    public void setUsed(Boolean used) {
        isUsed = used;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getUpdatedUser() {
        return updatedUser;
    }

    public void setUpdatedUser(String updatedUser) {
        this.updatedUser = updatedUser;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}

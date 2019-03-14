package com.qq.weixin.xml.mp;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * 微信消息基类
 * 这些消息需要解析出来
 *
 * @author gong.hua
 * @see com.qq.weixin.xml.util.JAXBUtils#convertToJavaBean(String, Class)
 */
@Data
@XmlAccessorType(XmlAccessType.NONE)
public class BaseAcceptMsg {
    public static final String EVENT = "event";
    public static final String LINK = "link";
    public static final String LOCATION = "location";
    public static final String SHORT_VIDEO = "shortvideo";
    public static final String VIDEO = "video";
    public static final String VOICE = "voice";
    public static final String IMAGE = "image";
    public static final String TEXT = "text";
    /**
     * 开发者微信号
     */
    @XmlElement(name = "ToUserName")
    private String toUserName;

    /**
     * 发送方帐号（一个OpenID）
     */
    @XmlElement(name = "FromUserName")
    private String fromUserName;

    /**
     * 消息创建时间 （整型）
     */
    @XmlElement(name = "CreateTime")
    private Integer createTime;

    /**
     * 消息类型
     */
    @XmlElement(name = "MsgType")
    private String msgType;

    protected BaseAcceptMsg(String msgType) {
        this.msgType = msgType;
    }

}

package com.zing.netty.easychat.enums;

/**
 * 消息签收状态 枚举
 */
public enum MsgSignFlagEnum {

    UNSIGN(0, "未签收"),
    SIGNED(1, "已签收");

    public final Integer type;
    public final String content;

    MsgSignFlagEnum(Integer type, String content){
        this.type = type;
        this.content = content;
    }

    public Integer getType() {
        return type;
    }
}

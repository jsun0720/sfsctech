package com.sfsctech.common.core.base.ex.enums;

import com.sfsctech.common.core.base.enums.BaseEnum;

/**
 * Class ExceptionTypeEnum
 *
 * @author 张麒 2018-5-10.
 * @version Description:
 */
public enum ExceptionTypeEnum implements BaseEnum<Integer, String> {

    System(0, "系统"),
    Business(1, "业务"),
    Unknown(9, "未知");

    private Integer code;
    private String description;

    ExceptionTypeEnum(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    public static String getValueByKey(Integer key) {
        return BaseEnum.findValue(values(), key);
    }

    public static Integer getKeyByValue(String value) {
        return BaseEnum.findKey(values(), value);
    }
}

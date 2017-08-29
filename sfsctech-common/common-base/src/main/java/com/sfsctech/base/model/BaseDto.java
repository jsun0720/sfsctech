package com.sfsctech.base.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * Class BaseDto
 *
 * @author 张麒 2017/5/26.
 * @version Description:
 */
public abstract class BaseDto implements IBaseDto, Serializable {

    private static final long serialVersionUID = 8799994997210907041L;

    private String ServiceGuid;

    public String getServiceGuid() {
        return ServiceGuid;
    }

    public void setServiceGuid(String serviceGuid) {
        ServiceGuid = serviceGuid;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}

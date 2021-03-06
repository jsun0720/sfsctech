package com.sfsctech.core.base.domain.dto;

import com.sfsctech.core.base.json.FastJson;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * Class BaseDto
 *
 * @author 张麒 2017/5/26.
 * @version Description:
 */
public abstract class BaseDto implements IBaseDto, Serializable {

    private static final long serialVersionUID = 8799994997210907041L;

    @Override
    public String toString() {
        return (new ToStringBuilder(this)).append(FastJson.toJSONString(this)).toString();
    }
}

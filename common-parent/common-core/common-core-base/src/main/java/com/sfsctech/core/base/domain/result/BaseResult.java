package com.sfsctech.core.base.domain.result;

import com.sfsctech.core.base.constants.RpcConstants;
import com.sfsctech.core.base.domain.dto.BaseDto;
import com.sfsctech.core.base.enums.StatusEnum;
import org.apache.commons.lang3.ArrayUtils;

import java.util.*;

/**
 * Class BasicResult
 *
 * @author 张麒 2017/3/21.
 * @version Description:
 */
public class BaseResult extends BaseDto {

    private static final long serialVersionUID = -8243241537328556858L;
    /**
     * 响应状态
     */
    private boolean success = true;
    /**
     * 响应状态
     */
    protected StatusEnum<Integer, String> status = RpcConstants.Status.Successful;
    /**
     * 响应消息列表
     */
    private List<String> messages = new ArrayList<>();

    public BaseResult() {
    }

    public BaseResult(StatusEnum<Integer, String> status, String... messages) {
        this.success = status.getSuccessful();
        this.status = status;
        if (ArrayUtils.isNotEmpty(messages)) {
            addMessages(messages);
        }
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean hasErrors) {
        this.success = hasErrors;
    }

//    @JSONField(name = "statusCode")
//    public int getStatusCode() {
//        return status.getCode();
//    }
//
//    @JSONField(name = "statusCode")
//    public void setStatusCode(int code) {
//        this.status = BaseEnum.getByCode(this.status, code);
//    }

    //    @JSONField(deserialize = false)
    public StatusEnum<Integer, String> getStatus() {
        return status;
    }

    //    @JSONField(deserialize = false)
    public void setStatus(StatusEnum<Integer, String> status) {
        this.status = status;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public void addMessages(String... messages) {
        this.messages.addAll(Arrays.asList(messages));
    }

    /**
     * Attachment
     */
    private Map<String, Object> attachs;

    public void addAttach(String key, Object value) {
        if (null == this.attachs) {
            this.attachs = new HashMap<>();
        }
        this.attachs.put(key, value);
    }

    public void setAttachs(Map<String, Object> map) {
        this.attachs = map;
    }

    public Map<String, Object> getAttachs() {
        return this.attachs;
    }

}

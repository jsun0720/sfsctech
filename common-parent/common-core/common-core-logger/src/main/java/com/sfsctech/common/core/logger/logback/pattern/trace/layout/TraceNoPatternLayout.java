package com.sfsctech.common.core.logger.logback.pattern.trace.layout;

import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.spi.ILoggingEvent;
import com.sfsctech.common.core.base.constants.LabelConstants;
import com.sfsctech.common.core.logger.logback.pattern.converter.TraceConverter;
import com.sfsctech.common.core.logger.util.TraceNoUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.logging.logback.ColorConverter;

/**
 * Class TraceNoPatternLayout
 *
 * @author 张麒 2017/6/8.
 * @version Description:
 */
// TODO 迁移至dubbox
public class TraceNoPatternLayout extends PatternLayout {

    static {
        defaultConverterMap.put("trace", TraceConverter.class.getName());
        defaultConverterMap.put("clr", ColorConverter.class.getName());
    }

    // TODO 字符串替换性能优化
    @Override
    public String doLayout(ILoggingEvent event) {
        String msg = super.doLayout(event);
        if (msg != null && event.getThrowableProxy() != null && TraceNoUtil.getTraceNo() != null) {
            // 有异常信息的，每行都打印跟踪号
            if (msg.endsWith(LabelConstants.NEW_LINE)) {
                msg = StringUtils.replace(msg.substring(0, msg.length() - 1), LabelConstants.NEW_LINE, (LabelConstants.NEW_LINE + LabelConstants.OPEN_BRACKET + TraceNoUtil.getTraceNo() + LabelConstants.CLOSE_BRACKET + LabelConstants.TAB)) + LabelConstants.NEW_LINE;
            } else {
                msg = StringUtils.replace(msg, LabelConstants.NEW_LINE, (LabelConstants.NEW_LINE + LabelConstants.OPEN_BRACKET + TraceNoUtil.getTraceNo() + LabelConstants.CLOSE_BRACKET + LabelConstants.TAB));
            }
        }
        return msg;
    }
}

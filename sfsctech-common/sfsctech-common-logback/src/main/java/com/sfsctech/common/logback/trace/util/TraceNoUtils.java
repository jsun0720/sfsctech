package com.sfsctech.common.logback.trace.util;

import com.alibaba.dubbo.rpc.proxy.TraceIdUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;

import java.util.UUID;

/**
 * Class TraceNoUtils
 *
 * @author 张麒 2017/6/8.
 * @version Description:
 */
public class TraceNoUtils {

    /**
     * 产生新的traceNo,并放到MDC中
     */
    public static void newTraceNo() {
        TraceIdUtil.setTraceId(RandomStringUtils.randomAlphanumeric(12));
//        MDC.put("traceNo", RandomStringUtils.randomAlphanumeric(12));
    }

    /**
     * 产生新的traceNo,并放到MDC中<br>
     * parentTranceNo-newTraceNo
     */
    public static void newTraceNo(String parentTranceNo) {
        if (StringUtils.isNotEmpty(parentTranceNo)) {
            MDC.put("traceNo", parentTranceNo + "-" + RandomStringUtils.randomAlphanumeric(6));
        } else {
            newTraceNo();
        }
    }

    /**
     * 获得MDC中的traceNo
     *
     * @return
     */
    public static String getTraceNo() {
        return TraceIdUtil.getTraceId();
//        MDC.get("traceNo");
    }

    /**
     * 清除MDC中的traceNo
     */
    public static void clearTraceNo() {
//        MDC.remove("traceNo");
    }
}

package com.sfsctech.dubbo.base.filter;

import com.alibaba.dubbo.rpc.*;
import com.sfsctech.dubbo.base.hystrix.DubboHystrixCommand;

/**
 * Class HystrixFilter
 *
 * @author 张麒 2018-3-1.
 * @version Description:
 */
public class HystrixFilter implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        DubboHystrixCommand command = new DubboHystrixCommand(invoker, invocation);
        return command.execute();
    }
}

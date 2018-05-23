package com.sfsctech.dubbo.base.serialize;

import com.alibaba.dubbo.common.serialize.support.SerializationOptimizer;
import com.sfsctech.core.base.constants.RpcConstants;
import com.sfsctech.core.base.jwt.JwtToken;
import com.sfsctech.core.base.session.UserAuthData;
import com.sfsctech.core.exception.ex.*;
import com.sfsctech.core.rpc.result.ActionResult;
import com.sfsctech.dubbo.base.constants.DubboConstants;
import com.sfsctech.support.common.util.ClassUtil;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;


/**
 * Class KryoSerializationOptimizer
 *
 * @author 张麒 2017/5/22.
 * @version Description:
 */
public class KryoSerializationOptimizer implements SerializationOptimizer {

    private Set<Class> classes = new LinkedHashSet<>();

    public KryoSerializationOptimizer() {
        classes.addAll(ClassUtil.getClasses(DubboConstants.BASE_KRYO_SERIALIZE_PATH));
        classes.add(VerifyException.class);
        classes.add(RpcException.class);
        classes.add(BizException.class);
        classes.add(RpcConstants.class);
        classes.add(RpcConstants.Status.class);
        classes.add(UserAuthData.class);
        classes.add(ActionResult.class);
        classes.add(JwtToken.class);
        classes.addAll(ClassUtil.getClassesByEndsWith(DubboConstants.KRYO_SERIALIZE_PATH, "dto"));
    }

    @Override
    public Collection<Class> getSerializableClasses() {
        return classes;
    }

}

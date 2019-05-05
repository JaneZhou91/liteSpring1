package org.litespring.aop;

import org.aopalliance.intercept.MethodInterceptor;

/**
 * Created by qingge on 2019/4/29.
 */
public interface Advice extends MethodInterceptor {
    Pointcut getPointcut();
}

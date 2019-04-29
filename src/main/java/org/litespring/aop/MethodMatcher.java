package org.litespring.aop;

import java.lang.reflect.Method;

/**
 * Created by qingge on 2019/4/29.
 */
public interface MethodMatcher {
    boolean matches(Method method/*, Class<?> targetClass*/);
}

package org.litespring.aop;

/**
 * Created by qingge on 2019/4/29.
 */
public interface Pointcut {
    MethodMatcher getMethodMatcher();
    String getExpression();
}

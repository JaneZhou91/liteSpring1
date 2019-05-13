package org.litespring.aop.aspectj;

import org.litespring.aop.Advice;
import org.litespring.aop.Pointcut;
import org.litespring.aop.config.AspectInstanceFactory;

import java.lang.reflect.Method;

/**
 * Created by qingge on 2019/4/29.
 */
public abstract class AbstractAspectJAdvice implements Advice {
    protected Method adviceMethod;
    protected AspectJExpressionPointcut pointcut;
//    protected Object adviceObject;
    protected AspectInstanceFactory adviceObjectFactory;

    public AbstractAspectJAdvice(Method adviceMethod,
                                 AspectJExpressionPointcut pointcut,
                                 AspectInstanceFactory adviceObjectFactory){

        this.adviceMethod = adviceMethod;
        this.pointcut = pointcut;
        this.adviceObjectFactory = adviceObjectFactory;
    }

    public void invokeAdviceMethod() throws Throwable{
        adviceMethod.invoke(adviceObjectFactory.getAspectInstance());
    }

    public Pointcut getPointcut(){
        return this.pointcut;
    }

    public Method getAdviceMethod() {
        return adviceMethod;
    }

    public Object getAdviceInstance() throws Exception {
        return adviceObjectFactory.getAspectInstance();
    }
}

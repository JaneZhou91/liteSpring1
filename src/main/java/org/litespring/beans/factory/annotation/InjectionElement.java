package org.litespring.beans.factory.annotation;

import org.litespring.beans.factory.config.AutowireCapableBeanFactory;

import java.lang.reflect.Member;

/**
 * Created by qingge on 2019/4/27.
 */
public abstract class InjectionElement {
    protected Member member;
    protected AutowireCapableBeanFactory factory;
    InjectionElement(Member member,AutowireCapableBeanFactory factory){
        this.member = member;
        this.factory = factory;
    }

    public abstract void inject(Object target);
}


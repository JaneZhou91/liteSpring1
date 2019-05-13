package org.litespring.beans.factory;

/**
 * Created by qingge on 2019/5/5.
 */
public interface FactoryBean<T> {

    T getObject() throws Exception;

    Class<?> getObjectType();
}


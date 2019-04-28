package org.litespring.beans.factory.config;

import org.litespring.beans.BeansException;

/**
 * Created by qingge on 2019/4/28.
 */
public interface BeanPostProcessor {
    Object beforeInitialization(Object bean, String beanName) throws BeansException;

    Object afterInitialization(Object bean, String beanName) throws BeansException;

}

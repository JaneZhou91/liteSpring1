package org.litespring.beans.factory;

import org.litespring.aop.Advice;
import org.litespring.beans.NoSuchBeanDefinitionException;

import java.util.List;

public interface BeanFactory {
    Object getBean(String petStore);

    Class<?> getType(String name) throws NoSuchBeanDefinitionException;

    List<Object> getBeansByType(Class<?> type);
}

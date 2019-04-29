package org.litespring.beans.factory;

import org.litespring.beans.NoSuchBeanDefinitionException;

public interface BeanFactory {
    Object getBean(String petStore);

    Class<?> getType(String name) throws NoSuchBeanDefinitionException;
}

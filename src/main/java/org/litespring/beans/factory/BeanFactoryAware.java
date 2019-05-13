package org.litespring.beans.factory;

import org.litespring.beans.BeansException;

/**
 * Created by qingge on 2019/5/5.
 */
public interface BeanFactoryAware {

    void setBeanFactory(BeanFactory beanFactory) throws BeansException;

}

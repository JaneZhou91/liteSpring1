package org.litespring.beans.factory.config;

import org.litespring.beans.factory.BeanFactory;

/**
 * Created by qingge on 2019/4/27.
 */
public interface AutowireCapableBeanFactory extends BeanFactory {
    Object resolveDependency(DependencyDescriptor descriptor);
}

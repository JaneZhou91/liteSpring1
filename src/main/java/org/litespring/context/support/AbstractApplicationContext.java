package org.litespring.context.support;

import org.litespring.aop.aspectj.AspectJAutoProxyCreator;
import org.litespring.beans.NoSuchBeanDefinitionException;
import org.litespring.beans.factory.annotation.AutowiredAnnotationProcessor;
import org.litespring.beans.factory.config.ConfigurableBeanFactory;
import org.litespring.beans.factory.support.DefaultBeanFactory;
import org.litespring.beans.factory.xml.XmlBeanDefinitionReader;
import org.litespring.context.ApplicationContext;
import org.litespring.core.io.Resource;
import org.litespring.util.ClassUtils;

import java.util.List;

public abstract class AbstractApplicationContext implements ApplicationContext {
    private DefaultBeanFactory defaultBeanFactory;
    private ClassLoader beanClassLoader;

    public AbstractApplicationContext(String configFile) {
        defaultBeanFactory = new DefaultBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(defaultBeanFactory);
        Resource resource = this.getResourceByPath(configFile);
        reader.loadBeanDefinition(resource);
        defaultBeanFactory.setBeanClassLoader(this.getBeanClassLoader());
        registerBeanPostProcessors(defaultBeanFactory);

    }

    protected abstract Resource getResourceByPath(String configFile);

    public Object getBean(String beanId) {
        return defaultBeanFactory.getBean(beanId);
    }

    public void setBeanClassLoader(ClassLoader beanClassLoader) {
        this.beanClassLoader = beanClassLoader;
    }

    public ClassLoader getBeanClassLoader() {
        return this.beanClassLoader != null ? this.beanClassLoader : ClassUtils.getDefaultClassLoader();
    }

    protected void registerBeanPostProcessors(ConfigurableBeanFactory beanFactory) {
        {
            AutowiredAnnotationProcessor postProcessor = new AutowiredAnnotationProcessor();
            postProcessor.setBeanFactory(beanFactory);
            beanFactory.addBeanPostProcessor(postProcessor);
        }
        {
            AspectJAutoProxyCreator postProcessor = new AspectJAutoProxyCreator();
            postProcessor.setBeanFactory(beanFactory);
            beanFactory.addBeanPostProcessor(postProcessor);
        }
    }

    public Class<?> getType(String name) throws NoSuchBeanDefinitionException {
        return this.defaultBeanFactory.getType(name);
    }

    @Override
    public List<Object> getBeansByType(Class<?> type){
        return this.defaultBeanFactory.getBeansByType(type);
    }
}

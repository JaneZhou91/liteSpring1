package org.litespring.test.v1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.litespring.beans.BeanDefinition;
import org.litespring.beans.factory.BeanCreationException;
import org.litespring.beans.factory.BeanDefinitionStoreException;
import org.litespring.beans.factory.support.DefaultBeanFactory;
import org.litespring.beans.factory.xml.XmlBeanDefinitionReader;
import org.litespring.service.v1.PetStoreService;

public class BeanFactoryTest {
    private DefaultBeanFactory beanFactory;
    private XmlBeanDefinitionReader reader;

    @Before
    public void setUp() {
        beanFactory = new DefaultBeanFactory();
        reader = new XmlBeanDefinitionReader(beanFactory);
    }
    @Test
    public void testGetBean() {
        reader.loadBeanDefinition("petstore-v1.xml");

        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("petStore");

        Assert.assertEquals("org.litespring.service.v1.PetStoreService",
                beanDefinition.getBeanClassName());
        PetStoreService petStoreService = (PetStoreService)beanFactory.getBean("petStore");
        Assert.assertNotNull(petStoreService);
    }

    @Test
    public void testInvalidBean() {
        reader.loadBeanDefinition("petstore-v1.xml");
        try {
            beanFactory.getBean("invalidBean");
        } catch (BeanCreationException e) {
            return;
        }

        Assert.fail("except BeanCreationException");
    }

    @Test
    public void testInvalidXML() {
        try {
            reader.loadBeanDefinition("xxx.xml");
        } catch (BeanDefinitionStoreException e) {
            return;
        }
        Assert.fail("except BeanDefinitionStoreException");
    }
}

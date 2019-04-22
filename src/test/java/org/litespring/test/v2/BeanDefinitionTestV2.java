package org.litespring.test.v2;

import org.junit.Assert;
import org.junit.Test;
import org.litespring.beans.BeanDefinition;
import org.litespring.beans.PropertyValue;
import org.litespring.beans.factory.config.RuntimeBeanReference;
import org.litespring.beans.factory.support.DefaultBeanFactory;
import org.litespring.beans.factory.xml.XmlBeanDefinitionReader;
import org.litespring.core.io.ClassPathResource;

import java.util.List;

public class BeanDefinitionTestV2 {

    @Test
    public void testGetDeanDefinition() {
        DefaultBeanFactory beanFactory = new DefaultBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinition(new ClassPathResource("petstore-v2.xml"));

        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("petStore");
        List<PropertyValue> propertyValueList = beanDefinition.getPropertyValues();
        Assert.assertTrue(propertyValueList.size() == 4);

        {
            PropertyValue pv = this.getPropertyValue("accountDao", propertyValueList);
            Assert.assertNotNull(pv);
            Assert.assertTrue(pv.getValue() instanceof RuntimeBeanReference);
        }

        {
            PropertyValue pv = this.getPropertyValue("itemDao", propertyValueList);
            Assert.assertNotNull(pv);
            Assert.assertTrue(pv.getValue() instanceof RuntimeBeanReference);
        }

    }

    private PropertyValue getPropertyValue(String name, List<PropertyValue> propertyValueList) {
        for (PropertyValue propertyValue : propertyValueList) {
            if (propertyValue.getName().equals(name)) {
                return propertyValue;
            }
        }
        return null;
    }
}

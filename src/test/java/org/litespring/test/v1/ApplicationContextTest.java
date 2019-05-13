package org.litespring.test.v1;

import org.junit.Assert;
import org.junit.Test;
import org.litespring.context.ApplicationContext;
import org.litespring.context.support.ClassPathXmlApplicationContext;
import org.litespring.context.support.FileSystemXmlApplicationContext;
import org.litespring.service.v1.PetStoreService;

public class ApplicationContextTest {
    @Test
    public void ClassPathXmlApplicationContextGetBean() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("petstore-v1.xml");
        PetStoreService petStoreService = (PetStoreService) applicationContext.getBean("petStore");
        Assert.assertNotNull(petStoreService);
    }

//    @Test
//    public void getBean() {
//        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("D:\\petstore-v1.xml");
//        PetStoreService petStoreService = (PetStoreService) applicationContext.getBean("petStore");
//        Assert.assertNotNull(petStoreService);
//    }
}

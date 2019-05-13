package org.litespring.test.v4;

import org.junit.Assert;
import org.junit.Test;
import org.litespring.context.ApplicationContext;
import org.litespring.context.support.ClassPathXmlApplicationContext;
import org.litespring.dao.v4.AccountDao;
import org.litespring.dao.v4.ItemDao;
import org.litespring.service.v4.PetStoreService;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by qingge on 2019/4/23.
 */
public class ApplicationContextTest4 {

    @Test
    public void testGetBeanProperty() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("petstore-v4.xml");
        PetStoreService petStore = (PetStoreService)ctx.getBean("petStore");

        Assert.assertNotNull(petStore.getAccountDao());
        Assert.assertNotNull(petStore.getItemDao());

        assertTrue(petStore.getAccountDao() instanceof AccountDao);
        assertTrue(petStore.getItemDao() instanceof ItemDao);

    }
}


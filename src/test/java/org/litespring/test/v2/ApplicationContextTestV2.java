package org.litespring.test.v2;

import org.junit.Assert;
import org.junit.Test;
import org.litespring.context.ApplicationContext;
import org.litespring.context.support.ClassPathXmlApplicationContext;
import org.litespring.dao.v2.AccountDao;
import org.litespring.dao.v2.ItemDao;
import org.litespring.service.v2.PetStoreService;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class ApplicationContextTestV2 {

    @Test
    public void testGetProperty() {
        ApplicationContext context = new ClassPathXmlApplicationContext("petstore-v2.xml");
        PetStoreService petStoreService = (PetStoreService) context.getBean("petStore");

        Assert.assertNotNull(petStoreService.getAccountDao());
        Assert.assertNotNull(petStoreService.getItemDao());

        assertTrue(petStoreService.getAccountDao() instanceof AccountDao);
        assertTrue(petStoreService.getItemDao() instanceof ItemDao);
        assertEquals("JaneZhou", petStoreService.getOwner());
        assertEquals(2, petStoreService.getVersion());
    }

}

package org.litespring.test.v5;

import org.junit.Test;
import org.litespring.tx.TransactionManager;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by qingge on 2019/4/30.
 */
public class InvokeTest {
    @Test
    public void testInvoke() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        TransactionManager tx = new TransactionManager();
        Method start = TransactionManager.class.getMethod("start");

        start.invoke(tx);
    }
}

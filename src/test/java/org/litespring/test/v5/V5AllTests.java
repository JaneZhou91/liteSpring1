package org.litespring.test.v5;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by qingge on 2019/5/19.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ ApplicationContextTest5.class, CglibAopProxyTest.class, CGLibTest.class,
        MethodLocatingFactoryTest.class, PointcutTest.class, ReflectiveMethodInvocationTest.class })
public class V5AllTests {

}

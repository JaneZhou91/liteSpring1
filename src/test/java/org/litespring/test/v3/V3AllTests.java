package org.litespring.test.v3;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by qingge on 2019/4/22.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ ApplicationContextTestV3.class, BeanDefinitionTestV3.class, ConstructorResolverTest.class })
public class V3AllTests {

}
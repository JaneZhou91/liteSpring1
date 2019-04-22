package org.litespring.test.v2;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by qingge on 2019/4/21.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ ApplicationContextTestV2.class, BeanDefinitionTestV2.class, BeanDefinitionValueResolverTest.class,
        CustomBooleanEditorTest.class, CustomNumberEditorTest.class, TypeConverterTest.class })
public class V2AllTests {

}

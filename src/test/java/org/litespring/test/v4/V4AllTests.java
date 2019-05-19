package org.litespring.test.v4;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by qingge on 2019/5/19.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ ApplicationContextTest4.class, AutowiredAnnotationProcessorTest.class,
        ClassPathBeanDefinitionScannerTest.class, ClassReaderTest.class, DependencyDescriptorTest.class,
        InjectionMetadataTest.class, MetadataReaderTest.class, PackageResourceLoaderTest.class,
        XmlBeanDefinitionReaderTest.class })
public class V4AllTests {

}

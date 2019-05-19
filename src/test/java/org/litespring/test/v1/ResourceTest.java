package org.litespring.test.v1;


import org.junit.Assert;
import org.junit.Test;
import org.litespring.core.io.ClassPathResource;
import org.litespring.core.io.FileSystemResource;
import org.litespring.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;

public class ResourceTest {

    @Test
    public void testClassPathResource() {
        Resource resource = new ClassPathResource("petstore-v1.xml");
        InputStream inputStream = null;
        try {
            inputStream = resource.getInputStream();
            Assert.assertNotNull(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

//    @Test
    public void testFileSystemResource() {
        Resource resource = new FileSystemResource("d:\\petstore-v1.xml");
        InputStream inputStream = null;
        try {
            inputStream = resource.getInputStream();
            Assert.assertNotNull(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

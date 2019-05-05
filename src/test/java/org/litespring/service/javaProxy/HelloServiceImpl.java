package org.litespring.service.javaProxy;


/**
 * Created by qingge on 2019/5/4.
 */
public class HelloServiceImpl implements HelloService {
    public void sayHello(String name) {
        System.out.println("hello: " + name);
    }
}

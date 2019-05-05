package org.litespring.service.javaProxy;

/**
 * Created by qingge on 2019/5/4.
 */
public class ProxyTest {

    public static void main(String[] args) {
        HelloServiceProxy proxy = new HelloServiceProxy();
        HelloService service = new HelloServiceImpl();
        //绑定代理对象。
        service = (HelloService) proxy.bind(service, new Class[] {HelloService.class});
        //这里service经过绑定，就会进入invoke方法里面了。
        service.sayHello("张三");
    }
}

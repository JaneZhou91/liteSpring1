package org.litespring.service.cglib;

/**
 * Created by qingge on 2019/5/4.
 */
public class TargetObject {
    public void method1(String paramName) {
        System.out.println("method1: " + paramName);
    }

    public void method2(int count) {
        System.out.println("method2: " + count);
    }

    public void method3(int count) {
        System.out.println("method3: " + count);
    }

    @Override
    public String toString() {
        return "TargetObject []"+ getClass();
    }
}

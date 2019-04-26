package org.litespring.service.visitor;

/**
 * Created by qingge on 2019/4/23.
 */
public class ConcreteElementA extends Element {
    @Override
    void accept(Visitor visitor) {
        visitor.visitElementA(this);
    }

    public void operationA() {
        System.out.println("ConcreteElementA operationA...");
    }
}

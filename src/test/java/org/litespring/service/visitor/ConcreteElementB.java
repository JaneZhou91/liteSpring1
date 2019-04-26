package org.litespring.service.visitor;

/**
 * Created by qingge on 2019/4/23.
 */
public class ConcreteElementB extends Element {
    @Override
    void accept(Visitor visitor) {
        visitor.visitElementB(this);
    }

    public void operationB() {
        System.out.println("ConcreteElementB operationB...");
    }
}

package org.litespring.service.visitor;

/**
 * Created by qingge on 2019/4/23.
 */
public class ConcreteVisitor2 extends Visitor {

    @Override
    void visitElementA(ConcreteElementA concreteElementA) {
        System.out.println(concreteElementA.getClass().getName() + "被" + this.getClass().getName() + "访问");
        concreteElementA.operationA();
    }

    @Override
    void visitElementB(ConcreteElementB concreteElementB) {
        System.out.println(concreteElementB.getClass().getName() + "被" + this.getClass().getName() + "访问");
        concreteElementB.operationB();
    }
}

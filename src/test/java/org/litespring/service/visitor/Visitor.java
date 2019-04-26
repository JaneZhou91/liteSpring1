package org.litespring.service.visitor;

/**
 * Created by qingge on 2019/4/23.
 */
public abstract class Visitor {
    abstract void visitElementA(ConcreteElementA concreteElementA);
    abstract void visitElementB(ConcreteElementB concreteElementB);
}

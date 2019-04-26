package org.litespring.service.visitor;

/**
 * Created by qingge on 2019/4/23.
 */
public abstract class Element {
    abstract void accept(Visitor visitor);

}

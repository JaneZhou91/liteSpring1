package org.litespring.service.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qingge on 2019/4/23.
 */
public class ObjectStructure {
    private List<Element> elementList = new ArrayList<>();

    public void attach(Element element) {
        elementList.add(element);
    }

    public void detach(Element element) {
        elementList.remove(element);
    }

    public void accept(Visitor visitor) {
        for (Element element : elementList) {
            element.accept(visitor);
        }
    }
}

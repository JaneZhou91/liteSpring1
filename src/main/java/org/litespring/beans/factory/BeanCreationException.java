package org.litespring.beans.factory;

import org.litespring.beans.BeansException;

public class BeanCreationException extends BeansException {
    public BeanCreationException(String msg) {
        super(msg);
    }
    public BeanCreationException(String msg, String s, Throwable cause) {
        super(msg, cause);
    }

    public BeanCreationException(String s, Exception e) {
        super(s);
    }
}

package org.litespring.beans;

/**
 * Created by qingge on 2019/4/21.
 */
public interface TypeConverter {
    <T> T convertIfNecessary(Object value, Class<T> requiredType) throws TypeMismatchException;
}


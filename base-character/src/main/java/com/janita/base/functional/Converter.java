package com.janita.base.functional;


@FunctionalInterface
public interface Converter<F, T> {

    T convert(F from);
}

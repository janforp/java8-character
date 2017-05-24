package com.janita.functional;


@FunctionalInterface
public interface Converter<F, T> {

    T convert (F from);
}

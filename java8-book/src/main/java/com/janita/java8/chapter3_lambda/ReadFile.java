package com.janita.java8.chapter3_lambda;

import java.io.BufferedReader;

/**
 * Created by Janita on 2017-05-30 16:15
 */
@FunctionalInterface
public interface ReadFile {

    String read(BufferedReader reader);
}

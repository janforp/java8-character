package com.janita.java8.chapter5_stream.trader;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by Janita on 2017-06-01 20:09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Trader {

    private  String name;

    private  String city;
}

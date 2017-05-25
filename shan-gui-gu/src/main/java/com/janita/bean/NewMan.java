package com.janita.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Optional;

/**
 * Created by Janita on 2017-05-25 17:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NewMan {

    //一般这么用
    private Optional<Goddess> goddess = Optional.empty() ;
}

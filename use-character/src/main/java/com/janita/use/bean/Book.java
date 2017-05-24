package com.janita.use.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by Janita on 2017-05-24 18:10
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private Long bookId;

    private String title;
}

package com.janita.use.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by Janita on 2017-05-24 17:21
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Author {

    private Long authorId;

    private String authorName;

    private String publisher;
}

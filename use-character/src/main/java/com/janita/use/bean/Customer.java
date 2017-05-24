package com.janita.use.bean;

import lombok.*;

/**
 * Created by Janita on 2017-05-24 16:54
 */
@Data
@ToString
@EqualsAndHashCode(exclude = {"customName","address","gender"})
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    private Long customerId;

    private String customName;

    private String address;

    private Integer gender;
}

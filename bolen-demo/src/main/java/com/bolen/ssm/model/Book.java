package com.bolen.ssm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private Integer id;

    private String name;

    private BigDecimal price;

    private Long isbn;

    private Date date;
}
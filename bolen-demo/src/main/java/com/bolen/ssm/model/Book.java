package com.bolen.ssm.model;

import edu.umd.cs.findbugs.annotations.DefaultAnnotation;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
public class Book {
    
    private Integer id;
    
    private String name;
    
    private BigDecimal price;
    
    private Long isbn;
    
    private Date date;
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public BigDecimal getPrice() {
        return price;
    }
    
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
    public Long getIsbn() {
        return isbn;
    }
    
    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }
    
    public Date getDate() {
        return date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
}
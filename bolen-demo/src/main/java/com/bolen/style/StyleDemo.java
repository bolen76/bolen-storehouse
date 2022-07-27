package com.bolen.style;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class StyleDemo<E, C> {
    
    private C c;
    
    private String name;
    
    private final int age = 18;
    
    public static String weight;
    
    public static final String LOVE_LANGUAGE = "hello world";
    
    @Autowired
    private List<?> list;
    
    public static String smethod(String name) {
        weight = name;
        return name;
    }
    
    /**
     * 多行注释
     *
     * @param t     入参
     * @param param
     * @param <T>   泛型参数
     * @return 返回值
     * @throws RuntimeException 异常
     */
    public <T> T get(T t, String param) throws RuntimeException {
        int a = 10;//单行注释
        /*
         *多行注释
         */
        String hel = "c++";
        List<String> list = new ArrayList<>();
        List<String> other = new ArrayList<>();
        list.stream().forEach(item -> {
            other.add(item);
        });
        weight = "hello";
        smethod("helo");
        this.name = "java";
        return t;
    }
    
    public void set() {
        get(null, null);
    }
    
}

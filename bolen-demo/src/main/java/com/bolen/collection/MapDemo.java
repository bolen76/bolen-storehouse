package com.bolen.collection;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class MapDemo {
	
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		int num=1000;
	/*	Map map=new HashMap<>();
		for(int i=0;i<num;i++){
			map.put(i, i);
		}
		map.put("a", "b");
		Field field = HashMap.class.getDeclaredField("table");
		field.setAccessible(true);
		Object [] table = (Object[]) field.get(map);
		System.out.println(table.length);*/
		
		
		Map  conmap=new ConcurrentHashMap();
		Field confield = ConcurrentHashMap.class.getDeclaredField("table");
		confield.setAccessible(true);
		for(int i=0;i<num;i++){
			conmap.put(i, i);
		}
		Object [] contable = (Object[]) confield.get(conmap);
		System.out.println(contable.length);
		
		
	}
}

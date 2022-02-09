package com.ihrm.common.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ihrm.common.entity.PageResult;
import org.apache.poi.ss.formula.functions.T;

public class BeanConvert {

	public static <T> T convertValue(Object data, Class clazz) {
		ObjectMapper mapper = new ObjectMapper();
		T userBean = mapper.convertValue(data, (Class<T>) clazz);
		return userBean;
	}
}

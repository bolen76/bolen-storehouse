package com.bolen.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolen.ssm.mapper.UpmsUserMapper;
import com.bolen.ssm.model.UpmsUser;
import com.bolen.ssm.service.UpmsUserService;

@Service
public class UpmsUserServiceImpl implements UpmsUserService{
	
	public UpmsUserServiceImpl() {
		super();
		//this.upmsUserMapper = upmsUserMapper;
		System.out.println("hello world ...UpmsUserServiceImpl");
	}
	@Autowired
	UpmsUserMapper upmsUserMapper;
	@Override
	public UpmsUser findUserById(Integer userId) {
		UpmsUser upmsUser = upmsUserMapper.selectByPrimaryKey(userId);
		return upmsUser;
	}

}

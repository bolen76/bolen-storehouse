package bolen.frame.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bolen.frame.mapper.UpmsUserMapper;
import bolen.frame.model.UpmsUser;
import bolen.frame.service.UpmsUserService;

@Service
public class UpmsUserServiceImpl implements UpmsUserService{
	@Autowired
	UpmsUserMapper upmsUserMapper;
	@Override
	public UpmsUser findUserById(Integer userId) {
		UpmsUser upmsUser = upmsUserMapper.selectByPrimaryKey(userId);
		return upmsUser;
	}

}

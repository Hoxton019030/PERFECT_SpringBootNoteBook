package com.jerryboot.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jerryboot.springbootdemo.model.WorkMessages;
import com.jerryboot.springbootdemo.model.WorkMessagesDao;

@Service
public class WorkMessagesService {
	
	@Autowired
	private WorkMessagesDao dao;
	
	public void save(WorkMessages msg) {
		dao.save(msg);
	}

}

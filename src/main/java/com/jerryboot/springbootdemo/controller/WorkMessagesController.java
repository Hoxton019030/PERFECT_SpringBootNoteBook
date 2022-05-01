package com.jerryboot.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jerryboot.springbootdemo.model.WorkMessages;
import com.jerryboot.springbootdemo.service.WorkMessagesService;

@Controller
public class WorkMessagesController {

	@Autowired
	private WorkMessagesService service;

	@GetMapping("/message/add") // 有用ModelAndView的話，ModelAndView的參數要寫在第一個
	public ModelAndView goAddMessage(ModelAndView mav) {

		WorkMessages msg = new WorkMessages();
		// 之前的ModelAttribute("名字",物件)
		mav.getModel().put("workMessages", msg);

		mav.setViewName("addMessage");

		return mav;
	}

	@PostMapping("/message/add")
	public ModelAndView postMessage(ModelAndView mav, @ModelAttribute(name = "workMessages") WorkMessages msg) {
		service.save(msg);
		WorkMessages newMsg = new WorkMessages();
		mav.getModel().put("workMessages", newMsg);
		mav.setViewName("addMessage");
		return mav;

	}
}

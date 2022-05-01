package com.jerryboot.springbootdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;


public class PageController{
	
	@GetMapping(name="/")
	public String index() {
		return "index";
	}
}
//@Controller
//public class PageController {
//
//	@GetMapping("/")
//	public String index() {
//		return "index";
//	}
//	@GetMapping("/about")
//	public String gotoAbout() {
//		return "about";
//	}
//
//}

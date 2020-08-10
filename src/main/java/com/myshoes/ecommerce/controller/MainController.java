package com.myshoes.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	@RequestMapping("/")
	@ResponseBody
	public String index() {
		String response = "Buenvenido a My Shoes Api";
		return response;
	}
	
}

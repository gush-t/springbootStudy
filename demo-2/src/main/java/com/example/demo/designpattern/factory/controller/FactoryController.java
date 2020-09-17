package com.example.demo.designpattern.factory.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.util.CaculatorUtil;

@RestController
public class FactoryController {

	@RequestMapping("/caculator")
	@ResponseBody
	public Double caculatorNumber(@RequestParam("firstNub") Double firstNub,@RequestParam("secondNub") Double secondNub
			,@RequestParam("operate") String operate) {
		Double result = CaculatorUtil.caculator(firstNub, secondNub, operate);
		
		return result;		
	}
}

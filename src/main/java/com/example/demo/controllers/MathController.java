package com.example.demo.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.MathResult;
import com.example.demo.service.MathService;


@RestController
@RequestMapping("/math")
public class MathController {
	
	private final MathService mathService;
	
	public MathController(MathService mathService) {
		this.mathService = mathService;
	}
	
	@RequestMapping("/sum/{one}/{two}")
	public MathResult sum(
						@PathVariable("one") String one,
						@PathVariable("two") String two){
		return mathService.sum(one, two);
	}
	
}

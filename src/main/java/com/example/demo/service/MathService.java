package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.utils.NumberUtils;
import com.example.demo.exception.UnsupportedMathException;
import com.example.demo.model.MathResult;

@Service
public class MathService {
	
	public MathResult sum(String one,String two){
			if(!NumberUtils.isValidNumeric(one) || !NumberUtils.isValidNumeric(two) ) {
				throw new UnsupportedMathException("Use um valor numérico!");
			}	
			return new MathResult(NumberUtils.convertToDouble(one) + NumberUtils.convertToDouble(two));
	}

}

package com.colutti.restfulSpring.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.colutti.restfulSpring.converters.NumberConverter;
import com.colutti.restfulSpring.exception.UnsuportedMathOperationException;
import com.colutti.restfulSpring.math.SimpleMath;

@RestController
public class MathController {
	
	NumberConverter number = new NumberConverter();
	SimpleMath math = new SimpleMath();
	
	@RequestMapping(value="/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!number.IsNumeric(numberOne) || !number.IsNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please, set a numeric value");
		}
		
		return math.sum(number.convertToDouble(numberOne), number.convertToDouble(numberTwo));
		
	}
	
	
	@RequestMapping(value="/subtraction/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double subtraction(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!number.IsNumeric(numberOne) || !number.IsNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please, set a numeric value");
		}
		
		return math.subtraction(number.convertToDouble(numberOne), number.convertToDouble(numberTwo));
		
	}
	
	@RequestMapping(value="/multiplication/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double multiplication(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!number.IsNumeric(numberOne) || !number.IsNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please, set a numeric value");
		}
		
		return math.multiplication(number.convertToDouble(numberOne), number.convertToDouble(numberTwo));
		
	}
	
	@RequestMapping(value="/division/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!number.IsNumeric(numberOne) || !number.IsNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please, set a numeric value");
		}
		
		return math.division(number.convertToDouble(numberOne), number.convertToDouble(numberTwo));
		
	}
	
	@RequestMapping(value="/mean/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double mean(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!number.IsNumeric(numberOne) || !number.IsNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please, set a numeric value");
		}
		
		return math.mean(number.convertToDouble(numberOne), number.convertToDouble(numberTwo));
		
	}
	
}

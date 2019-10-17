package com.brightflag.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brightflag.domain.Result;
import com.brightflag.service.ResultService;

@RestController
public class ResultAPIController {

	@Autowired
	ResultService resultService;

	@RequestMapping("api/getResults")
	public List<Result> getResults() {
		return resultService.getResults();
	}
	
}

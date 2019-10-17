package com.brightflag.controller;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brightflag.domain.EnrollForm;
import com.brightflag.service.EnrollService;

@RestController
public class EnrollAPIController {

	@Autowired
	EnrollService enrollService;

	@RequestMapping("api/enroll")
	public void enroll(@RequestBody @NotNull EnrollForm enrollForm) {
		enrollService.enroll(enrollForm);
	}
}

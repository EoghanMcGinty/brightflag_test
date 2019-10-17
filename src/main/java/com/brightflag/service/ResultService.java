package com.brightflag.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brightflag.domain.Result;
import com.brightflag.repository.ResultRepository;

@Service
public class ResultService {
	
	@Autowired
	ResultRepository resultRepository;

	public List<Result> getResults() {
		return resultRepository.getResults();
	}

}

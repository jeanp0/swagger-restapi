package com.jean.services;

import org.lightcouch.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jean.entity.Log;
import com.jean.repository.LogRepository;

@Service
public class LogService {

	@Autowired
	private LogRepository logRepository;
	
	public Response save(Log log) {
		return logRepository.save(log);
	}
}

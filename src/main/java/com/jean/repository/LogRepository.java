package com.jean.repository;

import org.lightcouch.CouchDbClient;
import org.lightcouch.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jean.entity.Log;

@Repository
public class LogRepository {
	
	private CouchDbClient dbClient = new CouchDbClient(); 
	
	public Response save(Log log) {
		return dbClient.save(log);
	}
}

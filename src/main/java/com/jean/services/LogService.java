package com.jean.services;

import com.jean.entity.Log;
import com.jean.repository.LogRepository;

import org.lightcouch.CouchDbClient;
import org.lightcouch.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

@Service
public class LogService {

    private CouchDbClient logRepository;
    private final List<String> controllersForLog = new ArrayList<>();

    private Log log;

    @Autowired
    public LogService(CouchDbClient logRepository) {
        this.logRepository = logRepository;
        controllersForLog.add("/customer");
    }

    public void saveRequest(HttpServletRequest httpServletRequest, Object body) {
        if (log == null) {
            log = new Log();
        }
        log.setInput(body);
        log.setDateTime(LocalDateTime.now());
        log.setControllerURI(httpServletRequest.getRequestURI());
        log.setHttpMethod(httpServletRequest.getMethod());
    }

    public void saveHandler(HandlerMethod handler) {
        // ocurre primero si es GET
        if (log == null) {
            log = new Log();
        }
        log = new Log();
        log.setJavaMethod(handler.toString());
    }

    public void saveResponse(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
            Object body) {

        log.setOutput(body);
        String pattern = ".*/customer/?.*";
        if (Pattern.matches(pattern, httpServletRequest.getRequestURI())) {
            logRepository = new CouchDbClient();
            System.out.println("Guardando log a DB...");
            Response response = logRepository.save(log);
            System.out.println(response.toString());
            try {
                logRepository.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

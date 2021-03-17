package com.jean.interceptor;

import com.jean.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.DispatcherType;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LogInterceptor implements HandlerInterceptor {

	private final LogService logService;

	@Autowired
	public LogInterceptor(LogService logService) {
		this.logService = logService;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		// guarda el javaMethod al log
		if (handler instanceof HandlerMethod) {
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			logService.saveHandler(handlerMethod);
		}

		// if GET method
		if (DispatcherType.REQUEST.name().equals(request.getDispatcherType().name())
				&& request.getMethod().equals(HttpMethod.GET.name())) {
			logService.saveRequest(request, "");
		}

		return true;
	}


	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception exception) throws Exception {
	}
	
}

package com.jean.entity;

import java.time.LocalDateTime;


public class Log {
	private LocalDateTime dateTime;
	private String controllerURI;
	private String javaMethod;
	private Object input;
	private Object output;
	private String httpMethod;

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public String getControllerURI() {
		return controllerURI;
	}

	public void setControllerURI(String controllerURI) {
		this.controllerURI = controllerURI;
	}

	public String getJavaMethod() {
		return javaMethod;
	}

	public void setJavaMethod(String javaMethod) {
		this.javaMethod = javaMethod;
	}

	public Object getInput() {
		return input;
	}

	public void setInput(Object input) {
		this.input = input;
	}

	public Object getOutput() {
		return output;
	}

	public void setOutput(Object output) {
		this.output = output;
	}

	public String getHttpMethod() {
		return httpMethod;
	}

	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}

	@Override
	public String toString() {
		return "Log [dateTime=" + dateTime + ", controllerURI=" + controllerURI + ", javaMethod=" + javaMethod
				+ ", input=" + input + ", output=" + output + ", httpMethod=" + httpMethod + "]";
	}

}

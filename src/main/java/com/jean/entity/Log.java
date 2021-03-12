package com.jean.entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Id;

public class Log {
	private LocalDateTime dateTime;
	private String controllerURI;
	private String methodURI;
	private Object input;
	private Object output;
	private String typeRequestMethod;

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

	public String getMethodURI() {
		return methodURI;
	}

	public void setMethodURI(String methodURI) {
		this.methodURI = methodURI;
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

	public String getTypeRequestMethod() {
		return typeRequestMethod;
	}

	public void setTypeRequestMethod(String typeRequestMethod) {
		this.typeRequestMethod = typeRequestMethod;
	}

	@Override
	public String toString() {
		return "Log [dateTime=" + dateTime + ", controllerURI=" + controllerURI + ", methodURI=" + methodURI
				+ ", input=" + input + ", output=" + output + ", typeRequestMethod=" + typeRequestMethod + "]";
	}

}

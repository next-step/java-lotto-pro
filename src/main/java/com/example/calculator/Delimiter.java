package com.example.calculator;

public class Delimiter {
	private static final String DEFAULT_DELIMITERS = "[,:]";

	private final String value;

	public Delimiter() {
		this.value = DEFAULT_DELIMITERS;
	}

	public Delimiter(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}

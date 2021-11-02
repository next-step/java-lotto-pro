package com.example.calculator;

import java.util.Arrays;

public class StringAddCalculator {
	private static final int DEFAULT_VALUE = 0;

	public static int splitAndSum(String string) {
		if (string == null || string.isEmpty()) {
			return DEFAULT_VALUE;
		}

		ParsedString parsed = Parser.parse(string);
		return Arrays.stream(Splitter.split(parsed))
			.map(NaturalNumber::new)
			.reduce(NaturalNumber::add)
			.get()
			.getValue();
	}
}

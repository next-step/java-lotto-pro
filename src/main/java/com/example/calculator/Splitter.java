package com.example.calculator;

public class Splitter {
	public static String[] split(ParsedString parsedString) {
		Delimiter delimiter = parsedString.getDelimiter();
		Remainder remainder = parsedString.getRemainder();

		return remainder.getValue().split(delimiter.getValue());
	}
}

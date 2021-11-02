package com.example.calculator;

public class ParsedString {
	private final Delimiter delimiter;
	private final Remainder remainder;

	public ParsedString(Delimiter delimiter, Remainder remainder) {
		this.delimiter = delimiter;
		this.remainder = remainder;
	}

	public Delimiter getDelimiter() {
		return delimiter;
	}

	public Remainder getRemainder() {
		return remainder;
	}
}

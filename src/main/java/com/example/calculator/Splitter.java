package com.example.calculator;

public class Splitter {
	public static String[] split(Remainder remainder, Delimiter delimiter) {
		return remainder.getValue().split(delimiter.getValue());
	}
}

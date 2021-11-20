package utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IntegerParser {
	private static final String SPACE = " ";
	private static final String EMPTY = "";

	public static List<Integer> toInteger(String input, String delimiter) {
		String removedSpace = input.replace(SPACE, EMPTY);
		List<Integer> result;
		try {
			result = Arrays.stream(removedSpace.split(delimiter))
				.mapToInt(x -> Integer.parseInt(x))
				.mapToObj(i -> i).collect(Collectors.toList());
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(e.getMessage());
		}

		return result;
	}
}

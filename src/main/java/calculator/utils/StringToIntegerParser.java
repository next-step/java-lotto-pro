package calculator.utils;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.List;

public class StringToIntegerParser {

	public static List<Integer> parseNumbers(String[] splitInputs) {
		return Arrays.stream(splitInputs)
					 .map(Integer::parseInt)
					 .collect(toList());
	}
}

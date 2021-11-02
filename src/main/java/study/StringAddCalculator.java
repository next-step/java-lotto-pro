package study;

import java.util.ArrayList;
import java.util.List;

public class StringAddCalculator {
	public static int splitAndSum(String stringFormula) {
		if (!validateInput(stringFormula)) {
			return 0;
		}
		List<Integer> nubmers = splitStringFormula(stringFormula);
		return sum(nubmers);
	}

	private static int sum(List<Integer> nubmers) {
		int result = 0;
		for(int number : nubmers) {
			result += number;
		}
		return result;
	}

	private static List<Integer> splitStringFormula(String stringFormula) {
		List<Integer> result = new ArrayList<>();
		for(String numberString : stringFormula.split(",|:")) {
			result.add(parseNumber(numberString));
		}
		return result;
	}

	private static Integer parseNumber(String numberString) {
		return Integer.parseInt(numberString);
	}

	private static boolean validateInput(String stringFormula) {
		if (stringFormula == null || "".equals(stringFormula)) {
			return false;
		}
		return true;
	}
}

package study;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
	private static final Pattern patternDelimiter = Pattern.compile("(?<=//)(.*?)(?=\\n)");


	public static int splitAndSum(String stringFormula) {
		if (!validateInput(stringFormula)) {
			return 0;
		}
		List<String> delimiters = getDelimiters(stringFormula);
		String stringFormulaBody = getStringFormulaBody(stringFormula);
		List<Integer> nubmers = splitStringFormula(stringFormulaBody, delimiters);
		return sum(nubmers);
	}

	private static String getStringFormulaBody(String stringFormula) {
		String[] splited = stringFormula.split("\\n");
		if (splited.length == 1) {
			return stringFormula;
		}
		return splited[1];
	}

	private static List<String> getDelimiters(String stringFormula) {
		List<String> result = new ArrayList<>();
		result.add(",");
		result.add(":");
		if (!stringFormula.contains("\n")) {
			return result;
		}
		result.add(parseDelimiter(stringFormula));
		return result;
	}

	private static String parseDelimiter(String stringFormula) {
		Matcher matcher = patternDelimiter.matcher(stringFormula);
		if (!matcher.find()) {
			throw new IllegalArgumentException("invalid input string");
		}
		return matcher.group();
	}

	private static int sum(List<Integer> nubmers) {
		int result = 0;
		for(int number : nubmers) {
			result += number;
		}
		return result;
	}

	private static List<Integer> splitStringFormula(String stringFormulaBody, List<String> delimiters) {
		List<Integer> result = new ArrayList<>();
		for(String numberString : stringFormulaBody.split(makeRegexDelimiter(delimiters))) {
			result.add(parseNumber(numberString));
		}
		return result;
	}

	private static String makeRegexDelimiter(List<String> delimiters) {
		return String.join("|", delimiters);
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

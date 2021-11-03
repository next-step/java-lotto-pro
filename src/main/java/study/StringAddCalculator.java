package study;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
	private static final Pattern patternDelimiter = Pattern.compile("(?<=//)(.*?)(?=\\n)");

	/**
	 * 문자 계산식을 계산
	 * @param stringFormula 문자 계산식
	 * @return 계산결과(숫자)
	 */
	public static int splitAndSum(String stringFormula) {
		if (!validateInput(stringFormula)) {
			return 0;
		}
		List<String> delimiters = getDelimiters(stringFormula);
		String stringFormulaBody = getStringFormulaBody(stringFormula);
		List<Integer> nubmers = splitStringFormula(stringFormulaBody, delimiters);
		return sum(nubmers);
	}

	/**
	 * 문자 계산식에서 계산식 바디를 반환
	 * @param stringFormula 문자 계산식
	 * @return 계산식 바디
	 */
	private static String getStringFormulaBody(String stringFormula) {
		String[] splited = stringFormula.split("\\n");
		if (splited.length == 1) {
			return stringFormula;
		}
		return splited[1];
	}

	/**
	 * 문자 계산식에서 구분자 목록을 반환
	 * @param stringFormula 문자 계산식
	 * @return 구분자 목록
	 */
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

	/**
	 * 문자 계산식에서 구분자를 탐색
	 * @param stringFormula 문자 계산식
	 * @return 찾은 구분자
	 */
	private static String parseDelimiter(String stringFormula) {
		Matcher matcher = patternDelimiter.matcher(stringFormula);
		if (!matcher.find()) {
			throw new IllegalArgumentException("invalid input string");
		}
		return matcher.group();
	}

	/**
	 * 숫자 목록을 모두 더함
	 * @param nubmers 숫자 목록
	 * @return 숫자 목록의 합
	 */
	private static int sum(List<Integer> nubmers) {
		int result = 0;
		for(int number : nubmers) {
			result += number;
		}
		return result;
	}

	/**
	 * 문자 계산식을 숫자 목록으로 변환
	 * @param stringFormulaBody 문자 계산식 바디
	 * @param delimiters 구분자 목록
	 * @return 숫자 목록
	 */
	private static List<Integer> splitStringFormula(String stringFormulaBody, List<String> delimiters) {
		List<Integer> result = new ArrayList<>();
		for(String numberString : stringFormulaBody.split(makeRegexDelimiter(delimiters))) {
			result.add(parseNumber(numberString));
		}
		return result;
	}

	/**
	 * 구분자 목록을 사용하여 구분자 문자열을 생성
	 * @param delimiters 구분자 목록
	 * @return 구문자 문자열
	 */
	private static String makeRegexDelimiter(List<String> delimiters) {
		return String.join("|", delimiters);
	}

	/**
	 * 숫자 문자열을 숫자로 변환
	 * @param numberString 숫자 문자열
	 * @return 변환된 숫자
	 */
	private static Integer parseNumber(String numberString) {
		return Integer.parseUnsignedInt(numberString);
	}

	/**
	 * 문자 계산식 유효성 체크
	 * @param stringFormula 문자 계산식
	 * @return 유효여부
	 */
	private static boolean validateInput(String stringFormula) {
		return stringFormula != null && !"".equals(stringFormula);
	}
}

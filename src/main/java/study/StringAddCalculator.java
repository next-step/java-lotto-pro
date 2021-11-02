package study;

public class StringAddCalculator {
	public static int splitAndSum(String stringFormula) {
		if (!validateInput(stringFormula)) {
			return 0;
		}
		return Integer.parseInt(stringFormula);
	}

	private static boolean validateInput(String stringFormula) {
		if (stringFormula == null || "".equals(stringFormula)) {
			return false;
		}
		return true;
	}
}

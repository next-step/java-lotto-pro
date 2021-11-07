public class StringAddCalculator {

	public static int splitAndSum(String str) {
		Statement statement = new Statement(str);
		return statement.calculate();
	}
}

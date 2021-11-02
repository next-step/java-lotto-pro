import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class StringAddCalculator {
	public static int splitAndSum(String s) {
		if (isNullOrEmpty(s)) {
			return 0;
		}
		throw new NotImplementedException();
	}

	private static boolean isNullOrEmpty(String s) {
		return (null == s) || s.isEmpty();
	}
}

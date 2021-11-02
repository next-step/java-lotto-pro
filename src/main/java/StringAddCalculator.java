import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

	public static int splitAndSum(String text) {
		if (isTextNullOrEmpty(text)) {
			return 0;
		}
		return -1;
	}

	private static boolean isTextNullOrEmpty(String text) {
		if (text == null || text.isEmpty()) {
			return true;
		}
		return false;
	}
}

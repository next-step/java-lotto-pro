package lottoservice.ui;

/**
 * 사용자에게 메세지를 출력하기 위한 클래스
 */
public class ResultView {

	private static String ERROR_PREFIX = "[ERROR] ";

	public static void printGuideMessage(String message) {
		System.out.println(message);
	}

	public static <T> void printResultMessage(T message) {
		System.out.println(message);
	}

	public static void printFormatResultMessage(String messageFormat, Object... arguments) {
		System.out.printf(messageFormat,arguments);
	}

	public static void printNewLine() {
		System.out.println();
	}

	public static void printErrorMessage(String message) {
		System.out.println(ERROR_PREFIX + message);
	}
}

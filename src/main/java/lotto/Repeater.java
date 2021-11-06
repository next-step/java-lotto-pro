package lotto;

public class Repeater {
	private static boolean repeater;

	private Repeater() {
	}

	public static void init() {
		repeater = true;
	}

	public static boolean isContinue() {
		return repeater;
	}

	public static void set(boolean setValue) {
		repeater = setValue;
	}
}

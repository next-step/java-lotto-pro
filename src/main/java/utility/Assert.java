package utility;

import java.util.Collection;

public final class Assert {

	private Assert() {
		throw new AssertionError();
	}

	public static void notNull(Object object, String message) {
		if (object == null) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void notEmpty(String string, String message) {
		if (string == null || string.trim().isEmpty()) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void notEmpty(Collection<?> collection, String message) {
		if (collection == null || collection.isEmpty()) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void isTrue(boolean expression, String message) {
		if (!expression) {
			throw new IllegalArgumentException(message);
		}
	}
}

package utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class StringDelimiterFinder {

	private final Pattern pattern;
	private final String target;
	private Matcher matcher;
	private Boolean cachedFoundResult;

	private StringDelimiterFinder(Pattern pattern, String target) {
		validate(pattern);
		this.pattern = pattern;
		this.target = target;
	}

	public static StringDelimiterFinder of(Pattern pattern, String target) {
		return new StringDelimiterFinder(pattern, target);
	}

	public boolean hasDelimiter() {
		return foundResult();
	}

	public String delimiter() {
		if (hasNotDelimiter()) {
			throw new IllegalStateException(String.format("%s has not delimiter pattern(%s)", target, pattern));
		}
		return matcher.group(1);
	}

	public String targetWithoutDelimiterPattern() {
		if (hasNotDelimiter()) {
			return target;
		}
		return matcher.group(2);
	}

	@Override
	public String toString() {
		return "StringDelimiterFinder{" +
			"pattern=" + pattern +
			", target='" + target +
			'}';
	}

	private boolean foundResult() {
		if (cachedFoundResult == null) {
			cachedFoundResult = find();
		}
		return cachedFoundResult;
	}

	private boolean find() {
		if (target == null) {
			return false;
		}
		matcher = pattern.matcher(target);
		return matcher.find();
	}

	private boolean hasNotDelimiter() {
		return !hasDelimiter();
	}

	private void validate(Pattern pattern) {
		if (pattern == null) {
			throw new IllegalArgumentException("delimiter pattern must not be null");
		}
	}
}

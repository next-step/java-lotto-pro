package step3;

import java.util.Arrays;
import java.util.Collections;

public class RandomUtils {
	private static Integer[] numbers = new Integer[45];

	static {
		for (int i = 1; i <= 45; i++)
			numbers[i - 1] = i;
	}

	public static int pick() {
		Collections.shuffle(Arrays.asList(numbers));
		return numbers[0];
	}

}

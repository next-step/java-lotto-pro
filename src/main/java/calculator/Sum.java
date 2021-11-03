package calculator;

import java.util.Arrays;

public class Sum {

	private int[] intArray;
	private int sum = 0;

	public Sum(Split split) {
		this.intArray = split.getIntArray();
		this.sum = sumIntArray();
	}

	public int[] getIntArray() {
		return intArray;
	}

	public int getSum() {
		return sum;
	}

	public int sumIntArray() {
		return Arrays.stream(intArray).sum();
	}
}

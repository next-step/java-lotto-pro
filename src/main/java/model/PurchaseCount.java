package model;

import java.util.Objects;

public class PurchaseCount {
	private int value;

	PurchaseCount(int value) {
		this.value = value;
	}

	public static PurchaseCount from(String manualCount) {
		return new PurchaseCount(Integer.parseInt(manualCount));
	}

	public static boolean validate(String manualCount) {
		return manualCount.matches(Regex.NUMBER);
	}

	public int getValue() {
		return value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		PurchaseCount that = (PurchaseCount)o;
		return value == that.value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}
}

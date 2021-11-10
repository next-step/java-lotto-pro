package lotto.domain;

import java.util.Objects;

public class ManualNumber {
	private final int manualNumber;

	public ManualNumber(int manualNumber) {
		this.manualNumber = manualNumber;
	}

	public boolean isMoreThanNumber(int number) {
		return manualNumber > number;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		ManualNumber that = (ManualNumber)o;
		return manualNumber == that.manualNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(manualNumber);
	}

}

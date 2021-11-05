package lotto;

import static common.CommonUtils.*;

import java.util.Objects;

public class ManualCount {
	private Integer manualCount;

	public ManualCount(String input) {
		this.manualCount = validateAndParse(input);
	}

	public Integer validateAndParse(String input) {
		Integer count = parseInt(input);
		isPositiveNumber(count);
		return count;
	}

	public int size() {
		return manualCount;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		ManualCount that = (ManualCount)o;
		return Objects.equals(manualCount, that.manualCount);
	}

	@Override
	public int hashCode() {
		return Objects.hash(manualCount);
	}
}

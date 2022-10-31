package lotto.domain;

import java.util.Objects;

public class YieldMessage {
	public static final float BENEFIT_STANDARD = 1f;
	private final float yield;

	public YieldMessage(float yield) {
		this.yield = yield;
	}

	private String benefitMessage() {
		if (yield > BENEFIT_STANDARD) {
			return "이득";
		}
		return "손해";
	}

	@Override
	public String toString() {
		return String.format("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)", yield, benefitMessage());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		YieldMessage that = (YieldMessage)o;
		return Float.compare(that.yield, yield) == 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(yield);
	}
}

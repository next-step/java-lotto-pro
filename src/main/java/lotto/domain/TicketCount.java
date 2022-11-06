package lotto.domain;

public class TicketCount {
	private final int value;

	private TicketCount(int value) {
		if (value < 0) {
			throw new IllegalArgumentException("티켓 수는 음수일 수 없습니다.");
		}
		this.value = value;
	}

	public static TicketCount from(int value) {
		return new TicketCount(value);
	}

	public int count() {
		return value;
	}

	public boolean isZero() {
		return value == 0;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		TicketCount that = (TicketCount)o;

		return value == that.value;
	}

	@Override
	public int hashCode() {
		return value;
	}
}

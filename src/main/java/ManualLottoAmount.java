import java.util.Objects;

public class ManualLottoAmount {

	private final int amount;

	private ManualLottoAmount(LottoPayment payment, int amount) {
		validate(payment, amount);
		this.amount = amount;
	}

	private void validate(LottoPayment payment, int amount) {
		if (null == payment) {
			throw new ManualLottoAmountException();
		}
		if (amount < 0) {
			throw new ManualLottoAmountException(payment);
		}
		if (payment.getNumOfLottosCanBuy() < amount) {
			throw new ManualLottoAmountException(payment);
		}
	}

	public boolean isBiggerThan(int amount) {
		return this.amount > amount;
	}

	public int subtractFrom(int operand) {
		return operand - amount;
	}

	public int get() {
		return amount;
	}

	public static ManualLottoAmount from(LottoPayment payment, int num) {
		return new ManualLottoAmount(payment, num);
	}

	public static ManualLottoAmount from(LottoPayment payment, String s) {
		return from(payment, parse(s, payment));
	}

	private static int parse(String s, LottoPayment payment) {
		try {
			return Integer.parseInt(s);
		} catch (NumberFormatException e) {
			throw new ManualLottoAmountException(payment);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof ManualLottoAmount))
			return false;
		ManualLottoAmount that = (ManualLottoAmount)o;
		return amount == that.amount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount);
	}

	@Override
	public String toString() {
		return String.valueOf(amount);
	}
}

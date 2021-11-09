import java.util.Objects;

public class ManualLottoQuantity {

	private final int quantity;

	private ManualLottoQuantity(LottoPayment payment, int quantity) {
		validate(payment, quantity);
		this.quantity = quantity;
	}

	private void validate(LottoPayment payment, int quantity) {
		if (null == payment) {
			throw new ManualLottoQuantityException();
		}
		if (quantity < 0) {
			throw new ManualLottoQuantityException(payment);
		}
		if (payment.getNumOfLottosCanBuy() < quantity) {
			throw new ManualLottoQuantityException(payment);
		}
	}

	public boolean isBiggerThan(int quantity) {
		return this.quantity > quantity;
	}

	public int subtractFrom(int operand) {
		return operand - quantity;
	}

	public int get() {
		return quantity;
	}

	public static ManualLottoQuantity from(LottoPayment payment, int num) {
		return new ManualLottoQuantity(payment, num);
	}

	public static ManualLottoQuantity from(LottoPayment payment, String s) {
		return from(payment, parse(s, payment));
	}

	private static int parse(String s, LottoPayment payment) {
		try {
			return Integer.parseInt(s);
		} catch (NumberFormatException e) {
			throw new ManualLottoQuantityException(payment);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof ManualLottoQuantity))
			return false;
		ManualLottoQuantity that = (ManualLottoQuantity)o;
		return quantity == that.quantity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(quantity);
	}

	@Override
	public String toString() {
		return String.valueOf(quantity);
	}
}

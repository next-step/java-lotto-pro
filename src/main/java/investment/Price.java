package investment;

import static lottoLegacy.common.Constants.*;

import java.util.Objects;

import exception.BusinessException;
import exception.ErrorMessages;

public class Price {
	private Integer price;

	public Price(String input) {
		validate(input);
		this.price = Integer.parseInt(input);
	}

	/**
	 * 숫자만 입력
	 * 1000원 단위
	 * 1000원 이상
	 *
	 * @param input
	 */
	private void validate(String input) {
		Integer price = parseInt(input);
		validGreaterThan(price);
		validUnit(price);
	}

	private Integer parseInt(String input) {
		try {
			return Integer.parseInt(input);
		}catch (NumberFormatException e) {
			throw new BusinessException(ErrorMessages.INPUT_NUMBER_FORMAT_NOT_VALID);
		}
	}

	private void validGreaterThan(Integer price) {
		if (price < PER_PRICE) {
			throw new BusinessException(ErrorMessages.INPUT_INVESTMENT_MIN_VALID);
		}
	}

	private void validUnit(Integer price) {
		if (Math.floorMod(price, PER_PRICE) != 0) {
			throw new BusinessException(ErrorMessages.INPUT_INVESTMENT_UNIT_VALID);
		}
	}

	public Integer floorDiv(Integer number) {
		return Math.floorDiv(price, number);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Price price1 = (Price)o;
		return Objects.equals(price, price1.price);
	}

	@Override
	public int hashCode() {
		return Objects.hash(price);
	}
}

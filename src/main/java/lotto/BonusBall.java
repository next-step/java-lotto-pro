package lotto;

import java.util.Objects;

import exception.BusinessException;
import exception.ErrorMessages;

public class BonusBall {
	private LottoNumber bonusBall;

	public BonusBall(String input) {
		this.bonusBall = new LottoNumber(parseInt(input));
	}

	private Integer parseInt(String input) {
		try {
			return Integer.parseInt(input);
		}catch (NumberFormatException e) {
			throw new BusinessException(ErrorMessages.INPUT_NUMBER_FORMAT_NOT_VALID);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		BonusBall bonusBall1 = (BonusBall)o;
		return Objects.equals(bonusBall, bonusBall1.bonusBall);
	}

	@Override
	public int hashCode() {
		return Objects.hash(bonusBall);
	}

}

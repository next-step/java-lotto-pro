package lotto;

import static common.CommonUtils.*;

import java.util.Objects;

public class BonusBall {
	private LottoNumber bonusBall;

	public BonusBall(String input) {
		this.bonusBall = new LottoNumber(parseInt(input));
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

	public boolean matched(Lotto lotto) {
		return lotto.contains(bonusBall);
	}

}

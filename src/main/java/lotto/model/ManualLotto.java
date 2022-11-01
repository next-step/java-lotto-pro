package lotto.model;

import java.util.Collection;

public class ManualLotto extends Lotto{
	public ManualLotto(final Collection<LottoNumber> numbers) {
		super(numbers);
	}

	@Override
	public boolean isAuto() {
		return false;
	}

	@Override
	public boolean isManual() {
		return true;
	}
}

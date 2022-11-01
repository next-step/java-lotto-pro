package lotto.model;

import java.util.Collection;

public class AutoLotto extends Lotto{
	public AutoLotto(final Collection<LottoNumber> numbers) {
		super(numbers);
	}

	@Override
	public boolean isAuto() {
		return true;
	}

	@Override
	public boolean isManual() {
		return false;
	}
}

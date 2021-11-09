package step3.machine;

import static step3.lotto.LottoNumbers.*;

public class AutoMachineValidation implements MachineValidation{
	@Override
	public boolean isOverFlow(int size) {
		if (size == LOTTO_NUMBER_MAX) {
			return false;
		}
		return true;
	}
}

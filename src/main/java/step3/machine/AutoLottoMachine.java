package step3.machine;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import step3.lotto.LottoNumber;
import step3.lotto.LottoNumbers;
import step3.lotto.LottoPapers;
import step3.Money;
import step3.RandomUtils;

public class AutoLottoMachine implements Machine {

	private MachineValidation machineValidation;

	public AutoLottoMachine(MachineValidation machineValidation) {
		this.machineValidation = machineValidation;
	}

	@Override
	public LottoPapers createLottoPapers(Money money) {
		List<LottoNumbers> lottoNumbers = new ArrayList<>();
		for (int i = 0; i < money.buyCount(); i++) {
			lottoNumbers.add(createOneLineLottoNumbers());
		}
		return LottoPapers.createPapers(lottoNumbers);
	}

	private LottoNumbers createOneLineLottoNumbers() {
		Set<LottoNumber> lottoNumbers = new HashSet<>();
		while (machineValidation.isOverFlow(lottoNumbers.size())) {
			lottoNumbers.add(new LottoNumber(RandomUtils.pick()));
		}
		return LottoNumbers.createLottoNumber(lottoNumbers);
	}
}

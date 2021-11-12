package step3.machine;

import static step3.lotto.LottoNumbers.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import step3.RandomUtils;
import step3.lotto.LottoNumber;
import step3.lotto.LottoNumbers;
import step3.lotto.LottoPapers;

public class LottoMachine implements Machine {
	@Override
	public LottoPapers createLottoPapers(int buyCount) {
		List<LottoNumbers> lottoNumbers = new ArrayList<>();
		for (int i = 0; i < buyCount; i++) {
			lottoNumbers.add(createOneLineLottoNumbers());
		}
		return LottoPapers.createPapers(lottoNumbers);
	}

	@Override
	public LottoPapers createManualLottoPapers(List<String> manualLottoNumbers) {
		List<LottoNumbers> lottoNumbers = new ArrayList<>();
		for (String string : manualLottoNumbers) {
			lottoNumbers.add(LottoNumbers.from(string));
		}
		return LottoPapers.createPapers(lottoNumbers);
	}

	private LottoNumbers createOneLineLottoNumbers() {
		Set<LottoNumber> lottoNumbers = new HashSet<>();
		while (isOverFlow(lottoNumbers.size())) {
			lottoNumbers.add(new LottoNumber(RandomUtils.pick()));
		}
		return LottoNumbers.createLottoNumber(lottoNumbers);
	}

	private boolean isOverFlow(int size) {
		if (size == LOTTO_NUMBER_MAX) {
			return false;
		}
		return true;
	}


}

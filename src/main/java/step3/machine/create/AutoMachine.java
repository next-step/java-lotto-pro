package step3.machine.create;

import static step3.lotto.LottoNumbers.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import step3.RandomUtils;
import step3.lotto.LottoNumber;
import step3.lotto.LottoNumbers;
import step3.lotto.LottoPapers;

public class AutoMachine implements CreateMachine<Integer> {

	@Override
	public LottoPapers createLotto(Integer buyCount) {
		List<LottoNumbers> lottoNumbers = new ArrayList<>();
		for (int i = 0; i < buyCount; i++) {
			lottoNumbers.add(createOneLineLottoNumbers());
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
		return size != LOTTO_NUMBER_MAX;
	}

}

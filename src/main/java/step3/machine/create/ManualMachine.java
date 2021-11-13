package step3.machine.create;

import java.util.ArrayList;
import java.util.List;

import step3.lotto.LottoNumbers;
import step3.lotto.LottoPapers;

public class ManualMachine implements CreateMachine<List<String>> {
	@Override
	public LottoPapers createLotto(List<String> manualLottoNumbers) {
		List<LottoNumbers> lottoNumbers = new ArrayList<>();
		for (String string : manualLottoNumbers) {
			lottoNumbers.add(LottoNumbers.from(string));
		}
		return LottoPapers.createPapers(lottoNumbers);
	}
}
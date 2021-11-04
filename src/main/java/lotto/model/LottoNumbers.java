package lotto.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumbers {
	public final static int LOTTO_NUMBERS_SIZE = 6;

	public List<LottoNumber> lottoNumberList;

	public LottoNumbers() {
		lottoNumberList = generateLottoNumberList();
	}

	public LottoNumbers(List<LottoNumber> lottoNumberList) {
		this.lottoNumberList = lottoNumberList;
	}

	private List<LottoNumber> generateLottoNumberList() {
		Set<LottoNumber> lottoNumberSet = new HashSet<>();

		do {
			lottoNumberSet.add(new LottoNumber());
		} while (lottoNumberSet.size() < LOTTO_NUMBERS_SIZE);

		return new ArrayList<>(lottoNumberSet);
	}

	public List<LottoNumber> getLottoNumberList() {
		return lottoNumberList;
	}
}


package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import lotto.code.ErrorCode;
import lotto.exception.LottoException;
import lotto.util.RandomUtil;
import lotto.util.SplitUtil;

public class LottoNumbers {
	public final static int LOTTO_NUMBERS_SIZE = 6;

	public final List<LottoNumber> lottoNumberList;

	public LottoNumbers() {
		lottoNumberList = Collections.unmodifiableList(generateLottoNumberList());
	}

	public LottoNumbers(List<LottoNumber> lottoNumberList) {
		this.lottoNumberList = Collections.unmodifiableList(lottoNumberList);
	}

	public LottoNumbers(String inputNumber) {
		this.lottoNumberList = generateLottoNumberList(inputNumber);
	}

	private List<LottoNumber> generateLottoNumberList(String inputNumber) {
		isNotLottoNumberSize(inputNumber);
		isDuplicateLottoNumber(inputNumber);
		List<LottoNumber> lottoNumberList = new ArrayList<>();

		for (String number : SplitUtil.splitInputNumbers(inputNumber)) {
			lottoNumberList.add(new LottoNumber(Integer.parseInt(number)));
		}

		return lottoNumberList;
	}

	private List<LottoNumber> generateLottoNumberList() {
		Set<LottoNumber> lottoNumberSet = new HashSet<>();

		do {
			lottoNumberSet.add(
				new LottoNumber(RandomUtil.pickNumber(LottoNumber.MIN_LOTTO_NUMBER, LottoNumber.MAX_LOTTO_NUMBER)));
		} while (lottoNumberSet.size() < LOTTO_NUMBERS_SIZE);

		return new ArrayList<>(lottoNumberSet);
	}

	public boolean containsLottoNumber(LottoNumber lottoNumber) {
		return lottoNumberList.contains(lottoNumber);
	}

	public int size() {
		return lottoNumberList.size();
	}

	private void isNotLottoNumberSize(String input) {
		if (SplitUtil.splitInputNumbers(input).length != LottoNumbers.LOTTO_NUMBERS_SIZE) {
			throw new LottoException(ErrorCode.IS_NOT_LOTTO_NUMBER_SIZE_ERROR);
		}
	}

	private void isDuplicateLottoNumber(String input) {
		Set<String> lottoNumberSet = new HashSet<>(Arrays.asList(SplitUtil.splitInputNumbers(input)));

		if (lottoNumberSet.size() != LottoNumbers.LOTTO_NUMBERS_SIZE) {
			throw new LottoException(ErrorCode.LOTTO_NUMBER_DUPLICATE_ERROR);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		LottoNumbers that = (LottoNumbers)o;
		return Objects.equals(lottoNumberList, that.lottoNumberList);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lottoNumberList);
	}
}


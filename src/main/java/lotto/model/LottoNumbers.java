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

	private LottoNumbers(List<LottoNumber> lottoNumberList) {
		this.lottoNumberList = Collections.unmodifiableList(lottoNumberList);
	}

	public static LottoNumbers from() {
		return new LottoNumbers(generateLottoNumberList());
	}

	public static LottoNumbers from(String inputNumber) {
		return new LottoNumbers(generateLottoNumberList(inputNumber));
	}

	public static LottoNumbers from(List<LottoNumber> lottoNumberList) {
		return new LottoNumbers(lottoNumberList);
	}

	private static List<LottoNumber> generateLottoNumberList(String inputNumber) {
		isNotLottoNumberSize(inputNumber);
		isDuplicateLottoNumber(inputNumber);
		List<LottoNumber> lottoNumberList = new ArrayList<>();

		for (String number : SplitUtil.splitInputNumbers(inputNumber)) {
			lottoNumberList.add(LottoNumber.from(number));
		}

		return lottoNumberList;
	}

	private static List<LottoNumber> generateLottoNumberList() {
		Set<LottoNumber> lottoNumberSet = new HashSet<>();

		do {
			lottoNumberSet.add(
				LottoNumber.from(RandomUtil.pickNumber(LottoNumber.MIN_LOTTO_NUMBER, LottoNumber.MAX_LOTTO_NUMBER)));
		} while (lottoNumberSet.size() < LOTTO_NUMBERS_SIZE);

		return new ArrayList<>(lottoNumberSet);
	}

	private static void isNotLottoNumberSize(String input) {
		if (SplitUtil.splitInputNumbers(input).length != LottoNumbers.LOTTO_NUMBERS_SIZE) {
			throw new LottoException(ErrorCode.IS_NOT_LOTTO_NUMBER_SIZE_ERROR);
		}
	}

	private static void isDuplicateLottoNumber(String input) {
		Set<String> lottoNumberSet = new HashSet<>(Arrays.asList(SplitUtil.splitInputNumbers(input)));

		if (lottoNumberSet.size() != LottoNumbers.LOTTO_NUMBERS_SIZE) {
			throw new LottoException(ErrorCode.LOTTO_NUMBER_DUPLICATE_ERROR);
		}
	}

	public boolean containsLottoNumber(LottoNumber lottoNumber) {
		return lottoNumberList.contains(lottoNumber);
	}

	public int size() {
		return lottoNumberList.size();
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


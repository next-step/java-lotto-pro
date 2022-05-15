package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoNumbers {
	private static final int LOTTO_NUMBERS_COUNT = 6;
	private static final String LOTTO_INPUT_LIST_REGEX = ",";

	private List<LottoNumber> lottoNumbers;

	public LottoNumbers(List<LottoNumber> lottoNumbers) {
		validation(lottoNumbers);
		Collections.sort(lottoNumbers);
		this.lottoNumbers = lottoNumbers;
	}

	public LottoNumbers(LottoNumber[] lottoNumbers) {
		List<LottoNumber> tempLottoNumbers = Arrays.asList(lottoNumbers);
		validation(tempLottoNumbers);
		Collections.sort(tempLottoNumbers);
		this.lottoNumbers = tempLottoNumbers;
	}

	public LottoNumbers(String lottoNumbers) {
		List<LottoNumber> tempLottoNumbers = stringToListLottoNumbers(lottoNumbers);
		validation(tempLottoNumbers);
		Collections.sort(tempLottoNumbers);
		this.lottoNumbers = tempLottoNumbers;
	}

	private List<LottoNumber> stringToListLottoNumbers(String lottoNumbers) {
		return stringsToListLottoNumbers(lottoNumbers.split(LOTTO_INPUT_LIST_REGEX));
	}

	private List<LottoNumber> stringsToListLottoNumbers(String... lottoNumbers) {
		List<LottoNumber> tempLottoNumbers = new ArrayList<>();
		for (String lottoNumber : lottoNumbers) {
			tempLottoNumbers.add(new LottoNumber(lottoNumber));
		}
		return tempLottoNumbers;
	}

	public static int lottoNumbersCount() {
		return LOTTO_NUMBERS_COUNT;
	}

	public List<LottoNumber> getLottoNumbers() {
		return this.lottoNumbers;
	}

	public void validation(List<LottoNumber> lottoNumbers) {
		validationEmpty(lottoNumbers);
		validationCount(lottoNumbers);
	}

	private void validationEmpty(List<LottoNumber> lottoNumbers) {
		if (isEmpty(lottoNumbers)) {
			throw new NullPointerException("Collection이 비어있습니다.");
		}
	}

	private boolean isEmpty(List<LottoNumber> lottoNumbers) {
		return lottoNumbers == null || lottoNumbers.isEmpty();
	}

	private void validationCount(List<LottoNumber> lottoNumbers) {
		if (!isLottoCount(lottoNumbers)) {
			throw new IllegalArgumentException(
					"size:" + lottoNumbers.stream().distinct().count() + " LottoSize: " + LOTTO_NUMBERS_COUNT);
		}
	}

	private boolean isLottoCount(List<LottoNumber> lottoNumbers) {
		return lottoNumbers.stream().distinct().count() == LOTTO_NUMBERS_COUNT;
	}

	// 반환값이 count가 좋을지 list로 반환하여 처리하는게 좋을지 고민해볼것
	public int countEqualsLottoNumber(LottoNumbers lottoNumbers) {
		return (int) lottoNumbers.getLottoNumbers().stream()
				.filter(lottoNumber -> getLottoNumbers().contains(lottoNumber)).count();
	}
}

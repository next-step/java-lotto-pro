package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningLottoNumbers {
	private final static String SEPARATOR = ",";
	private final static String REPLACE_REGEX = "\\p{Z}";
	private final static String EMPTY_STRING = "";

	private List<LottoNumber> winninglottoNumberList;

	public WinningLottoNumbers() {

	}

	public WinningLottoNumbers(String input) {
		this.winninglottoNumberList = generateWinningLottoNumbers(input);
	}

	private String[] splitInputNumbers(String input) {
		return input.replaceAll(REPLACE_REGEX, EMPTY_STRING).split(SEPARATOR);
	}

	private void isNotLottoNumberSize(String input) {
		if (splitInputNumbers(input).length != LottoNumbers.LOTTO_NUMBERS_SIZE) {
			throw new IllegalArgumentException();
		}
	}

	private void isDuplicateLottoNumber(String input) {
		Set<String> lottoNumberSet = new HashSet<>(Arrays.asList(splitInputNumbers(input)));

		if (lottoNumberSet.size() != LottoNumbers.LOTTO_NUMBERS_SIZE) {
			throw new IllegalArgumentException();
		}
	}

	private List<LottoNumber> generateWinningLottoNumbers(String input) {
		List<LottoNumber> lottoNumberList = new ArrayList<>();
		isNotLottoNumberSize(input);
		isDuplicateLottoNumber(input);

		for (String number : splitInputNumbers(input)) {
			lottoNumberList.add(new LottoNumber(Integer.parseInt(number)));
		}
		return lottoNumberList;
	}

	public int size() {
		return winninglottoNumberList.size();
	}

	public boolean containsLottoNumber(LottoNumber lottoNumber) {
		return winninglottoNumberList.contains(lottoNumber);
	}
}

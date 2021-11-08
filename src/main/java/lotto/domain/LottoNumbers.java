package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {
	private static final int MATCHED_NUMBER_PLUS = 1;
	private static final int NON_MATCHED_NUMBER = 0;
	private final List<Integer> lottoNumbers;

	public LottoNumbers(int... lottoNumbers) {
		this(Arrays.stream(lottoNumbers)
			.boxed()
			.collect(Collectors.toList()));
	}

	public LottoNumbers(List<Integer> lottoNumbers) {
		this.lottoNumbers = Collections.unmodifiableList(new ArrayList<>(lottoNumbers));
	}

	public int isMatch(int winningNumber) {
		if (lottoNumbers.contains(winningNumber)) {
			return MATCHED_NUMBER_PLUS;
		}
		return NON_MATCHED_NUMBER;
	}

	public List<String> StringValues() {
		List<String> stringValues = new ArrayList<>();
		for (Integer lottoNumber : lottoNumbers) {
			stringValues.add(String.valueOf(lottoNumber));
		}
		return stringValues;
	}
}


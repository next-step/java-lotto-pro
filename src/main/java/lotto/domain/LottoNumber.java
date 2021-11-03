package lotto.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LottoNumber {

	public static final int LOTTO_NUMBER_MINIMUM = 1;
	public static final int LOTTO_NUMBER_MAXIMUM = 45;
	public static final int LOTTO_NUMBER_SIZE = 6;

	private final List<Integer> lottoNumbers = new ArrayList<>();

	public LottoNumber(Collection<Integer> numbers) {
		validateNumber(numbers);
		this.lottoNumbers.addAll(numbers);
		Collections.sort(lottoNumbers);
	}

	private void validateNumber(Collection<Integer> numbers) {
		if (numbers.size() != LOTTO_NUMBER_SIZE) {
			throw new IllegalArgumentException("6개의 숫자로 되어야 합니다");
		}
		for (int number : numbers) {
			if (number < LOTTO_NUMBER_MINIMUM || number > LOTTO_NUMBER_MAXIMUM) {
				throw new IllegalArgumentException("1이상 45이하인 숫자여야 합니다");
			}
		}
	}

	public List<Integer> getNumbers() {
		return new ArrayList<>(this.lottoNumbers);
	}

	@Override
	public String toString() {
		List<String> elements = new ArrayList<>();
		for (int number : lottoNumbers) {
			elements.add(String.valueOf(number));
		}
		return String.join(",", elements);
	}

	private boolean contains(int a) {
		return this.lottoNumbers.contains(a);
	}

	public int getMatchCount(LottoNumber other) {
		int cnt = 0;
		for (int num : this.lottoNumbers) {
			cnt += other.contains(num) ? 1 : 0;
		}
		return cnt;
	}
}

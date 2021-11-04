package lotto.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumber {

	public static final int LOTTO_NUMBER_MINIMUM = 1;
	public static final int LOTTO_NUMBER_MAXIMUM = 45;
	public static final int LOTTO_NUMBER_SIZE = 6;

	private List<Integer> lottoNumbers = new ArrayList<>();

	public static LottoNumber of(List<Integer> numbers) {
		LottoNumber lottoNumber = new LottoNumber();
		validateNumber(numbers);
		Collections.sort(numbers);
		lottoNumber.addAll(numbers);
		return lottoNumber;
	}

	private static void validateNumber(Collection<Integer> numbers) {
		if (numbers.size() != LOTTO_NUMBER_SIZE) {
			throw new IllegalArgumentException("6개의 숫자로 되어야 합니다");
		}
		for (int number : numbers) {
			if (number < LOTTO_NUMBER_MINIMUM || number > LOTTO_NUMBER_MAXIMUM) {
				throw new IllegalArgumentException("1이상 45이하인 숫자여야 합니다");
			}
		}
		Set<Integer> set = new HashSet<>(numbers);
		if (set.size() != numbers.size()) {
			throw new IllegalArgumentException("중복이 있으면 안됩니다");
		}
	}

	private void addAll(Collection<Integer> numbers) {
		this.lottoNumbers.addAll(numbers);
		this.lottoNumbers = Collections.unmodifiableList(this.lottoNumbers);
	}

	public List<Integer> getNumbers() {
		return Collections.unmodifiableList(this.lottoNumbers);
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

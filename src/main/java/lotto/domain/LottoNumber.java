package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumber {

	public static final int LOTTO_NUMBER_MINIMUM = 1;
	public static final int LOTTO_NUMBER_MAXIMUM = 45;
	public static final int LOTTO_NUMBER_SIZE = 6;

	private List<Integer> lottoNumbers = new ArrayList<>();
	private int bonusNumber = 0;

	private LottoNumber() {
	}

	public static LottoNumber of(List<Integer> numbers) {
		LottoNumber lottoNumber = new LottoNumber();
		validateNumber(numbers);
		Collections.sort(numbers);
		lottoNumber.addAll(numbers);
		return lottoNumber;
	}

	public static LottoNumber of(List<Integer> numbers, int bonusNumber) {
		LottoNumber lottoNumber = new LottoNumber();
		validateNumber(numbers);
		Collections.sort(numbers);
		lottoNumber.addAll(numbers);
		validateBonusNumber(numbers, bonusNumber);
		lottoNumber.setBonusNumber(bonusNumber);
		return lottoNumber;
	}

	private static void validateNumber(List<Integer> numbers) {
		if (numbers.size() != LOTTO_NUMBER_SIZE) {
			throw new IllegalArgumentException("6개의 숫자로 되어야 합니다");
		}
		for (int number : numbers) {
			validateNumberRange(number);
		}
		Set<Integer> set = new HashSet<>(numbers);
		if (set.size() != numbers.size()) {
			throw new IllegalArgumentException("중복이 있으면 안됩니다");
		}
	}

	private static void validateBonusNumber(List<Integer> numbers, int bonusNumber) {
		if (numbers.contains(bonusNumber)) {
			throw new IllegalArgumentException("보너스번호는 다른 번호들과 중복이 되면 안됩니다");
		}
		validateNumberRange(bonusNumber);
	}

	private static void validateNumberRange(int number) {
		if (number < LOTTO_NUMBER_MINIMUM || number > LOTTO_NUMBER_MAXIMUM) {
			throw new IllegalArgumentException("1이상 45이하인 숫자여야 합니다");
		}
	}

	public static boolean isContainBonusNumber(LottoNumber winningNumber, LottoNumber number) {
		return number.contains(winningNumber.getBonusNumber());
	}

	private void addAll(List<Integer> numbers) {
		this.lottoNumbers = Collections.unmodifiableList(numbers);
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

	public boolean isMatchBonusNumber(int bonusNumber) {
		return this.bonusNumber == bonusNumber;
	}

	private int getBonusNumber() {
		return this.bonusNumber;
	}

	private void setBonusNumber(int bonusNumber) {
		this.bonusNumber = bonusNumber;
	}

	@Override
	public String toString() {
		String[] ary = new String[lottoNumbers.size()];
		for (int i = 0; i < ary.length; i++) {
			ary[i] = String.valueOf(lottoNumbers.get(i));
		}
		return "numbers: " + String.join(",", ary) + ", bonusNumber: " + bonusNumber;
	}
}

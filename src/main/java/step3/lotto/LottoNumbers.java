package step3.lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoNumbers {
	public static final int LOTTO_NUMBER_MAX = 6;
	private final Set<LottoNumber> lottoNumbers;

	public LottoNumbers(Set<LottoNumber> lottoNumbers) {
		this.lottoNumbers = lottoNumbers;
		validation();
	}

	private void validation() {
		if (isOverFlow()) {
			throw new ArrayIndexOutOfBoundsException("로또 번호가 6개 이상 뽑혔습니다.");
		}
	}

	private boolean isOverFlow() {
		return lottoNumbers.size() > LOTTO_NUMBER_MAX;
	}

	public static LottoNumbers createLottoNumber(Set<LottoNumber> inputLottoNumber) {
		return new LottoNumbers(inputLottoNumber);
	}

	public static LottoNumbers createLottoNumber(Integer... inputLottoNumber) {
		return new LottoNumbers(conventToSet(inputLottoNumber));
	}

	private static Set<LottoNumber> conventToSet(Integer[] inputLottoNumber) {
		return Stream.of(inputLottoNumber)
			.map(LottoNumber::new)
			.collect(Collectors.toSet());
	}

	public static LottoNumbers from(String userInputLottoNumbers) {
		return new LottoNumbers(
			Arrays.stream(userInputLottoNumbers.split(","))
				.map(String::trim)
				.map(s -> new LottoNumber(Integer.parseInt(s)))
				.collect(Collectors.toSet())
		);
	}

	public Integer matchCount(LottoNumbers userLottoNumbers) {
		return (int) lottoNumbers.stream()
			.filter(lottoNumber -> userLottoNumbers.getList().stream()
				.anyMatch(lottoNumber::equals)
			).count();
	}

	public Boolean matchBonusBall(BonusBall bonusBall) {
		return lottoNumbers.contains(bonusBall);
	}

	public Set<LottoNumber> getList() {
		return Collections.unmodifiableSet(lottoNumbers);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		LottoNumbers that = (LottoNumbers)o;
		return Objects.equals(lottoNumbers, that.lottoNumbers);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lottoNumbers);
	}

	@Override
	public String toString() {
		return String.valueOf(lottoNumbers);
	}

	public boolean hasBonusBall(BonusBall bonusBall) {
		return lottoNumbers.contains(bonusBall);
	}
}

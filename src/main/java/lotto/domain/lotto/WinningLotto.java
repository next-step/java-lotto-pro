package lotto.domain.lotto;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import lotto.util.InputSplitter;

public class WinningLotto {
	private final Lotto winLotto;
	private final LottoNumber bonusNumber;

	public WinningLotto(List<Integer> winNumbers, int bonusNumber) {
		validateDuplicateBonusNumber(winNumbers, bonusNumber);
		this.winLotto = new InputLottoGenerator(winNumbers).generate();
		this.bonusNumber = LottoNumber.from(bonusNumber);
	}

	private void validateDuplicateBonusNumber(List<Integer> winNumbers, int bonusNumber) {
		if (winNumbers.contains(bonusNumber)) {
			throw new IllegalStateException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
		}
	}

	public static WinningLotto from(String input, String bonusBallInput) {
		return new WinningLotto(convertInputToIntegerList(input), Integer.parseInt(bonusBallInput));
	}

	private static List<Integer> convertInputToIntegerList(String input) {
		return InputSplitter.splitText(input).stream()
			.map(Integer::parseInt)
			.collect(Collectors.toList());
	}

	public LottoResults getLottoResults(Lottos lottos) {
		return lottos.toLottoResults(winLotto);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		WinningLotto that = (WinningLotto)o;
		return Objects.equals(winLotto, that.winLotto) && Objects.equals(bonusNumber, that.bonusNumber);
	}

	@Override
	public int hashCode() {
		return Objects.hash(winLotto, bonusNumber);
	}
}

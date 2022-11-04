package lotto.domain.lotto;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import lotto.domain.amount.Amount;
import lotto.domain.quantity.Quantity;
import lotto.util.InputSplitter;

public class Lottos {
	private static final int MIN_LOTTOS_SIZE = 1;
	private static final int CHECK_HAS_CHANGES_NUM = 0;
	private static final int LOTTO_PURCHASE_PRICE = 1000;
	private final List<Lotto> lottos;

	private Lottos(List<Lotto> lottos) {
		validateLottosSize(lottos.size());
		this.lottos = lottos;
	}

	public static Lottos from(List<Lotto> lottos) {
		return new Lottos(lottos);
	}

	public static Lottos purchaseManualLottos(List<String> manualLottoNumbers) {
		return Lottos.from(manualLottoNumbers.stream()
			.map(s -> new InputLottoGenerator(
				InputSplitter.splitText(s).stream().map(Integer::parseInt).collect(Collectors.toList())).generate())
			.collect(Collectors.toList()));
	}

	public static Lottos purchaseRandomLottos(Amount purchaseAmount) {
		validateHasChanges(purchaseAmount);
		return Lottos.from(LongStream.range(0, purchaseCount(purchaseAmount))
			.mapToObj(i -> new RandomLottoGenerator().generate())
			.collect(Collectors.toList()));
	}

	private static long purchaseCount(Amount purchaseAmount) {
		return purchaseAmount.getLong() / LOTTO_PURCHASE_PRICE;
	}

	private static void validateHasChanges(Amount purchaseAmount) {
		if (purchaseAmount.getLong() % LOTTO_PURCHASE_PRICE != CHECK_HAS_CHANGES_NUM) {
			throw new IllegalArgumentException("1000원 단위의 금액을 입력해야 합니다.");
		}
	}

	public Lottos concat(Lottos other) {
		return new Lottos(Stream.concat(this.lottos.stream(), other.lottos.stream()).collect(Collectors.toList()));
	}

	private void validateLottosSize(int size) {
		if (size < MIN_LOTTOS_SIZE) {
			throw new IllegalArgumentException("최소 한장 이상의 로또를 구매해야합니다.");
		}
	}

	public Quantity getQuantity() {
		return Quantity.from(this.lottos.size());
	}

	public List<Lotto> getLottos() {
		return this.lottos;
	}

	public LottoResults toLottoResults(Lotto winLotto, LottoNumber bonusNumber) {
		return LottoResults.from(this.lottos.stream()
			.map(lotto -> LottoResult.from(lotto,
				MatchRank.valueOf(lotto.countMatchCount(winLotto), lotto.contains(bonusNumber))))
			.collect(Collectors.toList()));
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Lottos lottos = (Lottos)o;
		return Objects.equals(getLottos(), lottos.getLottos());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getLottos());
	}
}

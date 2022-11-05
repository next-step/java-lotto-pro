package lotto.domain.lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import lotto.domain.amount.Amount;
import lotto.util.InputSplitter;

public class PurchaseLottos {
	private static final int EMPTY_BUDGET_NUM = 0;
	private static final int CHECK_HAS_CHANGES_NUM = 0;
	private static final int LOTTO_PURCHASE_PRICE = 1000;
	private Amount budget;

	public PurchaseLottos(Amount budget) {
		validateHasChanges(budget);
		this.budget = budget;
	}

	private void validateHasChanges(Amount purchaseAmount) {
		if (purchaseAmount.getLong() % LOTTO_PURCHASE_PRICE != CHECK_HAS_CHANGES_NUM) {
			throw new IllegalArgumentException("1000원 단위의 금액을 입력해야 합니다.");
		}
	}

	public Lottos purchaseManualLottos(List<String> manualLottoNumbers) {
		Amount purchaseAmount = purchaseAmount(manualLottoNumbers.size());
		validateBudgetEnough(purchaseAmount);
		Lottos lottos = Lottos.from(manualLottoNumbers.stream()
			.map(s -> new InputLottoGenerator(
				InputSplitter.splitText(s).stream().map(Integer::parseInt).collect(Collectors.toList())).generate())
			.collect(Collectors.toList()));

		this.budget = budget.sub(purchaseAmount);
		return lottos;
	}

	private void validateBudgetEnough(Amount purchaseAmount) {
		if (!this.budget.greaterThanEqual(purchaseAmount)) {
			throw new IllegalStateException("예산이 부족합니다.");
		}
	}

	public Lottos purchaseRandomLottos() {
		Lottos lottos = Lottos.from(LongStream.range(0, purchaseCount(budget))
			.mapToObj(i -> new RandomLottoGenerator().generate())
			.collect(Collectors.toList()));
		this.budget = budget.sub(budget);
		return lottos;
	}

	private Amount purchaseAmount(long purchaseCount) {
		return Amount.from(purchaseCount * LOTTO_PURCHASE_PRICE);
	}

	private long purchaseCount(Amount purchaseAmount) {
		return purchaseAmount.getLong() / LOTTO_PURCHASE_PRICE;
	}

	public boolean isEmptyBudget() {
		return this.budget.equals(Amount.from(EMPTY_BUDGET_NUM));
	}
}

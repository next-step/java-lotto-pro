package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoShop {
	public static final Money LOTTO_PRICE = new Money(1000);
	private static final List<LottoNumber> allLottoNumbers = new ArrayList<>();

	static {
		for (int i = LottoNumber.MIN_BOUND; i <= LottoNumber.MAX_BOUND; i++) {
			allLottoNumbers.add(new LottoNumber(i));
		}
	}

	private static Lotto create() {
		Collections.shuffle(allLottoNumbers);
		List<LottoNumber> lottoNumbers = allLottoNumbers.subList(Lotto.MIN_RANGE_VALUE,
			Lotto.MAX_RANGE_VALUE);
		lottoNumbers.sort(Comparator.comparingInt(LottoNumber::getValue));
		return new Lotto(lottoNumbers);
	}

	public static Lottos sell(Money purchaseAmount) {
		return IntStream.range(0, purchaseAmount.getPurchaseQuantity(LOTTO_PRICE))
			.mapToObj(ignore -> create())
			.collect(Collectors.collectingAndThen(Collectors.toList(), Lottos::new));
	}
}
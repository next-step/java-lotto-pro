package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BuyerTest {

	private PurchaseAmount purchaseAmount;
	private Lottos lottos;
	private List<Lotto> lottoList;

	@BeforeEach
	void setUp() {
		purchaseAmount = new PurchaseAmount(10000);

		lottoList = new ArrayList<>();
		lottoList.add(new Lotto(
			Stream.of(1, 2, 3, 4, 5, 6)
				.map(LottoNumber::of)
				.collect(Collectors.toSet()))
		);

		lottos = new Lottos(lottoList);
	}

	@DisplayName("판매자 생성")
	@Test
	void generateBuyer() {
		Buyer buyer = new Buyer(purchaseAmount, lottos);

		assertThat(buyer).isEqualTo(new Buyer(purchaseAmount, lottos));
	}

}

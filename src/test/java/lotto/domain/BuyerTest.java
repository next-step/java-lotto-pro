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
		ManualNumber manualNumber = new ManualNumber(5);
		Buyer buyer = new Buyer(purchaseAmount, manualNumber, lottos);

		assertThat(buyer).isEqualTo(new Buyer(purchaseAmount, manualNumber, lottos));
	}

	@DisplayName("구입금액보다 많은 수동 횟수인 경우")
	@Test
	void shortMoney() {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				ManualNumber manualNumber = new ManualNumber(15);

				new Buyer(purchaseAmount, manualNumber, lottos);
			}).withMessageMatching("구입금액이 부족합니다.");
	}

	@DisplayName("수동 로또 자동 로또 합치기")
	@Test
	void mergeLotto() {
		ManualNumber manualNumber = new ManualNumber(3);
		Buyer buyer = new Buyer(purchaseAmount, manualNumber, lottos);
		List<Lotto> targetLottoList = new ArrayList<>();
		targetLottoList.add(new Lotto(
			Stream.of(1, 2, 3, 4, 5, 6)
				.map(LottoNumber::of)
				.collect(Collectors.toSet())));
		Lottos targetLottos = new Lottos(targetLottoList);

		Lottos mergeLottos = buyer.mergeLottos(targetLottos);
		Lottos concatLottos = new Lottos(Stream.concat(lottoList.stream(), targetLottoList.stream())
			.collect(Collectors.toList()));

		assertThat(mergeLottos).isEqualTo(concatLottos);

	}

}

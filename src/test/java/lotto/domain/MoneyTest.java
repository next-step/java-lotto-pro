package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {
	@Test
	@DisplayName("돈 0원 이하 에러처리")
	public void MoneyBoundaryTest() {
		assertThatThrownBy(() -> new Money(-1))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("돈은 0원보다 작을 수 없습니다.");
	}

	@Test
	@DisplayName("구매 수량 확인")
	public void purchaseQuantityTest() {
		//given
		Money money = new Money(15000);
		//when
		int purchaseQuantity = money.getPurchaseQuantity(1000);
		//then
		assertThat(purchaseQuantity).isEqualTo(15);
	}

}
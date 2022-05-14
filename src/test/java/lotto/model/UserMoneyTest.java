package lotto.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserMoneyTest {
	@Test
	@DisplayName("숫자가 아닌 값이나 로또 최소금액 1000원보다 낮은 수가 입력된 경우 예외발생 테스트")
	void create_money_예외테스트() {
		assertAll(() -> assertThrows(IllegalArgumentException.class, () -> new UserMoney("a")),
				() -> assertThrows(IllegalArgumentException.class, () -> new UserMoney("-1")));
	}

	@Test
	@DisplayName("생성 테스트")
	void create_money() {
		assertEquals(new UserMoney("1000").getMoney(), 1000);
	}
}

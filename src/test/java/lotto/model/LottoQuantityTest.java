package lotto.model;

import lotto.constants.ErrorMessage;
import lotto.exception.InvalidInputException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoQuantityTest {
  @Test
  void 로또_갯수를_가진다() {
    LottoQuantity lottoQuantity = new LottoQuantity(14);

    assertThat(lottoQuantity.getLottoQuantity()).isEqualTo(14);
  }

  @Test
  void 로또_개수_1개_미만_예외_처리() {
    assertThatThrownBy(() -> new LottoQuantity(-1))
      .isInstanceOf(InvalidInputException.class)
      .hasMessage(ErrorMessage.LOTTO_QUANTITY_LOWER_ERROR_MESSAGE);
  }

}
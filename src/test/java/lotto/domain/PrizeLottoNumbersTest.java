package lotto.domain;

import lotto.exception.WrongLottoNumbersInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PrizeLottoNumbersTest {

    @DisplayName("당첨 로또 결과 테스트")
    @Test
    void prizeLottoNumbersResultTest() {
        String prizeLottoNumbers = "1,2,3,4,5,6";
        LottoNumbers myLottoNumbers = Fixture.lottoNumbersOf(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        PrizeLottoNumbers prizeLottoNumbersTicket = new PrizeLottoNumbers(prizeLottoNumbers, bonusNumber);
        assertThat(prizeLottoNumbersTicket.getLottoResult(myLottoNumbers)).isEqualTo(new LottoResult(6, false));
    }

    @DisplayName("당첨 로또 보너스 숫자가 포함할 경우 오류 테스트")
    @Test
    void prizeLottoNumbersBonusNumberExceptionTest() {
        assertThatThrownBy(() -> {
            String prizeLottoNumbers = "1,2,3,4,5,6";
            int bonusNumber = 6;
            PrizeLottoNumbers prizeLottoNumbersTicket = new PrizeLottoNumbers(prizeLottoNumbers, bonusNumber);
        }).isInstanceOf(WrongLottoNumbersInputException.class)
        .hasMessageContaining("보너스 번호 입력을 확인해 주세요.");
    }
}
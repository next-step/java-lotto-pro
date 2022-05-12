package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoNumbersTest {

    @ParameterizedTest(name = "입력받은 금액({0})에 따른 {1}개의 로또가 생성되어 반환")
    @CsvSource(value = {"1500:1", "20000:20", "35100:35"}, delimiter = ':')
    void getLottoNumber(String money, int expected) {
        LottoPurchaseQuantity lottoPurchaseQuantity = new LottoPurchaseQuantity(money);
        LottoNumbers lottoTickets = new LottoNumbers(lottoPurchaseQuantity);
        List<LottoNumber> lottoNumbers = lottoTickets.getLottoNumbers();

        assertAll(
                () -> assertThat(lottoNumbers).isNotNull(),
                () -> assertThat(lottoNumbers).hasSize(expected)
        );
    }

    @Test
    @DisplayName("구매한 금액의 로또 갯수만큼 결과가 나왔는지 확인")
    void verifyLottoRankResultSize() {
        LottoNumber winningLottoNumber = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoPurchaseQuantity lottoPurchaseQuantity = new LottoPurchaseQuantity("10000");
        LottoNumbers lottoNumbers = new LottoNumbers(lottoPurchaseQuantity);

        assertThat(lottoNumbers.getLottoRanks(winningLottoNumber)).hasSize(lottoPurchaseQuantity.getQuantity());
    }
}

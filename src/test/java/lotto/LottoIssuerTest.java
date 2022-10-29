package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.junit.jupiter.params.ParameterizedTest.DEFAULT_DISPLAY_NAME;

class LottoIssuerTest {

    @ParameterizedTest(name = "로또 발급 성공 " + DEFAULT_DISPLAY_NAME)
    @CsvSource(value = { "10000:10", "10500:10", "500:0" }, delimiter = ':')
    void issue_lottoList_success(int money, int numberOfLotto) {
        assertThat(LottoIssuer.issue(new Money(money))).hasSize(numberOfLotto);
    }

    @DisplayName("로또 당첨 결과 성공")
    @Test
    void result_issuedLotto_success() {
        List<Lotto> lottoList = Collections.emptyList();
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThatNoException().isThrownBy(() -> LottoIssuer.result(lottoList, winningNumbers));
    }
}

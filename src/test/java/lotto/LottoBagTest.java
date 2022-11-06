package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.junit.jupiter.params.ParameterizedTest.DEFAULT_DISPLAY_NAME;

@DisplayName("로또 목록 테스트")
class LottoBagTest {

    @DisplayName("생성 테스트")
    @Test
    void create_lottoBag_success() {
        assertThatNoException().isThrownBy(() -> LottoIssuer.issueAuto(0, new LottoNumberGenerator()));
    }

    @ParameterizedTest(name = "발급 로또 갯수 테스트 " + DEFAULT_DISPLAY_NAME)
    @CsvSource(value = { "10:10", "20:20", "0:0" }, delimiter = ':')
    void create_numberOfLotto_success(int availableCount, int numberOfLotto) {
        //given:
        LottoBag lottoBag = LottoIssuer.issueAuto(availableCount, new LottoNumberGenerator());
        //when, then:
        assertThat(lottoBag.lottoSize()).isEqualTo(numberOfLotto);
    }

    @DisplayName("concat 메서드 테스트")
    @Test
    void concat_lottoBag_success() {
        //given:
        NumberGenerator numberGenerator = new LottoNumberGenerator();
        Lotto sourceLotto = new Lotto(numberGenerator);
        LottoBag sourceBag = new LottoBag(Collections.singletonList(sourceLotto));
        Lotto targetLotto = new Lotto(numberGenerator);
        LottoBag targetBag = new LottoBag(Collections.singletonList(targetLotto));
        //when:
        LottoBag expected = new LottoBag(Arrays.asList(sourceLotto, targetLotto));
        LottoBag result = LottoBag.concat(sourceBag, targetBag);
        //then:
        assertThat(result).usingRecursiveComparison().isEqualTo(expected);
    }
}

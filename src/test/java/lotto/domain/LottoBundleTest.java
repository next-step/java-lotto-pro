package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("LottoBundle 테스트")
class LottoBundleTest {

    @DisplayName("랜덤 로또 생성 확인")
    @ParameterizedTest(name = "{displayName} ({index}) -> param = [{arguments}]")
    @ValueSource(ints = {0, 1, 10})
    void 랜덤_로또_생성_확인(int testValue) {
        LottoBundle lottoBundle = LottoBundleFactory.generateRandomLotto(testValue);

        assertThat(lottoBundle.getLottoCount())
                .isEqualTo(testValue);
    }
}

package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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

    @Test
    @DisplayName("로또 번들 통합 확인")
    void 로또_번들_통합_확인() {
        // given
        LottoBundle lottoBundle = LottoBundleFactory.generateRandomLotto(3);
        LottoBundle secondLottoBundle = LottoBundleFactory.generateRandomLotto(4);

        // when
        LottoBundle totalLottoBundle = lottoBundle.addAll(secondLottoBundle);
        int totalLottoCount = totalLottoBundle.getLottoCount();

        // then
        assertThat(totalLottoCount)
                .isEqualTo(7);
    }
}

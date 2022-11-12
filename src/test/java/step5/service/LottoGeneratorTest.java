package step5.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step5.model.Lotto;
import step5.model.LottoNo;
import step5.model.LottoWinningNos;
import step5.model.Lottos;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoGeneratorTest {

    private LottoGenerator lottoGenerator;

    @BeforeEach
    void setUp() {
        this.lottoGenerator = new LottoGenerator();
    }

    @ParameterizedTest
    @ValueSource(ints = {1,3,4,6,8})
    @DisplayName("generateByTimes 사용할때 지정된 갯수만큼 가지고있는 lottos 리턴")
    void generateByTimes(int count) {
        Lottos lottos = this.lottoGenerator.generateByTimesAndManualLotto(count, List.of());

        assertThat(lottos.count()).isEqualTo(count);
    }

    @Test
    @DisplayName("입력 받은 텍스트를 로또 번호 리스트로 리턴")
    void generateLottoNos() {
        //given
        String lottoText = "1,2,3,4,5,7";
        List<LottoNo> primitiveLottoNos = List.of(1,2,3,4,5,7).stream()
                .map(LottoNo::new)
                .collect(Collectors.toList());

        //when
        List<LottoNo> lottoNos = lottoGenerator.generateLottoNos(lottoText);

        //then
        assertThat(lottoNos).hasSize(primitiveLottoNos.size());
        assertThat(lottoNos).containsAll(primitiveLottoNos);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,d,5,6", "1,2,3,4,-5d,6"})
    @DisplayName("입력 받은 텍스트가 번호로만 이루어지지 않았을 때 에러")
    void givenLottoText_whenGenerateLottoNos_thenThrow(String lottoText) {
        //when then
        assertThatThrownBy(() -> lottoGenerator.generateLottoNos(lottoText))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("숫자를 기입");
    }

    @Test
    @DisplayName("입력 받은 텍스트를 당첨 로또로 리턴")
    void generateLottoWinningNos() {
        //given
        final List<LottoNo> lottoNos = Stream.of(1,2,3,4,5,6)
                .map(LottoNo::new)
                .collect(Collectors.toList());
        final List<LottoNo> includeBonusNoLottoNos = Stream.of(1, 2, 3, 4, 5, 24)
                .map(LottoNo::new)
                .collect(Collectors.toList());
        final Lotto lotto = new Lotto(lottoNos);
        final int bonusNo = 24;
        final Lotto includeBonusNoLotto = new Lotto(includeBonusNoLottoNos);

        //when
        LottoWinningNos lottoWinningNos = lottoGenerator.generateLottoWinningNos(lotto, bonusNo);

        //then
        assertThat(lottoWinningNos).isNotNull();
        assertThat(lottoWinningNos.getMatchedCount(lotto)).isEqualTo(lottoNos.size());
        assertThat(lottoWinningNos.isMatchedBonus(includeBonusNoLotto)).isTrue();
    }
}

package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    private Lottos lottos;

    @BeforeEach
    void setUp() {
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6)
        )));
        lottoList.add(new Lotto(Arrays.asList(
                LottoNumber.of(2),
                LottoNumber.of(7),
                LottoNumber.of(11),
                LottoNumber.of(24),
                LottoNumber.of(34),
                LottoNumber.of(35)
        )));
        lottoList.add(new Lotto(Arrays.asList(
                LottoNumber.of(6),
                LottoNumber.of(8),
                LottoNumber.of(23),
                LottoNumber.of(35),
                LottoNumber.of(44),
                LottoNumber.of(45)
        )));

        lottos = new Lottos(lottoList);
    }

    @DisplayName("로또리스트로 구성되어있는 로또들 생성 테스트")
    @Test
    void 로또들_생성() {
        List<Lotto> lottoList = new ArrayList<>();
        LottoCreateStrategy strategy = new AutoLottoCreateStrategy();
        lottoList.add(strategy.createLotto());
        lottoList.add(strategy.createLotto());

        Lottos lottos = new Lottos(lottoList);

        assertThat(lottos).isInstanceOf(Lottos.class);
    }

    @DisplayName("로또를 추가로 발급한 경우에 대한 인터페이스 테스트")
    @Test
    void 로또_추가발급() {
        // given
        List<Lotto> lottoList = new ArrayList<>();
        LottoCreateStrategy strategy = new AutoLottoCreateStrategy();
        lottoList.add(strategy.createLotto());
        lottoList.add(strategy.createLotto());

        // when
        int beforeSize = lottos.lottos().size();
        lottos.addLottos(new Lottos(lottoList));
        int afterSize = lottos.lottos().size();

        // then
        assertThat(afterSize - lottoList.size()).isEqualTo(beforeSize);
    }

    @DisplayName("Lottos 에서 winningLotto를 입력받아 WinningResult를 반환한다")
    @Test
    void 로또결과_report() {
        WinningResult result = lottos.match(new WinningLotto(new Lotto(Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6))), LottoNumber.of(7)));
        assertThat(result.reportYield()).isEqualTo(666666.6666666666);
    }
}

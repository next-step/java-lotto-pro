package step3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Lotto;
import step3.domain.LottoNumber;
import step3.domain.LottoNumbers;
import step3.domain.Lottos;
import step3.domain.Rank;
import step3.domain.Result;

public class ResultTest {

    private Result result;

    @BeforeEach
    void setUp() {
        List<LottoNumber> lottoNumberList = Arrays.asList(new LottoNumber(1),
            new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5),
            new LottoNumber(6));
        Lottos lottos = new Lottos(Arrays.asList(new Lotto(new LottoNumbers(lottoNumberList))));
        Lotto winning = new Lotto(new LottoNumbers(lottoNumberList));
        result = new Result(lottos, winning);
    }

    @Test
    @DisplayName("당첨 통계 결과를 테스트한다.")
    void resultTest() {
        assertAll(
            () -> assertThat(result.getCountBy(Rank.FIRST)).isEqualTo(1),
            () -> assertThat(result.getCountBy(Rank.SECOND)).isEqualTo(0),
            () -> assertThat(result.getCountBy(Rank.THIRD)).isEqualTo(0),
            () -> assertThat(result.getCountBy(Rank.FOURTH)).isEqualTo(0)
        );
    }

    @Test
    @DisplayName("수익금이 정확히 나오는지 테스트한다.")
    void 수익금_결과_테스트() {
        assertThat(result.getTotalWinning()).isEqualTo(Rank.FIRST.winnings());
    }

}

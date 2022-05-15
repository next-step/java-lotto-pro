import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LotteryTest {
    @Test
    void 비교_결과_를_당첨별로_집계할_수_있다() {
        LottoNumbers winner = new LottoNumbers(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        );

        LottoNumbers lottoNumbers1 = new LottoNumbers(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        );
        LottoNumbers lottoNumbers2 = new LottoNumbers(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(43),
                new LottoNumber(44),
                new LottoNumber(45)
        );



        Lottos lottos = new Lottos();
        lottos.add(lottoNumbers1);
        lottos.add(lottoNumbers2);

        assertThat(new Lottery(winner).get(lottos))
                .containsEntry(Prize.FIRST, 1L)
                .containsEntry(Prize.FOURTH, 1L);
    }

}

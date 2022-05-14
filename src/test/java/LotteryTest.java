import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LotteryTest {
    @Test
    void 당첨번호와_비교하여_LottoNumbers_의_포함_갯수를_확인할_수_있댜() {
        LottoNumbers winner = new LottoNumbers(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        );

        LottoNumbers lottoNumbers = new LottoNumbers(
                new LottoNumber(1),
                new LottoNumber(10),
                new LottoNumber(11),
                new LottoNumber(12),
                new LottoNumber(13),
                new LottoNumber(14)
        );

        assertThat(new Lottery(winner).get(lottoNumbers)).isEqualTo(new ContainCount(1));
    }

    @Test
    void 당첨_번호와_로또_번호_여러개_를_비교할_수_있다() {
        LottoNumbers winner = new LottoNumbers(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        );

        Lottos lottos = new Lottos();
        lottos.add(new LottoNumbers(
                new LottoNumber(1),
                new LottoNumber(10),
                new LottoNumber(11),
                new LottoNumber(12),
                new LottoNumber(13),
                new LottoNumber(14)
        ));


        ContainCounts containCounts = new ContainCounts();
        containCounts.add(new ContainCount(1));
        assertThat(new Lottery(winner).get(lottos)).isEqualTo(containCounts);
    }
}

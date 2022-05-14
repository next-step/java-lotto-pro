import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LotteryTest {
    @Test
    void 당첨번호와_비교하여_포함_갯수를_확인할_수_있댜() {
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
}

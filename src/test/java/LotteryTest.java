import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LotteryTest {
    @Test
    void 당첨번호와_비교하여_몇_개의_번호가_일치하는지_확인할_수_있다() {
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



        Lotto lotto = new Lotto();
        lotto.add(lottoNumbers1);
        lotto.add(lottoNumbers2);

        assertThat(new Lottery(winner).get(lotto))
                .contains(new ContainCount(6))
                .contains(new ContainCount(3));
    }

}

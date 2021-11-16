package study.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.lotto.domain.LottoNumber;
import study.lotto.domain.LottoNumbers;
import study.lotto.domain.Rank;
import study.lotto.view.OutputView;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersTest {

    @Test
    @DisplayName("자동 생성된 로또번호들과 지난주 당첨로또번호, 보너스 볼이 주어졌을때 알맞게 랭킹을 구하는지 테스트")
    void match() {
        LottoNumbers lottoNumbers1 = new LottoNumbers("1,2,3,4,5,6");
        LottoNumbers lottoNumbers2 = new LottoNumbers("7,1,2,3,4,5");
        LottoNumbers lottoNumbers3 = new LottoNumbers("1,2,3,4,5,8");
        LottoNumbers lottoNumbers4 = new LottoNumbers("1,2,3,4,7,8");

        LottoNumbers lastLottoNumbers = new LottoNumbers("1,2,3,4,5,6");
        LottoNumber bonusBall = new LottoNumber(7);

        assertThat(lottoNumbers1.match(lastLottoNumbers, bonusBall)).isEqualTo(Rank.FIRST);
        assertThat(lottoNumbers2.match(lastLottoNumbers, bonusBall)).isEqualTo(Rank.SECOND);
        assertThat(lottoNumbers3.match(lastLottoNumbers, bonusBall)).isEqualTo(Rank.THIRD);
        assertThat(lottoNumbers4.match(lastLottoNumbers, bonusBall)).isEqualTo(Rank.FOURTH);
    }
}
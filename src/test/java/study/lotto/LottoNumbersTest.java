package study.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.lotto.domain.LottoNumber;
import study.lotto.domain.LottoNumbers;
import study.lotto.domain.Rank;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersTest {

    @Test
    void 출력형태_테스트() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        String printFormat = lottoNumbers.makeLottoNumberPrintFormat();
        assertThat(printFormat.matches("^\\[(\\d+,\\s){5}\\d+\\]$")).isTrue();
    }

    @Test
    @DisplayName("자동 생성된 로또번호들과 지난주 당첨로또번호, 보너스 볼이 주어졌을때 각각 몇개가 일치하는지 테스트")
    void match() {
        LottoNumbers lottoNumbers1 = new LottoNumbers("1,2,3,4,5,6");
        LottoNumbers lottoNumbers2 = new LottoNumbers("7,1,2,3,4,5");
        LottoNumbers lottoNumbers3 = new LottoNumbers("1,2,3,4,5,8");
        LottoNumbers lottoNumbers4 = new LottoNumbers("1,2,3,4,7,8");

        LottoNumbers lastLottoNumbers = new LottoNumbers("1,2,3,4,5,6");
        LottoNumber bonusBall = new LottoNumber(7);

        lottoNumbers1.match(lastLottoNumbers, bonusBall);
        lottoNumbers2.match(lastLottoNumbers, bonusBall);
        lottoNumbers3.match(lastLottoNumbers, bonusBall);
        lottoNumbers4.match(lastLottoNumbers, bonusBall);

        assertThat(Rank.FIRST.getCorrect()).isEqualTo(1);
        assertThat(Rank.SECOND.getCorrect()).isEqualTo(1);
        assertThat(Rank.THIRD.getCorrect()).isEqualTo(1);
        assertThat(Rank.FOURTH.getCorrect()).isEqualTo(1);
        assertThat(Rank.FIFTH.getCorrect()).isEqualTo(0);
    }
}
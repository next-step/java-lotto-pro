package study.lottoAuto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersTest {

    @Test
    @DisplayName("1~45의 숫자로 구성된 6개의 숫자 그룹을 만드는 테스트")
    void 생성_테스트() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        assertThat(lottoNumbers.getLottoNumbers()).isSorted();
        assertThat(lottoNumbers.getLottoNumbers().size()).isEqualTo(6);

        //각 원소들이 서로 다른지 어떻게 테스트 해보지...?
    }
    
    @Test
    void 출력형태_테스트() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        String printFormat = lottoNumbers.makeLottoNumberPrintFormat();
        assertThat(printFormat.matches("")).isTrue();
    }

    @Test
    @DisplayName("로또숫자 두 그룹 사이에 몇개가 일치하는지 테스트")
    void getMatchCount() {
        LottoNumbers lottoNumbers = new LottoNumbers("3,11,14,15,23,33");
        LottoNumbers lottoNumbers2 = new LottoNumbers("3,13,19,29,31,33");

        assertThat(lottoNumbers.getMatchCount(lottoNumbers2)).isEqualTo(2);
    }

}
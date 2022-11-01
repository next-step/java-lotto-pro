package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoResultTest {

  @DisplayName("로또 당첨 결과가 정상적으로 나오는지 확인")
  @ParameterizedTest(name = "당첨 로또 번호: {0}, 소유한 로또 번호: {1} 일 떄 등수결과: {2} 확인")
  @CsvSource(value = {
      "4,5,6,7,8,9 : 7 : 1,2,3,4,5,6 : 3개 일치 (5000원)- 1개",
      "3,4,5,6,7,8 : 7 : 1,2,3,4,5,6 : 4개 일치 (50000원)- 1개",
      "2,3,4,5,6,8 : 7 : 1,2,3,4,5,6 : 5개 일치 (1500000원)- 1개",
      "2,3,4,5,6,7 : 1 : 1,2,3,4,5,6 : 5개 일치, 보너스 볼 일치 (30000000원)- 1개",
      "1,2,3,4,5,6 : 7 : 1,2,3,4,5,6 : 6개 일치 (2000000000원)- 1개",
  }, delimiter = ':')
  void lotto_result(String winningLottoNumbers, String bonusNumber, String lottoNumbers,
      String lottoRankResult) {
    //given
    LottoList lottoList = new LottoList(
        Arrays.asList(
            Lotto.createManualLotto(Arrays.asList(1, 2, 3, 4, 5, 6))
        )
    );
    WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, bonusNumber);

    //when
    LottoResult result = new LottoResult(lottoList, winningLotto);

    System.out.println(result.convertResultMapToString());

    //then
    assertThat(result.convertResultMapToString()).containsExactly(lottoRankResult);
  }

  @DisplayName("로또 당첨 수익률이 정상적으로 나오는지 확인")
  @ParameterizedTest(name = "당첨 로또 번호: {0}, 소유한 로또 번호: {1} 일 떄 수익률 결과: {2} 확인")
  @CsvSource(value = {
      "4,5,6,7,8,9 : 7 : 1,2,3,4,5,6 : 총 수익률은 5.0입니다.",
      "3,4,5,6,7,8 : 7 : 1,2,3,4,5,6 : 총 수익률은 50.0입니다.",
      "2,3,4,5,6,8 : 7 : 1,2,3,4,5,6 : 총 수익률은 1500.0입니다.",
      "2,3,4,5,6,7 : 1 : 1,2,3,4,5,6 : 총 수익률은 30000.0입니다.",
      "1,2,3,4,5,6 : 7 : 1,2,3,4,5,6 : 총 수익률은 2000000.0입니다.",
  }, delimiter = ':')
  void lotto_yield_result(String winningLottoNumbers, String bonusNumber, String lottoNumbers,
      String lottoRankResult) {
    //given
    LottoList lottoList = new LottoList(
        Arrays.asList(
            Lotto.createManualLotto(Arrays.asList(1, 2, 3, 4, 5, 6))
        )
    );
    WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, bonusNumber);

    //when
    LottoResult result = new LottoResult(lottoList, winningLotto);

    System.out.println(result.convertResultMapToString());

    //then
    assertThat(result.convertYieldToString()).isEqualTo(lottoRankResult);
  }


}

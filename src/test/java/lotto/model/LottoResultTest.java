package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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

  @Test
  void 로또_일치_통계() {
    //given
    LottoList lottoList = new LottoList(
        Arrays.asList(
            Lotto.createManualLotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
            Lotto.createManualLotto(Arrays.asList(2, 3, 4, 5, 6, 8)),
            Lotto.createManualLotto(Arrays.asList(3, 11, 15, 18, 22, 32)),
            Lotto.createManualLotto(Arrays.asList(4, 24, 32, 37, 42, 45))
        )
    );

    WinningLotto winningLotto = new WinningLotto("2, 3, 4, 5, 6, 7", "8");

    //when
    List<String> result = new LottoResult(lottoList, winningLotto).convertResultMapToString();

    System.out.println(result.get(0));

    //then
    assertThat(result.contains("5개 일치 (1500000원)- 1개")).isTrue();
  }

  @Test
  void 로또_수익률_수익() {
    //given
    LottoList lottoList = new LottoList(
        Arrays.asList(
            Lotto.createManualLotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
            Lotto.createManualLotto(Arrays.asList(3, 11, 15, 18, 22, 32)),
            Lotto.createManualLotto(Arrays.asList(4, 24, 32, 37, 42, 45))
        )
    );

    WinningLotto winningLotto = new WinningLotto("2, 3, 4, 5, 6, 7", "8");

    //when
    String result = new LottoResult(lottoList, winningLotto).convertYieldToString();

    //then
    assertThat(result).isEqualTo("총 수익률은 500.0입니다.");
  }

  @Test
  void 로또_수익률_손해() {
    //given
    LottoList lottoList = new LottoList(
        Arrays.asList(
            Lotto.createManualLotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
            Lotto.createManualLotto(Arrays.asList(3, 11, 15, 18, 22, 32)),
            Lotto.createManualLotto(Arrays.asList(4, 24, 32, 37, 42, 45))
        )
    );

    WinningLotto winningLotto = new WinningLotto("6, 10, 20, 41, 43, 44");

    //when
    String result = new LottoResult(lottoList, winningLotto).convertYieldToString();

    //then
    assertThat(result).isEqualTo("총 수익률은 0.0입니다.(기준이 1이기 떄문에 결과적으로 손해라는 의미임)");
  }


}

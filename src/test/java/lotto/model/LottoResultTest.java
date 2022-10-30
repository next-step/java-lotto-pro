package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class LottoResultTest {


  @Test
  void 로또_일치_통계() {
    //given
    LottoList lottoList = new LottoList(
        Arrays.asList(
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
            new Lotto(Arrays.asList(3, 11, 15, 18, 22, 32)),
            new Lotto(Arrays.asList(4, 24, 32, 37, 42, 45))
        )
    );

    WinningLotto winningLotto = new WinningLotto("2, 3, 4, 5, 6, 7");

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
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
            new Lotto(Arrays.asList(3, 11, 15, 18, 22, 32)),
            new Lotto(Arrays.asList(4, 24, 32, 37, 42, 45))
        )
    );

    WinningLotto winningLotto = new WinningLotto("2, 3, 4, 5, 6, 7");

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
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
            new Lotto(Arrays.asList(3, 11, 15, 18, 22, 32)),
            new Lotto(Arrays.asList(4, 24, 32, 37, 42, 45))
        )
    );

    WinningLotto winningLotto = new WinningLotto("6,10, 20 41, 43, 44");

    //when
    String result = new LottoResult(lottoList, winningLotto).convertYieldToString();

    //then
    assertThat(result).isEqualTo("총 수익률은 0.0입니다.(기준이 1이기 떄문에 결과적으로 손해라는 의미임)");
  }


}

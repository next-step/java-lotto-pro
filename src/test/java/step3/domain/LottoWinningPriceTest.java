package step3.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoWinningPriceTest {

  private static Stream<Arguments> generateMatchCountList() {
    List<Arguments> listOfArguments = new LinkedList<>();
    // matchCount number, price
    listOfArguments.add(Arguments.of(Arrays.asList(1, 1, 1, 0, 0, 0, 0), 0));
    listOfArguments.add(Arguments.of(Arrays.asList(0, 0, 0, 1, 0, 0, 0), 5000));
    listOfArguments.add(Arguments.of(Arrays.asList(0, 0, 0, 0, 1, 0, 0), 50_000));
    listOfArguments.add(Arguments.of(Arrays.asList(0, 0, 0, 0, 0, 1, 0), 1_500_000));
    listOfArguments.add(Arguments.of(Arrays.asList(0, 0, 0, 0, 0, 0, 1), 2_000_000_000));
    listOfArguments.add(Arguments.of(Arrays.asList(0, 0, 0, 1, 1, 1, 1), 2_001_555_000));
    return listOfArguments.stream();
  }

  @ParameterizedTest
  @MethodSource("generateMatchCountList")
  void lottoWinningPriceTest(List<Integer> matchCountNums, int expectedPrice) {

    LottoMatchResult lottoMatchResult = new LottoMatchResult() {
      @Override
      public int getMatchCountNum(LottoMatchCaseEnum matchCaseEnum) {
        return matchCountNums.get(matchCaseEnum.getMatchCount());
      }
    };

    LottoWinningPrice lottoWinningPrice = lottoMatchResult.getLottoWinningPrice();
    assertEquals(expectedPrice, lottoWinningPrice.getWinningPrice());
  }


}

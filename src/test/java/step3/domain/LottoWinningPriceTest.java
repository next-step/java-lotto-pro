package step3.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static step3.domain.LottoMatchCaseEnum.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoWinningPriceTest {

  private static Stream<Arguments> generateMatchCountList() {
    List<Arguments> listOfArguments = new LinkedList<>();
    // matchCount number, price
    listOfArguments.add(Arguments.of(new HashMap<LottoMatchCaseEnum, Integer>() {{
        put(ZERO_NUMBER_MATCH, 1);
        put(ONE_NUMBER_MATCH, 1);
        put(TWO_NUMBERS_MATCH, 1);
    }}, 0));
    listOfArguments.add(Arguments.of(new HashMap<LottoMatchCaseEnum, Integer>() {{
        put(THREE_NUMBERS_MATCH, 1);
    }}, 5000));
    listOfArguments.add(Arguments.of(new HashMap<LottoMatchCaseEnum, Integer>() {{
        put(FOUR_NUMBERS_MATCH, 1);
    }}, 50_000));
    listOfArguments.add(Arguments.of(new HashMap<LottoMatchCaseEnum, Integer>() {{
        put(FIVE_NUMBERS_MATCH, 1);
    }}, 1_500_000));
    listOfArguments.add(Arguments.of(new HashMap<LottoMatchCaseEnum, Integer>() {{
        put(FIVE_NUMBERS_AND_BONUS_MATCH, 1);
    }}, 30_000_000));
    listOfArguments.add(Arguments.of(new HashMap<LottoMatchCaseEnum, Integer>() {{
        put(SIX_NUMBERS_MATCH, 1);
    }}, 2_000_000_000));
    listOfArguments.add(Arguments.of(new HashMap<LottoMatchCaseEnum, Integer>() {{
        put(THREE_NUMBERS_MATCH, 3);
        put(FOUR_NUMBERS_MATCH, 2);
    }}, 115_000));
    listOfArguments.add(Arguments.of(new HashMap<LottoMatchCaseEnum, Integer>() {{
        put(FOUR_NUMBERS_MATCH, 1);
        put(FIVE_NUMBERS_MATCH, 1);
        put(SIX_NUMBERS_MATCH, 1);
    }}, 2_001_550_000));
    return listOfArguments.stream();
  }

  @ParameterizedTest
  @MethodSource("generateMatchCountList")
  void lottoWinningPriceTest(Map<LottoMatchCaseEnum, Integer> matchCountMap, int expectedPrice) {

    LottoMatchResult lottoMatchResult = new LottoMatchResult() {
      @Override
      public int getMatchCountNum(LottoMatchCaseEnum matchCaseEnum) {
          Integer matchCount = matchCountMap.get(matchCaseEnum);
          return matchCount != null ? matchCount : 0;
      }
    };

    Money lottoWinningPrice = lottoMatchResult.getLottoWinningPrice();
    assertEquals(expectedPrice, lottoWinningPrice.getPrice());
  }


}

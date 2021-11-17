package step3.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoMatchResultTest {

  private LottoTicket winningTicket;

  private static Stream<Arguments> generateNumberList() {
    List<Arguments> listOfArguments = new LinkedList<>();
    listOfArguments.add(Arguments
        .of(Arrays.asList(1, 4, 27, 38, 40, 41), LottoMatchCaseEnum.FIVE_NUMBERS_MATCH));
    listOfArguments.add(Arguments
        .of(Arrays.asList(3, 4, 26, 27, 38, 45), LottoMatchCaseEnum.FOUR_NUMBERS_MATCH));
    listOfArguments.add(Arguments
        .of(Arrays.asList(1, 2, 9, 11, 28, 41), LottoMatchCaseEnum.ONE_NUMBER_MATCH));
    listOfArguments.add(Arguments
        .of(Arrays.asList(4, 15, 26, 27, 38, 40), LottoMatchCaseEnum.FIVE_NUMBERS_MATCH));
    listOfArguments.add(Arguments
        .of(Arrays.asList(4, 26, 27, 38, 40, 45), LottoMatchCaseEnum.FIVE_NUMBERS_AND_BONUS_MATCH));
    return listOfArguments.stream();
  }

  @BeforeEach
  void setUp() {
    winningTicket = new LottoTicket(Stream.of(1, 4, 26, 27, 38, 40)
        .map(LottoNumber::new)
        .collect(Collectors.toList()),
        new LottoNumber(45));
  }

  @ParameterizedTest
  @MethodSource("generateNumberList")
  @DisplayName("로또 숫자 매치 케이스_단위 테스트")
  void lottoMatchCountResult_unitTest(List<Integer> numbers, LottoMatchCaseEnum matchCase) {
    LottoTicket lottoTicket = new LottoTicket(numbers.stream()
        .map(LottoNumber::new)
        .collect(Collectors.toList()));

    assertEquals(matchCase, LottoTickets.calculateMatchCase(lottoTicket, winningTicket));
  }

  @Test
  @DisplayName("로또 숫자 매치 케이스_1Ticket, 4Number match")
  void lottoMatchResult_1Ticket4NumberMatch() {
    LottoTicket myTicket = new LottoTicket(Stream.of(3, 4, 26, 27, 38, 45)
        .map(LottoNumber::new)
        .collect(Collectors.toList()));
    LottoTickets myLottoTickets = new LottoTickets(Collections.singletonList(myTicket));
    LottoMatchResult lottoMatchResult = myLottoTickets.matchWinningNumbers(winningTicket);

    assertEquals(0, lottoMatchResult.getMatchCountNum(LottoMatchCaseEnum.THREE_NUMBERS_MATCH));
    assertEquals(1, lottoMatchResult.getMatchCountNum(LottoMatchCaseEnum.FOUR_NUMBERS_MATCH));
    assertEquals(0, lottoMatchResult.getMatchCountNum(LottoMatchCaseEnum.FIVE_NUMBERS_MATCH));
    assertEquals(0, lottoMatchResult.getMatchCountNum(LottoMatchCaseEnum.SIX_NUMBERS_MATCH));
  }

  @Test
  @DisplayName("로또 숫자 매치 케이스_1Ticket-2Number, 2Ticket-4Number match each")
  void lottoMatchResult_2Ticket4NumberMatch() {
    LottoTicket myTicket1 = new LottoTicket(Stream.of(3, 4, 26, 27, 38, 45)
        .map(LottoNumber::new)
        .collect(Collectors.toList()));
    LottoTicket myTicket2 = new LottoTicket(Stream.of(4, 27, 27, 38, 39, 45)
        .map(LottoNumber::new)
        .collect(Collectors.toList()));
    LottoTicket myTicket3 = new LottoTicket(Stream.of(4, 8, 29, 30, 31, 42)
        .map(LottoNumber::new)
        .collect(Collectors.toList()));
    LottoTickets myLottoTickets = new LottoTickets(Arrays.asList(myTicket1, myTicket2, myTicket3));
    LottoMatchResult lottoMatchResult = myLottoTickets.matchWinningNumbers(winningTicket);

    assertEquals(0, lottoMatchResult.getMatchCountNum(LottoMatchCaseEnum.THREE_NUMBERS_MATCH));
    assertEquals(2, lottoMatchResult.getMatchCountNum(LottoMatchCaseEnum.FOUR_NUMBERS_MATCH));
    assertEquals(0, lottoMatchResult.getMatchCountNum(LottoMatchCaseEnum.FIVE_NUMBERS_MATCH));
    assertEquals(0, lottoMatchResult.getMatchCountNum(LottoMatchCaseEnum.SIX_NUMBERS_MATCH));
  }
}

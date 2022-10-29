package lotto.model.lotto.ticket;

import lotto.constant.numbers.LottoConstant;
import lotto.model.winning.numbers.WinningNumberEach;
import lotto.model.winning.numbers.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoTicketsBucketTest {
    static class LottoTicketsBucketForTest extends LottoTicketsBucket {
        public LottoTicketsBucketForTest(int howManyTickets) {
            super(howManyTickets);
        }

        public LottoTicketsBucketForTest(List<LottoTicket> lottoTickets) {
            super(lottoTickets);
        }

        int bucketSize() {
            return lottoTickets.size();
        }
    }

    @Nested
    @DisplayName("LottoTicketsBucket 생성자 테스트")
    class Constructor {
        @ParameterizedTest
        @ValueSource(ints = {1, 2, 13, 597, 2000})
        @DisplayName("LottoTicketsBucket 클래스 생성자 실행 결과, 생성자에 야규먼트로 전달한 개수 만큼 로또 티켓을 만든다")
        void constructor(int numberOfTickets) {
            final LottoTicketsBucketForTest lottoTicketsBucketForTest = new LottoTicketsBucketForTest(numberOfTickets);
            for (int i = 0; i < numberOfTickets; ++i) {
                final List<Integer> candidates = intsFromOneToFortyFive();
                final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator(candidates);
                lottoTicketsBucketForTest.addLottoTicket(new LottoTicket(lottoNumberGenerator));
            }
            assertThat(lottoTicketsBucketForTest.bucketSize()).isEqualTo(numberOfTickets);
        }

        private List<Integer> intsFromOneToFortyFive() {
            final List<Integer> fullCandidateList = new ArrayList<>(LottoConstant.LOTTO_MAXIMUM_NUMBER);
            for (int i = LottoConstant.LOTTO_MINIMUM_NUMBER; i <= LottoConstant.LOTTO_MAXIMUM_NUMBER; ++i) {
                fullCandidateList.add(i);
            }
            return fullCandidateList;
        }
    }

    @Nested
    @DisplayName("addLottoTicket 메서드 테스트")
    class AddLottoTicket {
        @Test
        @DisplayName("LottoTicket 객체 추가 성공")
        void success() {
            final int numberOfLottoTickets = 3;
            final LottoTicketsBucketForTest lottoTicketsBucketForTest = new LottoTicketsBucketForTest(0);
            for (int i = 0; i < numberOfLottoTickets; ++i) {
                final List<Integer> candidates = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
                final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator(candidates);
                lottoTicketsBucketForTest.addLottoTicket(new LottoTicket(lottoNumberGenerator));
            }
            assertThat(lottoTicketsBucketForTest.bucketSize()).isEqualTo(numberOfLottoTickets);
        }
    }

    @Nested
    @DisplayName("sameNumberCountOfAllLottoTickets 메서드 테스트")
    class SameNumberCountOfAllLottoTickets {

        private final WinningNumbers winningNumbers;

        SameNumberCountOfAllLottoTickets() {
            final List<WinningNumberEach> numberEachList = new ArrayList<>(Arrays.asList(
                    new WinningNumberEach(1),
                    new WinningNumberEach(2),
                    new WinningNumberEach(3),
                    new WinningNumberEach(4),
                    new WinningNumberEach(5),
                    new WinningNumberEach(6)
            ));
            winningNumbers = new WinningNumbers(numberEachList);
        }

        @Test
        @DisplayName("6개 일치 6명")
        void countSixSameEqualsSix() {
            final List<LottoTicket> lottoTickets = new ArrayList<>(Arrays.asList(
                    new LottoTicket(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))),
                    new LottoTicket(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))),
                    new LottoTicket(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))),
                    new LottoTicket(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))),
                    new LottoTicket(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))),
                    new LottoTicket(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)))
            ));
            final LottoTicketsBucketForTest lottoTicketsBucketForTest = new LottoTicketsBucketForTest(lottoTickets);
            final int[] countAll = lottoTicketsBucketForTest.sameNumberCountOfAllLottoTickets(winningNumbers);
            assertAll(
                    () -> assertThat(countAll[0]).isEqualTo(0),
                    () -> assertThat(countAll[1]).isEqualTo(0),
                    () -> assertThat(countAll[2]).isEqualTo(0),
                    () -> assertThat(countAll[3]).isEqualTo(0),
                    () -> assertThat(countAll[4]).isEqualTo(0),
                    () -> assertThat(countAll[5]).isEqualTo(0),
                    () -> assertThat(countAll[6]).isEqualTo(6)
            );
        }

        @Test
        @DisplayName("3개 일치, 4개 일치, 5개 일치, 6개 일치 각각 1명 씩")
        void countThreeOneCountFourOneCountFiveOneCountSixOne() {
            final List<LottoTicket> lottoTickets = new ArrayList<>(Arrays.asList(
                    new LottoTicket(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))),
                    new LottoTicket(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 16))),
                    new LottoTicket(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 25, 16))),
                    new LottoTicket(new ArrayList<>(Arrays.asList(1, 2, 3, 44, 25, 16)))
            ));
            final LottoTicketsBucketForTest lottoTicketsBucketForTest = new LottoTicketsBucketForTest(lottoTickets);
            final int[] countAll = lottoTicketsBucketForTest.sameNumberCountOfAllLottoTickets(winningNumbers);
            assertAll(
                    () -> assertThat(countAll[0]).isEqualTo(0),
                    () -> assertThat(countAll[1]).isEqualTo(0),
                    () -> assertThat(countAll[2]).isEqualTo(0),
                    () -> assertThat(countAll[3]).isEqualTo(1),
                    () -> assertThat(countAll[4]).isEqualTo(1),
                    () -> assertThat(countAll[5]).isEqualTo(1),
                    () -> assertThat(countAll[6]).isEqualTo(1)
            );
        }
    }

    @DisplayName("sumProfit 메서드 테스트")
    static class SumProfit {
        @ParameterizedTest
        @MethodSource(value = "sumProfitSources")
        @DisplayName("당첨금 수익 총 합 구하기")
        void success(int[] sameCount, int sumResult) {
            final LottoTicketsBucket lottoTicketsBucket = new LottoTicketsBucket(sameCount);
            final int sum = lottoTicketsBucket.sumProfit();
            assertThat(sum).isEqualTo(sumResult);
        }

        private static Stream<Arguments> sumProfitSources() {
            return Stream.of(
                    Arguments.of(
                            new int[]{0, 0, 0, 0, 0, 0, 0},
                            0
                    ),
                    Arguments.of(
                            new int[]{0, 0, 0, 0, 0, 0, 1},
                            LottoConstant.PROFIT_SIX_DIGITS_MATCH * 1
                    ),
                    Arguments.of(
                            new int[]{0, 0, 0, 0, 0, 0, 5},
                            LottoConstant.PROFIT_SIX_DIGITS_MATCH * 5
                    ),
                    Arguments.of(
                            new int[]{0, 0, 0, 1, 1, 1, 0},
                            LottoConstant.PROFIT_THREE_DIGITS_MATCH * 1 + LottoConstant.PROFIT_FOUR_DIGITS_MATCH * 1 + LottoConstant.PROFIT_FIVE_DIGITS_MATCH * 1
                    ),
                    Arguments.of(
                            new int[]{0, 0, 0, 3, 0, 2, 0},
                            LottoConstant.PROFIT_THREE_DIGITS_MATCH * 3 + LottoConstant.PROFIT_FIVE_DIGITS_MATCH * 2
                    ),
                    Arguments.of(
                            new int[]{0, 0, 0, 1, 2, 4, 0},
                            LottoConstant.PROFIT_THREE_DIGITS_MATCH * 1 + LottoConstant.PROFIT_FOUR_DIGITS_MATCH * 2 + LottoConstant.PROFIT_FIVE_DIGITS_MATCH * 4
                    )
            );
        }
    }
}

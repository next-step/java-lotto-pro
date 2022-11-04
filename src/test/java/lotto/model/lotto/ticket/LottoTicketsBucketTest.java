package lotto.model.lotto.ticket;

import lotto.controller.converter.WinningNumbersConverter;
import lotto.model.lotto.enums.LottoNumberMatchCount;
import lotto.model.winning.numbers.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoTicketsBucketTest {
    static class LottoTicketsBucketForTest extends LottoTicketsBucket {
        public LottoTicketsBucketForTest(int howManyTickets) {
            super(howManyTickets);
        }

        int bucketSize() {
            return lottoTickets.size();
        }
    }

    @Nested
    @DisplayName("LottoTicketsBucket 생성자 테스트")
    class ConstructorInt {
        @ParameterizedTest
        @ValueSource(ints = {0, 1, 2, 13, 597, 2000})
        @DisplayName("LottoTicketsBucket 클래스 생성자 실행 결과, 생성자에 야규먼트로 전달한 개수 만큼 로또 티켓을 만든다")
        void success(int numberOfTickets) {
            assertDoesNotThrow(() -> new LottoTicketsBucket(numberOfTickets));
        }

        @ParameterizedTest
        @ValueSource(ints = {Integer.MIN_VALUE, -987654321, -771, -19, -2, -1})
        @DisplayName("LottoTicketsBucket 클래스 생성자 실행 결과, 생성자에 야규먼트로 전달한 개수 만큼 로또 티켓을 만든다")
        void errorInvalidNumberOfTickets(int numberOfTickets) {
            assertThrows(IllegalStateException.class, () -> new LottoTicketsBucket(numberOfTickets));
        }
    }

    @Nested
    @DisplayName("addLottoTicket 메서드 테스트")
    class AddLottoTicket {
        @ParameterizedTest
        @ValueSource(ints = {0, 1, 2, 13, 597, 2000})
        @DisplayName("지정한 개수만큼 addLottoTicket 호출하면 lottoTickets 멤버 변수의 size 가 지정한 개수가 되어야 한다.")
        void success(int numberOfTickets) {
            final LottoTicketsBucketForTest lottoTicketsBucket = new LottoTicketsBucketForTest(numberOfTickets);
            final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
            int numberCount = numberOfTickets;
            while (0 < numberCount) {
                lottoTicketsBucket.addLottoTicket(new LottoTicket(lottoNumberGenerator));
                numberCount = numberCount - 1;
            }
            assertThat(lottoTicketsBucket.bucketSize()).isEqualTo(numberOfTickets);
        }
    }

    static class LottoTicketsBucketForTest2 extends LottoTicketsBucket {
        public LottoTicketsBucketForTest2(int howManyTickets) {
            super(howManyTickets);
        }
    }

    @Nested
    @DisplayName("incrementCountWhenNumbersMatchIsOneOfTheCandidates 메서드 테스트")
    class IncrementCountWhenNumbersMatchIsOneOfTheCandidates {
        private final LottoTicketsBucketForTest2 lottoTicketsBucketForTest2;
        private final List<LottoNumberMatchCount> numbersMatchCandidates;
        private final int numbersMatch;
        private final Map<LottoNumberMatchCount, Integer> numbersMatchCount;

        IncrementCountWhenNumbersMatchIsOneOfTheCandidates() {
            final int anyNumber = 3;
            lottoTicketsBucketForTest2 = new LottoTicketsBucketForTest2(anyNumber);
            numbersMatchCandidates = new ArrayList<>(Arrays.asList(LottoNumberMatchCount.THREE,
                    LottoNumberMatchCount.FOUR, LottoNumberMatchCount.FIVE, LottoNumberMatchCount.SIX));
            numbersMatch = 3;
            numbersMatchCount = new HashMap<>();
        }

        @ParameterizedTest
        @ValueSource(ints = {3, 4, 5, 6})
        @DisplayName("일치하는 번호 개수에 따라서 numbersMatchCount 맵의 값(value) 변경하는 데 성공")
        void success(int numbersMatch) {
            // arrange
            final LottoNumberMatchCount matchCountEnum = convertToEnum(numbersMatch);
            final int prevNumbersMatch = 3;
            numbersMatchCount.put(matchCountEnum, prevNumbersMatch);

            // act
            lottoTicketsBucketForTest2.incrementCountWhenNumbersMatchIsOneOfTheCandidates(numbersMatchCandidates,
                    matchCountEnum, numbersMatchCount);

            // assert
            assertThat(numbersMatchCount.get(matchCountEnum)).isEqualTo(prevNumbersMatch + 1);
        }

        private LottoNumberMatchCount convertToEnum(int numbersMatch) {
            if (numbersMatch == 3) {
                return LottoNumberMatchCount.THREE;
            }
            if (numbersMatch == 4) {
                return LottoNumberMatchCount.FOUR;
            }
            if (numbersMatch == 5) {
                return LottoNumberMatchCount.FIVE;
            }
            return LottoNumberMatchCount.SIX;
        }
    }

    static class LottoTicketsBucketForTest3 extends LottoTicketsBucket {
        public LottoTicketsBucketForTest3(int howManyTickets) {
            super(howManyTickets);
        }

        protected LottoTicketsBucketForTest3(List<LottoTicket> lottoTickets) {
            super(lottoTickets);
        }
    }

    static class LottoNumberGeneratorForTest extends LottoNumberGenerator {
        private static final List<List<LottoNumber>> list = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(
                        new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5),
                        new LottoNumber(6)
                )),
                new ArrayList<>(Arrays.asList(
                        new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5),
                        new LottoNumber(11)
                )),
                new ArrayList<>(Arrays.asList(
                        new LottoNumber(11),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5),
                        new LottoNumber(6)
                )),
                new ArrayList<>(Arrays.asList(
                        new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(33),
                        new LottoNumber(22),
                        new LottoNumber(11)
                ))
        ));
        private final int index;

        LottoNumberGeneratorForTest(int index) {
            this.index = index;
        }

        @Override
        public List<LottoNumber> generate() {
            return list.get(index);
        }
    }

    @Nested
    @DisplayName("CalculateNumbersMatchCount 메서드 테스트")
    class CalculateNumbersMatchCount {
        @Test
        @DisplayName("성공")
        void success() {
            final int numberOfTickets = 4;
            final LottoTicketsBucket lottoTicketsBucket = new LottoTicketsBucketForTest3(numberOfTickets);
            for (int i = 0; i < numberOfTickets; ++i) {
                final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGeneratorForTest(i);
                lottoTicketsBucket.addLottoTicket(new LottoTicket((lottoNumberGenerator)));
            }
            final Map<LottoNumberMatchCount, Integer> prizeMoney = new HashMap<>();
            prizeMoney.put(LottoNumberMatchCount.THREE, 5000);
            prizeMoney.put(LottoNumberMatchCount.FOUR, 50000);
            prizeMoney.put(LottoNumberMatchCount.FIVE, 150000);
            prizeMoney.put(LottoNumberMatchCount.SIX, 2000000000);
            final WinningNumbersConverter winningNumbersConverter = new WinningNumbersConverter("1, 2, 3, 4, 5, 6");
            final WinningNumbers winningNumbers = new WinningNumbers(winningNumbersConverter.convertToLottoNumbers());
            final Map<LottoNumberMatchCount, Integer> result = lottoTicketsBucket.calculateNumbersMatchCount(prizeMoney,
                    winningNumbers);
            assertAll(
                    () -> assertThat(result.get(LottoNumberMatchCount.THREE)).isEqualTo(1),
                    () -> assertThat(result.get(LottoNumberMatchCount.FOUR)).isEqualTo(0),
                    () -> assertThat(result.get(LottoNumberMatchCount.FIVE)).isEqualTo(2),
                    () -> assertThat(result.get(LottoNumberMatchCount.SIX)).isEqualTo(1)
            );
        }
    }
}

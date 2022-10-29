package lotto.model.lotto.ticket;

import lotto.constant.numbers.LottoConstant;
import lotto.model.winning.numbers.WinningNumberEach;
import lotto.model.winning.numbers.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {
    static class LottoTicketForTest extends LottoTicket {
        public LottoTicketForTest(LottoNumberGenerator lottoNumberGenerator) {
            super(lottoNumberGenerator);
        }

        Set<Integer> numberMadeSet() {
            return new HashSet<>(numbers);
        }

        List<Integer> numbers() {
            return numbers;
        }
    }

    @Nested
    @DisplayName("LottoTicket 생성자 테스트")
    class Constructor {
        @RepeatedTest(value = 100)
        @DisplayName("한 장의 로또에 있는 숫자는 총 6개이고, 어떤 숫자도 서로 중복이 없다")
        void success() {
            final List<Integer> candidates = intsFromOneToFortyFive();
            final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator(candidates);
            final LottoTicketForTest lottoTicketForTest = new LottoTicketForTest(lottoNumberGenerator);
            final Set<Integer> numberSet = lottoTicketForTest.numberMadeSet();
            assertThat(numberSet.size()).isEqualTo(lottoTicketForTest.numbers().size());
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
    @DisplayName("sameNumbersCount 메서드 테스트")
    class SameNumbersCount {

        private final WinningNumbers winningNumbers;

        SameNumbersCount() {
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
        @DisplayName("6개 같은 경우")
        void sameCountSix() {
            // arrange
            final List<Integer> lottoNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
            final LottoTicket lottoTicket = new LottoTicket(lottoNumbers);

            // act
            final int countResult = lottoTicket.sameNumbersCount(winningNumbers);

            // assert
            assertThat(countResult).isEqualTo(6);
        }

        @Test
        @DisplayName("5개 같은 경우")
        void sameCountFive() {
            // arrange
            final List<Integer> lottoNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 16));
            final LottoTicket lottoTicket = new LottoTicket(lottoNumbers);

            // act
            final int countResult = lottoTicket.sameNumbersCount(winningNumbers);

            // assert
            assertThat(countResult).isEqualTo(5);
        }

        @Test
        @DisplayName("4개 같은 경우")
        void sameCountFour() {
            // arrange
            final List<Integer> lottoNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 25, 16));
            final LottoTicket lottoTicket = new LottoTicket(lottoNumbers);

            // act
            final int countResult = lottoTicket.sameNumbersCount(winningNumbers);

            // assert
            assertThat(countResult).isEqualTo(4);
        }

        @Test
        @DisplayName("3개 같은 경우")
        void sameCountThree() {
            // arrange
            final List<Integer> lottoNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 44, 25, 16));
            final LottoTicket lottoTicket = new LottoTicket(lottoNumbers);

            // act
            final int countResult = lottoTicket.sameNumbersCount(winningNumbers);

            // assert
            assertThat(countResult).isEqualTo(3);
        }
    }
}

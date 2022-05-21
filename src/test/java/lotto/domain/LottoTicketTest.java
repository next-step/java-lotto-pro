package lotto.domain;

import calculator.utils.Splitter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottoTicketTest {
    @DisplayName("6자리가 아닐 경우 오류가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "1,2,3", "1,2,3,4,5,6,7"})
    void checkExceptionWithNoneSixNumbers(String numbers) {
        assertAll(
            () -> assertThatThrownBy(() -> {
                    List<LottoNumber> lottoNumbers = new ArrayList<>();
                    for (String strNumber : Splitter.splitString(numbers)) {
                        lottoNumbers.add(new LottoNumber(Integer.parseInt(strNumber)));
                    }

                    new LottoTicket(lottoNumbers);
                }
            ).isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("중복되는 숫자가 있을 경우 오류가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,5", "1,1,1,2,3,4", "6,6,6,6,6,6"})
    void checkExceptionWithDuplicatedNumbers(String numbers) {
        assertAll(
            () -> assertThatThrownBy(() -> {
                    List<LottoNumber> lottoNumbers = new ArrayList<>();
                    for (String strNumber : Splitter.splitString(numbers)) {
                        lottoNumbers.add(new LottoNumber(Integer.parseInt(strNumber)));
                    }

                    new LottoTicket(lottoNumbers);
                }
            ).isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("6자리일 경우 값이 정상적으로 생성된다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:6", "1,20,21,33,36,45:6"}, delimiter = ':')
    void checkSixNumbers(String numbers, int size) {
        assertAll(
            () -> {
                List<LottoNumber> lottoNumbers = new ArrayList<>();
                for (String number : Splitter.splitString(numbers)) {
                    lottoNumbers.add(new LottoNumber(Integer.parseInt(number)));
                }
                assertThat(new LottoTicket(lottoNumbers).getLottoTicket().size()).isEqualTo(size);
            }
        );
    }

    @Test
    @DisplayName("로또 당첨번호와 일치하는 개수를 응답한다.")
    void checkMatch() {
        List<LottoNumber> userLottoNumbers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            userLottoNumbers.add(new LottoNumber(i + 1));
        }
        List<LottoNumber> rankLottoTicket = new ArrayList<>(userLottoNumbers);

        LottoTicket ticket = new LottoTicket(userLottoNumbers);
        assertThat(ticket.match(new LottoTicket(rankLottoTicket))).isEqualTo(6);
    }

    @Test
    @DisplayName("구매한 로또 번호에 당첨번호가 포함되어 있다.")
    void checkContainsTrue() {
        List<LottoNumber> userLottoNumbers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            userLottoNumbers.add(new LottoNumber(i + 1));
        }
        LottoTicket ticket = new LottoTicket(userLottoNumbers);
        assertThat(ticket.contains(new LottoNumber(3))).isTrue();
    }

    @Test
    @DisplayName("구매한 로또 번호에 당첨번호가 포함되어있지 않다.")
    void checkContainsFalse() {
        List<LottoNumber> userLottoNumbers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            userLottoNumbers.add(new LottoNumber(i + 1));
        }
        LottoTicket ticket = new LottoTicket(userLottoNumbers);
        assertThat(ticket.contains(new LottoNumber(45))).isFalse();
    }
}

package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.exception.LottoException;

class LottoTicketTest {

    @DisplayName("로또티켓 생성")
    @Test
    void constructLottoTicket() {
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lottoTicket).isEqualTo(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @DisplayName("입력받은 로또티켓 생성")
    @Test
    void constructLottoTicketFromText_success() {
        LottoTicket lottoTicket = new LottoTicket(parseToList("1,2,3,4,5,6"));
        assertThat(lottoTicket).isEqualTo(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @DisplayName("잘못된 입력으로 로또티켓 생성시 에러")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,5", "1,2,3,4,5,5,6", "1,2,3,4,5,6,7"})
    void throwsError_whenInvalidTextLottoTicket(String invalidLottoNumbers) {
        assertThatExceptionOfType(LottoException.class)
            .isThrownBy(() -> new LottoTicket(parseToList(invalidLottoNumbers)))
            .withMessage("1 ~ 45의 숫자 중 중복되지 않은 숫자 6개를 입력해주세요.");
    }

    @DisplayName("로또티켓 결과 계산")
    @ParameterizedTest
    @CsvSource(value = {"4,5,6,7,8,9;false;FIFTH", "4,5,6,1,8,9;false;FOURTH", "4,5,6,1,8,9;true;FOURTH",
        "4,5,6,1,2,9;false;THIRD", "4,5,6,1,2,9;true;SECOND", "4,5,6,1,2,3;false;FIRST", "7,8,9,10,11,12;false;MISS",
        "1,2,9,10,11,12;true;MISS"}, delimiter = ';')
    public void calculateResult(String lottoNumbers, boolean containsBonus, String resultName) {
        LottoTicket lottoTicket = new LottoTicket(parseToList(lottoNumbers));
        assertThat(lottoTicket.calculateResult(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)), containsBonus))
            .isEqualTo(LottoResult.valueOf(resultName));
    }

    private List<Integer> parseToList(String numbers) {
        return Arrays.stream(numbers.split(","))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

}
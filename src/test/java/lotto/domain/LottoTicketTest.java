package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTicketTest {
    LottoTicket lottoTicket;
    LottoTicket winningNumbers;
    LottoNumber bonusNUmber;

    @BeforeEach
    void init() {
        lottoTicket = new LottoTicket("1, 2, 3, 4, 5, 6");
        winningNumbers = new LottoTicket("6, 5, 4, 3, 2, 1");
        bonusNUmber = new LottoNumber(7);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("당첨 로또 번호 null 이거나 비어있을 경우 Exception 발생 확인")
    void validateNullOrEmpty(String input) {
        assertThatThrownBy(() -> {
            new LottoTicket(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, 1", "3, 3, 3, 4, 5, 6"})
    @DisplayName("당첨 로또 번호 중에 중복되는 번호가 존재할 경우 Exception 발생 확인")
    void validateUnique(String input) {
        assertThatThrownBy(() -> {
            new LottoTicket(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "1, 2", "1, 2, 3"})
    @DisplayName("당첨 로또 번호가 6개가 아닐 경우 Exception 발생 확인")
    void validateSize(String input) {
        assertThatThrownBy(() -> {
            new LottoTicket(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0, 1, 2, 3, 4, 5", "1, 2, 3, 4, 5, 46"})
    @DisplayName("당첨 로또 번호 중에 범위 내(1-45) 에 있지 않은 번호가 존재할 경우 Exception 발생 확인")
    void validateRange(String input) {
        assertThatThrownBy(() -> {
            new LottoTicket(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구매한 로또 번호와 당첨 번호의 매칭 개수 확인")
    void matchCount() {
        assertThat(lottoTicket.matchCount(winningNumbers)).isEqualTo(6);
    }

    @DisplayName("당첨 순위 확인")
    @Test
    void rank() {
        assertThat(lottoTicket.rank(winningNumbers, bonusNUmber)).isEqualTo(LottoRank.FIRST);
    }
}

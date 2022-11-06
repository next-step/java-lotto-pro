package lotto.domain;

import lotto.common.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTicketTest {
    @Test
    @DisplayName("로또_티켓_생성")
    void 로또_티켓_생성() {
        Set<LottoNumber> lottoTicket = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::valueOf)
                .collect(Collectors.toSet());
        assertThat(new LottoTicket(lottoTicket)).isEqualTo(new LottoTicket(lottoTicket));
    }

    @Test
    @DisplayName("로또_번호_중복_확인")
    void 로또_번호_중복_확인() {
        Set<LottoNumber> lottoTicket = Stream.of(1, 2, 3, 4, 5, 5)
                .map(LottoNumber::valueOf)
                .collect(Collectors.toSet());
        assertThatThrownBy(() -> new LottoTicket(lottoTicket))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_LOTTO_NUMBER_DUPLICATION);
    }

    @Test
    @DisplayName("문자열_로또_티켓_생성")
    void 문자열_로또_티켓_생성() {
        String lottoNumbers = "1,2, 3,4,5,  6";
        assertThat(new LottoTicket(lottoNumbers)).isEqualTo(new LottoTicket(lottoNumbers));
    }

    @Test
    @DisplayName("문자열_로또_티켓_중복_채크")
    void 문자열_로또_티켓_중복_채크() {
        String lottoNumbers = "1,2,3,4,5,5";
        assertThatThrownBy(() -> new LottoTicket(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_LOTTO_NUMBER_DUPLICATION);
    }

    @Test
    @DisplayName("로또_티켓_비교")
    void 로또_티켓_비교() {
        String lottoNumbers = "1,2,3,4,6,7";
        Set<LottoNumber> lottoTicketSet = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::valueOf)
                .collect(Collectors.toSet());
        LottoTicket winningTicket = new LottoTicket(lottoNumbers);
        LottoTicket purchaseLottoTicket = new LottoTicket(lottoTicketSet);
        assertThat(purchaseLottoTicket.compareTicket(winningTicket)).isEqualTo(5);
    }
}

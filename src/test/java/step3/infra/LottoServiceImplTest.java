package step3.infra;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import step3.domain.LottoService;

class LottoServiceImplTest {
    LottoService lottoService = new LottoServiceImpl();

    @ParameterizedTest
    @CsvSource(value = {"5000:5", "4500:4", "500:0"}, delimiter = ':')
    void buyLotto_구매수량_검증(int money, int expected) {
        List<String> lottoTicketVouchers = lottoService.buyLotto(money);

        assertThat(lottoTicketVouchers.size()).isEqualTo(expected);
    }
}
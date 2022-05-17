package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class InputLottoInformationTest {

    @Test
    void 로또_구입가격_수동_로또_입력_로또_개수_정보를_알수_있다() {

        Money inputMoney = Money.from(5000);
        List<LottoNumbers> lottoNumbersList = new ArrayList<>();
        lottoNumbersList.add(LottoNumbers.from(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottoNumbersList.add(LottoNumbers.from(Arrays.asList(6, 7, 8, 9, 10, 11)));

        InputLottoInformation lottoInformation = InputLottoInformation.of(inputMoney, lottoNumbersList);

        assertThat(lottoInformation.totalLottoCount()).isEqualTo(5);
        assertThat(lottoInformation.autoLottoCount()).isEqualTo(3);
        assertThat(lottoInformation.manualLottoCount()).isEqualTo(2);

    }
}

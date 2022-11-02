package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step3.model.Lotto;
import step3.model.LottoMoney;
import step3.model.Lottos;
import step3.model.dto.LottoStatusDto;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static step3.LottoUtils.getLottoNumbers;

public class LottoNumberDtoTest {

    @Test
    @DisplayName("생성자에 로또전달시 번호조회 가능")
    void test_that_returns_lottonumbers_if_created_at_constructor() {
        //given
        List<Lotto> lottoNumbers = new ArrayList();
        lottoNumbers.add(new Lotto(getLottoNumbers(1, 2, 3, 14, 15, 16)));
        lottoNumbers.add(new Lotto(getLottoNumbers(2, 11, 3, 4, 1, 6)));
        lottoNumbers.add(new Lotto(getLottoNumbers(1, 11, 33, 2, 35, 3)));
        Lottos lottos = new Lottos(lottoNumbers);
        LottoStatusDto lottoStatusDto = new LottoStatusDto(lottos, new LottoMoney(3000, 1));

        //when
        List<List<Integer>> numbers = lottoStatusDto.getLottosNumber();

        //then
        assertThat(numbers.get(0)).containsExactly(1, 2, 3, 14, 15, 16);
        assertThat(numbers.get(1)).containsExactly(2, 11, 3, 4, 1, 6);
        assertThat(numbers.get(2)).containsExactly(1, 11, 33, 2, 35, 3);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:13", "2:12", "3:11", "4:10"}, delimiter = ':')
    @DisplayName("로또를 생성시 자동개수 반환")
    void test_that_returns_auto_if_created_at_constructor(int manualCount, int autoCount) {
        //given
        List<Lotto> lottoNumbers = new ArrayList();
        lottoNumbers.add(new Lotto(getLottoNumbers(2, 11, 3, 4, 1, 6)));
        Lottos lottos = new Lottos(lottoNumbers);
        LottoStatusDto lottoStatusDto = new LottoStatusDto(lottos, new LottoMoney(14000, manualCount));

        //when
        int autoLottoCount = lottoStatusDto.getAutoLottoCount();

        //then
        assertThat(autoLottoCount).isEqualTo(autoCount);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5})
    @DisplayName("로또를 생성시 수동개수반환")
    void test_that_returns_autocount_if_created_at_constructor(int manualCount) {
        //given
        List<Lotto> lottoNumbers = new ArrayList();
        lottoNumbers.add(new Lotto(getLottoNumbers(2, 11, 3, 4, 1, 6)));
        lottoNumbers.add(new Lotto(getLottoNumbers(2, 11, 3, 4, 1, 6)));

        Lottos lottos = new Lottos(lottoNumbers);
        LottoStatusDto lottoStatusDto = new LottoStatusDto(lottos, new LottoMoney(14000, manualCount));

        //when
        int manualLottoCount = lottoStatusDto.getManualLottoCount();

        //then
        assertThat(manualLottoCount).isEqualTo(manualCount);
    }
}

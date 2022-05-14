package lotto.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottoLogicServiceTest {

    LottoLogicService lottoLogicService = new LottoLogicService();

    @DisplayName("makeAllLottoNumbers 함수가 만드는 리스트가 숫자 [1~45]을 만드는지 체크")
    @Test
    void makeAllLottoNumbersTest() {
        List<Integer> result = lottoLogicService.makeAllLottoNumbers();
        assertThat(result)
                .hasSize(45)
                .contains(1, 45)
                .doesNotContain(0, 46);
    }

    @DisplayName("makeLottoNumbers 함수가 6개의 랜덤한 숫자를 리턴하는지 체크")
    @Test
    void makeLottoNumbersTest() {
        Set<Integer> result = lottoLogicService.makeLottoNumbers();
        assertThat(result)
                .hasSize(6);
        System.out.println(result);
    }
}
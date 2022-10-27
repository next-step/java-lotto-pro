package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.model.Lotto;
import step3.model.LottoService;
import step3.model.Lottos;
import step3.model.Rank;
import step3.model.dto.LottoStatusDto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoServiceTest {


    @ParameterizedTest
    @CsvSource(value = {"1000:1", "6000:6", "5000:5", "12000:12"}, delimiter = ':')
    @DisplayName("로또를 구매하면 구매가격만큼 컬렉션에서 로또개수를 조회")
    void test_that_throw_exception_when_number_is_outofrange(int price,int count){
        //given
        Lottos lottos = new Lottos(new ArrayList());
        LottoService lottoService = new LottoService(price,lottos);

        //when
        lottoService.purchaseByAuto();

        //then
        assertThat(lottos.getNumbersOfLottos()).hasSize(count);

    }

    @Test
    @DisplayName("당첨된 경우 수익률은 상금/구입금액")
    void test_that_it_returns_winning_rate_if_wining_number_match(){
        //given
        Lotto lotto = new Lotto(Arrays.stream(new int[]{1,2,3,14,15,16}).boxed().collect(Collectors.toList()));
        Lottos lottos = new Lottos(Arrays.asList(lotto));
        LottoService lottoService = new LottoService(14000,lottos);
        List<Integer> winningNumbers = Arrays.stream(new int[]{1,2,3,4,5,6}).boxed().collect(Collectors.toList());

        //when
        LottoStatusDto lottoStatusDto = lottoService.getRankStatus(winningNumbers);

        //then
        assertThat(lottoStatusDto.getRanks()).hasSize(4);
        assertThat(lottoStatusDto.getWinnigPercent()).isEqualTo(Rank.FIFTH.getWinningPrice() / (double)14000);
    }

}

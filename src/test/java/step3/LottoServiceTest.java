package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedStatic;
import step3.model.Lotto;
import step3.model.LottoFactory;
import step3.model.LottoService;
import step3.model.Rank;
import step3.model.dto.LottoStatusDto;
import step3.model.dto.LottosNumberDto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

public class LottoServiceTest {

    private static MockedStatic<LottoFactory> mock;


    @ParameterizedTest
    @CsvSource(value = {"1000:1", "6000:6", "5000:5", "12000:12"}, delimiter = ':')
    @DisplayName("로또를 구매하면 구매가격만큼 컬렉션에서 로또개수를 조회")
    void test_that_throw_exception_when_number_is_outofrange(int price,int count){
        //given
        LottoService lottoService = new LottoService(price);

        //when
        LottosNumberDto lottosNumberDto = lottoService.getLottoTicketState();

        //then
        assertThat(lottosNumberDto.getLottosNumber()).hasSize(count);
    }

    @Test
    @DisplayName("당첨된 경우 수익률은 상금/구입금액")
    void test_that_it_returns_winning_rate_if_winning_number_match(){
        //given
        mock = mockStatic(LottoFactory.class);
        mock.when(() -> LottoFactory.createLottos(anyInt()))
                .thenReturn(Arrays.asList(new Lotto(Arrays.stream(new int[]{1,2,3,14,15,16}).boxed().collect(Collectors.toList()))));
        LottoService lottoService = new LottoService(14000);
        List<Integer> winningNumbers = Arrays.stream(new int[]{1,2,3,4,5,6}).boxed().collect(Collectors.toList());

        //when
        LottoStatusDto lottoStatusDto = lottoService.getRankStatus(winningNumbers);

        //then
        assertThat(lottoStatusDto.getWinnigPercent()).isEqualTo(Rank.FIFTH.getWinningPrice() / (double)14000);

        mock.close();

    }

}

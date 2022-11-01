package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step3.model.*;
import step3.model.dto.LottoResultDto;
import step3.model.dto.LottoStatusDto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static step3.LottoUtils.getLottoNumbers;

public class LottoMachineTest {

    @ParameterizedTest
    @CsvSource(value = {"2000:1", "5000:4", "4000:3", "12000:11"}, delimiter = ':')
    @DisplayName("로또를 구매하면 구매가격만큼 컬렉션에서 로또개수를 조회")
    void test_that_throw_exception_when_number_is_outofrange(int price, int count) {
        //given
        LottoMoney lottoMoney = new LottoMoney(price,1);
        Lottos lottos = new Lottos(LottoFactory.createLottosByAuto(lottoMoney));
        LottoMachine lottoMachine = new LottoMachine(lottoMoney, lottos);

        //when
        LottoStatusDto lottoStatusDto = lottoMachine.getLottoNumber();

        //then
        assertThat(lottoStatusDto.getLottosNumber()).hasSize(count);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("당첨된 번호가 없는 경우 수익률은 0")
    void test_that_it_returns_zero_rate_if_winning_number_nonematch(int count) {
        //given
        List<Lotto> lottoList = new ArrayList();
        for (int i = 0; i < count; i++) {
            lottoList.add(new Lotto(getLottoNumbers(1, 2, 3, 14, 15, 16)));
        }
        LottoMoney lottoMoney = new LottoMoney(14000,1);
        Lottos lottos = new Lottos(lottoList);
        LottoMachine lottoMachine = new LottoMachine(lottoMoney, lottos);
        List<LottoNumber> winningNumbers = Arrays.stream(new int[]{11, 22, 23, 24, 25, 26})
                .boxed()
                .map(LottoNumber::valueOf)
                .collect(Collectors.toList());

        //when
        LottoResultDto lottoResultDto = lottoMachine.getLottoResult(new Lotto(winningNumbers));

        //then
        assertThat(lottoResultDto.getPriceRatio()).isEqualTo((Rank.MISS.getWinningPrice() * count) / (double) 14000);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 4, 5, 6})
    @DisplayName("중복된 번호가 있는경우 예외발생")
    void test_that_throws_exceptino_if_number_has_duplicated(int count) {
        //given
        List<Lotto> lottoList = new ArrayList();
        lottoList.add(new Lotto(getLottoNumbers(1, 2, 3, 14, 15, 16)));

        LottoMoney lottoMoney = new LottoMoney(14000,1);
        Lottos lottos = new Lottos(lottoList);
        LottoMachine lottoMachine = new LottoMachine(lottoMoney, lottos);
        List<LottoNumber> winningNumbers = Arrays.stream(new int[]{1, count, 3, 4, 5, 6})
                .boxed()
                .map(LottoNumber::valueOf)
                .collect(Collectors.toList());

        //when,then
        assertThatThrownBy(() -> lottoMachine.getLottoResult(new Lotto(winningNumbers)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복없는 번호만 허용합니다");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    @DisplayName("보너스볼 중복된 번호가 있는경우 예외발생")
    void test_that_throws_exceptino_if_bonusnumber_has_duplicated(int count) {
        //given
        List<Lotto> lottoList = new ArrayList();
        lottoList.add(new Lotto(getLottoNumbers(1, 2, 3, 14, 15, 16)));

        LottoMoney lottoMoney = new LottoMoney(14000,1);
        Lottos lottos = new Lottos(lottoList);
        LottoMachine lottoMachine = new LottoMachine(lottoMoney, lottos);
        List<LottoNumber> winningNumbers = Arrays.stream(new int[]{1, 2, 3, 4, 5, 6})
                .boxed()
                .map(LottoNumber::valueOf)
                .collect(Collectors.toList());

        //when,then
        assertThatThrownBy(() -> lottoMachine.getLottoResult(new WinningLotto(new Lotto(winningNumbers), LottoNumber.valueOf(count))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("고유한 번호만 허용합니다");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("5등 당첨된 경우 수익률은  ( 5등상금 * 당첨된 로또개수)/구입금액")
    void test_that_it_returns_winning_rate_if_winning_number_match_at5(int count) {
        //given
        List<Lotto> lottoList = new ArrayList();
        for (int i = 0; i < count; i++) {
            lottoList.add(new Lotto(getLottoNumbers(1, 2, 3, 14, 15, 16)));
        }
        LottoMoney lottoMoney = new LottoMoney(14000,1);
        Lottos lottos = new Lottos(lottoList);
        LottoMachine lottoMachine = new LottoMachine(lottoMoney, lottos);
        List<LottoNumber> winningNumbers = Arrays.stream(new int[]{1, 2, 3, 4, 5, 6}).boxed()
                .map(LottoNumber::valueOf)
                .collect(Collectors.toList());

        //when
        LottoResultDto lottoResultDto = lottoMachine.getLottoResult(new Lotto(winningNumbers));

        //then
        assertThat(lottoResultDto.getPriceRatio()).isEqualTo((Rank.FIFTH.getWinningPrice() * count) / (double) 14000);

    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("4등 당첨된 경우 수익률은  ( 4등상금 * 당첨된 로또개수)/구입금액")
    void test_that_it_returns_winning_rate_if_winning_number_match_at4(int count) {
        //given
        List<Lotto> lottoList = new ArrayList();
        for (int i = 0; i < count; i++) {
            lottoList.add(new Lotto(getLottoNumbers(1, 2, 3, 14, 15, 16)));
        }
        LottoMoney lottoMoney = new LottoMoney(14000,1);
        Lottos lottos = new Lottos(lottoList);
        LottoMachine lottoMachine = new LottoMachine(lottoMoney, lottos);
        List<LottoNumber> winningNumbers = Arrays.stream(new int[]{1, 2, 3, 14, 5, 6})
                .boxed()
                .map(LottoNumber::valueOf)
                .collect(Collectors.toList());

        //when
        LottoResultDto lottoResultDto = lottoMachine.getLottoResult(new Lotto(winningNumbers));

        //then
        assertThat(lottoResultDto.getPriceRatio()).isEqualTo((Rank.FOURTH.getWinningPrice() * count) / (double) 14000);

    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("3등 당첨된 경우 수익률은  ( 3등상금 * 당첨된 로또개수)/구입금액")
    void test_that_it_returns_winning_rate_if_winning_number_match_at3(int count) {
        //given
        List<Lotto> lottoList = new ArrayList();
        for (int i = 0; i < count; i++) {
            lottoList.add(new Lotto(getLottoNumbers(1, 2, 3, 14, 15, 16)));
        }
        LottoMoney lottoMoney = new LottoMoney(14000,1);
        Lottos lottos = new Lottos(lottoList);
        LottoMachine lottoMachine = new LottoMachine(lottoMoney, lottos);
        List<LottoNumber> winningNumbers = Arrays.stream(new int[]{1, 2, 3, 14, 15, 6})
                .boxed()
                .map(LottoNumber::valueOf)
                .collect(Collectors.toList());

        //when
        LottoResultDto lottoResultDto = lottoMachine.getLottoResult(new Lotto(winningNumbers));

        //then
        assertThat(lottoResultDto.getPriceRatio()).isEqualTo((Rank.THIRD.getWinningPrice() * count) / (double) 14000);

    }


    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("1등 당첨된 경우 수익률은  ( 1등상금 * 당첨된 로또개수)/구입금액")
    void test_that_it_returns_winning_rate_if_winning_number_match(int count) {
        //given
        List<Lotto> lottoList = new ArrayList();
        for (int i = 0; i < count; i++) {
            lottoList.add(new Lotto(getLottoNumbers(1, 2, 3, 14, 15, 16)));
        }
        LottoMoney lottoMoney = new LottoMoney(14000,1);
        Lottos lottos = new Lottos(lottoList);
        LottoMachine lottoMachine = new LottoMachine(lottoMoney, lottos);
        List<LottoNumber> winningNumbers = Arrays.stream(new int[]{1, 2, 3, 14, 15, 16})
                .boxed()
                .map(LottoNumber::valueOf)
                .collect(Collectors.toList());

        //when
        LottoResultDto lottoResultDto = lottoMachine.getLottoResult(new Lotto(winningNumbers));

        //then
        assertThat(lottoResultDto.getPriceRatio()).isEqualTo((Rank.FIRST.getWinningPrice() * count) / (double) 14000);

    }

}

package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.model.LottoMoney;
import step3.model.Rank;
import step3.model.dto.LottoResultDto;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultDtoTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("5등 정보입력시 5등 수익률 반환")
    void test_that_returns_profit_when_entering_fifth(int count) {
        //given
        Map<Rank, Integer> rankStats = new HashMap();
        rankStats.put(Rank.FIRST, 0);
        rankStats.put(Rank.SECOND, 0);
        rankStats.put(Rank.THIRD, 0);
        rankStats.put(Rank.FOURTH, 0);
        rankStats.put(Rank.FIFTH, count);

        //when
        LottoResultDto lottoResultDto = new LottoResultDto(rankStats, new LottoMoney(14000, 1));

        //then
        assertThat(lottoResultDto.getPriceRatio()).isEqualTo((Rank.FIFTH.getWinningPrice() * count) / (double) 14000);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("4등 정보입력시 4등 수익률 반환")
    void test_that_returns_profit_when_entering_four(int count) {
        //given
        Map<Rank, Integer> rankStats = new HashMap();
        rankStats.put(Rank.FIRST, 0);
        rankStats.put(Rank.SECOND, 0);
        rankStats.put(Rank.THIRD, 0);
        rankStats.put(Rank.FOURTH, count);
        rankStats.put(Rank.FIFTH, 0);

        //when
        LottoResultDto lottoResultDto = new LottoResultDto(rankStats, new LottoMoney(14000, 1));

        //then
        assertThat(lottoResultDto.getPriceRatio()).isEqualTo((Rank.FOURTH.getWinningPrice() * count) / (double) 14000);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("3등 정보입력시 3등 수익률 반환")
    void test_that_returns_profit_when_entering_third(int count) {
        //given
        Map<Rank, Integer> rankStats = new HashMap();
        rankStats.put(Rank.FIRST, 0);
        rankStats.put(Rank.SECOND, 0);
        rankStats.put(Rank.THIRD, count);
        rankStats.put(Rank.FOURTH, 0);
        rankStats.put(Rank.FIFTH, 0);

        //when
        LottoResultDto lottoResultDto = new LottoResultDto(rankStats, new LottoMoney(14000, 1));

        //then
        assertThat(lottoResultDto.getPriceRatio()).isEqualTo((Rank.THIRD.getWinningPrice() * count) / (double) 14000);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("2등 정보입력시 2등 수익률 반환")
    void test_that_returns_profit_when_entering_second(int count) {
        //given
        Map<Rank, Integer> rankStats = new HashMap();
        rankStats.put(Rank.FIRST, 0);
        rankStats.put(Rank.SECOND, count);
        rankStats.put(Rank.THIRD, 0);
        rankStats.put(Rank.FOURTH, 0);
        rankStats.put(Rank.FIFTH, 0);

        //when
        LottoResultDto lottoResultDto = new LottoResultDto(rankStats, new LottoMoney(14000, 1));

        //then
        assertThat(lottoResultDto.getPriceRatio()).isEqualTo((Rank.SECOND.getWinningPrice() * count) / (double) 14000);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("1등 정보입력시 1등 수익률 반환")
    void test_that_returns_profit_when_entering_first(int count) {
        //given
        Map<Rank, Integer> rankStats = new HashMap();
        rankStats.put(Rank.FIRST, count);
        rankStats.put(Rank.SECOND, 0);
        rankStats.put(Rank.THIRD, 0);
        rankStats.put(Rank.FOURTH, 0);
        rankStats.put(Rank.FIFTH, 0);

        //when
        LottoResultDto lottoResultDto = new LottoResultDto(rankStats, new LottoMoney(14000, 1));

        //then
        assertThat(lottoResultDto.getPriceRatio()).isEqualTo((Rank.FIRST.getWinningPrice() * count) / (double) 14000);
    }
}

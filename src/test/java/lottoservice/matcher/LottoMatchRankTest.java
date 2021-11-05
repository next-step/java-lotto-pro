package lottoservice.matcher;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoMatchRankTest {

	@ParameterizedTest
	@CsvSource(value = {"SIX_POINT,6","FIVE_POINT,5","FOUR_POINT,4","THREE_POINT,3","TWO_POINT,2","ONE_POINT,1","ZERO_POINT,0"},delimiter=',')
	public void 로또_당첨_결과_countofmatch(LottoMatchRank rank, int countOfMatch){
		LottoMatchRank lottoMatchRank =rank;
		assertThat(lottoMatchRank.getCountOfMatch()).isEqualTo(countOfMatch);
	}

	@ParameterizedTest
	@CsvSource(value = {"SIX_POINT,2000000000","FIVE_POINT,1500000","FOUR_POINT,50000","THREE_POINT,5000","TWO_POINT,0","ONE_POINT,0","ZERO_POINT,0"},delimiter=',')
	public void 로또_당첨_결과_winningMoney(LottoMatchRank rank, int winningMoney){
		LottoMatchRank lottoMatchRank =rank;
		assertThat(lottoMatchRank.getWinningMoney()).isEqualTo(winningMoney);
	}

	@ParameterizedTest
	@CsvSource(value = {"SIX_POINT,6","FIVE_POINT,5","FOUR_POINT,4","THREE_POINT,3","TWO_POINT,2","ONE_POINT,1","ZERO_POINT,0"},delimiter=',')
	public void 로또_당첨_결과_valueof_countOfMatch(LottoMatchRank rank, int countOfMatch){
		assertThat(LottoMatchRank.valueOf(countOfMatch)).isEqualTo(rank);
	}
}
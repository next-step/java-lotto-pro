package lotto.controller.dto;

import static lotto.domain.LottoWinPrize.FIFTH;
import static lotto.domain.LottoWinPrize.FIRST;
import static lotto.domain.LottoWinPrize.FOURTH;
import static lotto.domain.LottoWinPrize.SECOND;
import static lotto.domain.LottoWinPrize.THIRD;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import lotto.domain.LottoWinPrizes;
import lotto.domain.ProfitMargin;
import money.Money;

public class LottoWinResultsResponse {

	private final List<LottoWinResultResponse> lottoWinResultResponseList;
	private final ProfitMargin profitMargin;

	private LottoWinResultsResponse(List<LottoWinResultResponse> lottoWinResultResponseList,
									ProfitMargin profitMargin) {
		this.lottoWinResultResponseList = lottoWinResultResponseList;
		this.profitMargin = profitMargin;
	}

	public static LottoWinResultsResponse of(LottoWinPrizes lottoWinPrizes, Money lottoPrice) {
		return new LottoWinResultsResponse(
			Arrays.asList(
				LottoWinResultResponse.of(FIFTH, lottoWinPrizes),
				LottoWinResultResponse.of(FOURTH, lottoWinPrizes),
				LottoWinResultResponse.of(THIRD, lottoWinPrizes),
				LottoWinResultResponse.of(SECOND, lottoWinPrizes),
				LottoWinResultResponse.of(FIRST, lottoWinPrizes)
			), lottoWinPrizes.getProfitMargin(lottoPrice));
	}

	public void forEach(Consumer<LottoWinResultResponse> consumer) {
		lottoWinResultResponseList.forEach(consumer);
	}

	public ProfitMargin getProfitMargin() {
		return profitMargin;
	}

}

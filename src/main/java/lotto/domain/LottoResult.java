package lotto.domain;

import lotto.dto.LottoResultDto;

public class LottoResult {

    private LottoRankMatcher lottoRankMatcher;
    private BuyAmount buyAmount;
    private WinningNumbers winningNumbers;

    public LottoResult (Lotteries lotteries, WinningNumbers winningNumbers, BuyAmount buyAmount) {
        this.lottoRankMatcher = new LottoRankMatcher(lotteries, winningNumbers);
        this.buyAmount = buyAmount;
        this.winningNumbers = winningNumbers;
    }

    private int getWinningPrice() {
        int winningPrice = 0;
        for (Rank rank : Rank.getAllRanks()) {
            winningPrice += rank.getWinningMoney() * lottoRankMatcher.getMatchLottoRank(rank);
        }
        return winningPrice;
    }

    private double getProfit() {
        return buyAmount.getProfit(getWinningPrice());
    }

    public LottoResultDto getLottoResultDto() {
        return new LottoResultDto(lottoRankMatcher, getProfit());
    }
}

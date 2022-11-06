package lotto.domain;

import lotto.dto.LotteriesDto;

import java.util.*;
import java.util.stream.Collectors;

public class Lotteries {

    private List<Lotto> lotteries;

    public Lotteries(List<Lotto> lotteries) {
        this.lotteries = lotteries;
    }

    public Map<Lotto, Rank> getLottoMatchRankMap(WinningNumbers winningNumbers) {
        Map<Lotto,Rank> lottoRankMatcher = new HashMap<>();
        for (Lotto lotto : lotteries) {
            lottoRankMatcher.put(lotto,
                    Rank.valueOf(winningNumbers.getMatchNumber(lotto), winningNumbers.isBonus(lotto)));
        }
        return lottoRankMatcher;
    }

    public LotteriesDto getLotteriesDto() {
        return new LotteriesDto(lotteries.stream()
                .map(lotto -> lotto.getLottoDto().getLotto())
                .collect(Collectors.toList()),this);
    }

    public Lotteries union(Lotteries lotteries) {
        this.lotteries.addAll(lotteries.lotteries);
        return new Lotteries(this.lotteries);
    }

    public boolean isEqualSize(int directBuyCount) {
        return directBuyCount == lotteries.size();
    }
}

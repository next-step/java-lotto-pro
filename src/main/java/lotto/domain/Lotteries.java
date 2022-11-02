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
        Map<Lotto,Rank> lottoMatchNumberMap = new HashMap<>();
        for (Lotto lotto : lotteries) {
            lottoMatchNumberMap.put(lotto,
                    Rank.valueOf(winningNumbers.getMatchNumber(lotto), winningNumbers.isBonus(lotto)));
        }
        return lottoMatchNumberMap;
    }

    public LotteriesDto getLotteriesDto() {
        return new LotteriesDto(lotteries.stream()
                .map(lotto -> lotto.getLottoDto().getLotto())
                .collect(Collectors.toList()),this);
    }
}

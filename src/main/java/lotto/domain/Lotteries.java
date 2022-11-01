package lotto.domain;

import lotto.dto.LotteriesDto;

import java.util.*;
import java.util.stream.Collectors;

public class Lotteries {

    private List<Lotto> lotteries;

    public Lotteries(List<Lotto> lotteries) {
        this.lotteries = lotteries;
    }

    public Map<Lotto, Integer> getLottoMatchNumberMap(WinningNumbers winningNumbers) {
        Map<Lotto,Integer> lottoMatchNumberMap = new HashMap<>();
        for (Lotto lotto : lotteries) {
            lottoMatchNumberMap.put(lotto, winningNumbers.getMatchNumber(lotto));
        }
        return lottoMatchNumberMap;
    }

    public LotteriesDto getLotteriesDto() {
        return new LotteriesDto(lotteries.stream()
                .map(lotto -> lotto.getLottoDto().getLotto())
                .collect(Collectors.toList()),this);
    }
}

package lotto.dto;

import lotto.domain.Lotteries;

import java.util.List;

public class LotteriesDto {

    private List<List<Integer>> lotteries;
    private Lotteries lotteriesDomain;

    public LotteriesDto(List<List<Integer>> lotteries, Lotteries lotteriesDomain) {
        this.lotteries = lotteries;
        this.lotteriesDomain = lotteriesDomain;
    }

    public Lotteries getLotteriesDomain() {
        return lotteriesDomain;
    }

    public List<List<Integer>> getLotteries() {
        return lotteries;
    }
}

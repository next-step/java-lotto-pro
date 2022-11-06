package lotto.dto;

import lotto.domain.Lotteries;

import java.util.List;

public class LotteriesDto {

    private List<List<Integer>> lotteries;
    private Lotteries lotteriesDomain;
    private int directBuyCount;
    private int autoBuyCount;

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

    public int getDirectBuyCount() {
        return directBuyCount;
    }

    public int getAutoBuyCount() {
        return autoBuyCount;
    }

    public void setDirectBuyCount(int directBuyCount) {
        this.directBuyCount = directBuyCount;
    }

    public void setAutoBuyCount(int autoBuyCount) {
        this.autoBuyCount = autoBuyCount;
    }

    public void setLotteries(List<List<Integer>> lotteries) {
        this.lotteries = lotteries;
    }
}

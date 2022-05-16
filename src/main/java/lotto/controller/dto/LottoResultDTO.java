package lotto.controller.dto;

import java.util.Map;
import lotto.enums.LottoRank;

public class LottoResultDTO {

    private Map<LottoRank, Integer> resultMap;

    private double profitRate;

    public LottoResultDTO(Map<LottoRank, Integer> resultMap, double profitRate) {
        this.resultMap = resultMap;
        this.profitRate = profitRate;
    }

    public LottoResultDTO() {

    }

    public Map<LottoRank, Integer> getResultMap() {
        return resultMap;
    }

    public void setResultMap(Map<LottoRank, Integer> resultMap) {
        this.resultMap = resultMap;
    }

    public double getProfitRate() {
        return profitRate;
    }

    public void setProfitRate(double profitRate) {
        this.profitRate = profitRate;
    }
}

package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private final Lotto winningLotto;
    private final List<Lotto> lottoList;
    private final Map<Integer, Integer> resultMap = new HashMap<>();

    public LottoResult(Lotto winningLotto, List<Lotto> lottoList) {
        this.winningLotto = winningLotto;
        this.lottoList = lottoList;
        setResultMap();
    }

    private void setResultMap() {
        for (Lotto lotto : lottoList) {
            int matchCount = winningLotto.match(lotto);
            resultMap.put(matchCount, resultMap.getOrDefault(matchCount, 0) + 1);
        }
    }

    protected int getResult(int key) {
        return resultMap.get(key) == null ? 0 : resultMap.get(key);
    }

    @Override
    public String toString() {
        return String.format("당첨 통계\n" +
                        "---------\n" +
                        "3개 일치 (5000원)- %d개\n" +
                        "4개 일치 (50000원)- %d개\n" +
                        "5개 일치 (1500000원)- %d개\n" +
                        "6개 일치 (2000000000원)- %d개\n" +
                        "총 수익률은 %f입니다."
                , getResult(3), getResult(4), getResult(5), getResult(6), 0.0);
    }
}

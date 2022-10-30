package model;

import java.util.List;

public class Rank {

    public void stats(List<LottoNumber> butLotto, List<Integer> winNumber) {
        for (LottoNumber lotto : butLotto) {
            int winNumberCount = lotto.getWinNumberCount(winNumber);
        }
    }
}

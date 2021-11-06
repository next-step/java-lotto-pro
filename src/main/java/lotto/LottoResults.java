package lotto;

import java.util.List;

public class LottoResults {
    public int getMatchedCount(List<Integer> lotto, List<Integer> winningLotto) {
        int count=0;
        for (Integer num : winningLotto) {
            if(lotto.contains(num)) {
                count++;
            }
        }
        return count;
    }
}

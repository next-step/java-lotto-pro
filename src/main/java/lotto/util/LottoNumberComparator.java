package lotto.util;

import java.util.Comparator;
import lotto.domain.LottoNumber;

public class LottoNumberComparator implements Comparator<LottoNumber>{
    @Override
    public int compare(LottoNumber o1, LottoNumber o2) {
        return o1.num - o2.num;
    }

}

package lotto.domain;

import lotto.constant.ErrorMessageConst;

public class LottoCount {
    private int count;

    public LottoCount(int count){
        validateLottoCount(count);
        this.count = count;
    }

    private void validateLottoCount(int count) {
        if (count < 0) {
            throw new IllegalArgumentException(ErrorMessageConst.ERROR_INVALID_NEGATIVE_INTEGER);
        }
    }

    public boolean isLessThan(LottoCount lottoCount) {
        return count < lottoCount.getCount();
    }

    public int getCount() {
        return count;
    }
}

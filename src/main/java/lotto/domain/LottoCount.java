package lotto.domain;

import lotto.constant.ErrorMessageConst;
import lotto.utils.CustomParseUtils;

public class LottoCount {
    private int count;

    public LottoCount(int count){
        validateLottoCount(count);
        this.count = count;
    }

    public static LottoCount from(int count) {
        return new LottoCount(count);
    }

    public static LottoCount from(String count) {
        return new LottoCount(CustomParseUtils.stringToInteger(count));
    }

    private void validateLottoCount(int count) {
        if (count < 0) {
            throw new IllegalArgumentException(ErrorMessageConst.ERROR_INVALID_NEGATIVE_INTEGER);
        }
    }

    public boolean isGreaterThan(LottoCount lottoCount) {
        return count > lottoCount.getCount();
    }

    public boolean isLessThan(LottoCount lottoCount) {
        return count < lottoCount.getCount();
    }

    public int getCount() {
        return count;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !(o instanceof  LottoCount)) {
            return false;
        }
        return ((LottoCount)o).getCount() == count;
    }
}

package lotto.number;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoNumbers {
    public static final int LOTTO_NUMBERS_SIZE = 6;

    private List<LottoNumber> lottoNumberList;

    public LottoNumbers(List<LottoNumber> lottoNumberList) {
        Collections.sort(lottoNumberList);
        this.lottoNumberList = Collections.unmodifiableList(lottoNumberList);
    }

    public List<LottoNumber> getLottoNumberList() {
        return Collections.unmodifiableList(lottoNumberList);
    }

    public boolean contains(LottoNumber number) {
        return lottoNumberList.contains(number);
    }

    @Override
    public String toString() {
        return Arrays.toString(lottoNumberList.toArray());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(lottoNumberList, that.lottoNumberList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumberList);
    }

}

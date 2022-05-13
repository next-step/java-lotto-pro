package lotto.number;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class NormalLottoNumbers implements LottoNumbers {
    public static final int LOTTO_NUMBERS_SIZE = 6;

    private List<LottoNumber> lottoNumberList;

    public NormalLottoNumbers(List<LottoNumber> lottoNumbers){
        this.lottoNumberList = Collections.unmodifiableList(lottoNumbers);
    }

    @Override
    public String toString() {
        return "NormalLottoNumbers{" +
                "lottoNumberList=" + lottoNumberList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NormalLottoNumbers that = (NormalLottoNumbers) o;
        return Objects.equals(lottoNumberList, that.lottoNumberList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumberList);
    }
}

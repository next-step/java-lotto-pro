package lotto.number;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NormalLottoNumbers implements LottoNumbers {
    private List<LottoNumber> lottoNumberList = new ArrayList<>();

    @Override
    public void add(LottoNumber number) {

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

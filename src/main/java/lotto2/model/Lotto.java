package lotto2.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public List<LottoNumber> lottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        final List<LottoNumber> listToPrint = new ArrayList<>(lottoNumbers);
        Collections.sort(listToPrint, (o1, o2) -> Integer.compare(o1.value(), o2.value()));
        return listToPrint.toString();
    }
}

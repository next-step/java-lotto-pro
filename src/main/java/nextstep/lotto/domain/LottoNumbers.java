package nextstep.lotto.domain;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static nextstep.lotto.constance.LottoDisplayMessage.PURCHASE_LOTTO_VIEW_MIDDLE;

public class LottoNumbers implements Iterable<LottoNumber> {

    private static final Integer LOTTO_NUMBER_COUNT = 6;

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers() {
        Set<LottoNumber> lottoNumbers = new LinkedHashSet<>();
        while (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            LottoNumber lottoNumber = new LottoNumber();
            lottoNumbers.add(lottoNumber);
        }
        this.lottoNumbers = new ArrayList<>(lottoNumbers);
    }

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    @Override
    public Iterator<LottoNumber> iterator() {
        return lottoNumbers.iterator();
    }

    @Override
    public String toString() {
        return StringUtils.join(lottoNumbers, PURCHASE_LOTTO_VIEW_MIDDLE);
    }
}

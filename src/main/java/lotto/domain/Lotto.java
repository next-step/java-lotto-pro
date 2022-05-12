package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static lotto.domain.LottoConstant.LOTTO_SIZE;

public class Lotto {
    private final List<LottoNo> lottoNoList;

    public Lotto(int... values) {
        this(Arrays.stream(values)
                .mapToObj(LottoNo::new)
                .collect(toList()));
    }

    public Lotto(List<LottoNo> lottoNoList) {
        if (isInvalidLotto(lottoNoList)) {
            throw new IllegalArgumentException("유효하지 않은 로또입니다.");
        }
        this.lottoNoList = lottoNoList;
        Collections.sort(lottoNoList);
    }

    private boolean isInvalidLotto(List<LottoNo> lottoNoList) {
        if (lottoNoList == null) {
            return true;
        }
        return lottoNoList.size() != LOTTO_SIZE;
    }

    public List<LottoNo> getLottoNoList() {
        return Collections.unmodifiableList(lottoNoList);
    }

    @Override
    public String toString() {
        return lottoNoList.toString();
    }
}

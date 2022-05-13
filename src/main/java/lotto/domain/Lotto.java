package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static lotto.domain.LottoConstant.LOTTO_SIZE;

public class Lotto {
    private final List<LottoNo> lottoNoList;

    public Lotto(int... values) {
        this(Arrays.stream(values)
                .mapToObj(LottoNo::new)
                .collect(toList()));
    }

    public Lotto(String values) {
        this(Arrays.stream(values.split(","))
                .map(String::trim)
                .map(LottoNo::new)
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

    public Ranking compareLotto(Lotto target) {
        List<LottoNo> result = new ArrayList<>(lottoNoList);
        result.retainAll(target.getLottoNoList());
        int matchingCount = result.size();
        return Ranking.findRank(matchingCount);
    }

    public List<LottoNo> getLottoNoList() {
        return Collections.unmodifiableList(lottoNoList);
    }

    @Override
    public String toString() {
        return lottoNoList.toString();
    }
}

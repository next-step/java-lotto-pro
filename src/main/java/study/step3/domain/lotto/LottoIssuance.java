package study.step3.domain.lotto;

import study.step3.domain.lottonumber.LottoNumbers;

import java.util.List;

public class LottoIssuance {

    private final Long count;
    private final List<LottoNumbers> lottoNumbersGroup;

    public LottoIssuance(Long count, List<LottoNumbers> lottoNumbersGroup) {
        this.count = count;
        this.lottoNumbersGroup = lottoNumbersGroup;
    }

    public static LottoIssuance ofCount(long count) {
        return new LottoIssuance(count, null);
    }

    public static LottoIssuance ofLottoNumbersGroup(List<LottoNumbers> lottoNumbersGroup) {
        return new LottoIssuance(null, lottoNumbersGroup);
    }

    public boolean isRandomLottos() {
        return count != null;
    }

    public boolean isManualLottos() {
        return lottoNumbersGroup != null;
    }

    public long count() {
        return this.count;
    }

    public List<LottoNumbers> lottoNumbersGroup() {
        return this.lottoNumbersGroup;
    }
}

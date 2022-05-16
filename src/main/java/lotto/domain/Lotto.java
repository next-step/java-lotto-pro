package lotto.domain;

import java.util.*;

import static java.util.stream.Collectors.toList;
import static lotto.domain.LottoConstant.LOTTO_SIZE;

public class Lotto {
    private final List<LottoNo> lottoNoList;

    public Lotto(int... values) {
        this(Arrays.stream(values)
                .mapToObj(LottoNo::new)
                .distinct()
                .collect(toList()));
    }

    public Lotto(String values) {
        this(Arrays.stream(values.split(","))
                .map(String::trim)
                .map(LottoNo::new)
                .distinct()
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
        return lottoNoList.size() != LOTTO_SIZE;
    }

    public Ranking compareLotto(Lotto target) {
        List<LottoNo> result = new ArrayList<>(lottoNoList);
        result.retainAll(target.getLottoNoList());
        int matchingCount = result.size();
        return Ranking.findRank(matchingCount, false);
    }

    public Ranking compareLottoWithBonus(Lotto target, LottoNo bonusNumber) {
        int matchingCount = getMatchingCount(target);
        boolean matchBonus = isContainBonusNumber(target, bonusNumber);
        return Ranking.findRank(matchingCount, matchBonus);
    }

    private int getMatchingCount(Lotto target) {
        List<LottoNo> intersection = new ArrayList<>(lottoNoList);
        intersection.retainAll(target.getLottoNoList());
        return intersection.size();
    }

    private boolean isContainBonusNumber(Lotto target, LottoNo bonusLotto) {
        List<LottoNo> lottoNoList = target.getLottoNoList();
        return lottoNoList.contains(bonusLotto);
    }

    public List<LottoNo> getLottoNoList() {
        return Collections.unmodifiableList(lottoNoList);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNoList, lotto.lottoNoList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNoList);
    }

    @Override
    public String toString() {
        return lottoNoList.toString();
    }
}

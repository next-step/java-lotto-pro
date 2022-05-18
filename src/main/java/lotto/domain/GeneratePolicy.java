package lotto.domain;

import java.util.List;

public interface GeneratePolicy {
    void generate(List<Lotto> lottoGroups, LottoCount lottoCount);
}

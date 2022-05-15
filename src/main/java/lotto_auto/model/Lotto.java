package lotto_auto.model;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private final LottoNumbers lottoNumbers;
    public Lotto(LottoNumbers numbers) {
        this.lottoNumbers = numbers;
    }

    public LottoRank matches(Lotto from) {
        int count = this.lottoNumbers.countSameLottoNumber(from.lottoNumbers);
        return LottoRank.getLottoRuleFromMatchedCount(count);
    }

    public String printLotto() {
        char fisrtCharactor = '[';
        char lastCharactor = ']';

        return fisrtCharactor + this.lottoNumbers.getLottoNumberList().stream()
                .map(lottoNumber -> Integer.toString(lottoNumber.getNumber()))
                .collect(Collectors.joining(", ")) +lastCharactor;
    }
}

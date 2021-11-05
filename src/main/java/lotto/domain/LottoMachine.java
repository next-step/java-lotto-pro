package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    public List<LottoNumber> getLottoList(Money money) {
        return generateLotto(money.getPurchaseCount());
    }

    public List<LottoNumber> generateLotto(int generateCount) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        IntStream.range(0, generateCount)
                .forEach(f -> lottoNumbers.add(new LottoNumber()));
        return lottoNumbers;
    }

    public List<Rank> matchLotto(List<Number> matchNumber, Number bonusNumber, List<LottoNumber> lottoList) {
        return lottoList.stream()
                .map(m -> m.getMatchRank(matchNumber, bonusNumber))
                .collect(Collectors.toList());
    }

}

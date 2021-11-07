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

}

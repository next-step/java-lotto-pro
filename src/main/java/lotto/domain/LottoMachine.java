package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static lotto.domain.LottoNumber.GAME_PRICE;

public class LottoMachine {

    private final Money money;
    private final List<List<Number>> activeNumberList;

    public LottoMachine(Money money) {
        this.money = money;
        this.activeNumberList = new ArrayList<>();
    }

    public LottoMachine(Money money, List<List<Number>> activeNumberList) {
        this.money = money;
        this.activeNumberList = activeNumberList;
    }

    public List<LottoNumber> getLottoList() {
        int autoCount = money.getPurchaseCount(GAME_PRICE) - activeNumberList.size();
        return Stream.concat(generateActiveLotto().stream(), generateAutoLotto(autoCount).stream())
                .collect(Collectors.toList());
    }

    private List<LottoNumber> generateAutoLotto(int count) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        IntStream.range(0, count)
                .forEach(f -> lottoNumbers.add(new LottoNumber()));
        return lottoNumbers;
    }

    private List<LottoNumber> generateActiveLotto() {
        return activeNumberList.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

}

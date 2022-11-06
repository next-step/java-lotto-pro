package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoBag {

    private final List<Lotto> lottoList;

    public static final Money LOTTO_PRICE = Money.from(1000);

    public LottoBag(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public List<WinningResult> getResult(WinningLottoBallBag winningLottoBallBag) {
        return lottoList.stream()
                .map(lotto -> lotto.getResult(winningLottoBallBag))
                .collect(Collectors.toList());
    }

    public long lottoSize() {
        return lottoList.size();
    }

    public List<NumberBag> getLottoNumbers() {
        return lottoList.stream()
                .map(Lotto::getNumbers)
                .collect(Collectors.toList());
    }

    public List<Lotto> getLottoList() {
        return new ArrayList<>(this.lottoList);
    }

    public static long availableCount(Money money) {
        return money.divide(LOTTO_PRICE);
    }

    public static LottoBag concat(LottoBag first, LottoBag second) {
        return new LottoBag(Stream.concat(first.lottoList.stream(), second.lottoList.stream())
                .collect(Collectors.toList()));
    }
}

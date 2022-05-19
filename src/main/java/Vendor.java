import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Vendor {
    public static final int LOTTO_PRICE = 1000;
    private final List<LottoNumber> ALL_AVAILABLE_LOTTO_NUMBER_LIST;

    public Vendor() {
        this.ALL_AVAILABLE_LOTTO_NUMBER_LIST = IntStream.range(LottoNumber.LOWER_BOUND, LottoNumber.UPPER_BOUND)
                .boxed()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public Lotto buyAutoContainsManual(LottoMoney lottoMoney, Lotto manual) {
        lottoMoney.buy(manual);
        return buyAuto(lottoMoney, manual);
    }

    private Lotto buyAuto(LottoMoney lottoMoney, Lotto manual) {
        Lotto lotto = Lotto.addAll(manual);

        while (lottoMoney.canBuy()) {
            lottoMoney.buyOne();
            lotto.add(auto());
        }

        return lotto;
    }

    private LottoNumbers auto() {
        Collections.shuffle(ALL_AVAILABLE_LOTTO_NUMBER_LIST);

        return new LottoNumbers(
                ALL_AVAILABLE_LOTTO_NUMBER_LIST.stream().limit(LottoNumbers.SIZE).collect(Collectors.toList()));
    }
}

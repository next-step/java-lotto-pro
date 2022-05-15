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

    public Lotto buy(long money) {
        final long maxCount = money / LOTTO_PRICE;
        if (maxCount < 1)
            throw new RuntimeException("이 돈으로는 로또를 구매할 수 없습니다.");

        Lotto lotto = new Lotto();
        for (int count = 1; count <= maxCount; count++) {
            lotto.add(get());
        }
        return lotto;
    }

    private LottoNumbers get() {
        Collections.shuffle(ALL_AVAILABLE_LOTTO_NUMBER_LIST);
        return new LottoNumbers(
                ALL_AVAILABLE_LOTTO_NUMBER_LIST.stream().limit(LottoNumbers.SIZE).collect(Collectors.toList()));
    }

    public Aggregator aggregate(ContainCounts containCounts) {
        return new Aggregator(containCounts);
    }
}

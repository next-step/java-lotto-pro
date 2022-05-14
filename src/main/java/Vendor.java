import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Vendor {
    public static final int LOTTO_BILL = 1000;
    private static final List<LottoNumber> ALL_AVAILABLE_LOTTO_NUMBER_LIST =
            IntStream.range(LottoNumber.LOWER_BOUND, LottoNumber.UPPER_BOUND)
                    .boxed()
                    .map(LottoNumber::new)
                    .collect(Collectors.toList());

    public Lottos buy(long money) {
        final long maxCount = money / LOTTO_BILL;
        if (maxCount < 1)
            throw new RuntimeException();

        Lottos lottos = new Lottos();
        for (int count = 1; count < Math.toIntExact(maxCount); count++) {
            lottos.add(get());
        }
        return lottos;
    }

    private LottoNumbers get() {
        Collections.shuffle(ALL_AVAILABLE_LOTTO_NUMBER_LIST);
        return new LottoNumbers(
                ALL_AVAILABLE_LOTTO_NUMBER_LIST.stream().limit(LottoNumbers.SIZE).collect(Collectors.toList()));
    }
}

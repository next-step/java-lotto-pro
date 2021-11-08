package lotto.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottosGenerator {

    private static final List<Integer> numbers;

    static {
        numbers = generateCandidateNumbers();
    }

    private LottosGenerator() {
    }

    public static Lottos generate(PurchaseAmount purchaseAmount, Lottos manualLottos) {
        List<Lotto> autoLottos = generateAutoLottos(purchaseAmount.getQuantity() - manualLottos.getTotalQuantity());
        return Stream.of(manualLottos.getLottos(), autoLottos)
                .flatMap(Collection::stream)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Lottos::from));
    }

    public static Lottos generate(PurchaseAmount purchaseAmount) {
        List<Lotto> autoLottos = generateAutoLottos(purchaseAmount.getQuantity());
        return Lottos.from(autoLottos);
    }

    private static List<Integer> generateCandidateNumbers() {
        return IntStream.range(LottoNumber.MIN_LOTTO_NUMBER, LottoNumber.MAX_LOTTO_NUMBER + 1)
                .boxed()
                .collect(Collectors.toList());
    }

    private static List<Lotto> generateAutoLottos(int autoQuantity) {
        return IntStream.range(0, autoQuantity)
                .mapToObj(ignore -> Lotto.of(getSortedAutoLottoNumbers(), LottoType.AUTO))
                .collect(Collectors.toList());
    }

    private static List<Integer> getSortedAutoLottoNumbers() {
        Collections.shuffle(numbers);
        List<Integer> generatedNumbers = new ArrayList<>(numbers.subList(0, Lotto.LOTTO_NUMBERS_SIZE));
        Collections.sort(generatedNumbers);
        return generatedNumbers;
    }
}

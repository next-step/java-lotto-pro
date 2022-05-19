package lotto.domain;

import static lotto.constants.LottoConstants.LOTTO_NUMBER_SIZE;
import static lotto.constants.LottoConstants.LOTTO_PRICE;
import static lotto.constants.LottoConstants.MAX;
import static lotto.constants.LottoConstants.MIN;
import static lotto.constants.LottoConstants.SPLIT_SYMBOL;
import static lotto.constants.LottoConstants.START_INDEX;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import lotto.constants.LottoConstants;
import lotto.domain.validator.LottoNumbersValidatorGroup;
import lotto.exception.ExceptionType;

public class LottoShop {

    public static final List<Integer> LOTTO_NUMBERS = IntStream.rangeClosed(MIN, MAX).boxed()
        .collect(Collectors.toList());
    private static final LottoNumbersValidatorGroup validatorGroup = LottoNumbersValidatorGroup.getInstance();

    private LottoShop() {
    }

    public static List<LottoNo> generate() {
        Collections.shuffle(LOTTO_NUMBERS);
        List<Integer> shuffleNo = LOTTO_NUMBERS.subList(START_INDEX, LOTTO_NUMBER_SIZE);
        return shuffleNo.stream().map(LottoNo::new).collect(Collectors.toList());
    }

    public static Lottos buyAutoLottos(Price price) {
        int count = price.getPrice() / LOTTO_PRICE;

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(generate()));
        }

        return new Lottos(lottos);
    }

    public static Lottos buyManualLottos(List<String> lottos, Price price) {
        validateBuyManual(lottos, price);
        lottos.forEach(validatorGroup::validate);
        price.spend(LottoConstants.LOTTO_PRICE * lottos.size());

        return new Lottos(lottos.stream()
            .map(LottoShop::splitLottoNumbers)
            .collect(Collectors.toList()));
    }

    private static Lotto splitLottoNumbers(String lottoNumbers) {
        List<LottoNo> numbers = Stream.of(lottoNumbers.split(SPLIT_SYMBOL))
            .map(LottoNo::new)
            .collect(Collectors.toList());

        return new Lotto(numbers);
    }

    private static void validateBuyManual(List<String> lottos, Price price) {
        if (lottos.size() > (price.getPrice() / LottoConstants.LOTTO_PRICE)) {
            throw new IllegalArgumentException(ExceptionType.IS_LACK_OF_PRICE.getMessage());
        }
    }
}

package step3.domain.factory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import step3.domain.LottoNumber;
import step3.domain.LottoNumbers;
import step3.domain.LottoNumbersBundle;
import step3.domain.constance.LottoConstant;

public class LottoNumbersFactory {
    private static final int LOTTO_SIZE = 6;
    private static final List<LottoNumber> cachedLottoNumbers = IntStream.rangeClosed(LottoConstant.MIN_NUMBER_RANGE,
            LottoConstant.MAX_NUMBER_RANGE)
        .mapToObj(LottoNumber::of)
        .collect(Collectors.toList());

    public static LottoNumbers createAutoLottoNumbers() {
        Collections.shuffle(cachedLottoNumbers);
        List<LottoNumber> autoLottoNumbers = cachedLottoNumbers.stream()
            .limit(LOTTO_SIZE)
            .collect(Collectors.toList());

        return LottoNumbers.of(autoLottoNumbers);
    }

    public static LottoNumbers createManualLottoNumbers(List<Integer> lottoNumbers) {
        List<LottoNumber> manualLottoNumbers = lottoNumbers.stream()
            .map(LottoNumber::of)
            .collect(Collectors.toList());

        return LottoNumbers.of(manualLottoNumbers);
    }

    public static List<LottoNumber> createManualLottoNumbersToList(List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
            .map(LottoNumber::of)
            .collect(Collectors.toList());
    }

    public static LottoNumbersBundle createLottoNumbersBundle(int quantity) {
        List<LottoNumbers> autoBundle = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            autoBundle.add(LottoNumbersFactory.createAutoLottoNumbers());
        }
        return LottoNumbersBundle.of(autoBundle);
    }

    public static LottoNumbers createLottoNumbers(List<Integer> numbers) {
        List<LottoNumber> lottoNumbers = numbers.stream()
            .map(LottoNumber::of)
            .collect(Collectors.toList());

        return LottoNumbers.of(lottoNumbers);
    }
}
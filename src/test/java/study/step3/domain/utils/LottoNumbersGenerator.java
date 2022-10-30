package study.step3.domain.utils;

import study.step3.domain.lottonumber.LottoNumber;
import study.step3.domain.lottonumber.LottoNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbersGenerator {
    public static LottoNumbers createLottoNumbers(int... numbers) {
        List<LottoNumber> lottoNumbers = Arrays.stream(numbers)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
        return new LottoNumbers(lottoNumbers);
    }
}

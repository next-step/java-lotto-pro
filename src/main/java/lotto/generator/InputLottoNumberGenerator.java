package lotto.generator;

import java.util.HashSet;
import java.util.Set;
import lotto.model.LottoNumber;
import lotto.util.StringToIntegerConverter;
import lotto.util.StringUtils;

public class InputLottoNumberGenerator implements LottoNumberGenerator {
    private final Set<LottoNumber> lottoNumbers = new HashSet<>();

    public InputLottoNumberGenerator(String input) {
        String[] numbers = StringUtils.split(input);
        for (String number : numbers) {
            number = number.trim();
            int lottoNumber = StringToIntegerConverter.parseInt(number);
            lottoNumbers.add(LottoNumber.valueOf(lottoNumber));
        }
    }

    @Override
    public Set<LottoNumber> generate() {
        return lottoNumbers;
    }
}

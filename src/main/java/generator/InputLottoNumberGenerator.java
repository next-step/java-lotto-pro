package generator;

import java.util.ArrayList;
import java.util.List;
import lotto.model.LottoNumber;
import util.StringToIntegerConverter;
import util.StringUtils;

public class InputLottoNumberGenerator implements LottoNumberGenerator {
    private final List<LottoNumber> lottoNumbers = new ArrayList<>();

    public InputLottoNumberGenerator(String input) {
        String[] numbers = StringUtils.split(input);
        for (String number : numbers) {
            number = number.trim();
            int lottoNumber = StringToIntegerConverter.parseInt(number);
            lottoNumbers.add(new LottoNumber(lottoNumber));
        }
    }

    @Override
    public List<LottoNumber> generate() {
        return lottoNumbers;
    }
}

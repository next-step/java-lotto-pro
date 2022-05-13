package generator;

import java.util.ArrayList;
import java.util.List;
import util.StringToIntegerConverter;
import util.StringUtils;

public class InputLottoNumberGenerator implements LottoNumberGenerator {
    private final List<Integer> lottoNumbers = new ArrayList<>();

    public InputLottoNumberGenerator(String input) {
        String[] numbers = StringUtils.split(input);
        for(String number : numbers) {
            number = number.trim();
            int lottoNumber = StringToIntegerConverter.parseInt(number);
            lottoNumbers.add(lottoNumber);
        }
    }

    @Override
    public List<Integer> generate() {
        return lottoNumbers;
    }
}

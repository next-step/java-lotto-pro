package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import common.utils.IntegerUtils;

public class ReadLineLottoNumberGenerator implements LottoNumberGenerator {

    private static final String READ_LINE_SPLIT_REGEX = ",";

    private final List<LottoNumber> lottoNumbers;

    public ReadLineLottoNumberGenerator(String readNumbers) {
        String[] textNumbers = readNumbers.split(READ_LINE_SPLIT_REGEX);
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for(String textNumber: textNumbers) {
            textNumber = textNumber.trim();
            int number = IntegerUtils.parseInt(textNumber);
            lottoNumbers.add(LottoNumber.from(number));
        }
        this.lottoNumbers = lottoNumbers;
    }

    @Override
    public List<LottoNumber> generateLottoNumbers() {
        return lottoNumbers;
    }
}

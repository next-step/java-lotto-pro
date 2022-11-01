package step3;

import step3.model.LottoNumber;

import java.util.ArrayList;
import java.util.List;

public class LottoUtils {

    static List<LottoNumber> getLottoNumbers(int... numbers) {

        List<LottoNumber> lottoNumbers = new ArrayList();
        for (int number : numbers) {
            lottoNumbers.add(LottoNumber.valueOf(number));
        }
        return lottoNumbers;
    }

}

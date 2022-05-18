package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoPassiveNumbers {

    private final LottoGameCount lottoGameCount;

    public LottoPassiveNumbers(LottoGameCount lottoGameCount) {
        this.lottoGameCount = lottoGameCount;
    }

    public List<LottoNumbers> generatePassiveNumbers(String[] splitPassiveNumber) {
        if (lottoGameCount.getPassiveCount() < 0) {
            return new ArrayList<>();
        }

        List<LottoNumbers> passiveNumbers = new ArrayList<>();
        for (int i = 0; i < lottoGameCount.getPassiveCount(); i++) {
            List<LottoNumber> passiveInputLottoNumbers = passiveInputLottoNumbers(splitPassiveNumber);
            passiveNumbers.add(new LottoNumbers(passiveInputLottoNumbers));
        }

        return passiveNumbers;
    }

    private List<LottoNumber> passiveInputLottoNumbers(String[] splitPassiveNumber) {
        return Arrays.stream(splitPassiveNumber)
                .map(val -> new LottoNumber(Integer.parseInt(val.trim())))
                .collect(Collectors.toList());
    }
}

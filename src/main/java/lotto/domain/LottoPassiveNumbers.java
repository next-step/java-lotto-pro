package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoPassiveNumbers {

    private final LottoPassiveCount lottoPassiveCount;

    public LottoPassiveNumbers(LottoPassiveCount lottoPassiveCount) {
        this.lottoPassiveCount = lottoPassiveCount;
    }

    public List<LottoNumbers> generatePassiveNumbers(String[] splitPassiveNumber) {
        List<LottoNumbers> passiveNumbers = new ArrayList<>();

        for (int i = 0; i < lottoPassiveCount.getPassiveCount(); i++) {
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

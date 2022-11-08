package domain;

import java.util.ArrayList;
import java.util.List;

public class ManualLottoMachine implements LottoMachine {
    private static final String DEFAULT_SPLIT_DILIMETER = ",";

    private final String[] inputManualLottoNumbers;
    private final Lottos lottos;

    public ManualLottoMachine(String[] inputManualLottoNumbers, Lottos lottos) {
        this.inputManualLottoNumbers = inputManualLottoNumbers;
        this.lottos = lottos;
    }

    @Override
    public void purchaseLotto() {
        for (int i = 0; i < inputManualLottoNumbers.length; i++) {
            lottos.add(splitPurchaseLottoNumbers(inputManualLottoNumbers[i]));
        }
    }

    private Lotto splitPurchaseLottoNumbers(String inputManualLottoNumber) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();

        for (String manualLottoNumber : inputManualLottoNumber.split(DEFAULT_SPLIT_DILIMETER)) {
            lottoNumbers.add(new LottoNumber(Integer.parseInt(manualLottoNumber.trim())));
        }

        return new Lotto(lottoNumbers);
    }

}

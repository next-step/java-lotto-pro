package domain;

import java.util.ArrayList;
import java.util.List;

public class ManualLottoMachine implements LottoMachine {
    private static final String DEFAULT_SPLIT_DILIMETER = ",";

    @Override
    public Lotto splitPurchaseLottoNumbers(String inputWinLottNumbers) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();

        for (String winNumber : inputWinLottNumbers.split(DEFAULT_SPLIT_DILIMETER)) {
            lottoNumbers.add(new LottoNumber(Integer.parseInt(winNumber.trim())));
        }

        return new Lotto(lottoNumbers);
    }

    @Override
    public Lottos purchaseLotto(int lottoTicketCount, Lottos lottos) {
        return null;
    }

}

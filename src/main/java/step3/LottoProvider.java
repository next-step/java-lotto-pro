package step3;

import step3.domain.LottoNumbers;
import step3.domain.LottoNumbersBundle;
import step3.domain.constance.LottoConstant;
import step3.domain.numbers.RandomNumbers;

public class LottoProvider {
    private static final int PRICE = 1000;
    private final LottoNumbersBundle lottoNumbersBundle = new LottoNumbersBundle();

    public void buyLotto(int count) {
        addLottoNumbers(count);
    }

    public void buyLotto(Amount amount) {
        addLottoNumbers(availableQuantity(amount.value()));
    }

    private void addLottoNumbers(int count) {
        for (int i = 0; i < count; i++) {
            LottoNumbers lottoNumbers = new LottoNumbers(getNumberStrategy());
            lottoNumbersBundle.addLottoNumbers(lottoNumbers);
        }
    }

    private RandomNumbers getNumberStrategy() {
        return new RandomNumbers(LottoConstant.MIN_NUMBER_RANGE,
            LottoConstant.MAX_NUMBER_RANGE, LottoNumbers.MAX_LOTTO_NUMBERS_SIZE);
    }

    private static int availableQuantity(int amount) {
        return amount / PRICE;
    }

    public int lottoNumbersBundleSize() {
        return lottoNumbersBundle.size();
    }
}

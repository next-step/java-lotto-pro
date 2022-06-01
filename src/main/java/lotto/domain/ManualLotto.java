package lotto.domain;

import java.util.List;

public class ManualLotto {
    private Money money;
    private List<String> inputLottoNumbers;

    private ManualLotto(Money money, List<String> inputLottoNumbers) {
        this.money = money;
        this.inputLottoNumbers = inputLottoNumbers;
    }

    public static ManualLotto of(Money money, List<String> inputLottoNumbers) {
        return new ManualLotto(money, inputLottoNumbers);
    }

    public Money getMoney() {
        return money;
    }

    public List<String> getInputLottoNumbers() {
        return inputLottoNumbers;
    }

    public int getAutoCount() {
        return this.money.getAllCount() - this.inputLottoNumbers.size();
    }
}

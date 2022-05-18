package lotto.domain;

import java.util.Collections;
import java.util.List;

public class InputLottoInformation {

    private final Money money;
    private final List<LottoNumbers> manualLottoNumbersList;

    private InputLottoInformation(Money money, List<LottoNumbers> manualLottoNumbersList) {
        this.money = money;
        this.manualLottoNumbersList = manualLottoNumbersList;
    }

    public static InputLottoInformation of(Money money, List<LottoNumbers> manualLottoNumbersList) {
        return new InputLottoInformation(money, manualLottoNumbersList);
    }

    public int totalLottoCount() {
        return this.money.calculatePurchasableCount();
    }

    public int manualLottoCount() {
        return this.manualLottoNumbersList.size();
    }

    public int autoLottoCount() {
        return totalLottoCount() - manualLottoCount();
    }

    public List<LottoNumbers> getManualLottoNumbersList() {
        return Collections.unmodifiableList(manualLottoNumbersList);
    }


}

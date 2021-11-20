package lotto.generator;

import lotto.model.LottoNumbers;
import lotto.model.LottoQuantity;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;

import static lotto.view.OutputView.printInputManualLottoNumbersGuideMessage;

public class ManualLottoGenerator implements LottoGenerator {
  @Override
  public List<LottoNumbers> generate(LottoQuantity quantity) {
    printInputManualLottoNumbersGuideMessage();
    InputView inputView = new InputView();
    List<LottoNumbers> lottoNumbers = new ArrayList<>();

    for (int i = 0; i < quantity.getQuantity(); i++) {
      lottoNumbers.add(inputView.inputManualLottoNumbers());
    }

    return lottoNumbers;
  }

}

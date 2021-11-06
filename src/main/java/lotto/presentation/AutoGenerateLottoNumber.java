package lotto.presentation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoNumbers;
import lotto.domain.lotto.Lottos;
import lotto.infrastructure.component.Label;
import lotto.infrastructure.datashared.UiSharedData;

public class AutoGenerateLottoNumber extends Screen {
  private final Label lottoLabel;

  public AutoGenerateLottoNumber() {
    lottoLabel = new Label();

    initialize();
  }

  @Override
  public void initialize() {
  }

  @Override
  public void render() {
    super.render();

    lottoLabel.render();
  }

  @Override
  public void update() {
    Lottos lottos = UiSharedData.getBuyLottos();

    List<String> printText = lottos.getStream().map(Lotto::getNumbers)
                                                .map(this::changeNumbersToText)
                                                .map(this::changeNumbersTextToPrintExpression)
                                                .collect(Collectors.toList());

    lottoLabel.setPrintText(String.join("\n", printText));
  }

  private String changeNumbersTextToPrintExpression(String numbersString) {
    return "[" + numbersString + "]";
  }

  private String changeNumbersToText(LottoNumbers numbers) {
    return numbers.getStream()
                  .map(LottoNumber::toString)
                  .reduce((result, number) -> result += ", " + number)
                  .orElse("");
  }
}

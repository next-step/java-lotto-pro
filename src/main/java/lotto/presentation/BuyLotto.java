package lotto.presentation;

import lotto.infrastructure.component.Label;
import lotto.infrastructure.component.TextEdit;
import lotto.infrastructure.datashared.UiSharedData;

public class BuyLotto extends Screen {
  private final TextEdit buyingLottoPrice;
  private final Label invalidAlertForInvalidLottosPrice;

  public BuyLotto() {
    buyingLottoPrice = new TextEdit("구입금액을 입력해 주세요.");
    invalidAlertForInvalidLottosPrice = new Label();
    
    initialize();
  }

  @Override
  public void initialize() {
    invalidAlertForInvalidLottosPrice.setPrintText("입력한 구입금액이 유효하지 않습니다.");
  }

  @Override
  public void render() {
    super.render();

    Integer lottosPrice = renderInputLottosPrice();

    UiSharedData.setLottosPrice(lottosPrice);
  }

  private Integer renderInputLottosPrice() {
    Integer lottosPrice = -1;

    while (lottosPrice < 0) {
      buyingLottoPrice.render();

      lottosPrice = inputLottosPrice();
    } 

    return lottosPrice;
  }

  private Integer inputLottosPrice() {
    Integer lottosPrice = - 1;

    try {
      lottosPrice = Integer.valueOf(buyingLottoPrice.getValue());
      
      invalidLottosPriceIsNegative(lottosPrice);
      
      return lottosPrice;
    } catch (Exception ex) {
      invalidAlertForInvalidLottosPrice.render();
    }

    return lottosPrice;
  }

  private void invalidLottosPriceIsNegative(Integer lottosPrice) {
    if (lottosPrice < 0) {
      invalidAlertForInvalidLottosPrice.render();  
    }
  }

  @Override
  public void update() {
  }
}

package lotto.presentation;

import lotto.infrastructure.component.MarginLabel;

public abstract class Screen {
  private final MarginLabel topMargin;

  protected Screen() {
    topMargin = new MarginLabel();
  }

  protected void initialize() {
  }

  protected abstract void update();

  public void render() {
    update();

    topMargin.render();
  }


  public void setTopMargin(Integer marginCount) {
    topMargin.setMarginCount(marginCount);
  }
}

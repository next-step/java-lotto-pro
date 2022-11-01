package lotto.domain.winningnumber.bonus.factory;

import lotto.domain.winningnumber.WinningNumber;

public interface BonusFactory {

    WinningNumber createWinningNumberWithBonus(String bonus);
}

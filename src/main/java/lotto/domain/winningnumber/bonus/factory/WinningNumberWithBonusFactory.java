package lotto.domain.winningnumber.bonus.factory;

import java.util.ArrayList;
import java.util.Set;
import lotto.domain.winningnumber.WinningNumber;
import lotto.domain.winningnumber.WinningNumberWithBonus;
import lotto.domain.winningnumber.bonus.validation.DefaultBonusValidator;

public class WinningNumberWithBonusFactory implements BonusFactory {

    private Set<Integer> winningNumber;

    public WinningNumberWithBonusFactory(Set<Integer> winningNumber) {
        this.winningNumber = winningNumber;
    }

    @Override
    public WinningNumber createWinningNumberWithBonus(String bonus) {
        new DefaultBonusValidator(winningNumber).validate(bonus);
        ArrayList<Integer> winningNumberWithBonus = new ArrayList<>(winningNumber);
        winningNumberWithBonus.add(Integer.parseInt(bonus));
        return new WinningNumberWithBonus(winningNumberWithBonus);
    }
}

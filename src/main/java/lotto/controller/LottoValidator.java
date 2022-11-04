package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.view.OutputView;

import java.util.List;

public abstract class LottoValidator {
    public static boolean isValidMoney(int money) {
        try {
            Money.validate(money);
        }catch (IllegalArgumentException e) {
            OutputView.print(e.getMessage());
            return false;
        }
        return true;
    }

    public static boolean isValidLottoNumber(int number) {
        try {
            LottoNumber.validate(number);
        }catch (IllegalArgumentException e) {
            OutputView.print(e.getMessage());
            return false;
        }
        return true;
    }

    public static boolean isValidLotto(List<LottoNumber> lottoNumbers) {
        try {
            Lotto.validate(lottoNumbers);
        }catch (IllegalArgumentException e) {
            OutputView.print(e.getMessage());
            return false;
        }
        return true;
    }

    public static boolean isValidWinningLotto(List<LottoNumber> lottoNumbers, LottoNumber bonusBall) {
        try {
            WinningLotto.validate(lottoNumbers, bonusBall);
        }catch (IllegalArgumentException e) {
            OutputView.print(e.getMessage());
            return false;
        }
        return true;
    }
}

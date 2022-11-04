package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class WinningNumbers extends Lotto {

    private BonusNumber bonusNumber;

    public WinningNumbers(List<Integer> winningNumberList) {
        super(winningNumberList.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toList()));
    }

    public WinningNumbers(List<Integer> winningNumberIntList, BonusNumber bonusNumber) {
        this(winningNumberIntList);
        if(bonusNumber.isMatch(winningNumberIntList)) {
            throw new IllegalArgumentException("보너스 번호가 당첨숫자와 중복될 수 없습니다.");
        }
        this.bonusNumber = bonusNumber;
    }

    public boolean isBonus(Lotto lotto) {
        return bonusNumber.isLottoMatch(lotto);
    }

}

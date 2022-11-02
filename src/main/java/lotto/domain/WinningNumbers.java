package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class WinningNumbers extends Lotto {

    private List<LottoNumber> winningNumbers;
    private BonusNumber bonusNumber;

    public WinningNumbers(String winningNumbersString) {
        this(winningNumbersString, new StringCommaSplitter());
    }

    public WinningNumbers(String winningNumbersString, StringToIntListSplitter lottoStringSplitter) {
        this(lottoStringSplitter.split(winningNumbersString));
    }

    public WinningNumbers(List<String> winningNumberList) {
        super(winningNumberList.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList()));
        this.winningNumbers = super.lottoNumbers;
    }

    public WinningNumbers(List<Integer> winningNumberIntList, BonusNumber bonusNumber) {
        this(winningNumberIntList.stream()
                .map(winningNumber -> winningNumber.toString())
                .collect(Collectors.toList()));
        this.bonusNumber = bonusNumber;
    }

    public boolean isBonus(Lotto lotto) {
        return lotto.isMatch(this.bonusNumber);
    }

}

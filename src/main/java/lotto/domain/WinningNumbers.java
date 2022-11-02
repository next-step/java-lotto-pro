package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class WinningNumbers extends Lotto {

    private List<LottoNumber> winningNumbers;

    public WinningNumbers(String winningNumbersString) {
        this(winningNumbersString, new StringCommaSplitter());
    }

    public WinningNumbers(String winningNumbersString, LottoStringSplitter lottoStringSplitter) {
        this(lottoStringSplitter.split(winningNumbersString));
    }

    public WinningNumbers(String[] winningNumberStringArray) {
        super(Arrays.stream(winningNumberStringArray)
                .map(LottoNumber::new)
                .collect(Collectors.toList()));
        this.winningNumbers = super.lottoNumbers;
    }



}

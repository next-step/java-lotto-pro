package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class WinningNumbers extends Lotto {

    private List<LottoNumber> winningNumbers;

    public WinningNumbers(String winningNumbersString) {
        super(Arrays.asList(winningNumbersString.split(",")).stream()
                .map(winningNumberString -> new LottoNumber(winningNumberString))
                .collect(Collectors.toList()));
        this.winningNumbers = super.lottoNumbers;
    }

}

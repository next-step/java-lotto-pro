package lotto.dto;

import lotto.domain.WinningNumbers;

import java.util.List;

public class WinningNumbersDto {

    private WinningNumbers winningNumbersDomain;
    private List<Integer> winningNumbers;

    public WinningNumbersDto(WinningNumbers winningNumbersDomain) {
        this.winningNumbersDomain = winningNumbersDomain;
        this.winningNumbers = winningNumbersDomain.getLottoDto().getLotto();
    }

    public WinningNumbersDto(WinningNumbers winningNumbersDomain, List<Integer> winningNumbers) {
        this(winningNumbersDomain);
        this.winningNumbers = winningNumbers;
    }

    public WinningNumbers getWinningNumbersDomain() {
        return winningNumbersDomain;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}

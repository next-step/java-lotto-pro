package step3.dto;

import java.util.List;

import step3.domain.Amount;
import step3.domain.LottoNumber;
import step3.domain.LottoNumbers;
import step3.domain.WinningLotto;

public class LottoStatisticsRequestDto {
    private final List<LottoNumbers> buyLottoList;
    private final WinningLotto winningLotto;
    private final Amount amount;

    public LottoStatisticsRequestDto(List<LottoNumbers> buyLottoList, Amount amount, WinningLotto winningLotto) {
        this.buyLottoList = buyLottoList;
        this.amount = amount;
        this.winningLotto = winningLotto;
    }

    public List<LottoNumbers> getBuyLottoList() {
        return buyLottoList;
    }

    public WinningLotto getWinningLotto() {
        return winningLotto;
    }

    public Amount getAmount() {
        return amount;
    }
}

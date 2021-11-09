package step3.dto;

import java.util.List;

import step3.domain.Amount;
import step3.domain.LottoNumber;
import step3.domain.LottoNumbers;
import step3.domain.WinningLotto;

public class LottoStatisticsRequestDto {
    private List<LottoNumbers> buyLottoList;
    private WinningLotto winningLotto;
    private Amount amount;

    @Deprecated
    public LottoStatisticsRequestDto(List<LottoNumbers> buyLottoList, Amount amount, WinningLotto winningLotto) {
        this.buyLottoList = buyLottoList;
        this.amount = amount;
        this.winningLotto = winningLotto;
    }

    public LottoStatisticsRequestDto() {

    }

    public void mapBuyLottoList(List<LottoNumbers> buyLottoList) {
        this.buyLottoList = buyLottoList;
    }

    public void mapWinningLotto(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public void mapAmount(Amount amount) {
        this.amount = amount;
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

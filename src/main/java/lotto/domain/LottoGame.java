package lotto.domain;

import lotto.view.OutputView;

import java.util.List;

public class LottoGame {

    public static final int LOTTO_PRICE = 1000;
    private final int payAmount;
    private final Lottos lottos;

    public LottoGame(int payAmount){
        this.payAmount = payAmount;
        int lottoAmount = calculateLottoAmount();
        OutputView.printLottoAmount(lottoAmount);
        lottos = new Lottos(lottoAmount);
    }

    public int calculateLottoAmount(){
        return payAmount/LOTTO_PRICE;
    }

    public void checkLottoNumbers(List<Integer> winningNumbers){
        lottos.findWinner(new Lotto(winningNumbers));
        lottos.printLottoResult();
    }
}
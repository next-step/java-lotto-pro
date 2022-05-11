package lotto.model;

import java.util.List;
import lotto.constant.ErrorMessage;
import lotto.constant.LottoMatchNumber;
import lotto.vo.Lotto;
import lotto.vo.Lottos;

public class LottoPlayService {

    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_MAX_PURCHASE_PRICE = 10_000_000;
    private static final int LOW_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final LottoGeneratorService lottoGeneratorService;

    public LottoPlayService() {
        lottoGeneratorService = new LottoGeneratorService();
    }

    public Lottos convertMoneyToLottos(int money) {
        validateMoney(money);

        int playCount = money / LOTTO_PRICE;
        return new Lottos(playCount);
    }

    private void validateMoney(int money) {
        validateLackMoney(money);
        validateOverMoney(money);
        validateUnitMoney(money);
    }

    private void validateLackMoney(int money) {
        if(money < LOTTO_PRICE){
            throw new IllegalArgumentException(ErrorMessage.LACK_MONEY);
        }
    }

    private void validateOverMoney(int money) {
        if(money >= LOTTO_MAX_PURCHASE_PRICE){
            throw new IllegalArgumentException(ErrorMessage.OVER_MONEY);
        }
    }

    private void validateUnitMoney(int money) {
        if(money % LOTTO_PRICE != 0){
            throw new IllegalArgumentException(ErrorMessage.INCORRECT_UNIT_MONEY);
        }
    }

    public Lottos generateLottosByPlayCount(int playCount) {
        Lottos lottos = new Lottos(playCount);
        for (int play = 0; play < lottos.getPlayCount(); play++) {
            Lotto lotto = lottoGeneratorService.generateLotto();
            lottos.addLotto(lotto);
        }
        return lottos;
    }

    public void playLottoGame(Lottos lottos, List<Integer> winningNumberList) {
        validateNumber(winningNumberList);
        for (Lotto lotto : lottos.getLottoList()){
            int matchNumberCount = calcMatchNumberCount(winningNumberList, lotto);
            lottos.updateResultCountMap(matchNumberCount);
        }
        calculateProfitRate(lottos);
    }

    private void validateNumber(List<Integer> winningNumberList) {
        for (int winningNumber : winningNumberList) {
            validateLottoNumber(winningNumber);
        }
    }

    private void validateLottoNumber(int winningNumber) {
        if(winningNumber < LOW_NUMBER || winningNumber > MAX_NUMBER){
            throw new IllegalArgumentException(ErrorMessage.NOT_LOTTO_NUMBER);
        }
    }

    private int calcMatchNumberCount(List<Integer> winningNumberList, Lotto lotto) {
        int matchNumberCount = 0;
        for (int lottoNumber : lotto.getNumberList()){
            matchNumberCount = countMatchNumber(winningNumberList,lottoNumber, matchNumberCount );
        }
        return matchNumberCount;
    }

    private int countMatchNumber(List<Integer> winningNumberList, int lottoNumber, int matchNumberCount) {
        if(winningNumberList.contains(lottoNumber)) {
            matchNumberCount++;
        }
        return matchNumberCount;
    }

    private void calculateProfitRate(Lottos lottos) {
        int money = lottos.getPlayCount() * LOTTO_PRICE;
        int totalWinningAmount = 0;
        for (LottoMatchNumber lottoMatchNumber : LottoMatchNumber.allMatchNumber()){
            totalWinningAmount += lottos.getResultCount(lottoMatchNumber.getMatchNumberCount()) * lottoMatchNumber.getWinningAmount();
        }
        double resultProfitRate = (double) totalWinningAmount / money;
        lottos.setResultProfitRate(resultProfitRate);
    }
}

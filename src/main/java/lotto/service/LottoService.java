package lotto.service;

import lotto.domain.Lotteries;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;

import java.util.HashSet;
import java.util.Set;

public class LottoService {

    public Lotteries buyLotto(int buyAmount) {
        return new Lotteries(buyAmount);
    }

    public LottoResult lottoResult(Lotteries lotteries, int[] readWinningNumbers, int buyAmount) {
        return new LottoResult(lotteries,readWinningNumbers,buyAmount);
    }

    public int readBuyAmount(String userInput) {
        int buyAmount = stringToNumber(userInput);
        if(buyAmount < Lotteries.LOTTO_AMOUNT)
            throw new IllegalArgumentException("구입금액은 " + Lotteries.LOTTO_AMOUNT + "원 이상이여야 합니다.");
        if(buyAmount > Lotteries.LOTTO_MAX_BUY_AMOUNT)
            throw new IllegalArgumentException("구입금액은 " + Lotteries.LOTTO_MAX_BUY_AMOUNT + "원 이하여야 합니다.");
        return buyAmount;
    }

    public int[] readWinningNumbers(String userInput) {
        String[] userInputs = userInput.split(",");
        winningNumberSizeCheck(userInputs);
        return getWinningNumbers(userInputs);
    }

    private int[] getWinningNumbers(String[] userInputs) {
        int[] winningNumbers = new int[Lotto.digit];
        Set<Integer> winningNumberSet = new HashSet<>();
        for(int i=0; i<Lotto.digit; i++) {
            int number = stringToNumber(userInputs[i]);
            winningNumberSet.add(number);
            winningNumberMinMaxValueCheck(number);
            winningNumbers[i] = number;
        }
        winningNumberDuplicateCheck(winningNumberSet);
        return winningNumbers;
    }

    private int stringToNumber(String str) {
        if(!str.matches("\\d+")) {
            throw new IllegalArgumentException("자연수 형식이 아닙니다.");
        }
        return Integer.parseInt(str);
    }

    private void winningNumberSizeCheck(String[] userInputs) {
        if(userInputs.length != Lotto.digit) {
            throw new IllegalArgumentException(",를 구분자로 6자리 입력해주세요.");
        }
    }

    private void winningNumberMinMaxValueCheck(int number) {
        if(number < Lotto.LOTTO_MIN_NUMBER) {
            throw new IllegalArgumentException("숫자는 "+ Lotto.LOTTO_MIN_NUMBER +"이상이여야 합니다.");
        }
        if(number > Lotto.LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException("숫자는 "+ Lotto.LOTTO_MAX_NUMBER +"이하여야 합니다.");
        }
    }

    private void winningNumberDuplicateCheck(Set<Integer> winningNumberSet) {
        if(winningNumberSet.size() != Lotto.digit)
            throw new IllegalArgumentException("중복숫자는 입력할 수 없습니다.");
    }

}

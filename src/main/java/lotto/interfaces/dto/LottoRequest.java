package lotto.interfaces.dto;

import lotto.infrastructure.util.StringUtils;

import java.util.Arrays;
import java.util.List;

public class LottoRequest {

    public static class PurchaseRequest {
        private final String payAmount;

        public PurchaseRequest(String payAmount) {
            this.payAmount = payAmount;
        }

        public String getPayAmount() {
            return payAmount;
        }
    }

    public static class ResultRequest {
        private final List<Integer> winningNumbers;
        private final Integer bonusBall;

        public ResultRequest(String[] winningNumbers, String bonusBall) {
            this.winningNumbers = StringUtils.convertIntegers(Arrays.asList(winningNumbers));
            this.bonusBall = Integer.parseInt(bonusBall);
        }

        public List<Integer> getWinningNumbers() {
            return winningNumbers;
        }

        public Integer getBonusBall() {
            return bonusBall;
        }
    }
}

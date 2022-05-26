package lotto.interfaces.dto;

import lotto.infrastructure.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoRequest {

    public static class PurchaseRequest {
        private final int payAmount;
        private final int manualLottoCount;
        private final List<List<Integer>> manualLottoNumbers;

        public PurchaseRequest(int payAmount, int manualLottoCount, List<List<String>> manualLottoNumbers) {
            this.payAmount = payAmount;
            this.manualLottoCount = manualLottoCount;
            this.manualLottoNumbers = manualLottoNumbers.stream()
                    .map(StringUtils::convertIntegers)
                    .collect(Collectors.toList());
        }

        public int getPayAmount() {
            return payAmount;
        }

        public int getManualLottoCount() {
            return manualLottoCount;
        }

        public List<List<Integer>> getManualLottoNumbers() {
            return manualLottoNumbers;
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

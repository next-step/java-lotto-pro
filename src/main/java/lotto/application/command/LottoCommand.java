package lotto.application.command;

import java.util.List;

public class LottoCommand {

    public static class Purchase {
        private final int payAmount;
        private final int manualLottoCount;
        private final List<List<Integer>> manualLottoNumbers;

        public Purchase(int payAmount, int manualLottoCount, List<List<Integer>> manualLottoNumbers) {
            this.payAmount = payAmount;
            this.manualLottoCount = manualLottoCount;
            this.manualLottoNumbers = manualLottoNumbers;
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
}

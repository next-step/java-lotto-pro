package lotto.domain.lottonumber.purchase;

import lotto.domain.lottonumber.purchase.factory.validation.NumberValidator;
import lotto.domain.lottonumber.purchase.role.LottoNumberCountMaker;
import lotto.domain.lottonumber.purchase.role.PurchaseRole;

public class Purchase {

    public static final int LOTTO_COST = 1000;
    public static final String MANUAL_HEADER_TEXT = "수동으로 ";
    public static final String AUTO_HEADER_TEXT = "장, 자동으로 ";
    public static final int MANUAL_LOTTO_THRESHOLD = 0;
    private static final String LINEBREAK = "\n";
    private static final String LAST_HEADER_TEXT = "개를 구매했습니다." + LINEBREAK;
    private static final String PROFIT_MARGIN_FORMAT = "%.2f";
    private static final String RESULT_START_TEXT = "총 수익률은 ";
    private static final String RESULT_END_TEXT = "입니다.";
    private static final String RESULT_APPEND_TEXT = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    private static final String ERROR_AUTO_LOTTO_COUNT_MESSAGE = "[ERROR] 구입금액을 넘게 구매할 수 없습니다.";
    private String purchase;
    private int beginningPurchase;
    private int manualLottoCount;
    private PurchaseRole role;

    public Purchase(String purchase) {
        this.purchase = purchase;
        this.beginningPurchase = Integer.parseInt(purchase);
        this.role = new LottoNumberCountMaker();
    }

    public int makeLottoNumberCount() {
        return role.makeLottoNumberCount(purchase);
    }

    public String makeProfitMargin(int totalProfit) {
        double profitMargin = (double) totalProfit / (double) beginningPurchase;
        String formatProfitMargin = String.format(PROFIT_MARGIN_FORMAT, profitMargin);
        String result = RESULT_START_TEXT + formatProfitMargin + RESULT_END_TEXT;
        if (profitMargin < 1) {
            result += RESULT_APPEND_TEXT;
        }
        return result;
    }

    public void validateManualLottoCount(String readManualLottoCount) {
        new NumberValidator().validate(readManualLottoCount);
        manualLottoCount = Integer.parseInt(readManualLottoCount);
        if ((beginningPurchase / LOTTO_COST < manualLottoCount)) {
            throw new IllegalArgumentException(ERROR_AUTO_LOTTO_COUNT_MESSAGE);
        }
        purchase = String.valueOf(beginningPurchase - (manualLottoCount * LOTTO_COST));
    }

    public String makeLottoNumbersResultHeader() {
        if (manualLottoCount != MANUAL_LOTTO_THRESHOLD) {
            return MANUAL_HEADER_TEXT + manualLottoCount + AUTO_HEADER_TEXT + (Integer.parseInt(purchase) / LOTTO_COST)
                    + LAST_HEADER_TEXT;
        }
        return beginningPurchase + LAST_HEADER_TEXT;
    }
}

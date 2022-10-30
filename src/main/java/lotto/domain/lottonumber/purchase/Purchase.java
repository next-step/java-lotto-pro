package lotto.domain.lottonumber.purchase;

import lotto.domain.lottonumber.purchase.role.LottoNumberCountMaker;
import lotto.domain.lottonumber.purchase.role.PurchaseRole;

public class Purchase {

    public static final int LOTTO_COST = 1000;
    private static final String PROFIT_MARGIN_FORMAT = "%.2f";
    private static final String RESULT_START_TEXT = "총 수익률은 ";
    private static final String RESULT_END_TEXT = "입니다.";
    private static final String RESULT_APPEND_TEXT = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    private String purchase;
    private PurchaseRole role;

    public Purchase(String purchase) {
        this.purchase = purchase;
        this.role = new LottoNumberCountMaker();
    }

    public int makeLottoNumberCount() {
        return role.makeLottoNumberCount(purchase);
    }

    public String makeProfitMargin(int totalProfit) {
        double profitMargin = (double) totalProfit / (double) Integer.parseInt(purchase);
        String formatProfitMargin = String.format(PROFIT_MARGIN_FORMAT, profitMargin);
        String result = RESULT_START_TEXT + formatProfitMargin + RESULT_END_TEXT;
        if (profitMargin < 1) {
            result += RESULT_APPEND_TEXT;
        }
        return result;
    }
}

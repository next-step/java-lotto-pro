package utils;

import java.text.DecimalFormat;

public final class MoneyFormat {

    private static final DecimalFormat DF = new DecimalFormat("###,###");

    private MoneyFormat() {}

    public static String getMoneyExpression(long money) {
        return DF.format(money);
    }
}

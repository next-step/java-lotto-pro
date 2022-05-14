package lotto_auto.view;

public class Output {
    public static final String purchaseStartGuide = "구입금액을 입력해 주세요.";
    public static final String purchaseCountGuideFormat = "%d개를 구매했습니다.\n";
    public static final String winningLottoInputGuide = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String lottoFiguresTitle = "\n당첨 총계";
    public static final String lottoFiguresDelimiter = "----------";
    public static final String profitRateGuideFormat = "총 수익률은 %s입니다.\n";

    public void showNotice(String str) {
        System.out.println(str);
    }

    public void showNotice(String strFormat, int value) {
        System.out.format(strFormat, value);
    }

    public void showNotice(String strFormat, String value) {
        System.out.format(strFormat, value);
    }

    public void showError(Throwable e) {
        System.out.println(e.getMessage());
    }
}

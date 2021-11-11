package lotto.ui;

import lotto.domain.Playslips;
import lotto.domain.Price;
import lotto.domain.Retailer;
import nextstep.utils.Console;

public class InputView {

    public static String askPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요");
        return Console.readLine();
    }

    public static Playslips purchaseLotto(final String purchaseAmount) {
        final Playslips playslips = Retailer.buy(new Price(Long.parseLong(purchaseAmount)));
        System.out.println(playslips.size() + "개를 구매했습니다.");
        System.out.println(playslips);
        return playslips;
    }

    public static String askPastWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }
}

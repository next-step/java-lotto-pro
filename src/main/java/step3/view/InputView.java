package step3.view;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String LOTTO_NUMBER_STATUS = "[%s]";

    private Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public int readyBuyingLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        return  this.scanner.nextInt();
    }

    public void printBoughtLottoCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public String readyLuckyLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return this.scanner.next();
    }

    public void printLottos(List<List<Integer>> lottos) {
        for (List<Integer> lotto : lottos) {
            showLotto(lotto);
        }
    }

    private void showLotto(List<Integer> lottos) {
        String status = String.format(LOTTO_NUMBER_STATUS, lottos.stream()
                .map(Object::toString)
                .collect(Collectors.joining(",")));

        System.out.println(status);
    }
}

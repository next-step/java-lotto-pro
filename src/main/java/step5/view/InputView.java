package step5.view;

import step5.model.Lottos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {

    private static final String LOTTO_NUMBER_STATUS = "[%s]";

    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * 구입 금액 입력
     *
     * @return 구입 금액
     */
    public String readyBuyingLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        return this.scanner.nextLine();
    }

    /**
     * 수동 로또 구매 수 입력
     *
     * @return 구매할 수동 로또 수
     */
    public String readyBuyingManualLotto() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return this.scanner.nextLine();
    }

    /**
     * 보너스 번호 입력
     *
     * @return 보너스 번호
     */
    public String readyBonus() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return this.scanner.nextLine();
    }

    /**
     * 로또 구입 개수 출력
     *
     * @param autoLottoCount   자동 로또 구입 개수
     * @param manualLottoCount 수동 로또 구입 개수
     */
    public void printBoughtLottoCountAndManualLottoCount(int autoLottoCount, int manualLottoCount) {
        System.out.println(String.format("수동으로 %d장, 자동으로 %d개를 구매했습니다.", manualLottoCount, autoLottoCount));
    }

    /**
     * 당첨 번호 입력
     *
     * @return 당첨 번호
     */
    public String readyWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return this.scanner.nextLine();
    }

    /**
     * 구입한 로또 번호 출력
     *
     * @param lottos 로또 리스트
     */
    public void printLottos(Lottos lottos) {
        lottos.print(System.out::println);
    }

    /**
     * 수동 로또 번호 리스트 입력
     *
     * @param countManualLotto 구입할 수동 로또 수
     * @return 입력한 수동 로또 번호
     */
    public List<String> readyManualLottos(int countManualLotto) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        return IntStream.range(0, countManualLotto)
                .mapToObj(i -> this.scanner.nextLine())
                .collect(Collectors.toList());
    }
}

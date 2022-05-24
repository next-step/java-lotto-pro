package lotto.view;

import calculator.domain.StringSplitter;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;
import lotto.domain.Lottos;
import lotto.domain.MatchResult;

public class View {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String MONEY_UNIT = "원";

    public View() {
    }

    public void outputOrderPrice() {
        System.out.println("구입 금액을 입력해 주세요. (자연수만 가능하며, 1게임 가격에 따라 구입 개수가 정해짐)");
    }

    public void outputOrderLottoList(Lottos manualLottos, Lottos autoLottos) {

        System.out.println(String.format("수동으로 %d장, 자동으로 %d개를 구매했습니다.", manualLottos.size(), autoLottos.size()));
        System.out.print(manualLottos.toString());
        System.out.println(autoLottos.toString());
    }

    public void outputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요. (','로 구분)");
    }

    public void outputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
    }

    public void outputWinningStatistic(Map<MatchResult, Integer> winningResults) {

        StringBuilder builder = new StringBuilder();

        builder.append("당첨 통계\n" + "---------\n");

        for (MatchResult winningMatchResult : MatchResult.winningMatchResults()) {
            builder.append(toMatchResultString(winningMatchResult, winningResults.get(winningMatchResult)));
        }

        System.out.println(builder);

    }

    public void outputEarning(BigDecimal totalEarning) {
        System.out.println(toEarningString(totalEarning));
    }

    public void outputManualLottoSize() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
    }

    public void outputManualLottoNumbers() {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    }

    private String toMatchResultString(MatchResult matchResult, int matchCount) {
        return matchResult.getMatchCount() + "개 일치" + toBonusNumberOutputString(matchResult) + "("
                + matchResult.getCashPrize()
                .toString()
                + MONEY_UNIT + ")- " + matchCount + "개\n";
    }

    private String toBonusNumberOutputString(MatchResult matchResult) {
        if (matchResult.equals(MatchResult.SECOND)) {
            return ", 보너스 번호 일치";
        }
        return "";
    }

    private String toEarningString(BigDecimal totalEarning) {
        String result;
        result = "총 수익률은 " + String.format("%.2f", totalEarning) + " 입니다.";
        if (totalEarning.compareTo(BigDecimal.ONE) == 1) {
            return result + "(기준이 1이기 때문에 결과적으로 이득이라는 의미임)";
        }
        return result + "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    }


    public String inputOrderPrice() {
        return scanner.nextLine();
    }

    public String[] inputWinningNumbers() {
        String winingNumbers = scanner.nextLine();
        return StringSplitter.split(winingNumbers);
    }

    public String inputBonusNumber() {
        return scanner.nextLine();
    }

    public int inputManualLottoSize() {
        return Integer.parseInt(scanner.nextLine());
    }

    public String[] inputManualNumbers(int size) {
        String[] manualNumbers = new String[size];
        for (int index = 0; index < size; index++) {
            manualNumbers[index] = scanner.nextLine();
        }
        return manualNumbers;
    }


}

package step3.view;

import step3.domain.Grades;
import step3.domain.Lotto;
import step3.domain.LottoQuantities;
import step3.domain.Lottos;
import step3.domain.enums.Grade;

public class ResultView {

    public static void printLottoQuantityMessage(LottoQuantities quantities) {
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.\n", quantities.getManualLottoQuantity(),
                quantities.getAutoLottoQuantity());
    }

    public static void printLottosNumberMessage(Lottos lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printTotalGrades(Grades grades) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (Grade grade : Grade.values()) {
            printGradeIfNotMiss(grades, grade);
        }
    }

    private static void printGradeIfNotMiss(Grades grades, Grade grade) {
        if (grade != Grade.MISS) {
            System.out.print(getMessgeByGrade(grade));
            System.out.printf(" - %d개\n", grades.getGradeCount(grade));
        }
    }

    private static String getMessgeByGrade(Grade grade) {
        if (Grade.SECOND.equals(grade)) {
            return String.format("%d개 일치, 보너스 볼 일치(%d원)", grade.getCount(), grade.getAmount());
        }
        return String.format("%d개 일치 (%d원)", grade.getCount(), grade.getAmount());
    }

    public static void printProfitRate(Float profitRate) {
        System.out.printf("총 수익률은 %.2f입니다.", profitRate);
    }
}

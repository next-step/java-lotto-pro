import java.util.List;

public class ResultView {

    private ResultView() {
    }

    public static void printBuyResult(int count){
        System.out.printf("%d개를 구매했습니다.\n", count);
    }

    public static void printLottoList(Lottos lottoList){
        for(int i = 0; i < lottoList.size(); i++){
            System.out.println(lottoList.get(i));
        }
    }

    public static void printResult(User user) {
        System.out.println("\n당첨 통계\n-------------");
        System.out.printf("3개 일치 (5000원)-%d개\n", user.match(3));
        System.out.printf("4개 일치 (50000원)-%d개\n", user.match(4));
        System.out.printf("5개 일치 (1500000원)-%d개\n", user.match(5));
        System.out.printf("6개 일치 (2000000000원)-%d개\n", user.match(6));
        System.out.printf("총 수익률은 %.2f 입니다.", user.getProfitRate());
    }

}

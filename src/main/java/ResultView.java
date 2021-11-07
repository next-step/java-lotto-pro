import java.util.List;

public class ResultView {
    public static void printBuyResult(int count){
        System.out.printf("%d개를 구매했습니다.\n", count);
    }

    public static void printLottoList(List<Lotto> lottoList){
        for(Lotto lotto : lottoList) {
            System.out.println(lotto);
        }
    }
}

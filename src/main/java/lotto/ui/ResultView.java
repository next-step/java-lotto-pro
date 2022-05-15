package lotto.ui;

public class ResultView {
    public static void printTicketCount(int purchasePrice) {
        System.out.println(String.format("%d개를 구매했습니다.", purchasePrice));
    }

    public static void printTicketLottoNumbers(String ticketLottoNumbers) {
        System.out.println(ticketLottoNumbers);
    }
}

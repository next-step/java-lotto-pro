package lottoauto;

public class LottoStarter {
    public void startLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        String inputStr = "15000";
        int price = Integer.parseInt(inputStr);

        System.out.println(price/1000+"개를 구매했습니다.");
    }


}

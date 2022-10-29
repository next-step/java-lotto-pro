import controller.Lotto;

public class LottoApplication {
    public static void main(String[] args) {
        try {
            Lotto lotto = new Lotto();
            lotto.run();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

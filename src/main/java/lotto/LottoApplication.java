package lotto;

import lotto.controller.LottoMachineController;
import lotto.exception.*;

public class LottoApplication {
    public static void main(String[] args) {

        try {
            LottoMachineController machine = new LottoMachineController();
            machine.run();
        } catch (LottoPurchaseAmountException lpae) {
            System.out.println(lpae.getMessage());
        } catch (LottoMatchNumberException lmne) {
            System.out.println(lmne.getMessage());
        } catch (LottoBonusNumberException lbne) {
            System.out.println(lbne.getMessage());
        } catch (LottoActiveNumberException lane) {
            System.out.println(lane.getMessage());
        } catch (LottoNumberOutOfRangeException lnofre) {
            System.out.println(lnofre.getMessage());
        } catch (LottoNumberSizeException lnse) {
            System.out.println(lnse.getMessage());
        }

    }
}

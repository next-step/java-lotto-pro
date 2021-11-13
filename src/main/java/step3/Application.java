package step3;

import step3.machine.LottoMachineFacade;
import step3.view.RequestView;
import step3.view.ReturnView;

public class Application {
	public static void main(String[] args) {
		LottoMachineFacade lottoMachineFacade = new LottoMachineFacade(
			new RequestView(),
			new ReturnView());
		lottoMachineFacade.LottoMachineExecute();
	}
}

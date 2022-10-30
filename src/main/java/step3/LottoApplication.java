package step3;

import step3.controller.LottoController;
import step3.model.machine.ShuffleTicketGenerator;
import step3.model.machine.TicketGenerator;

public class LottoApplication {

    public static void main(String[] args) {
        TicketGenerator ticketGenerator = new ShuffleTicketGenerator();
        LottoController lottoController = new LottoController(ticketGenerator);
        lottoController.start();
    }

}

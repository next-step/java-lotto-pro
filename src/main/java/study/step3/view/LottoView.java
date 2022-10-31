package study.step3.view;

import study.step3.domain.lotto.Lottos;
import study.step3.message.LottoMessage;

public class LottoView {

    public static void printLottos(Lottos lottos) {
        StringBuilder printer = new StringBuilder();
        printer.append(String.format(LottoMessage.OUTPUT_COUNTS_OF_LOTTOS_FORMAT.message(), lottos.size()))
                .append(lottos.report());
        ResultView.output(printer);
    }
}

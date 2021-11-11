package study.lotto.view.input;

import study.lotto.controller.dto.LottoOrderMoneyRequestDto;
import study.lotto.controller.dto.LottoOrderRequestDto;
import study.lotto.view.InvalidLottoInputViewException;
import study.utils.Console;
import study.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static study.lotto.view.input.LottoParser.parseNumber;
import static study.lotto.view.input.LottoParser.parseSet;

public class LottoManualOrderInputView {

    private static final String LOTTO_MANUAL_ORDER_COUNT_INPUT_GUIDE_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String LOTTO_MANUAL_TICKET_LOTTERY_INPUT_GUIDE_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String LOTTO_MANUAL_ORDER_COUNT_OVER_ERROR_MESSAGE_TEMPLATE = "금액이 부족합니다. 최대 %d개 구매할 수 있습니다.";
    private static final String LOTTO_MANUAL_TICKET_LOTTERY_NUMBER_EMPTY_ERROR_MESSAGE = "아무것도 입력되지 않았습니다.";
    private static final int PRICE_OF_LOTTO_TICKET = 1_000;
    private static final String DELIMITER = ",";

    private LottoManualOrderInputView() {
    }

    public static LottoOrderRequestDto submit(final LottoOrderMoneyRequestDto orderMoneyRequestDto) {
        final int money = orderMoneyRequestDto.getMoney();
        final int manualOrderCount = getInputManualOrderCount(money);
        final List<Set<Integer>> ticketLotteryBundle = getInputManualTicketLotteryBundle(manualOrderCount);
        return new LottoOrderRequestDto(ticketLotteryBundle, money);
    }

    private static int getInputManualOrderCount(final int orderMoney) {
        System.out.println(LOTTO_MANUAL_ORDER_COUNT_INPUT_GUIDE_MESSAGE);
        try {
            final int manualOrderCount = parseNumber(Console.readLine());
            validateManualOrderCount(manualOrderCount, orderMoney);
            return manualOrderCount;
        } catch (InvalidLottoInputViewException exception) {
            System.out.println(exception.getMessage());
        }
        return getInputManualOrderCount(orderMoney);
    }

    private static void validateManualOrderCount(final int manualOrderCount, final int orderMoney) {
        final int manualOrderMoney = manualOrderCount * PRICE_OF_LOTTO_TICKET;
        if (orderMoney < manualOrderMoney) {
            final int maxOrderCount = orderMoney / PRICE_OF_LOTTO_TICKET;
            throw new InvalidLottoInputViewException(String.format(LOTTO_MANUAL_ORDER_COUNT_OVER_ERROR_MESSAGE_TEMPLATE, maxOrderCount));
        }
    }

    private static List<Set<Integer>> getInputManualTicketLotteryBundle(final int manualOrderCount) {
        System.out.println(LOTTO_MANUAL_TICKET_LOTTERY_INPUT_GUIDE_MESSAGE);
        try {
            final List<Set<Integer>> ticketLotteryBundle = new ArrayList<>();
            for (int i = 0; i < manualOrderCount; i++) {
                final String ticketLotteryNumbers = Console.readLine();
                validateTicketLotteryNumbersNotNull(ticketLotteryNumbers);
                ticketLotteryBundle.add(parseSet(ticketLotteryNumbers.trim(), DELIMITER));
            }
            return ticketLotteryBundle;
        } catch (InvalidLottoInputViewException exception) {
            System.out.println(exception.getMessage());
        }

        return getInputManualTicketLotteryBundle(manualOrderCount);
    }

    private static void validateTicketLotteryNumbersNotNull(final String ticketLotteryNumbers) {
        if (StringUtils.isEmpty(ticketLotteryNumbers)) {
            throw new InvalidLottoInputViewException(LOTTO_MANUAL_TICKET_LOTTERY_NUMBER_EMPTY_ERROR_MESSAGE);
        }
    }
}

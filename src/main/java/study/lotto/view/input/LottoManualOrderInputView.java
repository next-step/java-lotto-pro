package study.lotto.view.input;

import study.lotto.controller.dto.LottoOrderMoneyRequestDto;
import study.lotto.controller.dto.LottoOrderRequestDto;
import study.lotto.model.Lottery;
import study.lotto.model.LottoNumber;
import study.lotto.model.LottoStore;
import study.lotto.view.InvalidLottoInputViewException;
import study.utils.Console;
import study.utils.StringUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoManualOrderInputView {

    private static final String LOTTO_MANUAL_ORDER_COUNT_INPUT_GUIDE_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String LOTTO_MANUAL_TICKET_LOTTERY_INPUT_GUIDE_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String LOTTO_MANUAL_ORDER_COUNT_ONLY_ERROR_MESSAGE = "수동으로 구매할 로또 수는 숫자만 입력가능합니다.";
    private static final String LOTTO_MANUAL_ORDER_COUNT_OVER_ERROR_MESSAGE_TEMPLATE = "금액이 부족합니다. 최대 %d 개 구매할 수 있습니다.";

    private static final String LOTTO_MANUAL_TICKET_LOTTERY_NUMBER_SIZE_ERROR_MESSAGE = "쉼표로 구분하여 총 6개의 당첨번호를 입력해야 합니다.";
    private static final String LOTTO_MANUAL_TICKET_LOTTERY_NUMBER_MAL_FORMED_ERROR_MESSAGE = "로또번호는 1부터 45까지의 숫자로 구성되어야 합니다.";
    private static final String LOTTO_MANUAL_TICKET_LOTTERY_NUMBER_EMPTY_ERROR_MESSAGE = "아무것도 입력되지 않았습니다.";
    private static final String DELIMITER = ",";

    private LottoManualOrderInputView() {
    }

    public static LottoOrderRequestDto submit(final LottoOrderMoneyRequestDto orderMoneyRequestDto) {
        final int manualOrderCount = getInputManualOrderCount(orderMoneyRequestDto);
        final int autoOrderMoney = change(orderMoneyRequestDto, manualOrderCount);
        final List<Set<Integer>> ticketLotteryBundle = getInputManualTicketLotteryBundle(manualOrderCount);
        return new LottoOrderRequestDto(ticketLotteryBundle, autoOrderMoney);
    }

    private static int change(LottoOrderMoneyRequestDto orderMoneyRequestDto, int manualOrderCount) {
        return orderMoneyRequestDto.getMoney() - manualOrderCount * LottoStore.PRICE_OF_LOTTO_TICKET;
    }

    private static int getInputManualOrderCount(final LottoOrderMoneyRequestDto orderMoneyRequestDto) {
        System.out.println(LOTTO_MANUAL_ORDER_COUNT_INPUT_GUIDE_MESSAGE);
        try {
            final int manualOrderCount = parseInt(Console.readLine());
            validateManualOrderCount(manualOrderCount, orderMoneyRequestDto);
            return manualOrderCount;
        } catch (InvalidLottoInputViewException exception) {
            System.out.println(exception.getMessage());
        }
        return getInputManualOrderCount(orderMoneyRequestDto);
    }

    private static void validateManualOrderCount(final int manualOrderCount, final LottoOrderMoneyRequestDto orderMoneyRequestDto) {
        final int manualOrderMoney = manualOrderCount * LottoStore.PRICE_OF_LOTTO_TICKET;
        final int orderMoney = orderMoneyRequestDto.getMoney();
        if (orderMoney < manualOrderMoney) {
            final int maxOrderCount = orderMoney / LottoStore.PRICE_OF_LOTTO_TICKET;
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
                ticketLotteryBundle.add(toLottery(ticketLotteryNumbers.trim()));
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

    private static int parseInt(final String numberStr) {
        try {
            return Integer.parseInt(numberStr.trim());
        } catch (final NumberFormatException exception) {
            throw new InvalidLottoInputViewException(LOTTO_MANUAL_ORDER_COUNT_ONLY_ERROR_MESSAGE);
        }
    }

    private static HashSet<Integer> toLottery(final String ticketLotteryNumbers) {
        final String[] ticketLotteryNumberArr = ticketLotteryNumbers.split(DELIMITER);
        final HashSet<Integer> numberSet = new HashSet<>();
        for (final String ticketLotteryNumber : ticketLotteryNumberArr) {
            numberSet.add(parseLottoNumber(ticketLotteryNumber));
        }
        if (numberSet.size() != Lottery.LOTTO_NUMBER_COUNT) {
            throw new InvalidLottoInputViewException(LOTTO_MANUAL_TICKET_LOTTERY_NUMBER_SIZE_ERROR_MESSAGE);
        }
        return numberSet;
    }

    private static int parseLottoNumber(String winningNumber) {
        final int number = parseInt(winningNumber);
        if (number < LottoNumber.MIN_NUMBER || number > LottoNumber.MAX_NUMBER) {
            throw new InvalidLottoInputViewException(LOTTO_MANUAL_TICKET_LOTTERY_NUMBER_MAL_FORMED_ERROR_MESSAGE);
        }
        return number;
    }
}

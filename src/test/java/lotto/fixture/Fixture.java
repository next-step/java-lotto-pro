package lotto.fixture;

import lotto.domain.number.Payment;
import lotto.domain.ticket.LottoNumbers;
import lotto.domain.ticket.Ticket;

import java.util.Arrays;
import java.util.List;

public class Fixture {
    public static LottoNumbers LOTTO_NUMBER_1_2_3_4_5_6 = LottoNumbers.from(Arrays.asList(1, 2, 3, 4, 5, 6));
    public static LottoNumbers LOTTO_NUMBER_2_3_4_5_6_7 = LottoNumbers.from(Arrays.asList(2, 3, 4, 5, 6, 7));
    public static LottoNumbers LOTTO_NUMBER_3_4_5_6_7_8 = LottoNumbers.from(Arrays.asList(3, 4, 5, 6, 7, 8));
    public static LottoNumbers LOTTO_NUMBER_4_5_6_7_8_9 = LottoNumbers.from(Arrays.asList(4, 5, 6, 7, 8, 9));
    public static LottoNumbers LOTTO_NUMBER_5_6_7_8_9_10 = LottoNumbers.from(Arrays.asList(5, 6, 7, 8, 9, 10));
    public static LottoNumbers LOTTO_NUMBER_6_7_8_9_10_11 = LottoNumbers.from(Arrays.asList(6, 7, 8, 9, 10, 11));
    public static LottoNumbers LOTTO_NUMBER_7_8_9_10_11_12 = LottoNumbers.from(Arrays.asList(7, 8, 9, 10, 11, 12));


    public static Ticket TICKET_1_2_3_4_5_6 = Ticket.from(LOTTO_NUMBER_1_2_3_4_5_6);
    public static Ticket TICKET_2_3_4_5_6_7 = Ticket.from(LOTTO_NUMBER_2_3_4_5_6_7);
    public static Ticket TICKET_3_4_5_6_7_8 = Ticket.from(LOTTO_NUMBER_3_4_5_6_7_8);
    public static Ticket TICKET_4_5_6_7_8_9 = Ticket.from(LOTTO_NUMBER_4_5_6_7_8_9);
    public static Ticket TICKET_5_6_7_8_9_10 = Ticket.from(LOTTO_NUMBER_5_6_7_8_9_10);
    public static Ticket TICKET_6_7_8_9_10_11 = Ticket.from(LOTTO_NUMBER_6_7_8_9_10_11);
    public static Ticket TICKET_7_8_9_10_11_12 = Ticket.from(LOTTO_NUMBER_7_8_9_10_11_12);

    public static List<Ticket> TICKET_LIST_SAMPLE = Arrays.asList(
        TICKET_1_2_3_4_5_6, TICKET_2_3_4_5_6_7, TICKET_3_4_5_6_7_8, TICKET_4_5_6_7_8_9, TICKET_5_6_7_8_9_10, TICKET_6_7_8_9_10_11, TICKET_7_8_9_10_11_12);
    public static Payment TOTAL_PAYMENT = Payment.from(Payment.MINIMUM_MONEY * TICKET_LIST_SAMPLE.size());
    public static LottoNumbers WINNING_LOTTO_NUMBERS_1_2_3_4_5_6 = LottoNumbers.from(Arrays.asList(1, 2, 3, 4, 5, 6));
    public static float RETURN_ON_INVESTMENT_SAMPLE = 285936.4f;
}

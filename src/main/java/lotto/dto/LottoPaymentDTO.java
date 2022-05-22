package lotto.dto;

public class LottoPaymentDTO {
    private final int totalPayment;

    public LottoPaymentDTO(int totalPayment) {
        this.totalPayment = totalPayment;
    }

    public int getTotalPayment(){
        return totalPayment;
    }
}

package lotto.domain;

public class LottoTicket {

    private LottoNumbers numbers;
    
    public LottoTicket(LottoNumbers numbers) {
        this.numbers = numbers;
    }

    public int[] getNumbersAsArray() {
        return this.numbers.getNumbersAsArray();
    }

    public boolean contains(LottoNumber number) {
        return this.numbers.contains(number);
    }

    @Override
    public String toString() {
        return this.numbers.toString();
    }
}

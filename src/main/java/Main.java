import model.Lotto;
import model.RankCalculator;
import view.LottoInput;
import view.LottoOutput;

public class Main {
    public static void main(String[] args) {
        final var balance = LottoInput.inputBalance();
        final var lotto = new Lotto(balance);

        lotto.calcLottoNumbersCount();
        lotto.generateRandomLottoNumbers();
        LottoOutput.printLottoNumbers(lotto);

        final var ansNumber = LottoInput.inputLottoAnswer();
        final var bonusBall = LottoInput.inputBonusBall();

        final var rankCalculator = new RankCalculator(ansNumber, bonusBall);
        rankCalculator.calculateAllLottoCorrectNumbers(lotto);
        LottoOutput.printCorrectNumbers(rankCalculator);

        double rate = rankCalculator.calculateRateOfReturn(lotto.getBalance());
        LottoOutput.printRateOfReturn(rate);
    }
}
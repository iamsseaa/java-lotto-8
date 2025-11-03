package lotto;

import controller.LottoMachineController;

public class Application {
    public static void main(String[] args) {
        LottoMachineController lottoMachineController = new LottoMachineController();
        lottoMachineController.run();
    }
}

package controller;

import view.InputView;

public class LottoMachineController {
    private final InputView inputView;

    public LottoMachineController() {
        this.inputView = new InputView();
    }

    public void run() {
        startLottoMachine();
    }

    public void startLottoMachine() {
        int lottoPrice = inputView.readLottoPrice();
        inputView.readWinningNumbers();
        int bonusNumber = inputView.readBonusNumber();
    }
}

package week_1.adapter_pattern.models;

import week_1.adapter_pattern.interfaces.CoffeeMachineInterface;

public class CoffeeTouchScreenAdapter implements CoffeeMachineInterface {
    private OldCoffeeMachine oldVendingMachine;

    public void CoffeeTouchScreenAdapter(OldCoffeeMachine oldVendingMachine) {
        this.oldVendingMachine = oldVendingMachine;
    }

    @Override
    public void chooseFirstSelection() {
        oldVendingMachine.selectA();
    }

    @Override
    public void chooseSecondSelection() {
        oldVendingMachine.selectB();
    }
}

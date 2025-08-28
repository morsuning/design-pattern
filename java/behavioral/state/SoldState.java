package behavioral.state;

public class SoldState implements State {
    VendingMachine machine;
    public SoldState(VendingMachine machine) { this.machine = machine; }
    public void insertCoin() { System.out.println("Please wait, we're already giving you an item."); }
    public void pressButton() { System.out.println("Pressing the button twice doesn't get you another item!"); }
    public void dispense() {
        machine.releaseItem();
        if (machine.getCount() > 0) {
            machine.setState(machine.getNoCoinState());
        } else {
            System.out.println("Oops, out of items!");
            machine.setState(machine.getSoldOutState());
        }
    }
}

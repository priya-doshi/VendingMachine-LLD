package model.states;

import exception.ServiceException;
import enums.Coin;
import model.Item;
import model.VendingMachine;

import java.util.List;

public class SelectionState implements State {

    public SelectionState(){
        System.out.println("Current vending machine is in Selection State");
    }

    @Override
    public void insertCoinButton(VendingMachine vendingMachine) throws ServiceException {
        return;
    }

    @Override
    public void selectProductButton(VendingMachine vendingMachine) throws ServiceException {
        return;
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) throws ServiceException {
        throw new ServiceException("you can not insert Coin in selection state");
    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine, int codeNumber) throws ServiceException {
        Item item = vendingMachine.getInventory().getItem(codeNumber);

        int totalAmountPaid = 0;

        for(Coin coin : vendingMachine.getCoins()){
            totalAmountPaid = totalAmountPaid + coin.value;
        }

        if(totalAmountPaid >= item.getPrice()){

            if(totalAmountPaid > item.getPrice())
                getChange(totalAmountPaid-item.getPrice());

            vendingMachine.setVendingMachineState(new DispenseState(vendingMachine, codeNumber));
        }
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int codeNumber) throws ServiceException {
        throw new ServiceException("product can not be dispensed Selection state");
    }

    @Override
    public List<Coin> refund(VendingMachine vendingMachine) {
        System.out.println("Returned the full amount back in the Coin Dispense Tray");
        vendingMachine.setVendingMachineState(new IdleState(vendingMachine));
        return vendingMachine.getCoins();
    }

    @Override
    public int getChange(int returnChangeMoney) {
        System.out.println("Returned the change in the Coin Dispense Tray: " + returnChangeMoney);
        return returnChangeMoney;
    }

    @Override
    public void updateInventory(VendingMachine vendingMachine, Item item, int codeNumber) throws ServiceException {
        throw new ServiceException("Inventory can not be updated in Selection state");
    }
}

package model.states;

import exception.ServiceException;
import enums.Coin;
import model.Item;
import model.VendingMachine;

import java.util.List;

public class HasMoneyState implements State {

    public HasMoneyState(){
        System.out.println("Currently Vending machine is in HasMoneyState");
    }


    @Override
    public void insertCoinButton(VendingMachine vendingMachine) throws ServiceException{
        return;
    }

    @Override
    public void selectProductButton(VendingMachine vendingMachine) throws ServiceException {
     vendingMachine.setVendingMachineState(new SelectionState());
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) throws ServiceException {
        System.out.println("Coin accepted!");
        vendingMachine.getCoins().add(coin);
    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine, int codeNumber) throws ServiceException {
        throw new ServiceException("Press select product button");
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int codeNumber) throws ServiceException {
        throw new ServiceException("Press select product button");
    }

    @Override
    public List<Coin> refund(VendingMachine vendingMachine) {
        System.out.println("Returned the full amount back in the Coin Dispense Tray");
        vendingMachine.setVendingMachineState(new IdleState(vendingMachine));
        return vendingMachine.getCoins();
    }

    @Override
    public int getChange(int returnChangeMoney) throws ServiceException {
        throw new ServiceException("Press select product button");
    }

    @Override
    public void updateInventory(VendingMachine vendingMachine, Item item, int codeNumber) throws ServiceException {
        throw new ServiceException("You cannot update inventory in has money state");
    }
}

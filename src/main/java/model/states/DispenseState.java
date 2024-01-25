package model.states;

import exception.InvalidCodeException;
import exception.ItemSoldOutException;
import exception.ServiceException;
import enums.Coin;
import model.Item;
import model.VendingMachine;

import java.util.List;

public class DispenseState implements State {

    DispenseState(VendingMachine vendingMachine, int codeNumber) throws ServiceException {

        System.out.println("Currently Vending machine is in DispenseState");
        dispenseProduct(vendingMachine, codeNumber);
    }



    @Override
    public void insertCoinButton(VendingMachine vendingMachine) throws ServiceException {
        throw new ServiceException("insert coin button can not clicked on Dispense state");
    }

    @Override
    public void selectProductButton(VendingMachine vendingMachine) throws ServiceException {
        throw new ServiceException("product selection buttion can not be clicked in Dispense state");
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) throws ServiceException {
        throw new ServiceException("coin can not be inserted in Dispense state");
    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine, int codeNumber) throws ServiceException {
        throw new ServiceException("product can not be choosen in Dispense state");
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int codeNumber) throws ItemSoldOutException, InvalidCodeException {
        System.out.println("Product has been dispensed");
        Item item = vendingMachine.getInventory().getItem(codeNumber);
        vendingMachine.getInventory().updateItemStatus(codeNumber);
        vendingMachine.setVendingMachineState(new IdleState(vendingMachine));
        return item;
    }

    @Override
    public List<Coin> refund(VendingMachine vendingMachine) throws ServiceException {

        throw new ServiceException("refund can not be happen in Dispense state");
    }

    @Override
    public int getChange(int returnChangeMoney) throws ServiceException {

        throw new ServiceException("change can not returned in Dispense state");
    }

    @Override
    public void updateInventory(VendingMachine vendingMachine, Item item, int codeNumber) throws ServiceException {
        throw new ServiceException("inventory can not be updated in Dispense state");
    }
}

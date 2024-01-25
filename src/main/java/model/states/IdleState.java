package model.states;

import exception.ServiceException;
import enums.Coin;
import model.Item;
import model.VendingMachine;

import java.util.ArrayList;
import java.util.List;

public class IdleState implements State {

    public IdleState(){
        System.out.println("Current vending machine is in IdleState");
    }

    public IdleState(VendingMachine vendingMachine){
        System.out.println("Current vending machine is in IdleState");
        vendingMachine.setCoins(new ArrayList<>());
    }

    @Override
    public void insertCoinButton(VendingMachine vendingMachine) throws ServiceException {
        vendingMachine.setVendingMachineState(new HasMoneyState());
    }

    @Override
    public void selectProductButton(VendingMachine vendingMachine) throws ServiceException {
        throw new ServiceException("Please insert a coin");
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) throws ServiceException {
        throw new ServiceException("Press insert a coin button");
    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine, int codeNumber) throws ServiceException {
        throw new ServiceException("Please insert a coin");
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int codeNumber) throws ServiceException {
        throw new ServiceException("Please insert a coin");
    }

    @Override
    public List<Coin> refund(VendingMachine vendingMachine) throws ServiceException {
        throw new ServiceException("Please insert a coin");
    }

    @Override
    public int getChange(int returnChangeMoney) throws ServiceException {
        throw new ServiceException("Please insert a coin");
    }

    @Override
    public void updateInventory(VendingMachine vendingMachine, Item item, int codeNumber) throws ServiceException {
        throw new ServiceException("Please insert a coin");
    }
}

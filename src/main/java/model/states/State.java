package model.states;

import exception.ServiceException;
import enums.Coin;
import model.Item;
import model.VendingMachine;

import java.util.List;

public interface State {
    public void insertCoinButton(VendingMachine vendingMachine)throws ServiceException;
    public void selectProductButton(VendingMachine vendingMachine) throws ServiceException;
    public void insertCoin(VendingMachine vendingMachine, Coin coin)throws ServiceException;
    public void chooseProduct(VendingMachine vendingMachine, int codeNumber)throws ServiceException;
    public Item dispenseProduct(VendingMachine vendingMachine, int codeNumber)throws ServiceException;
    public List<Coin> refund(VendingMachine vendingMachine)throws ServiceException;
    public int getChange(int returnChangeMoney)throws ServiceException;
    public void updateInventory(VendingMachine vendingMachine, Item item, int codeNumber)throws ServiceException;
}

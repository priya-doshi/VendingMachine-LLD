import enums.Coin;
import enums.ItemType;
import exception.ItemAlreadyPresentException;
import exception.ServiceException;
import model.*;
import model.states.State;

import java.util.List;

public class Driver {
    public static void main(String args[]){
        VendingMachine vendingMachine = new VendingMachine();

        try{

            System.out.println("Adding items in the inventory");


            addItemsInTheInventory(vendingMachine);
            displayInventory(vendingMachine);


            System.out.println("clicking on InsertCoinButton");


            State vendingState = vendingMachine.getVendingMachineState();
            vendingState.insertCoinButton(vendingMachine);

            vendingState = vendingMachine.getVendingMachineState();
            vendingState.insertCoin(vendingMachine, Coin.DIME);
            vendingState.insertCoin(vendingMachine, Coin.QUARTER);


            System.out.println("clicking on ProductSelectionButton");

            vendingState.selectProductButton(vendingMachine);

            vendingState = vendingMachine.getVendingMachineState();
            vendingState.chooseProduct(vendingMachine, 102);

            displayInventory(vendingMachine);

        }
         catch (ServiceException e) {
            throw new RuntimeException(e);
        }
    }

    public static void addItemsInTheInventory(VendingMachine vendingMachine) throws ItemAlreadyPresentException {
        List<ItemShelf> itemShelfList = vendingMachine.getInventory().getItemShelfList();
        Inventory inventory = vendingMachine.getInventory();
        for(int i=0; i< itemShelfList.size(); i++){
            Item newItem = new Item();
            if(i>=0 && i<2){
                newItem.setItemType(ItemType.SODA);
                newItem.setPrice(5);
            }
            else if(i>=2 && i<4){
                newItem.setItemType(ItemType.COKE);
                newItem.setPrice(7);
            }
            else if(i>=4 && i<6){
                newItem.setItemType(ItemType.SPRITE);
                newItem.setPrice(4);
            }
            else if(i>=6 && i<8){
                newItem.setItemType(ItemType.PEPSI);
                newItem.setPrice(8);
            }
            else if(i>=8 && i<10){
                newItem.setItemType(ItemType.JUICE);
                newItem.setPrice(10);
            }
            inventory.addItem(newItem,itemShelfList.get(i).getCode());
        }
    }


    public static void displayInventory(VendingMachine vendingMachine){

        List<ItemShelf> itemShelfList = vendingMachine.getInventory().getItemShelfList();
        for (int i = 0; i < itemShelfList.size(); i++) {

            System.out.println("CodeNumber: " + itemShelfList.get(i).getCode() +
                    " Item: " + itemShelfList.get(i).getItem().getItemType().name() +
                    " Price: " + itemShelfList.get(i).getItem().getPrice() +
                    " isAvailable: " + !itemShelfList.get(i).isSold());
        }
    }

}

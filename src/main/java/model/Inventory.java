package model;

import exception.InvalidCodeException;
import exception.ItemAlreadyPresentException;
import exception.ItemSoldOutException;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {
    private int itemCount;
    private List<ItemShelf> itemShelfList;

    public Inventory(int itemCount){
        this.itemCount = itemCount;
        this.itemShelfList = new ArrayList<>(itemCount);
        initializeInventory();
    }

    public void initializeInventory(){
        int startCode = 101;
        for(int i=0; i<itemCount; i++){
            ItemShelf space = new ItemShelf();
            space.setCode(startCode);
            space.setSold(true);
            itemShelfList.add(i, space);
            startCode = startCode + 1;
        }
    }

    public void addItem(Item item, int codeNumber) throws ItemAlreadyPresentException {
        for(ItemShelf itemShelf : itemShelfList){
            if(itemShelf.getCode() == codeNumber){
                if(itemShelf.isSold()){
                    itemShelf.setItem(item);
                    itemShelf.setSold(false);
                }
                else
                    throw new ItemAlreadyPresentException("Already item is present, you can not add item here");
            }
        }
    }

    public Item getItem(int codeNumber) throws ItemSoldOutException, InvalidCodeException {
        for(ItemShelf itemShelf : itemShelfList){
            if(itemShelf.getCode() == codeNumber){
                if(itemShelf.isSold())
                    throw new ItemSoldOutException("Item already sold out!");
                else
                    return itemShelf.getItem();
            }
        }
        throw new InvalidCodeException("Invalid code!");
    }

    public void updateItemStatus(int codeNumber){
        for(ItemShelf itemShelf : itemShelfList){
            if(itemShelf.getCode() == codeNumber) {
                itemShelf.setSold(true);
            }
        }
    }

}

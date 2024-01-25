package model;


import enums.ItemType;
import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    private String id;
    private ItemType itemType;
    private int price;
}

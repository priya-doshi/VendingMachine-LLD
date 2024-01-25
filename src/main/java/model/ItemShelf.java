package model;

import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ItemShelf {
    private int code;
    private Item item;
    private boolean isSold;
}

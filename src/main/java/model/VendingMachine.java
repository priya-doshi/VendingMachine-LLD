package model;

import enums.Coin;
import lombok.*;
import model.states.IdleState;
import model.states.State;

import java.util.ArrayList;
import java.util.List;

@Builder
@Setter
@Getter
@AllArgsConstructor
public class VendingMachine {
   private Inventory inventory;
   private List<Coin> coins;
   private State vendingMachineState;

   public VendingMachine(){
      this.vendingMachineState = new IdleState();
      this.inventory = new Inventory(10);
      this.coins = new ArrayList<>();
   }

}

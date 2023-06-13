package lk.ijse.project_rio.view.tdm;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class InventoryTM {
    private String id;
    private String name;
    private String category;
    private Double unitPrice;
    private String qtyOnHand;
}

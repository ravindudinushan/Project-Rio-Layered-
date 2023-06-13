package lk.ijse.project_rio.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class SupplierDTO {
    private String id;
    private String name;
    private String address;
    private String email;
    private String contact;
}

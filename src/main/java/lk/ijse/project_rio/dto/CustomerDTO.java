package lk.ijse.project_rio.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class CustomerDTO {
    private String id;
    private String name;
    private String address;
    private String email;
    private String contact;
}

package lk.ijse.project_rio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EventDTO {
    String id;
    String name;
    String date;
    String time;
    String type;
    String empId;
}

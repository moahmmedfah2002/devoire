package ma.ensa.dto;

import lombok.Data;
import ma.ensa.entity.Custumer;

import java.sql.Date;
@Data
public class OrderDto {
    private int orderId;
    private Custumer customer;
    private Date orderDate;
    private boolean orderStatus;
    private Double amount ;
}

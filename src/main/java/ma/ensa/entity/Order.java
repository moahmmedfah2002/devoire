package ma.ensa.entity;

import lombok.Data;

import java.sql.Date;
import java.time.LocalDate;

@Data
public class Order {
    private int id;
    private Date date;
    private Double amount ;
    private int costumer;
    private boolean statue;



}

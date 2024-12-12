package ma.ensa.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
public class Custumer implements Serializable {
    @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
    private int id;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String email;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String phone;
}

package cat.itacademy.s04.t02.n03.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.NotNull;

@Data
@Document(collection = "fruit")
public class Fruit {

    @Transient
    public static final String SEQ_NAME = "fruit_seq_id";

    @Id
    private Integer id;
    @NotNull
    private String name;
    private int kgQty;

    public @NotNull String getName() {
        return name;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    public int getKgQty() {
        return kgQty;
    }

    public void setKgQty(int kgQty) {
        this.kgQty = kgQty;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

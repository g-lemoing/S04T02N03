package cat.itacademy.s04.t02.n03.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.NotNull;

@Data
@Document(collection = "fruit")
public class Fruit {
    @Id
    private int id;
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
}

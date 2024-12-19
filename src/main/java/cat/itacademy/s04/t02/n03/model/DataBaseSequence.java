package cat.itacademy.s04.t02.n03.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "db_sequence")
public class DataBaseSequence {
    @Id
    private String seqName;
    private Integer sequenceNr;

    public Integer getSequenceNr() {
        return sequenceNr;
    }

    public void setSequenceNr(Integer sequenceNr) {
        this.sequenceNr = sequenceNr;
    }
}

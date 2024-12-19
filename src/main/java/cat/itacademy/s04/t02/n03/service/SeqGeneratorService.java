package cat.itacademy.s04.t02.n03.service;

import cat.itacademy.s04.t02.n03.model.DataBaseSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

@Service
public class SeqGeneratorService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public Integer generateSequence(String seqName){
        DataBaseSequence counter = mongoTemplate.findAndModify(
                new Query(where("_id").is(seqName)),
                new Update().inc("sequenceNr",1),
                options().returnNew(true).upsert(true),
                DataBaseSequence.class
        );
        return !Objects.isNull(counter) ? counter.getSequenceNr() : 1;
    }
}

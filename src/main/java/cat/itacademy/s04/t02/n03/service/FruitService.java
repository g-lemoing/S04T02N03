package cat.itacademy.s04.t02.n03.service;

import cat.itacademy.s04.t02.n03.model.Fruit;

import java.util.List;

public interface FruitService {
    List<Fruit> findAll();
    Fruit getReferenceById(int id);
    Fruit save(Fruit fruit);
    void deleteById(int id);
    Fruit update(int id, Fruit fruit);
}

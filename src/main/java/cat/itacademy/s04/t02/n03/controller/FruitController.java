package cat.itacademy.s04.t02.n03.controller;

import cat.itacademy.s04.t02.n03.model.Fruit;
import cat.itacademy.s04.t02.n03.service.FruitServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fruita")
public class FruitController {

    @Autowired
    private FruitServiceImpl fruitService;

    @GetMapping("/getAll")
    public List<Fruit> getAll() {
        return fruitService.findAll();
    }

    @GetMapping(value = {"/getOne/{id}", "/getOne/", "/getOne"})
    public ResponseEntity<Fruit> getFruit(@PathVariable int id) {
        return new ResponseEntity<>(fruitService.getReferenceById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Fruit> addFruit(@Valid @RequestBody Fruit fruit) {
        return new ResponseEntity<>(fruitService.save(fruit), HttpStatus.CREATED);
    }

    @PutMapping(value = {"/update/{id}", "/update/", "/update"})
    public ResponseEntity<Fruit> updateFruit(@PathVariable int id, @RequestBody Fruit fruit) {
        Fruit updatedFruit = fruitService.update(id, fruit);
        return new ResponseEntity<>(updatedFruit, HttpStatus.OK);
    }

    @DeleteMapping(value = {"/delete/{id}", "/delete/", "delete"})
    public ResponseEntity<Fruit> deleteFruit(@PathVariable int id) {
        fruitService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

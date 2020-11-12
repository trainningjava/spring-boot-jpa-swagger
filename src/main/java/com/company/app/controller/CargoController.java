package com.company.app.controller;

import com.company.app.model.Cargo;
import com.company.app.repository.CargoRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/office")
public class CargoController {

    @Autowired
    CargoRepository cargoRep;

    @ApiOperation(value="Lista todos os cargos")
    @GetMapping("/alloffices")
    public List<Cargo> getAllOffices() {
        return cargoRep.findAll();
    }

    @ApiOperation(value="busca pelo codigo do cargo")
    @GetMapping("/{id}")
    public ResponseEntity<Cargo> getOfficeById(@PathVariable(name = "id") Integer id) {

        Optional<Cargo> optional = cargoRep.findById(id);

        if (optional.isPresent()) {
            Cargo Cargo = cargoRep.getOne(id);
            return new ResponseEntity<>(Cargo, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @ApiOperation(value="salva um cargo")
    @PostMapping("/save")
    public List<Cargo> saveEmployee(@RequestBody Cargo Cargo) {
        cargoRep.save(Cargo);
        return cargoRep.findAll();

    }

    @ApiOperation(value="apaga um cargo")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id) {
        try {
            cargoRep.deleteById(id);
        } catch (Exception e) {
            return new ResponseEntity<>("employee not found", HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<>("employee is deleted", HttpStatus.OK);
    }

    @ApiOperation(value="atualiza um cargo")
    @PutMapping("/update")
    public ResponseEntity<Cargo> updateEmployee(@RequestBody Cargo Cargo) {
        Optional<Cargo> optional = cargoRep.findById(Cargo.getId());
        if (optional.isPresent()) {
            Cargo Cargo1 = optional.get();
            Cargo1.setName(Cargo.getName());
            cargoRep.save(Cargo1);
            return new ResponseEntity<>(optional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}

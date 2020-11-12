package com.company.app.controller;

import com.company.app.model.Departamento;
import com.company.app.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departament")
public class DepartamentoController {
    
    @Autowired
    DepartamentoRepository departamentoRep;

    @GetMapping("/alldepartament")
    public List<Departamento> getAllEmployees() {
        return departamentoRep.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Departamento> getEmployeeById(@PathVariable(name = "id") Integer id) {

        Optional<Departamento> optional = departamentoRep.findById(id);

        if (optional.isPresent()) {
            Departamento Departamento = departamentoRep.getOne(id);
            return new ResponseEntity<>(Departamento, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PostMapping("/save")
    public List<Departamento> saveEmployee(@RequestBody Departamento Departamento) {
        departamentoRep.save(Departamento);
        return departamentoRep.findAll();

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id) {
        try {
            departamentoRep.deleteById(id);
        } catch (Exception e) {
            return new ResponseEntity<>("employee not found", HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<>("employee is deleted", HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Departamento> updateEmployee(@RequestBody Departamento Departamento) {
        Optional<Departamento> optional = departamentoRep.findById(Departamento.getId());
        if (optional.isPresent()) {
            Departamento Departamento1 = optional.get();
            Departamento1.setName(Departamento.getName());
            departamentoRep.save(Departamento1);
            return new ResponseEntity<>(optional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}

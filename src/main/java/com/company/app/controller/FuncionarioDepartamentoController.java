package com.company.app.controller;

import com.company.app.model.Cargo;
import com.company.app.model.FuncionarioDepartamento;
import com.company.app.repository.CargoRepository;
import com.company.app.repository.FuncionarioDepartamentoRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employeesdepartaments")
public class FuncionarioDepartamentoController {

    @Autowired
    FuncionarioDepartamentoRepository funcRep;

    @ApiOperation(value="Lista todos os funcionarios x departamentos")
    @GetMapping("/all")
    public List<FuncionarioDepartamento> getAll() {
        return funcRep.findAll();
    }

    @ApiOperation(value="salva um cargo")
    @PostMapping("/save")
    public List<FuncionarioDepartamento> saveEmployee(@RequestBody FuncionarioDepartamento func) {
        funcRep.save(func);
        return funcRep.findAll();

    }

    @ApiOperation(value="apaga um funcionario x departamento")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id) {
        try {
            funcRep.deleteById(id);
        } catch (Exception e) {
            return new ResponseEntity<>("employee departament id not found", HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<>("employee departament is deleted", HttpStatus.OK);
    }

//    @ApiOperation(value="atualiza um cargo")
    @PutMapping("/update")
    public ResponseEntity<FuncionarioDepartamento> updateEmployee(@RequestBody FuncionarioDepartamento func) {
        Optional<FuncionarioDepartamento> optional = funcRep.findById(func.getId());
        if (optional.isPresent()) {
            FuncionarioDepartamento func1 = optional.get();
            func1.setFuncionario(func.getFuncionario());
            func1.setDepartamento(func.getDepartamento());
            funcRep.save(func1);
            return new ResponseEntity<>(optional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}

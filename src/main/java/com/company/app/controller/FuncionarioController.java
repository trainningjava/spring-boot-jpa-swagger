package com.company.app.controller;

import com.company.app.model.Funcionario;
import com.company.app.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class FuncionarioController {
    @Autowired
    FuncionarioRepository funcRep;

    @GetMapping("/allemployees")
    public List<Funcionario> getAllEmployees() {
        return funcRep.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> getEmployeeById(@PathVariable(name = "id") Integer id) {

        Optional<Funcionario> optional = funcRep.findById(id);

        if (optional.isPresent()) {
            Funcionario funcionario = funcRep.getOne(id);
            return new ResponseEntity<>(funcionario, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PostMapping("/save")
    public List<Funcionario> saveEmployee(@RequestBody Funcionario funcionario) {
        funcRep.save(funcionario);
        return funcRep.findAll();

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id) {
        try {
            funcRep.deleteById(id);
        } catch (Exception e) {
            return new ResponseEntity<String>("employee not found", HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<String>("employee is deleted", HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Funcionario> updateEmployee(@RequestBody Funcionario funcionario) {
        Optional<Funcionario> optional = funcRep.findById(funcionario.getId());
        if (optional.isPresent()) {
            Funcionario funcionario1 = optional.get();
            funcionario1.setName(funcionario.getName());
            funcionario1.setAge(funcionario.getAge());
            funcionario1.setBirthday(funcionario.getBirthday());
            funcionario1.setDocument(funcionario.getDocument());
            funcionario1.setCargo(funcionario.getCargo());
            funcRep.save(funcionario1);
            return new ResponseEntity<Funcionario>(optional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<Funcionario>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/departament/{id}")
    public List<Funcionario> getEmployeeByDepartamentId(@PathVariable(name = "id") Integer id) throws Exception {
        List<Funcionario> funcionarioList = funcRep.listEmployeesbyDepartamentId(id);
        if(funcionarioList.isEmpty()) {
            throw new Exception("departament not found");
        }
        return funcionarioList;
    }

}

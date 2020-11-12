package com.company.app.repository;

import com.company.app.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

    @Query("SELECT F FROM Funcionario F INNER JOIN FuncionarioDepartamento FD \n" +
            "ON F.id = FD.funcionario.id  WHERE FD.departamento.id = :id")
    List<Funcionario> listEmployeesbyDepartamentId(@Param("id") Integer id);

}

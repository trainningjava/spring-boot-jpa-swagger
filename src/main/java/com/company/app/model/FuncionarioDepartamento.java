package com.company.app.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@ApiModel(description = "Funcionario x Departamento")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "FuncionariosDepartamentos")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class FuncionarioDepartamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "departamento_id", referencedColumnName = "id", nullable = false)
    private Departamento departamento;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "funcionario_id", referencedColumnName = "id", nullable = false)
    private Funcionario funcionario;

}

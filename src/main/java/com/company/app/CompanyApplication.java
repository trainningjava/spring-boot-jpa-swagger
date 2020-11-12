package com.company.app;


import com.company.app.model.Cargo;
import com.company.app.model.Departamento;
import com.company.app.model.Funcionario;
import com.company.app.model.FuncionarioDepartamento;
import com.company.app.repository.CargoRepository;
import com.company.app.repository.DepartamentoRepository;
import com.company.app.repository.FuncionarioDepartamentoRepository;
import com.company.app.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class CompanyApplication  implements ApplicationRunner {

	@Autowired
	CargoRepository cargoRep;

	@Autowired
	FuncionarioRepository funcionarioRep;

	@Autowired
	DepartamentoRepository departamentoRep;

	@Autowired
	FuncionarioDepartamentoRepository funcdeptRep;

	public static void main(String[] args) {
		SpringApplication.run(CompanyApplication.class, args);
	}


	@Override
	public void run(ApplicationArguments args) throws Exception {
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

		cargoRep.save(new Cargo(1,"Presidência/Diretoria"));
		cargoRep.save(new Cargo(2,"Gerência"));
		cargoRep.save(new Cargo(3,"Coordenação"));
		cargoRep.save(new Cargo(4,"Supervisão"));
		cargoRep.save(new Cargo(5,"Analista"));
		cargoRep.save(new Cargo(6,"Assistente"));
		cargoRep.save(new Cargo(7,"Auxiliar"));
		cargoRep.save(new Cargo(8,"Estagiário"));
		cargoRep.save(new Cargo(9,"Aprendiz"));

		Cargo cargo = new Cargo();
		cargo.setId(2);
		funcionarioRep.save(new Funcionario(1,"Marcos Vinicius Anthony Aparício", 40,
				(Date)formatter.parse("01/01/1980"), "36.557.022-9", cargo));
		cargo.setId(3);
		funcionarioRep.save(new Funcionario(2,"Henrique Oliver Lorenzo Silveira", 30,
				(Date)formatter.parse("29/03/1990"), "36.557.022-9", cargo));
		cargo.setId(7);
		funcionarioRep.save(new Funcionario(3,"Eduardo Geraldo Dias", 43,
				(Date)formatter.parse("27/4/1977"), "30.306.732-9", cargo));
		cargo.setId(7);
		funcionarioRep.save(new Funcionario(4,"Cauã Joaquim Duarte", 43,
				(Date)formatter.parse("15/8/1977"), "49.328.788-7", cargo));
		cargo.setId(8);
		funcionarioRep.save(new Funcionario(5,"Carolina Yasmin Hadassa Campos", 42,
				(Date)formatter.parse("06/03/1978"), "19.478.984-6", cargo));
		cargo.setId(8);
		funcionarioRep.save(new Funcionario(6,"Agatha Emanuelly Camila Souza", 74,
				(Date)formatter.parse("13/04/1978"), "34.456.148-3", cargo));
		cargo.setId(8);
		funcionarioRep.save(new Funcionario(7,"Eduarda Sara Pereira", 80,
				(Date)formatter.parse("03/03/1940"), "11.253.807-1", cargo));
		cargo.setId(8);
		funcionarioRep.save(new Funcionario(8,"Antonella Alana Oliveira", 21,
				(Date)formatter.parse("27/02/1999"), "33.777.024-4", cargo));
		cargo.setId(8);
		funcionarioRep.save(new Funcionario(9,"Benedita Raimunda Alana das Neves", 75,
				(Date)formatter.parse("02/09/1945"), "45.746.403-3", cargo));

		departamentoRep.save(new Departamento(1, "Atendimento ao cliente"));
		departamentoRep.save(new Departamento(2, "Comercial"));
		departamentoRep.save(new Departamento(3, "Logística"));
		departamentoRep.save(new Departamento(4, "TI – Tecnologia da Informação"));


		Funcionario func = new Funcionario();
		Departamento dept = new Departamento();
		func.setId(1);
		dept.setId(1);
		funcdeptRep.save(new FuncionarioDepartamento(1,dept, func));
		func.setId(2);
		dept.setId(1);
		funcdeptRep.save(new FuncionarioDepartamento(2,dept, func));
		func.setId(3);
		dept.setId(2);
		funcdeptRep.save(new FuncionarioDepartamento(3,dept, func));
		func.setId(4);
		dept.setId(3);
		funcdeptRep.save(new FuncionarioDepartamento(4,dept, func));
		func.setId(5);
		dept.setId(3);
		funcdeptRep.save(new FuncionarioDepartamento(5,dept, func));
		func.setId(6);
		dept.setId(3);
		funcdeptRep.save(new FuncionarioDepartamento(6,dept, func));
		func.setId(7);
		dept.setId(4);
		funcdeptRep.save(new FuncionarioDepartamento(7,dept, func));
		func.setId(8);
		dept.setId(4);
		funcdeptRep.save(new FuncionarioDepartamento(8,dept, func));

	}

}

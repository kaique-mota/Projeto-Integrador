package org.queryjobs.queryjobs.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
@Entity
@Table(name = "tb_usuario")
public class Usuario {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message="O nome é obrigatório!")
	@Size(min=10 , max=300)
	private String nomeusuario;
	
	@NotNull(message="A idade é obrigatória!")
	@Column(name = "dt_nascimento")
	@JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate datanascimento; 
	
	@NotNull(message="Esta opção é obrigatória!")
	private Boolean empregador;
	
	@NotNull(message="O email é obrigatório!")
	@Size(min=8 , max=50 )
	@Email
	private String  email;
	
	@NotNull(message="A senha é obrigatória!")
	@Size(min=4)
	private String senha;
	
	@Size(min=1 , max=50 )
	private String genero;
	
	@ManyToOne
	@JsonIgnoreProperties ("usuario")
	private Categoria categoria;
}

package com.bookstore.dtos;

import java.io.Serializable;

import com.bookstore.domain.Livro;

public class LivroDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7451263629345605304L;

	private Integer id;
	private String titulo;

	public LivroDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LivroDTO(Livro obj) {
		super();
		this.id = obj.getId();
		this.titulo = obj.getTitulo();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeLivro() {
		return titulo;
	}

	public void setNomeLivro(String titulo) {
		this.titulo = titulo;
	}

}

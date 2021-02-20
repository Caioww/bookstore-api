package com.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.domain.Categoria;
import com.bookstore.dtos.CategoriaDTO;
import com.bookstore.exceptions.ObjectNotFoundException;
import com.bookstore.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public Categoria categoria;

	public Categoria findById(Integer id) {
		Optional<Categoria> obj = categoriaRepository.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id:" + id + ", Tipo: " + Categoria.class.getName()));
	}

	public List<Categoria> findAll() {
		return categoriaRepository.findAll();
	}

	public Categoria create(Categoria obj) {
		obj.setId(null);
		return categoriaRepository.save(obj);
	}

	public Categoria create(Integer id, CategoriaDTO objDTO) {
		Categoria obj = findById(id);
		obj.setNome(objDTO.getNome());
		obj.setDescricao(objDTO.getDescricao());

		return categoriaRepository.save(obj);
	}

}

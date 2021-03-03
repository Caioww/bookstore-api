package com.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.domain.Categoria;
import com.bookstore.domain.Livro;
import com.bookstore.exceptions.ObjectNotFoundException;
import com.bookstore.repository.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;

	@Autowired
	private CategoriaService categoriaService;

	public Livro findById(Integer id) {
		Optional<Livro> livro = livroRepository.findById(id);

		return livro.orElseThrow(() -> new ObjectNotFoundException(
				"Livro não encontrado! Id:" + id + ", Tipo:" + Livro.class.getName()));
	}

	public List<Livro> findAll(Integer id_cat) {
		categoriaService.findById(id_cat);

		return livroRepository.findAllByCategoria(id_cat);
	}

	public Livro update(Integer id, Livro obj) {
		Livro newObj = findById(id);
		updateData(newObj, obj);
		return livroRepository.save(newObj);
	}

	private void updateData(Livro newObj, Livro obj) {
		newObj.setTitulo(obj.getTitulo());
		newObj.setNome_autor(obj.getNome_autor());
		newObj.setTexto(obj.getTexto());

	}

	public Livro create(Integer id, Livro obj) {
		obj.setId(null);
		Categoria cat = categoriaService.findById(id);
		obj.setCategoria(cat);
		return livroRepository.save(obj);
	}

	public void delete(Integer id) {
		Livro obj = findById(id);
		livroRepository.deleteById(obj.getId());
	}

}

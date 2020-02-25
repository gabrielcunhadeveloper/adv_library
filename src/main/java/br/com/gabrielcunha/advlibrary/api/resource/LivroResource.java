package br.com.gabrielcunha.advlibrary.api.resource;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gabrielcunha.advlibrary.api.dto.LivroDto;
import br.com.gabrielcunha.advlibrary.api.entity.Livro;
import br.com.gabrielcunha.advlibrary.api.repository.LivroRepository;

@RestController
@RequestMapping("/livros")
public class LivroResource {

	@Autowired
	private LivroRepository livroRepository;
	
	@PostMapping
	public ResponseEntity<LivroDto> criar(@RequestBody LivroDto livroDto) {
		
		ModelMapper modelMapper = new ModelMapper();
		
		Livro livro = modelMapper.map(livroDto, Livro.class);
		
		Livro livroCriado = livroRepository.save(livro);
		
		LivroDto livroRetorno = modelMapper.map(livroCriado, LivroDto.class);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(livroRetorno);
	}
	
}

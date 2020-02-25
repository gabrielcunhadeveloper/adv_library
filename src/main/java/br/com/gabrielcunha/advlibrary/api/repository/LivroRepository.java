package br.com.gabrielcunha.advlibrary.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gabrielcunha.advlibrary.api.entity.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

}

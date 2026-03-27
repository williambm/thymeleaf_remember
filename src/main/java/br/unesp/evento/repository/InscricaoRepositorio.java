package br.unesp.evento.repository;

import br.unesp.evento.model.Inscricao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.List;

public interface InscricaoRepositorio extends JpaRepository<Inscricao, Long> {
    Optional<Inscricao> findByEmail(String email);
    List<Inscricao> findAllByOrderByIdDesc();
}
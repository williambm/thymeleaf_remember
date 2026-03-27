package br.unesp.evento.service;

import br.unesp.evento.model.Inscricao;
import br.unesp.evento.model.StatusInscricao;
import br.unesp.evento.repository.InscricaoRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InscricaoServico {

    private final InscricaoRepositorio inscricaoRepositorio;

    public InscricaoServico(InscricaoRepositorio inscricaoRepositorio) {
        this.inscricaoRepositorio = inscricaoRepositorio;
    }

    public List<Inscricao> listarTodas() {
        return inscricaoRepositorio.findAllByOrderByIdDesc();
    }

    public Optional<Inscricao> buscarPorEmail(String email) {
        return inscricaoRepositorio.findByEmail(email);
    }

    public Optional<Inscricao> buscarPorId(Long id) {
        return inscricaoRepositorio.findById(id);
    }

    public Inscricao salvar(Inscricao inscricao) {
        if (inscricaoRepositorio.findByEmail(inscricao.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Já existe inscrição para este e-mail.");
        }
        inscricao.setStatus(StatusInscricao.PENDENTE);
        return inscricaoRepositorio.save(inscricao);
    }

    public Inscricao atualizarStatus(Long id, StatusInscricao status) {
        Inscricao inscricao = inscricaoRepositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Inscrição não encontrada."));
        inscricao.setStatus(status);
        return inscricaoRepositorio.save(inscricao);
    }
}
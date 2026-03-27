package br.unesp.evento.controller;

import br.unesp.evento.model.StatusInscricao;
import br.unesp.evento.service.InscricaoServico;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/docente")
public class DocenteControlador {

    private final InscricaoServico inscricaoServico;

    private final String USUARIO_PADRAO = "docente";
    private final String SENHA_PADRAO = "unesp2025";
    private final String SESSAO_AUTENTICADO = "docenteAutenticado";

    public DocenteControlador(InscricaoServico inscricaoServico) {
        this.inscricaoServico = inscricaoServico;
    }

    @GetMapping("/login")
    public String loginForm() {
        return "docente/login";
    }

    @PostMapping("/login")
    public String processarLogin(@RequestParam String usuario, @RequestParam String senha, HttpSession session, Model model) {
        if (USUARIO_PADRAO.equals(usuario) && SENHA_PADRAO.equals(senha)) {
            session.setAttribute(SESSAO_AUTENTICADO, true);
            return "redirect:/docente/inscricoes";
        }
        model.addAttribute("erro", "Usuário ou senha inválidos.");
        return "docente/login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/docente/login";
    }

    @GetMapping("/inscricoes")
    public String listaInscricoes(HttpSession session, Model model) {
        if (!verificaAutenticacao(session)) {
            return "redirect:/docente/login";
        }
        model.addAttribute("inscricoes", inscricaoServico.listarTodas());
        return "docente/lista-inscricoes";
    }

    @PostMapping("/inscricoes/{id}/deferir")
    public String deferirInscricao(@PathVariable Long id, HttpSession session) {
        if (!verificaAutenticacao(session)) {
            return "redirect:/docente/login";
        }
        inscricaoServico.atualizarStatus(id, StatusInscricao.DEFERIDA);
        return "redirect:/docente/inscricoes";
    }

    @PostMapping("/inscricoes/{id}/indeferir")
    public String indeferirInscricao(@PathVariable Long id, HttpSession session) {
        if (!verificaAutenticacao(session)) {
            return "redirect:/docente/login";
        }
        inscricaoServico.atualizarStatus(id, StatusInscricao.INDEFERIDA);
        return "redirect:/docente/inscricoes";
    }

    private boolean verificaAutenticacao(HttpSession session) {
        Boolean autenticado = (Boolean) session.getAttribute(SESSAO_AUTENTICADO);
        return autenticado != null && autenticado;
    }
}
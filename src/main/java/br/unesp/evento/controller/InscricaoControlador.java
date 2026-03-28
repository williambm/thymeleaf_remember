package br.unesp.evento.controller;

import br.unesp.evento.model.AreaFormacao;
import br.unesp.evento.model.Evento;
import br.unesp.evento.model.Inscricao;
import br.unesp.evento.service.InscricaoServico;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class InscricaoControlador {

    private final InscricaoServico inscricaoServico;
    private final Evento evento = new Evento();

    public InscricaoControlador(InscricaoServico inscricaoServico) {
        this.inscricaoServico = inscricaoServico;
    }

    @GetMapping("/")
    public String landingPage(Model model) {
        model.addAttribute("evento", evento);
        return "publico/landing-page";
    }

    @GetMapping("/inscricao")
    public String formularioInscricao(Model model) {
        model.addAttribute("evento", evento);
        model.addAttribute("inscricao", new Inscricao());
        model.addAttribute("areas", AreaFormacao.values());
        return "publico/formulario-inscricao";
    }

    @PostMapping("/inscricao")
    public String processarInscricao(@ModelAttribute Inscricao inscricao, Model model, RedirectAttributes redirectAttributes) {
        try {
            inscricaoServico.salvar(inscricao);
            redirectAttributes.addFlashAttribute("mensagem", "Inscrição realizada com sucesso! Consulte seu status no menu.");
        } catch (IllegalArgumentException e) {
            model.addAttribute("erro", e.getMessage());
            model.addAttribute("evento", evento);
            model.addAttribute("inscricao", inscricao);
            model.addAttribute("areas", AreaFormacao.values());
            return "publico/formulario-inscricao";
        }
        return "redirect:/";
    }

    @GetMapping("/status")
    public String consultarStatusForm() {
        return "publico/consulta-status";
    }

    @PostMapping("/status")
    public String consultarStatus(@RequestParam String email, Model model) {
        var inscricaoOpt = inscricaoServico.buscarPorEmail(email);
        if (inscricaoOpt.isPresent()) {
            model.addAttribute("inscricao", inscricaoOpt.get());
        } else {
            model.addAttribute("erro", "Nenhuma inscrição encontrada para o e-mail informado.");
        }
        return "publico/consulta-status";
    }
}
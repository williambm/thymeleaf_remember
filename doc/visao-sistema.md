# Visão Geral e Especificação do Sistema — CLAUDE.md

Este documento apresenta a visão geral, arquitetura, tecnologias e convenções do sistema de inscrição de evento universitário, servindo como onboarding para agentes IA e também como referência institucional.

---

## 1. Visão do Sistema

Sistema web para gerenciamento de inscrições na “Semana Acadêmica de Tecnologia”, com apoio a dois perfis (aluno/docente) e funcionalidades de inscrição, consulta e administração de participantes. Visa automatizar e simplificar o controle de participação em eventos institucionais.

---

## 2. Stack e Tecnologias

- Java 17
- Spring Boot 3.x
- Spring Data JPA
- Thymeleaf (templates server-side)
- H2 Database (console habilitado para desenvolvimento)
- Bootstrap 5 (visual)
- Maven (build/dependências)
- VSCode (IDE)
- Git (controle de versão)

---

## 3. Estrutura de Pastas e Pacotes

```
src/main/java/br/unesp/evento/
├── controller/     # Controllers HTTP (XxxControlador)
├── service/        # Regras de negócio (XxxServico)
├── model/          # Entidades JPA (nome direto)
└── repository/     # Spring Data (XxxRepositorio)
src/main/resources/
├── templates/
│   ├── publico/    # Telas públicas (aluno)
│   └── docente/    # Telas restritas (docente)
└── static/css/     # Estilos custom (complementares)
doc/                # Documentação e engenharia reversa
```

---

## 4. Convenções de Código

- Idioma: português para nomes
- Sufixos obrigatórios:
  - Controller: `Controlador` — ex: `InscricaoControlador`
  - Service: `Servico`
  - Repository: `Repositorio`
- Models: nome direto, singular — ex: `Inscricao`, `Evento`
- Templates: nomes em português, kebab-case — ex: `formulario-inscricao.html`
- Não usar Lombok nem Spring Security
- Nada de REST endpoints, somente MVC tradicional

---

## 5. Personas e Funcionalidades

### Aluno (público)
- Landing page institucional
- Preencher formulário de inscrição
- Consultar status da inscrição por e-mail

### Docente (restrito)
- Login simples (usuário: docente / senha: unesp2025)
- Listar todas as inscrições e status
- Deferir/Indeferir inscrições individualmente

---

## 6. Dados Fixos do Evento

- Nome: Semana Acadêmica de Tecnologia
- Descrição: Evento universitário com palestras, workshops e minicursos voltados à comunidade acadêmica.
- Data: 31/07/2026
- Local: Reitoria - prédio praça da república.
- Vagas: 150

---

## 7. Identidade Visual — Unesp

- Azul escuro: #0000CC (header, botões, links)
- Azul claro: #1ca9da (badges, destaques)
- Fundo: branco #FFFFFF
- Texto: cinza escuro #333333
- Tipografia padrão: Arial, sans-serif
- Header institucional, navbar simples, rodapé discreto, badges nos status

---

## 8. Observações Finais

- Console H2 acessível durante desenvolvimento
- Didatismo, clareza e separação de responsabilidades acima de tudo
- Engenharia reversa documentada nesta pasta
- CLAUDE.md cumpre função de onboarding rápido para times e automação IA

---
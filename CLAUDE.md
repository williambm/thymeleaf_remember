# CLAUDE.md — Sistema de Inscrição em Evento Universitário

## Contexto do Projeto

Este projeto é um sistema web para gerenciamento de inscrições em eventos universitários.

O sistema possui duas personas:

- **Aluno** — acessa a landing page do evento, realiza inscrição e consulta o status da sua inscrição
- **Docente** — acessa uma área restrita para gerenciar as inscrições (deferir ou indeferir)

---

## Stack e Versões

- **Java 17**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **Thymeleaf** — motor de templates para renderização server-side
- **H2** — banco de dados em memória (console habilitado para visualização em desenvolvimento)
- **Bootstrap 5** — estilização dos templates
- **Maven** — gerenciamento de dependências

---

## Estrutura de Pacotes

```
src/main/java/br/unesp/evento/
├── controller/       # Recebe requisições HTTP e retorna templates Thymeleaf
├── service/          # Regras de negócio
├── model/            # Entidades JPA
└── repository/       # Interfaces Spring Data JPA

src/main/resources/
├── templates/
│   ├── publico/      # Templates acessíveis pelo aluno
│   └── docente/      # Templates da área de gerenciamento
└── static/
    └── css/          # Estilos customizados complementares ao Bootstrap
```

---

## Personas e Funcionalidades

### Aluno (área pública)
- Visualizar a landing page do evento (nome, descrição, data, local, vagas)
- Preencher e enviar formulário de inscrição (nome, e-mail, curso, período)
- Consultar o status da própria inscrição informando o e-mail cadastrado

### Docente (área restrita)
- Acessar área de gerenciamento via tela de login simples
- Visualizar lista de todas as inscrições com status
- Deferir ou indeferir inscrições individualmente

---

## Convenções de Código

- **Idioma:** Português para nomes de classes, métodos, variáveis e atributos
- **Controllers:** sufixo `Controlador` — ex: `InscricaoControlador`, `DocenteControlador`
- **Services:** sufixo `Servico` — ex: `InscricaoServico`
- **Repositories:** sufixo `Repositorio` — ex: `InscricaoRepositorio`
- **Models:** nome direto da entidade — ex: `Inscricao`, `Evento`
- **Templates:** nomes em português, kebab-case — ex: `formulario-inscricao.html`, `lista-inscricoes.html`

---

## Simulação de Autenticação do Docente

**Não usar Spring Security.**

Implementar uma tela de login simples com usuário e senha fixos em memória:

- Usuário: `docente`
- Senha: `unesp2025`

Ao autenticar com sucesso, armazenar um atributo na `HttpSession` para controlar o acesso à área do docente. Os controllers da área docente devem verificar esse atributo no início de cada método e redirecionar para o login caso não esteja presente.

---

## Identidade Visual — Estilo Unesp

Os templates devem seguir a identidade visual institucional da Unesp:

**Cores:**
- Azul escuro: `#0000CC` — cabeçalho, botões primários, links
- Azul claro: `#1ca9da` — destaques, badges de status, elementos secundários
- Fundo: branco `#FFFFFF`
- Texto: cinza escuro `#333333`

**Tipografia:**
- Fonte sans-serif — usar `Arial, sans-serif` como família padrão

**Layout:**
- Header com faixa azul escura contendo o nome do sistema e o nome do evento
- Navbar simples e limpa
- Conteúdo centralizado com `container` do Bootstrap
- Rodapé discreto com referência institucional
- Visual sóbrio e institucional — sem elementos decorativos excessivos

**Badges de status de inscrição:**
- Pendente: `badge bg-warning text-dark`
- Deferida: `badge bg-success`
- Indeferida: `badge bg-danger`

---

## O que NÃO Fazer

- ❌ Não usar Spring Security
- ❌ Não criar endpoints REST (sem `@RestController`, sem JSON)
- ❌ Não usar banco de dados externo (MySQL, PostgreSQL) — apenas H2
- ❌ Não usar JavaScript complexo — apenas o que o Bootstrap já fornece
- ❌ Não criar mais de uma entidade de evento — o sistema é para um único evento fixo
- ❌ Não implementar recuperação de senha ou cadastro de docentes
- ❌ Não usar Lombok — manter o código explícito e didático

---

## Dados do Evento (Fixos no Sistema)

O evento é único e seus dados podem ser carregados via `data.sql` ou configurados diretamente no service:

- **Nome:** Semana Acadêmica de Tecnologia
- **Descrição:** Evento universitário com palestras, workshops e minicursos voltados à comunidade acadêmica.
- **Data:** 31/07/2026
- **Local:** Reitoria - prédio praça da república.
- **Vagas:** 150

---

## Observações Gerais

- O código deve ser simples, legível e didático — priorizar clareza sobre elegância
- Cada camada deve ter responsabilidade única e bem definida
- Os templates Thymeleaf devem usar fragmentos (`th:fragment`) para header e footer reutilizáveis
- O console do H2 deve estar habilitado em `application.properties` para fins didáticos
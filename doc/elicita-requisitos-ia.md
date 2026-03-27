# Elicitação de Requisitos com IA (Claude Code)

Este exemplo mostra como utilizar uma IA (Claude/Claude Code) para apoiar a elicitação de requisitos no desenvolvimento de um sistema de inscrição em evento universitário. O objetivo é transformar uma ideia inicial em requisitos completos, personas e funcionalidades com prompts e feedback estruturado.

---

## Exemplo de Conversa Estruturante

### Prompt Inicial do Usuário
```
Quero construir um sistema web para gerenciar inscrições em um evento universitário.
É para alunos se inscreverem e para professores controlarem as inscrições.
Poderia me ajudar a detalhar os requisitos?
```

### Resposta da IA
Claro! Para começar, preciso entender melhor alguns pontos do evento e do fluxo. Por favor, informe:
- Nome do evento, descrição, data, local, quantidade de vagas.
- Quais perfis devem acessar o sistema? (Ex: alunos, docentes...)
- Quais funcionalidades cada perfil deve ter? (Ex: inscrição, consulta, gerenciamento...)

### Prompt do Usuário
```
O evento chama-se Semana Acadêmica de Tecnologia, ocorre dia 31/07/2026 na Reitoria e tem 150 vagas.
Quero dois perfis: Aluno (faz inscrição, consulta status) e Docente (gerencia inscrições, defere/indefere).
```

### Resposta da IA
Ótimo, com base nisso, os requisitos podem ser:
- [x] Cadastro de inscrições por alunos com nome, e-mail, curso, período
- [x] Consulta do status da inscrição informando o e-mail
- [x] Área restrita para docentes com login
- [x] Listagem de todas as inscrições com status
- [x] Possibilidade de deferir ou indeferir cada inscrição individualmente

**Personas:**
- Aluno: se inscreve no evento e consulta status.
- Docente: gerencia inscrições e define status.

**Funcionalidades detalhadas:**
- Formulário público de inscrição
- Busca/consulta de inscrição por e-mail
- Login e sessão para docentes
- Interface para docentes validarem inscrições
- Visualização clara de status (pendente, deferida, indeferida)

---

## Resultado Estruturado

**Requisitos de Negócio**  
- O sistema deve permitir inscrição de alunos para um evento fixo.
- Cada aluno inscreve-se informando nome, e-mail, curso e período.
- Docentes acessam a área restrita com usuário fixo.
- Docentes podem alterar o status das inscrições.
- Alunos consultam seu status com o e-mail cadastrado.

**Personas**  
- Aluno
- Docente

**Funcionalidades**  
- Landing page institucional
- Formulário de inscrição de aluno
- Consulta pública de status
- Login docente
- Área docente para decisão sobre inscrições

---

Este documento exemplifica como utilizar a IA para transformar uma ideia inicial em requisitos, personas e funcionalidades de modo claro, colaborativo e iterativo.
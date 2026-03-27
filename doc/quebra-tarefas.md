# Quebra de Tarefas e Delegação Incremental ao Agente (Claude Code)

Este documento mostra como traduzir os requisitos e visão do sistema em tarefas técnicas (histórias de usuário ou tasks) que podem ser delegadas incrementalmente à IA para desenvolvimento ágil e controlado.

---

## 1. Abordagem: Programação por Ciclos Curtos

A construção do sistema é feita em etapas pequenas:
- Defina o objetivo de cada ciclo (ex: “criar formulário de inscrição”).
- Delegue à IA a implementação, peça que rode tests.
- Valide e só então prossiga para a próxima task.

Isso garante rastreabilidade, controle de qualidade e facilidade de ajustes.

---

## 2. Macro-Tarefas x Tarefas Detalhadas

### Exemplo: Macro-Tarefa
```
Implementar funcionalidade de inscrição de aluno no evento.
```

### Quebra recomendada em tarefas delegáveis:
1. Implementar modelo JPA de Inscricao.
2. Criar repositório InscricaoRepositorio.
3. Implementar InscricaoControlador: mostrar formulário de inscrição.
4. Implementar lógica de cadastro e validação.
5. Exibir mensagem de sucesso/erro no template.
6. Permitir consulta do status da inscrição pelo e-mail.

---

## 3. Exemplo de Delegação via Prompt

### Prompt (para Claude Code)
```
Crie o modelo JPA 'Inscricao' com os campos: id, nome, email, curso, periodo, status.
O campo status deve ser um Enum: PENDENTE, DEFERIDA, INDEFERIDA.
Siga as convenções deste projeto (ver CLAUDE.md) e retorne a entidade completa.
```

### Prompt para tarefa de tela:
```
Implemente o template Thymeleaf 'formulario-inscricao.html' no padrão Bootstrap 5,
seguindo as cores Unesp e o fragmento de header/footer.
O formulário deve pedir: nome, email, curso, período.
Ao submeter, enviar os dados para o controller e exibir mensagem de sucesso ou erro.
```

---

## 4. Sequência Sugerida de Tarefas

1. Modelo JPA: Inscricao
2. Enum StatusInscricao
3. InscricaoRepositorio
4. InscricaoControlador: endpoints da área pública
5. Templates públicos: landing-page, formulario-inscricao, consulta-status
6. DocenteControlador: login + área administrativa
7. Templates docentes: login, lista-inscricoes
8. Lógica de deferimento/indeferimento
9. Validação geral e feedbacks de status
10. Teste e ajustes visuais finais

---

## 5. Benefícios do Ciclo Incremental com IA

- Visibilidade contínua do progresso.
- Facilidade para pausar, revisar ou ajustar requisitos em tempo real.
- Promove code review e aprendizado didático no processo.

---

Este documento serve como guia prático para delegar e executar tarefas incrementais em projetos orientados por IA, garantindo clareza, rastreabilidade e facilidade de revisão/ensino.
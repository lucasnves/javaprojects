[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-c66648af7eb3fe8bc4f294546bfd86ef473780cde1dea487d3c4ff354943c9ae.svg)](https://classroom.github.com/online_ide?assignment_repo_id=9687560&assignment_repo_type=AssignmentRepo)
# Trabalho de PPOO - Sistema de Recomendação

Veja as Instruções do Trabalho no Campus Virtual da disciplina.

Preencha os campos abaixo de acordo com as intruções dadas.

## Definição do Grupo

**Nome do grupo**: Spotfly

**Tema escolhido**: Obras de Arte (pinturas e músicas)

**Integrantes** (preencha abaixo):

- BRENDA MOREIRA DA SILVA
- DIEGO DE SOUZA MARQUES
- LISLAILA TARSILA PEREIRA
- LUCAS NEVES SABER GABRIEL

### Informações para utilização do sistema:
    - O sistema inicia buscando pelo arquivo com os usuários e obras cadastrados
        -Caso não exista usuários cadastrados ainda ele cria 3 tipos usuaŕios:
            - Adminsitrador (login: adm, senha: adm)
            - Moderador (login: mod, senha: mod)
            - Comum (login: comum, senha: comum)
        - Caso já exista usuários cadastrados, além de possuir os 3 usuarios acima, também possui os novos usuários cadastrados

## Checklist para a Primeira Entrega

**Preencha a coluna _Respostas_** na tabela abaixo **antes de fazer a primeira entrega**.

- Obs.: a coluna _Id_ indica a seção das Instruções do trabalho.

|  Id   |  Descrição                                                         | Respostas | 
|-------|--------------------------------------------------------------------|-----------|
| 2.1.1 | O sistema permite cadastrar itens?                                 | (sim) |
| 2.1.1 | O sistema usa o código fornecido para obter a descrição dos itens? | (sim) |
| 2.1.1 | Se sim na resposta anterior, de qual Wiki?                         | (Wikipedia em português) |
| 2.1.2 | O sistema permite visualizar os detalhes dos itens?                | (sim) |
| 2.1.3 | O sistema permite excluir itens cadastrados?                       | (sim) |
| 2.1.4 | O sistema permite cadastrar usuários?                              | (sim) |
| 2.1.4 | Há tratamento para os diferentes tipos de usuários?                | (sim) |
| 3.1.3 | O código implementado tem bom design de classes?                   | (sim) |
| 3.1.4 | O código implementado tem divisão de camadas?                      | (sim) |
| 3.1.5 | O código faz uso de herança? Tem superclasse e subclasses?         | (sim) |
| 3.1.6 | O código inicial fornecido pelo professor foi alterado?            | (não) |
| 3.1.7 | Como os itens são salvos?                                          | (arquivo binário) |
| 3.1.8 | Diagrama simplificado em PNG se encontra na pasta `doc`?           | (sim) |
| 3.1.9 | Código enviado compila sem erros na versão 17 do Java?             | (sim) |
| 3.1.9 | Implementação usa pacote `br.ufla.gac106.s2022_2.nomeDoGrupo`?     | (sim) |
| 3.1.9 | Foi adicionada alguma biblioteca (arquivo `.jar`)?                 | (não) |
| 3.1.9 | Código está legível, organizado e bem comentado?                   | (sim) |
|       | Todos os integrantes contribuíram, inclusive na implementação?     | (sim) |

## Checklist para a Entrega Final

**Preencha a coluna _Respostas_** na tabela abaixo **antes da entrega final**.

- Obs.: a coluna _Id_ indica a seção das Instruções do trabalho.

|  Id   |  Descrição                                                                  | Respostas | 
|-------|-----------------------------------------------------------------------------|-----------|
| 2.1   | Sistema trata todos os itens do módulo de Administração (primeira entrega)? | (sim) |
| 2.2.1 | É possível consultar a lista de itens cadastrados no módulo de Avaliação?   | (sim) |
| 2.2.1 | A lista pode ser ordenada por nome e por classificação média?               | (sim) |
| 2.2.2 | É possível filtrar os dados? Quais são os filtros?                          | (subgrupos de palavras e obras sem classificao)         |
| 2.2.3 | O usuário consegue comentar os itens? Mais de uma vez?                      | (sim) |
| 2.2.3 | Os comentários são salvos (persistidos)?                                    | (sim) |
| 2.2.4 | O usuário consegue classificar os itens? Como?                              | (sim) (curtindo / descrutir (não é unlike)) |
| 2.2.4 | As classificações são salvas (persistidas)?                                 | (sim) |
| 2.2.5 | No módulo de Avaliação, o usuário consegue ver os detalhes dos itens?       | (sim) |
| 2.2.5 | Os detalhes incluem classificação média e comentários?                      | (sim) |
| 2.2.6 | Foi implementado o módulo de relatórios?                                    | (sim) |
| 2.2.6 | Relatório permite consulta da quantidade de itens classificados ou não?     | (sim) |
| 2.2.6 | Relatório permite consulta dos 5 itens melhor classificados, de cada tipo?  | (sim) |
| 2.2.6 | Relatório permite consulta dos 3 usuários que mais classificaram itens?     | (sim) |
| 2.2.6 | Relatório permite consulta dos 3 usuários que mais comentaram itens?        | (sim) |
| 2.2.6 | Relatório permite exibição do gráfico usando código fonercido?              | (sim) |
| 3.1.3 | O código implementado tem bom design de classes?                   | (sim) |
| 3.1.4 | O código implementado tem divisão de camadas?                      | (sim) |
| 3.1.5 | O código faz uso de herança? Tem superclasse e subclasses?         | (sim) |
| 3.1.6 | O código inicial fornecido pelo professor foi alterado?            | (não) |
| 3.1.7 | Como os itens são salvos?                                          | (arquivo binário) |
| 3.1.8 | Diagrama simplificado em PNG se encontra na pasta `doc`?           | (sim) |
| 3.1.9 | Código enviado compila sem erros na versão 17 do Java?             | (sim) |
| 3.1.9 | Implementação usa pacote `br.ufla.gac106.s2022_2.nomeDoGrupo`?     | (sim) |
| 3.1.9 | Foi adicionada alguma biblioteca (arquivo `.jar`)?                 | (não) |
| 3.1.9 | Código está legível, organizado e bem comentado?                   | (sim) |
| 3.1.10| Código faz uso de variável polimórfica?                            | (sim) |
| 3.1.10| Código faz uso de polimorfismo de método?                          | (sim) |
| 3.1.11| Há tratamento de exceção para entradas inválidas do usuário?       | (sim) |
| 3.1.11| Há tratamento de exceção para programa não fechar por erro de execução? | (sim) |
| 3.1.11| Há tratamento de exceção para exceções lançadas pela classe Wiki?  | (sim) |
| 3.1.12| Foi implementado algum Padrão de Projeto? Qual?                    | (sim (Singleton, "Factory Simples" )) |
| 3.1.13| A interface de usuário é de fácil utilização?                      | (sim) |
| 3.1.13| Foi implementada interface gráfica de usuário?                     | (não) |
|       | Todos os integrantes contribuíram, inclusive na implementação?     | (sim) |

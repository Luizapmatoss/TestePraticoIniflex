# TestePraticoIniflex

# 🚀 Projeto de Gestão de Funcionários

Este é um projeto de console em Java desenvolvido como parte de um processo seletivo para a vaga de Desenvolvedor Júnior. O objetivo principal é demonstrar habilidades em programação orientada a objetos (POO), manipulação de coleções, tratamento de dados (datas e valores numéricos) e a aplicação de boas práticas de código.

---

## 📋 Funcionalidades

O programa executa as seguintes operações em uma lista de funcionários:

* **Listagem de Dados:** Cria e exibe uma lista de funcionários com informações detalhadas.
* **Remoção:** Remove um funcionário específico da lista.
* **Atualização:** Aplica um aumento salarial de 10% a todos os funcionários.
* **Consultas:**
    * Agrupa e exibe os funcionários por função.
    * Filtra e exibe os aniversariantes dos meses de outubro e dezembro.
    * Identifica e mostra o funcionário mais velho.
    * Calcula e imprime o salário total da equipe.
    * Exibe o salário de cada funcionário em múltiplos do salário mínimo.
* **Ordenação:** Organiza e exibe a lista de funcionários em ordem alfabética por nome.

---

## 🛠️ Tecnologias e Boas Práticas

* **Java 8+:** Utiliza recursos modernos da linguagem, como a Stream API para manipulação de dados de forma funcional e eficiente.
* **Programação Orientada a Objetos (POO):** O projeto foi estruturado com classes (`Pessoa`, `Funcionario`) e herança para modelar o domínio de forma clara.
* **Princípio de Responsabilidade Única (SRP):** A lógica de negócio foi isolada em uma classe de serviço (`FuncionarioService`), deixando a classe principal (`Principal`) responsável apenas pela orquestração.
* **Tratamento de Dados:** Utilização de `java.time.LocalDate` para manipulação segura de datas e `java.math.BigDecimal` para cálculos financeiros precisos, evitando erros de ponto flutuante.
* **Código Limpo:** As saídas no console são formatadas de maneira clara e visualmente agradável, demonstrando atenção aos detalhes e à experiência do usuário.

---

## 💻 Como Executar o Projeto

Para rodar este projeto em seu ambiente local, siga estes passos simples:

1.  **Clone o Repositório:**
    ```bash
    git clone [https://github.com/SeuNomeDeUsuario/nome-do-seu-repositorio.git](https://github.com/SeuNomeDeUsuario/nome-do-seu-repositorio.git)
    ```
2.  **Abra o Projeto:**
    Importe a pasta do projeto em sua IDE Java preferida (IntelliJ IDEA, Eclipse, VS Code, etc.).
3.  **Execute a Classe Principal:**
    Rode a classe `Main.java`. A saída será exibida diretamente no console da sua IDE.

---

## 📬 Contato

Se tiver qualquer dúvida ou feedback, sinta-se à vontade para entrar em contato:

* **Nome:** Luiza de Paula Matos
* **E-mail:** contatoluizamatos@gmail.com
* **LinkedIn:** https://www.linkedin.com/in/luiza-matos-2b17a3356/

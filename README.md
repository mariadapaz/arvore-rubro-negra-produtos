# Árvore Rubro-Negra: Organização de Produtos

Este projeto utiliza uma árvore rubro-negra (implementada com `TreeMap` em Java) para armazenar e organizar produtos com base em seus valores. Os produtos são separados em dois grupos: abaixo de R$100,00 e acima de R$100,00. O projeto simula a geração de 10.000 produtos e salva os resultados em arquivos de texto.

## Requisitos

- **Java Development Kit (JDK)**: Versão 8 ou superior.
- **IDE** (opcional): Eclipse, IntelliJ IDEA, ou qualquer editor de texto com suporte a Java.
- **Git** (opcional): Para clonar o repositório.

## Como Rodar o Projeto

1. **Clone o repositório**:
   ```bash
   git clone https://github.com/mariadapaz/arvore-rubro-negra-produtos.git
   cd arvore-rubro-negra-produtos

2. **Compile o codigo**:
   ```bash
   javac arvRb/Main.java

3. **Execute o programa**:
   ```bash
   java arvRb.Main
## Explicação do Código

### Estrutura do Projeto

- **Main.java**: Contém a lógica principal do programa, incluindo a geração de produtos, separação em subgrupos e salvamento em arquivos.
- **Produto.java**: Representa um produto com descrição e valor. Implementa o método `toString` para formatar a saída.

### Detalhes do Código

#### 1. Geração de Produtos

- O programa gera 10.000 produtos com valores aleatórios entre R$10,00 e R$500,00.
- Cada produto é armazenado em um `TreeMap`, onde a chave é a descrição e o valor é um objeto `Produto`.

#### 2. Separação dos Produtos

- Os produtos são separados em dois subgrupos:
  - **`produtosAbaixo100`**: Produtos com valor abaixo de R$100,00.
  - **`produtosAcima100`**: Produtos com valor acima de R$100,00.
- Ambos os subgrupos são armazenados em `TreeMap`s para manter a ordenação.

#### 3. Persistência dos Dados

- Os subgrupos são salvos em arquivos de texto (`produtosAbaixo100.txt` e `produtosAcima100.txt`).
- O método `salvarArquivo` utiliza `PrintWriter` para escrever os dados no arquivo.

#### 4. Formatação dos Valores

- O método `toString` da classe `Produto` formata os valores com duas casas decimais:
  ```java
  return String.format("%s: R$%.2f", descricao, valor);
## Exibição da Árvore no Console

O programa exibe todos os produtos ordenados no console antes de separá-los em subgrupos.  
Para isso, utiliza o método `exibirArvoreOrdenada`, que percorre o `TreeMap` e imprime os produtos em ordem crescente de descrição.

### Exemplo de Saída

Os arquivos gerados terão o seguinte formato:
`Produto1001: R$12,00
Produto1005: R$69,96`


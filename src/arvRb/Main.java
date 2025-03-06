package arvRb;

import java.util.Map;
import java.util.NavigableMap;
import java.util.Random;
import java.util.TreeMap;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    private static final int NUM_PRODUTOS = 10000;
    private static final double LIMITE_PRECO = 100.00;

    public static void main(String[] args) {
        TreeMap<String, Produto> produtos = new TreeMap<>();

        // Gera produtos aleatórios
        Random random = new Random();
        for (int i = 1; i <= NUM_PRODUTOS; i++) {
            String descricao = "Produto" + i;
            double valor = 5 + (200 - 5) * random.nextDouble();
            produtos.put(descricao, new Produto(descricao, valor));
        }

        // Exibe a árvore completa no console
        exibirArvoreOrdenada(produtos);

        // Usanso os métodos da estrutura para obter subgrupos
        NavigableMap<String, Produto> produtosAbaixo100 = produtos.headMap("Produto" + NUM_PRODUTOS, true)
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue().getValor() < LIMITE_PRECO)
                .collect(TreeMap::new, (map, e) -> map.put(e.getKey(), e.getValue()), TreeMap::putAll);

        NavigableMap<String, Produto> produtosAcima100 = produtos.tailMap("Produto1", true)
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue().getValor() >= LIMITE_PRECO)
                .collect(TreeMap::new, (map, e) -> map.put(e.getKey(), e.getValue()), TreeMap::putAll);

        // Salvar arquivos
        salvarArquivo("produtosAbaixo100.txt", produtosAbaixo100);
        salvarArquivo("produtosAcima100.txt", produtosAcima100);
    }

    private static void exibirArvoreOrdenada(Map<String, Produto> produtos) {
        System.out.println("=== Produtos Ordenados ===");
        for (Map.Entry<String, Produto> entry : produtos.entrySet()) {
            System.out.println(entry.getValue());
        }
        System.out.println("=========================");
    }

    private static void salvarArquivo(String nomeArquivo, Map<String, Produto> produtos) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo))) {
            for (Produto produto : produtos.values()) {
                writer.println(produto);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

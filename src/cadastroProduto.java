import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class cadastroProduto extends JFrame {
    private final List<Produto> produtos = new ArrayList<>();

    private final JTextField campoNome = new JTextField(20);
    private final JTextField campoPreco = new JTextField(10);
    private final JTextField campoQuantidade = new JTextField(10);
    private final JButton botaoSalvar = new JButton("Salvar produto");
    private final JTextArea areaProdutos = new JTextArea(8, 30);

    public cadastroProduto() {
        setTitle("Cadastro de Produto");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 350);
        setLocationRelativeTo(null);
        setLayout(new java.awt.BorderLayout(10, 10));

        JPanel painelFormulario = new JPanel(new java.awt.GridLayout(3, 2, 10, 10));
        painelFormulario.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));

        painelFormulario.add(new JLabel("Nome do produto:"));
        painelFormulario.add(campoNome);

        painelFormulario.add(new JLabel("Preço:"));
        painelFormulario.add(campoPreco);

        painelFormulario.add(new JLabel("Quantidade em estoque:"));
        painelFormulario.add(campoQuantidade);

        JPanel painelBotao = new JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER));
        painelBotao.add(botaoSalvar);

        areaProdutos.setEditable(false);
        areaProdutos.setBorder(BorderFactory.createTitledBorder("Produtos cadastrados"));

        add(painelFormulario, java.awt.BorderLayout.NORTH);
        add(painelBotao, java.awt.BorderLayout.CENTER);
        add(new JScrollPane(areaProdutos), java.awt.BorderLayout.SOUTH);

        botaoSalvar.addActionListener(e -> salvarProduto());
    }

    private void salvarProduto() {
        String nome = campoNome.getText().trim();
        String precoTexto = campoPreco.getText().trim();
        String quantidadeTexto = campoQuantidade.getText().trim();

        if (nome.isEmpty() || precoTexto.isEmpty() || quantidadeTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos antes de salvar.");
            return;
        }

        try {
            double preco = Double.parseDouble(precoTexto.replace(',', '.'));
            int quantidade = Integer.parseInt(quantidadeTexto);

            if (quantidade < 0) {
                JOptionPane.showMessageDialog(this, "A quantidade em estoque não pode ser negativa.");
                return;
            }

            Produto produto = new Produto(nome, preco, quantidade);
            produtos.add(produto);

            areaProdutos.append(produto.toString() + "\n");
            limparCampos();
            JOptionPane.showMessageDialog(this, "Produto salvo com sucesso!");
        } catch (NumberFormatException erro) {
            JOptionPane.showMessageDialog(this, "Preço e quantidade devem ser valores válidos.");
        }
    }

    private void limparCampos() {
        campoNome.setText("");
        campoPreco.setText("");
        campoQuantidade.setText("");
        campoNome.requestFocus();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            cadastroProduto tela = new cadastroProduto();
            tela.setVisible(true);
        });
    }

    private static class Produto {
        private final String nome;
        private final double preco;
        private final int quantidadeEstoque;

        public Produto(String nome, double preco, int quantidadeEstoque) {
            this.nome = nome;
            this.preco = preco;
            this.quantidadeEstoque = quantidadeEstoque;
        }

        @Override
        public String toString() {
            return "Produto: " + nome + " | Preço: R$ " + String.format("%.2f", preco)
                    + " | Estoque: " + quantidadeEstoque;
        }
    }
}

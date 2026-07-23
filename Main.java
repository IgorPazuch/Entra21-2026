import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import dao.PedidoDao;
import dao.ClienteDao;
import dao.ProdutoDao;
import modelos.Cliente;
import modelos.Pedido;
import modelos.Produto;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ProdutoDao dao = new ProdutoDao();

        Pedido carrinho = new Pedido();
    
        int opcao;

        do {

            System.out.println("\n=== MENU ===");
            System.out.println("1 - Cadastrar Produto");
            System.out.println("2 - Listar Produtos");
            System.out.println("3 - Cadastrar Cliente");
            System.out.println("4 - Listar Clientes");
            System.out.println("5 - Cadastrar Pedido");
            System.out.println("6 - Listar Pedidos");
            System.out.println("7 - Finalizar Pedido");
            System.out.println("8 - Excluir Pedido");
            System.out.println("9 - Adicionar Produto ao Carrinho");
            System.out.println("10 - Remover Produto do Carrinho");
            System.out.println("0 - Sair");

            opcao = sc.nextInt();

            switch (opcao) {

                case 1:

                    sc.nextLine();

                    System.out.print("Descrição: ");
                    String descricao = sc.nextLine();

                    System.out.print("Preço: ");
                    double preco = sc.nextDouble();

                    System.out.print("Quantidade: ");
                    int quantidade = sc.nextInt();

                    Produto produto = new Produto(descricao, preco, quantidade);

                    dao.salvar(produto);

                    break;

                case 2:

                    List<Produto> produtos = dao.listar();

                    for (Produto p : produtos) {

                        System.out.println(
                                p.getId() + " | " +
                                        p.getDescricao() + " | " +
                                        p.getPreco() + " | " +
                                        p.getQuantidade());
                    }

                    break;

                case 3:

                    sc.nextLine();

                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();

                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    System.out.print("Rua: ");
                    String rua = sc.nextLine();

                    System.out.print("Número: ");
                    int numero = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Bairro: ");
                    String bairro = sc.nextLine();

                    System.out.print("CEP: ");
                    int cep = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Cidade: ");
                    String cidade = sc.nextLine();

                    System.out.print("Estado: ");
                    String estado = sc.nextLine();

                    Cliente cliente = new Cliente();

                    cliente.setCpf(cpf);
                    cliente.setNome(nome);
                    cliente.setEmail(email);
                    cliente.setRua(rua);
                    cliente.setNumero(numero);
                    cliente.setBairro(bairro);
                    cliente.setCep(cep);
                    cliente.setCidade(cidade);
                    cliente.setEstado(estado);

                    ClienteDao clienteDao = new ClienteDao();

                    clienteDao.salvar(cliente);

                    break;

                case 4:

                    ClienteDao clienteDao2 = new ClienteDao();

                    List<Cliente> clientes = clienteDao2.listar();

                    for (Cliente c : clientes) {

                        System.out.println(
                                c.getId() + " | " +
                                        c.getNome() + " | " +
                                        c.getCpf());
                    }

                    break;

                case 5:

                    System.out.print("ID do cliente: ");
                    int idCliente = sc.nextInt();

                    ClienteDao clienteDao3 = new ClienteDao();

                    Cliente cliente3 = clienteDao3.consultar(idCliente);

                    if (cliente3 == null) {

                        System.out.println("Cliente não encontrado!");
                        break;
                    }

                    Pedido pedido = new Pedido();

                    pedido.setCliente(cliente3);

                    int idProduto;

                    do {

                        System.out.print("ID do produto (0 para finalizar): ");
                        idProduto = sc.nextInt();

                        if (idProduto != 0) {

                            Produto produtoCarrinho = dao.consultar(idProduto);

                            if (produtoCarrinho != null) {

                                pedido.adicionarProduto(produtoCarrinho);

                                System.out.println("Produto adicionado!");

                            } else {

                                System.out.println("Produto não encontrado!");
                            }
                        }

                    } while (idProduto != 0);

                    System.out.println("\nPRODUTOS DO PEDIDO:");

                    for (Produto p : pedido.getProdutos()) {

                        System.out.println(
                                p.getId() + " | " +
                                        p.getDescricao() + " | " +
                                        p.getPreco());
                    }

                    PedidoDao pedidoDao = new PedidoDao();

                    pedidoDao.salvar(pedido);

                    break;

                case 6:

                    PedidoDao pedidoDao2 = new PedidoDao();

                    List<Pedido> pedidos = pedidoDao2.listar();

                    for (Pedido p : pedidos) {

                        System.out.println(
                                p.getId() + " | " +
                                        p.getData() + " | " +
                                        p.getStatus());
                    }

                    break;

                case 7:

                    System.out.print("ID do pedido: ");
                    int idPedido = sc.nextInt();

                    PedidoDao pedidoDao3 = new PedidoDao();

                    pedidoDao3.finalizar(idPedido);

                    break;

                case 8:

                    System.out.print("ID do pedido: ");
                    int idExcluir = sc.nextInt();

                    PedidoDao pedidoDao4 = new PedidoDao();

                    pedidoDao4.excluir(idExcluir);

                    break;

                case 9:

                    System.out.print("ID do produto: ");
                    int idProduto1 = sc.nextInt();

                    Produto produtoCarrinho = dao.consultar(idProduto1);

                    if (produtoCarrinho != null) {

                        carrinho.adicionarProduto(produtoCarrinho);

                        System.out.println("Produto adicionado ao carrinho!");

                    } else {

                        System.out.println("Produto não encontrado!");
                    }

                    break;

                case 10:
                    
                    System.out.print("ID do produto: ");
                    int idProdutoRemover = sc.nextInt();

                    Produto produtoRemover = dao.consultar(idProdutoRemover);

                    if(produtoRemover != null) {

                        carrinho.removerProduto(produtoRemover);

                        System.out.println("Produto removido do carrinho!");

                    } else {

                        System.out.println("Produto não encontrado!");
                    }

                    break;


            }

        } while (opcao != 0);

        sc.close();
    }
}
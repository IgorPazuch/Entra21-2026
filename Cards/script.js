var editandoIndex = -1;

function cadastrar(event) {
    event.preventDefault(); // Evita o comportamento padrão do formulário

    var nome = document.getElementById("nome");
    var email = document.getElementById("email");
    var telefone = document.getElementById("telefone");

    var rua = document.getElementById("rua");
    var bairro = document.getElementById("bairro");
    var cidade = document.getElementById("cidade");
    var cep = document.getElementById("cep");

    var cliente = {
        nome: nome.value,
        email: email.value,
        telefone: telefone.value,
        cep: cep.value,
        rua: rua.value,
        bairro: bairro.value,
        cidade: cidade.value
    };

    // PEGANDO CLIENTES
    var clientes = JSON.parse(localStorage.getItem("clientes")) || [];

    var editandoIndex = localStorage.getItem("editandoIndex");

    if (editandoIndex !== null && editandoIndex !== "") {
        clientes[editandoIndex] = cliente;
    } else {
        clientes.push(cliente);
        localStorage.setItem("clientes", JSON.stringify(clientes));
    }
    localStorage.setItem("clientes", JSON.stringify(clientes));

    localStorage.removeItem("editandoIndex");
    localStorage.removeItem("nomeEditar");
    localStorage.removeItem("emailEditar");
    localStorage.removeItem("telefoneEditar");

    nome.value = "";
    email.value = "";
    telefone.value = "";

    alert("Cliente cadastrado com sucesso!");
}

function mostrarCards() {
    window.location.href = "tabela.html";
}

function voltarCadastro() {
    window.location.href = "cadastro.html";
}

// Executa somente na tabela.html
window.onload = function () {

    // ===== TABELA =====
    var lista = document.getElementById("listaClientes");

    if (lista) {

        var clientes = JSON.parse(localStorage.getItem("clientes")) || [];

        clientes.forEach(function (cliente, index) {

            lista.innerHTML += `
                <div class="card">

                    <h3>${cliente.nome}</h3>
                    <p>📧 ${cliente.email}</p>
                    <p>📱 ${cliente.telefone}</p>
                    <p>🆔 ${cliente.cep}</p>
                    <p>📍 ${cliente.rua}</p>
                    <p>🏘️ ${cliente.bairro}</p>
                    <p>🌆 ${cliente.cidade}</p>

                    <button onclick="editarCliente(${index})">
                        Editar
                    </button>

                    <button onclick="excluirCliente(${index})">
                        Excluir
                    </button>

                </div>
            `;
        });
    }

    var nome = document.getElementById("nome");

    if (nome) {

        document.getElementById("nome").value =
            localStorage.getItem("nomeEditar") || "";

        document.getElementById("email").value =
            localStorage.getItem("emailEditar") || "";

        document.getElementById("telefone").value =
            localStorage.getItem("telefoneEditar") || "";
    }
}
function excluirCliente(index) {

    var clientes = JSON.parse(localStorage.getItem("clientes")) || [];

    clientes.splice(index, 1);

    localStorage.setItem("clientes", JSON.stringify(clientes));

    location.reload();
}

function editarCliente(index) {

    var clientes = JSON.parse(localStorage.getItem("clientes")) || [];

    var cliente = clientes[index];

    // Salvando index do cliente
    localStorage.setItem("editandoIndex", index);

    // Preenchendo inputs
    localStorage.setItem("nomeEditar", cliente.nome);
    localStorage.setItem("emailEditar", cliente.email);
    localStorage.setItem("telefoneEditar", cliente.telefone);

    // Voltando para cadastro
    window.location.href = "cadastro.html";
}

async function buscarCep() {

    let cep = document.getElementById("cep").value;

    // Remove traços e caracteres especiais
    cep = cep.replace(/\D/g, "");

    if (cep.length !== 8) {
        alert("CEP inválido!");
        return;
    }

    try {

        const resposta = await fetch(`https://viacep.com.br/ws/${cep}/json/`);

        const dados = await resposta.json();

        if (dados.erro) {
            alert("CEP não encontrado!");
            return;
        }

        document.getElementById("rua").value = dados.logradouro;
        document.getElementById("bairro").value = dados.bairro;
        document.getElementById("cidade").value = dados.localidade;

    } catch (erro) {

        console.error(erro);
        alert("Erro ao buscar CEP.");

    }
}
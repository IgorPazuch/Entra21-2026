var editandoIndex = -1;

function cadastrar(event) {
    event.preventDefault(); // Evita o comportamento padrão do formulário

    var nome = document.getElementById("nome");
    var email = document.getElementById("email");
    var telefone = document.getElementById("telefone");

    var erroNome = document.getElementById("erroNome");
    var erroEmail = document.getElementById("erroEmail");
    var erroTelefone = document.getElementById("erroTelefone");

    // Limpando erros antigos
    erroNome.innerHTML = "";
    erroEmail.innerHTML = "";
    erroTelefone.innerHTML = "";

    // OBJETO CLIENTE
    var cliente = {
        nome: nome.value,
        email: email.value,
        telefone: telefone.value
    };

    // PEGANDO CLIENTES
    var clientes = JSON.parse(localStorage.getItem("clientes")) || [];

    var editandoIndex = localStorage.getItem("editandoIndex");

    if (editandoIndex !== null) {

        clientes[editandoIndex] = cliente;

        localStorage.removeItem("editandoIndex");

        localStorage.removeItem("nomeEditar");
        localStorage.removeItem("emailEditar");
        localStorage.removeItem("telefoneEditar");

    } else {

        clientes.push(cliente);
    }
    // SALVANDO
    localStorage.setItem("clientes", JSON.stringify(clientes));

    // LIMPAR CAMPOS
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

    var lista = document.getElementById("listaClientes");

    // Se não existir, para tudo
    if (!lista) {
        return;
    }

    // Pegando clientes do localStorage
    var clientes = JSON.parse(localStorage.getItem("clientes")) || [];

    clientes.forEach(function (cliente, index) {

        lista.innerHTML += `
    <div class="card">

        <h3>${cliente.nome}</h3>

        <p>${cliente.email}</p>

        <p>${cliente.telefone}</p>

        <div class="botoesCard">

            <button class="btnEditar"
                onclick="editarCliente(${index})">
                Editar
            </button>

            <button class="btnExcluir"
                onclick="excluirCliente(${index})">
                Excluir
            </button>

        </div>

        </div>
`;
    });
}
function excluirCliente(index) {

    // Pegando clientes
    var clientes = JSON.parse(localStorage.getItem("clientes")) || [];

    // Remove 1 item
    clientes.splice(index, 1);

    // Salva novamente
    localStorage.setItem("clientes", JSON.stringify(clientes));

    // Recarrega página
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

    // ===== CADASTRO =====
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
function cadastrar() {

    var nome = document.getElementById("nome");

    var email = document.getElementById("email");

    var telefone = document.getElementById("telefone");

    var lista = document.getElementById("listaClientes");

    if (nome.value === "" || email.value === "" || telefone.value === "") {
        alert("Preencha todos os campos!");
        return;
    }
    lista.innerHTML +=
        "<tr>" +
        "<td>" + nome.value + "</td>" +
        "<td>" + email.value + "</td>" +
        "<td>" + telefone.value + "</td>" +
        "</tr>";

}

function mostrarTabela() {
    window.location.href = "tabela.html";
}

function voltarCadastro() {
    window.location.href = "cadastro.html";
}

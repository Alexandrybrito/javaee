/**
 * Confirmação de exclusão de um contato
 * @author Alexandry DEADFILE
 * @param id
 */

 function confirmar(id) {
	 let resposta = confirm("confirma a exclusão deste contato?")
	 if (resposta === true) {
		 window.location.href="delete?id=" + id
	 }
 }
/**
 * Validação de formulario
 * @author Alexandry DEADFILE
 */

 function validar() {
	 let nome = formContato.nome.value
	 let fone = formContato.fone.value
	 
	 if (nome ==="") {
		 alert('Para avançar preencha o campo nome')
		 formContato.nome.focus()
		 return false
	 } else if (fone ==="") {
		 alert('Para avançar preencha o campo fone')
		 formContato.fone.focus()
		 return false
	 } else {
		 document.forms["formContato"].submit()
	 }
 }
 
 
 
 
 
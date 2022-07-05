/**
 * Validaçao de formulário
 * @author: Lucas Marcuzo
 */

function validar(){
    let nome = frmContato.nome.value
    let fone = frmContato.fone.value
    let email = frmContato.email.value
    
    if(nome == ""){
        alert("Preencha o campo Nome");
        form.nome.focus();
        return false;
    }
    else if(fone == ""){
        alert("Preencha o campo Telefone");
        form.fone.focus();
        return false;
    }
    else if(email == ""){
        alert("Preencha o campo Email");
        form.email.focus();
        return false;
    }
    else{
		document.forms["frmContato"].submit();
}
}
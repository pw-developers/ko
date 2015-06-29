//Validate campos antes de Adicionar novo Usu�rio.
function checkForm(form) {
	
    re = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    if (!re.test(form.email.value) || form.email.value == "") { //Verifica se o email é válido
	    alert('Por favor, insira um endereço de e-mail válido!');
	    form.email.focus;
	    return false;
    }
    
	if (form.login.value == "") {//Verifica se existe um nome de usuário (login)
		alert("Você deve inserir um NOME DE USUÁRIO!");
		form.login.focus();
		return false;
	}
	
	re = /^\w+$/;
	if (!re.test(form.login.value)) {//Verifica se o nome de usuário não tem códigos
		alert("O NOME DE USUÁRIO deve ter apenas letras, numeros e \"underlines\"!");
		form.login.focus();
		return false;
	}
    
	if (form.senha.value != "" && form.senha.value == form.rptsenha.value) {//Verifica se a senha é maior que 6 digitos
		if (form.senha.value.length < 6) {
			alert("Sua senha deve possuir no mínimo 6 caracteres");
			form.senha.focus();
			return false;
		}
		
		if (form.senha.value == form.login.value) {//Verifica se a senha é igual ao login
			alert("Error: Sua senha deve ser diferente do seu Login!");
			form.senha.focus();
			return false;
		}
		
		re = /[a-z]/;
		if (!re.test(form.senha.value)) {//Verifica se a senha tem pelo menos uma letra
			alert("A senha deve ter pelomenos uma letra (a-z)!");
			form.senha.focus();
			return false;
		}

	} else {//Verifica se existe uma senha
		alert("Você deve definir uma senha e confirmar!");
		form.senha.focus();
		return false;
	}

	alert("Grave a sua senha em um local de segurança: " + form.senha.value);
	return true;
}

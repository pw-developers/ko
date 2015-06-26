//Validate campos antes de Adicionar novo Usu�rio.
function checkForm(form) {
	if (form.login.value == "") {
		alert("Voc� deve inserir um NOME DE USU�RIO!");
		form.login.focus();
		return false;
	}
	re = /^\w+$/;
	if (!re.test(form.login.value)) {
		alert("O NOME DE USU�RIO deve ter apenas letras, numeros e \"underlines\"!");
		form.login.focus();
		return false;
	}

	if (form.senha.value != "" && form.senha.value == form.rptsenha.value) {
		if (form.senha.value.length < 6) {
			alert("Sua senha deve possuir no m�nimo 6 caracteres");
			form.senha.focus();
			return false;
		}
		if (form.senha.value == form.login.value) {
			alert("Error: Password must be different from login!");
			form.senha.focus();
			return false;
		}
		re = /[a-z]/;
		if (!re.test(form.senha.value)) {
			alert("A senha deve ter pelomenos uma letra (a-z)!");
			form.senha.focus();
			return false;
		}

	} else {
		alert("Voc� deve definir uma senha e confirmar!");
		form.senha.focus();
		return false;
	}

	alert("Grave a sua senha em um local de seguran�a: " + form.senha.value);
	return true;
}

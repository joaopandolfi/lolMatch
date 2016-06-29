function validateRegister(){
	if (register.name.value == '') {
		alert('Por favor digite um nome.');
		return false;
	}

	if (register.nick.value == '') {
		alert('Por favor digite um Nickname.');
		return false;
	}

	if (register.email.value == '') {
		alert('Por favor digite um Email.');
		return false;
	}

	if (register.pass1.value == '') {
		alert('Por favor digite uma Senha.');
		return false;
	}

	if (register.pass2.value == '') {
		alert('Por favor confirme sua Senha.');
		return false;
	}

	if (register.agree.checked == false) {
		alert('Aceite os termos de compromisso.');
		return false;
	}

	if (!checkPass()) { alert('Senhas não conferem.'); return false; }
	return true;
}

function checkPass() {
	if (register.pass1.value == register.pass2.value) {
		return true;
	} else {
		changeColor();
		return false;
	}

}

function changeColor() {
	register.pass1.style = "background-color: red;";
	register.pass2.style = "background-color: red;";
}

function validateLogin(){
	if (login.name.value == '') {
		alert('Por favor digite um Nome.');
		return false;
	}

	if (login.pass.value == '') {
		alert('Por favor digite uma Senha.');
		return false;
	}

	return true;
}

function follow(element) {
	if (element.className == "btn btn-block btn-danger") {
		element.className = "btn btn-primary btn-block";
		element.innerHTML = "Follow";
	} else {
		element.className = "btn btn-block btn-danger";
		element.innerHTML = "Unfollow";
	}
}

function sendMessageTo(idUser,idChat){
	var chat = document.getElementById("contentMessages"+idUser);
	var msgModel = 
		"<!-- Message. Default to the left or right -->"+
	"<div class='direct-chat-msg rigth'>"+
	"<div class='direct-chat-info clearfix'>"+
	"</div><!-- /.direct-chat-info -->"+
	"<img class='direct-chat-img' src='../dist/img/img-rigth-chat.png'/><!-- /.direct-chat-img -->"+
	"<div class='direct-chat-text'>"+
		"%message%"+
	"</div><!-- /.direct-chat-text -->"+
"</div><!-- /.direct-chat-msg -->";
	
	var message = document.getElementById("msg"+idUser).value;
	
	$.getJSON("http://"+window.location.host+"/proj1/messenger?idChat="+idChat+"&from="+idUser+"&message"+message, function(result){
	      $.each(result, function(i, field){
	          msgModel = msgModel.replace(new RegExp("%message%", 'g'),message);
	          chat.innerHTML += msgModel;
	      });
	  });
}


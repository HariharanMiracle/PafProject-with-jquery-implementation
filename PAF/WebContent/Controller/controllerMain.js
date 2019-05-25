$(document).on("click", "#btnLogin", function(){
	var result = isValidFormLogin();
	if(result=="true")
	{	$("#formLogin").submit();	}
	else
	{	$("#divStsMsgLogin").html(result)	}
});

function isValidFormLogin(){
	var nameReg = /^[A-Za-z]+$/;
    
	if($('#txtUserName').val() == null)
		return "Enter Username";
	
	if($('#txtPassword').val() == null)
		return "Enter Password";
	
	if(!$('#txtUserName').val().match(nameReg))
		return "Invalid Character in Username Field";

	return "true";
}

$(document).on("click", "#btnRegister", function(){
	var result = isValidFormRegister();
	if(result=="true")
	{	$("#formRegister").submit();	}
	else
	{	$("#divStsMsgRegister").html(result)	}
});

function isValidFormRegister(){
	var nameReg = /^[A-Za-z]+$/;
	var numberReg =  /^[0-9]+$/;
    var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
    
    var name = $('#name').val();
    var pw = $('#pw').val();
    var cpw = $('#cpw').val();
    var add = $('#add').val();
    var mail = $('#mail').val();
    var cno = $('#cno').val();
    
    if((name == "") || (name == null))
		return "Enter Username";
    if((pw == "") || (pw == null))
		return "Enter Password";
    if((cpw == "") || (cpw == null))
		return "Enter Current Password";
    if((add == "") || (add == null))
		return "Enter Address";
    if((mail == "") || (mail == null))
		return "Enter Email";
    if((cno == "") || (cno == null))
		return "Enter Contact Number";
    if(!name.match(nameReg))
		return "Invalid Character in User Name Field";
    if(!cno.match(numberReg))
		return "Invalid Character in Contact Number Field";
    if(!mail.match(emailReg))
		return "Invalid Character in Email Field";
	
	return "true";
}

$(document).on("click", "#btnEdit", function(){
	$("#hidMode"),val("update")
	$("#hidID").val($(this).attr("param"));
	$("#txtItemName").val($(this).clonest("tr").find('td:eq(1)').text());
	$("#txtItemDesc").val($(this).clonest("tr").find('td:eq(2)').text());
});

$(document).on("click", "#btnRemove", function(){
	$("#hidMode"),val("remove")
	$("#hidID").val($(this).attr("param"));
	var res = confirm("Are you sure?");
	if(res == true){
		$("#formItems").submit();
	}
});
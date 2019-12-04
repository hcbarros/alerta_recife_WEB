
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
	<link href="css/bootstrap.css" rel="stylesheet">
	<link href="css/jquery-ui.css" rel="stylesheet">
	
	<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
	  
	<style>
	
	img {
	  max-width:100%;
	}

	#sortable td {
        width: 257px;
        float: left;
        border-radius: 5px;
		margin-left: 10px;
		
		background-color:rgb(220,220,220);
		
      }
	  
	  #sortable a { font-weight: bold; margin-left: 230px; }

	  #sortable b { margin-left:8px; display: inline-block; white-space: nowrap; 
		  overflow: hidden; text-overflow: ellipsis; direction: ltr;}
	  
	  #sortable div div { 
		  margin-left:8px; margin: 0 0px -2px 5px; padding: 5px; font-size: 1.0em; width: 243px;
          height: 35px; border-radius: 5px; display: inline-block; white-space: nowrap; 
		  overflow: hidden; text-overflow: ellipsis; direction: ltr;}

	
</style>


  </head>
  
  <body  id="body">
  
		<script src="js/jQuery.js"></script>
		<script src="js/jquery-ui.js"></script>
		<script src="js/popper.min.js"></script>
		<script src="js/bootstrap.js"></script>
	

	
  <div id="divs">
  
  <div style="background-color: rgb(248,248,248); height: 95px; width: 100%; position:fixed; z-index: 9;">
	 
  <button type="button" onclick='window.location = "indexLogin.xhtml"' style="width: 9.7%; height: 55%; border-radius: 10px; position:relative; top:20px; background-color: rgb(215,215,215); font-size: 108%; opacity: 0.6; left:77.4%;">Fazer Login</button>
  <button type="button" onclick='window.location = "indexCadastro.xhtml"' class="font-weight-bold" style="width: 10.8%; height: 55%; border-radius: 10px; position:relative; top:20px; background-color: rgb(109,179,77); font-size: 108%; color: white; left:77.9%;">Cadastrar-se</button>
   
  <img class="mx-auto d-block" src="logo.png" style="width: 9.6%; position:relative; top:-65px; left:-44%; filter: grayscale(1); opacity: 0.55">    
  
  </div>

	<div>
			<br><br><br><br><br><br>	
			
			<img class="mx-auto d-block" src="logo.png">  <br>
	<center><br>
			<a class="font-weight-bold" style="font-size: 240%; opacity: 0.8; line-height: 100%; word-spacing: -20%;">
				Alerta Recife é a forma mais eficiente de informar <br/> à prefeitura sobre incidentes com estruturas <br/>  de risco, deslizamento e alagamento.
			</a>	<br><br>
 
			<a style="font-size: 135%; opacity: 0.7; line-height: 140%;">
				Este sistema permite uma maior aproximação entre cidadãos que residem  <br/>
				em áreas de risco e a Prefeitura do Recife, visando a prevenção de danos<br/>
				causados por fatores naturais <br/>
				
			</a>	<br><br>
			
			<button type="button" onclick='window.location = "indexCadastro.xhtml"' class="font-weight-bold" style="width: 25%; height: 50px; border-radius: 10px;
			background-color: rgb(99,169,67); font-size: 125%; color: white; ">Cadastre-se no Alerta Recife!</button>		<br><br><br>
	
			<a onclick='window.location = "indexLogin.xhtml"' href="#" style="font-size: 135%; text-decoration: underline; color: rgb(170,170,170);">Fazer Login...</a>

	</center> 
	
	</div>		<br><br><br><br>
  

	<div class="col-mg-12 hidden-xs" style="height: 40%; width: 100%; position:absolute; background-color: rgb(20,110,160);">
 
		<a style="font-size: 130%; color:white; position: relative; margin-left: 23%; top: 30%;">
			Informe aqui as áreas de risco da cidade e solicite a estrutura necessária. <br/>
			
		</a> 
	</div>
</div>

	<div id="inicio" style="display: none; background-color: rgb(20,110,160); opacity:0.7; height: 40px; width: 100%; position:fixed; z-index: 9;">
		
	 <img class="mx-auto d-block" src="logo-blue.png" style="width: 6%; position:relative; top:20%; ">
	 <button type="button" onclick="listaUsuarios()" class="font-weight-bold" style="width: auto; height: 80%; border-radius: 5px; position:absolute; margin-top:-1.6%; background-color: rgb(70,160,210); font-size: 90%; color: white; left:70%;">Lista de usuários</button>
  
	
    <button id="botaoMenu" class="font-weight-bold" type="button" data-toggle="dropdown" style="width: auto; height: 80%; border-radius: 5px; position:absolute; margin-top:-1.6%; left:90%; background-color: rgb(70,160,210); font-size: 130%; color: white;"> + </button>
     
    <ul class="dropdown-menu">
	  <li style="background-color: rgb(228,228,228);"><a class="font-weight-bold" tabindex="-1" onclick="sair()" href="#" style="color: black;">Sair</a></li>
	  <li style="background-color: rgb(228,228,228);"><a class="font-weight-bold" tabindex="-1" onclick="listaBoards()" href="#" style="color: black;">Lista de boards</a></li>
	  <li id="rename" style="display: none; background-color: rgb(228,228,228);"><a class="font-weight-bold" tabindex="-1" onclick="renomearBoard()" href="#" style="color: black;">Renomear o board</a></li>
	  <li id="delete" style="display: none; background-color: rgb(228,228,228);"><a class="font-weight-bold" tabindex="-1" onclick="excluirBoard()" href="#" style="color: black;">Excluir o board</a></li> 
	  <li class="dropdown-submenu" style="background-color: rgb(228,228,228);">
        <a id="cadastrarBoard" class="test font-weight-bold" tabindex="-1" href="#" style="color: black;">Cadastrar um board</a>
				
        <ul id="dropdown1" class="dropdown-menu">
			<form id="corInicio">  
				<li style="background-color: rgb(228,228,228);">Selecione a cor:<input type="color" name="corCadastro" value="#ff0000"></li>
				<li style="background-color: rgb(228,228,228);"><input type="submit" value="Cadastrar"></li>
			</form>
		</ul>
	  </li>
	  <li class="dropdown-submenu2" style="background-color: rgb(228,228,228);">
        <a id="alterarCor" class="test2 font-weight-bold" tabindex="-1" href="#" style="display: none; color: black;">Alterar a cor</a>
				
        <ul id="dropdown2" class="dropdown-menu">
			<form id="corFinal">  
				<li style="background-color: rgb(228,228,228);">Selecione a cor:<input type="color" name="corAltera" value="#ff0000"></li>
				<li style="background-color: rgb(228,228,228);"><input type="submit" value="Alterar"></li>
			</form>
		</ul>
      </li>
    </ul>
	
			
  </div>    <br><br>
  
	
  		<a id="nomeBoard" class="font-weight-bold" style="padding-left:10px; font-size: 120%"></a>

		 
  		<div id="listas" class="font-weight-bold">
			
  		</div>


		  <div id="modal" class="font-weight-bold container">

					
			<div class="modal fade" id="bemVindo" role="dialog">
				<div class="modal-dialog">
					 
				  <div class="modal-content">
					
					<div class="modal-body">
						<div class="modal-body">
							<h4 id="ola" style="padding:35px 50px;"></h4>
			  			</div>
			  		<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			  		</div>
	   		 	 </div>
			  </div>
		    </div>
		 </div>
		 
		 
					<div class="modal fade" id="novoList" role="dialog">
						<div class="modal-dialog modal-sm">
							 
						  <div class="modal-content">
							<h4 style="padding:35px 50px;">Cadastrar list</h4>
							<div class="modal-body" style="padding:0px 50px;">
							  <form role="form" id="formList">
								<div class="form-group">
								  <label>Nome do list</label>
								  <input type="text" required maxlength="17" class="form-control" name="nome">
								</div>
								<button type="submit" class="btn btn-success btn-block">Cadastrar</button>
								<div data-dismiss="modal"></div>
							  </form>
							</div>
							<div class="modal-footer">
							  <button type="submit" onclick="listaLists()" class="btn btn-danger btn-default pull-left" data-dismiss="modal">Cancelar</button>
							</div>
						  </div>
						</div>
					</div> 


					<div class="modal fade" id="renameList" role="dialog">
						<div class="modal-dialog modal-sm">
							 
						  <div class="modal-content">
							<h4 style="padding:35px 50px;">Renomear list</h4>
							<div class="modal-body" style="padding:0px 50px;">
								<form role="form" id="formRenameList">
									<div class="form-group">
									  <label>Nome do list</label>
									  <input type="text" required maxlength="17" class="form-control" name="nome">
									</div>
									<button type="submit" class="btn btn-success btn-block">Cadastrar</button>
									<div data-dismiss="modal"></div>
								</form>
							</div>
							<div class="modal-footer">
							  <button type="submit" onclick="listaLists()" class="btn btn-danger btn-default pull-left" data-dismiss="modal">Cancelar</button>
							</div>
						  </div>
						</div>
					</div>
					

					<div class="modal fade" id="novoCard" role="dialog">
							<div class="modal-dialog modal-sm">
								 
							  <div class="modal-content">
								<h4 style="padding:35px 50px;">Cadastrar Card</h4>
								<div class="modal-body" style="padding:0px 50px;">
								  <form role="form" id="formCard">
									<div class="form-group">
									  <label>Nome do Card</label>
									  <input type="text" required maxlength="27" class="form-control" name="nome">
									</div>
									<div class="form-group">
									  <label>Data</label>
									  <input type="date" required class="form-control" placeholder="Ex: dd/mm/aaaa" name="data" value="">
									</div>
								 <button type="submit" class="btn btn-success btn-block">Cadastrar</button>
									<div data-dismiss="modal"></div>
								</form>
							 
								</div>
								<div class="modal-footer">
								  <button type="submit" onclick="listaLists()" class="btn btn-danger btn-default pull-left" data-dismiss="modal">Cancelar</button>
								  </div>
							  </div>
							</div>
						</div>
					

						<div class="modal fade" id="renameCard" role="dialog">
								<div class="modal-dialog modal-sm">
									 
								  <div class="modal-content">
									<h4 style="padding:35px 50px;">Renomear card</h4>
									<div class="modal-body" style="padding:0px 50px;">
										<form role="form" id="formRenameCard">
											<div class="form-group">
											  <label>Nome do Card</label>
											  <input type="text" required maxlength="27" class="form-control" name="nome">
											</div>
											<button type="submit" class="btn btn-success btn-block">Cadastrar</button>
											<div data-dismiss="modal"></div>
										</form>
									</div>
									<div class="modal-footer">
									  <button type="submit" onclick="listaLists()" class="btn btn-danger btn-default pull-left" data-dismiss="modal">Cancelar</button>
									</div>
								  </div>
								</div>
							</div>


					<div class="modal fade" id="listsCards" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								 
							  <div class="modal-content" style="width:240%; height:600px; overflow-x: scroll; margin-left:-70%; border-radius:15px;">
								
								<div id="modalLists" class="modal-body" style="height:50000%; width:50000%; padding:40px 50px; border-radius:15px;">
								  
									<a id="nomeBoardLists" class="font-weight-bold" style="padding-left:10px; font-size: 120%"></a>
									<a id="addList" onclick="novoList()" href="#" style="padding-left:30px;"></a>
									<a id="retornaListas" onclick="listaLists()" href="#" style="padding-left:30px;"></a>
									<a id="menuInicial" onclick="voltaBoard()" href="#" style="padding-left:30px;">Menu inicial</a>

										<table>
              
											<tr id="sortable" class="connectedSortable">     
											

											</tr>
										</table>
							 							 
								</div>
								
							  </div>
							</div>
						</div>
					

						<div class="modal fade" id="opcoesList" role="dialog">
								<div class="modal-dialog modal-sm">
									 
								  <div class="modal-content" style="border-radius:15px;">
									
									<div id="modalLists" class="modal-body" style="padding:40px 50px; border-radius:15px;">
									  
										<a id="nomeList" class="font-weight-bold" style="margin-left:-20%; padding-left:10px; font-size: 120%"></a>
										<br><br>
																				
										<button onclick="renomearList()" class="btn btn-success btn-block">Renomear o list</button>
										<button onclick="excluirList()" class="btn btn-success btn-block">Excluir o list</button>
										<button onclick="novoCard()" class="btn btn-success btn-block">Cadastrar um card</button><br>
										<button class="btn btn-danger btn-default pull-left" onclick="listaLists()" data-dismiss="modal">Cancelar</button>

									</div>
									
								  </div>
								</div>
							</div>
			

							<div class="modal fade" id="opcoesCard" role="dialog">
								<div class="modal-dialog">
									 
								  <div class="modal-content" style="border-radius:15px;">
									
									<div id="modalCards" class="modal-body" style="padding:40px 50px; border-radius:15px;">
									  
										<a id="nomeCard" class="font-weight-bold" style="font-size: 120%"></a> <br>
										<a id="dataCard" class="font-weight-bold" style="font-size: 120%"></a> <br>
										<a id="listCard" class="font-weight-bold" style="font-size: 120%"></a> <br>
										<table><tr id="tags"></tr></table>
										<br><br>
																				
										<button onclick="renomearCard()" class="btn btn-success btn-block">Renomear o Card</button>
										<button onclick="alterarData()" class="btn btn-success btn-block">Alterar a data</button>
										<button onclick="excluirCard()" class="btn btn-success btn-block">Excluir o card</button>
										<button onclick="adicionarTag()" class="btn btn-success btn-block">Adicionar uma tag</button>
										<button onclick="adicionarComentario()" class="btn btn-success btn-block">Adicionar um comentário</button>
										<button onclick="listaComments()" class="btn btn-success btn-block">Lista de comments</button>	<br>
										<button class="btn btn-danger btn-default pull-left" onclick="listaLists()" data-dismiss="modal">Cancelar</button>

									</div>
									
								  </div>
								</div>
							</div>
		
							
							<div class="modal fade" id="alterarData" role="dialog">
							<div class="modal-dialog modal-sm">
								 
							  <div class="modal-content">
								<h4 style="padding:35px 50px;">Alterar data</h4>
								<div class="modal-body" style="padding:0px 50px;">
								  <form role="form" id="formData">
									<div class="form-group">
									  <label>Nova data</label>
									  <input type="date" required class="form-control" placeholder="Ex: dd/mm/aaaa" name="data" value="">
									</div>
									<button type="submit" class="btn btn-success btn-block">Cadastrar</button>
										<div data-dismiss="modal"></div>
								  </form>
							    </div>
								<div class="modal-footer">
								  <button type="submit" onclick="listaLists()" class="btn btn-danger btn-default pull-left" data-dismiss="modal">Cancelar</button>
								  </div>
							  </div>
							</div>
						</div>
		

						<div class="modal fade" id="adicionarTag" role="dialog">
							<div class="modal-dialog modal-sm">
								 
							  <div class="modal-content">
								
								  <h4 style="padding:35px 50px;">Adicionar uma tag</h4>
								
								<div class="modal-body" style="padding:0px 50px;">
								  <form role="form" id="formTag">
									<div class="form-group">
									<table>
									<tr>
										<td><input type="radio" class="form-control" name="valor" checked value="1"></td><td><div style="margin-left: 5px; border-radius: 5px; width:40px;height:20px; background-color: #0000ff"></div></td>
									</tr>
									<tr>
										<td><input type="radio" class="form-control" name="valor" value="2"></td><td><div style="margin-left: 5px; border-radius: 5px; width:40px;height:20px; background-color: #00ff00"></div></td>
									</tr>
									<tr>
										<td><input type="radio" class="form-control" name="valor" value="3"></td><td><div style="margin-left: 5px; border-radius: 5px; width:40px;height:20px; background-color: #ff0000"></div></td>
									</tr>
									</table>		
									</div>
										<button type="submit" onclick="listaLists()" class="btn btn-success btn-block">Cadastrar</button>
										<div data-dismiss="modal"></div>
									
									</form>
							    </div>
								<div class="modal-footer">
								  <button type="submit" onclick="listaLists()" class="btn btn-danger btn-default pull-left" data-dismiss="modal">Cancelar</button>
								  </div>
							  </div>
							</div>
						</div>


						<div class="modal fade" id="addComment" role="dialog">
							<div class="modal-dialog">
								 
							  <div class="modal-content">
								<h4 style="padding:35px 50px;">Adicionar um comentário</h4>
								<div class="modal-body" style="padding:0px 50px;">
									<form role="form" id="formAddComment">
										<div class="form-group">
										  <label>Escreva seu comentário</label>
										  <textarea required class="form-control" maxlength="20000" rows="4" name="comentario"></textarea>
										</div>
										<button type="submit" class="btn btn-success btn-block">Cadastrar</button>
										<div data-dismiss="modal"></div>
									</form>
								</div>
								<div class="modal-footer">
								  <button type="submit" onclick="listaLists()" class="btn btn-danger btn-default pull-left" data-dismiss="modal">Cancelar</button>
								</div>
							  </div>
							</div>
						</div>

		</div>
							  

			<br><br>	
	
			
				
		
    	
 <div id="cadastro" style="display: none; width: 30%; position: relative; right: -33%;">		<br><br><br>
	<a class="font-weight-bold" style="font-size: 240%; ">Criar uma conta</a>  <br/>
	ou <a href="#" id="b5" style="font-size: 120%; text-decoration: underline;">entrar em sua conta</a>  <br><br>
	
	<form style="font-size: 130%; opacity: 0.7;" method="POST" id="cadastrar_usuario_form" enctype='application/json'>
      		<div class="form-group">
					<label>Nome</label>
					<input type="text" class="form-control" name="name" required value="" style="background-color: rgb(230,230,230); height: 50px" placeholder="Ex: Henrique Caetano">
			</div>
			<div class="form-group">
					<label>Primeiro nome</label>
					<input type="text" class="form-control" name="primeiroNome" required value="" style="background-color: rgb(230,230,230); height: 50px" placeholder="Ex: Henrique">
			</div>
			<div class="form-group">
					<label>Segundo nome</label>
                                        <input type="text" class="form-control" name="segundoNome" required value="" style="background-color: rgb(230,230,230); height: 50px" placeholder="Ex: Caetano">
			</div>
                        <div class="form-group">
					<label>Email</label>
                                        <input type="text" class="form-control" name="email" required value="" style="background-color: rgb(230,230,230); height: 50px" placeholder="Ex: hcb@a.recife.ifpe.edu.br">
			</div>
                        <div class="form-group">
					<label>Senha</label>
                                        <input type="password" class="form-control" name="senha" required value="" style="background-color: rgb(230,230,230); height: 50px">
			</div>
            
			  
			  <button id="b7" type="submit" class="btn btn-success">Cadastrar</button> <button type="reset" class="btn btn-success">Limpar</button>
	</form>
</div>

 	<div id="login" style="display: none; width: 30%; position: relative; right: -33%;">		<br><br><br>
		<a class="font-weight-bold" style="font-size: 240%; ">Fazer Login no Alerta Recife</a> <br/>
		ou <a href="#" id="b6" style="font-size: 120%; text-decoration: underline;">criar uma conta</a>  <br><br>
	
		<form style="font-size: 130%; opacity: 0.7;" method="POST" id="login_form" enctype='application/json'>
      		<div class="form-group">
					<label>Username</label>
					<input type="text" class="form-control" name="username" required value="" style="background-color: rgb(230,230,230); height: 50px" placeholder="">
			</div>
			<div class="form-group">
					<label for="exampleInputPassword1">Password</label>
					<input type="password" class="form-control" name="password" required value="" id="exampleInputPassword1" style="background-color: rgb(230,230,230); height: 50px" placeholder="Senha">
			</div>
			
			<button id="b8" type="submit" class="btn btn-success">Fazer Login</button> <button type="reset" class="btn btn-success">Limpar</button>
		</form>
	</div>
 
  </body>

		
  <script>	
  


	var j = 0;
	var lists = "";
  function listaCards() {
		  
		  var nomeList = "";
		  var id = "";
		
		  var xhttp = new XMLHttpRequest();
		   xhttp.onreadystatechange = function() {
			 if (this.readyState == 4 && this.status == 200) {
				var myObj = JSON.parse(this.responseText);

				var classe = "x";
				var i = 0;
				var contadorCards = 0;
				var cards = "";
								

				while (i < myObj.length) {	
				
					var index = arrayCards.indexOf(myObj[i].id);

				  cards += "<div id="+myObj[i].id+" onmousedown="+"recuperarCard(this.id)"+" class="+"ui-state-default"+
				  " >"+arrayCores[index]+"<a id="+myObj[i].data+" onmouseover="+"dataCard(this.id)"+" href="+"#"+" onclick="+"opcoesCard("+myObj[i].id+")"+
				  " style="+"margin-left:0px;"+">"+myObj[i].name+"</a></div>";
					
					$("#listsCards").modal();		
					
					$("#modalLists").css("background",corBoard);
					$("#nomeBoardLists").text(nomeBoard);
					document.getElementById("nomeBoardLists").style.color = cor;
					$("#retornaListas").css("display", "none");
					$("#addList").show();
					$("#addList").text("Adicionar uma lista...");
					document.getElementById("addList").style.color = cor;
					document.getElementById("menuInicial").style.color = cor;	
					
					i++;
					contadorCards++;
				} 
						
				lists += "<td id="+nomeList+" onmouseenter="+"recuperarList("+id+")"+" class="+"ui-state-default"+"><a id="+id+" onclick="+"opcoesList(this.id)"+
					" href="+"#"+">...</a><br><b>"+nomeList+"</b><div style="+"min-height:40px;"+
					" id="+id+" onmouseover="+"sort()"+" onclick="+"alterarCard("+id+")"+" >"+cards+"</div></td>";
					
				document.getElementById("sortable").innerHTML = "<br>"+lists;	
				
								
				j++;
				if (objLists.length > j) listaCards();
				else {j = 0; lists = "";}
			}
						 
		   } 
		   nomeList = objLists[j].name;
		   id = objLists[j].id;
		   xhttp.open("GET", "https://tads-trello.herokuapp.com/api/trello/cards/"+token+"/list/"+objLists[j].id, true);
		   xhttp.send();
  		}


	var k = 0;
	var arrayCards = new Array();
  function totalCards() {
		  
		  var nomeList = "";
		  var id = "";
		
		  var xhttp = new XMLHttpRequest();
		   xhttp.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
						var myObj = JSON.parse(this.responseText);
						
							var i = 0;
							while (i < myObj.length) {	
														
								arrayCards.push(myObj[i].id);	
								i++;
							} 
													
						k++;
						if (objLists.length > k) totalCards();
						else {k = 0; listaTags(arrayCards[0]);}
				}
						 
		   } 
		   xhttp.open("GET", "https://tads-trello.herokuapp.com/api/trello/cards/"+token+"/list/"+objLists[k].id, true);
		   xhttp.send();
  }
					

			function alterarCard(id) {
        var request = new XMLHttpRequest();
		   request.onreadystatechange = function() {
			 		if (this.readyState == 4 && this.status == 200) {
						var myObj = JSON.parse(this.responseText);
					
							$("#sortable").show();
							listaLists(); 
			 		}
		   }
		   		var url = "https://tads-trello.herokuapp.com/api/trello/cards/changelist";
				request.open("PATCH", url);
				request.setRequestHeader('Content-Type', 'application/json');
		   					

		  var objeto = {
			list_id: id,
			token: token,
			card_id: id_card
			}
					
			// request.send( `{ "op": "replace", "path": "/baz", "value": "boo" }`);			
			request.send(JSON.stringify(objeto));
	  }


		
		function listaComments() {
		  var request = new XMLHttpRequest();
		  request.onreadystatechange = function() {
			 if (this.readyState == 4 && this.status == 200) {
				var myObj = JSON.parse(this.responseText);
					
				var i = 0;
				var comentarios = "";
				if (myObj.length == 0) alert("Não há comentário nesse cartão!");
				while (i < myObj.length) {
					
					comentarios += "<td style="+"min-height:150px;"+" class="+
					"ui-state-default"+"><textarea style="+"min-width:252px;"+
					"min-height:145px;"+"border-radius:5px;"+">"+myObj[i].comment+"</textarea></td>";
					i++;
					$("#listsCards").modal();
					document.getElementById("sortable").innerHTML = "<br>"+comentarios;
					$('#opcoesCard').modal('hide');	
					$("#addList").css("display", "none");	
					$("#retornaListas").show();
					$("#retornaListas").text("Retornar às listas...");
					document.getElementById("retornaListas").style.color = cor;
					id_card = "";
				}
				
			 }
		  } 
		   	  			
			request.open("GET","https://tads-trello.herokuapp.com/api/trello/cards/"+token+"/"+id_card+"/comments", true);
		    request.send();
	    }


		 var addComment = document.querySelector("#formAddComment");
		 addComment.addEventListener("submit", function (e) {
          e.preventDefault();
          var formData = new FormData(addComment);
	  	  var request = new XMLHttpRequest();
		   request.onreadystatechange = function() {
			 if (this.readyState == 4 && this.status == 200) {
				var myObj = JSON.parse(this.responseText);
					
					console.dir(myObj);
					$('#addComment').modal('hide');
					$("#sortable").show();
					id_card = "";
					listaLists();
			 }
		   }
		   		var url = "https://tads-trello.herokuapp.com/api/trello/cards/addcomment";
				request.open("POST", url);
				request.setRequestHeader('Content-Type', 'application/json');
		   					

		  var objeto = {
			comment: formData.get("comentario"),
			token: token,
			card_id: id_card
			}
					
			// request.send( `{ "op": "replace", "path": "/baz", "value": "boo" }`);			
			request.send(JSON.stringify(objeto));
	  });  


		function voltaBoard() {

			$('#listsCards').modal('hide');
		}

		function adicionarComentario() {

			$('#opcoesCard').modal('hide');
			$('#addComment').modal();
		}

		function adicionarTag() {

			$('#opcoesCard').modal('hide');
			$('#adicionarTag').modal();
		}  	
		

		var objTag = "";
		var arrayCores = new Array();		
		function listaTags(id_card) {
		  var request = new XMLHttpRequest();
		  request.onreadystatechange = function() {
			 if (this.readyState == 4 && this.status == 200) {
				var myObj = JSON.parse(this.responseText);
					
				var td = "";
				var cores = "";
				for (var i = 0; i < myObj.length; i++) {
								
					td += "<td style="+"border-radius:5px;"+"width:40px;"+"height:20px;"+
					"background-color:"+myObj[i].color+";"+"><td style="+"width:5px"+"></td></td>";

					cores += "<td style="+"border-radius:5px;"+"width:20px;"+"height:5px;"+
					"background-color:"+myObj[i].color+";"+"></td>";
				}
				if (minhaTag == true) {
							minhaTag = false;
							document.getElementById("tags").innerHTML = td;
							return;
				}
					cores = "<table><tr>"+cores+"</tr></table>";
					arrayCores.push(cores);
					if (arrayCards.indexOf(id_card) < arrayCards.length - 1)
						listaTags(arrayCards[arrayCards.indexOf(id_card)+1]);
				  else listaCards();
			 }
		 } 
		   	  			
			request.open("GET","https://tads-trello.herokuapp.com/api/trello/cards/"+token+"/"+id_card+"/tags", true);
		    request.send();
	    }

		
		 var objTag = "";
		 var addTag = document.querySelector("#formTag");
		 addTag.addEventListener("submit", function (e) {
          e.preventDefault();
          var formData = new FormData(addTag);
	  	  var request = new XMLHttpRequest();
		   request.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					var myObj = JSON.parse(this.responseText);
																																			
						$("#sortable").show();
						$('#adicionarTag').modal('hide');
				}
				$('#adicionarTag').modal('hide');
		   }
		   		var url = " https://tads-trello.herokuapp.com/api/trello/cards/addtag";
				request.open("POST", url);
				request.setRequestHeader('Content-Type', 'application/json');
		   					

		  var objeto = {
			tag_id: formData.get("valor"),
			token: token,
			card_id: id_card
			}
					
			// request.send( `{ "op": "replace", "path": "/baz", "value": "boo" }`);			
			request.send(JSON.stringify(objeto));
	  });


		function excluirCard() {
		  var request = new XMLHttpRequest();
		  request.onreadystatechange = function() {
			 if (this.readyState == 4 && this.status == 200) {
				var myObj = JSON.parse(this.responseText);

					id_card = "";
					listaLists();
				}
		   } 
		   var url = "https://tads-trello.herokuapp.com/api/trello/cards/delete";
			request.open("DELETE", url);
			request.setRequestHeader('Content-Type', 'application/json');
		   
		    $('#opcoesCard').modal('hide');
			          
		  var objeto = {
						
			card_id: id_card,
			token: token
			}
			
			// request.send( `{ "op": "replace", "path": "/baz", "value": "boo" }`);			
			request.send(JSON.stringify(objeto));
	    }



	   var novaData = document.querySelector("#formData");
  		novaData.addEventListener("submit", function (e) {
          e.preventDefault();
          var formData = new FormData(novaData);
	  	  var request = new XMLHttpRequest();
		   request.onreadystatechange = function() {
			 if (this.readyState == 4 && this.status == 200) {
				var myObj = JSON.parse(this.responseText);
					
					$("#sortable").show();
					$('#alterarData').modal('hide');
					listaLists();
			 }
		   }
		   		
				var url = "https://tads-trello.herokuapp.com/api/trello/cards/newdata";
				request.open("PATCH", url);
				request.setRequestHeader('Content-Type', 'application/json');
		   
		  var objeto = {
			data: formData.get("data"),
			token: token,
			card_id: id_card
			}
					
			// request.send( `{ "op": "replace", "path": "/baz", "value": "boo" }`);			
			request.send(JSON.stringify(objeto));
	  });



		function alterarData() {
			
			$('#opcoesCard').modal('hide');
			$('#alterarData').modal();
		}


		var renameCard = document.querySelector("#formRenameCard");
		renameCard.addEventListener("submit", function (e) {
          e.preventDefault();
          var formData = new FormData(renameCard);
		  var request = new XMLHttpRequest();
		  request.onreadystatechange = function() {
			 if (this.readyState == 4 && this.status == 200) {
				var myObj = JSON.parse(this.responseText);

					$('#renameCard').modal('hide');
					id_card = "";
					listaLists();
				}
		   } 
		   var url = "https://tads-trello.herokuapp.com/api/trello/cards/rename";
			request.open("PATCH", url);
			request.setRequestHeader('Content-Type', 'application/json');
		   			          
		  var objeto = {
						
			card_id: id_card,
			name: formData.get("nome"),	
			token: token
			}
			
			// request.send( `{ "op": "replace", "path": "/baz", "value": "boo" }`);			
			request.send(JSON.stringify(objeto));
	    });
		

		function renomearCard() {
			
			$('#opcoesCard').modal('hide');
			$("#listsCards").modal('hide');
			$('#renameCard').modal();
		}


		var id_card = "";
	  var nome_card = "";
		var minhaTag = false;
	  function recuperarCard(card_id) {
		  var xhttp = new XMLHttpRequest();
		   xhttp.onreadystatechange = function() {
			 if (this.readyState == 4 && this.status == 200) {
				var myObj = JSON.parse(this.responseText);
							
					id_card = myObj.id;
					nome_card = myObj.name;
					document.getElementById("nomeCard").innerHTML = nome_card;
					minhaTag = true;
					listaTags(myObj.id);
				}
			}
		   		xhttp.open("GET", "https://tads-trello.herokuapp.com/api/trello/cards/"+token+"/"+card_id, true);
				xhttp.send();
	  }
  
	  

	  function dataCard(data) {
						
			var d = new Date(data);
			d.setHours(d.getHours()+3);
			$("#dataCard").text("Data: "+d.toLocaleDateString());
	  }

	  function opcoesCard(id) {
			recuperarCard(id);
			$("#opcoesCard").modal();
	  }
		

	function sort() {
		$(function() {
   					
		   $("td > div").sortable({
				connectWith: "td > div"
				}).disableSelection();
		});
	}


  var cadastrarCard = document.querySelector("#formCard");
  		cadastrarCard.addEventListener("submit", function (e) {
          e.preventDefault();
          var formData = new FormData(cadastrarCard);
	  	  var request = new XMLHttpRequest();
		   request.onreadystatechange = function() {
			 if (this.readyState == 4 && this.status == 200) {
				var myObj = JSON.parse(this.responseText);
					
					$("#sortable").show();
					$('#novoCard').modal('hide');
					listaLists();
			 }
		   }
		   		
				var url = "https://tads-trello.herokuapp.com/api/trello/cards/new";
				request.open("POST", url);
				request.setRequestHeader('Content-Type', 'application/json');
		   
		  var objeto = {
			name: formData.get("nome"),
			data: formData.get("data"),
			token: token,
			list_id: id_list
			}
					
			// request.send( `{ "op": "replace", "path": "/baz", "value": "boo" }`);			
			request.send(JSON.stringify(objeto));
	  });

	
	var objLists = "";
	function listaLists() {
		  var xhttp = new XMLHttpRequest();
		   xhttp.onreadystatechange = function() {
			 if (this.readyState == 4 && this.status == 200) {
				var myObj = JSON.parse(this.responseText);
				var x = "";
				var i = 0;
				var contadorLists = 0;
				objLists = myObj;

				while (i < myObj.length) {	
										
					x += "<td class="+"ui-state-default"+"><a id="+myObj[i].id+" onclick="+"opcoesList(this.id)"+
					" href="+"#"+">...</a><br><b>"+myObj[i].name+"</b></td>";

					$("#listsCards").modal();		
					document.getElementById("sortable").innerHTML = "<br>"+x;
					$("#modalLists").css("background",corBoard);
					$("#nomeBoardLists").text(nomeBoard);
					document.getElementById("nomeBoardLists").style.color = cor;
					$("#addList").text("Adicionar uma lista...");
					document.getElementById("addList").style.color = cor;
					document.getElementById("menuInicial").style.color = cor;

					i++;
					contadorLists++;
				} 
				if (contadorLists == 0) $("#sortable").css("display", "none");
				else $("#sortable").show();

				if (myObj.length == 0)  {				 
					
					document.getElementById("listas").innerHTML = "<br><a href="+"#"+
					" onclick="+"novoList()"+" style="+"color:"+cor+";"+">Adicionar uma lista...</a>";				
				}
				else {
					document.getElementById("listas").innerHTML = "<br><a href="+"#"+
					" onclick="+"listaLists()"+" style="+"color:"+cor+";"+">Exibir listas</a>";
				}	
								
					arrayCards.length = 0;
					arrayCores.length = 0;
					totalCards();
			}
						 
		   } 
		   xhttp.open("GET", "https://tads-trello.herokuapp.com/api/trello/lists/"+token+"/board/"+id_board, true);
		   xhttp.send();
	  }


	  function excluirList() {
		  var request = new XMLHttpRequest();
		  request.onreadystatechange = function() {
			 if (this.readyState == 4 && this.status == 200) {
				var myObj = JSON.parse(this.responseText);

					listaLists();
				}
		   } 
		   var url = "https://tads-trello.herokuapp.com/api/trello/lists/delete";
			request.open("DELETE", url);
			request.setRequestHeader('Content-Type', 'application/json');
		   
		    $('#opcoesList').modal('hide');
			          
		  var objeto = {
						
			list_id: id_list,
			token: token
			}
			
			// request.send( `{ "op": "replace", "path": "/baz", "value": "boo" }`);			
			request.send(JSON.stringify(objeto));
	    }


	  var renameList = document.querySelector("#formRenameList");
	  renameList.addEventListener("submit", function (e) {
          e.preventDefault();
          var formData = new FormData(renameList);
		  var request = new XMLHttpRequest();
		  request.onreadystatechange = function() {
			 if (this.readyState == 4 && this.status == 200) {
				var myObj = JSON.parse(this.responseText);

					$("#renameList").modal('hide');
					listaLists();
				}
		   } 
		   var url = "https://tads-trello.herokuapp.com/api/trello/lists/rename";
			request.open("PATCH", url);
			request.setRequestHeader('Content-Type', 'application/json');


		  var objeto = {
						
			list_id: id_list,
			name: formData.get("nome"),	
			token: token
			}
			
			// request.send( `{ "op": "replace", "path": "/baz", "value": "boo" }`);			
			request.send(JSON.stringify(objeto));
	  });


		function renomearList() {
			
			$('#opcoesList').modal('hide');
			$("#listsCards").modal('hide');
			$("#renameList").modal();
		}


	  var id_list = "";
	  var nome_list = "";
	  function recuperarList(list_id) {
		  var xhttp = new XMLHttpRequest();
		   xhttp.onreadystatechange = function() {
			 if (this.readyState == 4 && this.status == 200) {
				var myObj = JSON.parse(this.responseText);
					
					id_list = myObj.id;
					nome_list = myObj.name;
					$("#listCard").text("List: "+nome_list);
					document.getElementById("nomeList").innerHTML = nome_list;
				}
						 
		   } 
		   		xhttp.open("GET", "https://tads-trello.herokuapp.com/api/trello/lists/"+token+"/"+list_id, true);
				xhttp.send();
	  }

	  function novoCard() {
			
		$("#novoCard").modal();
		$("#opcoesList").modal('hide');
		$("#listsCards").modal('hide');
	  }

	  function opcoesList(id) {
	
		recuperarList(id);
		$("#opcoesList").modal();
	  }

	  function novoList() {
	
		$('#listsCards').modal('hide');
		$("#novoList").modal();
	  }

	  
	  var cadastrarList = document.querySelector("#formList");
	  cadastrarList.addEventListener("submit", function (e) {
          e.preventDefault();
          var formData = new FormData(cadastrarList);
	  	  var request = new XMLHttpRequest();
		   request.onreadystatechange = function() {
			 if (this.readyState == 4 && this.status == 200) {
				var myObj = JSON.parse(this.responseText);
					
					$("#sortable").show();
					listaLists();
					$('#novoList').modal('hide');
			 }
		   }
		   		
				var url = "https://tads-trello.herokuapp.com/api/trello/lists/new";
				request.open("POST", url);
				request.setRequestHeader('Content-Type', 'application/json');
		   
		  var objeto = {
			name: formData.get("nome"),
			token: token,
			board_id: id_board
			}
					
			// request.send( `{ "op": "replace", "path": "/baz", "value": "boo" }`);			
			request.send(JSON.stringify(objeto));
	  });
	  
	  

	  function excluirBoard() {
		  var request = new XMLHttpRequest();
		   request.onreadystatechange = function() {
			 if (this.readyState == 4 && this.status == 200) {
					
				var myObj = JSON.parse(this.responseText);
					listaBoards();
			 }
		   }
				var url = "https://tads-trello.herokuapp.com/api/trello/boards/delete";
				request.open("DELETE", url);
								
				request.setRequestHeader('Content-Type', 'application/json');
				  
          var objeto = {
			
			board_id: id_board,
			token: token
			}
						
			// request.send( `{ "op": "replace", "path": "/baz", "value": "boo" }`);			
			request.send(JSON.stringify(objeto));
	    }


		var alterarCor = document.querySelector("#corFinal");
		alterarCor.addEventListener("submit", function (e) {
          e.preventDefault();
          var formData = new FormData(alterarCor);
		  var request = new XMLHttpRequest();
		   request.onreadystatechange = function() {
			 if (this.readyState == 4 && this.status == 200) {
				var myObj = JSON.parse(this.responseText);
				
				recuperarBoard(id_board); 	
			 }
		   }
				var url = "https://tads-trello.herokuapp.com/api/trello/boards/newcolor";
				request.open("PATCH", url);
								
				request.setRequestHeader('Content-Type', 'application/json');
				  
          var objeto = {
						
			board_id: id_board,
			color: formData.get("corAltera"),	
			token: token
			}
			
			// request.send( `{ "op": "replace", "path": "/baz", "value": "boo" }`);			
			request.send(JSON.stringify(objeto));
	    });

  
		function renomearBoard() {
		  var request = new XMLHttpRequest();
		   request.onreadystatechange = function() {
			 if (this.readyState == 4 && this.status == 200) {
				var myObj = JSON.parse(this.responseText);
				
				recuperarBoard(id_board);
			 }
		   }
				var url = "https://tads-trello.herokuapp.com/api/trello/boards/rename";
				request.open("PATCH", url);
								
				request.setRequestHeader('Content-Type', 'application/json');
				    
			var nome = prompt("Digite um novo nome para o board: ");
		  
          var objeto = {
			
			board_id: id_board,
			name: nome,
			token: token
			}
			
			// request.send( `{ "op": "replace", "path": "/baz", "value": "boo" }`);			
			if (nome != null) request.send(JSON.stringify(objeto));
	  }
					
		  
	  var corBoard = "";	
	  var nomeBoard = "";	
	  var id_board = "";
		function recuperarBoard(id) {
		  var xhttp = new XMLHttpRequest();
		   xhttp.onreadystatechange = function() {
			 if (this.readyState == 4 && this.status == 200) {
					var myObj = JSON.parse(this.responseText);
					
					for (var i = 0; i < myObj.length; i++) 	{
						
						nomeBoard = myObj[i].name;;
						corBoard = myObj[i].color;
						if (corBoard > "#888") cor = "black";
						else cor = "white";
						id_board = myObj[i].id;
						
						$("#listas,#nomeBoard,#rename,#delete,#alterarCor").show();
							$("#body").css("background",corBoard);
							$("#nomeBoard").text(nomeBoard);
							document.getElementById("nomeBoard").style.color = cor;
							listaLists();
					}
			 }
	       }
		   		xhttp.open("GET", "https://tads-trello.herokuapp.com/api/trello/boards/"+token+"/"+id, true);
				xhttp.send();
	    }


		var cor = "";
	  function listaBoards() {
		  var xhttp = new XMLHttpRequest();
		   xhttp.onreadystatechange = function() {
			 if (this.readyState == 4 && this.status == 200) {
								
				$('#listsCards').modal('hide');
				$('#body').css("background", "linear-gradient(to right, rgb(30, 106, 111), rgb(100, 176, 181)");
				$("#listas").show();
				$("#nomeBoard,#rename,#delete,#alterarCor").css("display", "none");
				
				var myObj = JSON.parse(this.responseText);
				var contadorBoards = 0;
				var x = "";
				for (var i = 0; i < myObj.length; i++) {
					
					if (i%4 == 0) x = "<tr>"+x+"</tr><tr style="+"height:10px;"+"></tr>";
					if (myObj[i].color > "#888") cor = "black";
					else cor = "white";
					x += "<td class="+"font-weight-bold"+" id="+myObj[i].id+" onclick="+"recuperarBoard(this.id)"+" style="+
					"height:100px;"+"width:170px;"+"border-radius:10px;"+"color:"+cor+";"+"font-size:120%;"+"background-color:"+
					myObj[i].color+";"+"><center>"+myObj[i].name+"</center></td><td style="+"width:10px;"+"></td>";
				
					document.getElementById("listas").innerHTML = "<br><br><br><br><center><table>"+x+"</table></center>";
					contadorBoards++;
				}
					$("#rename,#delete,#alterarCor").css("display", "none");
					if (contadorBoards == 0) $("#listas").css("display", "none");
			 }
		   }
				xhttp.open("GET", "https://tads-trello.herokuapp.com/api/trello/boards/"+token, true);
				xhttp.send();
	  }

  
	  var cadastrarBoard = document.querySelector("#corInicio");
	  cadastrarBoard.addEventListener("submit", function (e) {
          e.preventDefault();
          var formData = new FormData(cadastrarBoard);
		  var request = new XMLHttpRequest();
		   request.onreadystatechange = function() {
			 if (this.readyState == 4 && this.status == 200) {
				var myObj = JSON.parse(this.responseText);
				
				recuperarBoard(myObj.id);
			 }
		   }
		   var url = "https://tads-trello.herokuapp.com/api/trello/boards/new";
          request.open("POST", url);
          request.setRequestHeader('Content-Type', 'application/json');

		   var nome = "";
		   
            nome = prompt ("Digite o nome do board: ");
        	
          var objeto = {
			
			name: nome,
			color: formData.get("corCadastro"),
			token: token
			}

			if (nome != null)
			// request.send( `{name”:”${name}”,”username”:...........
			request.send(JSON.stringify(objeto));
      });


	  function sair() {

		  window.location = "index.html";
	  }


	  var formCadastrarUsuario = document.querySelector("#cadastrar_usuario_form");
      formCadastrarUsuario.addEventListener("submit", function (e) {
          e.preventDefault();
          var formData = new FormData(formCadastrarUsuario);
          var request = new XMLHttpRequest();
          request.onreadystatechange = function () {
              if (this.readyState === 4 && this.status === 200) {
                   var text = this.responseText;
                   var name = JSON.parse(text);
                   alert(name.nome);
              }
          };
                      
            var valor = {
                 primeiroNome: encodeURIComponent(formData.get("primeiroNome")),
                 segundoNome: encodeURIComponent(formData.get("segundoNome")),
                 email: encodeURIComponent(formData.get("email")),
                 senha: encodeURIComponent(formData.get("senha"))
            };
    
            var json = JSON.stringify(valor);
            var obj = "objeto=" + encodeURIComponent(json);      
            xhr.open("POST", "CadastrarUsuario", true);
            xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xhr.send(obj);
                 
      });
	  

	  var formLogin = document.querySelector("#login_form");
		var token = "";
		   formLogin.addEventListener("submit", function (e) {
            e.preventDefault();
            var formData = new FormData(formLogin);
            var request = new XMLHttpRequest();
            request.onreadystatechange = function () {
                if (this.readyState === 4 && this.status === 200) {
						
									var myObj = JSON.parse(this.responseText);
									localStorage.setItem("token", myObj.token);
									token = localStorage.getItem("token");
								}
								
								if (this.readyState === 4 && token == "") {alert("Dados inválidos!"); $("#login").show();}
						}

            var url = "https://tads-trello.herokuapp.com/api/trello/login";
            request.open("POST", url);
            request.setRequestHeader('Content-Type', 'application/json');
                       			
			var objeto = {

			username: formData.get("username"),
			password: formData.get("password")
			}

			// request.send( `{name”:”${name}”,”username”:...........
			request.send(JSON.stringify(objeto));
		});
		
		
		function listaUsuarios() {
			var xhttp = new XMLHttpRequest();
			xhttp.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {

					$("#listas").show();
					$("#rename,#divList,#delete,#alterarCor,#nomeBoard").css("display", "none");
					$('#body').css("background", "linear-gradient(to right, rgb(30, 106, 111), rgb(100, 176, 181)");
					
					var myObj = JSON.parse(this.responseText);
					var x = "";
					for (var i = 0; i < myObj.length; i++) {
						x += "Nome: "+myObj[i].name+"       Username: "+myObj[i].username+"      Token: "+myObj[i].token+"<br><br>";
					}
					document.getElementById("listas").innerHTML = "<div style="+"color:white;"+"position:absolute;"+"left:10%;"+
					"><br><br><br>LISTA DE USUÁRIOS<br><br><br>"+x+"</div>";
					
					$("#rename,#delete,#alterarCor").css("display", "none");
				}
			}
				xhttp.open("GET", "https://tads-trello.herokuapp.com/api/trello/users/", true);
				xhttp.send();
		}
		
		var usuario = "";
		function recuperarUsuario() {
			var xhttp = new XMLHttpRequest();
			xhttp.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					var myObj = JSON.parse(this.responseText);
					localStorage.setItem("usuario", myObj.id);
					usuario = localStorage.getItem("usuario");
				
					$("#bemVindo").modal();
					$("#ola").text("Bem vindo ao Trello, "+myObj.name+"!");
				}
			}
				xhttp.open("GET", "https://tads-trello.herokuapp.com/api/trello/users/"+token, true);
				xhttp.send();
		}
		
		$(function() {
   					
			        
      $( ".connectedSortable" ).sortable({
				connectWith: ".connectedSortable"
      }).disableSelection();

			$("#b1,#b2,#b5").click(function() {
				$("#login").show();
				$("#divs,#cadastro").css("display", "none");
			});
			
			$("#b3,#b4,#b6").click(function() {
				$("#cadastro").show();
				$("#divs,#login").css("display", "none");
			});
			
			$("#b7").click(function() {
				$("#login").show();
				$("#cadastro").css("display", "none");
			});
			
			$("#b8").click(function() {
				if (token != "") {
				$("#inicio").show();
				listaBoards();
				$("#login").css("display", "none");
				recuperarUsuario();
				}
			});
					
			$('.dropdown-submenu a.test').on("click", function(e){
    				$(this).next('ul').toggle();
    				e.stopPropagation();
    				e.preventDefault();
  			});

			$('.dropdown-submenu2 a.test2').on("click", function(e){
    				$(this).next('ul').toggle();
    				e.stopPropagation();
    				e.preventDefault();
  			});

			$("#botaoMenu").click(function() {
					
				$("#dropdown1,#dropdown2").css("display", "none");
			});

			$("#cadastrarBoard").click(function() {
					
				$("#dropdown2").css("display", "none");
			});
			
			$("#alterarCor").click(function() {
					
					$("#dropdown1").css("display", "none");
			});
						
		});
			
  </script>
	
</html>

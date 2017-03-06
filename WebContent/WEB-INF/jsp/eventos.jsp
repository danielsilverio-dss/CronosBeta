<%@ include file="../../snippets/imports.jsp" %>

<form method="post" action="Servlet?origem=eventos.jsp">
	<fieldset>
		<legend>Novo Evento</legend>
		
		<div>
		
			<label>Nome</label>
			<input type="text" name="nome"/>
		
		</div>
		<div>
		
			<label>Descricao</label>
			<input type="text" name="descricao"/>
		
		</div>
		<div>
		
			<label>Capitulo</label>
			<select name="capitulo">
				<c:forEach var="capitulo" items="${capitulos}">
					<option value="${capitulo.codigo}">${capitulo.nome}</option>
				</c:forEach>
			</select>
		
		</div>
		<div>
		
			<label>Personagens</label>
			<div id="containerDeSelects">
				<select name="personagem0" id="pers">
					<c:forEach var="personagem" items="${personagens}">
						<option value="${personagem.codigo}">${personagem.nome}</option>
					</c:forEach>
				</select>
			</div>
			
		
		</div>
		<div>
		
		
		
			<input type="text" name="contador" value="0" id="hid"/>
			
			
			
		</div>
		<div>
		
		
			<input type="submit" value="Enviar" class="enviar">
		
		
		</div>		
		
	</fieldset>

</form>


<p>${msg}</p>

<div>
		
		
		
			<button onclick="criaDropBoxPersonagem()" id="add">add</button>
		
		
		
</div>

<script>

	var contadorDeSelects = 0;

	function criaDropBoxPersonagem(){
		
		contadorDeSelects = contadorDeSelects + 1;
		
		var container = document.getElementById("containerDeSelects");

		var select1 = document.getElementById("pers");
		var select2 = document.createElement("select");
		
		select2.innerHTML = select2.innerHTML + select1.innerHTML;
		
		
		
		var valorSelect = "personagem" + contadorDeSelects;
		select2.setAttribute("name", valorSelect);
		
		container.appendChild(select2);

		var contador = document.getElementById("hid");
		contador.value = contadorDeSelects;
		
		
		
	}
	
	/*

	function criaDropBoxPersonagem(){
		
		var container = document.getElementById("containerDeSelects");
		
		var div = document.createElement("div");
		var select = document.createElement("select");
		
		var foreach = document.createElement("c:forEach");
		var atrVar = document.createAttribute("var");
		atrVar.value = "personagem";
		var atrItems = document.createAttribute("items");
		atrItems.value = "${personagens}";
		foreach.setAttributeNode(atrVar);
		foreach.setAttributeNode(atrItems);
		
		var opt = document.createElement("option");
		var texto = document.createTextNode("${personagem.nome}"); 
		
		container.appendChild(div);
		div.appendChild(select);
		select.appendChild(foreach);
		foreach.appendChild(opt);
		opt.appendChild(texto);
		
	}
		
	*/
</script>


<%@ include file="../../snippets/imports.jsp" %>

<form method="post" action="Servlet?origem=personagem.jsp">
	<fieldset>
		<legend>Personagem</legend>
		
		<div>
		
		
			<label>Nome*</label>
			<input type="text" name="nome" required/>
		
		
		</div>
		<div>
		
		
			<label>Descricao</label>
			<input type="text" name="descricao"/>
		
		
		</div>
		<div>
		
		
			<input class="enviar" type="submit" value="Enviar">
		
		
		</div>
		<div>
		
			<p>${msg}</p>
		
		</div>
		
	</fieldset>
</form>
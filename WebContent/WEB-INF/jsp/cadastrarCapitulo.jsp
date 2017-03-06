<%@ include file="../../snippets/imports.jsp" %>

<form method="post" action="Servlet?origem=cadastrarCapitulo.jsp">

	<fieldset>
	<legend>Capítulo</legend>
		<div>
		
			<label>Número do Capítulo</label>
			<input type="number" name="numero">
			
		</div>
		<div>
		
			<label>Nome</label>
			<input type="text" name="nome">
			
		</div>
		<div>
		
			<label>Descrição</label>
			<input type="text" name="descricao">
			
		</div>
		<div>
		
			<input type="submit" name="Enviar" class="enviar">
			
		</div>
		<div>
		
			<p>${msg}</p>
		
		</div>
	
	</fieldset>

</form>
<%@ include file="../../snippets/imports.jsp" %>

<form method="post" action="Servlet?origem=cadastrarCapitulo.jsp">

	<fieldset>
	<legend>Cap�tulo</legend>
		<div>
		
			<label>N�mero do Cap�tulo</label>
			<input type="number" name="numero">
			
		</div>
		<div>
		
			<label>Nome</label>
			<input type="text" name="nome">
			
		</div>
		<div>
		
			<label>Descri��o</label>
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
<%@ include file="../../snippets/imports.jsp" %>
	<c:forEach var="capitulo" items="${listaCapitulos}">	
		<section>
			<p class="capDivision">${capitulo.nome}</p>
				<c:forEach var="evento" items="${capitulo.eventos}">
					<div class="containerLinhas">
						<div class="majorCell">
							<table>
								<tr>
									<td class="tituloEvento">${evento.nome}</td>
									<td class="botaoX"><a href="Servlet?page=none&funcao=excluir&codigo=${evento.codigo}">X</a></td>
								</tr>
							</table>
							<hr/>
							
							<div class="conteudo">
								<span>${evento.descricao}</span>
							</div>
							
						</div>
							<c:forEach var="personagem" items="${evento.envolvidos}">
								<span class="minorCell">${personagem.nome}</span>
							</c:forEach>
					</div>
					<br/>
				</c:forEach>			
		</section>
		
	
	</c:forEach>

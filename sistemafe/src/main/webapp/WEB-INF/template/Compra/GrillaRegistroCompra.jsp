<script type="text/javascript">
	//Verifica que exta una columna de la tabla con el valor pasado como 2do parámetro  
	function contiene(val) {
		//Obtiene la tabla dado su id
		var tabla = document.getElementById("#lstGrillaCompra");
		//obtiene todas las celdas de la tabla
		var tds = document.getElementsByTagName("td");
		//Crea y asigna la variable que se retornará
		var resultado = false;
		//recorre las celdas de la tabla
		for (var i = 0; i < tds.length; i++) {
			//Si encuentra una con el atributo value y su valor es igual al que se esta buscando....
			if (getAttr(tds[i], "value") == val) {
				//Asigna a verdadero la variable a retornar
				resultado = true;
				//Sale del ciclo
				break;
			}
		}
		return resultado;
	}

	//Función que devuelve el valor de un atributo en un elemento HTML si el atributo existe, sino devolvera null
	function getAttr(elemento, nombre) {
		//Inicializo a null la variable a retornar
		var resultado = null;
		//Recorro los atributos del elemento pasado por parámetro
		for (var j = 0; j < elemento.attributes.length; j++) {
			//Si el nombre del atributo coincide con el ke estamos buscando...
			if (elemento.attributes[j].name === nombre) {
				//Asigno su valor a la variable que retornaré
				resultado = elemento.attributes[j].value;
				//Salgo del ciclo porque ya encontré lo que buscaba
				break;
			}
		}
		return resultado;
	}
</script>
<div class="x_panel">
	<div class="x_content">
		<div class="container_fluid">

			<div class="table-responsive">
				<table id="lstGrillaCompra" name="lstGrillaCompra"
					class="table table-striped table-bordered nowrap col-md-12 col-sm-12 col-xs-12"
					cellspacing="0" width="100%">
					<thead>
						<tr>
							<th>Acciones</th>
							<th>Item</th>
							<th>Clase Sunat</th>
							<th>Codigo comercial</th>
							<th>Concepto</th>
							<th>Unidad de Medida</th>
							<th>Cantidad</th>
							<th>V. unitaria</th>
							<th>Valor compra</th>
							<th>ISC</th>
							<th>ISC Total</th>
							<th>IGV unitario</th>
<!-- 							<th>IGV</th> -->
							<th>Precio unitario</th>
							<th>Base imponible</th>
							<th>IGV total</th>
							<th>Total bruto</th>
							<th>Otros tributos y Cargos</th>
							<th>Total neto</th>
							<th>Indicador Afecto</th>
							<th>Tipo cambio</th>
							<th>Observacion</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
<!-- </div> -->
<!-- </div> -->

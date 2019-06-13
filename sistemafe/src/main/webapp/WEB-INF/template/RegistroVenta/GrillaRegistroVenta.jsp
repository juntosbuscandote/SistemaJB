<style type="text/css">
.modal-footer {
	text-align: center;
}

label.error {
	display: block;
	margin-top: 5px;
	margin-bottom: 10px;
	color: #d33535;
	font-size: 10px;
}
.ui-menu-item{
background-color:white;
color: black;
padding: 10px 0px 0px 10px;
text-decoration: none;
width: 450px;
height: 30px;
font-family: fantasy;
font-size :10px;
overflow-y:20px; 
}

.ui-widget-content{
padding:10px;
margin: 10px;
height: 200px; 
width: 250px;  
overflow-y: auto;  
list-style: none;
}
</style>
<script type="text/javascript">
	//Verifica que exta una columna de la tabla con el valor pasado como 2do parámetro  
	function contiene(val) {
		//Obtiene la tabla dado su id
		var tabla = document.getElementById("#lstProductoVenta");
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

<div class="x_panel" id="grillaDetalleFactura">
	<div class="x_content">
		<div class="container_fluid">
			<div class="row">
				<div class="form-group">
					<div class="col-md-6 col-sm-6 col-xs-12">
						<button type="button" class="btn btn-primary" data-toggle="modal"
							id="AgrProducto">+ Producto</button>
						<button type="button" class="btn btn-primary" data-toggle="modal"
							id="AgrServicio">+ Servicio</button>
					</div>
				</div>
			</div>
			<div class="table-responsive">
				<table id="lstProductoVenta" name="lstProductoVenta"
					class="table table-striped table-bordered nowrap col-md-12 col-sm-12 col-xs-12"
					cellspacing="0" width="100%">
					<thead>
						<tr>
							<th><input type="checkbox" id="check-all" class="flat"></th>
							<th>ACCIONES</th>
							<th>NUMERO</th>
							<th>CLASE SUNAT</th>
							<th>CODIGO PRESENTACION</th>
							<th>CODIGO COMERCIAL</th>
							<th>CONCEPTO</th>
							<th>UNIDAD MEDIDA</th>
							<th>CANTIDAD</th>
							<!-- 								<th>INCLUYE IGV</th> -->
							<th>V. VENTA UNITARIA</th>
							<th>IGV UNITARIO</th>
							<th>PRECIO UNITARIO</th>
							<th>VALOR VENTA</th>
							<th>IGV</th>
							<th>PRECIO DE VENTA</th>
							<th>% DSCTO. UNIT.</th>
							<th>IMP. DSCTO TOTAL</th>
							<th>V. VTA. TOTAL CON DSCTO</th>
							<th>IGV TOTAL CON DSCTO</th>
							<th>PRECIO VENTA CON DSCTO</th>
							<th>BASE IMPONIBLE</th>
							<th>IGV TOTAL</th>
							<th>TOTAL BRUTO</th>
							<th>TOTAL NETO</th>
							<th>INDICADOR AFECTO</th>
							<th>T. DE INDICADOR AFECTO</th>
							<th>T. MONEDA ORIGEN</th>
							<th>T. MONEDA DESTINO</th>
							<th>TIPO CAMBIO</th>
							<!-- 								<th>CONVERSION</th> -->
							<th>TRANSFERENCIA GRATUITA</th>
							<th>OBSERVACION</th>
							<th>TIPO</th>
							<th>CODIGO ALMACEN</th>
							<th>CODIGO ALMACEN</th>
							<th>CODIGO ALMACEN</th>
							<th>CODIGO ALMACEN</th>
							<th>CODIGO ALMACEN</th>
							<th>CODIGO ALMACEN</th>
							<th>CODIGO ALMACEN</th>
							<th>CODIGO ALMACEN</th>
							<th>ORDEN DE PEDIDO ORIGEN</th>
							<th>ORDEN DE PEDIDO ORIGEN</th>
							<!-- 								<th>GUIA REMISION ORIGEN</th> -->

						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>

<div class="x_panel" id="divAnticipo" style="display: none">
	<div class="x_content">
		<div class="container_fluid">
			<div class="row">
				<div class="col-md-6 col-sm-6 col-xs-12 form-group">
					<div class="form-group">
						<label for="usr">Descripción:</label> 
						<input type="text" class="form-control" value id="frmMovVentaOrdenCompra" name="frmMovVentaOrdenCompra">
					</div>
				</div>
				<div class="col-md-6 col-sm-6 col-xs-12 form-group">
							<label class="control-label">Clase Sunat:</label>						
							<input class="form-control" type="text" id="frmProductoClase"  
								value="${prodDescripVclassSunat}"  name="frmProductoClase">
                       </div>
                       <input type="hidden" id="prodVclassSunat" name="prodVclassSunat" required="" value="${prodVclassSunat}" />
			</div>
			<div class="row">
			<div class="col-md-6 col-sm-6 col-xs-12 form-group">
					<div class="form-group">
						<label for="usr">Importe:</label> 
						<input type="text" class="form-control" value id="frmImporteAnticipo" name="frmImporteAnticipo">
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
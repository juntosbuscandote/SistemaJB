/**
 * 
 *  
 * 
 */

function Dashboard() {

}

Dashboard.prototype.init = function() {
	this.handler();

}

Dashboard.prototype.handler = function() {
	
//	var usuario =  session.getAttribute("usuario") ;
//	
//	console.log("ver: "+ usuario);


	//peticion del tipo de cambio
	console.log('Inicio de validacion');
	console.log('ver flag TC: '+$('#dataTipoCambio').val());
	var flagTC=$('#dataTipoCambio').val();
	
	if ($('#userPerfil').val() == "2"){
		console.log("user final");
	} else {
		if(flagTC == '0'){
			//abrir modal
		
			$("#fechaTCActual").text($('#dataTipoCambioFecha').val());
			$('#modalTipoCambio').modal('show');
		}
	}
	/*********************************************************************************************************/
	/*-------------------------------   FIGURA TOTAL DE COMPROBANTES   --------------------------------------*/
	/*********************************************************************************************************/
	var dat = JSON.parse($('#data').val());
	var info = [];
	$.each(dat.data, function(key, value) {
		if (key == "notaVentaV") {
			info[0] = value;
		}
		if (key == "factura") {
			info[1] = value;
		}
		if (key == "boleta") {
			info[2] = value;
		}
		if (key == "notaCredito") {
			info[3] = value;
		}
		if (key == "notaDebito") {
			info[4] = value;
		}
		if (key == "comprobanteRentencion") {
			info[5] = value;
		}
	});
	var datos = {
		type : "pie",
		data : {
			datasets : [ {
				data : info,
				backgroundColor : [ "#9a4820", "#e2462d", "#ea9431", "#f8dcac", "#fbf3ab",
						"#990100", ],
			} ],
			labels : [ "Nota de Venta", "Factura", "Boleta", "Nota de Crédito",
					"Nota de Débito", "C. Retención", ]
		},
		options : {
			responsive : true
		}
	};

	var canvas = $("#totalCPE").get(0).getContext('2d');
	window.pie = new Chart(canvas, datos);

	/*********************************************************************************************************/
	/*-------------------------   FIGURA TOTAL DE COMPROBANTES ACEPTADOS  -----------------------------------*/
	/*********************************************************************************************************/
	var datAcep = JSON.parse($('#dataAcep').val());
	var infoAcep = [];
	$.each(datAcep.data, function(key, value) {
		if (key == "factura") {
			infoAcep[0] = value;
		}
		if (key == "boleta") {
			infoAcep[1] = value;
		}
		if (key == "notaCredito") {
			infoAcep[2] = value;
		}
		if (key == "notaDebito") {
			infoAcep[3] = value;
		}
		if (key == "comprobanteRentencion") {
			infoAcep[4] = value;
		}
	});
	var datos = {
		type : "pie",
		data : {
			datasets : [ {
				data : infoAcep,
				backgroundColor : [ "#e2462d", "#ea9431", "#f8dcac", "#fbf3ab",
						"#990100", ],
			} ],
			labels : [ "Factura", "Boleta", "Nota de Crédito",
					"Nota de Débito", "Comprobante de Retención", ]
		},
		options : {
			responsive : true
		}
	};

	var canvas = $("#CPEAceptado").get(0).getContext('2d');
	window.pie = new Chart(canvas, datos);

	/*********************************************************************************************************/
	/*-------------------------   FIGURA TOTAL DE COMPROBANTES RECHAZADOS  ----------------------------------*/
	/*********************************************************************************************************/
	var datRechaz = JSON.parse($('#dataRechaz').val());
	var infoRechaz = [];
	$.each(datRechaz.data, function(key, value) {
		if (key == "factura") {
			infoRechaz[0] = value;
		}
		if (key == "boleta") {
			infoRechaz[1] = value;
		}
		if (key == "notaCredito") {
			infoRechaz[2] = value;
		}
		if (key == "notaDebito") {
			infoRechaz[3] = value;
		}
		if (key == "comprobanteRentencion") {
			infoRechaz[4] = value;
		}
	});
	var datos = {
		type : "pie",
		data : {
			datasets : [ {
				data : infoRechaz,
				backgroundColor : [ "#e2462d", "#ea9431", "#f8dcac", "#fbf3ab",
						"#990100", ],
			} ],
			labels : [ "Factura", "Boleta", "Nota de Crédito",
					"Nota de Débito", "Comprobante de Retención", ]
		},
		options : {
			responsive : true
		}
	};

	var canvas = $("#CPERechazado").get(0).getContext('2d');
	window.pie = new Chart(canvas, datos);
	
	/*********************************************************************************************************/
	/*-------------------------   FIGURA TOTAL DE COMPROBANTES POR MESES TRIBUTARIOS -----------------------------------*/
	/*********************************************************************************************************/	
	var datFactxMes = JSON.parse($('#dataFactxMes').val());
	var infoFactxMes = [];
	$.each(datFactxMes.data, function(key, value) {
		if (key == "enero") {
			infoFactxMes[0] = value;
		}
		if (key == "febrero") {
			infoFactxMes[1] = value;
		}
		if (key == "marzo") {
			infoFactxMes[2] = value;
		}
		if (key == "abril") {
			infoFactxMes[3] = value;
		}
		if (key == "mayo") {
			infoFactxMes[4] = value;
		}
		if (key == "junio") {
			infoFactxMes[5] = value;
		}
		if (key == "julio") {
			infoFactxMes[6] = value;
		}
		if (key == "agosto") {
			infoFactxMes[7] = value;
		}
		if (key == "septiembre") {
			infoFactxMes[8] = value;
		}
		if (key == "octubre") {
			infoFactxMes[9] = value;
		}
		if (key == "noviembre") {
			infoFactxMes[10] = value;
		}
		if (key == "diciembre") {
			infoFactxMes[11] = value;
		}
	});

	var datBolxMes = JSON.parse($('#dataBolxMes').val());
	var infoBolxMes = [];
	$.each(datBolxMes.data, function(key, value) {
		if (key == "enero") {
			infoBolxMes[0] = value;
		}
		if (key == "febrero") {
			infoBolxMes[1] = value;
		}
		if (key == "marzo") {
			infoBolxMes[2] = value;
		}
		if (key == "abril") {
			infoBolxMes[3] = value;
		}
		if (key == "mayo") {
			infoBolxMes[4] = value;
		}
		if (key == "junio") {
			infoBolxMes[5] = value;
		}
		if (key == "julio") {
			infoBolxMes[6] = value;
		}
		if (key == "agosto") {
			infoBolxMes[7] = value;
		}
		if (key == "septiembre") {
			infoBolxMes[8] = value;
		}
		if (key == "octubre") {
			infoBolxMes[9] = value;
		}
		if (key == "noviembre") {
			infoBolxMes[10] = value;
		}
		if (key == "diciembre") {
			infoBolxMes[11] = value;
		}
	});

	var datNCredxMes = JSON.parse($('#dataNCredxMes').val());
	var infoNCredxMes = [];
	$.each(datNCredxMes.data, function(key, value) {
		if (key == "enero") {
			infoNCredxMes[0] = value;
		}
		if (key == "febrero") {
			infoNCredxMes[1] = value;
		}
		if (key == "marzo") {
			infoNCredxMes[2] = value;
		}
		if (key == "abril") {
			infoNCredxMes[3] = value;
		}
		if (key == "mayo") {
			infoNCredxMes[4] = value;
		}
		if (key == "junio") {
			infoNCredxMes[5] = value;
		}
		if (key == "julio") {
			infoNCredxMes[6] = value;
		}
		if (key == "agosto") {
			infoNCredxMes[7] = value;
		}
		if (key == "septiembre") {
			infoNCredxMes[8] = value;
		}
		if (key == "octubre") {
			infoNCredxMes[9] = value;
		}
		if (key == "noviembre") {
			infoNCredxMes[10] = value;
		}
		if (key == "diciembre") {
			infoNCredxMes[11] = value;
		}
	});

	var datNDebxMes = JSON.parse($('#dataNDebxMes').val());
	var infoNDebxMes = [];
	$.each(datNDebxMes.data, function(key, value) {
		if (key == "enero") {
			infoNDebxMes[0] = value;
		}
		if (key == "febrero") {
			infoNDebxMes[1] = value;
		}
		if (key == "marzo") {
			infoNDebxMes[2] = value;
		}
		if (key == "abril") {
			infoNDebxMes[3] = value;
		}
		if (key == "mayo") {
			infoNDebxMes[4] = value;
		}
		if (key == "junio") {
			infoNDebxMes[5] = value;
		}
		if (key == "julio") {
			infoNDebxMes[6] = value;
		}
		if (key == "agosto") {
			infoNDebxMes[7] = value;
		}
		if (key == "septiembre") {
			infoNDebxMes[8] = value;
		}
		if (key == "octubre") {
			infoNDebxMes[9] = value;
		}
		if (key == "noviembre") {
			infoNDebxMes[10] = value;
		}
		if (key == "diciembre") {
			infoNDebxMes[11] = value;
		}
	});

	var datCRetxMes = JSON.parse($('#dataCRetxMes').val());
	var infoCRetxMes = [];
	$.each(datCRetxMes.data, function(key, value) {
		if (key == "enero") {
			infoCRetxMes[0] = value;
		}
		if (key == "febrero") {
			infoCRetxMes[1] = value;
		}
		if (key == "marzo") {
			infoCRetxMes[2] = value;
		}
		if (key == "abril") {
			infoCRetxMes[3] = value;
		}
		if (key == "mayo") {
			infoCRetxMes[4] = value;
		}
		if (key == "junio") {
			infoCRetxMes[5] = value;
		}
		if (key == "julio") {
			infoCRetxMes[6] = value;
		}
		if (key == "agosto") {
			infoCRetxMes[7] = value;
		}
		if (key == "septiembre") {
			infoCRetxMes[8] = value;
		}
		if (key == "octubre") {
			infoCRetxMes[9] = value;
		}
		if (key == "noviembre") {
			infoCRetxMes[10] = value;
		}
		if (key == "diciembre") {
			infoCRetxMes[11] = value;
		}
	});

	var datosbar = {
		labels : [ "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
				"Julio", "Agosto", "septiembre", "Octubre", "Noviembre",
				"Diciembre" ],
		datasets : [ {
			label : "Factura",
			backgroundColor : "#e2462d",
			data : infoFactxMes
		}, {
			label : "Boleta",
			backgroundColor : "#ea9431",
			data : infoBolxMes
		}, {

			label : "Nota de Crédito",
			backgroundColor : "#f8dcac",
			data : infoNCredxMes
		}, {

			label : "Nota de Débito",
			backgroundColor : "#fbf3ab",
			data : infoNDebxMes
		}, {
			label : "Comprobante de Retención",
			backgroundColor : "#990100",
			data : infoCRetxMes
		} ]
	};
	var canvas = $("#totalCPExMes").get(0).getContext('2d');
	window.bar = new Chart(canvas, {
		type : "bar",
		data : datosbar,
		options : {
			elements : {},
			responsive : true
		}
	});
	
	/*********************************************************************************************************/
	/*-------------------------   FIGURA TOTAL DE COMPROBANTES POR MESES  VENTAS-----------------------------------*/
	/*********************************************************************************************************/
	var datNotVentxMes = JSON.parse($('#dataNotVentxMesV').val());
	var infoNotVentxMes = [];
	$.each(datNotVentxMes.data, function(key, value) {
		if (key == "enero") {
			infoNotVentxMes[0] = value;
		}
		if (key == "febrero") {
			infoNotVentxMes[1] = value;
		}
		if (key == "marzo") {
			infoNotVentxMes[2] = value;
		}
		if (key == "abril") {
			infoNotVentxMes[3] = value;
		}
		if (key == "mayo") {
			infoNotVentxMes[4] = value;
		}
		if (key == "junio") {
			infoNotVentxMes[5] = value;
		}
		if (key == "julio") {
			infoNotVentxMes[6] = value;
		}
		if (key == "agosto") {
			infoNotVentxMes[7] = value;
		}
		if (key == "septiembre") {
			infoNotVentxMes[8] = value;
		}
		if (key == "octubre") {
			infoNotVentxMes[9] = value;
		}
		if (key == "noviembre") {
			infoNotVentxMes[10] = value;
		}
		if (key == "diciembre") {
			infoNotVentxMes[11] = value;
		}
	});
	var datosbar = {
		labels : [ "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
				"Julio", "Agosto", "septiembre", "Octubre", "Noviembre",
				"Diciembre" ],
		datasets : [ {
			label : ["Nota de Venta"],
			backgroundColor : "#9a4820",
			data : infoNotVentxMes	
			}, {
			label: "Nota de venta",
		    type: "line",
			backgroundColor : "#9a4820",
		    data: infoNotVentxMes,
		    fill: false
		} ]
	};
	var canvas = $("#totalCPEVxMes").get(0).getContext('2d');
	window.bar = new Chart(canvas, {
		type : "bar",
		data : datosbar,
		options : {
			elements : {},
			responsive : true
		},
	});
	
	/*********************************************************************************************************/
	/*----------------------   FIGURA MONTO TOTAL DE COMPROBANTES POR MESES  --------------------------------*/
	/*********************************************************************************************************/
	var datNotVenttMontoxMes = JSON.parse($('#dataNotVentMontoxMes').val());
	var infoNotVentMontoxMes = [];
	$.each(datNotVenttMontoxMes.data, function(key, value) {
		if (key == "enero") {
			infoNotVentMontoxMes[0] = value;
		}
		if (key == "febrero") {
			infoNotVentMontoxMes[1] = value;
		}
		if (key == "marzo") {
			infoNotVentMontoxMes[2] = value;
		}
		if (key == "abril") {
			infoNotVentMontoxMes[3] = value;
		}
		if (key == "mayo") {
			infoNotVentMontoxMes[4] = value;
		}
		if (key == "junio") {
			infoNotVentMontoxMes[5] = value;
		}
		if (key == "julio") {
			infoNotVentMontoxMes[6] = value;
		}
		if (key == "agosto") {
			infoNotVentMontoxMes[7] = value;
		}
		if (key == "septiembre") {
			infoNotVentMontoxMes[8] = value;
		}
		if (key == "octubre") {
			infoNotVentMontoxMes[9] = value;
		}
		if (key == "noviembre") {
			infoNotVentMontoxMes[10] = value;
		}
		if (key == "diciembre") {
			infoNotVentMontoxMes[11] = value;
		}
	});
	var datFactMontoxMes = JSON.parse($('#dataFactMontoxMes').val());
	var infoFactMontoxMes = [];
	$.each(datFactMontoxMes.data, function(key, value) {
		if (key == "enero") {
			infoFactMontoxMes[0] = value;
		}
		if (key == "febrero") {
			infoFactMontoxMes[1] = value;
		}
		if (key == "marzo") {
			infoFactMontoxMes[2] = value;
		}
		if (key == "abril") {
			infoFactMontoxMes[3] = value;
		}
		if (key == "mayo") {
			infoFactMontoxMes[4] = value;
		}
		if (key == "junio") {
			infoFactMontoxMes[5] = value;
		}
		if (key == "julio") {
			infoFactMontoxMes[6] = value;
		}
		if (key == "agosto") {
			infoFactMontoxMes[7] = value;
		}
		if (key == "septiembre") {
			infoFactMontoxMes[8] = value;
		}
		if (key == "octubre") {
			infoFactMontoxMes[9] = value;
		}
		if (key == "noviembre") {
			infoFactMontoxMes[10] = value;
		}
		if (key == "diciembre") {
			infoFactMontoxMes[11] = value;
		}
	});
	var datBolMontoxMes = JSON.parse($('#dataBolMontoxMes').val());
	var infoBolMontoxMes = [];
	$.each(datBolMontoxMes.data, function(key, value) {
		if (key == "enero") {
			infoBolMontoxMes[0] = value;
		}
		if (key == "febrero") {
			infoBolMontoxMes[1] = value;
		}
		if (key == "marzo") {
			infoBolMontoxMes[2] = value;
		}
		if (key == "abril") {
			infoBolMontoxMes[3] = value;
		}
		if (key == "mayo") {
			infoBolMontoxMes[4] = value;
		}
		if (key == "junio") {
			infoBolMontoxMes[5] = value;
		}
		if (key == "julio") {
			infoBolMontoxMes[6] = value;
		}
		if (key == "agosto") {
			infoBolMontoxMes[7] = value;
		}
		if (key == "septiembre") {
			infoBolMontoxMes[8] = value;
		}
		if (key == "octubre") {
			infoBolMontoxMes[9] = value;
		}
		if (key == "noviembre") {
			infoBolMontoxMes[10] = value;
		}
		if (key == "diciembre") {
			infoBolMontoxMes[11] = value;
		}
	});

	var datNCredMontoxMes = JSON.parse($('#dataNCredMontoxMes').val());
	var infoNCredMontoxMes = [];
	$.each(datNCredMontoxMes.data, function(key, value) {
		if (key == "enero") {
			infoNCredMontoxMes[0] = value;
		}
		if (key == "febrero") {
			infoNCredMontoxMes[1] = value;
		}
		if (key == "marzo") {
			infoNCredMontoxMes[2] = value;
		}
		if (key == "abril") {
			infoNCredMontoxMes[3] = value;
		}
		if (key == "mayo") {
			infoNCredMontoxMes[4] = value;
		}
		if (key == "junio") {
			infoNCredMontoxMes[5] = value;
		}
		if (key == "julio") {
			infoNCredMontoxMes[6] = value;
		}
		if (key == "agosto") {
			infoNCredMontoxMes[7] = value;
		}
		if (key == "septiembre") {
			infoNCredMontoxMes[8] = value;
		}
		if (key == "octubre") {
			infoNCredMontoxMes[9] = value;
		}
		if (key == "noviembre") {
			infoNCredMontoxMes[10] = value;
		}
		if (key == "diciembre") {
			infoNCredMontoxMes[11] = value;
		}
	});

	var datNDebMontoxMes = JSON.parse($('#dataNDebMontoxMes').val());
	var infoNDebMontoxMes = [];
	$.each(datNDebMontoxMes.data, function(key, value) {
		if (key == "enero") {
			infoNDebMontoxMes[0] = value;
		}
		if (key == "febrero") {
			infoNDebMontoxMes[1] = value;
		}
		if (key == "marzo") {
			infoNDebMontoxMes[2] = value;
		}
		if (key == "abril") {
			infoNDebMontoxMes[3] = value;
		}
		if (key == "mayo") {
			infoNDebMontoxMes[4] = value;
		}
		if (key == "junio") {
			infoNDebMontoxMes[5] = value;
		}
		if (key == "julio") {
			infoNDebMontoxMes[6] = value;
		}
		if (key == "agosto") {
			infoNDebMontoxMes[7] = value;
		}
		if (key == "septiembre") {
			infoNDebMontoxMes[8] = value;
		}
		if (key == "octubre") {
			infoNDebMontoxMes[9] = value;
		}
		if (key == "noviembre") {
			infoNDebMontoxMes[10] = value;
		}
		if (key == "diciembre") {
			infoNDebMontoxMes[11] = value;
		}
	});

	var datCRetMontoxMes = JSON.parse($('#dataCRetMontoxMes').val());
	var infoCRetMontoxMes = [];
	$.each(datCRetxMes.data, function(key, value) {
		if (key == "enero") {
			infoCRetMontoxMes[0] = value;
		}
		if (key == "febrero") {
			infoCRetMontoxMes[1] = value;
		}
		if (key == "marzo") {
			infoCRetMontoxMes[2] = value;
		}
		if (key == "abril") {
			infoCRetMontoxMes[3] = value;
		}
		if (key == "mayo") {
			infoCRetMontoxMes[4] = value;
		}
		if (key == "junio") {
			infoCRetMontoxMes[5] = value;
		}
		if (key == "julio") {
			infoCRetMontoxMes[6] = value;
		}
		if (key == "agosto") {
			infoCRetMontoxMes[7] = value;
		}
		if (key == "septiembre") {
			infoCRetMontoxMes[8] = value;
		}
		if (key == "octubre") {
			infoCRetMontoxMes[9] = value;
		}
		if (key == "noviembre") {
			infoCRetMontoxMes[10] = value;
		}
		if (key == "diciembre") {
			infoCRetMontoxMes[11] = value;
		}
	});

	var datosbar = {
		labels : [ "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
				"Julio", "Agosto", "septiembre", "Octubre", "Noviembre",
				"Diciembre" ],
		datasets : [ {
			label : "B-Nota de Venta",
			backgroundColor : "#9a4820",
			data : infoNotVentMontoxMes
		  }, {
	          label: "L-Nota de Venta",
	          type: "line",
	          backgroundColor: "#9a4820",
	          data: infoNotVentMontoxMes,
	          fill: false
	      }, {
			label : "B-Factura",
			backgroundColor : "#e2462d",
			data : infoFactMontoxMes
		  }, {
	          label: "L-Factura",
	          type: "line",
	          backgroundColor: "#e2462d",
	          data: infoFactMontoxMes,
	          fill: false
	    }, {
			label : "B-Boleta",
			backgroundColor : "#ea9431",
			data : infoBolMontoxMes
		}, {
	         label: "L-Boleta",
	          type: "line",
	          backgroundColor: "#ea9431",
	          data: infoBolMontoxMes,
	          fill: false
	    }, {	
			label : "B-Nota de Crédito",
			backgroundColor : "#f8dcac",
			data : infoNCredMontoxMes
		}, {
	         label: "L-Nota de Crédito",
	          type: "line",
	          backgroundColor: "#f8dcac",
	          data: infoNCredMontoxMes,
	          fill: false
	    }, {	
			label : "B-Nota de Débito",
			backgroundColor : "#fbf3ab",
			data : infoNDebMontoxMes
		}, {
	         label: "L-Nota de Débito",
	          type: "line",
	          backgroundColor: "#fbf3ab",
	          data: infoNDebMontoxMes,
	          fill: false
	    }, {
			label : "B-Comprobante de Retención",
			backgroundColor : "#990100",
			data : infoCRetMontoxMes
		}, {
	         label: "" +
	         		"L-Comprobante de Retención",
	          type: "line",
	          backgroundColor: "#990100",
	          data: infoCRetMontoxMes,
	          fill: false		
		} ]
	};

	var canvas = $("#montoTipCPE").get(0).getContext('2d');
	window.bar = new Chart(canvas, {
		type : "bar",
		data : datosbar,
		options : {
			elements : {},
			responsive : true
		}
	});
//	
//	var grapharea = document.getElementById("barChart").getContext("2d");
//
//	var myChart = new Chart(grapharea, { type: 'bar', data: barData, options: barOptions });
//
//	myChart.destroy();

	/*********************************************************************************************************/
	/*-------------------------   FILTRO TOTAL DE COMPROBANTES POR MESES  -----------------------------------*/
	/*********************************************************************************************************/
	$('body').on('click', '#filTotalBuscar', function() {
		var l = Ladda.create(this);
			$.ajax({
				url : "reloadTotalMeses",
				type : "POST",
				data : "moneda="+ $('#filTotalmoneda').val()+"&anio="+$('#filTotalAnio').val(),
				dataType : "json",
				beforeSend : function() {
					l.start();
					},
				success : function(data) {
					if (data.estado == "1") {
						$('#totalCPExMes').remove(); // this is my <canvas> element
					 	$('#canvas-container-totalCPExMes').append('<canvas id="totalCPExMes" width="300" height="150"></canvas>');
					 	var datFactxMes = JSON.parse(data.dataLPFactxMes);
						var infoFactxMes = [];
						$.each(datFactxMes.data, function(key, value) {
							if (key == "enero") {
								infoFactxMes[0] = value;
							}
							if (key == "febrero") {
								infoFactxMes[1] = value;
							}
							if (key == "marzo") {
								infoFactxMes[2] = value;
							}
							if (key == "abril") {
								infoFactxMes[3] = value;
							}
							if (key == "mayo") {
								infoFactxMes[4] = value;
							}
							if (key == "junio") {
								infoFactxMes[5] = value;
							}
							if (key == "julio") {
								infoFactxMes[6] = value;
							}
							if (key == "agosto") {
								infoFactxMes[7] = value;
							}
							if (key == "septiembre") {
								infoFactxMes[8] = value;
							}
							if (key == "octubre") {
								infoFactxMes[9] = value;
							}
							if (key == "noviembre") {
								infoFactxMes[10] = value;
							}
							if (key == "diciembre") {
								infoFactxMes[11] = value;
							}
						});
	
						var datBolxMes = JSON.parse(data.dataLPBolxMes);
						var infoBolxMes = [];
						$.each(datBolxMes.data, function(key, value) {
							if (key == "enero") {
								infoBolxMes[0] = value;
							}
							if (key == "febrero") {
								infoBolxMes[1] = value;
							}
							if (key == "marzo") {
								infoBolxMes[2] = value;
							}
							if (key == "abril") {
								infoBolxMes[3] = value;
							}
							if (key == "mayo") {
								infoBolxMes[4] = value;
							}
							if (key == "junio") {
								infoBolxMes[5] = value;
							}
							if (key == "julio") {
								infoBolxMes[6] = value;
							}
							if (key == "agosto") {
								infoBolxMes[7] = value;
							}
							if (key == "septiembre") {
								infoBolxMes[8] = value;
							}
							if (key == "octubre") {
								infoBolxMes[9] = value;
							}
							if (key == "noviembre") {
								infoBolxMes[10] = value;
							}
							if (key == "diciembre") {
								infoBolxMes[11] = value;
							}
						});
	
						var datNCredxMes = JSON.parse(data.dataLPNDebxMes);
						var infoNCredxMes = [];
						$.each(datNCredxMes.data, function(key, value) {
							if (key == "enero") {
								infoNCredxMes[0] = value;
							}
							if (key == "febrero") {
								infoNCredxMes[1] = value;
							}
							if (key == "marzo") {
								infoNCredxMes[2] = value;
							}
							if (key == "abril") {
								infoNCredxMes[3] = value;
							}
							if (key == "mayo") {
								infoNCredxMes[4] = value;
							}
							if (key == "junio") {
								infoNCredxMes[5] = value;
							}
							if (key == "julio") {
								infoNCredxMes[6] = value;
							}
							if (key == "agosto") {
								infoNCredxMes[7] = value;
							}
							if (key == "septiembre") {
								infoNCredxMes[8] = value;
							}
							if (key == "octubre") {
								infoNCredxMes[9] = value;
							}
							if (key == "noviembre") {
								infoNCredxMes[10] = value;
							}
							if (key == "diciembre") {
								infoNCredxMes[11] = value;
							}
						});
	
						var datNDebxMes = JSON.parse(data.dataLPNCredxMes);
						var infoNDebxMes = [];
						$.each(datNDebxMes.data, function(key, value) {
							if (key == "enero") {
								infoNDebxMes[0] = value;
							}
							if (key == "febrero") {
								infoNDebxMes[1] = value;
							}
							if (key == "marzo") {
								infoNDebxMes[2] = value;
							}
							if (key == "abril") {
								infoNDebxMes[3] = value;
							}
							if (key == "mayo") {
								infoNDebxMes[4] = value;
							}
							if (key == "junio") {
								infoNDebxMes[5] = value;
							}
							if (key == "julio") {
								infoNDebxMes[6] = value;
							}
							if (key == "agosto") {
								infoNDebxMes[7] = value;
							}
							if (key == "septiembre") {
								infoNDebxMes[8] = value;
							}
							if (key == "octubre") {
								infoNDebxMes[9] = value;
							}
							if (key == "noviembre") {
								infoNDebxMes[10] = value;
							}
							if (key == "diciembre") {
								infoNDebxMes[11] = value;
							}
						});
	
						var datCRetxMes = JSON.parse(data.dataLPCRetxMes);
						var infoCRetxMes = [];
						$.each(datCRetxMes.data, function(key, value) {
							if (key == "enero") {
								infoCRetxMes[0] = value;
							}
							if (key == "febrero") {
								infoCRetxMes[1] = value;
							}
							if (key == "marzo") {
								infoCRetxMes[2] = value;
							}
							if (key == "abril") {
								infoCRetxMes[3] = value;
							}
							if (key == "mayo") {
								infoCRetxMes[4] = value;
							}
							if (key == "junio") {
								infoCRetxMes[5] = value;
							}
							if (key == "julio") {
								infoCRetxMes[6] = value;
							}
							if (key == "agosto") {
								infoCRetxMes[7] = value;
							}
							if (key == "septiembre") {
								infoCRetxMes[8] = value;
							}
							if (key == "octubre") {
								infoCRetxMes[9] = value;
							}
							if (key == "noviembre") {
								infoCRetxMes[10] = value;
							}
							if (key == "diciembre") {
								infoCRetxMes[11] = value;
							}
						});
	
						var datosbar = {
							labels : [ "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
									"Julio", "Agosto", "septiembre", "Octubre", "Noviembre",
									"Diciembre" ],
							datasets : [ {
								label : "Factura",
								backgroundColor : "#e2462d",
								data : infoFactxMes
							}, {
	
								label : "Boleta",
								backgroundColor : "#ea9431",
								data : infoBolxMes
							}, {
	
								label : "Nota de Crédito",
								backgroundColor : "#f8dcac",
								data : infoNCredxMes
							}, {
	
								label : "Nota de Débito",
								backgroundColor : "#fbf3ab",
								data : infoNDebxMes
							}, {
								label : "Comprobante de Retención",
								backgroundColor : "#990100",
								data : infoCRetxMes
							} ]
						};
						var canvas = $("#totalCPExMes").get(0).getContext('2d');
						window.bar = new Chart(canvas, {
							type : "bar",
							data : datosbar,
							options : {
								elements : {},
								responsive : true
							}
						});
						l.stop();
					} else if(data.estado == "2"){
						bootbox.alert("<label class='text-danger'>ERROR : <br> Se produjo un error interno en los servicios</label>");
					}
				},
				complete : function() {},
				error : function(jqXHR, exception) {
						if (jqXHR.status === 0) {
						} else if (jqXHR.status == 400) {
						} else if (jqXHR.status == 401) {
						} else if (jqXHR.status == 403) {
						} else if (jqXHR.status == 404) {
						} else if (jqXHR.status == 500) {
						} else if (jqXHR.status == 503) {
						} else if (exception === 'parsererror') {
						} else if (exception === 'timeout') {
						} else if (exception === 'abort') {
						} else {}
				}
		});
	});  
	
	/*********************************************************************************************************/
	/*-------------------------   FILTRO TOTAL DE COMPROBANTES POR MESES  -----------------------------------*/
	/*********************************************************************************************************/
	$('body').on('click', '#filTotalBuscarv', function() {
		var l = Ladda.create(this);
			$.ajax({
				url : "reloadTotalMesesV",
				type : "POST",
				data : "moneda="+ $('#filTotalmonedav').val()+"&anio="+$('#filTotalAniov').val(),
				dataType : "json",
				beforeSend : function() {
					l.start();
					},
				success : function(data) {
					if (data.estado == "1") {
						$('#totalCPEVxMes').remove(); // this is my <canvas> element
					 	$('#canvas-container-totalCPEVxMes').append('<canvas id="totalCPEVxMes" width="300" height="150"></canvas>');
					 	var datNotVentxMes = JSON.parse(data.dataLPNVentxMes);
						var infoNotVentxMes = [];
						$.each(datNotVentxMes.data, function(key, value) {
							if (key == "enero") {
								infoNotVentxMes[0] = value;
							}
							if (key == "febrero") {
								infoNotVentxMes[1] = value;
							}
							if (key == "marzo") {
								infoNotVentxMes[2] = value;
							}
							if (key == "abril") {
								infoNotVentxMes[3] = value;
							}
							if (key == "mayo") {
								infoNotVentxMes[4] = value;
							}
							if (key == "junio") {
								infoNotVentxMes[5] = value;
							}
							if (key == "julio") {
								infoNotVentxMes[6] = value;
							}
							if (key == "agosto") {
								infoNotVentxMes[7] = value;
							}
							if (key == "septiembre") {
								infoNotVentxMes[8] = value;
							}
							if (key == "octubre") {
								infoNotVentxMes[9] = value;
							}
							if (key == "noviembre") {
								infoNotVentxMes[10] = value;
							}
							if (key == "diciembre") {
								infoNotVentxMes[11] = value;
							}
						});					 	
						var datosbar = {
							labels : [ "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
									"Julio", "Agosto", "septiembre", "Octubre", "Noviembre",
									"Diciembre" ],
							datasets : [ {
								label : "Nota Venta",
								backgroundColor : "#9a4820",
								data : infoNotVentxMes
							}, {
								label: "Nota de venta",
							    type: "line",
								backgroundColor : "#9a4820",
							    data: infoNotVentxMes,
							    fill: false
							} ]
						};
						var canvas = $("#totalCPEVxMes").get(0).getContext('2d');
						window.bar = new Chart(canvas, {
							type : "bar",
							data : datosbar,
							options : {
								elements : {},
								responsive : true
							}
						});
						l.stop();
					} else if(data.estado == "2"){
						bootbox.alert("<label class='text-danger'>ERROR : <br> Se produjo un error interno en los servicios</label>");
					}
				},
				complete : function() {},
				error : function(jqXHR, exception) {
						if (jqXHR.status === 0) {
						} else if (jqXHR.status == 400) {
						} else if (jqXHR.status == 401) {
						} else if (jqXHR.status == 403) {
						} else if (jqXHR.status == 404) {
						} else if (jqXHR.status == 500) {
						} else if (jqXHR.status == 503) {
						} else if (exception === 'parsererror') {
						} else if (exception === 'timeout') {
						} else if (exception === 'abort') {
						} else {}
				}
		});
	}); 
	
	/*********************************************************************************************************/
	/*-------------------------   FILTRO MONTO DE COMPROBANTES POR MESES  -----------------------------------*/
	/*********************************************************************************************************/
	$('body').on('click', '#filMontoBuscar', function() {
		var l = Ladda.create(this);
			$.ajax({
				url : "reloadMontolMeses",
				type : "POST",
				data : "moneda="+ $('#filMontomoneda').val()+"&anio="+$('#filMontoAnio').val(),
				dataType : "json",
				beforeSend : function() {
					l.start();
					},
				success : function(data) {
					if (data.estado == "1") {
						$('#montoTipCPE').remove(); // this is my <canvas> element
						$('#canvas-container-montoTipCPE').append('<canvas id="montoTipCPE" width="300" height="150"></canvas>');
						var datNotVentMontoxMes = JSON.parse(data.dataLPNVentMontoxMes);
						var infoNotVentMontoxMes = [];
						$.each(datNotVentMontoxMes.data, function(key, value) {
							if (key == "enero") {
								infoNotVentMontoxMes[0] = value;
							}
							if (key == "febrero") {
								infoNotVentMontoxMes[1] = value;
							}
							if (key == "marzo") {
								infoNotVentMontoxMes[2] = value;
							}
							if (key == "abril") {
								infoNotVentMontoxMes[3] = value;
							}
							if (key == "mayo") {
								infoNotVentMontoxMes[4] = value;
							}
							if (key == "junio") {
								infoNotVentMontoxMes[5] = value;
							}
							if (key == "julio") {
								infoNotVentMontoxMes[6] = value;
							}
							if (key == "agosto") {
								infoNotVentMontoxMes[7] = value;
							}
							if (key == "septiembre") {
								infoNotVentMontoxMes[8] = value;
							}
							if (key == "octubre") {
								infoNotVentMontoxMes[9] = value;
							}
							if (key == "noviembre") {
								infoNotVentMontoxMes[10] = value;
							}
							if (key == "diciembre") {
								infoNotVentMontoxMes[11] = value;
							}
						});
						var datFactMontoxMes = JSON.parse(data.dataLPFactMontoxMes);
						var infoFactMontoxMes = [];
						$.each(datFactMontoxMes.data, function(key, value) {
							if (key == "enero") {
								infoFactMontoxMes[0] = value;
							}
							if (key == "febrero") {
								infoFactMontoxMes[1] = value;
							}
							if (key == "marzo") {
								infoFactMontoxMes[2] = value;
							}
							if (key == "abril") {
								infoFactMontoxMes[3] = value;
							}
							if (key == "mayo") {
								infoFactMontoxMes[4] = value;
							}
							if (key == "junio") {
								infoFactMontoxMes[5] = value;
							}
							if (key == "julio") {
								infoFactMontoxMes[6] = value;
							}
							if (key == "agosto") {
								infoFactMontoxMes[7] = value;
							}
							if (key == "septiembre") {
								infoFactMontoxMes[8] = value;
							}
							if (key == "octubre") {
								infoFactMontoxMes[9] = value;
							}
							if (key == "noviembre") {
								infoFactMontoxMes[10] = value;
							}
							if (key == "diciembre") {
								infoFactMontoxMes[11] = value;
							}
						});
						var datBolMontoxMes = JSON.parse(data.dataLPBolMontoxMes);
						var infoBolMontoxMes = [];
						$.each(datBolMontoxMes.data, function(key, value) {
							if (key == "enero") {
								infoBolMontoxMes[0] = value;
							}
							if (key == "febrero") {
								infoBolMontoxMes[1] = value;
							}
							if (key == "marzo") {
								infoBolMontoxMes[2] = value;
							}
							if (key == "abril") {
								infoBolMontoxMes[3] = value;
							}
							if (key == "mayo") {
								infoBolMontoxMes[4] = value;
							}
							if (key == "junio") {
								infoBolMontoxMes[5] = value;
							}
							if (key == "julio") {
								infoBolMontoxMes[6] = value;
							}
							if (key == "agosto") {
								infoBolMontoxMes[7] = value;
							}
							if (key == "septiembre") {
								infoBolMontoxMes[8] = value;
							}
							if (key == "octubre") {
								infoBolMontoxMes[9] = value;
							}
							if (key == "noviembre") {
								infoBolMontoxMes[10] = value;
							}
							if (key == "diciembre") {
								infoBolMontoxMes[11] = value;
							}
						});

						var datNCredMontoxMes = JSON.parse(data.dataLPNCredMontoxMes);
						var infoNCredMontoxMes = [];
						$.each(datNCredMontoxMes.data, function(key, value) {
							if (key == "enero") {
								infoNCredMontoxMes[0] = value;
							}
							if (key == "febrero") {
								infoNCredMontoxMes[1] = value;
							}
							if (key == "marzo") {
								infoNCredMontoxMes[2] = value;
							}
							if (key == "abril") {
								infoNCredMontoxMes[3] = value;
							}
							if (key == "mayo") {
								infoNCredMontoxMes[4] = value;
							}
							if (key == "junio") {
								infoNCredMontoxMes[5] = value;
							}
							if (key == "julio") {
								infoNCredMontoxMes[6] = value;
							}
							if (key == "agosto") {
								infoNCredMontoxMes[7] = value;
							}
							if (key == "septiembre") {
								infoNCredMontoxMes[8] = value;
							}
							if (key == "octubre") {
								infoNCredMontoxMes[9] = value;
							}
							if (key == "noviembre") {
								infoNCredMontoxMes[10] = value;
							}
							if (key == "diciembre") {
								infoNCredMontoxMes[11] = value;
							}
						});

						var datNDebMontoxMes = JSON.parse(data.dataLPNDebMontoxMes);
						var infoNDebMontoxMes = [];
						$.each(datNDebMontoxMes.data, function(key, value) {
							if (key == "enero") {
								infoNDebMontoxMes[0] = value;
							}
							if (key == "febrero") {
								infoNDebMontoxMes[1] = value;
							}
							if (key == "marzo") {
								infoNDebMontoxMes[2] = value;
							}
							if (key == "abril") {
								infoNDebMontoxMes[3] = value;
							}
							if (key == "mayo") {
								infoNDebMontoxMes[4] = value;
							}
							if (key == "junio") {
								infoNDebMontoxMes[5] = value;
							}
							if (key == "julio") {
								infoNDebMontoxMes[6] = value;
							}
							if (key == "agosto") {
								infoNDebMontoxMes[7] = value;
							}
							if (key == "septiembre") {
								infoNDebMontoxMes[8] = value;
							}
							if (key == "octubre") {
								infoNDebMontoxMes[9] = value;
							}
							if (key == "noviembre") {
								infoNDebMontoxMes[10] = value;
							}
							if (key == "diciembre") {
								infoNDebMontoxMes[11] = value;
							}
						});

						var datCRetMontoxMes = JSON.parse(data.dataLPCRetMontoxMes);
						var infoCRetMontoxMes = [];
						$.each(datCRetxMes.data, function(key, value) {
							if (key == "enero") {
								infoCRetMontoxMes[0] = value;
							}
							if (key == "febrero") {
								infoCRetMontoxMes[1] = value;
							}
							if (key == "marzo") {
								infoCRetMontoxMes[2] = value;
							}
							if (key == "abril") {
								infoCRetMontoxMes[3] = value;
							}
							if (key == "mayo") {
								infoCRetMontoxMes[4] = value;
							}
							if (key == "junio") {
								infoCRetMontoxMes[5] = value;
							}
							if (key == "julio") {
								infoCRetMontoxMes[6] = value;
							}
							if (key == "agosto") {
								infoCRetMontoxMes[7] = value;
							}
							if (key == "septiembre") {
								infoCRetMontoxMes[8] = value;
							}
							if (key == "octubre") {
								infoCRetMontoxMes[9] = value;
							}
							if (key == "noviembre") {
								infoCRetMontoxMes[10] = value;
							}
							if (key == "diciembre") {
								infoCRetMontoxMes[11] = value;
							}
						});

						var datosbar = {
							labels : [ "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
									"Julio", "Agosto", "septiembre", "Octubre", "Noviembre",
									"Diciembre" ],
							datasets : [ {
								
								label : "B-Nota de Venta",
								backgroundColor : "#9a4820",
								data : infoNotVentMontoxMes
//							}, {
							  }, {
						          label: "L-Nota de Venta",
						          type: "line",
						          backgroundColor:"#9a4820",
						          data: infoNotVentMontoxMes,
						          fill: false
						      }, {
								label : "B-Factura",
								backgroundColor : "#e2462d",
								data : infoFactMontoxMes
							  }, {
						          label: "L-Factura",
						          type: "line",
						          backgroundColor: "#e2462d",
						          data: infoFactMontoxMes,
						          fill: false
						    }, {
								label : "B-Boleta",
								backgroundColor : "#ea9431",
								data : infoBolMontoxMes
							}, {
						         label: "L-Boleta",
						          type: "line",
						          backgroundColor: "#ea9431",
						          data: infoBolMontoxMes,
						          fill: false
						    }, {	
								label : "B-Nota de Crédito",
								backgroundColor : "#f8dcac",
								data : infoNCredMontoxMes
							}, {
						         label: "L-Nota de Crédito",
						          type: "line",
						          backgroundColor: "#f8dcac",
						          data: infoNCredMontoxMes,
						          fill: false
						    }, {	
								label : "B-Nota de Débito",
								backgroundColor : "#fbf3ab",
								data : infoNDebMontoxMes
							}, {
						         label: "L-Nota de Débito",
						          type: "line",
						          backgroundColor: "#fbf3ab",
						          data: infoNDebMontoxMes,
						          fill: false
						    }, {
								label : "B-Comprobante de Retención",
								backgroundColor : "#990100",
								data : infoCRetMontoxMes
							}, {
						         label: "" +
						         		"L-Comprobante de Retención",
						          type: "line",
						          Color: "#990100",
						          data: infoCRetMontoxMes,
						          fill: false	
							} ]
						};

						var canvas = $("#montoTipCPE").get(0).getContext('2d');
						window.bar = new Chart(canvas, {
							type : "bar",
							data : datosbar,
							options : {
								elements : {},
								responsive : true
							}
						});
						l.stop();
					} else if(data.estado == "2"){
						bootbox.alert("<label class='text-danger'>ERROR : <br> Se produjo un error interno en los servicios</label>");
					}
				},
				complete : function() {},
				error : function(jqXHR, exception) {
						if (jqXHR.status === 0) {
						} else if (jqXHR.status == 400) {
						} else if (jqXHR.status == 401) {
						} else if (jqXHR.status == 403) {
						} else if (jqXHR.status == 404) {
						} else if (jqXHR.status == 500) {
						} else if (jqXHR.status == 503) {
						} else if (exception === 'parsererror') {
						} else if (exception === 'timeout') {
						} else if (exception === 'abort') {
						} else {}
				}
		});
	});  
	
}
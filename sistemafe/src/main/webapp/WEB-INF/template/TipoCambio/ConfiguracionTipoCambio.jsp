<form class="form-horizontal form-label-left input_mask" id="frmTipoCambio" name="frmTipoCambio">
<div class="row" >
<!--  <div class="col-md-3 col-sm-6 col-xs-6">Fecha :</div> -->
<!--  <div class="col-md-3 col-sm-6 col-xs-6"><input class="form-control" type="text" id="frmConsultaTC" name="frmConsultaTC" value=""></div> -->
 <div class="col-md-3 col-sm-6 col-xs-6" ></div> 
 <div class="col-md-2 col-sm-6 col-xs-6" align="left"><button type="button" class="btn btn-primary" id="frmbtnConsultarTC">Consultar</button></div>
 <div class="col-md-4 col-sm-6 col-xs-6"><button type="button" class="btn btn-dark" id="test_ajax">IMPORTAR SUNAT</button></div>

</div> 
<div class="row">
<div class="container_fluid">
											<div class="table-responsive">
<table id="lstUsuario" name="lstusuario" 
                                        class="table table-striped table-bordered bulk_action nowrap col-md-12 col-sm-12 col-xs-12" cellspacing="0" width="100%">
                                            <thead >
                                                <tr >
                                                    <th style="text-align: center;">MONEDA</th>
                                                    <th style="text-align: center;">COMPRA</th>
                                                    <th style="text-align: center;">VENTA</th>
                                                    <th style="text-align: center;">PROMEDIO</th>
                                                </tr>  
                                            </thead>
                                            <tbody>
                                                    <tr>
                                                        <td>DOLARES AMERICANOS</td>
                                                        <td><input class="form-control" id="frmTipoCambioCompraD" name="frmTipoCambioCompraD" type="text" placeholder="Compra"></td>
                                                        <td><input class="form-control" id="frmTipoCambioVentaD" name="frmTipoCambioVentaD" type="text" placeholder="Venta"></td>
                                                        <td><input class="form-control" id="frmTipoCambioPromedioD" name="frmTipoCambioPromedioD" type="text" placeholder="Promedio" readonly="readonly"></td>                                       
                                                    </tr>
<!--                                                     <tr> -->
<!--                                                         <td>EURO</td> -->
<!--                                                         <td><input class="form-control" id="frmTipoCambioCompraE" name="frmTipoCambioCompraE" type="text" placeholder="Compra"></td> -->
<!--                                                         <td><input class="form-control" id="frmTipoCambioVentaE" name="frmTipoCambioVentaE" type="text" placeholder="Venta"></td> -->
<!--                                                         <td><input class="form-control" id="frmTipoCambioPromedioE" name="frmTipoCambioPromedioE" type="text" placeholder="Promedio" readonly="readonly"></td>                                        -->
<!--                                                     </tr> -->
<!--                                                     <tr> -->
<!--                                                         <td>YEN</td> -->
<!--                                                         <td><input class="form-control" id="frmTipoCambioCompraY" name="frmTipoCambioCompraY" type="text" placeholder="Compra"></td> -->
<!--                                                         <td><input class="form-control" id="frmTipoCambioVentaY" name="frmTipoCambioVentaY" type="text" placeholder="Venta"></td> -->
<!--                                                         <td><input class="form-control" id="frmTipoCambioPromedioY" name="frmTipoCambioPromedioY" type="text" placeholder="Promedio" readonly="readonly"></td>                                        -->
<!--                                                     </tr> -->

                                            </tbody>
                                        </table>
                                        </div>
                                        </div>
                                        </div>
                    </form>
<script>

$('#frmConsultaTC').daterangepicker({
    singleDatePicker: true,
    calender_style: "picker_4",
    maxDate: new Date(),
    locale: {
      format: 'DD/MM/YYYY'
  }
  }, function(start, end, label) {
    console.log(start.toISOString(), end.toISOString(), label);
  });

$("#frmTipoCambio").validate({
    rules: {
    	frmTipoCambioCompraD: {
            required: true,
            number: true
        },
        frmTipoCambioVentaD: {
            required: true,
            number: true
        },
        frmTipoCambioPromedioD: {
            required: true,
            number: true
//         },

//         frmTipoCambioCompraE: {
//             number: true
//         },
//         frmTipoCambioVentaE: {
//             number: true
//         },
//         frmTipoCambioPromedioE: {
//             number: true
//         },

//         frmTipoCambioCompraY: {
//             number: true
//         },
//         frmTipoCambioVentaY: {
//             number: true
//         },
//         frmTipoCambioPromedioY: {
//             number: true
        }
    },
    messages: {

    	frmTipoCambioCompraD: {
            required: "Campo Obligatorio",
            number: "Solo N&uacute;meros"
        },
        frmTipoCambioVentaD: {
            required: "Campo Obligatorio",
            number: "Solo N&uacute;meros"
        },
        frmTipoCambioPromedioD: {
            required: "Campo Obligatorio",
            number: "Solo N&uacute;meros"
//         },

//         frmTipoCambioCompraE: {
//             number: "Solo N&uacute;meros"
//         },
//         frmTipoCambioVentaE: {
//             number: "Solo N&uacute;meros"
//         },
//         frmTipoCambioPromedioE: {
//             number: "Solo N&uacute;meros"
//         },

//         frmTipoCambioCompraY: {
//             number: "Solo N&uacute;meros"
//         },
//         frmTipoCambioVentaY: {
//             number: "Solo N&uacute;meros"
//         },
//         frmTipoCambioPromedioY: {
//             number: "Solo N&uacute;meros"
        }
    }
});


// $('body').on('click', '#test_ajax', function(event) {
	
// 	$.ajax({
// 		url : "/SistemaFE/tipocambio/test_ajax/",
// 		type : "POST",
// 		data : {"fechaConsulta":$('#frmConsultaTC').val()},
// 		dataType : "json",
// 		beforeSend : function() {
// 			console.log("antes de enviar ");
// 		},
// 		success : function(data) {
// 			if (data.codRpta == "1") {
// 				// ok
				
// 				$.ajax({
// 					url : "/SistemaFE/tipocambio/test_ajax/",
// 					type : "POST",
// 					data : {"fechaConsulta":$('#frmConsultaTC').val()},
// 					dataType : "json",
// 					async: true;
// 					beforeSend : function() {
// 						console.log("antes de enviar ");
// 					},
// 					success : function(data) {
// 						if (data.codRpta == "1") {
// 							// ok
							
							
// 						}else {
// 							// error 
// 						}
// 					},
// 					error : function(xhr, statusText, errorThrown) {
// 						console.log("ocurrio un error");  
// 					}
// 				});
				
// 			}else {
// 				// error 
// 			}
// 		},
// 		error : function(xhr, statusText, errorThrown) {
// 			console.log("ocurrio un error");  
// 		}
// 	});
	
	
// });

$('body').on('click', '#frmbtnConsultarTC', function(event) {
	//buscar el tipo de cambio del dia actual
	$.ajax({
		url : "/SistemaFE/tipocambio/consultaTCDia/",
		type : "POST",
		data : {"fechaConsulta":$('#frmConsultaTC').val()},
		dataType : "json",
		beforeSend : function() {},
		success : function(data) {
			if (data.msg == "ok") {
				
				if(data.flagRegistro=="1"){
					$("#frmTipoCambioCompraD").val(JSON.parse(data.USD).tcCompra);
					$("#frmTipoCambioVentaD").val(JSON.parse(data.USD).tcVenta);
					$("#frmTipoCambioPromedioD").val(JSON.parse(data.USD).tcPromedio);
					
// 					$("#frmTipoCambioCompraE").val(JSON.parse(data.EUR).tcCompra);
// 					$("#frmTipoCambioVentaE").val(JSON.parse(data.EUR).tcVenta);
// 					$("#frmTipoCambioPromedioE").val(JSON.parse(data.EUR).tcPromedio);
					
// 					$("#frmTipoCambioCompraY").val(JSON.parse(data.JPY).tcCompra);
// 					$("#frmTipoCambioVentaY").val(JSON.parse(data.JPY).tcVenta);
// 					$("#frmTipoCambioPromedioY").val(JSON.parse(data.JPY).tcPromedio);
				}else{
					$("#frmTipoCambioCompraD").val("");
					$("#frmTipoCambioVentaD").val("");
					$("#frmTipoCambioPromedioD").val("");
					
// 					$("#frmTipoCambioCompraE").val("");
// 					$("#frmTipoCambioVentaE").val("");
// 					$("#frmTipoCambioPromedioE").val("");
					
// 					$("#frmTipoCambioCompraY").val("");
// 					$("#frmTipoCambioVentaY").val("");
// 					$("#frmTipoCambioPromedioY").val("");
					}
				
			}
		},
		error : function(xhr, statusText, errorThrown) {
			console.log("ocurrio un error");  
		}
	});
	
	
});

//para el calculo del promedio

	$( "#frmTipoCambioCompraD , #frmTipoCambioVentaD" ).change(function() {
		var cD=0,vD=0;
		if($("#frmTipoCambioCompraD").valid()){
			cD=Number($('#frmTipoCambioCompraD').val());
		}
		if($("#frmTipoCambioVentaD").valid()){
			vD=Number($('#frmTipoCambioVentaD').val());
		}
		$('#frmTipoCambioPromedioD').val(((cD+vD)/2).toFixed(3));
	});

	$( "#frmTipoCambioCompraE , #frmTipoCambioVentaE" ).change(function() {
		var cD=0,vD=0;
		if($("#frmTipoCambioCompraE").valid()){
			cD=Number($('#frmTipoCambioCompraE').val());
		}
		if($("#frmTipoCambioVentaE").valid()){
			vD=Number($('#frmTipoCambioVentaE').val());
		}
	    $('#frmTipoCambioPromedioE').val(((cD+vD)/2).toFixed(3));
	});

	$( "#frmTipoCambioCompraY , #frmTipoCambioVentaY" ).change(function() {
		var cD=0,vD=0;
		if($("#frmTipoCambioCompraY").valid()){
			cD=Number($('#frmTipoCambioCompraY').val());
		}
		if($("#frmTipoCambioVentaY").valid()){
			vD=Number($('#frmTipoCambioVentaY').val());
		}
	    $('#frmTipoCambioPromedioY').val(((cD+vD)/2).toFixed(3));
	});


</script>
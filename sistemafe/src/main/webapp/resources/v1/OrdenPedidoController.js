function OrdenPedido() {
	$("#frmMovVentaFecMov").daterangepicker({singleDatePicker:!0,singleClasses:"picker_4"},
  			 function(a,b,c){console.log(a.toISOString(),b.toISOString(),c)});
	
	$("#frmOrdenPedidoFecEntrega").daterangepicker({singleDatePicker:!0,singleClasses:"picker_4"},
 			 function(a,b,c){console.log(a.toISOString(),b.toISOString(),c)});
	
	$("#frmOrdenPedidoFecCaduc").daterangepicker({singleDatePicker:!0,singleClasses:"picker_4"},
 			 function(a,b,c){console.log(a.toISOString(),b.toISOString(),c)});
	
}

OrdenPedido.prototype.init = function() {
	this.handler();
	
}

OrdenPedido.prototype.handler = function() {
	
    var obj=this;
	$('body').on('mouseenter', '#select2-filtrarClienteNroV', function() {
    var boton=$(this);
		var user=boton.attr( "attr-user2" );
		$.ajax({
			url : "/SistemaFE/ordenpedido/detalleordenpedido/",
			type : "POST",
			data : {"user":user},  
			dataType : "json",
			beforeSend : function() {
                    // $('#btnProccess').ladda().ladda('start');
				},
			success : function(data) {
				if (data.msg == "ok") {
					var objULeg=JSON.parse(data.usuarioPer_legal);
					
					$("#filtrarClienteRazonSocialVendedor").val(objULeg.legaBusiname); 
					
					}
			},
			error : function(xhr, statusText, errorThrown) {
				console.log("ocurrio un error");  
			}
		});
	});
	
	
	
	//Cliente
//	$('body').on('mouseenter', '#select2-filtrarClienteNroC', function() {
//
//	    var boton=$(this);
//			var user=boton.attr( "attr-user2" );
//			$.ajax({
//				url : "/SistemaFE/ordenpedido/detalleordenpedido/",
//				type : "POST",
//				data : {"user":user},  
//				dataType : "json",
//				beforeSend : function() {
//	                    // $('#btnProccess').ladda().ladda('start');
//					},
//				success : function(data) {
//					if (data.msg == "ok") {
//						var objULeg=JSON.parse(data.usuarioPer_legal);
//						var objUDirec=JSON.parse(data.usuarioDirec);
//						$("#filtrarClienteRazonSocialCliente").val(objULeg.legaBusiname); 
//						$("#filtrarClienteDireccion").val(objUDirec.addrVaddress); 
//						}
//				},
//				error : function(xhr, statusText, errorThrown) {
//					console.log("ocurrio un error");  
//				}
//			});
//		});
	
		$('.OrdenPedidoOcultarFecCaduc').change(function(){
		if(!$(this).prop('checked')){
		$('#frmOrdenPedidoOcultarFecCaduc').show();
		 }else{
		$('#frmOrdenPedidoOcultarFecCaduc').hide();
		 }													  
		 })					

	
		
}





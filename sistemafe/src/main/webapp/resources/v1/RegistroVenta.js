	function RegistroVenta() {
		this.gMethods = system.globalMethods;
		this.ProductoVenta = $('#lstProductoVenta');
		this.lstDataTableProductoVenta;
		this.lstDataTableAnticipo;
		this.Anticipos = $('#lstAnticipos');
		this.idProducto=0;
		this.idServicio=0;
		this.posRowEdit;
		this.ExploradorCompra = $('#lstExploradorCompra');
		this.GrillaComprasfacbol = $('#lstGrillaCompras');
	    this.GrillaBuscarFacBol = $('#lstExploradorVentaDetalles');
		this.ExploradorVentas = $('#lstExploradorVenta');
		this.objProducto;
		moment.locale('es');
		$("#frmCPEFiltrosfecIniFecFinexplorador").daterangepicker();
		$("#frmCPEFiltrosfecIniFecFinexplorador").val("");
		$("#frmCPEFiltrosFecEmision").daterangepicker({singleDatePicker:!0,singleClasses:"picker_4"},
		 function(a,b,c){console.log(a.toISOString(),b.toISOString(),c)});
	
		$("#frmMovVentaFecMov").daterangepicker({
			 singleDatePicker : !0,		 
			 timePicker: true,
		     timePicker24Hour: true,
		     timePickerSeconds: true,
		     startDate:moment().startOf('minutes'),
			maxDate: new Date(),
			locale: {
	//			format :'DD-MM-YYYY',
				format :'DD-MM-YYYY,HH:mm:ss',
//				
		          "daysOfWeek": [
		              "Do",
		              "Lu",
		              "Ma",
		              "Mi",
		              "Ju",
		              "Vi",
		              "Sá"
		          ],
		          "monthNames": [
		              "Enero",
		              "Febrero",
		              "Marzo",
		              "Abril",
		              "Mayo",
		              "Junio",
		              "Julio",
		              "Agosto",
		              "Septiembre",
		              "Octubre",
		              "Noviembre",
		              "Diciembre"
		          ]
		        },
			singleClasses : "picker_4"
		}, function(a, b, c) {
		console.log(a.toISOString(), b.toISOString(), c)
		});
		
		$("#fechaMovVentafacbol").daterangepicker({
			singleDatePicker : !0,
			maxDate: new Date(),
			locale: {
		          format: 'DD-MM-YYYY',
		          "daysOfWeek": [
		              "Do",
		              "Lu",
		              "Ma",
		              "Mi",
		              "Ju",
		              "Vi",
		              "Sá"
		          ],
		          "monthNames": [
		              "Enero",
		              "Febrero",
		              "Marzo",
		              "Abril",
		              "Mayo",
		              "Junio",
		              "Julio",
		              "Agosto",
		              "Septiembre",
		              "Octubre",
		              "Noviembre",
		              "Diciembre"
		          ]
		        },
			singleClasses : "picker_4"
		}, function(a, b, c) {
			console.log(a.toISOString(), b.toISOString(), c)
		});
		$("#fechaMovVentafacbol").val("");
		
		$("#frmMovVentaFecMovNota").daterangepicker({
			singleDatePicker : !0,
			maxDate: new Date(),
			locale: {
		          format: 'DD-MM-YYYY'
		        },
			singleClasses : "picker_4"
		}, function(a, b, c) {
			console.log(a.toISOString(), b.toISOString(), c)
		});
	
		$("#frmMovVentaFecCad").daterangepicker({
			singleDatePicker : !0,
			locale: {
		          format: 'DD-MM-YYYY'
		        },
			singleClasses : "picker_4"
		}, function(a, b, c) {
			console.log(a.toISOString(), b.toISOString(), c)
		});
	
		$("#frmMovVentaFecEmic").daterangepicker({
			singleDatePicker : !0,
			locale: {
		          format: 'DD-MM-YYYY'
		        },
			singleClasses : "picker_4"
		}, function(a, b, c) {
			console.log(a.toISOString(), b.toISOString(), c)
		});
	
		$("#frmMovVentaFecPago").daterangepicker({
			singleDatePicker:!0,
			locale: {
		          format: 'DD-MM-YYYY'
		        },
			singleClasses:"picker_4"	
		}, function(a,b,c){
			console.log(a.toISOString(),b.toISOString(),c)
		});
		
		$.fn.select2.defaults.set("theme", "bootstrap");
		var placeholder = "Seleccione";
		$(".select2-single").select2({
			placeholder: placeholder,
			width: null,
			containerCssClass: ':all:'
		});
		$(".select2-singlessssss").select2({
			placeholder: placeholder,
			width: null,
			containerCssClass: ':all:'
		});
		
	}
	
	RegistroVenta.prototype.init = function() {
		this.handler();
		this.listarExploradorVenta();	
		 $( "#listaCatDetIndicador" ).val('10').trigger( "change" );
		 $("#listaCatDetComp").change();
		 $('#listaCatDetSucursal').change();
	
		 
		
	}
	
	RegistroVenta.prototype.handler = function() {
	    var obj=this;
	    obj.gMethods.setValidatorDefaults();
	    var selected = [];
	    obj.codigoRegistro();
	    $('#proveedorComprafacbol').val('').trigger('change');
	    $("#tipoCuenta").val("Suma Total");
		$("#tipoCuentas").val("Suma Total");
	    
	    $('body').on('click', '#btn_clean', function(event) {
			$('#frmCPFiltrosSucursal').val('').trigger('change');
			$('#frmCPFiltrosTipo').val('').trigger('change');
			$('#listaCatDetPeriod').val('').trigger('change');
			$('#listaAnulado').val('').trigger('change');
			$('#listaMoneda').val('').trigger('change');
	    });
	    
	    $("#frmProductoClase").autocomplete({
			source : function(request, response) {
				$.ajax({
					url : "/SistemaFE/producto/listarClases/",
					type : "POST",
					dataType : "json",
					data : {
						term : $("#frmProductoClase").val()
					},
					success : function(data) {
						response($.map(data.toption, function(item) {
							return {
								label : item.store,	
								label1 : item.id,	
							};
						}));	

					},
				}); 
			},
			select : function(event, ui) {
				$("#prodVclassSunat").val(ui.item.label1);
			}
		});
	    
	    $('body').on('click', '#cliente', function(event) {
	    	$("#frmTipoPersonNatural").prop( "checked", true );
	    	$('input[type=radio][name=frmTipoPerson]').trigger('change');
	    	$('#pers_vnumdoc').val("");
	    	var l = Ladda.create( document.querySelector( '#btnClienteGuardar' ) );
	    	l.stop();
	    	/*
	         * Configuración de persona
	         */
	    	$("#grbvendedor").hide();
	    	$("#titlevendedor").hide();
	    	$("#grbcliente").show();
	    	$("#titlecliente").show();
	    	$("#modalPersona").modal("show");
	    	
	        $("#natural_vlocalidad").select2({ width: '100%' });
	        $("#natural_vpais").select2({ width: '100%' });
	        $("#legal_vpais").select2({ width: '100%' });
	        $("#legal_vlocalidad").select2({ width: '100%' });
	        $("#emp_empresa").select2({ width: '100%' });
			
	   });
	    
	    
	    $('body').on('click', '#CrearVendedor', function(event) {
	    	$("#frmTipoPersonNatural").prop( "checked", true );
	    	$('input[type=radio][name=frmTipoPerson]').trigger('change');
	    	$('#pers_vnumdoc').val("");
	    	var l = Ladda.create( document.querySelector( '#btnProccessVendedor' ) );
	    	l.stop();
	    	/*
	         * Configuración de persona
	         */
	    	$("#grbcliente").hide();
	    	$("#titlecliente").hide();
	    	$("#grbvendedor	").show();
	    	$("#titlevendedor	").show();
	    	$("#modalPersona").modal("show");
	    	
	        $("#natural_vlocalidad").select2({ width: '100%' });
	        $("#natural_vpais").select2({ width: '100%' });
	        $("#legal_vpais").select2({ width: '100%' });
	        $("#legal_vlocalidad").select2({ width: '100%' });
	        $("#emp_empresa").select2({ width: '100%' });
			
	   });
	    
	    $('body').on('change', '#check-all', function() {
	        if($(this).is(':checked')){
	            $('input[type="checkbox"]').not(this).prop('checked', false);
	            
	            var tr = $(this).closest('tr');
	             
	        }
	    });
	    
	    //mtoledo 08/03/2019 CWA-591
	    $('body').on('change', '#listaTipoOperacion', function() {
	    	var value=$("#listaTipoOperacion").val();
	    	if(value=="2"){
	    		obj.activar(0);
	    		$("#divAnticipo").show();
	    		$("#grillaDetalleFactura").hide();
	    	}else{
	    		$("#grillaDetalleFactura").show();
	    		$("#divAnticipo").hide();
	    		obj.activar(1);
	    	}
	    });
	    
	    //mtoledo 12/03/2019 CWA-591
	    $('body').on('change', '#frmImporteAnticipo', function() {
	    	var codia = $("#listaCatDetIndicador").val();
			$.ajax({
				url : "/SistemaFE/registroventa/calcularAnticipo/",
				type : "POST",
				data : {"monto":$("#frmImporteAnticipo").val() ,"indicadorAfecto":$("#listaCatDetIndicador").val()},
				dataType : "json",
				beforeSend : function() {},
				success : function(data) {
					obj.objProducto=data.datos;
					var o=new Array("DIEZ", "ONCE", "DOCE", "TRECE", "CATORCE", "QUINCE", "DIECISÉIS", "DIECISIETE", "DIECIOCHO", "DIECINUEVE", "VEINTE", "VEINTIUNO", "VEINTIDÓS", "VEINTITRÉS", "VEINTICUATRO", "VEINTICINCO", "VEINTISÉIS", "VEINTISIETE", "VEINTIOCHO", "VEINTINUEVE");
					var u=new Array("CERO", "UNO", "DOS", "TRES", "CUATRO", "CINCO", "SEIS", "SIETE", "OCHO", "NUEVE");
					var d=new Array("", "", "", "TREINTA", "CUARENTA", "CINCUENTA", "SESENTA", "SETENTA", "OCHENTA", "NOVENTA");
					var c=new Array("", "CIENTO", "DOSCIENTOS", "TRESCIENTOS", "CUATROCIENTOS", "QUINIENTOS", "SEISCIENTOS", "SETECIENTOS", "OCHOCIENTOS", "NOVECIENTOS");
				    var tot = data.datos.totalNeto;
					function nn(n)
					{
					  /*OJO: no hay tercer parámetro*/
					  var n=parseFloat(n).toFixed(2); /*se limita a dos decimales, no sabía que existía toFixed() :)*/
					  var p=n.toString().substring(n.toString().indexOf(".")+1); /*decimales*/
					  var m=n.toString().substring(0,n.toString().indexOf(".")); /*número sin decimales*/
					  var m=parseFloat(m).toString().split("").reverse(); /*tampoco que reverse() existía :D*/
					  var t="";
	
					  /*Se analiza cada 3 dígitos*/
					  for (var i=0; i<m.length; i+=3)
					  {
					    var x=t;
					    /*formamos un número de 2 dígitos*/
					    var b=m[i+1]!=undefined?parseFloat(m[i+1].toString()+m[i].toString()):parseFloat(m[i].toString());
					    /*analizamos el 3 dígito*/
					    t=m[i+2]!=undefined?(c[m[i+2]]+" "):"";
					    t+=b<10?u[b]:(b<30?o[b-10]:(d[m[i+1]]+(m[i]=='0'?"":(" Y "+u[m[i]]))));
					    t=t=="CIENTO CERO"?"CIEN":t;
					    if (2<i&&i<6)
					      t=t=="UNO"?"MIL ":(t.replace("UNO","UN")+" MIL ");
					    if (5<i&&i<9)
					      t=t=="UNO"?"UN MILLÓN ":(t.replace("UNO","UN")+" MILLONES ");
					    t+=x;
					    //t=i<3?t:(i<6?((t=="uno"?"mil ":(t+" mil "))+x):((t=="uno"?"un millón ":(t+" millones "))+x));
					  }
				     
					  if($("#listaCatDetMoneda").val()==1){
						  t+=" CON "+p+"/100" +" SOLES"; 
					  }else{
						  t+=" CON "+p+"/100" +" DOLARES AMERICANOS";
					  }
					  /*correcciones*/
					  t=t.replace("  "," ");
					  t=t.replace(" CERO","");
					  $("#frmResultadoMonto").val(t);
					  return t;
					
					}  
					if (data.msg == "ok") {
						if(codia=="10"){
				        	$("#frmResultadoINF").val("0.00");
				        	$("#frmResultadoExonerado").val("0.00");
				        	$("#frmResultadoExportacion").val("0.00");
				        	$("#frmResultadoBIM").val(data.datos.baseImporte);
				        	//MONTOS TOTALES
				        	$("#frmResultadoVentaGratuita").val("0.00");
				        	$("#frmResultadoValorTotal").val(data.datos.valorVenta);
				        	$("#frmResultadoImpDescTot").val(data.datos.importeDesc);
				        	$("#frmResultadoNeto").val(data.datos.valorVenta);
				        	$("#frmResultadoIGV").val(data.datos.igv);
				        	$("#frmResultadoTotal").val(parseFloat(data.datos.totalNeto).toFixed(2));
				        	$("#frmResultadoTotalView").val(parseFloat(data.datos.totalNeto).toFixed(2));
				        	$("#frmResultadoConver").val(parseFloat(data.datos.totalNeto).toFixed(2));
				        	nn($("#frmResultadoTotal").val());
				    	}else if(codia=="20"){
				    		$("#frmResultadoINF").val("0.00");
				        	$("#frmResultadoExonerado").val(data.datos.baseImporte);
				        	$("#frmResultadoExportacion").val("0.00");
				        	$("#frmResultadoBIM").val("0.00");
				        	//MONTOS TOTALES
				        	$("#frmResultadoVentaGratuita").val("0.00");
				        	$("#frmResultadoValorTotal").val(data.datos.valorVenta);
				        	$("#frmResultadoImpDescTot").val(data.datos.importeDesc);
				        	$("#frmResultadoNeto").val(data.datos.valorVenta);
				        	$("#frmResultadoIGV").val("0.00");
				        	$("#frmResultadoTotal").val(parseFloat(data.datos.totalNeto).toFixed(2));
				        	$("#frmResultadoTotalView").val(parseFloat(data.datos.totalNeto).toFixed(2));
				        	$("#frmResultadoConver").val(parseFloat(data.datos.totalNeto).toFixed(2));
				        	 nn($("#frmResultadoTotal").val());
				        }else if(codia=="30"){
				        	$("#frmResultadoINF").val(data.datos.baseImporte);
				        	$("#frmResultadoExonerado").val("0.00");
				        	$("#frmResultadoExportacion").val("0.00");
				        	$("#frmResultadoBIM").val("0.00");
				        	//MONTOS TOTALES
				        	$("#frmResultadoVentaGratuita").val("0.00");
				        	$("#frmResultadoValorTotal").val(data.datos.valorVenta);
				        	$("#frmResultadoImpDescTot").val(data.datos.importeDesc);
				        	$("#frmResultadoNeto").val(data.datos.valorVenta);
				        	$("#frmResultadoIGV").val("0.00");
				        	$("#frmResultadoTotal").val(parseFloat(data.datos.totalNeto).toFixed(2));
				        	$("#frmResultadoTotalView").val(parseFloat(data.datos.totalNeto).toFixed(2));
				        	$("#frmResultadoConver").val(parseFloat(data.datos.totalNeto).toFixed(2));
				        	 nn($("#frmResultadoTotal").val());
				        }else if(codia=="40"){
				        	$("#frmResultadoINF").val("0.00");
				        	$("#frmResultadoExonerado").val("0.00");
				        	$("#frmResultadoExportacion").val(data.datos.baseImporte);
				        	$("#frmResultadoBIM").val("0.00");
				        	//MONTOS TOTALES
				        	$("#frmResultadoVentaGratuita").val("0.00");
				        	$("#frmResultadoValorTotal").val(data.datos.valorVenta);
				        	$("#frmResultadoImpDescTot").val(data.datos.importeDesc);
				        	$("#frmResultadoNeto").val(data.datos.valorVenta);
				        	$("#frmResultadoIGV").val("0.00");
				        	$("#frmResultadoTotal").val(parseFloat(data.datos.totalNeto).toFixed(2));
				        	$("#frmResultadoTotalView").val(parseFloat(data.datos.totalNeto).toFixed(2));
				        	$("#frmResultadoConver").val(parseFloat(data.datos.totalNeto).toFixed(2));
				        	 nn($("#frmResultadoTotal").val());
				        }else if(codia=="50"){
				        	$("#frmResultadoINF").val("0.00");
				        	$("#frmResultadoExonerado").val("0.00");
				        	$("#frmResultadoExportacion").val("0.00");
				        	$("#frmResultadoBIM").val("0.00");
				        	//MONTOS TOTALES
				        	$("#frmResultadoVentaGratuita").val(data.datos.baseImporte);
				        	$("#frmResultadoValorTotal").val(data.datos.valorVenta);
				        	$("#frmResultadoImpDescTot").val("0.00");
				        	$("#frmResultadoNeto").val("0.00");
				        	$("#frmResultadoIGV").val(data.datos.igv);
				        	$("#frmResultadoTotal").val("0.00");
				        	$("#frmResultadoTotalView").val("0.00");
				        	$("#frmResultadoConver").val("0.00");
				        	 nn($("#frmResultadoTotal").val());
				        }
					} else {
						$("#listaTipCambio").val("");
					}
				},
				error : function(xhr, statusText, errorThrown) {
					console.log("ocurrio un error");  
				}
			});
	    	
	    	
	    });
	    
	    
	    //mtoledo 08/03/2019 CWA-591
	    $("input[name=operAnticipo]").click(function () {
	    	if($(this).val()=="2"){
	    		$("#grillaAnticipos").show();
	    		$("#grillaDetalleFactura").show();
	    		$("#divAnticipo").hide();
	    	}else{
	    		$("#grillaAnticipos").hide();
	    		$("#grillaDetalleFactura").hide();
	    		$("#divAnticipo").show();
	    	}
	    });
	    
	    //mtoledo 08/03/2019 CWA-591
	    $('body').on('click', '#btnAnticipos', function(event) {
	    	obj.cargarCPEanticipos();
	    	$("#txtTipoCPAnticipo").val($("#listaCatDetComp").find('option:selected').text());
	    	$('#txtFechaAnticipo').val("");
	    	$('#txtTotalAnticipo').val("");
	    	$('#txtMontoDisponibleAnticipo').val("");
	    	$('#txtMontoUtilizarAnticipo').val("");
	    	$('#txtSaldoFinalAnticipo').val("");
	    	$('#modalLstAnticipo').modal('show');
	    });	
	    
	    //mtoledo 08/03/2019 CWA-591
	    $('body').on('change', '#lstSerieAnticipo', function(event) {
	    	obj.cargarCPEanticipos($('#lstSerieAnticipo').val());
	    	
	    });
	    
	    //mtoledo 08/03/2019 CWA-591
	    $('body').on('click', '#btnAgregarAnticipo', function(event) {
	    	obj.listarAnticipos();
	    	obj.cargarLstanticipos();
	    	obj.cargarCPEanticipos();
	    	$("#txtTipoCPAnticipo").val($("#listaCatDetComp").find('option:selected').text());
	    	$('#lstSerieAnticipo').val("");
	    	$('#txtFechaAnticipo').val("");
	    	$('#txtTotalAnticipo').val("");
	    	$('#txtMontoDisponibleAnticipo').val("");
	    	$('#txtMontoUtilizarAnticipo').val("");
	    	$('#txtSaldoFinalAnticipo').val("");
	    });
	    
	    //mtoledo 08/03/2019 CWA-591
	    $('body').on('change', '#txtMontoUtilizarAnticipo', function(event) {
	    	obj.calcularSaldoDisponible();
	    	
	    });
		
		$('body').on('change', '#frmMovVentaFecMov', function() {
			if($('#listaCatDetComp').val()== "07" || $('#listaCatDetComp').val()== "08"){
				console.log("fecha nota");
			}else {
			$.ajax({
				url : "/SistemaFE/registroventa/consultaTCFechaSel/",
				type : "POST",
				data : {"fechaConsulta":$('#frmMovVentaFecMov').val()},
				dataType : "json",
				beforeSend : function() {},
				success : function(data) {
					if (data.msg == "ok") {
						var template = $("#cboMasterTipCambio").html();
	                    var content = $("#listaTipCambio").empty();
	                    var html = Mustache.render(template, data);
	                    content.html(html);
	                    obj.CalcularTipCambGrilla();
					} else if (data.msg == "vacio") {
						bootbox.alert("<label class='text-danger'>ALERTA : <br> La fecha seleccionada no posee tipo de cambio</label>");
						$("#listaTipCambio").val("");
					} else {
						$("#listaTipCambio").val("");
					}
				},
				error : function(xhr, statusText, errorThrown) {
					console.log("ocurrio un error");  
				}
			});
			}
		});
		
		$('body').on('change', '#frmMovVentaFecMovNota', function() {
			$.ajax({
				url : "/SistemaFE/registroventa/consultaTCFechaSel/",
				type : "POST",
				data : {"fechaConsulta":$('#frmMovVentaFecMovNota').val()},
				dataType : "json",
				beforeSend : function() {},
				success : function(data) {
					if (data.msg == "ok") {
						var template = $("#cboMasterTipCambio").html();
	                    var content = $("#listaTipCambio").empty();
	                    var html = Mustache.render(template, data);
	                    content.html(html);
					} else if (data.msg == "vacio") {
						bootbox.alert("<label class='text-danger'>ALERTA : <br> La fecha seleccionada no posee tipo de cambio</label>");
						$("#listaTipCambio").val("");
					} else {
						$("#listaTipCambio").val("");
					}
				},
				error : function(xhr, statusText, errorThrown) {
					console.log("ocurrio un error");  
				}
			});
		});
	   
		
		$('body').on('change', '#listaCatDetComp', function() {
			if($('#listaCatDetComp').val()== "07"){
				$('#divNotaVenta').show();
				$('#divMotivoCre').show();
				$('#divMotivoDeb').hide();
				$('#divObs').hide();
				$('#divObsNota').show();
				$('#modalNotaBuscarDoc').modal({backdrop: 'static', keyboard: false});
				obj.listarFacturaVenta();
				$('.vendNota').addClass('col-md-12 col-sm-12 col-xs-12');
				$('.vendNota').removeClass('col-md-5 col-sm-5 col-xs-12');
			} else if($('#listaCatDetComp').val()== "08"){		
				$('#divNotaVenta').show();
				$('#divMotivoDeb').show();
				$('#divMotivoCre').hide();
				$('#divObs').hide();
				$('#divObsNota').show();
				$('#modalNotaBuscarDoc').modal({backdrop: 'static', keyboard: false});
				obj.listarFacturaVenta();
				$('.vendNota').addClass('col-md-12 col-sm-12 col-xs-12');
				$('.vendNota').removeClass('col-md-5 col-sm-5 col-xs-12');
			} else {
				
				var position=obj.lstDataTableProductoVenta.row( $(this).parents('tr') ).index();
		     	obj.lstDataTableProductoVenta.rows(position).remove().draw();  
				$('#frmResultadoBIM').val('').trigger('change');
				$('#frmResultadoINF').val('').trigger('change');
				$('#frmResultadoExonerado').val('').trigger('change');
				$('#frmResultadoExportacion').val('').trigger('change');
				$('#frmResultadoVentaGratuita').val('').trigger('change');
				$('#frmResultadoValorTotal').val('').trigger('change');
				$('#frmResultadoImpDescTot').val('').trigger('change');
				$('#frmResultadoNeto').val('').trigger('change');
				$('#frmResultadoIGV').val('').trigger('change');
				$('#frmResultadoTotal').val('').trigger('change');
				$('#frmResultadoConver').val('').trigger('change');
				$('#frmResultadoMonto').val('').trigger('change');
				$('#frmResultadoTotalView').val('').trigger('change');
				$('#frmMovVentaObs').val('').trigger('change');
				
				$('#divNotaVenta').hide();
				$('#divMotivoDeb').hide();
				$('#divMotivoCre').hide();
				$('#divObsNota').hide();
				$('#divObs').show();
				$("#filtrarClienteNroC").attr("disabled",false);
				$("#filtrarVendedorNroV").attr("disabled",false);
				$("#listaCatDetIndicador").attr("disabled",false);
				$("#listaCatDetIndicadortipo").attr("disabled",false);
				$('#filtrarClienteNroC').val($("").val()).trigger('change');
	//			$('#filtrarVendedorNroV').val($("").val()).trigger('change');
				$('#listaCatDetIndicador').removeAttr("disabled");
	            $("#listaCatDetIndicadortipo").removeAttr("disabled");
				
				$('#lstProductoVenta').DataTable().clear();
				$('.vendNota').addClass('col-md-5 col-sm-5 col-xs-12');
				$('.vendNota').removeClass('col-md-12 col-sm-12 col-xs-12');
			}
		});
		
		$("#frmDatosObservacion").validate({
			rules: {
				frmMovVentaObsNota: {
	            	required: true
	
	            }
	        }
		});
		if ($("#frmMovVentaFecMov")!=""){
			$.ajax({
				url : "/SistemaFE/registroventa/consultaTCFechaSel/",
				type : "POST",
				data : {"fechaConsulta":$('#frmMovVentaFecMov').val()},
				dataType : "json",
				beforeSend : function() {},
				success : function(data) {
					if (data.msg == "ok") {
						var template = $("#cboMasterTipCambio").html();
	                    var content = $("#listaTipCambio").empty();
	                    var html = Mustache.render(template, data);
	                    content.html(html);
					} else {
						$("#listaTipCambio").val("");
					}
				},
				error : function(xhr, statusText, errorThrown) {
					console.log("ocurrio un error");  
				}
			});
		}
		$('body').on('click', '#mostrarSel', function(event) {
			var obj=this;
			if(!$(".selecciondetalle").is(':checked')){
				bootbox.alert({
		            size: null,
		            title: null,
		            message: "<label class='text-danger'>No hay ningún detalle seleccionado</label>"
		        });
				
				
				
	        } else {
			$('#lstProductoVenta').DataTable().clear();
		    var boton=$(this);	
			var codDet=$("#idCompra").val();
			$.ajax({
				url : "/SistemaFE/registroventa/detalleNCND/",
				type : "POST",
				data : {"codDet":codDet},
				dataType : "json",
				beforeSend : function() {},
				success : function(data) {
					if (data.msg == "ok") {
						var obj=JSON.parse(data.Campos_NC_ND);
						
						$("#frmMovVentaFecMovNota").val(obj.fechademovimiento);
						$("#frmMovVentaListaCompNota").val(obj.tipdoc);
						$("#frmMovVentaSerieNota").val(obj.VentaSerie);
						$("#frmMovVentaNroComprNota").val(obj.VentaNroDoc);
						$("#filtrarClienteNroC").val(obj.cliente).trigger('change');
						$("#filtrarVendedorNroV").val(obj.vendedor).trigger('change');
						$("#idVentaRef").val(obj.idcodVenta);
						$("#idMoneNota").val(obj.moneda);
						console.log($("#idMoneNota").val());
	//					$("#listaCatDetMoneda").val(obj.moneda);
						
						$("#dataFacIndicadorAf").val(obj.indicador);
						$("#dataFacIndicadorAfTipo").val(obj.indicadortipo);
						$("#listaCatDetIndicadortipo").val(obj.indicadortipo);
						var ia = $("#dataFacIndicadorAf").val(obj.indicador);
						var tia = $("#dataFacIndicadorAfTipo").val(obj.indicadortipo);
						if($("#dataFacIndicadorAf").val()=="10"){
							$("#listaCatDetIndicador").val(obj.indicador).trigger('change');
							$("#listaCatDetIndicadortipo").val(obj.indicadortipo).trigger('change');
						}else if($("#dataFacIndicadorAf").val()=="20"){
							$("#listaCatDetIndicador").val(obj.indicador).trigger('change');
							$("#listaCatDetIndicadortipo").val(obj.indicadortipo).trigger('change');
						}else if($("#dataFacIndicadorAf").val()=="30"){
							$("#listaCatDetIndicador").val(obj.indicador).trigger('change');	
							$("#listaCatDetIndicadortipo").val(obj.indicadortipo).trigger('change');
						}else if($("#dataFacIndicadorAf").val()=="40"){
							$("#listaCatDetIndicador").val(obj.indicador).trigger('change');	
							$("#listaCatDetIndicadortipo").val(obj.indicadortipo).trigger('change');
						}else if($("#dataFacIndicadorAf").val()=="50"){
						$("#listaCatDetIndicador").val(obj.indicador).trigger('change');	
						$("#listaCatDetIndicadortipo").val(obj.indicadortipo).trigger('change');			
						}
						
						$("#filtrarClienteNroC").attr("disabled",true);
						$("#filtrarVendedorNroV").attr("disabled",true);
						$("#listaCatDetIndicador").attr("disabled",true);
						$("#listaCatDetIndicadortipo").attr("disabled",true);
						
						$.ajax({
							url : "/SistemaFE/registroventa/consultaTCFechaSel/",
							type : "POST",
							data : {"fechaConsulta":$('#frmMovVentaFecMovNota').val()},
							dataType : "json",
							beforeSend : function() {},
							success : function(data) {
								if (data.msg == "ok") {
									var template = $("#cboMasterTipCambio").html();
				                    var content = $("#listaTipCambio").empty();
				                    var html = Mustache.render(template, data);
				                    content.html(html);
				                    if($('#listaCatDetComp').val()== "07" || $('#listaCatDetComp').val() == "08"){
				                   		 if(ia=="10"){
				                   			$("#listaCatDetIndicadortipo").val(tia).trigger('change');
				                   	     }else if(ia=="20"){
				                   			$("#listaCatDetIndicadortipo").val(tia).trigger('change');
				                   	     }else if(ia=="30"){
				                   			$("#listaCatDetIndicadortipo").val(tia).trigger('change');
				                   	     }else if(ia=="40"){
				                   			$("#listaCatDetIndicadortipo").val(tia).trigger('change');
				                   	     }else if(ia=="50"){
				                   			$("#listaCatDetIndicadortipo").val(tia).trigger('change');
				                   	     } 
				                   	}
				                    
				                    
				                    var valores = new Array();
					          		  var sList = "";
					          		  $('input[type=checkbox]').each(function () {
					          		    if(this.checked){
					          		      valores.push(
					          		          $(this).parent().parent().find(".codigoDetVen").text()
					          		      );
					          		    }
					          		  });
					          		  
					          		  $("#idMostrarDetVenta").val(valores);
					          		  var codDet = $("#idMostrarDetVenta").val();
					          		  
					          		  $.ajax({
					          				url : "/SistemaFE/registroventa/detVentaIndividual/",
					          				type : "POST",
					          				data : {"codDet":codDet},  
					          				dataType : "json",
					          				beforeSend : function() { },
					          				success : function(data) {
					          					if (data.msg == "ok") {	
					          						 $('#lstProductoVenta').DataTable().rows.add(data.datadetalle);	
					          					      $('#lstProductoVenta').DataTable().draw();
					          					      //obj.calculaValor();
					          					    $("#listaCatDetMoneda").val($("#idMoneNota").val()).change();
					          				}			
					          				},
					          				error : function(xhr, statusText, errorThrown) {
					          					console.log("ocurrio un error");  
					          				}
					          			});
					          		  console.log($("#idMoneNota").val());
	//				          		  var idMoneNota = $("#idMoneNota").val();
					          		
					          		  $('#modalNotaBuscarDoc').modal('hide');	
					          		  $("#idMostrarDetVenta").val("");
					          		  $("#mostrarSel").hide();
					          		  $("#PanelDetalle").hide();
					          		  $("#btnAgregafac").show();
								} else if (data.msg == "vacio") {
									bootbox.alert("<label class='text-danger'>ALERTA : <br> La fecha seleccionada no posee tipo de cambio</label>");
									$("#listaTipCambio").val("");
								} else {
									$("#listaTipCambio").val("");
								}
							},
							error : function(xhr, statusText, errorThrown) {
								console.log("ocurrio un error");  
							}
						});
					}
				},
				error : function(xhr, statusText, errorThrown) {
					console.log("ocurrio un error");  
				}
			});
			
			  
	        }
		});
	    
	    $('body').on('click', '#mostrarSel', function(event) {
			console.log("seleccionados"+$("#filasSeleccionadas").val());		
	   });
		
		$('body').on('click', '#btn_searchfiltrofacbol', function(event) {
			obj.reloadDataTableFacBolCompra();
			$("#PanelDetalle").hide();
			$("#btnAgregafac").show();
			$("#mostrarSel").hide();
	   });
		$('body').on('click', '#btn_clean', function(event) {
			$('#listaComprobantefacbol').val('').trigger('change');
			$('#clienteVentafacbol').val('').trigger('change');
	   });
		
		$('body').on('click', '#btncancelareditar', function(event) {
			 bootbox.confirm("Se perderán los cambios ¿ Desea continuar ?", function(result) {
			        if(result) {
			        	$("#modalEditGriVent").modal('hide');
			        }else{
			        	console.log("Salio");
			        }
			    });
	  });
		
		$('body').on('click', '.btnVerDetCompraDetFac', function() {
			var boton=$(this);
			var codDet=boton.attr( "attr-user" );
			$("#idCompra").val(codDet);	
			$("#idCompraparaNotC").val(codDet);				
			$.ajax({
				url : "/SistemaFE/registroventa/MostrarDetalle/",
				type : "POST",
				data : {"codDet":codDet},  
				dataType : "json",
				beforeSend : function() { },
				success : function(data) {
					if (data.msg == "ok") {	
						if($("#idCompraparaNotC").val()!="" ){	
							
							$("#PanelDetalle").show();
							obj.listarProductoComprafacturaboleta();
						}
						$("#mostrarSel").show();
										}
					$("#btnAgregafac").hide();
				},
				error : function(xhr, statusText, errorThrown) {
					console.log("ocurrio un error");  
				}
			});	
			
		});
		
		$('body').on('click', '#SalirFacBol', function(event) {
			 $("#frmFactBuscar").trigger("reset");
			 $("#PanelDetalle").hide();
			$('#modalNotaBuscarDoc').modal('hide');
			$("#mostrarSel").hide();
			bootbox.alert({
	            size: null,
	            title: null,
	            message: "<label class='text-danger'>no se ha seleccionada ningún CPE</label>"
	        });
	  });
	
	    var obj=this;   
		$('body').on('click', '#Salir', function(event) {
			 $("#frmmodalMostrarDetalle").trigger("reset");
			$('#frmmodalMostrarDetalle').modal('hide');
			$('#idCompra').val("");
			
	    });
		
		$('body').on('click', '#btn_search', function(event) {		
	    	obj.reloadDataTableExploradorVenta();
	   });
		
	    $('body').on('click', '.btnVerDetVenta', function() {
			var boton=$(this);
			var codDet=boton.attr( "attr-user" );
			$("#idAlmacen").val(codDet);	
			$('#VerDet').val(codDet);
			$.ajax({
				url : "/SistemaFE/registroventa/MostrarDetalle/",
				type : "POST",
				data : {"codDet":codDet},  
				dataType : "json",
				beforeSend : function() { },
				success : function(data) {
					if (data.msg == "ok") {	
						obj.listarProductoVenta();
						$('#frmmodalMostrarDetalle').modal({backdrop: 'static', keyboard: false})
					}			
				},
				error : function(xhr, statusText, errorThrown) {
					console.log("ocurrio un error");  
				}
			});	
		});
	
		$('body').on('click', '.delete', function() {
		var boton=$(this);
		var codVta=boton.attr( "attr-user" );
		var nrodoc=boton.attr( "attr-nrodoc" );
		var serie=boton.attr( "attr-serie" );
		bootbox.confirm("<label class='text-danger'>¿Esta seguro que desea Anular la venta:</label>"+' '+serie+'-'+nrodoc+" <label class='text-danger'>?</label>",function(res){
			if (res) {
				
				$.ajax({
					url : "/SistemaFE/registroventa/AnularVenta/",
					type : "POST",
					data : {"codVta":codVta
	//					,"serie":serie,"nrodoc":nrodoc
						},
					dataType : "json",
					beforeSend : function() {
	//$('#btnProccess').ladda().ladda('start');
					},
					success : function(data) {
						if (data.msg == "ok") {
							bootbox.alert({
				                size: null,
				                title: null,
				                message: "<label class='text-danger'>Se Anulo la venta :</label>"+' '+serie+'-'+nrodoc,
				                callback: function () {
				                	location.href = "/SistemaFE/registroventa/exploradorventa";
				                }
				            });
						}else{
							alert("Esta enviado a sunat");
						}
					},
					error : function(xhr, statusText, errorThrown) {
						console.log("ocurrio un error");  
					}
				});
				
			}
		});
	});
		
		$('body').on('click', '.baja', function() {
			var boton=$(this);
			var idVta=boton.attr( "attr-idVta" );
			var nrodoc=boton.attr( "attr-nrodoc" );
			var serie=boton.attr( "attr-serie" );
			bootbox.confirm("<label class='text-danger'>¿Esta seguro que desea Dar de Baja el comprobante:</label>"+' '+serie+'-'+nrodoc+" <label class='text-danger'>?</label>",function(res){
				if (res) {
					
					$.ajax({
						url : "/SistemaFE/registroventa/DarBaja/",
						type : "POST",
						data : {"idVta":idVta
	//						,"serie":serie,"nrodoc":nrodoc
							},
						dataType : "json",
						beforeSend : function() {
						},
						success : function(data) {
							if (data.msg == "ok") {
								bootbox.alert({
					                size: null,
					                title: null,
					                message: "<label class='text-danger'>Se dio de Baja el comprobante :</label>"+' '+serie+'-'+nrodoc,
					                callback: function () {
					                	location.href = "/SistemaFE/registroventa/exploradorventa";
					                }
					            });
							} else if (data.msg == "tiempo") {
								bootbox.alert({
					                size: null,
					                title: null,
					                message: "<label class='text-danger'>Fuera de Tiempo de baja :</label>"+' '+serie+'-'+nrodoc,
					                callback: function () {
					                	location.href = "/SistemaFE/registroventa/exploradorventa";
					                }
					            });
							}else{
								bootbox.alert({
					                size: null,
					                title: null,
					                message: "<label class='text-danger'>error</label>",
					                callback: function () {
					                	location.href = "/SistemaFE/registroventa/exploradorventa";
					                }
					            });
							}
						},
						error : function(xhr, statusText, errorThrown) {
							console.log("ocurrio un error");  
						}
					});
					
				}
			});
		});
	
	    
		//funciones para descargar archivos del servidor
		$('body').on('click', '.dPDF', function(event) {
			var idVenta=$(this).attr( "attr-idVenta" );
			obj.imprimirPDF("/SistemaFE/registroventa/verPDF?idVenta="+idVenta);
			//location.href="/SistemaFE/registroventa/download?file="+urlFile+"&tipo="+tipoFile;	
	    });
	
		//funcion para el modificar trae grilla detlle por ID y Serie
		if($("#idAlmacen").val()!=""){		
			$("#labelTipCambio").show();	
			$("#comboTipCambio").hide();
			$('#listaCatDetComp').val($('#idTipCP').val()).trigger('change');
			var idCliente = $("#idCliente").val();
			var idVendedor = $("#idVendedor").val();
			$("#filtrarClienteNroC").val($("#idCliente").val());
			$("#filtrarClienteNroC").val(idCliente).trigger("change");
			$("#filtrarVendedorNroV").val(idVendedor).trigger("change");
		    var nombre=$('#filtrarVendedorNroV').find(":selected").attr('attr-nombre');
		    $("#filtrarVendedorNombre").val(nombre);
		    var nombre=$('#filtrarClienteNroC').find(":selected").attr('attr-nombre');
		    var dirrecion=$('#filtrarClienteNroC').find(":selected").attr('attr-direccion');
		    $("#filtrarClienteRazonSocialCliente").val(nombre); 
		    $("#filtrarClienteDireccion").val(dirrecion); 
			$('#listaCatDetPeriod').val($('#idPeriodo').val()).trigger('change');
			$('#listaCatDetSucursal').val($('#idSucursal').val()).trigger('change');
			$('#listaCatDetMoneda').val($('#idMone').val()).trigger('change');
			$('#listaFormaPago').val($('#idFormaPago').val()).trigger('change');
			$('#listaCatDetIndicador').val($('#idIndi').val()).trigger('change');
			$('#listaCatDetIndicadortipo').val($('#idIndiTip').val()).trigger('change');
			$('#idFecVenc').show();
			$('#frmMovVentaFecMov').val($("#idFecMov").val());
			$('#frmMovVentaFecCad').val($("#idFecVencimiento").val());
			
			if ($("#idFecMov").val() != $("#idFecVencimiento").val()){
				$("#idFecVenc").show();
			} else {
				$("#idFecVenc").hide();
			}
			
			$("#listaEjercicioVenta").attr("disabled", true);
			$("#listaCatDetPeriod").attr("disabled", true);
			$("#listaCatDetSucursal").attr("disabled", true);
			$("#listAlmacenVenta").attr("disabled", true);
			$("#listaCatDetMoneda").attr("disabled", true);
			$("#listaCatDetComp").attr("disabled", true);
			$("#frmMovVentaSerie").attr("disabled", true);
			$("#frmMovVentaNroComprobante").attr("disabled", true);
	
			this.listarProductoVenta();
		}else{
			
			$("#labelTipCambio").hide();
			$("#comboTipCambio").show();
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
					$('#modalTipoCambio').modal({backdrop: 'static', keyboard: false})
				}
			}
			//Tipo de Documento
			  $('#filtrarClienteNroC').val('').trigger('change');
	//	      $('#filtrarVendedorNroV').val('').trigger('change');
			  $( "#listaCatDetComp" ).change(function() {
	//		    	$.ajax({
	//		    		url : "/SistemaFE/registroventa/consultaSerieNro/",
	//		    		type : "POST",
	//		    		data : {
	//		    			"idTipoDoc": $("#listaCatDetComp").val(),
	//		    			"sucur": $("#listaCatDetSucursal").val()
	//		    			},
	//		    		dataType : "json",
	//		    		beforeSend : function() {},
	//		    		success : function(data) {
	//		    			if (data.msg == "ok") {
	//		    				$('#frmMovVentaSerie').val(data.serie);
	//		    				$('#frmMovVentaNroComprobante').val(data.nro);
	//		    			}else {
	//		    				$('#frmMovVentaSerie').val('');
	//		    				$('#frmMovVentaNroComprobante').val('0');
	//		    			}
	//		    		},
	//		    		error : function(xhr, statusText, errorThrown) {
	//		    			console.log("ocurrio un error");  
	//		    		}
	//		    	});
				  obj.loadSerie();
				});
	//		  $( "#listaCatDetComp" ).val('01').trigger( "change" );
			console.log("No es modificar");
			if($("#VerDet").val()=="" && $("#EditDet").val()==""){	
				this.listarProductoVenta()
			}
			    
		}
		
	//	
	
		
	/*EN PROCESO DE DESARROLLO EDITAR VENTA*/
		
		$('body').on('click', '.editar', function() {
			var boton=$(this);
			var nomUser=boton.attr( "attr-usuario" );
			var codDet=boton.attr( "attr-user" );
			var nrodoc=boton.attr( "attr-nrodoc" );
			var serie=boton.attr( "attr-serie" );
			bootbox.confirm("<label class='text-danger'>¿Esta seguro que desea modificar la venta</label>"+' '+serie+'-'+nrodoc+
					"<label class='text-danger'>?</label>",function(res){
	//		bootbox.confirm("<label class='text-danger'>¿Esta seguro que desea modificar usuario?:</label>"+' '+nomUser,function(res){
				if (res) {
					location.href="/SistemaFE/registroventa/EditarVenta?codDet="+codDet;
				}
			});
	    	
		}); 
		
	    //registro de venta
	  $('body').on('click', '#btnProccess', function() {
		  var vistaPrevia = "0";
		  $("#idVistaPrevia").val(vistaPrevia);
	//		var l = Ladda.create(this);
	//	 	l.start(); 
		if($("#idAlmacen").val()==""){	
	  	  obj.registrar(this);
		}else{
	//		l.stop();
	//		$("#tips").hide();
			obj.updateVenta(this);
	   }    
		 }); 
		
	//  $('body').on('click', '#btnVistaPrevia', function() {
	//	  var vistaPrevia = "1";
	//	  $("#idVistaPrevia").val(vistaPrevia);
	//	  obj.registrar(this);   
	//	 }); 
		
	    
	    /*************************************************************/
	    /****************ARRIBA PARTE EXPLORADOR**********************/     
	    //seteando las monedas y tipo de cambio
	    $('#listaCatDetMoneda').val('1');
	    
	    $("#frmDatosClienteVendedor").validate({
			rules: {
				filtrarClienteNroC: {
	                required: true
	            },
	            filtrarClienteRazonSocialCliente: {
	                required: true
	            },
	            filtrarVendedorNroV: {
	                required: true
	            },
	            filtrarVendedorNombre: {
	            	required: true
	
	            },
	            frmMovVentaOrdenCompra: {
	//            	required: true
	
	            },
	            frmMovVentaguia: {
	//            	required: true
	
	            }
	        }
		});
	    
	    $("#frmEditarVenta").validate({
			rules: {
				frmEditarCompraCant: {
	                required: true,
	                number : true 
	            },
	            frmEditarValorVunit: {
	                required: true,
	                number: true
	            },
	            frmEditarVentaIGV: {
	                required: true
	            },
	            frmEditarVentaPrecUn: {
	            	required: true,
	            	number : true
	
	            }
	        }
		});
	    
		
	    $("#frm_insert_producto").validate({
			rules: {
				listaProducto: {
	                required: true
	            },
	            listaUniMedida: {
	                required: true
	            },
	            listaPrecio: {
	                required: true
	            },
	            frmCantidad: {
	            	required: true,
	            	number : true
	
	            }
	        }
		});
	    
	    
	    $("#frm_insert_servicio").validate({
			rules: {
				listaServicio: {
	                required: true
	            },
	            listaUniMedidas: {
	                required: true
	            },
	            listaPrecios: {
	                required: true
	            },
	            frmCantidads: {
	                required: true,
	                number : true
	            }
	        }
		});
	    
	    $('#filtrarVendedorNroV').change(function(){
	    	var nombre=$('#filtrarVendedorNroV').find(":selected").attr('attr-nombre');
	    	$("#filtrarVendedorNombre").val(nombre); 
	    })
	    
	    $('#filtrarClienteNroC').change(function(){
	    	var nombre=$('#filtrarClienteNroC').find(":selected").attr('attr-nombre');
	    	var dirrecion=$('#filtrarClienteNroC').find(":selected").attr('attr-direccion');
	    	$("#filtrarClienteRazonSocialCliente").val(nombre); 
	    	$("#filtrarClienteDireccion").val(dirrecion); 
	    })
	    
	    
	//	//mostrar y ocultar boton	
		$('.ocultarboton').change(function(){
		if(!$(this).prop('checked')){
		$('#dvOcultar').show();
		 }else{
		$('#dvOcultar').hide();
		 }													  
		 })		
		 
		 
		//mostrar modal de forma de pago 
		 
	//
	//	 $("#DropDownList1").change(function () {
	//		 var val=$("#DropDownList1").val();
	//		  selection = $(this).val();
	//		       if (selection != 4) {
	//		    	   fecha.setDate(fecha.getDate() + 7); 
	//		 		  $("#frmMovVentaFecVenc").datepicker("setDate", fecha);
	//		       }
	//			}
	//		       
	
		
		 $("#listaFormaPago").change(function () {
			 var val=$("#listaFormaPago").val();
			 if( val != "undefined" && val=='2' || val=='3'){
				 $('#modalFormaPago').modal('show'); 
				 $("#dias").val("");
			 }	else  if(val=='4' || val=='5'|| val=='6'|| val=='7'){
					var shortName=$('#listaFormaPago').find(":selected").attr('atrr-shortName');
					$("#dias").val(shortName);
			 }	
			 
			});  
	    
		   $('#reportrange').daterangepicker({
			singleDatePicker :0,
		    ranges: {
		       'Nª Dias': [moment(), moment()],
		       '15 Dias': [moment().add(14, 'days'), moment()],
		       '30 Dias': [moment().add(29, 'days'), moment()],
		       '60 Dias': [moment().add(59, 'days'), moment()],
		       '90 Dias': [moment().add(89, 'days'), moment()],
				}
			});
		
		//calcular diferencia de fechas
		
		  $("#frmMovVentaFecEmic").change(function () {
			  if($("#frmMovVentaFecEmic").val()!="" && $("#frmMovVentaFecPago").val()!=""){
				  var fechInicial=moment($("#frmMovVentaFecEmic").val());
				  var fechFinal=moment($("#frmMovVentaFecPago").val());
				  var dias=fechFinal.diff(fechInicial,"days");
				  $("#frmdias").val(dias);
			  }
				       
		  });
		  
		  $("#frmMovVentaFecPago").change(function () {
			  if($("#frmMovVentaFecEmic").val()!="" && $("#frmMovVentaFecPago").val()!=""){
				  var fechInicial=moment($("#frmMovVentaFecEmic").val());
				  var fechFinal=moment($("#frmMovVentaFecPago").val());
				  var dias=fechFinal.diff(fechInicial,"days");
				  $("#frmdias").val(dias);
			  }
		  });
		  
		  $('body').on('click', '#CrearVendedor', function() {
					 $('#modalVendedor').modal('show');		 
		  });
		 
		 $('body').on('click', '#AgrProducto', function() {
				 $('#modalLstProducto').modal('show');
				 $( "#frm_insert_producto" ).validate().resetForm();		
		 }); 
		 
		 $( "#modalLstProducto" ).on('shown.bs.modal', function(){
			 $( "#frm_insert_producto" ).validate().resetForm();
		 });
		 
		 $('body').on(	'click', '#frmAgregarProducto', function() {
			 var StockInicial=$("#frmStock").val();
			 var descuentoCantidad=$("#frmCantidad").val();	
			 
//			 if($("#frmStock").val()==""){
//				}else{
					
//				}
					
			 
			   //Comentado CWA-603 
			  //if(parseFloat(StockInicial)<parseFloat(descuentoCantidad)){
			  //bootbox.alert("<label class='text-danger'> La cantidad es mayor al Stock!</label>");	 
             //}	
			 if(obj.idProducto==0){			 
				 obj.idProducto= 1;
			 }else{
				 obj.idProducto=obj.idProducto+1; 
			 }	 
			 var newPrecio=$("#frmPrecioNuevo").val();
			 var codPrecio=$("#listaPrecio").val();
			 if(codPrecio!=""){
				 var l = Ladda.create(this);
				 var codProducto=$("#listaProducto").val();
				 var codAlmacen=$("#listaUniMedida").val();
				 var codPrecio=$("#listaPrecio").val().toLowerCase();
				 var cantidad=$("#frmCantidad").val();
				 var observacion=$("#frmMovVentaObsProd").val();
				 var indicadorAfecto=$("#listaCatDetIndicador").val();
				 var monedaDestino=$("#listaCatDetMoneda").val();
	             var listaTipCambio=$("#listaTipCambio").find(":selected").attr("attr-venta");			 
	             var trans=$('#movVentTitgrat').is(':checked')?"SI":"NO";
	             
	             var editCant=$("#frmEditarVentaCant").val();
	    		 var editValorVentUn=$("#frmEditarVentaValorVunit").val();
	    		 var editventIGV=$("#frmEditarVentaIGV").val();
	    		 var editVentPrecUn=$("#frmEditarVentaPrecUn").val();
	//    		 var editObsv=$("#frmEditarVentaObserv").val();
	                         
	             
			 if($("#frm_insert_producto").valid()){
				 $.ajax({
						url : "/SistemaFE/registroventa/InsertGrillaProducto/",
						type : "POST",
						data : {"codProducto":codProducto,"codAlmacen":codAlmacen,
							"codPrecio":codPrecio,"cantidad":cantidad,"idProd":obj.idProducto,"indicadorAfecto":indicadorAfecto,"monedaDestino":monedaDestino,"listaTipCambio":listaTipCambio,"observacion":observacion,"trans":trans,"editValorVentUn":editValorVentUn,"editventIGV":editventIGV,"editVentPrecUn":editVentPrecUn,"editCant":editCant},
						dataType : "json",
						beforeSend : function() {
							l.start();
						},
						success : function(data) {
							if (data.msg == "ok") {
									l.stop();
								    $('#lstProductoVenta').DataTable().rows.add(data.datos);	
							        $('#lstProductoVenta').DataTable().draw();
							        obj.CalcularTipCambGrilla();
                                    $("#frmStock").css({"background":"#FFFFFF"}); 
//							        obj.calculaValor();
								}else if (data.msg == "tipocambio") { 
									bootbox.alert("<label class='text-danger'>ALERTA : <br> Debe registrar el Tipo de cambio para realizar esta operación</label>");
									l.stop();
								}	else{
								obj.idProducto=obj.idProducto-1;
								bootbox.alert("<label class='text-danger'>ERROR : <br> Se produjo un error interno en los servicios</label>");
								l.stop();
							}
						},
						error : function(xhr, statusText, errorThrown) {
							console.log("ocurrio un error");  
						}
					});
			 }
			 
			 }else
			 if(newPrecio!=""){
				 var l = Ladda.create(this);
				 var codProducto=$("#listaProducto").val();
				 var codAlmacen=$("#listaUniMedida").val();
	//			 var codPrecio=$("#listaPrecio").val("1");
				 var newPrecio=$("#frmPrecioNuevo").val();
				 var cantidad=$("#frmCantidad").val();
				 
				 var observacion=$("#frmMovVentaObsProd").val();
				 var indicadorAfecto=$("#listaCatDetIndicador").val();
				 var monedaDestino=$("#listaCatDetMoneda").val();
	             var listaTipCambio=$("#listaTipCambio").find(":selected").attr("attr-venta");				 
	             var trans=$('#movVentTitgrat').is(':checked')?"SI":"NO";
				 
				 if($("#frm_insert_producto").valid()){
					 $.ajax({
							url : "/SistemaFE/registroventa/InsertGrillaProducto/",
							type : "POST",
							data : {"codProducto":codProducto,"codAlmacen":codAlmacen,
								"newPrecio":newPrecio,"cantidad":cantidad,"idProd":obj.idProducto,"indicadorAfecto":indicadorAfecto,"monedaDestino":monedaDestino,"listaTipCambio":listaTipCambio,"observacion":observacion,"trans":trans},
							dataType : "json",
							beforeSend : function() {
								l.start();
							},
							success : function(data) {
								if (data.msg == "ok") {
										l.stop();
									    $('#lstProductoVenta').DataTable().rows.add(data.datos);	
								        $('#lstProductoVenta').DataTable().draw();
								        obj.CalcularTipCambGrilla();
                                        $("#frmStock").css({"background":"#FFFFFF"}); 
//								        obj.calculaValor();			
								}else if (data.msg == "tipocambio") { 
									l.stop();
									bootbox.alert("<label class='text-danger'>ALERTA : <br> Debe registrar el Tipo de cambio para realizar esta operación</label>");
								}else{
									obj.idProducto=obj.idProducto-1;
									bootbox.alert("<label class='text-danger'>ERROR : <br> Se produjo un error interno en los servicios</label>");
									l.stop();
								}
							},
							error : function(xhr, statusText, errorThrown) {
								console.log("ocurrio un error");  
							}
						});
				 }
				 
			 }		 	 
		 	 $("#frm_insert_producto").trigger("reset");
		 	 $("#listaCatDetIndicador").attr("disabled",true);
			 $("#listaCatDetIndicadortipo").attr("disabled",true);	
			 $('#nuevoPrecio').hide();
			 $('#listaUniMedida').removeAttr("readonly");
			 $('#listaPrecio').removeAttr("disabled");
			 $("#listaProducto").trigger("reset");
			 $('#listaProducto').trigger('change.select2');
				$('#frmCantidad').val("");	
				$('#listaPrecio').val("");
				$('#listaUniMedida').val("");
				$('#frmStock').val("");	
				$('#listaProducto').trigger("reset");
		 });
		 $("#listaProducto").change(function() {
			 var codProd=$("#listaProducto").val();
				$.ajax({
					url : "/SistemaFE/registroventa/listarUnidadMedida/",
					type : "POST",
					data : {"codProd":codProd},
					dataType : "json",
					beforeSend : function() {
						$("#listaUniMedida").val("");
						$("#listaPrecio").val("");
						$("#listaUniMedida").attr("disabled",true);
					},
					success : function(data) {
						if (data.msg == "ok") {
							var template = $("#cboMasterPres").html();
	                        var content = $("#listaUniMedida").empty();
	                        var html = Mustache.render(template, data);
	                        content.html(html);
	                        $("#listaUniMedida").attr("disabled",false);
	//                        if(data.toption.length==1){
	                        	$("#listaUniMedida option[value='remover1']").remove();
	                        	$("#listaUniMedida").val(data.toption[0].id).change();
	                        	
	                        	$("#listaUniMedida").attr('readonly', true);
	//                        }
						}else{
							bootbox.alert("<label class='text-danger'>ERROR : <br> Se produjo un error interno en los servicios</label>");
						}
					},
					error : function(xhr, statusText, errorThrown) {
						console.log("ocurrio un error");  
					}
				});
		 });
		 
		 $('#listaUniMedida').change(function(){
				var id=$('#listaUniMedida').find(":selected").val();
				var stocks=$('#listaUniMedida').find(":selected").attr('attr-stock');			
				$("#frmStock").val(stocks);
				var str = stocks.toString();
				var res2 = str.substring(0, 1);
				
				if(res2 != null && res2 =="-"){
					 $("#frmStock").css({"background":"#FCA7A0"}); 
				}else if(res2 != null && res2 !="-"){
					 $("#frmStock").css({"background":"#7AADF6"}); 
				}
				
				
				$("#frmStock").attr("disabled",true);			
		  }) 
		 
		  
		  
		 $('#frmEditarPrecio').click(function() {
			  if (!$(this).is(':checked')) {
				  $("#listaPrecio").attr("disabled",false);
					 $("#frmPrecioNuevo").attr("disabled",true);
					 $("#frmPrecioNuevo").val("");
					 $("#nuevoPrecio").hide();
			  }else{
				  $("#listaPrecio").attr("disabled",true);
					 $("#frmPrecioNuevo").attr("disabled",false);
					 $("#listaPrecio").val("");
					 $("#nuevoPrecio").show();
			  }
			});
		 
		 $('#frmEditarPrecioServicio').click(function() {
			  if (!$(this).is(':checked')) {
				  $("#listaPrecios").attr("disabled",false);
					 $("#frmPrecioNuevoServicio").attr("disabled",true);
					 $("#frmPrecioNuevoServicio").val("");
					 $("#nuevoPrecioSer").hide();
			  }else{
				  $("#listaPrecios").attr("disabled",true);
					 $("#frmPrecioNuevoServicio").attr("disabled",false);
					 $("#listaPrecios").val("");
					 $("#nuevoPrecioSer").show();
			  }
			});
		  
		 
		 $("#listaUniMedida").change(function() {
			 var codAlmacen=$("#listaUniMedida").val();
				$.ajax({
					url : "/SistemaFE/registroventa/listarPrecio/",
					type : "POST",
					data : {"codAlmacen":codAlmacen},
					dataType : "json",
					beforeSend : function() {
						$("#listaPrecio").val("");
						$("#listaPrecio").attr("disabled",true);
					},
					success : function(data) {
						if (data.msg == "ok") {
							var template = $("#cboMasterP").html();
	                        var content = $("#listaPrecio").empty();
	                        var html = Mustache.render(template, data);
	                        content.html(html);
	                        $("#listaPrecio").attr("disabled",false);
	//                        if(data.toption.length==1){
	                        	$("#listaPrecio option[value='remover1']").remove();
	                        	$("#listaPrecio").val(data.toption[0].id).change();
	                        	$("#listaPrecio").attr('readonly', true);
	//                        }
						}else{
							bootbox.alert("<label class='text-danger'>ERROR : <br> Se produjo un error interno en los servicios</label>");
						}
					},
					error : function(xhr, statusText, errorThrown) {
						console.log("ocurrio un error");  
					}
				});
		 });
		 
	
		 $('body').on('click', '#AgrServicio', function() {
				 $('#modalLstServicio').modal('show');
				 $( "#frm_insert_servicio" ).validate().resetForm();
		 }); 
		 
		 $( "#modalLstServicio" ).on('shown.bs.modal', function(){
			 $( "#frm_insert_servicio" ).validate().resetForm();
		 });
		 
		$('body').on('click', '#TerminarInsertProd', function(event) {
			$("#frm_insert_producto").trigger("reset");
			$("#frm_insert_servicio").trigger("reset");
			$('#listaProducto').val("");
			$('#nuevoPrecio').hide();
			$('#nuevoPrecioSer').hide();
			$('#frmCantidad').val("");	
			$('#listaPrecio').val("");
			$('#listaPrecios').val("");
			$('#listaUniMedida').val("");
			$('#listaUniMedidas').val("");
			$('#frmStock').val("");	
			$('#listaUniMedida').trigger("reset");
			$('#listaProducto').trigger('change.select2');
			$('#listaServicio').trigger('change.select2');
			$('#listaUniMedida').removeAttr("readonly");
			$('#listaUniMedidas').removeAttr("readonly");
			$('#listaPrecio').removeAttr("disabled");
			$('#listaPrecios').removeAttr("disabled");
            $("#frmStock").css({"background":"#FFFFFF"});
	    }); 
		 
			 $('body').on(	'click', '#frmAgregarServicio', function() {
				 
				 if(obj.idProducto==0){
					 obj.idProducto= 1;
				 }else{
					 obj.idProducto=obj.idProducto+1; 
				 }
				 
				 var newPrecio=$("#frmPrecioNuevoServicio").val();
				 var codPrecio=$("#listaPrecios").val();
				 if(codPrecio!=""){
				 var l = Ladda.create(this);
				 var codProducto=$("#listaServicio").val();
				 var codAlmacen=$("#listaUniMedidas").val();
				 var codPrecio=$("#listaPrecios").val();
				 var cantidad=$("#frmCantidads").val();
				 var observacion=$("#frmMovVentaObsServ").val();
				 var indicadorAfecto=$("#listaCatDetIndicador").val();
				 var monedaDestino=$("#listaCatDetMoneda").val();
	//			 var listaTipCambio=$("#listaTipCambio").val().split("-")[1];
				 var listaTipCambio=$("#listaTipCambio").find(":selected").attr("attr-venta");
				 var trans=$('#movVentTitgrat').is(':checked')?"SI":"NO";
				 if($("#frm_insert_servicio").valid()){
					 $.ajax({
							url : "/SistemaFE/registroventa/InsertGrillaServicio/",
							type : "POST",
							data : {"codProducto":codProducto,"codAlmacen":codAlmacen,
								"codPrecio":codPrecio,"cantidad":cantidad,"idProd":obj.idProducto,"indicadorAfecto":indicadorAfecto,"monedaDestino":monedaDestino,"listaTipCambio":listaTipCambio,"observacion":observacion,"trans":trans},
							dataType : "json",
							beforeSend : function() {
								l.start();
							},
							success : function(data) {
								if (data.msg == "ok") {
									l.stop();
							        $('#lstProductoVenta').DataTable().rows.add(data.datos);
							        $('#lstProductoVenta').DataTable().draw();
							        obj.CalcularTipCambGrilla();
//							        obj.calculaValor();
								}else if (data.msg == "tipocambio") { 
									bootbox.alert("<label class='text-danger'>ALERTA : <br> Debe registrar el Tipo de cambio para realizar esta operación</label>");
									l.stop();
								}else{ 
									obj.idProducto=obj.idProducto+1;
									bootbox.alert("<label class='text-danger'>ERROR : <br> Se produjo un error interno en los servicios</label>");
									l.stop();
								}
							},
							error : function(xhr, statusText, errorThrown) {
								console.log("ocurrio un error");  
							}
						});
				 
				 }
				 }else 
					 if(newPrecio!=""){
					 var l = Ladda.create(this);
					 var codProducto=$("#listaServicio").val();
					 var codAlmacen=$("#listaUniMedidas").val();
					 var newPrecio=$("#frmPrecioNuevoServicio").val();
					 var cantidad=$("#frmCantidads").val();
					 var observacion=$("#frmMovVentaObsServ").val();
					 var indicadorAfecto=$("#listaCatDetIndicador").val();
					 var monedaDestino=$("#listaCatDetMoneda").val();
	//				 var listaTipCambio=$("#listaTipCambio").val().split("-")[1];
					 var listaTipCambio=$("#listaTipCambio").find(":selected").attr("attr-venta");
					 var trans=$('#movVentTitgrat').is(':checked')?"SI":"NO";
					 if($("#frm_insert_servicio").valid()){
						 $.ajax({
								url : "/SistemaFE/registroventa/InsertGrillaServicio/",
								type : "POST",
								data : {"codProducto":codProducto,"codAlmacen":codAlmacen,
									"newPrecio":newPrecio,"cantidad":cantidad,"idProd":obj.idProducto,"indicadorAfecto":indicadorAfecto,"monedaDestino":monedaDestino,"listaTipCambio":listaTipCambio,"observacion":observacion,"trans":trans},
								dataType : "json",
								beforeSend : function() {
									l.start();
								},
								success : function(data) {
									if (data.msg == "ok") {
										l.stop();
								        $('#lstProductoVenta').DataTable().rows.add(data.datos);
								        $('#lstProductoVenta').DataTable().draw();
								        obj.CalcularTipCambGrilla();
//								        obj.calculaValor();
									}else if (data.msg == "tipocambio") { 
										bootbox.alert("<label class='text-danger'>ALERTA : <br> Debe registrar el Tipo de cambio para realizar esta operación</label>");
										l.stop();
									}else{ 
										obj.idProducto=obj.idProducto+1;
										bootbox.alert("<label class='text-danger'>ERROR : <br> Se produjo un error interno en los servicios</label>");
										l.stop();
									}
								},
								error : function(xhr, statusText, errorThrown) {
									console.log("ocurrio un error");  
								}
							});
					 
					 } 
				 }
		 $("#frm_insert_servicio").trigger("reset");
	 	 $("#listaCatDetIndicador").attr("disabled",true);
		 $("#listaCatDetIndicadortipo").attr("disabled",true);
		 $('#nuevoPrecioSer').hide();
		 $('#listaUniMedidas').removeAttr("readonly");
		 $('#listaPrecios').removeAttr("disabled");
		 $('#listaServicio').trigger('change.select2');
					$('#frmPrecioNuevoServicio').val("");	
					$('#listaPrecios').val("");
					$('#listaUniMedidas').val("");
					$('#frmCantidads').val("");	
					$('#listaServicio').trigger("reset");
			 });
		 
		 
		 
		 
		 $("#listaServicio").change(function() {
			 var codProd=$("#listaServicio").val();
				$.ajax({
					url : "/SistemaFE/registroventa/listarUnidadMedidaS/",
					type : "POST",
					data : {"codProd":codProd},
					dataType : "json",
					beforeSend : function() {
						$("#listaUniMedidas").val("");
						$("#listaPrecios").val("");
						$("#listaUniMedidas").attr("disabled",true);
					},
					success : function(data) {
						if (data.msg == "ok") {
							var template = $("#cboMaster").html();
	                        var content = $("#listaUniMedidas").empty();
	                        var html = Mustache.render(template, data);
	                        content.html(html);
	                        $("#listaUniMedidas").attr("disabled",false);
	                        if(data.toption.length==1){
	                        	$("#listaUniMedidas option[value='remover1']").remove();
	                        	$("#listaUniMedidas").val(data.toption[0].id).change();
	                        	
	                        	$("#listaUniMedidas").attr('readonly', true);
	                        }
						}else{
							bootbox.alert("<label class='text-danger'>ERROR : <br> Se produjo un error interno en los servicios</label>");
						}
					},
					error : function(xhr, statusText, errorThrown) {
						console.log("ocurrio un error");  
					}
				});
		 });
		 
		 $("#listaUniMedidas").change(function() {
			 var codAlmacen=$("#listaUniMedidas").val();
			 $.ajax({
					url : "/SistemaFE/registroventa/listarPrecio/",
					type : "POST",
					data : {"codAlmacen":codAlmacen},
					dataType : "json",
					beforeSend : function() {
						$("#listaPrecios").val("");
						$("#listaPrecios").attr("disabled",true);
					},
					success : function(data) {
						if (data.msg == "ok") {
							var template = $("#cboMasterP").html();
	                        var content = $("#listaPrecios").empty();
	                        var html = Mustache.render(template, data);
	                        content.html(html);
	                        $("#listaPrecios").attr("disabled",false);
	//                        if(data.toption.length==1){
	                        	$("#listaPrecios option[value='remover1']").remove();
	                        	$("#listaPrecios").val(data.toption[0].id).change();
	                        	$("#listaPrecios").attr('readonly', true);
	//                        }
						}else{
							bootbox.alert("<label class='text-danger'>ERROR : <br> Se produjo un error interno en los servicios</label>");
						}
					},
					error : function(xhr, statusText, errorThrown) {
						console.log("ocurrio un error");  
					}
				});
		 });
		 
		 $("#listaCatDetSucursal").change(function() {
			 var codia=$("#listaCatDetSucursal").val();
			 if(codia!=""){
			 var ctia =$("#listaCatDetIndicadortipo").val();
			 var tia =$("#dataFacIndicadorAfTipo").val();
				$.ajax({
					url : "/SistemaFE/registroventa/listarAlmacen/",
					type : "POST",
					data : {"codIa":codia},
					dataType : "json",
					beforeSend : function() {
					},
					success : function(data) {
						if (data.msg == "ok") {
							var template = $("#cboMasterAlmacen").html();
	                        var content = $("#listAlmacenVenta").empty();
	                        var html = Mustache.render(template, data);
	                        content.html(html);
						}else{
							bootbox.alert("<label class='text-danger'>ERROR : <br> Se produjo un error interno en los servicios</label>");
						}
					},
					error : function(xhr, statusText, errorThrown) {
						console.log("ocurrio un error");  
					}
				});
				if($("#listaCatDetSucursal").val()!="" && $("#listaCatDetComp").val()){
				 	obj.loadSerie();
				 }
				obj.codigoRegistro();
				
			 } else {
				 bootbox.alert({
			            size: null,
			            title: null,
			            message: "<label class='text-danger'>El usuario no esta asignado a alguna sucursal</label>"
			        });
			 }
		 });
		 
		 
		 $("#listaCatDetComp").change(function() {
			 if($("#listaCatDetSucursal").val()!="" && $("#listaCatDetComp").val()){
				 	obj.loadSerie();
				 }
		 });
	
		 
		 $("#listSerieVenta").change(function() {
			 var codSerie=$("#listSerieVenta").val();
				$.ajax({
					url : "/SistemaFE/registroventa/listarSerienro/",
					type : "POST",
					data : {"codSerie":codSerie},
					dataType : "json",
					beforeSend : function() {},
					success : function(data) {
						if (data.msg == "ok") {
							var obj=JSON.parse(data.Campos_Nro);						
							$("#frmMovVentaNroComprobante").val(obj.numeroSerie);
						}
					},
					error : function(xhr, statusText, errorThrown) {
						console.log("ocurrio un error");  
					}
				});
		
			});
		 
		 $("#listaCatDetIndicador").change(function() {
			 var codia=$("#listaCatDetIndicador").val();
			 var ctia =$("#listaCatDetIndicadortipo").val();
			 var tia =$("#dataFacIndicadorAfTipo").val();
				$.ajax({
					url : "/SistemaFE/registroventa/listartia/",
					type : "POST",
					data : {"codIa":codia},
					dataType : "json",
					beforeSend : function() {
					},
					success : function(data) {
						if (data.msg == "ok") {
							var template = $("#cboMaster").html();
	                        var content = $("#listaCatDetIndicadortipo").empty();
	                        var html = Mustache.render(template, data);
	                        content.html(html);
	                        if($('#listaCatDetComp').val()== "07" || $('#listaCatDetComp').val() == "08"){
	                   		 if(codia=="10"){
	                   			$("#listaCatDetIndicadortipo").val(tia).trigger('change');
	                   	     }else if(codia=="20"){
	                   			$("#listaCatDetIndicadortipo").val(tia).trigger('change');
	                   	     }else if(codia=="30"){
	                   			$("#listaCatDetIndicadortipo").val(tia).trigger('change');
	                   	     }else if(codia=="40"){
	                   			$("#listaCatDetIndicadortipo").val(tia).trigger('change');
	                   	     }else if(codia=="50"){
	                   			$("#listaCatDetIndicadortipo").val(tia).trigger('change');
	                   	     }
	                   		 
	                        }
	//                        $("#listaCatDetIndicadortipo").attr("disabled",false);
	//                        obj.calculaValor();
						}else{
							bootbox.alert("<label class='text-danger'>ERROR : <br> Se produjo un error interno en los servicios</label>");
						}
					},
					error : function(xhr, statusText, errorThrown) {
						console.log("ocurrio un error");  
					}
				});
		 });
		 
			var symbMoneda = $('#listaCatDetMoneda').find(":selected").attr('attr-sym');
			var symbalterno2 = $('#listaCatDetMoneda option[value="2"]').attr('attr-sym');
			var colorinput = $('#listaCatDetMoneda').find(":selected").attr('attr-color');
			var coloralterno = $('#listaCatDetMoneda option[value="2"]').attr('attr-color');
			$("#simbMonedavtagratuita").val(symbMoneda);
			$("#simbMonedavatot").val(symbMoneda);
			$("#simbMonedades").val(symbMoneda);
			$("#simbMonedatot").val(symbMoneda);
			$("#simbMonedaigv").val(symbMoneda);
			$("#simbMoneda").val(symbMoneda);
			$("#simbMonedas").val(symbMoneda);
			$("#conversion1").val(symbalterno2);
			$("#frmResultadoBIM").css({"background":colorinput});
			$("#frmResultadoExonerado").css({"background":colorinput});
			$("#frmResultadoVentaGratuita").css({"background":colorinput});
			$("#frmResultadoINF").css({"background":colorinput});
			$("#frmResultadoExportacion").css({"background":colorinput});
			$("#frmResultadoValorTotal").css({"background":colorinput});
			$("#frmResultadoImpDescTot").css({"background":colorinput});
			$("#frmResultadoImpDescTot").css({"background":colorinput});
			$("#frmResultadoNeto").css({"background":colorinput});
			$("#frmResultadoIGV").css({"background":colorinput});
			$("#frmResultadoTotalView").css({"background":colorinput});
			$("#frmResultadoTotal").css({"background":colorinput});
			$("#frmResultadoMonto").css({"background":colorinput});
			$("#frmResultadoConver").css({"background":coloralterno});
			
			$('#listaCatDetMoneda').change(function() {
				var symbMoneda = $('#listaCatDetMoneda').find(":selected").attr('attr-sym');
				var symbalterno1 = $('#listaCatDetMoneda option[value="1"]').attr('attr-sym');
				var symbalterno2 = $('#listaCatDetMoneda option[value="2"]').attr('attr-sym');
				var colorinput = $('#listaCatDetMoneda').find(":selected").attr('attr-color');
				var coloralterno1 = $('#listaCatDetMoneda option[value="1"]').attr('attr-color');
				var coloralterno2 = $('#listaCatDetMoneda option[value="2"]').attr('attr-color');
				$("#simbMonedavtagratuita").val(symbMoneda);
				$("#simbMonedavatot").val(symbMoneda);
				$("#simbMonedades").val(symbMoneda);
				$("#simbMonedatot").val(symbMoneda);
				$("#simbMonedaigv").val(symbMoneda);
				$("#simbMoneda").val(symbMoneda);
				$("#simbMonedas").val(symbMoneda);
				$("#conversion1").val(symbalterno2);
				$("#conversion2").val(symbalterno1);
				$("#frmResultadoBIM").css({"background":colorinput});
				$("#frmResultadoExonerado").css({"background":colorinput});
				$("#frmResultadoVentaGratuita").css({"background":colorinput});
				$("#frmResultadoINF").css({"background":colorinput});
				$("#frmResultadoExportacion").css({"background":colorinput});
				$("#frmResultadoValorTotal").css({"background":colorinput});
				$("#frmResultadoImpDescTot").css({"background":colorinput});
				$("#frmResultadoImpDescTot").css({"background":colorinput});
				$("#frmResultadoNeto").css({"background":colorinput});
				$("#frmResultadoIGV").css({"background":colorinput});
				$("#frmResultadoTotalView").css({"background":colorinput});
				$("#frmResultadoTotal").css({"background":colorinput});
				$("#frmResultadoMonto").css({"background":colorinput});
				$("#frmResultadoConver").css({"background":coloralterno1});
				if($('#listaCatDetMoneda').val()!='2'){
					$("#frmResultadoConver").css({"background":coloralterno2});
				}							
			})
		 
		 $(document).on('click', '.btnDeleteVenta', function (){
			 var data = obj.lstDataTableProductoVenta.row( $(this).parents('tr') ).data();
	         var position=obj.lstDataTableProductoVenta.row( $(this).parents('tr') ).index();
	         bootbox.confirm({
	           message: 'Seguro que desea eliminar registro de venta',
	           onEscape: true,
	           buttons: {
	               confirm: {
	                   label: 'Sí',
	                   className: 'btn-primary'
	               },
	               cancel: {
	                   label: 'No',
	                   className: 'btn-default'
	               }
	           },
	           callback: function (result) {
	               if (result) {
	                   if(data["ventPrincipal"]==true){
	                       bootbox.alert({
	                           size: null,
	                           title: null,
	                           message: "No se puede eliminar un registro principal",
	                           onEscape: true
	                       }); 
	                   }else{
	                	   obj.lstDataTableProductoVenta.rows(position).remove().draw();  
	                	   var table = $('#lstProductoVenta').DataTable();               	   
	                	   if ( ! table.data().any() ) {
	                         $('#listaCatDetIndicador').removeAttr("disabled");
	                         $("#listaCatDetIndicadortipo").removeAttr("disabled");
	                	   }
	                   }
	                   obj.calculaValor();
	               }
	           }
	       });
		 });
		 
		 $('body').on('change', '#listaCatDetMoneda', function (){
			 if($('#listaCatDetComp').val()== "07" || $('#listaCatDetComp').val()== "08"){
				 	obj.CalcularTipCambGrillaNota();
				 	obj.calculaValor();
				 	bootbox.alert({
			             size: null,
			             title: null,
			             message: "El cambio de Moneda para NC/ND, no afecta los calculos de la grilla",
			             onEscape: true
			         }); 
				}else {
					obj.CalcularTipCambGrilla();
				}
	
		 });
		 	
		 
		 $('body').on('click', '.btnEditarGrilla', function (){
	        var data = obj.lstDataTableProductoVenta.row( $(this).parents('tr') ).data();
	        var boton=$(this);
	        var product =  $(this).parents("tr").find("td").eq(2).html();
	        var codDet=boton.attr( "attr-codigo" );
	 		var codStore=boton.attr( "attr-idStore" );
			var cantgrilla=$("#cantidadrestar").val(data["cantidad"]);
			var nuevacant=$("#frmEditarVentaCant").val(data["cantidad"]);
			$("#codigo").val(codDet);
			$("#codColum").val(product);
	 		$("#codstore").val(codStore);
	         $("#frmEditarVentaCodComercial").val(data["codigoComercial"]);
	         $("#frmEditarVentaConcepto").val(data["concepto"]);
	         $("#frmEditarVentaUnidadMedida").val(data["UnidadMedida"]);
	         $("#frmEditarVentaCant").val(data["cantidad"]);
	         $("#frmEditarVentaValorVunit").val(data["valorUnitario"]);
	         $("#frmEditarVentaIGV").val(data["igvUnitario"]);        
	         $("#frmEditarVentaPrecUn").val(data["precioUnitario"]);
	         $("#frmEditarVentaObserv").val(data["observacion"]);
	         $("#modalEditGriVent").modal("show");
		 
		 });
		 
		 
		 /*CALCULOS PARA EDITAR PRODUCTOS EN GRILLA*/
			$("#frmEditarVentaCant").change(function() {
				obj.calculoprodeditargrilla(); 
			 });
		  
		  $("#frmEditarVentaValorVunit").change(function() {
			  obj.calculoprodeditargrilla(); 
		   });  
		  $("#frmEditarVentaIGV").change(function() {
				var valorVenta=$("#frmEditarVentaValorVunit").val();
		    	var pVenta=$("#frmEditarVentaPrecUn").val();
		    	var cantidad=$("#frmEditarVentaCant").val();
		    	var precioVenta=0;
		    	var valvta=0;
		            		valvta=parseFloat(valorVenta);
		            		pVentaunit=parseFloat(valvta);
		            		igv=parseFloat(0.00);
		            		$("#frmEditarVentaPrecUn").val(pVentaunit.toFixed(2));
			 });
		  
		  $("#frmEditarVentaPrecUn").change(function() {
				var valorVenta=$("#frmEditarVentaValorVunit").val();
		    	var pVenta=$("#frmEditarVentaPrecUn").val();
		    	var cantidad=$("#frmEditarVentaCant").val();
		    	var precioVenta=0;
		    	var valvta=0;
		    	var igv=0;
		    	var nuevocalculo=0;
		    	if(cantidad==""){
		    		bootbox.alert("<label class='text-danger'>El monto de cantidad es menor al valor establecido! Revisar antes de continuar!</label>");
		    	} else if(parseFloat(pVenta)>0){      		
		            		valvta=parseFloat(pVenta)/1.18;
		            		nuevocalculo=valvta.toFixed(2)
		            		igv=parseFloat(pVenta)-parseFloat(pVenta)/1.18;
		            		$("#frmEditarVentaValorVunit").val(valvta.toFixed(2));
		            		$("#frmEditarVentaIGV").val(igv.toFixed(2));    
		            	}
			 });
		  
		  $('body').on('click', '#GuardarEditarGrilla', function() {		 
				 if(obj.idProducto==0){				 
					 obj.idProducto= 1;
				 }else{
					 obj.idProducto=obj.idProducto+1; 
				 }	 
				 var newPrecio=$("#frmEditarVentaPrecUn").val(); 
				 if(newPrecio!=""){
					 var l = Ladda.create(this);
					 var codNumero=$("#codColum").val();	
					 var codProducto=$("#codigo").val();
					 var codAlmacen=$("#codstore").val();
					 var newPrecio=$("#frmEditarVentaPrecUn").val();
					 var codComercial=$("#frmEditarVentaCodComercial").val();
					 var concepto=$("#frmEditarVentaConcepto").val();
					 var unimedida=$("#frmEditarVentaUnidadMedida").val();
					 var cantidad=$("#frmEditarVentaCant").val();
					 var valorunitarios=$("#frmEditarVentaValorVunit").val();
					 var igvUnitario=$("#frmEditarVentaIGV").val();
					 var precioUnitario=$("#frmEditarVentaPrecUn").val();
					 var observacion=$("#frmEditarVentaObserv").val();				 
	//				 var observacion=$("#frmMovVentaObsServ").val();
					 var indicadorAfecto=$("#listaCatDetIndicador").val();
					 var monedaDestino=$("#listaCatDetMoneda").val();
					 var listaTipCambio=$("#listaTipCambio").find(":selected").attr("attr-venta");
					 var trans=$('#movVentTitgrat').is(':checked')?"SI":"NO";
		             var listaComprobante=$("#listaComprobante").val();	
					if (unimedida=="ZZ"){
						 $.ajax({
								url : "/SistemaFE/registroventa/InsertGrillaServicio/",
								type : "POST",
								data : {"codProducto":codProducto,"codAlmacen":codAlmacen,"concepto":concepto,"unimedida":unimedida,
									"cantidad":cantidad,"valorunitarios":valorunitarios,"igvUnitario":igvUnitario,
									"precioUnitario":precioUnitario,"idProd":obj.idProducto,"observacion":observacion,
									"listaComprobante":listaComprobante,"newPrecio":newPrecio,"indicadorAfecto":indicadorAfecto,
									"monedaDestino":monedaDestino,"listaTipCambio":listaTipCambio,"trans":trans,"codNumero":codNumero},
								dataType : "json",
								beforeSend : function() {
									l.start();
								},
								success : function(data) {
									if (data.msg == "ok") {
										
	//									var datainicial=$("#lstProductoVenta").DataTable().rows().data();
	
										l.stop();
										
									    var datainicial=$("#lstProductoVenta").DataTable().rows().data();
									    var datafinal=[];
		    
									    var i=0;
									    var idMod=$("#codColum").val();
									    for(i=0;i<datainicial.length;i++){
									    	console.log("ver: "+datainicial[i].numero);
									    	if(((i+1)+"")!=idMod){
									    		datafinal.push(datainicial[i]);
									    	}else{
									    		datafinal.push(data.datos[0]);	
									    	}								    	
									    }						    	
									    $("#lstProductoVenta").DataTable().rows().remove()
									    $("#lstProductoVenta").DataTable().rows.add(datafinal).draw();	       
										$('#modalEditGriVent').modal('hide');
										obj.CalcularTipCambGrilla();
//										obj.calculaValor();
									}else if (data.msg == "tipocambio") { 
										bootbox.alert("<label class='text-danger'>ALERTA : <br> Debe registrar el Tipo de cambio para realizar esta operación</label>");
										l.stop();
									}else{ 
										obj.idProducto=obj.idProducto+1;
										bootbox.alert("<label class='text-danger'>ERROR : <br> Se produjo un error interno en los servicios</label>");
										l.stop();
									}
								},
								error : function(xhr, statusText, errorThrown) {
									console.log("ocurrio un error");  
								}
							});
					}else{
					 if($("#frm_insert_producto").valid()){
						 $.ajax({
								url : "/SistemaFE/registroventa/InsertGrillaProducto/",
								type : "POST",
								data : {"codProducto":codProducto,"codAlmacen":codAlmacen,"concepto":concepto,"unimedida":unimedida,
									"cantidad":cantidad,"valorunitarios":valorunitarios,"igvUnitario":igvUnitario,
									"precioUnitario":precioUnitario,"idProd":obj.idProducto,"observacion":observacion,
									"listaComprobante":listaComprobante,"newPrecio":newPrecio,"indicadorAfecto":indicadorAfecto,
									"monedaDestino":monedaDestino,"listaTipCambio":listaTipCambio,"trans":trans,"codNumero":codNumero},
								dataType : "json",
								beforeSend : function() {
									l.start();
								},
								success : function(data) {
									if (data.msg == "ok") {
										
	//									var datainicial=$("#lstProductoVenta").DataTable().rows().data();
	
										l.stop();
										
									    var datainicial=$("#lstProductoVenta").DataTable().rows().data();
									    var datafinal=[];
		    
									    var i=0;
									    var idMod=$("#codColum").val();
									    for(i=0;i<datainicial.length;i++){
									    	console.log("ver: "+datainicial[i].numero);
									    	if(((i+1)+"")!=idMod){
									    		datafinal.push(datainicial[i]);
									    		//$('#lstGrillaCompra').DataTable().rows.add(datainicial[i]);
									    	}else{
	//								    		data.datos["numero"]= Number(data.datos["numero"]);
	//								    		data.datos["codComercial"]= Number(data.datos["codComercial"]);
									    		datafinal.push(data.datos[0]);	
									    	}								    	
									    }						    	
									    $("#lstProductoVenta").DataTable().rows().remove()
									    $("#lstProductoVenta").DataTable().rows.add(datafinal).draw();	       
										$('#modalEditGriVent').modal('hide');
										obj.CalcularTipCambGrilla();
//										obj.calculaValor();
									}else if (data.msg == "tipocambio") { 
										bootbox.alert("<label class='text-danger'>ALERTA : <br> Debe registrar el Tipo de cambio para realizar esta operación</label>");
										l.stop();
									}	
										else{ 
									
										obj.idProducto=obj.idProducto+1;
										bootbox.alert("<label class='text-danger'>ERROR : <br> Se produjo un error interno en los servicios</label>");
										l.stop();
									}
								},
								error : function(xhr, statusText, errorThrown) {
									console.log("ocurrio un error");  
								}
							});
					 
					 } 
					}
				 }
				 
	//		 	 $("#frm_insert_producto").trigger("reset");
			 	 $("#listaCatDetIndicador").attr("disabled",true);
				 $("#listaCatDetIndicadortipo").attr("disabled",true);
					$('#frmEditarVentaCodComercial').val("");	
					$('#frmEditarVentaConcepto').val("");
					$('#frmEditarVentaUnidadMedida').val("");
					$('#frmEditarVentaCant').val("");
					$('#frmEditarVentaValorVunit').val("");
					$('#frmEditarVentaIGV').val("");
					$('#frmEditarVentaPrecUn').val("");
					$('#frmEditarVentaObserv').val("");	
					$('#listaProducto').trigger("reset");
			
			 });	  
		 	  
		  
		  
		  
		  $('body').on('change', '#listaFormaPago', function() {
		 		var shortName=$('#listaFormaPago').find(":selected").attr('atrr-shortName');
				 var d = shortName;
				 var fechaVenta = $('#frmMovVentaFecMov').val();
				 var res = fechaVenta.split(",");
				 var arr = res[0].split('-');
				 var fechaVentaVar=arr[2] +"-"+ arr[1] +"-"+ arr[0];					
				 var Fecha = new Date(fechaVentaVar); 
			     var dias = parseInt(d);
					 Fecha.setDate(Fecha.getDate()+1 + dias);
				$("#frmMovVentaFecCad").val(Fecha.getDate() + '-' +(Fecha.getMonth() + 1) + '-' + Fecha.getFullYear());
				$("#frmMovVentaFecPago").val(Fecha.getDate() + '-' +(Fecha.getMonth() + 1) + '-' + Fecha.getFullYear());
				if($('#listaFormaPago').val()== "1" ){
					$('#idFecVenc').hide();					
				} else {
					$('#idFecVenc').show();
				}
			});
		 
		 
		 
		  $("#dias").keyup(function() {
			  var d = $("#dias").val() || 0;
				 if ( d=="" || d==0){
	//			    alert("No has ingresado el numero de dias")
				    var fechaFinal="";
				 }else{
					 var fechaVenta = $('#frmMovVentaFecMov').val();
					 var res = fechaVenta.split(",");
					 var arr = res[0].split('-');
					 var fechaVentaVar=arr[2] +"-"+ arr[1] +"-"+ arr[0];					
					 var Fecha = new Date(fechaVentaVar); 
				     var dias = parseInt(d);
						 Fecha.setDate(Fecha.getDate()+1 + dias);
					$("#frmMovVentaFecCad").val(Fecha.getDate() + '-' +(Fecha.getMonth() + 1) + '-' + Fecha.getFullYear());
					$("#frmMovVentaFecPago").val(Fecha.getDate() + '-' +(Fecha.getMonth() + 1) + '-' + Fecha.getFullYear());
	
					if($('#listaFormaPago').val()== "1" ){
						$('#idFecVenc').hide();					
					} else {
						$('#idFecVenc').show();
					} 
				 }	    
				}); 
		  
		  
		 $("#exportExcel").on("click", function () {
			 $.ajax({
					url : "/SistemaFE/registroventa/exportExcel/",
					type : "POST",
					dataType : "json",
					beforeSend : function() {
					},
					success : function(data) {
						if (data.msg == "ok") {
							location.href = data.respuesta;
						}else{
							bootbox.alert("<label class='text-danger'>ERROR : <br> Se produjo un error interno en los servicios</label>");
						}
					},
					error : function(xhr, statusText, errorThrown) {
						console.log("ocurrio un error");  
					}
				});
		 });
		 
		 $('body').on('click', '#btnAgregafac', function() {
			 	$('#lstProductoVenta').DataTable().clear();
			    var boton=$(this);
				//var codDet=boton.attr( "attr-user" );
				$("#idCompra").val();	
				$("#idCompraparaNotC").val();		
				var codDet=$("#idCompra").val();
				$.ajax({
					url : "/SistemaFE/registroventa/detalleNCND/",
					type : "POST",
					data : {"codDet":codDet},
					dataType : "json",
					beforeSend : function() {},
					success : function(data) {
						if (data.msg == "ok") {
							var obj=JSON.parse(data.Campos_NC_ND);
							
							$("#frmMovVentaFecMovNota").val(obj.fechademovimiento);
							$("#frmMovVentaListaCompNota").val(obj.tipdoc);
							$("#frmMovVentaSerieNota").val(obj.VentaSerie);
							$("#frmMovVentaNroComprNota").val(obj.VentaNroDoc);
							$("#filtrarClienteNroC").val(obj.cliente).trigger('change');
							$("#filtrarVendedorNroV").val(obj.vendedor).trigger('change');
							$("#idVentaRef").val(obj.idcodVenta);
							$("#idMoneNota").val(obj.moneda);
							
							var indicadorcabecera = $("#dataFacIndicadorAf").val(obj.indicador);
							var indicadordetalle = $("#dataFacIndicadorAfTipo").val(obj.indicadortipo);
							$("#listaCatDetIndicadortipo").val(obj.indicadortipo);
							if(obj.indicador=="10"){
								$("#listaCatDetIndicador").val(obj.indicador).trigger('change');
								$("#listaCatDetIndicadortipo").val(obj.indicadortipo).trigger('change');
							}else if(obj.indicador=="20"){
								$("#listaCatDetIndicador").val(obj.indicador).trigger('change');
								$("#listaCatDetIndicadortipo").val(obj.indicadortipo).trigger('change');
							}else if(obj.indicador=="30"){
								$("#listaCatDetIndicador").val(obj.indicador).trigger('change');	
								$("#listaCatDetIndicadortipo").val(obj.indicadortipo).trigger('change');
							}else if(obj.indicador=="40"){
								$("#listaCatDetIndicador").val(obj.indicador).trigger('change');	
								$("#listaCatDetIndicadortipo").val(obj.indicadortipo).trigger('change');
							}else if(obj.indicador=="50"){
							$("#listaCatDetIndicador").val(obj.indicador).trigger('change');	
							$("#listaCatDetIndicadortipo").val(obj.indicadortipo).trigger('change');			
							}
							
							$("#filtrarClienteNroC").attr("disabled",true);
							$("#filtrarVendedorNroV").attr("disabled",true);
							$("#listaCatDetIndicador").attr("disabled",true);
							$("#listaCatDetIndicadortipo").attr("disabled",true);						
							$.ajax({
								url : "/SistemaFE/registroventa/consultaTCFechaSel/",
								type : "POST",
								data : {"fechaConsulta":$('#frmMovVentaFecMovNota').val()},
								dataType : "json",
								beforeSend : function() {},
								success : function(data) {
									if (data.msg == "ok") {
										var template = $("#cboMasterTipCambio").html();
					                    var content = $("#listaTipCambio").empty();
					                    var html = Mustache.render(template, data);
					                    content.html(html);
					                    $.ajax({
					        				url : "/SistemaFE/registroventa/MostrarDetalle/",
					        				type : "POST",
					        				data : {"codDet":codDet},  
					        				dataType : "json",
					        				beforeSend : function() { },
					        				success : function(data) {
					        					if (data.msg == "ok") {	
					        						 $('#lstProductoVenta').DataTable().rows.add(data.datadetalle);	
					        					      $('#lstProductoVenta').DataTable().draw();
	//				        					        obj.calculaValor();
					        					      $("#listaCatDetMoneda").val($("#idMoneNota").val()).change();
	//				        						if($("#idCompraparaNotC").val()!="" ){							
	//				        						$("#PanelDetalle").show();
	//				        						obj.listarProductoCompra();
	//				        						}
					        				}			
					        				},
					        				error : function(xhr, statusText, errorThrown) {
					        					console.log("ocurrio un error");  
					        				}
					        			});
					        			
					        			
					        			
					        			$('#modalNotaBuscarDoc').modal('hide');
									} else if (data.msg == "vacio") {
										bootbox.alert("<label class='text-danger'>ALERTA : <br> La fecha seleccionada no posee tipo de cambio</label>");
										$("#listaTipCambio").val("");
									} else {
										$("#listaTipCambio").val("");
									}
								},
								error : function(xhr, statusText, errorThrown) {
									console.log("ocurrio un error");  
								}
							});
						}
					},
					error : function(xhr, statusText, errorThrown) {
						console.log("ocurrio un error");  
					}
				});
				
				
			});
		 
		 $('body').on('click', '#check-all', function() {
		        var id = this.id;
		        var index = $.inArray(id, selected);
		        var $row = $(this).closest('tr');
			    if( $(this).is(':checked') ) {
			    	 selected.push( id );
			            console.log("Activo "+index);	            
			            $row.addClass('selected');
			            $(".btnVerDetCompraDetFac").hide();
			            $("#PanelDetalle").hide();
			            $("#idCompraparaNotC").val(codDet);	
			            var boton=$(this);
						var codDet=boton.attr( "attr-user" );
						$("#idCompra").val(codDet);	
						$("#idCompraparaNotC").val(codDet);
						$("#mostrarSel").hide();
						$("#btnAgregafac").show();
			    } else {
			    	 selected.splice( index, 1 );
			            console.log("Inactivo "+index);
			            $row.removeClass('selected');
			            $(".btnVerDetCompraDetFac").show();
			        	
			    }
			});
		 
		 $('body').on('change', '#listaCatDetPeriod', function() {
			 obj.codigoRegistro();
			});
		 
		 $('body').on('change', '#listaEjercicioVenta', function() {
			 obj.codigoRegistro();
			});
		 
		 
		 
		 
		 
		 
		 
		 
		 
			$("#btnVistaPrevia").click(
					function(e) {
	
	//					var l = Ladda.create(this);
	//					l.start();
	//				var rutalogo = "https://asesorescontablesaym.com/inicio/wp-content/uploads/2018/05/contaweb_logo.png";
					var rutalogo = $("#imagenLogo").val();
				    var lemaempresa ="";
				    
				    
				    var ventas = 
				    {
						"ejercicio": $("#listaEjercicioVenta").val(),
						"almacen": $("#listAlmacenVenta").val(),
						"codRegVenta": $("#frmMovVentaCodReg").val(),
						"periodo": $("#listaCatDetPeriod").val(),
					    "sucursal": $("#listaCatDetSucursal").val(),
					    "moneda": $("#listaCatDetMoneda").val(),
					    "monedasimbolo": $("#listaCatDetMoneda").find(":selected").attr("attr-sym"),
					    "tipoMonedaOrigen" : $("#listaCatDetMoneda").val(),
					    "tipoMonedaDestino" : $("#listaCatDetMoneda").val(),
					    
					    "formaPago": $("#listaFormaPago").val(),
					    "tipoCambio": $("#listaTipCambio").find(":selected").attr("attr-venta"),
					    "tipoCambioBident": $("#listaTipCambio").val(),
					    
					    "fecDocReferencia":$("#frmMovVentaFecMovNota").val(),
					    "tipCompReferencia":$("#frmMovVentaListaCompNota").val(),
					    "serCompReferencia":$("#frmMovVentaSerieNota").val(),
					    "nroCompReferencia":$("#frmMovVentaNroComprNota").val(),
					    "codMotivoCre":$("#listaMotivoCre").val(),
					    "codMotivoDeb":$("#listaMotivoDeb").val(),
					    "codMotivoCreDesc": $("#listaMotivoCre").find(":selected").attr("attr-desc"),
					    "codMotivoDebDesc": $("#listaMotivoDeb").find(":selected").attr("attr-desc"),
					    "idVentaRef":$("#idVentaRef").val(),
	
					    
					    "fechaMovimientoemic": $("#frmMovVentaFecEmic").val(),
					    "dias": $("#dias").val(),
					    "fechaMovimientopago": $("#frmMovVentaFecPago").val(),
					    "fechaMovimiento": $("#frmMovVentaFecMov").val(),
					    "fechaVencimiento": $("#frmMovVentaFecCad").val(),
					    "tipoComprobante": $("#listaCatDetComp").val(),
					    "Serie": $('#listSerieVenta').find(":selected").attr("attr-venta"),
					    "SerieID": $("#listSerieVenta").val(),		    
					    "nroComprobante": $("#frmMovVentaNroComprobante").val(),
					    "nroDocCliente": $('#filtrarClienteNroC').find(":selected").attr("attr-numdoc"),
					    "tipoDocCliente": $('#filtrarClienteNroC').find(":selected").attr("attr-tipdoc"),
					    "idCliente": $('#filtrarClienteNroC').val(),
					    "nombreCliente": $("#filtrarClienteRazonSocialCliente").val(),
					    "direccionCliente": $("#filtrarClienteDireccion").val(),
					    "emailCliente":$('#filtrarClienteNroC').find(":selected").attr("attr-email"),
					     
					    "nroDocVendedor": $('#filtrarVendedorNroV').find(":selected").attr("attr-numdoc"),
					    "tipoDocVendedor": $('#filtrarVendedorNroV').find(":selected").attr("attr-tipdoc"),
					    
					    "idVendedor": $('#filtrarVendedorNroV').val(),
					    "nombreVendedor": $("#filtrarVendedorNroV").find(":selected").attr("attr-nombre"),
					    
					    
	//				    "nombreVendedor": $("#filtrarVendedorNombre").val(),
					    "observacion": $("#frmMovVentaObs").val(),
					    "observacionNota": $("#frmMovVentaObsNota").val(),
					    "indicador": $("#listaCatDetIndicador").val(),
					    "tipoIndicador": $("#listaCatDetIndicadortipo").val(),
					    "ventaTituloGratuito": $("#movVentTitgrat").is(':checked') ? true : false,
					    		
					    "inf": $("#frmResultadoINF").val(),
					    "exonerado": $("#frmResultadoExonerado").val(),
					    "ventaGratuita": $("#frmResultadoVentaGratuita").val(),
					    "bim": $("#frmResultadoBIM").val(),
					    "exportacion": $("#frmResultadoExportacion").val(),
					    "valortotal": $("#frmResultadoValorTotal").val(),
					    "neto": $("#frmResultadoNeto").val(),
					    "igv": $("#frmResultadoIGV").val(),
					    "impDescTot": $("#frmResultadoImpDescTot").val(),
					    "total": $("#frmResultadoTotal").val(),
					    "conversion": $("#frmResultadoConver").val(),
					    "monto": $("#frmResultadoMonto").val(),
							
	
					    "descrFormaPago": $("#listaFormaPago option:selected").text(),
	//				    "idTipoCambio" : idTC,
	//				    "montoTipoCambio": montoTC,
					    
					    "inafecto": $('#frmResultadoINF').val(),
					    "gravada": $('#frmResultadoBIM').val(),
					    "exonerada": $('#frmResultadoExonerado').val(),
					    "exportacion": $('#frmResultadoExportacion').val(),
					    "gratuita": $('#frmResultadoVentaGratuita').val(),
					    "neto": $('#frmResultadoNeto').val(),
					    "igv": $('#frmResultadoIGV').val(),
					    "impDescTot": $("#frmResultadoImpDescTot").val(),
					    "total": $('#frmResultadoTotal').val(),
					    "conversion": $('#frmResultadoConver').val(),
					    "totalletras": $('#frmResultadoMonto').val(),    
					    "ordencompra": $('#frmMovVentaOrdenCompra').val(),    
					    "guia": $('#frmMovVentaguia').val()
	//			        "arrayRegistros": arrayRegistros
				    };
				    
				    console.log("dentro del json "+ventas.moneda);
	//				var razonsocialcliente = $('#filtrarClienteNroC').find(":selected").attr("attr-nombre");
	//				var nrodocumentocliente  = $('#filtrarClienteNroC').find(":selected").attr("attr-numdoc");
	//				var serieventa =	$('#listSerieVenta').find(":selected").attr("attr-venta");
	//				var nrodocventa = $('#frmMovVentaNroComprobante').val();
	//				var telefonoempresa = $('#frmMovVentaNroComprobante').val();
	//				var emailempresa = $('#frmMovVentaNroComprobante').val();
					var direccionempresa = $('#frmMovVentaNroComprobante').val();
					var formapago= $("#listaFormaPago option:selected").text();
					var monedanombre= $("#listaCatDetMoneda option:selected").text();
					
					var direcEmpresa = $('#direccionEmpresa').val();
					var emailEmpresa = $('#emailEmpresa').val();
					var telefonoEmpresa = $('#telefonoEmpresa').val();
					var nroRucEmpresa = $('#nroRucEmpresa').val();
					
					var cantidad='';
				       var codigo='';
				       var descripcion='';
				       var punitario='';
				       var total='';
					var contenido = '';
					var tipoDocumento = ventas.tipoComprobante;
	//				var jQueryTabla = $("<table></table>");
	//			       jQueryTabla.attr({
	//			       id:"idtabla"});
				       
	//			function addRow(){
	//			  var nuevoTr = "<tr bgcolor='FFFDC1'><th>Columna 1</th><th>Column 2</th><th>Columna 3</th></tr>";
	//			  jQueryTabla.append(  nuevoTr );
	//			}
	//				NUESTRA RAZÓN DE SER  ES SERVIRLOS
	//				 contenido += '<img width="150" height="150" src=\https://asesorescontablesaym.com/inicio/wp-content/uploads/2018/05/contaweb_logo.png\ >'+'<b>'+'<a style=\"color: #2e6c80;" >NUESTRA RAZÓN DE SER  ES SERVIRLOS</a>';
	//					 contenido += '&nbsp';
	//				 contenido += '<b>';
					 contenido +='<table width="750" >';
					 contenido +='<tr>';
					 contenido +=  '<td ROWSPAN=5><img width="200" height="100" src='+rutalogo+' ></td>';
					 contenido += '<td ROWSPAN=5><h5 style=\"color: #2e6c80; text-align: center;\">'+lemaempresa+'</h5></td>';
	//				 contenido +='<tr>';
					 contenido += '</tr>'+'</td>';
					 if (tipoDocumento == "01"){
						 contenido += '<td style="border:1px solid black" align="center" BGCOLOR="BLACK" ><strong style="color:#FFFFFF">FACTURA ELECTRÓNICA</strong><tr>'+'<td style="border:1px solid black" align="center">'+ventas.Serie+'-'+ventas.nroComprobante+'</td>';
					 } else if (tipoDocumento == "03"){
						 contenido += '<td style="border:1px solid black" align="center" BGCOLOR="BLACK" ><strong style="color:#FFFFFF">BOLETA ELECTRÓNICA</strong><tr>'+'<td style="border:1px solid black" align="center">'+ventas.Serie+'-'+ventas.nroComprobante+'</td>';
					 } else if (tipoDocumento == "07"){
						 contenido += '<td style="border:1px solid black" align="center" BGCOLOR="BLACK" ><strong style="color:#FFFFFF">NOTA DE CRÉDITO ELECTRÓNICA</strong><tr>'+'<td style="border:1px solid black" align="center">'+ventas.Serie+'-'+ventas.nroComprobante+'</td>';
					 } else if (tipoDocumento == "08"){
						 contenido += '<td style="border:1px solid black" align="center" BGCOLOR="BLACK" ><strong style="color:#FFFFFF">NOTA DE DÉBITO ELECTRÓNICA</strong><tr>'+'<td style="border:1px solid black" align="center">'+ventas.Serie+'-'+ventas.nroComprobante+'</td>';
					 } else if (tipoDocumento == "99"){
						 contenido += '<td style="border:1px solid black" align="center" BGCOLOR="BLACK" ><strong style="color:#FFFFFF">NOTA DE VENTA</strong><tr>'+'<td style="border:1px solid black" align="center">'+ventas.Serie+'-'+ventas.nroComprobante+'</td>';
					 } 
	//				 contenido += '<td style="border:1px solid black" align="center" BGCOLOR="YELLOW" ><strong>FACTURACIÓN ELECTRONICA</strong><tr>'+'<td style="border:1px solid black" align="center">'+ventas.Serie+'-'+ventas.nroComprobante+'</td>';
					 contenido += '</tr>';
					 contenido +='<tr>';
					 contenido += '<td style="border:1px solid black" align="center" BGCOLOR="BLACK"><strong style="color:#FFFFFF">RUC EMPRESA</strong><tr>'+'<td style="border:1px solid black" align="center">'+nroRucEmpresa+'</td>';
					 contenido += '</tr>'+'</td>';
					 contenido += '</tr>';
					 contenido +='</table>'+'</b>';
					 contenido += '<br>';
					 contenido +='<table width="750" >';
					 contenido +='<tr>';
					 contenido += '<td align="left"  WIDTH="60" ><strong>Correo:</strong>'+'<td  align="left">'+emailEmpresa+'</td></td>';
	//				 contenido += '</tr>';
	//				 contenido +='<tr>';
					 contenido += '<td  align="right" WIDTH="60"  ><strong> Teléfono:</strong>'+'<td  align="center">'+telefonoEmpresa+'</td></td>';
	//				 contenido += '</tr>';
	//				 contenido +='<tr>';
					 if (tipoDocumento == "07" || tipoDocumento == "08"){
						 contenido += '<td style="border:1px solid black" align="center" BGCOLOR="BLACK" WIDTH="146" ><strong style="color:#FFFFFF">Fecha de Doc. Rela.</strong><tr>'+'<td  WIDTH="110" align="left"><strong>Domicilio Fiscal:</strong></td>';
						 contenido += '<td colspan="3"  align="left"  >'+direcEmpresa+'<td style="border:1px solid black" align="center">'+ventas.fecDocReferencia+'</td></td>';
					 } else {
						 contenido += '<td style="border:1px solid black" align="center" BGCOLOR="BLACK" WIDTH="146" ><strong style="color:#FFFFFF">Método de Pago</strong><tr>'+'<td  WIDTH="110" align="left"><strong>Domicilio Fiscal:</strong></td>';
						 contenido += '<td colspan="3"  align="left"  >'+direcEmpresa+'<td style="border:1px solid black" align="center">'+ventas.descrFormaPago+'</td></td>';
					 }
					 contenido += '</tr>';
					 contenido +='</table>';
	//				 contenido += '<br>';
					 contenido += '<br>';
					 contenido +='<table width="750" >';
					 contenido +='<tr>';
					 contenido += '<td colspan="4" style="border:1px solid black" WIDTH="350" font size ="4" align="center" BGCOLOR="BLACK" ><font style="color:#FFFFFF" size="5">Cliente</font></td>';
					 contenido += '<td style="border:1px solid black" align="center" width="121" ><strong >Facturación Electronica</strong><tr>'+'<td style="border:1px solid black" align="left" WIDTH="90"><strong>Razón Social:</strong></td>';
					 contenido += '<td colspan="3" WIDTH="370" style="border:1px solid black" align="left"  >'+ventas.nombreCliente+'<td style="border:1px solid black" align="center" ROWSPAN=7><img width="100" height="100" src=\https://asesorescontablesaym.com/inicio/wp-content/uploads/2018/05/contaweb_logo.png\ ></td></td>';
					 contenido +='<tr>';
					 contenido += '<td style="border:1px solid black" align="left"><strong>Dirección:</strong></td>';
					 contenido += '<td colspan="3" style="border:1px solid black" align="left" WIDTH="90">'+ventas.direccionCliente+'</td>';
	//				 contenido += '<td style="border:1px solid black" align="left" BGCOLOR="YELLOW" WIDTH="90"><strong>Dirección:</strong></td>';
	//				 contenido += '<td style="border:1px solid black" align="left" BGCOLOR="YELLOW" WIDTH="90"><strong>Dirección:</strong></td>';
					 contenido += '</tr>';
					 contenido +='<tr>';
					 contenido += '<td style="border:1px solid black" align="left" WIDTH="90"><strong>Num. Doc.:</strong></td>';
					 contenido += '<td style="border:1px solid black" align="left"  WIDTH="90">'+ventas.nroDocCliente+'</td>';
					 contenido += '<td style="border:1px solid black" align="left"  WIDTH="90"><strong>Correo:</strong></td>';
					 contenido += '<td style="border:1px solid black" align="left"  WIDTH="90">'+ventas.emailCliente+'</td>';
					 contenido += '</tr>';
					 contenido +='<tr>';
					 contenido += '<td style="border:1px solid black" align="left"  WIDTH="90"><strong>Moneda:</strong></td>';
					 contenido += '<td colspan="3" style="border:1px solid black" align="left"  WIDTH="90">'+monedanombre+'</td>';
					 contenido += '</tr>';
					 contenido +='<tr>';
					 if (tipoDocumento == "07" || tipoDocumento == "08"){
						 var nomDocumento = ventas.tipCompReferencia;
						 var nombre = "";
						 if (nomDocumento =="01"){
							 nombre = "FACTURA";
						 } else if (nomDocumento =="03"){
							 nombre = "BOLETA";
						 }
						 contenido += '<td style="border:1px solid black" align="left" WIDTH="90"><strong>Tipo-Serie-Nro Doc Ref:</strong></td>';
						 contenido += '<td colspan="3" style="border:1px solid black" align="left"  WIDTH="90">'+nombre+'-'+ventas.serCompReferencia+'-'+ventas.nroCompReferencia+'</td>';
						 contenido += '</tr>';
						 contenido +='<tr>';
					 }
					 contenido += '<td style="border:1px solid black" align="left"  WIDTH="90"><strong>Fec. Emisión:</strong></td>';
					 contenido += '<td style="border:1px solid black" align="left"  WIDTH="90">'+ventas.fechaMovimientoemic+'</td>';
					 contenido += '<td style="border:1px solid black" align="left"  WIDTH="90"><strong>Fec. Vencimiento:</strong></td>';
					 contenido += '<td style="border:1px solid black" align="left"  WIDTH="90">'+ventas.fechaVencimiento+'</td>';
					 contenido += '</tr>';
					 contenido +='<tr>';
					 contenido += '<td style="border:1px solid black" align="left"  WIDTH="90"><strong>Ord. Compra:</strong></td>';
					 contenido += '<td style="border:1px solid black" align="left"  WIDTH="90">'+ventas.ordencompra+'</td>';
					 contenido += '<td style="border:1px solid black" align="left"  WIDTH="90"><strong>Guia Remisión:</strong></td>';
					 contenido += '<td style="border:1px solid black" align="left"  WIDTH="90">'+ventas.guia+'</td>';
					 contenido += '</tr>';
					 contenido +='</table>'+'</b>';
		            contenido += '<br>';
	                contenido +='<table width="750" >';
	//                contenido += '<thead>';
	               contenido +='<tr>';
					 contenido += '<td style="border:1px solid black" align="center" WIDTH="40"><strong>Cantidad</strong></td>';
					 contenido += '<td style="border:1px solid black" align="center" WIDTH="60"><strong>Codigo</strong></td>';
					 contenido += '<td style="border:1px solid black" align="center" WIDTH="150"><strong>Descripción</strong></td>';
					 contenido += '<td style="border:1px solid black" align="center" WIDTH="40"><strong>P. Unitario</strong></td>';
					 contenido += '<td style="border:1px solid black" align="center"  WIDTH="40"><strong>Total</strong></td>';
	     			 contenido += '</tr>';
	     			 
	     			 contenido +='</table>';
	//     			 $('#lstProductoVenta').stickyTableHeaders();
		           $('#lstProductoVenta ').each(function(){
		                $(this).find('tr').each(function(){
		       var cantidad =	$(this).find("td").eq(7).html();
		                var codigo =	$(this).find("td").eq(4).html();
		                var descripcion =	$(this).find("td").eq(5).html();
		                var punitario =	$(this).find("td").eq(10).html();
		                var total =	$(this).find("td").eq(22).html();
		                var obsDetalle = $(this).find("td").eq(29).html();
		                
		                if(cantidad==undefined){
		                	console.log("NO HAY DATO");
		                }else{
			                contenido +='<table width="750" >';			              
							contenido +='<tbody>';
			                contenido +='<tr>';
							 contenido += '<td style="border:1px solid black" align="center" width="120">'+cantidad+'</td>';
							 contenido += '<td style="border:1px solid black" align="center"  width="124" white-space="pre-line" text-overflow="ellipsis" overflow="hidden" >'+codigo+'</td>';
							 contenido += '<td style="border:1px solid black" align="left"  width="313" white-space="pre-line"text-overflow="ellipsis" overflow="hidden" >'+descripcion+' - '+obsDetalle+'</td>';
							 contenido += '<td style="border:1px solid black" align="RIGHT" width="108" white-space="pre-line" text-overflow="ellipsis" overflow="hidden" >'+punitario+'</td>';
							 contenido += '<td style="border:1px solid black" align="RIGHT" white-space="pre-line"  text-overflow="ellipsis" overflow="hidden" >'+total+'</td>';
							 contenido += '</tr>';
							 contenido +='</tbody>';
						 contenido +='</table>';
		                }
		                })
		            })
		               contenido += '<br>';
		           contenido += '<br>';
		             contenido +='<table width="750" >';
		             if (tipoDocumento == "07"){
						 contenido +='<tr>';
						 contenido += '<td style="border:1px solid black" align="left"  WIDTH="200"><strong>Motivo o Sustento:</strong></td>';
						 contenido += '<td style="border:1px solid black" align="left"  WIDTH="90">'+ventas.codMotivoCreDesc+'</td>';
						 contenido += '</tr>';
		             } else if (tipoDocumento == "08"){
		            	 contenido +='<tr>';
						 contenido += '<td style="border:1px solid black" align="left"  WIDTH="200"><strong>Motivo o Sustento:</strong></td>';
						 contenido += '<td style="border:1px solid black" align="left"  WIDTH="90">'+ventas.codMotivoDebDesc+'</td>';
						 contenido += '</tr>';
		             }
		             contenido +='<tr>';
					 contenido += '<td style="border:1px solid black" align="left"   WIDTH="200"><strong>Observación:</strong></td>';
					 contenido += '<td  WIDTH="200"></td>';
					 contenido += '<td style="border:1px solid black" align="left"   WIDTH="120"><strong>Op. Gravadas</strong></td>';
					 contenido += '<td style="border:1px solid black" align="center"  WIDTH="5">:</td>';
					 contenido += '<td style="border:1px solid black" align="left"  WIDTH="90">'+ventas.monedasimbolo+'</td>';
					 contenido += '<td style="border:1px solid black" align="left"  WIDTH="90">'+ventas.gravada+'</td>';
					 contenido += '</tr>';
					 contenido +='<tr>';
					 contenido += '<td  WIDTH="200"></td>';
					 if (tipoDocumento == "07" || tipoDocumento == "08"){
						 contenido += '<td style="border:1px solid black" align="left" ROWSPAN=2  WIDTH="600">'+ventas.observacionNota+'</td>';
					 } else {
						 contenido += '<td style="border:1px solid black" align="left" ROWSPAN=2  WIDTH="600">'+ventas.observacion+'</td>';
					 }
					 contenido += '<td style="border:1px solid black" align="left" WIDTH="120"><strong>Op. Inafectas</strong></td>';
					 contenido += '<td style="border:1px solid black" align="center"  WIDTH="5">:</td>';
					 contenido += '<td style="border:1px solid black" align="left"  WIDTH="90">'+ventas.monedasimbolo+'</td>';
					 contenido += '<td style="border:1px solid black" align="left"  WIDTH="90">'+ventas.inafecto+'</td>';
					 contenido += '</tr>';
					 contenido +='<tr>';
					 contenido += '<td  WIDTH="200"></td>';
					 contenido += '<td style="border:1px solid black" align="left"  WIDTH="120"><strong>Op. Exoneradas</strong></td>';
					 contenido += '<td style="border:1px solid black" align="center"  WIDTH="5">:</td>';
					 contenido += '<td style="border:1px solid black" align="left"  WIDTH="90">'+ventas.monedasimbolo+'</td>';
					 contenido += '<td style="border:1px solid black" align="left"  WIDTH="90">'+ventas.exonerada+'</td>';
					 contenido += '</tr>';
					 contenido +='<tr>';
					 contenido += '<td style="border:1px solid black" align="left"   WIDTH="200"><strong>Son:</strong></td>';
					 contenido += '<td  WIDTH="200"></td>';
					 contenido += '<td style="border:1px solid black" align="left"  WIDTH="120"><strong>Op. Exportación</strong></td>';
					 contenido += '<td style="border:1px solid black" align="center"  WIDTH="5">:</td>';
					 contenido += '<td style="border:1px solid black" align="left"  WIDTH="90">'+ventas.monedasimbolo+'</td>';
					 contenido += '<td style="border:1px solid black" align="left"  WIDTH="90">'+ventas.exportacion+'</td>';
					 contenido += '</tr>';
					 contenido +='<tr>';
					 contenido += '<td  WIDTH="200"></td>';
					 contenido += '<td style="border:1px solid black" align="left" ROWSPAN=2    WIDTH="600">'+ventas.totalletras+'</td>';
					 contenido += '<td style="border:1px solid black" align="left"  WIDTH="120"><strong>Descuento      </strong></td>';
					 contenido += '<td style="border:1px solid black" align="center"  WIDTH="5">:</td>';
					 contenido += '<td style="border:1px solid black" align="left"  WIDTH="90">'+ventas.monedasimbolo+'</td>';
					 contenido += '<td style="border:1px solid black" align="left"  WIDTH="90">'+ventas.impDescTot+'</td>';
					 contenido += '</tr>';
					 contenido +='<tr>';
					 contenido += '<td  WIDTH="200"></td>';
					 contenido += '<td style="border:1px solid black" align="left"  WIDTH="120"><strong>Valor de Venta </strong></td>';
					 contenido += '<td style="border:1px solid black" align="center"  WIDTH="5">:</td>';
					 contenido += '<td style="border:1px solid black" align="left"  WIDTH="90">'+ventas.monedasimbolo+'</td>';
					 contenido += '<td style="border:1px solid black" align="left"  WIDTH="90">'+ventas.neto+'</td>';
					 contenido += '</tr>';
					 contenido +='<tr>';
					 contenido += '<td  WIDTH="800" align="center" colspan="2" BGCOLOR="BLACK"><strong style="color:#FFFFFF">Representación impresa de la FACTURA ELECTRÓNICA</strong></td>';
					 contenido += '<td style="border:1px solid black" align="left"  WIDTH="120"><strong>IGV            </strong></td>';
					 contenido += '<td style="border:1px solid black" align="center"  WIDTH="5">:</td>';
					 contenido += '<td style="border:1px solid black" align="left"  WIDTH="90">'+ventas.monedasimbolo+'</td>';
					 contenido += '<td style="border:1px solid black" align="left"  WIDTH="90">'+ventas.igv+'</td>';
					 contenido += '</tr>';
					 contenido +='<tr>';
					 contenido += '<td  WIDTH="800" align="center"  colspan="2"BGCOLOR="BLACK"><strong style="color:#FFFFFF">Visita: http://www.contawebaym.net/</strong></td>';
					 contenido += '<td style="border:1px solid black" align="left"  WIDTH="120"><strong>ISC            </strong></td>';
					 contenido += '<td style="border:1px solid black" align="center"  WIDTH="5">:</td>';
					 contenido += '<td style="border:1px solid black" align="left"  WIDTH="90">'+ventas.monedasimbolo+'</td>';
					 contenido += '<td style="border:1px solid black" align="left"  WIDTH="90">0.00</td>';
					 contenido += '</tr>';
					 contenido +='<tr>';
					 contenido += '<td  WIDTH="800" align="center"  colspan="2"BGCOLOR="BLACK"><strong style="color:#FFFFFF">Autorizado mediante Resolución de Intendencia N°.3354620190033</strong></td>';
					 contenido += '<td style="border:1px solid black" align="left"  WIDTH="120"><strong>Total          </strong></td>';
					 contenido += '<td style="border:1px solid black" align="center"  WIDTH="5">:</td>';
					 contenido += '<td style="border:1px solid black" align="left"  WIDTH="90">'+ventas.monedasimbolo+'</td>';
					 contenido += '<td style="border:1px solid black" align="left"  WIDTH="90">'+ventas.total+'</td>';
					 contenido += '</tr>';
					 
					 contenido +='</table>'+'</b>';
		            contenido += '<br>';
	                contenido +='<table width="750" >';
		            
		            
		            
		            
	//	                console.log("esto sale "+cantidad+" "+codigo+" "+descripcion+" "+punitario+" "+total);
	
	
	//var name_table=$("#cargarPropuesta");
	//var row = name_table.insertRow(0+1);
	//var cell1 = row.insertCell(0);
	//var cell2 = row.insertCell(1);
	//var cell3 = row.insertCell(2);
	//var cell4 = row.insertCell(3);
	//var cell5 = row.insertCell(4);
	//var cell6 = row.insertCell(5);
	//var cell7 = row.insertCell(6);
	//var cell8 = row.insertCell(7);
	//var cell9 = row.insertCell(8);
	
	
	//cell1.innerHTML = '<input name="numerorevision_p[]" value='+cantidad+' class="form-control col-sm-4"/>';
	//cell2.innerHTML = '<input name="fechapropuesta_f[]" value='+codigo+' class="form-control col-sm-4"/>';
	//cell3.innerHTML = '<input name="tipcambio_p[]" value='+descripcion+' class="form-control col-sm-4"/>';
	//cell4.innerHTML = '<input name="soles_p[]" value='+soles+' class="form-control col-sm-4"/>';
	//cell5.innerHTML = '<input name="dolares_p[]" value='+dolares+' class="form-control col-sm-4"/>';
	
		              
	
	//	            contenido += '<br>';
	//	            contenido += '<button id="cmd1">generate PDF</button>';
	//	            contenido += '<p><a href="pdf.php">Ver tabla en PDF</a></p>';
	//$("#contenedor").append(jQueryTabla);
		            $('#resumenContent').html(contenido);
	//	            console.log(contenido);
						$('#modalVistaPrevia').modal("show")
					});
		 
		 
	
	//});
		 
			$('body').on('click', '#btnCalcular', function(event) {
				if ($("#frmResultadoNeto").val()!=""){
					var codia=$("#listaCatDetIndicador").val();
					var codTipoMoneda = $("#listaCatDetMoneda").val();
					var listaTipCambio=$("#listaTipCambio").find(":selected").attr("attr-venta");
					var valorVenta = parseFloat($("#frmResultadoNeto").val());
					var igvVenta = (valorVenta*(parseFloat(0.18))).toFixed(2);
					var precioVenta = (valorVenta+parseFloat(igvVenta)).toFixed(2);
					if (codTipoMoneda=="1"){
						var precioConv = (parseFloat(precioVenta)/parseFloat(listaTipCambio)).toFixed(2);
					} else {
						var precioConv = (parseFloat(precioVenta)*parseFloat(listaTipCambio)).toFixed(2);
					}
					if (codia=="10"){
						$("#frmResultadoIGV").val(igvVenta);
						$("#frmResultadoTotal").val(precioVenta);
						$("#frmResultadoTotalView").val(precioVenta);
						$("#frmResultadoConver").val(precioConv);
						obj.totLetras();
					} else if (codia=="50"){
						$("#frmResultadoIGV").val(igvVenta);

					} else {
						console.log("no afecta igv");
					}
				}
			});
		 
		 
		 
		 
		 
	 
	}
	
	RegistroVenta.prototype.codigoRegistro = function() {
		var codVenta = "0";
		$.ajax({
			url : "/SistemaFE/registroventa/consultaCodRegistro/",
			type : "POST",
			data : {
				"tipo": codVenta,
				"sucursal": $("#listaCatDetSucursal").val(),
				"ejercicio": $("#listaEjercicioVenta").val(),
				"periodo": $("#listaCatDetPeriod").val(),
				},
			dataType : "json",
			beforeSend : function() {},
			success : function(data) {
				if (data.msg == "ok") {
					$('#frmMovVentaCodReg').val(data.CodRegistro);
				}else {
					$('#frmMovVentaCodReg').val('');
				}
			},
			error : function(xhr, statusText, errorThrown) {
				console.log("ocurrio un error");  
			}
		});
	}
	
	//editar grilla 
	RegistroVenta.prototype.clear = function() {
		var obj = this;
		$("#frmEditarVentaCodComercial").val("");
		$("#frmEditarVentaConcepto").val("");
		$("#frmEditarVentaUnidadMedida").val("");
		$("#frmEditarVentaCant").val("");
		$("#frmEditarVentaValorVunit").val("");
		$("#frmEditarVentaIGV").val("");	
		$("#frmEditarVentaPrecUn").val("0");
		$("#frmEditarVentaObserv").val("0");	
	//	obj.lstDataTableProductoVenta.clear();
		obj.lstDataTableProductoVenta.draw();
	}
	//editar grilla
	RegistroVenta.prototype.loadSerie = function() {
	var codia=$("#listaCatDetSucursal").val();
	if(codia!=""){
	var ctia =$("#listaCatDetComp").val();
		$.ajax({
			url : "/SistemaFE/registroventa/listarSerie/",
			type : "POST",
			data : {"codSer":codia,"codDoc":ctia},
			dataType : "json",
			beforeSend : function() {
			},
			success : function(data) {
				if (data.msg == "ok") {
					var template = $("#cboMasterserie").html();
	               var content = $("#listSerieVenta").empty();
	               var html = Mustache.render(template, data);
	               content.html(html);
	               if(data.toption.length==0){            	   
	            	   $("#frmMovVentaNroComprobante").val("");           	   
	               }else {
	//               	$("#listaPrecios option[value='remover1']").remove();
	               	$("#listSerieVenta").val(data.toption[0].id).change();
	            	$("#frmMovVentaNroComprobante").val(data.toption[0].numDoc).change();
	               }
				}else{
					bootbox.alert("<label class='text-danger'>ERROR : <br> Se produjo un error interno en los servicios</label>");
				}
			},
			error : function(xhr, statusText, errorThrown) {
				console.log("ocurrio un error");  
			}
		});
		}
	}
	
	RegistroVenta.prototype.registrar = function(form) {
		var arrayRegistros = [];
		var arrayAnticipos = [];
		var obj = this;
		var l = Ladda.create(form);
		var tipoAnticipo;
		 //mtoledo 08/03/2019 CWA-591
		if($("#listaTipoOperacion").val()=='2'){
			 tipoAnticipo=$('input:radio[name=operAnticipo]:checked ').val();
		}
		if($("#listaTipoOperacion").val()=='2' && $('input:radio[name=operAnticipo]:checked ').val() == '1' ){
			if(obj.objProducto ==null){
				bootbox.alert({
		            size: null,
		            title: null,
		            message: "Es obligatorio ingresar un registro.",
		            onEscape: true
		        }); 
				return;
			}
			
			 var jsonData = {};
			 jsonData["numero"] = null;
		     jsonData["codigo"] = null;
		     jsonData["claseSunat"] = $("#prodVclassSunat").val();
		     jsonData["codigoAlmacen"] = null;
		     jsonData["codigoComercial"] = null;
		     jsonData["concepto"] = 'Anticipo';
		     jsonData["UnidadMedida"] = 'NIU';
		     jsonData["cantidad"] = '1';
		     jsonData["valorUnitario"] = obj.objProducto.valorUnitario;
		     jsonData["igvUnitario"] =  obj.objProducto.igvUnitario;
		     jsonData["precioUnitario"] = obj.objProducto.precioUnitario;
		     jsonData["valorVenta"] = obj.objProducto.valorVenta;
		     jsonData["porcentaDesc"] =  obj.objProducto.porcentaDesc;
		     jsonData["importeDesc"] = obj.objProducto.importeDesc;
		     jsonData["baseImporte"] = obj.objProducto.baseImporte;
		     jsonData["incluyeIgv"] = true;
		     jsonData["igv"] = obj.objProducto.igv;
		     jsonData["totalBruto"] = obj.objProducto.totalBruto;
		     jsonData["totalNeto"] = obj.objProducto.totalNeto;
		     jsonData["indicadorAfecto"] = $("#listaCatDetIndicador").val();
		     jsonData["tipoIndicadorAfecto"] = $("#listaCatDetIndicadortipo").val();
		     jsonData["observacion"] = $("#frmMovVentaOrdenCompra").val();
		     jsonData["ordernPedido"] = null;
		     jsonData["guiaRemision"] = null;
		     jsonData["transferencia"] = 'NO';
		     jsonData["precValorVentaDscto"] = obj.objProducto.precValorVentaDscto;
		     jsonData["precIgvVentaDscto"] = obj.objProducto.precIgvVentaDscto;
		     jsonData["precPrecioVentaDscto"] = obj.objProducto.precPrecioVentaDscto;
		     jsonData["precDescripMoneda"] = $("#listaCatDetMoneda").val();
		     jsonData["tipoMonedaDestino"] = $("#listaCatDetMoneda").val();
		     jsonData["tipoCambioVenta"] = "";
		     jsonData["tipoConversion"] = '10';
		     jsonData["tipoRegistro"] = 's';
		     jsonData["nomcorto"] = 'Anticipo';
		     jsonData["Descripcion"] = $("#frmMovVentaOrdenCompra").val();
		     jsonData["preciodescripcion"] = obj.objProducto.preciodescripcion;
		     jsonData["preciodescripcionproducto"] = obj.objProducto.preciodescripcionproducto;
		     jsonData["nombremarca"] = '';
		     jsonData["nombrecortomarca"] = '';
		     jsonData["nombredescripcionmarca"] = '';
		     jsonData["codservicio"] = ''       
		     jsonData["esprecioprincipal"] = true;      
		     jsonData["codigoComercial"] = "ANT";
		     arrayRegistros.push(jsonData);
		}else{
			if($("#listaTipoOperacion").val()=='2'){
				$.map(obj.lstDataTableAnticipo.rows().data(), function (item) {
					 var jsonData = {};
					 jsonData["idCPE"] = item["idCPE"];
					 jsonData["serie"] = item["serie"];
					 jsonData["numero"] = item["numero"];
					 jsonData["montopendiente"] = item["montopendiente"];
					 //agregar el monto a utilizar
					 jsonData["montoutilizar"] = item["montoutilizar"];
					 
					 arrayAnticipos.push(jsonData);
				});
			}
			$.map(obj.lstDataTableProductoVenta.rows().data(), function (item) {
		        var jsonData = {};
		        jsonData["numero"] = item["numero"];
		        jsonData["codigo"] = item["codigo"];
		        jsonData["claseSunat"] = item["claseSunat"];
		        jsonData["codigoAlmacen"] = item["codigoAlmacen"];
		        jsonData["codigoComercial"] = item["codigoComercial"];
		        jsonData["concepto"] = item["concepto"];
		        jsonData["UnidadMedida"] = item["UnidadMedida"];
		        jsonData["cantidad"] = item["cantidad"];
		        jsonData["valorUnitario"] = item["valorUnitario"];
		        jsonData["igvUnitario"] = item["igvUnitario"];
		        jsonData["precioUnitario"] = item["precioUnitario"];
		        jsonData["valorVenta"] = item["valorVenta"];
		        jsonData["porcentaDesc"] = item["porcentaDesc"];
		        jsonData["importeDesc"] = item["importeDesc"];
		        jsonData["baseImporte"] = item["baseImporte"];
		        jsonData["incluyeIgv"] = item["incluyeIgv"];
		        jsonData["igv"] = item["igv"];
		        jsonData["totalBruto"] = item["totalBruto"];
		        jsonData["totalNeto"] = item["totalNeto"];
		        jsonData["indicadorAfecto"] = item["indicadorAfecto"];
		        jsonData["tipoIndicadorAfecto"] = item["tipoIndicadorAfecto"];
		        jsonData["observacion"] = item["observacion"];
		        jsonData["ordernPedido"] = item["ordernPedido"];
		        jsonData["guiaRemision"] = item["guiaRemision"];
		        jsonData["transferencia"] = item["transferencia"];
		        jsonData["precValorVentaDscto"] = item["precValorVentaDscto"];
		        jsonData["precIgvVentaDscto"] = item["precIgvVentaDscto"];
		        jsonData["precPrecioVentaDscto"] = item["precPrecioVentaDscto"];
		        jsonData["precDescripMoneda"] = item["precDescripMoneda"];
		        jsonData["tipoMonedaDestino"] = item["tipoMonedaDestino"];
		        jsonData["tipoCambioVenta"] = item["tipoCambioVenta"];
		        jsonData["tipoConversion"] = item["tipoConversion"];
		        jsonData["tipoRegistro"] = item["tipoRegistro"];
		        jsonData["nomcorto"] = item["nomcorto"];
		        jsonData["Descripcion"] = item["Descripcion"];
		        jsonData["preciodescripcion"] = item["preciodescripcion"];
		        jsonData["preciodescripcionproducto"] = item["preciodescripcionproducto"];
		        jsonData["nombremarca"] = item["nombremarca"];
		        jsonData["nombrecortomarca"] = item["nombrecortomarca"];
		        jsonData["nombredescripcionmarca"] = item["nombredescripcionmarca"];//        jsonData["nombrecortoservicio"] = item["nombrecortoservicio"];
		        jsonData["codservicio"] = item["codservicio"];       
		        jsonData["esprecioprincipal"] = item["esprecioprincipal"];       
		        jsonData[""] = item[""];//agregar monto total de descuento
		        
		        arrayRegistros.push(jsonData);
		    });
		}
		if(arrayRegistros.length===0){
			 bootbox.alert({
	             size: null,
	             title: null,
	             message: "Es obligatorio ingresar un registro.",
	             onEscape: true
	         }); 
		} else if ($("#frmDatosClienteVendedor").valid()== false) {
			bootbox.alert({
	            size: null,
	            title: null,
	            message: "Verificar datos pendientes",
	            onEscape: true
	        });
		} else if ($("#frmDatosObservacion").valid()== false) {
			bootbox.alert({
	            size: null,
	            title: null,
	            message: "Verificar observación",
	            onEscape: true
	        });
		} else if ($("#listaTipCambio").val()==null || $("#listaTipCambio").val()== "") {
			bootbox.alert({
	            size: null,
	            title: null,
	            message: "Verificar tipo de Cambio",
	            onEscape: true
	        });
		} else if ($("#listSerieVenta").val()== ""||$("#frmMovVentaNroComprobante").val()== "") {
		bootbox.alert({
	        size: null,
	        title: null,
	        message: "Verificar Serie o Nro. Comprabante",
	        onEscape: true
	    });
		} else {
			
			var tipoCambio= $("#listaTipCambio").val();
			var montoTC="";
			var idTC="";
			if($("#listaTipCambio").val()!=null){
				tipoCambio=tipoCambio.split("-");
				montoTC=tipoCambio[1];
				idTC=tipoCambio[0];
			}
	
			var ventas = 
		    {
				"ejercicio": $("#listaEjercicioVenta").val(),
				"almacen": $("#listAlmacenVenta").val(),
				"codRegVenta": $("#frmMovVentaCodReg").val(),
				"periodo": $("#listaCatDetPeriod").val(),
			    "sucursal": $("#listaCatDetSucursal").val(),
			    "moneda": $("#listaCatDetMoneda").val(),
			    
			    "tipoMonedaOrigen" : $("#listaCatDetMoneda").val(),
			    "tipoMonedaDestino" : $("#listaCatDetMoneda").val(),
			    
			    "formaPago": $("#listaFormaPago").val(),
			    "tipoCambio": $("#listaTipCambio").find(":selected").attr("attr-venta"),
			    "tipoCambioBident": $("#listaTipCambio").val(),
			    
			    "fecDocReferencia":$("#frmMovVentaFecMovNota").val(),
			    "tipCompReferencia":$("#frmMovVentaListaCompNota").val(),
			    "serCompReferencia":$("#frmMovVentaSerieNota").val(),
			    "nroCompReferencia":$("#frmMovVentaNroComprNota").val(),
			    "codMotivoCre":$("#listaMotivoCre").val(),
			    "codMotivoDeb":$("#listaMotivoDeb").val(),
			    "idVentaRef":$("#idVentaRef").val(),
	
			    
			    "fechaMovimientoemic": $("#frmMovVentaFecEmic").val(),
			    "dias": $("#dias").val(),
			    "fechaMovimientopago": $("#frmMovVentaFecPago").val(),
			    "fechaMovimiento": $("#frmMovVentaFecMov").val(),
			    "fechaVencimiento": $("#frmMovVentaFecCad").val(),
			    "tipoComprobante": $("#listaCatDetComp").val(),
			    "Serie": $('#listSerieVenta').find(":selected").attr("attr-venta"),
			    "SerieID": $("#listSerieVenta").val(),		    
			    "nroComprobante": $("#frmMovVentaNroComprobante").val(),
			    "nroDocCliente": $('#filtrarClienteNroC').find(":selected").attr("attr-numdoc"),
			    "tipoDocCliente": $('#filtrarClienteNroC').find(":selected").attr("attr-tipdoc"),
			    "idCliente": $('#filtrarClienteNroC').val(),
			    "nombreCliente": $("#filtrarClienteRazonSocialCliente").val(),
			    "direccionCliente": $("#filtrarClienteDireccion").val(),
			    "emailCliente":$('#filtrarClienteNroC').find(":selected").attr("attr-email"),
			     
			    "nroDocVendedor": $('#filtrarVendedorNroV').find(":selected").attr("attr-numdoc"),
			    "tipoDocVendedor": $('#filtrarVendedorNroV').find(":selected").attr("attr-tipdoc"),
			    
			    "idVendedor": $('#filtrarVendedorNroV').val(),
			    "nombreVendedor": $("#filtrarVendedorNroV").find(":selected").attr("attr-nombre"),
			    
			    
	//		    "nombreVendedor": $("#filtrarVendedorNombre").val(),
			    "observacion": $("#frmMovVentaObs").val(),
			    "observacionNota": $("#frmMovVentaObsNota").val(),
			    "indicador": $("#listaCatDetIndicador").val(),
			    "tipoIndicador": $("#listaCatDetIndicadortipo").val(),
			    "ventaTituloGratuito": $("#movVentTitgrat").is(':checked') ? true : false,
			    		
			    "inf": $("#frmResultadoINF").val(),
			    "exonerado": $("#frmResultadoExonerado").val(),
			    "ventaGratuita": $("#frmResultadoVentaGratuita").val(),
			    "bim": $("#frmResultadoBIM").val(),
			    "exportacion": $("#frmResultadoExportacion").val(),
			    "valortotal": $("#frmResultadoValorTotal").val(),
			    "neto": $("#frmResultadoNeto").val(),
			    "igv": $("#frmResultadoIGV").val(),
			    "impDescTot": $("#frmResultadoImpDescTot").val(),
			    
			    "impAnticipoTot": $("#frmResultadoVentaAnticipo").val(),
			    
			    "total": $("#frmResultadoTotal").val(),
			    "conversion": $("#frmResultadoConver").val(),
			    "monto": $("#frmResultadoMonto").val(),
			    "tipoOperacion": $("#listaTipoOperacion").val(),
					
	
			    "descrFormaPago": $("#listaFormaPago option:selected").text(),
			    "idTipoCambio" : idTC,
			    "montoTipoCambio": montoTC,
			    
			    "inafecto": $('#frmResultadoINF').val(),
			    "gravada": $('#frmResultadoBIM').val(),
			    "exonerada": $('#frmResultadoExonerado').val(),
			    "exportacion": $('#frmResultadoExportacion').val(),
			    "gratuita": $('#frmResultadoVentaGratuita').val(),
			    "neto": $('#frmResultadoNeto').val(),
			    "igv": $('#frmResultadoIGV').val(),
			    "impDescTot": $("#frmResultadoImpDescTot").val(),
			    "total": $('#frmResultadoTotal').val(),
			    "conversion": $('#frmResultadoConver').val(),
			    "totalletras": $('#frmResultadoMonto').val(),    
			    "ordencompra": $('#frmMovVentaOrdenCompra').val(),    
			    "guia": $('#frmMovVentaguia').val(),
			    "tipoAnticipo":tipoAnticipo,
		        "arrayRegistros": arrayRegistros,
		        "arrayAnticipos": arrayAnticipos
		    };
			
			if ($("#idVistaPrevia").val() == "0" ){
			
			$.ajax({
				url : "/SistemaFE/registroventa/InsertarRegistroVenta/",
				type : "POST",
				data : JSON.stringify(ventas),
				dataType : "json",
				contentType: "application/json;charset=UTF-8",
				beforeSend : function() {
					l.start();
				},
				success : function(data) {
					l.stop();
					var msj="success";
					var flagErrorSunat=false;
					var tituloModal="";
					//if(data.msg=='ok'){
						var rptaSunat = "";
						if(data.voucEstadoSunat){
							if(data.voucEstadoSunat=="0"){
								rptaSunat = 'SUNAT - ACEPTADO';
		                    } /*else if(data.voucEstadoSunat==""){
		                    	rptaSunat = 'NO ENVIADO';
		                    }*/else {
		                    	flagErrorSunat=true;
		                    	rptaSunat = 'SUNAT - RECHAZADO - '+data.msgErrorSunat;
		                    }
						}
						
						if ($("#listaCatDetComp").val() == "07"){
							tituloModal='Se Registro la Nota de Crédito '+data.serieC+'-'+data.nroC+' '+''+rptaSunat;
						} else if ($("#listaCatDetComp").val() == "08"){
							tituloModal='Se Registro la Nota de Débito '+data.serieC+'-'+data.nroC+' '+''+rptaSunat;
							
						} else {
							tituloModal='Se Registro la Venta '+data.serieC+'-'+data.nroC+' '+''+rptaSunat;
						}
						if(data.msg=='ok'){
							swal({
								title : tituloModal,
								  type: 'success',
								  html:
									    '<a href class="fa fa-refresh  swal2-confirm btn btn-success" role="button"></a> ' +
									    '<a href class="fa fa-refresh  swal2-confirm btn btn-success" role="button">Crear Nueva Venta</a> ' +
									    '<a href="/SistemaFE/registroventa/exploradorventa" class="fa fa-share swal2-cancel  btn btn-danger" role="button">Ir al Explorador</a> '+
									    '<a href="/SistemaFE/comprobanteelectronico/" class="fa fa-share swal2-cancel  btn btn-primary" role="button">Ir a Comprobante</a> '+
									    '<button href class="fa fa-file-pdf-o dPDF btn btn-dark btn-sm" role="button" attr-idVenta='+data.idVenta+' title ="Descargar PDF">Imprimir	</button> ', 
									    showCloseButton: false,
									    showCancelButton: false,
									    showConfirmButton: false,
									    buttonsStyling: false,
									    allowOutsideClick: false,
									    allowEscapeKey : false
		    						

								});
						}else if(data.msg=='errorS'){
							swal({
								title : tituloModal,
								  type: 'error',
								  html:
									    '<a href class="fa fa-refresh  swal2-confirm btn btn-success" role="button"></a> ' +
									    '<a href class="fa fa-refresh  swal2-confirm btn btn-success" role="button">Crear Nueva Venta</a> ' +
									    '<a href="/SistemaFE/registroventa/exploradorventa" class="fa fa-share swal2-cancel  btn btn-danger" role="button">Ir al Explorador</a> '+
									    '<a href="/SistemaFE/comprobanteelectronico/" class="fa fa-share swal2-cancel  btn btn-primary" role="button">Ir a Comprobante</a>', 
									    showCloseButton: false,
									    showCancelButton: false,
									    showConfirmButton: false,
									    buttonsStyling: false,
									    allowOutsideClick: false,
									    allowEscapeKey : false
		    						

								});
						}else {
							swal("Error", "<h3 class='swal2-title' id='swal2-title'>Ocurrio un error al registrar la Venta <br/>"+rptaSunat+"</h3>", "error");
						}
						
					/*}else{
						swal("Error", "Ocurrio un Error al registrar la Venta", "error");
						//alert('Ocurrio un error al registrar la venta');
					}*/
					
				},
				error : function(xhr, statusText, errorThrown) {
					console.log("ocurrio un error");
				}
			});
			
			} else {
				
				$.ajax({
					url : "/SistemaFE/registroventa/vistaPrevia/",
					type : "POST",
					data : JSON.stringify(ventas),
					dataType : "json",
					contentType: "application/json;charset=UTF-8",
					beforeSend : function() {
						l.start();
					},
					success : function(data) {
						l.stop();
						if(data.msg=='ok'){
							console.log("ok");
						}
					}
				})
			}
			
		}
	
	}
	
	RegistroVenta.prototype.updateVenta = function() {
		var arrayRegistros = [];
		var obj = this;
	//	var l = Ladda.create(form);
		$.map(obj.lstDataTableProductoVenta.rows().data(), function (item) {
	        var jsonData = {};
	        jsonData["numero"] = item["numero"];
	        jsonData["codigo"] = item["codigo"];
	        jsonData["claseSunat"] = item["claseSunat"];
	        jsonData["codigoAlmacen"] = item["codigoAlmacen"];
	        jsonData["codigoComercial"] = item["codigoComercial"];
	        jsonData["concepto"] = item["concepto"];
	        jsonData["UnidadMedida"] = item["UnidadMedida"];
	        jsonData["cantidad"] = item["cantidad"];
	        jsonData["valorUnitario"] = item["valorUnitario"];
	        jsonData["igvUnitario"] = item["igvUnitario"];
	        jsonData["precioUnitario"] = item["precioUnitario"];
	        jsonData["valorVenta"] = item["valorVenta"];
	        jsonData["porcentaDesc"] = item["porcentaDesc"];
	        jsonData["importeDesc"] = item["importeDesc"];
	        jsonData["baseImporte"] = item["baseImporte"];
	        jsonData["incluyeIgv"] = item["incluyeIgv"];
	        jsonData["igv"] = item["igv"];
	        jsonData["totalBruto"] = item["totalBruto"];
	        jsonData["totalNeto"] = item["totalNeto"];
	        jsonData["indicadorAfecto"] = item["indicadorAfecto"];
	        jsonData["tipoIndicadorAfecto"] = item["tipoIndicadorAfecto"];
	        jsonData["observacion"] = item["observacion"];
	        jsonData["ordernPedido"] = item["ordernPedido"];
	        jsonData["guiaRemision"] = item["guiaRemision"];
	        jsonData["transferencia"] = item["transferencia"];
	        jsonData["precValorVentaDscto"] = item["precValorVentaDscto"];
	        jsonData["precIgvVentaDscto"] = item["precIgvVentaDscto"];
	        jsonData["precPrecioVentaDscto"] = item["precPrecioVentaDscto"];
	        jsonData["precDescripMoneda"] = item["precDescripMoneda"];
	        jsonData["tipoMonedaDestino"] = item["tipoMonedaDestino"];
	        jsonData["tipoCambioVenta"] = item["tipoCambioVenta"];
	        jsonData["tipoConversion"] = item["tipoConversion"];
	        jsonData["tipoRegistro"] = item["tipoRegistro"];
	        jsonData["nomcorto"] = item["nomcorto"];
	        jsonData["Descripcion"] = item["Descripcion"];
	        jsonData["preciodescripcion"] = item["preciodescripcion"];
	        jsonData["preciodescripcionproducto"] = item["preciodescripcionproducto"];
	        jsonData["nombremarca"] = item["nombremarca"];
	        jsonData["nombrecortomarca"] = item["nombrecortomarca"];
	        jsonData["nombredescripcionmarca"] = item["nombredescripcionmarca"];//        jsonData["nombrecortoservicio"] = item["nombrecortoservicio"];
	        jsonData["codservicio"] = item["codservicio"];       
	        jsonData["esprecioprincipal"] = item["esprecioprincipal"];       
	        jsonData[""] = item[""];//agregar monto total de descuento
	        
	        arrayRegistros.push(jsonData);
	    });
		if(arrayRegistros.length===0){
			 bootbox.alert({
	             size: null,
	             title: null,
	             message: "Es obligatorio ingresar un registro.",
	             onEscape: true
	         }); 
		} else if ($("#frmDatosClienteVendedor").valid()== false) {
			bootbox.alert({
	            size: null,
	            title: null,
	            message: "Verificar datos pendientes",
	            onEscape: true
	        });
		}else{
			
			var tipoCambio= $("#listaTipCambio").val();
			var montoTC="";
			var idTC="";
			if($("#listaTipCambio").val()!=null){
				tipoCambio=tipoCambio.split("-");
				montoTC=tipoCambio[1];
				idTC=tipoCambio[0];
			}
	
			var ventaseditar = 
		    {
					"periodo": $("#listaCatDetPeriod").val(),
				    "sucursal": $("#listaCatDetSucursal").val(),
				    "moneda": $("#listaCatDetMoneda").val(),
				    
				    "tipoMonedaOrigen" : $("#listaCatDetMoneda").val(),
				    "tipoMonedaDestino" : $("#listaCatDetMoneda").val(),
				    
				    "formaPago": $("#listaFormaPago").val(),
				    "tipoCambio": $("#frmTipCa").val(),
				    "tipoCambioBident": $("#frmTipCaIdent").val(),
	
				    
				    "fechaMovimientoemic": $("#frmMovVentaFecEmic").val(),
				    "dias": $("#dias").val(),
				    "fechaMovimientopago": $("#frmMovVentaFecPago").val(),
				    "fechaMovimiento": $("#frmMovVentaFecMov").val(),
				    "fechaVencimiento": $("#idFecVencimiento").val(),
				    "tipoComprobante": $("#listaCatDetComp").val(),
				    "Serie": $("#frmMovVentaSerie").val(),		    
				    "nroComprobante": $("#frmMovVentaNroComprobante").val(),
				    "nroDocCliente": $('#filtrarClienteNroC').find(":selected").attr("attr-numdoc"),
				    "tipoDocCliente": $('#filtrarClienteNroC').find(":selected").attr("attr-tipdoc"),
				    "idCliente": $('#filtrarClienteNroC').val(),
				    "nombreCliente": $("#filtrarClienteRazonSocialCliente").val(),
				    "direccionCliente": $("#filtrarClienteDireccion").val(),
				    "emailCliente":$('#filtrarClienteNroC').find(":selected").attr("attr-email"),
				     
				    "nroDocVendedor": $('#filtrarVendedorNroV').find(":selected").attr("attr-numdoc"),
				    "tipoDocVendedor": $('#filtrarVendedorNroV').find(":selected").attr("attr-tipdoc"),
				    "idVendedor": $('#filtrarVendedorNroV').val(),
	//			    "nombreVendedor": $('#filtrarVendedorNombre').val(),
				    
				    
				    "nombreVendedor": $("#filtrarVendedorNroV").find(":selected").attr("attr-nombre"),
				    "observacion": $("#frmMovVentaObs").val(),
				    "observacionNota": $("#frmMovVentaObsNota").val(),
				    "indicador": $("#listaCatDetIndicador").val(),
				    "tipoIndicador": $("#listaCatDetIndicadortipo").val(),
				    "ventaTituloGratuito": $("#movVentTitgrat").is(':checked') ? true : false,
				    		
				    "inf": $("#frmResultadoINF").val(),
				    "exonerado": $("#frmResultadoExonerado").val(),
				    "ventaGratuita": $("#frmResultadoVentaGratuita").val(),
				    "bim": $("#frmResultadoBIM").val(),
				    "exportacion": $("#frmResultadoExportacion").val(),
				    "valortotal": $("#frmResultadoValorTotal").val(),
				    "neto": $("#frmResultadoNeto").val(),
				    "igv": $("#frmResultadoIGV").val(),
				    "impDescTot": $("#frmResultadoImpDescTot").val(),
				    "total": $("#frmResultadoTotal").val(),
				    "conversion": $("#frmResultadoConver").val(),
				    "monto": $("#frmResultadoMonto").val(),
						
	
				    "descrFormaPago": $("#listaFormaPago option:selected").text(),
				    "idTipoCambio" : idTC,
				    "montoTipoCambio": montoTC,
				    
				    "inafecto": $('#frmResultadoINF').val(),
				    "gravada": $('#frmResultadoBIM').val(),
				    "exonerada": $('#frmResultadoExonerado').val(),
				    "exportacion": $('#frmResultadoExportacion').val(),
				    "gratuita": $('#frmResultadoVentaGratuita').val(),
				    "neto": $('#frmResultadoNeto').val(),
				    "igv": $('#frmResultadoIGV').val(),
				    "impDescTot": $("#frmResultadoImpDescTot").val(),
				    "total": $('#frmResultadoTotal').val(),
				    "conversion": $('#frmResultadoConver').val(),
				    "totalletras": $('#frmResultadoMonto').val(),    
			    "idVenta":   $('#EditDet').val(),
			    "fechareg": $('#idFecReg').val(),
			    "fechamov": $('#idFecMov').val(),
			    "fechavenc": $('#idFecVenc').val(),
			    "fechapago": $('#idFecPago').val(),
			    "pdf1": $('#idPdf').val(),
			    "ordencompra": $('#frmMovVentaOrdenCompra').val(),    
			    "guia": $('#frmMovVentaguia').val(),    
		        "arrayRegistros": arrayRegistros
		    };
		
		console.log("entro al ajax");
		$.ajax({
				url : "ActualizarVenta",
			type : "POST",
			data : JSON.stringify(ventaseditar),
			dataType : "json",
			contentType: "application/json",
			beforeSend : function() {
	// $('#btnProccess').ladda().ladda('start');
			},
			success : function(data) {
				if (data.msg == "ok") {	
	             swal({
						title:'Se Actualizo la Venta ',
						text: 'Listo.',
						type: 'success',
						confirmButtonColor: '#3085d6',
					    confirmButtonText: 'Ok',
						confirmButtonClass: 'btn btn-success',
						buttonsStyling: false,
						allowOutsideClick: false,
						allowEscapeKey : false
						}).then(function () {
							  location.href = "/SistemaFE/registroventa/exploradorventa";
							 
							  })
						
				}
			},
			error : function(xhr, statusText, errorThrown) {
				console.log("ocurrio un error");  
			}
		});
		
	
	}
	}
	
	RegistroVenta.prototype.CalcularTipCambGrillaNota = function() {
		var obj = this;
		var codTipoMoneda = $("#listaCatDetMoneda").val();
		 var indicadorAfecto = $("#listaCatDetIndicador").val();
		 var listaTipCambio=$("#listaTipCambio").find(":selected").attr("attr-venta");
		 var datainicial=$("#lstProductoVenta").DataTable().rows().data();
		 var datafinal=[];
		 for (var i = 0; i < datainicial.length; i++) {
				var descripMon = datainicial[i].precDescripMoneda;
				var precioInicial = datainicial[i].precioInicial;
				var cantidad = datainicial[i].cantidad;
	
				 
				 datainicial[i].tipoMonedaDestino = codTipoMoneda;
				 datafinal.push(datainicial[i]);
		 }
		 $("#lstProductoVenta").DataTable().rows().remove();
		 $("#lstProductoVenta").DataTable().rows.add(datafinal).draw();
		 obj.calculaValor();
		
	}
	
	RegistroVenta.prototype.CalcularTipCambGrilla = function() {
		var obj = this;
		var codTipoMoneda = $("#listaCatDetMoneda").val();
		 var indicadorAfecto = $("#listaCatDetIndicador").val();
		 var listaTipCambio=$("#listaTipCambio").find(":selected").attr("attr-venta");
		 var datainicial=$("#lstProductoVenta").DataTable().rows().data();
		 var datafinal=[];
		 var dataAux=$("#lstProductoVenta").DataTable().rows().data();
		 console.log(dataAux);
		 console.log(datainicial);


		 for (var i = 0; i < datainicial.length; i++) {
				var descripMon = datainicial[i].precDescripMoneda;
				var precioInicial = datainicial[i].precioInicial;
				var cantidad = datainicial[i].cantidad;
				 var preciounitario = precioInicial;
				 var valorunitario = 0;
				 var igvunitario = 0;
				 var dsctoTotal = 0;
				 var valorVtaTotalDscto = 0;
				 var igvVtaTotalDscto = 0;
				 var precioVtaTotalDscto = 0;
				 var dsctoPorc = 0;
				 var valorVenta = 0;
				 var igvVenta = 0;
				 var precioVenta = 0;
				 var preciounitarioVista = 0;
				 var precioVentaVista = 0;
				 var precioVtaTotalDsctoVista = 0;
				 
				 if (descripMon == codTipoMoneda) {
					 valorunitario = precioInicial/(parseFloat(1.18));
					} else {
						if (descripMon == "1"){
							valorunitario = precioInicial/(parseFloat(1.18))/(parseFloat(listaTipCambio));
							preciounitario = preciounitario/(parseFloat(listaTipCambio));
						} else {
							valorunitario = precioInicial/(parseFloat(1.18))*(parseFloat(listaTipCambio));
							preciounitario = preciounitario*(parseFloat(listaTipCambio));
						}
					}
				 
				 if (indicadorAfecto == "10") {
					 datainicial[i].valorUnitario = valorunitario.toFixed(2);
					 igvunitario = valorunitario*(parseFloat(0.18));
					 datainicial[i].igvUnitario = igvunitario.toFixed(2);
					 preciounitarioVista = parseFloat(valorunitario.toFixed(2)) + parseFloat(igvunitario.toFixed(2));
					 datainicial[i].precioUnitario = preciounitarioVista.toFixed(2);
					 valorVenta = valorunitario*(parseFloat(cantidad));
//					 valorVenta = (valorunitario.toFixed(2))*(parseFloat(cantidad));
					 datainicial[i].valorVenta = valorVenta.toFixed(2);
					 igvVenta = igvunitario*(parseFloat(cantidad));
					 datainicial[i].igvVenta = igvVenta.toFixed(2);
					 precioVenta = preciounitario*(parseFloat(cantidad));
					 precioVentaVista = parseFloat(valorVenta.toFixed(2)) + parseFloat(igvVenta.toFixed(2));
					 datainicial[i].precioVenta = precioVentaVista.toFixed(2);
					 
					 if (datainicial[i].precioDescuento !=null && datainicial[i].precioDescuento == true) {
							dsctoPorc = datainicial[i].porcentaDesc/(parseFloat(100));
							dsctoTotal = valorunitario*cantidad*(parseFloat(dsctoPorc));
							datainicial[i].importeDesc = dsctoTotal.toFixed(2);
							valorVtaTotalDscto = valorunitario*cantidad-(parseFloat(dsctoTotal.toFixed(2)));
//							valorVtaTotalDsctoView = (valorunitario.toFixed(2))*cantidad-(parseFloat(dsctoTotal.toFixed(2)));
							datainicial[i].precValorVentaDscto = valorVtaTotalDscto.toFixed(2);
//							datainicial[i].precValorVentaDscto = valorVtaTotalDsctoView.toFixed(2);
							igvVtaTotalDscto = valorVtaTotalDscto*(parseFloat(0.18));
							datainicial[i].precIgvVentaDscto = igvVtaTotalDscto.toFixed(2);
							precioVtaTotalDscto = valorVtaTotalDscto+(parseFloat(igvVtaTotalDscto));
							precioVtaTotalDsctoVista = parseFloat(valorVtaTotalDscto.toFixed(2)) + parseFloat(igvVtaTotalDscto.toFixed(2));
							datainicial[i].precPrecioVentaDscto = precioVtaTotalDsctoVista.toFixed(2);
							datainicial[i].baseImporte = valorVtaTotalDscto.toFixed(2);
							datainicial[i].igv = igvVtaTotalDscto.toFixed(2);
							datainicial[i].totalBruto = precioVtaTotalDsctoVista.toFixed(2);
							datainicial[i].totalNeto = precioVtaTotalDsctoVista.toFixed(2);
							
					} else {
							dsctoPorc = 0.00;
							datainicial[i].importeDesc = dsctoPorc.toFixed(2);
							datainicial[i].precValorVentaDscto = valorVenta.toFixed(2);
							datainicial[i].precIgvVentaDscto = igvVenta.toFixed(2);
							datainicial[i].precPrecioVentaDscto = precioVentaVista.toFixed(2);
							datainicial[i].baseImporte = valorVenta.toFixed(2);
							datainicial[i].igvVenta = igvVenta.toFixed(2);
							datainicial[i].totalBruto = precioVentaVista.toFixed(2);
							datainicial[i].totalNeto = precioVentaVista.toFixed(2);

						}
					datainicial[i].tipoMonedaDestino = codTipoMoneda;
					 
					 
				 }else if(indicadorAfecto == "20" || indicadorAfecto == "30"||indicadorAfecto == "40") {
					 	nuevovalor=valorunitario+(valorunitario*0.18);
						 datainicial[i].valorUnitario = nuevovalor.toFixed(2);
						 igvunitario = valorunitario*(parseFloat(0.00));
						 datainicial[i].igvUnitario = igvunitario.toFixed(2);
						 preciounitarioVista = parseFloat(nuevovalor.toFixed(2)) + parseFloat(igvunitario.toFixed(2));
						 datainicial[i].precioUnitario = preciounitarioVista.toFixed(2);
						 valorVenta = nuevovalor*(parseFloat(cantidad));
						 datainicial[i].valorVenta = valorVenta.toFixed(2);
						 igvVenta = igvunitario*(parseFloat(cantidad));
						 datainicial[i].igvVenta = igvVenta.toFixed(2);
						 precioVenta = preciounitario*(parseFloat(cantidad));
						 precioVentaVista = parseFloat(valorVenta.toFixed(2)) + parseFloat(igvVenta.toFixed(2));
						 datainicial[i].precioVenta = precioVentaVista.toFixed(2);
						 if (datainicial[i].precioDescuento !=null && datainicial[i].precioDescuento == true) {
								dsctoPorc = datainicial[i].porcentaDesc/(parseFloat(100));
								dsctoTotal = nuevovalor*cantidad*(parseFloat(dsctoPorc));
								 datainicial[i].importeDesc = dsctoTotal.toFixed(2);
								 valorVtaTotalDscto = nuevovalor*cantidad-(parseFloat(dsctoTotal.toFixed(2)));
								 datainicial[i].precValorVentaDscto = valorVtaTotalDscto.toFixed(2);
								 igvVtaTotalDscto = valorVtaTotalDscto*(parseFloat(0.00));
								 datainicial[i].precIgvVentaDscto = igvVtaTotalDscto.toFixed(2);
								 precioVtaTotalDscto = valorVtaTotalDscto+(parseFloat(igvVtaTotalDscto));
								 precioVtaTotalDsctoVista = parseFloat(valorVtaTotalDscto.toFixed(2)) + parseFloat(igvVtaTotalDscto.toFixed(2));
								 datainicial[i].precPrecioVentaDscto = precioVtaTotalDsctoVista.toFixed(2);
								 datainicial[i].baseImporte = valorVtaTotalDscto.toFixed(2);
								 datainicial[i].igv = igvVtaTotalDscto.toFixed(2);
								 datainicial[i].totalBruto = precioVtaTotalDsctoVista.toFixed(2);
								 datainicial[i].totalNeto = precioVtaTotalDsctoVista.toFixed(2);
							} else {
								dsctoPorc = 0.00;
								datainicial[i].importeDesc = dsctoPorc.toFixed(2);
								datainicial[i].precValorVentaDscto = valorVenta.toFixed(2);
								datainicial[i].precIgvVentaDscto = igvVenta.toFixed(2);
								datainicial[i].precPrecioVentaDscto = precioVentaVista.toFixed(2);
								datainicial[i].baseImporte = valorVenta.toFixed(2);
								datainicial[i].igvVenta = igvVenta.toFixed(2);
								datainicial[i].totalBruto = precioVentaVista.toFixed(2);
								datainicial[i].totalNeto = precioVentaVista.toFixed(2);
							}
						 datainicial[i].tipoMonedaDestino = codTipoMoneda;

						 
				 } else if(indicadorAfecto == "50") {
					 datainicial[i].valorUnitario = valorunitario.toFixed(2);
					 igvunitario = valorunitario*(parseFloat(0.18));
					 datainicial[i].igvUnitario = igvunitario.toFixed(2);
					 preciounitarioVista = parseFloat(valorunitario.toFixed(2)) + parseFloat(igvunitario.toFixed(2));
					 datainicial[i].precioUnitario = preciounitarioVista.toFixed(2);
//					 valorVenta = valorunitario*(parseFloat(cantidad));
					 valorVenta = (valorunitario.toFixed(2))*(parseFloat(cantidad));
					 datainicial[i].valorVenta = valorVenta.toFixed(2);
					 igvVenta = igvunitario*(parseFloat(cantidad));
					 datainicial[i].igvVenta = igvVenta.toFixed(2);
					 precioVenta = preciounitario*(parseFloat(cantidad));
//					 precioVentaVista = (valorVenta.toFixed(2)) + parseFloat(igvVenta.toFixed(2));
					 precioVentaVista = parseFloat(valorVenta.toFixed(2)) + parseFloat(igvVenta.toFixed(2));
					 datainicial[i].precioVenta = precioVentaVista.toFixed(2);
					 datainicial[i].precValorVentaDscto = valorVenta.toFixed(2);
					 datainicial[i].precIgvVentaDscto = igvVenta.toFixed(2);
					 datainicial[i].precPrecioVentaDscto = precioVentaVista.toFixed(2);
					 datainicial[i].baseImporte = valorVenta.toFixed(2);
					 datainicial[i].igvVenta = igvVenta.toFixed(2);
					 datainicial[i].tipoMonedaDestino = codTipoMoneda;
				 } else {
					 datainicial[i].valorUnitario = valorunitario.toFixed(2);
					 datainicial[i].precioUnitario = valorunitario.toFixed(2);
					 valorVenta = valorunitario*(parseFloat(cantidad));
					 datainicial[i].valorVenta = valorVenta.toFixed(2);
					 datainicial[i].precioVenta = valorVenta.toFixed(2);
					 if (datainicial[i].precioDescuento !=null && datainicial[i].precioDescuento == true) {
							dsctoPorc = datainicial[i].porcentaDesc/(parseFloat(100));
						} else {
							dsctoPorc = 0.00;
						}
					 dsctoTotal = valorunitario*cantidad*(parseFloat(dsctoPorc));
					 datainicial[i].importeDesc = dsctoTotal.toFixed(2);
					 valorVtaTotalDscto = valorunitario*cantidad-(parseFloat(dsctoTotal.toFixed(2)));
					 datainicial[i].precValorVentaDscto = valorVtaTotalDscto.toFixed(2);
					 datainicial[i].precPrecioVentaDscto = valorVtaTotalDscto.toFixed(2);
					 datainicial[i].baseImporte = valorVtaTotalDscto.toFixed(2);
					 datainicial[i].totalBruto = valorVtaTotalDscto.toFixed(2);
					 datainicial[i].totalNeto = valorVtaTotalDscto.toFixed(2);
					 datainicial[i].tipoMonedaDestino = codTipoMoneda;
				 }
				 datafinal.push(datainicial[i]);
		 }
		 console.log(datafinal);
		 $("#lstProductoVenta").DataTable().rows().remove();
		 $("#lstProductoVenta").DataTable().rows.add(datafinal).draw();
		 obj.calculaValor();
		
	}
	
	RegistroVenta.prototype.totLetras = function() {
		var obj=this;
		
		var o=new Array("DIEZ", "ONCE", "DOCE", "TRECE", "CATORCE", "QUINCE", "DIECISÉIS", "DIECISIETE", "DIECIOCHO", "DIECINUEVE", "VEINTE", "VEINTIUNO", "VEINTIDÓS", "VEINTITRÉS", "VEINTICUATRO", "VEINTICINCO", "VEINTISÉIS", "VEINTISIETE", "VEINTIOCHO", "VEINTINUEVE");
		var u=new Array("CERO", "UNO", "DOS", "TRES", "CUATRO", "CINCO", "SEIS", "SIETE", "OCHO", "NUEVE");
		var d=new Array("", "", "", "TREINTA", "CUARENTA", "CINCUENTA", "SESENTA", "SETENTA", "OCHENTA", "NOVENTA");
		var c=new Array("", "CIENTO", "DOSCIENTOS", "TRESCIENTOS", "CUATROCIENTOS", "QUINIENTOS", "SEISCIENTOS", "SETECIENTOS", "OCHOCIENTOS", "NOVECIENTOS");
		var tot = parseFloat($("#frmResultadoTotal").val());
		function nn(n)
		{
		  /*OJO: no hay tercer parámetro*/
		  var n=parseFloat(n).toFixed(2); /*se limita a dos decimales, no sabía que existía toFixed() :)*/
		  var p=n.toString().substring(n.toString().indexOf(".")+1); /*decimales*/
		  var m=n.toString().substring(0,n.toString().indexOf(".")); /*número sin decimales*/
		  var m=parseFloat(m).toString().split("").reverse(); /*tampoco que reverse() existía :D*/
		  var t="";

		  /*Se analiza cada 3 dígitos*/
		  for (var i=0; i<m.length; i+=3)
		  {
		    var x=t;
		    /*formamos un número de 2 dígitos*/
		    var b=m[i+1]!=undefined?parseFloat(m[i+1].toString()+m[i].toString()):parseFloat(m[i].toString());
		    /*analizamos el 3 dígito*/
		    t=m[i+2]!=undefined?(c[m[i+2]]+" "):"";
		    t+=b<10?u[b]:(b<30?o[b-10]:(d[m[i+1]]+(m[i]=='0'?"":(" Y "+u[m[i]]))));
		    t=t=="CIENTO CERO"?"CIEN":t;
		    if (2<i&&i<6)
		      t=t=="UNO"?"MIL ":(t.replace("UNO","UN")+" MIL ");
		    if (5<i&&i<9)
		      t=t=="UNO"?"UN MILLÓN ":(t.replace("UNO","UN")+" MILLONES ");
		    t+=x;
		    //t=i<3?t:(i<6?((t=="uno"?"mil ":(t+" mil "))+x):((t=="uno"?"un millón ":(t+" millones "))+x));
		  }
	     
		  if($("#listaCatDetMoneda").val()==1){
			  t+=" CON "+p+"/100" +" SOLES"; 
		  }else{
			  t+=" CON "+p+"/100" +" DOLARES AMERICANOS";
		  }
		  /*correcciones*/
		  t=t.replace("  "," ");
		  t=t.replace(" CERO","");
		  $("#frmResultadoMonto").val(t);
		  return t;
		
		}
		
		nn($("#frmResultadoTotal").val());
		
		
	}
	
	RegistroVenta.prototype.calculoprodeditargrilla = function() {
		var obj = this;
		var valorVenta=$("#frmEditarVentaValorVunit").val();
	  	var pVenta=$("#frmEditarVentaPrecUn").val();
	  	var cantidad=$("#frmEditarVentaCant").val();
	  	var originalcant=$("#cantidadrestar").val();
	  	var otrosatrib=$("#frmEditarOtrosAtrib").val();
	  	var precioVenta=0;
	  	var valvta=0;
	  	var igv=0;
	  	var cantidadnueva=0;
	  	if(cantidad==""){
	  		bootbox.alert("<label class='text-danger'>El monto de cantidad es menor al valor establecido! Revisar antes de continuar!</label>");
	  	}else if(parseFloat(valorVenta)>0){
	  		    cantidadnueva=parseFloat(originalcant)-parseFloat(cantidad);
	      		igv=((parseFloat(valorVenta))*0.18);
	      		precioVenta=parseFloat(valorVenta)+parseFloat(igv);
	      		$("#frmEditarVentaPrecUn").val(precioVenta.toFixed(2));     		
	      		$("#frmEditarVentaIGV").val(igv.toFixed(2));  
	      	} 
	}
	
	RegistroVenta.prototype.countMonto = function(filterCount) {
		var obj=this;
		var sumaTotal=0;
		$.map(obj.lstDataTableProductoVenta.rows().data(), function (item) {
			sumaTotal=sumaTotal+parseFloat(item[filterCount]);
	    });
		return sumaTotal;
	}
	
	RegistroVenta.prototype.countMontoExp = function(filterCoin,filterCount) {
		var obj=this;
		var sumaTotal=0;
		var tipoCambio = $("#tipoCambio").val();
		$.map($('#lstExploradorVenta').DataTable().rows().data(), function (item) {
			var moneda = (item[filterCoin]);
			var strEx = (item[filterCount]);
			strEx = strEx.replace(/\,/g,'');
			if (moneda == "USD"){
				strEx = strEx*tipoCambio
			}
			sumaTotal=parseFloat(sumaTotal.toFixed(2))+parseFloat(strEx);
	    });
		var sumaTotalView=sumaTotal.toFixed(2);
		console.log("sumaView"+sumaTotalView);
		return sumaTotal;
	}
	
	RegistroVenta.prototype.countMontoConversion = function(filterCount) {
		if($('#listaCatDetMoneda').val()=='1'){
			$('#viewSoles').show();
			$('#viewDollar').hide();
			var obj=this;
			var sumaTotal=0;
			var tipCambio =  $('#listaTipCambio').find(":selected").attr('attr-venta');
			$.map(obj.lstDataTableProductoVenta.rows().data(), function (item) {
				sumaTotal=sumaTotal+parseFloat(item[filterCount])/tipCambio;
			});
		return sumaTotal;
		} else {
			$('#viewSoles').hide();
			$('#viewDollar').show();
			var obj=this;
			var sumaTotal=0;
			var tipCambio =  $('#listaTipCambio').find(":selected").attr('attr-venta');
			$.map(obj.lstDataTableProductoVenta.rows().data(), function (item) {
				sumaTotal=sumaTotal+parseFloat(item[filterCount])*tipCambio;
		    });
			return sumaTotal;
		}
	}
	
	RegistroVenta.prototype.calculaValor = function() {
		var obj=this;
		
		var o=new Array("DIEZ", "ONCE", "DOCE", "TRECE", "CATORCE", "QUINCE", "DIECISÉIS", "DIECISIETE", "DIECIOCHO", "DIECINUEVE", "VEINTE", "VEINTIUNO", "VEINTIDÓS", "VEINTITRÉS", "VEINTICUATRO", "VEINTICINCO", "VEINTISÉIS", "VEINTISIETE", "VEINTIOCHO", "VEINTINUEVE");
		var u=new Array("CERO", "UNO", "DOS", "TRES", "CUATRO", "CINCO", "SEIS", "SIETE", "OCHO", "NUEVE");
		var d=new Array("", "", "", "TREINTA", "CUARENTA", "CINCUENTA", "SESENTA", "SETENTA", "OCHENTA", "NOVENTA");
		var c=new Array("", "CIENTO", "DOSCIENTOS", "TRESCIENTOS", "CUATROCIENTOS", "QUINIENTOS", "SEISCIENTOS", "SETECIENTOS", "OCHOCIENTOS", "NOVECIENTOS");
	    var tot = obj.countMonto("totalNeto").toFixed(2);
		function nn(n)
		{
		  /*OJO: no hay tercer parámetro*/
		  var n=parseFloat(n).toFixed(2); /*se limita a dos decimales, no sabía que existía toFixed() :)*/
		  var p=n.toString().substring(n.toString().indexOf(".")+1); /*decimales*/
		  var m=n.toString().substring(0,n.toString().indexOf(".")); /*número sin decimales*/
		  var m=parseFloat(m).toString().split("").reverse(); /*tampoco que reverse() existía :D*/
		  var t="";
	
		  /*Se analiza cada 3 dígitos*/
		  for (var i=0; i<m.length; i+=3)
		  {
		    var x=t;
		    /*formamos un número de 2 dígitos*/
		    var b=m[i+1]!=undefined?parseFloat(m[i+1].toString()+m[i].toString()):parseFloat(m[i].toString());
		    /*analizamos el 3 dígito*/
		    t=m[i+2]!=undefined?(c[m[i+2]]+" "):"";
		    t+=b<10?u[b]:(b<30?o[b-10]:(d[m[i+1]]+(m[i]=='0'?"":(" Y "+u[m[i]]))));
		    t=t=="CIENTO CERO"?"CIEN":t;
		    if (2<i&&i<6)
		      t=t=="UNO"?"MIL ":(t.replace("UNO","UN")+" MIL ");
		    if (5<i&&i<9)
		      t=t=="UNO"?"UN MILLÓN ":(t.replace("UNO","UN")+" MILLONES ");
		    t+=x;
		    //t=i<3?t:(i<6?((t=="uno"?"mil ":(t+" mil "))+x):((t=="uno"?"un millón ":(t+" millones "))+x));
		  }
	     
		  if($("#listaCatDetMoneda").val()==1){
			  t+=" CON "+p+"/100" +" SOLES"; 
		  }else{
			  t+=" CON "+p+"/100" +" DOLARES AMERICANOS";
		  }
		  /*correcciones*/
		  t=t.replace("  "," ");
		  t=t.replace(" CERO","");
		  $("#frmResultadoMonto").val(t);
		  return t;
		
		}   	
		
		
		var codia=$("#listaCatDetIndicador").val();
		if(codia=="10"){
	    	$("#frmResultadoINF").val("0.00");
	    	$("#frmResultadoExonerado").val("0.00");
	    	$("#frmResultadoExportacion").val("0.00");
	//    	$("#frmResultadoBIM").val(obj.countMonto("totalNeto").toFixed(2));
	    	$("#frmResultadoBIM").val(obj.countMonto("baseImporte").toFixed(2));
	    	
	    	//MONTOS TOTALES
	    	$("#frmResultadoVentaGratuita").val("0.00");
	    	$("#frmResultadoValorTotal").val(obj.countMonto("valorVenta").toFixed(2));
	    	$("#frmResultadoImpDescTot").val(obj.countMonto("importeDesc").toFixed(2));
	    	$("#frmResultadoNeto").val(obj.countMonto("precValorVentaDscto").toFixed(2));
	    	$("#frmResultadoIGV").val(obj.countMonto("igv").toFixed(2));
	    	$("#frmResultadoTotal").val(obj.countMonto("totalNeto").toFixed(2));
	    	$("#frmResultadoTotalView").val(obj.countMonto("totalNeto").toFixed(2));
	    	$("#frmResultadoConver").val(obj.countMontoConversion("totalNeto").toFixed(2));
	
	    	
	    	
	    	  nn($("#frmResultadoTotal").val());
	    	    	
		}else if(codia=="20"){
			$("#frmResultadoINF").val("0.00");
	//    	$("#frmResultadoExonerado").val(obj.countMonto("valorVenta").toFixed(2));
	    	$("#frmResultadoExonerado").val(obj.countMonto("baseImporte").toFixed(2));
	    	$("#frmResultadoExportacion").val("0.00");
	    	$("#frmResultadoBIM").val("0.00");
	    	//MONTOS TOTALES
	    	$("#frmResultadoVentaGratuita").val("0.00");
	    	$("#frmResultadoValorTotal").val(obj.countMonto("valorVenta").toFixed(2));
	    	$("#frmResultadoImpDescTot").val(obj.countMonto("importeDesc").toFixed(2));
	    	$("#frmResultadoNeto").val(obj.countMonto("precValorVentaDscto").toFixed(2));
	    	$("#frmResultadoIGV").val("0.00");
	    	$("#frmResultadoTotal").val(obj.countMonto("totalNeto").toFixed(2));
	    	$("#frmResultadoTotalView").val(obj.countMonto("totalNeto").toFixed(2));
	    	$("#frmResultadoConver").val(obj.countMontoConversion("totalNeto").toFixed(2));
	    	 nn($("#frmResultadoTotal").val());
	    }else if(codia=="30"){
	//    	$("#frmResultadoINF").val(obj.countMonto("valorVenta").toFixed(2));
	    	$("#frmResultadoINF").val(obj.countMonto("baseImporte").toFixed(2));
	    	$("#frmResultadoExonerado").val("0.00");
	    	$("#frmResultadoExportacion").val("0.00");
	    	$("#frmResultadoBIM").val("0.00");
	    	//MONTOS TOTALES
	    	$("#frmResultadoVentaGratuita").val("0.00");
	    	$("#frmResultadoValorTotal").val(obj.countMonto("valorVenta").toFixed(2));
	    	$("#frmResultadoImpDescTot").val(obj.countMonto("importeDesc").toFixed(2));
	    	$("#frmResultadoNeto").val(obj.countMonto("precValorVentaDscto").toFixed(2));
	    	$("#frmResultadoIGV").val("0.00");
	    	$("#frmResultadoTotal").val(obj.countMonto("totalNeto").toFixed(2));
	    	$("#frmResultadoTotalView").val(obj.countMonto("totalNeto").toFixed(2));
	    	$("#frmResultadoConver").val(obj.countMontoConversion("totalNeto").toFixed(2));
	    	 nn($("#frmResultadoTotal").val());
	    }else if(codia=="40"){
	    	$("#frmResultadoINF").val("0.00");
	    	$("#frmResultadoExonerado").val("0.00");
	//    	$("#frmResultadoExportacion").val(obj.countMonto("valorVenta").toFixed(2));
	    	$("#frmResultadoExportacion").val(obj.countMonto("baseImporte").toFixed(2));
	    	$("#frmResultadoBIM").val("0.00");
	    	//MONTOS TOTALES
	    	$("#frmResultadoVentaGratuita").val("0.00");
	    	$("#frmResultadoValorTotal").val(obj.countMonto("valorVenta").toFixed(2));
	    	$("#frmResultadoImpDescTot").val(obj.countMonto("importeDesc").toFixed(2));
	    	$("#frmResultadoNeto").val(obj.countMonto("precValorVentaDscto").toFixed(2));
	    	$("#frmResultadoIGV").val("0.00");
	    	$("#frmResultadoTotal").val(obj.countMonto("totalNeto").toFixed(2));
	    	$("#frmResultadoTotalView").val(obj.countMonto("totalNeto").toFixed(2));
	    	$("#frmResultadoConver").val(obj.countMontoConversion("totalNeto").toFixed(2));
	    	 nn($("#frmResultadoTotal").val());
	    }else if(codia=="50"){
	    	$("#frmResultadoINF").val("0.00");
	    	$("#frmResultadoExonerado").val("0.00");
	    	$("#frmResultadoExportacion").val("0.00");
	    	$("#frmResultadoBIM").val("0.00");
	    	//MONTOS TOTALES
	    	$("#frmResultadoVentaGratuita").val(obj.countMonto("baseImporte").toFixed(2));
	    	$("#frmResultadoValorTotal").val(obj.countMonto("valorVenta").toFixed(2));
	    	$("#frmResultadoImpDescTot").val("0.00");
	    	$("#frmResultadoNeto").val(obj.countMonto("valorVenta").toFixed(2));
	    	$("#frmResultadoIGV").val(obj.countMonto("igv").toFixed(2));
	    	$("#frmResultadoTotal").val("0.00");
	    	$("#frmResultadoTotalView").val("0.00");
	    	$("#frmResultadoConver").val("0.00");
	    	 nn($("#frmResultadoTotal").val());
	    }
		if($('#frmResultadoVentaAnticipo').val()>0){
			obj.restarMontoTotalAnticipo();
		}
		
	}
	
	RegistroVenta.prototype.listarProductoVenta = function() {
		var obj = this;
		obj.lstDataTableProductoVenta = obj.ProductoVenta
				.DataTable({
					"sPaginationType" : "simple_numbers",
	//				"scrollX" : true,
	//				"sScrollX" : "100%",
					"bScrollCollapse" : true,
					"order" : false,
					"bSort" : false,
					"paging": false,
					"destroy": true,	
					"serverSide" : false,
					"dom" : '<"row"<"col-md-12 addButtonHere">><"row"<"col-md-12"tr>><"row"<"col-md-8"i><"col-md-4 text-right"p>>',
					"pagingType": "simple_numbers",
					"lengthMenu" : [10, 25, 50, 100],
					"pageLength": 5,
			        "paging": true,
			        "Paginate" : true,						
					"ajax": {	
							
				            "url": "/SistemaFE/registroventa/MostrarDetalle"+"?"+"codDet="+$('#idAlmacen').val(),
				            "type": "POST"
						
				        },
					"columnDefs" : [
							{
								"targets" : 0,
								"data" : "sel",
								"defaultContent" : "",
								"className" : "text-center",
								"orderable" : false,
								"render" : function(data, type, full, meta) {
									return "<input type='checkbox' class='flat'  />";
								}
							},
							{
								"targets" : 1,
								"data" : "accion",
								"defaultContent" : "",
								"className" : "text-center",
								"orderable" : false,
								"width" : "100px",
								"render" : function(data, type, full, meta) {
									if($("#listaCatDetComp").val()!="" && $("#VerDet").val()==""){
										//Se comento la validacion por que pidieron que sea modificable para todo tipo de comprobante
									//	if($("#listaCatDetComp").val()=="07" || $("#listaCatDetComp").val()=="08"){	
											var estado = "disabled";
											return "<button type='button' class='fa fa-trash-o btnDeleteVenta btn btn-danger btn-sm' id='btnDeshabilitar' title ='Inhabilitar' onclick='formReset()' value='Reset' "
													+ "attr-tipo='"
													+ full.tipoRegistro
													+ "'"
													+ "attr-idDetVenta='"
													+ full.detailBident
													+"'"
													+ " attr-idStore='"
													+ full.codigoAlmacen
													+ "'"
													+ ""
													+ "> </button> "
													+"<button type='button' class='btn btn-warning fa fa-edit btn-sm btnEditarGrilla ladda-button' title ='Editar Columna'"
													+ " attr-idStore='"
													+ full.codigoAlmacen
													+ "'"
													+ " attr-user='"
													+ full.numerodeprecio
													+ "'"
													+ " attr-valVenta='"
													+ full.valorUnitario
													+ "'"
													+ " attr-cantidad='"
													+ full.cantidad
													+ "'"
													+ " attr-preVenta='"
													+ full.precioUnitario
													+ "'"
													+ " attr-descuento='"
													+ full.importeDesc
													+ "'"
													+ " attr-idOrden='"
													+ full.numero
													+ "'"
													+ " attr-codigo='"
													+ full.codigo
													+ "'"
													+ " attr-idProd='"
													+ full.prodBident
													+ "'"
													+ " > </button> ";
											//Se comento la validacion por que pidieron que sea modificable para todo tipo de comprobante
									//	}else  {
	//										var estado = "enabled";
	//										return "<button type='button' class='fa fa-trash-o btnDeleteVenta btn btn-danger btn-sm' id='btnDeshabilitar' title ='Inhabilitar' onclick='formReset()' value='Reset' "
	//												+ "attr-tipo='"
	//												+ full.tipoRegistro
	//												+ "'"
	//												+ "attr-idDetVenta='"
	//												+ full.detailBident
	//												+"'"
	//												+ " attr-idStore='"
	//												+ full.codigoAlmacen
	//												+ "'"
	//												+ ""
	//												+ estado
	//												+ "> </button> ";
										//}
									} else {
									if($("#VerDet").val()!=""){	
									var estado = "disabled";
									return "<button type='button' class='fa fa-trash-o btnDeleteVenta btn btn-danger btn-sm' id='btnDeshabilitar' title ='Inhabilitar' onclick='formReset()' value='Reset' "
											+ "attr-tipo='"
											+ full.tipoRegistro
											+ "'"
											+ "attr-idDetVenta='"
											+ full.detailBident
											+"'"
											+ " attr-idStore='"
											+ full.codigoAlmacen
											+ "'"
											+ ""
											+ estado
											+ "> </button> "
											+"<button type='button' class='btn btn-warning fa fa-edit btn-sm btnEditarGrilla ladda-button' title ='Editar Columna'"
											+ " attr-user='"
											+ full.numerodeprecio
											+ "'"
											+ estado
											+ " > </button> ";
								}else  {
									var estado = "enabled";
									return "<button type='button' class='fa fa-trash-o btnDeleteVenta btn btn-danger btn-sm' id='btnDeshabilitar' title ='Inhabilitar' onclick='formReset()' value='Reset' "
											+ "attr-tipo='"
											+ full.tipoRegistro
											+ "'"
											+ "attr-idDetVenta='"
											+ full.detailBident
											+ "'"
											+ " attr-idStore='"
											+ full.codigoAlmacen
											+ "'"
											+ ""
											+ estado
											+ "> </button> "
											+"<button type='button' class='btn btn-warning fa fa-edit btn-sm btnEditarGrilla ladda-button' title ='Editar columna'"
											+ " attr-user='"
											+ full.numerodeprecio
											+ "'"
											+ " > </button> ";
								}
									
							}
								}
							},
							{
								"targets" : 2,
								"data" : "numero"
							},
							{
								"targets" : 3,
								"data" : "claseSunat"
							},
							{
								"targets" : 4,
								"visible" : false,
								"data" : "codigoAlmacen"
							},
							{
								"targets" : 5,
								"data" : "codigoComercial"
							},
							{
								"targets" : 6,
								"data" : "concepto"
							},
							{
								"targets" : 7,
								"data" : "UnidadMedida"
							},
							{
								"targets" : 8,
								"data" : "cantidad"
							},
							{
								"targets" : 9,
								"data" : "valorUnitario"
							},
							{
								"targets" : 10,
								"data" : "igvUnitario"
							},
							{
								"targets" : 11,
								"data" : "precioUnitario"
							},
							{
								"targets" : 12,
								"data" : "valorVenta"
							},
							{
								"targets" : 13,
								"data" : "igvVenta"
							},
							{
								"targets" : 14,
								"data" : "precioVenta"
							},
							{
								"targets" : 15,
								"data" : "porcentaDesc"
							},
							{
								"targets" : 16,
								"data" : "importeDesc"
							},
							{
								"targets" : 17,
								"data" : "precValorVentaDscto"
							},
							{
								"targets" : 18,
								"data" : "precIgvVentaDscto"
							},
							{
								"targets" : 19,
								"data" : "precPrecioVentaDscto"
							},
							{
								"targets" : 20,
								"data" : "baseImporte"
							},						
							{
								"targets" : 21,
								"data" : "igv"
							},
							{
								"targets" : 22,
								"data" : "totalBruto"
							},
							{
								"targets" : 23,
								"data" : "totalNeto"
							},
							{
								"targets" : 24,
								"data" : "indicadorAfecto"
							},
							{
								"targets" : 25,
								"data" : "tipoIndicadorAfecto"
							},
							{
								"targets" : 26,
								"data" : "accion",
								"defaultContent" : "",
								"className" : "text-center",
								"orderable" : false,
								"width" : "100px",
								"render" : function(data, type, full, meta) {
										var estado = "";
										if (full.precDescripMoneda == 1) {
											return "<div class='badge bg-blue'>"
													+ "Soles" + "</div>";
										} else if (full.precDescripMoneda == 2) {
											return "<div class='badge' style='background-color: #15a01f;' >"
													+ "Dolares" + "</div> ";
										} else if (full.precDescripMoneda == 3) {
											return "<div class='badge bg-red'>"
												+ "Euro" + "</div> ";
										} else if (full.precDescripMoneda == 4) {
											return "<div class='badge bg-orange'>"
												+ "Yen" + "</div> ";
										}
									}
							},
							{
								"targets" : 27,
								"data" : "accion",
								"defaultContent" : "",
								"className" : "text-center",
								"orderable" : false,
								"width" : "100px",
								"render" : function(data, type, full, meta) {
										var estado = "";
										if (full.tipoMonedaDestino == 1) {
											return "<div class='badge bg-blue'>"
													+ "Soles" + "</div>";
										} else if (full.tipoMonedaDestino == 2) {
											return "<div class='badge' style='background-color: #15a01f;' >"
													+ "Dolares" + "</div> ";
										} else if (full.tipoMonedaDestino == 3) {
											return "<div class='badge bg-red'>"
												+ "Euro" + "</div> ";
										} else if (full.tipoMonedaDestino == 4) {
											return "<div class='badge bg-orange'>"
												+ "Yen" + "</div> ";
										}
									}
							},
							{
								"targets" : 28,
								"data" : "tipoCambioVenta"
							},
							{
								"targets" : 29,
								"data" : "transferencia"
							},
							
							{
								"targets" : 30,
								"data" : "observacion"
							}
							,
							{
								"targets" : 31,
								"visible": false,
								"data" : "tipoRegistro"
							},
							{
								"targets" : 32,
								"visible": false,
								"data" : "codigoAlmacen"
							},
							{
								"targets" : 33,
								"visible": false,
								"data" : "nomcorto"						
							},
							{
								"targets" : 34,
								"visible": false,
								"data" : "Descripcion"
							}
							//preciodescripcion
							,
							{
								"targets" : 35,
								"visible": false,
								"data" : "preciodescripcionproducto"
							}
							,
							{
								"targets" : 36,
								"visible": false,
								"data" : "esprecioprincipal"
							}
							,
							{
								"targets" : 37,
								"visible": false,
								"data" : "nombremarca"
							}
							,
							{
								"targets" : 38,
								"visible": false,
								"data" : "nombrecortomarca"
							}
							,		
							{
								"targets" : 39,
								"visible": false,
								"data" : "nombredescripcionmarca"
							}
						,
						{
							"targets" : 40,
							"visible": false,
							"data" : "preciodescripcion"
						}
						,
						{
							"targets" : 41,
							"visible": false,
							"data" : "precioInicial"
						}
							],
					"preDrawCallback" : function(settings) {
						var api = new $.fn.dataTable.Api(settings);
						var pagination = $(this).closest('.dataTables_wrapper')
								.find('.dataTables_paginate');
						pagination.toggle(api.page.info().pages > 1);
					}
				});
		obj.lstDataTableProductoVenta.on( 'order.dt search.dt', function () {
			obj.lstDataTableProductoVenta.column(2, {search:'applied', order:'applied'}).nodes().each( function (cell, i) {
	            cell.innerHTML = i+1;
	        } );
	    } ).draw();
	}	
	RegistroVenta.prototype.reloadDataTableExploradorVenta = function() {
		this.ExploradorVentas.DataTable().ajax.url("/SistemaFE/registroventa/lista_ventas"+"?"+$('#frm_filtrarVenta').serialize()).load();
		var sumaTotalPen=0;
		var sumaTotalUsd=0;
		$.map($('#lstExploradorVenta').DataTable().rows().data(), function (item) {
			var tipoCambio = (item['dexchange_rate']);
			var moneda = (item['vname_coin']);
			var strEx = (item['dresult_total']);
			strEx = strEx.replace(/\,/g,'');
			console.log("strEx "+strEx);
			var montoPen = 0;
			var montoUsd = 0;
			if (moneda == "PEN"){
				montoPen = strEx;
				montoUsd = strEx/tipoCambio;
				montoUsd = montoUsd.toFixed(2);
			} else if (moneda == "USD"){
				montoPen = strEx*tipoCambio;
				montoUsd = strEx;
				montoPen = montoPen.toFixed(2);
			}
			console.log("strExCam "+strEx);
			sumaTotalPen=parseFloat(sumaTotalPen.toFixed(2))+parseFloat(montoPen);
			sumaTotalUsd=parseFloat(sumaTotalUsd.toFixed(2))+parseFloat(montoUsd);
	    });
		var sumaTotalPenView=sumaTotalPen.toFixed(2);
		var sumaTotalUsdView=sumaTotalUsd.toFixed(2);
		$("#frmResultadoTotal").val(sumaTotalPenView);
		$("#frmResultadoTotalConversion").val(sumaTotalUsdView);
		
	}
	
	RegistroVenta.prototype.listarExploradorVenta = function() {
		
		var table = $('#lstExploradorVenta').DataTable({
			"dom": 'Bfrt<"col-md-6 inline"i> <"col-md-6 inline"p>',
	         "buttons": {
	             'dom': {
	               'container':{
	                 'tag':'div',
	                 'className':'flexcontent'
	               },
	               'buttonLiner': {
	                 'tag': null
	               }
	             },
	             "buttons": [
	                 'colvis'
	             ],
	         },
			        "scrollY" : "500px",
					"scrollX" : true,
					"sScrollX" : "100%",
					"bScrollCollapse" : true,
					"sProcessing" : "Procesando...",
					"serverSide" : true,
					"order": [[7, 'desc']],
					 "fixedColumns":   {
				            "leftColumns": 2,
				            "rightColumns": 0
				        },
			        "pagingType": "numbers",
					"lengthMenu" : [100, 250, 500, 1000],
					"pageLength": 100,
			        "paging": true,
			        "Paginate" : true,
			        
			        "ajax": {
			            "url": "/SistemaFE/registroventa/lista_ventas"+"?"+$('#frm_filtrarVenta').serialize(),
			            "type": "POST"
			        },
			        "language": {
	//		        	"url": "dataTables.german.lang"
			            "url": "https://cdn.datatables.net/plug-ins/1.10.11/i18n/Spanish.json"
			        },
					"columnDefs" : [
						 
			        	{
			                "targets": 0,
			                "data": "accion", "defaultContent": "",
			                "className": "text-center",
			                "width": '20%',
			                "render": function (data, type, full, meta) {
			                	var estado="";
			                	var estadoEd="";
			                	var estadoAn="";
			                	var estadoDB="";
			                	var estadoPDF="";
			                	if (full.saleCstate == 1) {
									var estadoEd="disabled";
				                	var estadoAn="disabled";
			                	} else if (full.saleCstate == 2) {
									var estadoEd="disabled";
									var estadoDB="disabled";
			                	}
			                	if (full.vtipdocvoucher == "NV") {
			                		estadoDB="disabled"
			                    } else {
			                    	if(full.voucEnvioSunat!=""){
			                    		var fechaHoy = new Date();
			                    		var fecAux = full.sdetTmovementDate;
			                			var res = fecAux.split(" ");
			                			var arr = res[0].split('-');
			                    		var fechaVentaVar=arr[2] +"-"+ arr[1] +"-"+ arr[0];					
			                    		var fechaMov = new Date(fechaVentaVar);
			                    		var fechaMovP = new Date(fechaVentaVar);
			                    		var dias = 7; // Número de días a agregar
			                    		fechaMovP.setDate(fechaMovP.getDate()+1 + dias);
			                    		if(fechaMovP > fechaHoy){
			                    			estadoAn="disabled";
			                    			estadoEd="disabled"
			                    		} else {
			                    			estadoAn="disabled";
			                    			estadoEd="disabled";
			                    			estadoDB="disabled"
			                    		}
			                    	} else {
			                    		estadoDB="disabled"
			                    	}
			                    	
			                    } 
			                    return 	"<button type='button' class='btn btn-info fa fa-eye btn-sm btnVerDetVenta ladda-button' title ='Ver Detalle'" +
			                    " attr-user='"+full.saleBident+"'"+ " attr-emple='"+full.busiBident+"'+  attr-natu='"+full.busiBident+"'"+ " attr-lega='"+full.busiBident+"'"+
			                    		" > </button> " +
			                    		"<button type='button' class='fa fa-edit editar btn btn-warning btn-sm' id='btnEditar' title ='Editar' " +
			                    		" attr-user='"+full.saleBident+"'"+" attr-lega='"+full.busiBident+"'"+" attr-nrodoc='"+full.vnumbervoucher+"'"+" attr-serie='"+full.vserievoucher+"'"+
			                            ""+estadoEd+"> </button> " +
			                            "<button type='button' class='fa fa-ban delete btn btn-primary btn-sm' id='btnDeshabilitar' title ='Anular' " +
			                            " attr-user='"+full.saleBident+"'"+" attr-nrodoc='"+full.vnumbervoucher+"'"+" attr-serie='"+full.vserievoucher+"'"+
			                            ""+estadoAn+"> </button> " +
			                            "<button type='button' class='fa fa-arrow-down baja btn btn-info btn-sm' id='btnDarBaja' title ='Dar de Baja' " +
			                            " attr-idVta='"+full.saleBident+"'"+" attr-nrodoc='"+full.vnumbervoucher+"'"+" attr-estado='"+full.saleCstate+"'"+" attr-serie='"+full.vserievoucher+"'"+""+
			                            ""+estadoDB+"> </button> "
			                            +
			                            "<button type='button' class='fa fa-file-pdf-o dPDF btn btn-danger btn-sm' attr-tipo='2' "+" attr-idVenta='"+full.saleBident+"'"+""+""+estadoPDF+" title ='Descargar PDF'> </button> "
			                            //"<button type='button' class='btn btn-danger fa fa-file-pdf-o msjBoton btn-sm dPDF' attr-tipo='2' "+" attr-url='"+full.voucUrlPDF+"'"+" title ='Descargar PDF'></button>"
			                           ;
			                }
			            },
			                {"targets" : 1,"visible": false,"data" : "vcodReg"},
							{"targets" : 2,"visible": false,"data" : "vperiod"},
							{"targets" : 3,"visible": false,"data" : "vOfficePlace"},
							{"targets" : 4,
								 type:   'datetime',
								"data" : "sdetTmovementDate"
								
								},
							{"targets" : 5,"visible": false,"data" : "vwaypay_name"},
							{"targets" : 6,"visible": false,"data" : "sdetTexpiryDate"},
							{"targets" : 7,"data" : "vtipdocvoucher"},						
							{"targets" : 8,"data" : "vserievoucher"},
							{"targets" : 9,"data" : "vnumbervoucher"},
							{"targets" : 10,"visible": false,"data" : "vtype_doc_clie"},
							{"targets" : 11,"data" : "bnumber_doc_clie"},						
							{"targets" : 12,"data" : "vbusiname_clie"},	
							{"targets" : 13,"data" : "dresult_exporta"},
							{"targets" : 14,"data" : "dresult_grav"},
							{"targets" : 15,"data" : "dresult_exo"},
							{"targets" : 16,"data" : "dresult_inf"},
							{"targets" : 17,"data" : "dresult_igv"},
							{"targets" : 18,"data" : "dresult_discountglobal"},
							{"targets" : 19,"data" : "dresult_total"},
							{"targets" : 20,"visible": false,"data" : "dexchange_rate"},
							{"targets" : 21,"visible": false,"data" : "vname_coin"},						
	//						{"targets" : 22,"data" : "sale_tdoc_referece_date"},
							{"targets" : 22,"visible": false,"data" : "sale_vcod_tip_referece"},
							{"targets" : 23,"visible": false,"data" : "sale_vserie_doc_referece"},
							{"targets" : 24,"visible": false,"data" : "sale_vnum_doc_referece"},
							{"targets" : 25,"visible": false,"data" : "dresult_affair"},	
							{"targets" : 26,"visible": false,"data" : "vtype_doc_seller"},	
							{"targets" : 27,"visible": false,"data" : "bnumber_doc_seller"},	
							{"targets" : 28,"visible": false,"data" : "vbusiname_seller"},	
	
							{"targets" : 29,"visible": false,"data" : "SaleVguide"},	
							{"targets" : 30,"visible": false,"data" : "SaleVorderpurchase"},	
							 {		 
				                "targets":  31,
				                "visible": false,
				            	"data" : "accion",
								"defaultContent" : "",
								"className" : "text-center",
								"orderable" : false,
								"width" : "100px",
								"render" : function(data, type, full, meta) {
									var estado = "";
									if (full.saleCstate == 1) {
										return "<div class='badge bg-red'>" + "Anulado"
										+ "</div>";
								} else if (full.saleCstate == 2) {
									return "<div class='badge bg-red'>" + "Baja"
									+ "</div>";
								} else {
									return "<div class='badge' style='background-color: #15a01f;' >"
										+ "Activo" + "</div> ";
								}
									
									
									
								}
				            },
				            {
				                "targets": 32,
				                "visible": false,
				                "data": "accion", "defaultContent": "",
				                "className": "text-center",
				                "orderable": false,
				                "width": "100px",
				                "render": function (data, type, full, meta) {
				                	var estado="";
				                    if(full.voucEnvioSunat!=""){
				                    	return 	"<div class='badge' style='background-color: #15a01f;'>SI</div> ";
				                    } else if(full.voucEnvioSunat==""){
				                    	return 	"<div class='badge bg-red'>NO</div>";
				                    }/*else {
				                    	return 	"<div class='badge bg-red'>NO</div>";
				                    }*/
				                   
				                }
				            },
				            {
				                "targets": 33,
				                "data": "accion", "defaultContent": "",
				                "className": "text-center",
				                "orderable": false,
				                "width": "100px",
				                "render": function (data, type, full, meta) {
				                	var estado="";
				                    if(full.voucEstadoSunat=="1"){
				                   	 	return 	"<div class='badge' style='background-color: #15a01f;' >ACEPTADO</div> ";
				                    } else if(full.voucEstadoSunat==""){
				                    	return 	"<div  class='badge bg-orange'>NO ENVIADO</div>";
				                    }else {
				                    	return 	"<div class='badge bg-red'>RECHAZADO</div>";    	
				                }
				                   
				                }
				            },
				            
							],
							
							"preDrawCallback" : function(settings) {
								var api = new $.fn.dataTable.Api(settings);
								var pagination = $(this).closest('.dataTables_wrapper').find('.dataTables_paginate');
								pagination.toggle(api.page.info().pages > 1);
							},
					        "drawCallback": function (settings) {
					        	$(".filterWrapping").append($(".filter-block"));
								$(".filterActive").append($("#filterActive"));
								$("#filterActive").removeClass("hidden");
								$(".filter-block").removeClass("hidden");
								$(".multiBtnWrapping").append($("#btnBar_multipleSelection"));
								$("#btnBar_multipleSelection").removeClass("hidden");
								$(this).closest('.dataTables_wrapper').removeClass("form-inline");
								$("input[id='select_all']").prop('checked', false);
								
								var sumaTotalPen=0;
								var sumaTotalUsd=0;
								$.map($('#lstExploradorVenta').DataTable().rows().data(), function (item) {
									var tipoCambio = (item['dexchange_rate']);
									var moneda = (item['vname_coin']);
									var strEx = (item['dresult_total']);
									strEx = strEx.replace(/\,/g,'');
									console.log("strEx "+strEx);
									var montoPen = 0;
									var montoUsd = 0;
									if (moneda == "PEN"){
										montoPen = strEx;
										montoUsd = strEx/tipoCambio;
										montoUsd = montoUsd.toFixed(2);
									} else if (moneda == "USD"){
										montoPen = strEx*tipoCambio;
										montoUsd = strEx;
										montoPen = montoPen.toFixed(2);
									}
									console.log("strExCam "+strEx);
									sumaTotalPen=parseFloat(sumaTotalPen.toFixed(2))+parseFloat(montoPen);
									sumaTotalUsd=parseFloat(sumaTotalUsd.toFixed(2))+parseFloat(montoUsd);
							    });
								var sumaTotalPenView=sumaTotalPen.toFixed(2);
								var sumaTotalUsdView=sumaTotalUsd.toFixed(2);
								$("#frmResultadoTotal").val(sumaTotalPenView);
								$("#frmResultadoTotalConversion").val(sumaTotalUsdView);
					        }
					        
						});
		$('#lstExploradorVenta_filter').hide();
	//	$("#lstExploradorVenta").hide();
		
	}
	
	RegistroVenta.prototype.listarProductoComprafacturaboleta = function() {
		var obj = this;
		var tablesfacbol = obj.GrillaComprasfacbol.DataTable({
					"sPaginationType" : "simple_numbers",
	//				"scrollY" : "300%",
	//				"scrollX" : true,
	//				"sScrollX" : "100%",
					"bScrollCollapse" : true,
					"order" : false,
					"bSort" : false,
					"destroy": true,	
					"serverSide" : true,
					"dom" : '<"row"<"col-md-12 addButtonHere">><"row"<"col-md-12"tr>><"row"<"col-md-8"i><"col-md-4 text-right"p>>',
					"lengthMenu" : [5, 25, 50, 100],
					"pageLength": 10,
			        "paging": true,
			        "Paginate" : true,
					"language": {
			            "decimal": ",",
			            "thousands": "."
			        },				
					"ajax": {							
				            "url": "/SistemaFE/registroventa/MostrarDetalle"+"?"+"codDet="+$('#idCompra').val(),
				            "type": "POST"					
				        },
					"columnDefs" : [
						 {	
				                "targets":  0, 
				                "data": "sel", 
				                "defaultContent": "",
				                "className": "text-center" ,
				                "orderable": false,
				                "render": function (data, type, full, meta) {
				                    return "<input type='checkbox'  id='checkDetalle' name='checkDetalle' class='flat iCheck-helper selecciondetalle icheckbox_flat-green' />" ;
				                }
				            },
							{
								"targets" : 1,
								"data" : "accion",
								"visible": false,
								"defaultContent" : "",
								"className" : "text-center",
								"orderable" : false,
								"width" : "100px",
								"render" : function(data, type, full, meta) {
									if($("#VerDet").val()!=""){	
									var estado = "disabled";
									return "<button type='button' class='fa fa-trash-o btnDeleteVenta btn btn-danger btn-sm' id='btnDeshabilitar' title ='Inhabilitar' onclick='formReset()' value='Reset' "
											+ "attr-tipo='"
											+ full.tipoRegistro
											+ "'"
											+ "attr-idDetVenta='"
											+ full.detailBident
											+"'"
											+ " attr-idStore='"
											+ full.codigoAlmacen
											+ "'"
											+ ""
											+ estado
											+ "> </button> ";
								}else  {
									var estado = "enabled";
									return "<button type='button' class='fa fa-trash-o btnDeleteVenta btn btn-danger btn-sm' id='btnDeshabilitar' title ='Inhabilitar' onclick='formReset()' value='Reset' "
											+ "attr-tipo='"
											+ full.tipoRegistro
											+ "'"
											+ "attr-idDetVenta='"
											+ full.detailBident
											+"'"
											+ " attr-idStore='"
											+ full.codigoAlmacen
											+ "'"
											+ ""
											+ estado
											+ "> </button> ";
								}
								}
							},
							{
								"targets" : 2,
								"data" : "numero"
							},
							{
								"targets" : 3,
								"data" : "codigo"
							},
							{
								"targets" : 4,
								"visible" : false,
								"data" : "codigoAlmacen"
							},
							{
								"targets" : 5,
								"data" : "codigoComercial"
							},
							{
								"targets" : 6,
								"data" : "concepto"
							},
							{
								"targets" : 7,
								"data" : "UnidadMedida"
							},
							{
								"targets" : 8,
								"data" : "cantidad"
							},
							{
								"targets" : 9,
								"data" : "valorUnitario"
							},
							{
								"targets" : 10,
								"data" : "igvUnitario"
							},
							{
								"targets" : 11,
								"data" : "precioUnitario"
							},
							{
								"targets" : 12,
								"data" : "valorVenta"
							},
							{
								"targets" : 13,
								"data" : "igvVenta"
							},
							{
								"targets" : 14,
								"data" : "precioVenta"
							},
							{
								"targets" : 15,
								"data" : "porcentaDesc"
							},
							{
								"targets" : 16,
								"data" : "importeDesc"
							},
							{
								"targets" : 17,
								"data" : "precValorVentaDscto"
							},
							{
								"targets" : 18,
								"data" : "precIgvVentaDscto"
							},
							{
								"targets" : 19,
								"data" : "precPrecioVentaDscto"
							},
							{
								"targets" : 20,
								"data" : "baseImporte"
							},						
							{
								"targets" : 21,
								"data" : "igv"
							},
							{
								"targets" : 22,
								"data" : "totalBruto"
							},
							{
								"targets" : 23,
								"data" : "totalNeto"
							},
							{
								"targets" : 24,
								"data" : "indicadorAfecto"
							},
							{
								"targets" : 25,
								"data" : "tipoIndicadorAfecto"
							},
							{
								"targets" : 26,
								"data" : "accion",
								"defaultContent" : "",
								"className" : "text-center",
								"orderable" : false,
								"width" : "100px",
								"render" : function(data, type, full, meta) {
										var estado = "";
										if (full.precDescripMoneda == 1) {
											return "<div class='badge bg-blue'>"
													+ "Soles" + "</div>";
										} else if (full.precDescripMoneda == 2) {
											return "<div class='badge' style='background-color: #15a01f;' >"
													+ "Dolares" + "</div> ";
										} else if (full.precDescripMoneda == 3) {
											return "<div class='badge bg-red'>"
												+ "Euro" + "</div> ";
										} else if (full.precDescripMoneda == 4) {
											return "<div class='badge bg-orange'>"
												+ "Yen" + "</div> ";
										}
									}
							},
							{
								"targets" : 27,
								"data" : "accion",
								"defaultContent" : "",
								"className" : "text-center",
								"orderable" : false,
								"width" : "100px",
								"render" : function(data, type, full, meta) {
										var estado = "";
										if (full.tipoMonedaDestino == 1) {
											return "<div class='badge bg-blue'>"
													+ "Soles" + "</div>";
										} else if (full.tipoMonedaDestino == 2) {
											return "<div class='badge' style='background-color: #15a01f;' >"
													+ "Dolares" + "</div> ";
										} else if (full.tipoMonedaDestino == 3) {
											return "<div class='badge bg-red'>"
												+ "Euro" + "</div> ";
										} else if (full.tipoMonedaDestino == 4) {
											return "<div class='badge bg-orange'>"
												+ "Yen" + "</div> ";
										}
									}
							},
							{
								"targets" : 28,
								"data" : "tipoCambioVenta"
							},
							{
								"targets" : 29,
								"data" : "transferencia"
							},
							
							{
								"targets" : 30,
								"data" : "observacion"
							}
							,
							{
								"targets" : 31,
								"visible": false,
								"data" : "tipoRegistro"
							},
							{
								"targets" : 32,
								"visible": false,
								"data" : "codigoAlmacen"
							},
							{
								"targets" : 33,
								"visible": false,
								"data" : "nomcorto"						
							},
							{
								"targets" : 34,
								"visible": false,
								"data" : "Descripcion"
							}
							//preciodescripcion
							,
							{
								"targets" : 35,
								"visible": false,
								"data" : "preciodescripcionproducto"
							}
							,
							{
								"targets" : 36,
								"visible": false,
								"data" : "esprecioprincipal"
							}
							,
							{
								"targets" : 37,
								"visible": false,
								"data" : "nombremarca"
							}
							,
							{
								"targets" : 38,
								"visible": false,
								"data" : "nombrecortomarca"
							}
							,		
							{
								"targets" : 39,
								"visible": false,
								"data" : "nombredescripcionmarca"
							}
						,
						{
							"targets" : 40,
							"visible": false,
							"data" : "preciodescripcion"
						}
						,
						{
							"targets" : 41,
							"class" : "codigoDetVen",
							"data" : "detailBident"
						}
							],
					"preDrawCallback" : function(settings) {
						var api = new $.fn.dataTable.Api(settings);
						var pagination = $(this).closest('.dataTables_wrapper')
								.find('.dataTables_paginate');
						pagination.toggle(api.page.info().pages > 1);
					},
						
				 "drawCallback": function (settings) {
			        	$(".filterWrapping").append($(".filter-block"));
						$(".filterActive").append($("#filterActive"));
						$("#filterActive").removeClass("hidden");
						$(".filter-block").removeClass("hidden");
						$(".multiBtnWrapping").append(
								$("#btnBar_multipleSelection"));
						$("#btnBar_multipleSelection").removeClass("hidden");
						$(this).closest('.dataTables_wrapper').removeClass(
								"form-inline");
						$("input[id='select_all']").prop('checked', false);
			        }	        
				});	
		$("#lstGrillaCompra_filter").hide();
		$("#lstGrillaCompra_length").hide();
		$("#lstGrillaCompra_info").hide();
	}
	
	RegistroVenta.prototype.reloadDataTableFacBolCompra = function() {
		this.GrillaBuscarFacBol.DataTable().ajax.url("/SistemaFE/registroventa/lista_ventabuscarfacturaboleta"+"?"+$('#frmFactBuscar').serialize()).load();
		$("#lstExploradorVentaDetalles_filter").hide();
	}
	
	RegistroVenta.prototype.listarFacturaVenta = function() {
		var obj = this;
		var tablesfact = obj.GrillaBuscarFacBol.DataTable({
			        "scrollY" : "200px",
					"scrollX" : true,
					"sScrollX" : "100%",
					"bScrollCollapse" : true,
	//				"sProcessing" : "Procesando...",
					"bSort" : true,
					"destroy" : true,
					"serverSide" : true,
					"dom" : '<"row"<"col-md-12 addButtonHere">><"row"<"col-md-12"tr>><"row"<"col-md-8"i><"col-md-4 text-right"p>>',
			        "pagingType": "numbers",
	//				"lengthMenu" : [5, 25, 50, 100],
					"pageLength": 1000,
	//		        "paging": true,
	//		        "Paginate" : true,		        
			        "ajax": {
			            "url": "/SistemaFE/registroventa/lista_ventabuscarfacturaboleta"+"?"+$('#frmFactBuscar').serialize(),
			            "type": "POST"
			        },
					"columnDefs" : [{
						"targets":  0, 
		                "data": "sel", 
		                "defaultContent": "",
		                "className": "select-checkbox" ,
		                "orderable": false,
		                "render": function (data, type, full, meta) {
		                	return 	"<button type='button' class='btn btn-info fa fa-eye btn-sm btnVerDetCompraDetFac ladda-button' title ='Ver Detalle'" +
		                    " attr-user='"+full.saleBident+"'"+ " attr-emple='"+full.purcBidents+"'+  attr-natu='"+full.purcBidents+"'"+ " attr-lega='"+full.purcVnumberPurchase+"'"+
		                    		" > </button> "+
		                     "<input type='checkbox'  id='check-all' name='check-all' class='flat iCheck-helper icheckbox_flat-green' "+" attr-user='"+full.saleBident+"'" +" />" ;
		                	//  "<input type='checkbox'  id='select_alla' name='select_alla' class='flat iCheck-helper icheckbox_flat-green' />" ;
		                }},
							{"targets" : 1,"data" : "vtipdocvoucher"},	
							{"targets" : 2,"data" : "sdetTmovementDate"},
							{"targets" : 3,"data" : "vserievoucher"},
							{"targets" : 4,"data" : "vnumbervoucher"},
							{"targets" : 5,"data" : "dresult_total"},
							{"targets" : 6,"data" : "vname_coin"},
							{"targets" : 7,"data" : "vbusiname_clie"}
							],
							"select": {
					            "style":    'os',
					            "selector": 'td:first-child'
					        },
					"preDrawCallback" : function(settings) {
						var api = new $.fn.dataTable.Api(settings);
						var pagination = $(this).closest('.dataTables_wrapper')
								.find('.dataTables_paginate');
						pagination.toggle(api.page.info().pages > 1);
					},
			        "drawCallback": function (settings) {
			        	$(".filterWrapping").append($(".filter-block"));
						$(".filterActive").append($("#filterActive"));
						$("#filterActive").removeClass("hidden");
						$(".filter-block").removeClass("hidden");
						$(".multiBtnWrapping").append($("#btnBar_multipleSelection"));
						$("#btnBar_multipleSelection").removeClass("hidden");
						$(this).closest('.dataTables_wrapper').removeClass(
								"form-inline");
						$("input[id='select_all']").prop('checked', false);
			        },
			        
				});
		$("#lstExploradorVentaDetalles_filter").hide();
		 $("#listaCatDetIndicador").attr("disabled",true);
		 $("#listaCatDetIndicadortipo").attr("disabled",true);
	}
	
	RegistroVenta.prototype.imprimirPDF = function(url) {
		var iframe = this._printIframe;
		  if (!this._printIframe) {
		    iframe = this._printIframe = document.createElement('iframe');
		    document.body.appendChild(iframe);
	
		    iframe.style.display = 'none';
		    iframe.onload = function() {
		      setTimeout(function() {
		        iframe.focus();
		        iframe.contentWindow.print();
		      }, 1);
		    };
		  }
	
		  iframe.src = url;
	}
	
	//mtoledo 08/03/2019 CWA-591
	RegistroVenta.prototype.activar = function(accion) {
		if(accion==0){
			$("#divOperAnticipo").show();
			$("#divRegulaAnticipo").show();
			$("#divventaGratis").hide();
			$("#divVentaAnticipo").show();
		}else if(accion==1){
			$("#divOperAnticipo").hide();
			$("#divRegulaAnticipo").hide();
			$("#divventaGratis").show();
			$("#divVentaAnticipo").hide();
		}
	}
	
	RegistroVenta.prototype.cargarCPEanticipos = function(idSale) {
		var filtro=[];
		if(idSale===undefined){
			filtro={"tipoCPE":$('#listaCatDetComp').val()};
		}else{
			filtro={"tipoCPE":$('#listaCatDetComp').val(),"idSale":idSale};
		}
		
		$.ajax({
			url : "/SistemaFE/registroventa/obtenerAnticipos/",
			type : "POST",
			data : filtro,
			dataType : "json",
			beforeSend : function() {},
			success : function(data) {
				if (data.msg == "ok") {
					if(idSale===undefined){
						var template = $("#cboAnticipos").html();
		                var content = $("#lstSerieAnticipo").empty();
		                var html = Mustache.render(template, data);
		                content.html(html);
					}else{
						$('#txtFechaAnticipo').val(data.toption[0].saleTregistrationDate);
				    	$('#txtTotalAnticipo').val(data.toption[0].saleTotalAnticipo);
				    	$('#txtMontoDisponibleAnticipo').val(data.toption[0].saleTotalDisponibleAnticipo);
				    	$('#txtMontoUtilizarAnticipo').val("");
				    	$('#txtSaldoFinalAnticipo').val("");
						
					}
				} else if (data.msg == "error") {
					bootbox.alert("<label class='text-danger'>ALERTA : <br> No hay data para mostrar</label>");
					$("#lstSerieAnticipo").val("");
				} else {
					$('#txtFechaAnticipo').val("");
			    	$('#txtTotalAnticipo').val("");
			    	$('#txtMontoDisponibleAnticipo').val("");
			    	$('#txtMontoUtilizarAnticipo').val("");
			    	$('#txtSaldoFinalAnticipo').val("");
				}
			},
			error : function(xhr, statusText, errorThrown) {
				console.log("ocurrio un error");  
			}
		});
	}
	
	RegistroVenta.prototype.listarAnticipos = function() {
		var obj = this;
		obj.lstDataTableAnticipo = obj.Anticipos
				.DataTable({
					"sPaginationType" : "simple_numbers",
					"bScrollCollapse" : true,
					"order" : false,
					"bSort" : false,
					"paging": false,
					"destroy": true,	
					"serverSide" : false,
					"dom" : '<"row"<"col-md-12 addButtonHere">><"row"<"col-md-12"tr>><"row"<"col-md-8"i><"col-md-4 text-right"p>>',
					"pagingType": "simple_numbers",
					"lengthMenu" : [10, 25, 50, 100],
					"pageLength": 5,
			        "paging": true,
			        "Paginate" : true,						
					"columnDefs" : [
							{
								"targets" : 0,
								"data" : "sel",
								"defaultContent" : "",
								"className" : "text-center",
								"orderable" : false,
								"render" : function(data, type, full, meta) {
									return "<input type='checkbox' class='flat'  />";
								}
							},
							{
								"targets" : 1,
								"data" : "accion",
								"defaultContent" : "",
								"className" : "text-center",
								"orderable" : false,
								"width" : "100px",
								"render" : function(data, type, full, meta) {
									return "<button type='button' class='fa fa-trash-o btnDeleteAnticipo btn btn-danger btn-sm' id='btnDeshabilitar' title ='Inhabilitar'  value='Reset' "
									+ "attr-id='"
									+ full.idCPE
									+ "'"
									+ "> </button> "
									+"<button type='button' class='btn btn-warning fa fa-edit btn-sm btnEditarAnticipo ladda-button' title ='Editar Columna'"
									+ " attr-id='"
									+ full.idCPE
									+ "'"
									+ " > </button> ";
								}
							},
							{
								"targets" : 2,
								"data" : "tipoCPE"
							},
							{
								"targets" : 3,
								"data" : "serie"
							},
							{
								"targets" : 4,
								"data" : "numero"
							},
							{
								"targets" : 5,
								"data" : "fecha"
							},
							{
								"targets" : 6,
								"data" : "valor"
							},
							{
								"targets" : 7,
								"data" : "igv"
							},
							{
								"targets" : 8,
								"data" : "total"
							},
							{
								"targets" : 9,
								"data" : "montoutilizar"
							},
							{
								"targets" : 10,
								"data" : "montopendiente"
							}
							],
					"preDrawCallback" : function(settings) {
						var api = new $.fn.dataTable.Api(settings);
						var pagination = $(this).closest('.dataTables_wrapper')
								.find('.dataTables_paginate');
						pagination.toggle(api.page.info().pages > 1);
					}
				});
		obj.lstDataTableProductoVenta.on( 'order.dt search.dt', function () {
			obj.lstDataTableProductoVenta.column(2, {search:'applied', order:'applied'}).nodes().each( function (cell, i) {
	            cell.innerHTML = i+1;
	        } );
	    } ).draw();
	}
	
	RegistroVenta.prototype.cargarLstanticipos = function(idSale) {
		var obj = this;
		$.ajax({
			url : "/SistemaFE/registroventa/obtenerAnticiposGrilla/",
			type : "POST",
			data : {"idSale":$('#lstSerieAnticipo').val(),"tipoCPE":$('#txtTipoCPAnticipo').val(),"montoUtilizar":$('#txtMontoUtilizarAnticipo').val()},
			dataType : "json",
			beforeSend : function() {},
			success : function(data) {
				if (data.msg == "ok") {
					$('#lstAnticipos').DataTable().rows.add(data.datos);	
			        $('#lstAnticipos').DataTable().draw();
			        var montoAnticipo=0;
			    	$.map(obj.lstDataTableAnticipo.rows().data(), function (item) {
			    		montoAnticipo= parseFloat(montoAnticipo)+parseFloat(item["montoutilizar"]);
					});
			    	$('#frmResultadoVentaAnticipo').val(montoAnticipo);
			    	
				} else if (data.msg == "error") {
					bootbox.alert("<label class='text-danger'>ALERTA : <br> No hay data para mostrar</label>");
					$("#lstSerieAnticipo").val("");
				} else {
					$('#txtFechaAnticipo').val("");
			    	$('#txtTotalAnticipo').val("");
			    	$('#txtMontoDisponibleAnticipo').val("");
			    	$('#txtMontoUtilizarAnticipo').val("");
			    	$('#txtSaldoFinalAnticipo').val("");
				}
			},
			error : function(xhr, statusText, errorThrown) {
				console.log("ocurrio un error");  
			}
		});
	}
	
	RegistroVenta.prototype.calcularSaldoDisponible = function() {
		$.ajax({
			url : "/SistemaFE/registroventa/calcularSaldoDisponible/",
			type : "POST",
			data : {"saldoDisponible":$('#txtMontoDisponibleAnticipo').val(),"saldoUtilizar":$('#txtMontoUtilizarAnticipo').val()},
			dataType : "json",
			beforeSend : function() {},
			success : function(data) {
				if (data.msg == "ok") {
					$("#txtSaldoFinalAnticipo").val(data.resultado);
				} else if (data.msg == "error") {
					bootbox.alert(data.respuesta);
					$("#txtSaldoFinalAnticipo").val("");
				} 
			},
			error : function(xhr, statusText, errorThrown) {
				console.log("ocurrio un error");  
			}
		});
	}
	
	RegistroVenta.prototype.restarMontoTotalAnticipo = function() {
		var obj = this;
		$.ajax({
			url : "/SistemaFE/registroventa/restarMontoTotalAnticipo/",
			type : "POST",
			data : {"montoAnticipo":$('#frmResultadoVentaAnticipo').val(),"montoTotal":$('#frmResultadoTotal').val()},
			dataType : "json",
			beforeSend : function() {},
			success : function(data) {
				if (data.msg == "ok") {
					$("#frmResultadoTotalView").val(data.resultado);
					$("#frmResultadoTotal").val(data.resultado);
					$("#frmResultadoMonto").val(obj.montoLetras(data.resultado));
				} else if (data.msg == "error") {
					bootbox.alert(data.respuesta);
					$("#txtSaldoFinalAnticipo").val("");
				} 
			},
			error : function(xhr, statusText, errorThrown) {
				console.log("ocurrio un error");  
			}
		});
	}
	
	RegistroVenta.prototype.montoLetras = function(monto) {
		var o=new Array("DIEZ", "ONCE", "DOCE", "TRECE", "CATORCE", "QUINCE", "DIECISÉIS", "DIECISIETE", "DIECIOCHO", "DIECINUEVE", "VEINTE", "VEINTIUNO", "VEINTIDÓS", "VEINTITRÉS", "VEINTICUATRO", "VEINTICINCO", "VEINTISÉIS", "VEINTISIETE", "VEINTIOCHO", "VEINTINUEVE");
		var u=new Array("CERO", "UNO", "DOS", "TRES", "CUATRO", "CINCO", "SEIS", "SIETE", "OCHO", "NUEVE");
		var d=new Array("", "", "", "TREINTA", "CUARENTA", "CINCUENTA", "SESENTA", "SETENTA", "OCHENTA", "NOVENTA");
		var c=new Array("", "CIENTO", "DOSCIENTOS", "TRESCIENTOS", "CUATROCIENTOS", "QUINIENTOS", "SEISCIENTOS", "SETECIENTOS", "OCHOCIENTOS", "NOVECIENTOS");
	    var tot = monto;
	    var n=parseFloat(tot).toFixed(2); /*se limita a dos decimales, no sabía que existía toFixed() :)*/
		  var p=n.toString().substring(n.toString().indexOf(".")+1); /*decimales*/
		  var m=n.toString().substring(0,n.toString().indexOf(".")); /*número sin decimales*/
		  var m=parseFloat(m).toString().split("").reverse(); /*tampoco que reverse() existía :D*/
		  var t="";
		  /*Se analiza cada 3 dígitos*/
		  for (var i=0; i<m.length; i+=3)
		  {
		    var x=t;
		    /*formamos un número de 2 dígitos*/
		    var b=m[i+1]!=undefined?parseFloat(m[i+1].toString()+m[i].toString()):parseFloat(m[i].toString());
		    /*analizamos el 3 dígito*/
		    t=m[i+2]!=undefined?(c[m[i+2]]+" "):"";
		    t+=b<10?u[b]:(b<30?o[b-10]:(d[m[i+1]]+(m[i]=='0'?"":(" Y "+u[m[i]]))));
		    t=t=="CIENTO CERO"?"CIEN":t;
		    if (2<i&&i<6)
		      t=t=="UNO"?"MIL ":(t.replace("UNO","UN")+" MIL ");
		    if (5<i&&i<9)
		      t=t=="UNO"?"UN MILLÓN ":(t.replace("UNO","UN")+" MILLONES ");
		    t+=x;
		    //t=i<3?t:(i<6?((t=="uno"?"mil ":(t+" mil "))+x):((t=="uno"?"un millón ":(t+" millones "))+x));
		  }
	     
		  if($("#listaCatDetMoneda").val()==1){
			  t+=" CON "+p+"/100" +" SOLES"; 
		  }else{
			  t+=" CON "+p+"/100" +" DOLARES AMERICANOS";
		  }
		  /*correcciones*/
		  t=t.replace("  "," ");
		  t=t.replace(" CERO","");
		  return t;
	}
	

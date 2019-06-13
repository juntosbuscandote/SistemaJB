/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


	  
	  /**
	   * 
	   * Controller para la grilla comprobante electronico
	   * @returns
	   */

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function Comprobante() {

//	this.lstComprobante = $('#lstComprobante').DataTable( {
//        "scrollX": true
//    } );
//	$("#lstComprobante_filter").hide();
	
	this.lstComprobante = $('#lstComprobante');
//	$("#frmCPEFiltrosfecIniFecFin").daterangepicker();
	
	$("#frmCPEFiltrosfecIniFecFin").daterangepicker({
		locale: {
	          format: 'DD/MM/YYYY'
	        },
		singleClasses : "picker_4"
	});
	
//	$('#frmCPEFiltrosFecEmision').datepicker();
	$("#frmCPEFiltrosfecIniFecFin").val("");
	$("#frmCPEFiltrosFecEmision").daterangepicker({singleDatePicker:!0,singleClasses:"picker_4"},
	 function(a,b,c){console.log(a.toISOString(),b.toISOString(),c)});
	
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

Comprobante.prototype.init = function() {
	this.handler();
	this.listarComprobante();
}

Comprobante.prototype.handler = function() {

	//funcion para reenviar el correo al cliente
	$('body').on('click', '.dSend', function() {
		var boton=$(this);
        
		var nro=boton.attr( "attr-nro" );
		var id=boton.attr( "attr-id" );
		
		var tipoDoc=boton.attr( "attr-tipoDoc" );
		var empresa=boton.attr( "attr-empresa" );
		console.log(nro);
		// BootBox sobre el boton editar Luis S.
		bootbox.confirm("¿Esta seguro que desea reenviar el documento electronico al correo del cliente?" +
				"<br/>Tipo :"+tipoDoc+"<br>Nro:  "+nro+"" +
						"<br/>Emisor: "+empresa+
						"<br/>Ingrese un correo adicional para enviar una copia del CPE (opcional): "+
						"<br/><input type='text' name='correoR' id='correoR' class='form-control input-sm filter-single' placeholder='@ejemplo.com' maxlength='300'>",function(res){
			if (res) {
				//location.href="/SistemaFE/comprobanteelectronico/reenviar?id="+id;
				$.ajax({
					url : "/SistemaFE/comprobanteelectronico/reenviar",
					type : "POST",
					data : {
						"id":id,
						"correo":$('#correoR').val()
						},
					dataType : "json",
					beforeSend : function() {
//						$('#btnProccess').ladda().ladda('start');
					},
					success : function(data) {
							//Se añadio para el efecto de aviso que se guardo correctamente Luis S.
						if (data.cod == "1") {
							bootbox.alert("Se reenvio correctamente la información");
						}else{
							bootbox.alert("Ocurrio un error");
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
	$('body').on('click', '.dXML , .dCDR , .dPDF', function(event) {
    	//console.log("descargar xml");
		//var boton=$(this);
		//var nro=boton.attr( "attr-nro" );
		var urlFile=$(this).attr( "attr-url" );
		
		//var urlEncode=encodeURIComponent(urlFile);
		var tipoFile=$(this).attr( "attr-tipo" );
		location.href="/SistemaFE/comprobanteelectronico/download?file="+urlFile+"&tipo="+tipoFile;
		
    });
	
	$('body').on('click', '#btn_descarga', function(event) {
		var tabla=$('#lstComprobante').DataTable();
		var tm=tabla.data().count();
		console.log(tm);
		if(tm>0){
			location.href="/SistemaFE/comprobanteelectronico/obtenerPDFMasivo?"+$('#frm_filtrarComprobante').serialize();
		}else{
			bootbox.alert("<label>No existen registros para descargar</label>");
		}
		
		
    });
	
	
	var obj=this;
	$('body').on('click', '#btn_search', function(event) {
    	obj.reloadDataTableComprobante();
    });
	
	$("#btnSalirDet").click(function(e){
        location.href="/SistemaFE/comprobanteelectronico/"  
   });	
	
	
//	$('body').on('click', '.btnVerDet', function() {
//		var boton=$(this);
//		var nro=boton.attr( "attr-nro" );
//		console.log(boton.attr( "attr-nro" ));
//			location.href="/SistemaFE/comprobanteelectronico/detallecpe?nro="+nro;
		
//			$('#modalVerDetFact').html(nro).modal("");
		
		
//		console.log("NO ENTRO")
//		$.ajax({
//			type: "POST",
//			url:"/SistemaFE/ComprobanteElectronico/ListarComprobante?nro="+nro;,
//			success: function(data){
//				$('#modalVerDetFact').html(data).modal("");
//			}
//		})
		
//		});
//		}

//Boton ver detalle
$('body').on('click', '.btnVerDet', function() {
	var boton=$(this);
	var nro=boton.attr( "attr-nro" );
	$.ajax({
		url : "/SistemaFE/comprobanteelectronico/detallecpenuevo/",
		type : "POST",
		data : {"id":nro},
		dataType : "json",
		beforeSend : function() {
//			$('#btnProccess').ladda().ladda('start');
		},
		success : function(data) {
				//Se añadio para el efecto de aviso que se guardo correctamente Luis S.
			if (data.msg == "ok") {
				var obj=JSON.parse(data.respuesta);	
				$("#vouc_vtypdocvou").val(obj.tipoDocDescr);
				$("#vouc_vnro").val(obj.nroDoc);
				$("#vouc_vrucemisor").val(obj.empreNroDoc);
				$("#clie_bcod").val(obj.emprRS);
				$("#vouc_temitiondate").val(obj.fechaEmision);
				$("#vouc_dmonto").val(obj.total);
				
				$("#vouc_vstateSystem").text(data.estadoSystem);
				$("#vouc_venviadoSunat").text(data.enviadoSunat);
				$("#vouc_vstate").text(data.estadoSunat);
				//verificar los demas campos cliente
				console.log("ver: "+data.msg+" - "+data.estadoSystem+" - "+data.enviadoSunat);
				
				$("#vouc_vtypdocvou").attr("disabled",true);
				$("#vouc_vnro").attr("disabled",true);
				$("#vouc_vrucemisor").attr("disabled",true);
				$("#clie_bcod").attr("disabled",true);
				$("#vouc_temitiondate").attr("disabled",true);
				$("#vouc_dmonto").attr("disabled",true);
				$("#vouc_vstateSystem").attr("disabled",true);
				$("#vouc_venviadoSunat").attr("disabled",true);
				$("#vouc_vstate").attr("disabled",true);
				$("#modalVerDetFact").modal("show");
			}
		},
		error : function(xhr, statusText, errorThrown) {
			console.log("ocurrio un error");  
		}
	});
	
//	var boton=$(this);
//	var ruc=boton.attr( "attr-ruc" );
//	console.log(boton.attr( "attr-ruc" ));
//		location.href="/SistemaFE/empresa/detalleemp?ruc="+ruc;
});

$('body').on('click', '#btn_clean', function(event) {
	$('#frmCPEFiltrosTipo').val('').trigger('change');
	$('#frmCPEFiltrosResulSunat').val('').trigger('change');
});

}
//	$('.msjBoton').tooltip();
	
//	  $('#lstConElect').DataTable( {
//	        "scrollX": true
//	    } );
	


//function cargardetalle(cod,tipodocu,nrodoc,ruce,codcliente,emicion,monto,estado){
//	
//   
//}
//$(document).ready(function () {
//	
//    $('#lstFactElect').DataTable( {
//        "scrollX": true
//    } );
//    
//});
//

Comprobante.prototype.reloadDataTableComprobante = function() {
	this.lstComprobante.DataTable().ajax.url("/SistemaFE/comprobanteelectronico/lista_comprobante"+'?'+$('#frm_filtrarComprobante').serialize()).load();
}

Comprobante.prototype.listarComprobante = function () {
    var obj = this;
    obj.lstComprobante.DataTable({
    	  "scrollY" : "500px",
    	"scrollX": true,
    	"sScrollX": "100%",
//    	"scrollY": 400,
    	"sScrollXInner": "101%",
    	"bScrollCollapse": true,
        "processing": false,
        "serverSide": true,
        "order": [],
        "colReorder": {
            "fixedColumnsLeft": 1,
            "fixedColumnsRight": 2
        },
        "pagingType": "numbers",
        "lengthMenu": [10,25,50,100],
        "pageLength": 10,
        "paging": true,
        "Paginate" : true,
        //se creara otro metodo para obtener la lista desde el controlador
        "ajax": {
            "url": "/SistemaFE/comprobanteelectronico/lista_comprobante"+"?"+$('#frm_filtrarComprobante').serialize(),
            "type": "POST"
        },
        "columnDefs": [
            {
                'targets': 0, "data": "sel", "defaultContent": "",
                'className': 'text-center',
                'orderable': false,
                'render': function (data, type, full, meta) {
                    return '<input type="checkbox" name="table_records" class="flat">';
                }
            },
            {"targets": 1, "data": "voucVtypdocvou"},
            {"targets": 2, "data": "voucVnro"},
            {"targets": 3, "data": "clieVructipo"},
            {"targets": 4, "data": "clieVrucemisor"},
            {"targets": 5, "data": "clieRS"},
            {"targets": 6, "data": "obs"},
            {"targets": 7, "data": "voucTemitiondate"},
            {"targets": 8, "data": "voucCcodmoneda"},
            {"targets": 9, "data": "voucDmonto"},
            {"targets": 10, "data": "voucVstateSistema"},
            {
                "targets": 11,
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
                "targets": 12,
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
            
            {
                "targets": 13,
                "data": "accion", "defaultContent": "",
                "className": "text-center",
                'orderable': false,
                "width": "100px",
                "render": function (data, type, full, meta) {
                	var disabled="";
                    if(full.voucEnvioSunat==""){
                    	disabled="disabled";
                    }
                    
                    return  "<button "+disabled+" type='button' class='btn btn-success fa fa-file-excel-o msjBoton btn-sm dXML' attr-tipo='1' "+" attr-url='"+full.voucUrlXML+"'"+" title ='Descargar XML'></button>";
                }
            },
            {
                "targets": 14,
                "data": "accion", "defaultContent": "",
                "className": "text-center",
                'orderable': false,
                "width": "100px",
                "render": function (data, type, full, meta) {
                	var disabled="";
                    if(full.voucEnvioSunat!="1" && full.voucEstadoSunat!="1"){
                    	disabled="disabled";
                    }
                    return  "<button "+disabled+" -"+full.voucEstadoSunat+"- "+" type='button' class='btn btn-danger fa fa-file-pdf-o msjBoton btn-sm dPDF' attr-tipo='2' "+" attr-url='"+full.voucUrlPDF+"'"+" title ='Descargar PDF'></button></td>";
                }
            },
            {
                "targets": 15,
                "data": "accion", "defaultContent": "",
                "className": "text-center",
                'orderable': false,
                "width": "100px",
                "render": function (data, type, full, meta) {
                	var disabled="";
                    if(full.voucEnvioSunat!="1" && full.voucEstadoSunat!="1"){
                    	disabled="disabled";
                    }
                    return  "<button "+disabled+"  type='button' class='btn btn-primary fa fa-file-text-o msjBoton btn-sm dCDR' attr-tipo='3' "+" attr-url='"+full.voucUrlCDR+"'"+" title ='Descargar CDR'></button></td>";
                }
            },
            
            
            //{"targets": 13, "data": "voucEnvioSunat"},
            
            
            {
                "targets": 16,
                "data": "accion", "defaultContent": "",
                "className": "text-center",
                'orderable': false,
                "width": "100px",
                "render": function (data, type, full, meta) {
                    
                	var disabled="";
                    if(full.voucEnvioSunat!="1" && full.voucEstadoSunat!="1"){
                    	disabled="disabled";
                    }
                    
                    return 	"<button type='button' attr-cod='"+full.voucBcod+"'" +
                    		" attr-tipdoc='"+full.voucVtypdocvou+"'"+ 
                            " attr-nro='"+full.voucUrlPDF+"'"+  
                            " attr-ruc='"+full.clieVrucemisor+"'"+ 
                            " attr-codcli='"+full.clieBcod+"'"+ 
                            " attr-fecemision='"+full.voucTemitiondate+"'"+ 
                            " attr-monto='"+full.voucDmonto+"'"+  
                            " attr-estado='"+full.voucVstate+"'"+    
                            "class='btn btn-info fa fa-eye btnVerDet btn-sm' title ='Ver Detalle'> </button> " +
                            "<button  "+disabled+"  type='button' class='btn btn-warning fa fa-send-o msjBoton btn-sm dSend' "+" attr-nro='"+full.voucVnro+"'"+ " attr-tipoDoc='"+full.voucVtypdocvou+"'"+
                             " attr-empresa='"+full.clieRS+"'"+" attr-id='"+full.voucUrlPDF+"'"+
                            " title ='Reenviar Correo'></button>"
                            ;
                }
            }

        ],
        "preDrawCallback": function (settings) {
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
            
        }
    });
    
    $("#lstComprobante_filter").hide();
//    $("#lstComprobante_length").hide();
    
    

}

function ExploradorCPE() {
	
	this.lstExploradorCPE = $('#lstExploradorCPE');
	
	$("#frmBuscarCPEFecEmi").daterangepicker({
		singleDatePicker:!0,
		locale: {
	          format: 'DD/MM/YYYY'
	        },
		singleClasses:"picker_4"
		},
		function(a,b,c){
			console.log(a.toISOString(),
			b.toISOString(),c)}
	);
//	$('#lstExploradorCPE').DataTable();
//	$("#lstExploradorCPE_length").hide();
//	$("#lstExploradorCPE_filter").hide();
//	$("#lstExploradorCPE_info").hide();
//	$("#lstExploradorCPE_paginate").hide();
	
}

ExploradorCPE.prototype.init = function() {

	this.handler();
	this.listarExploradorCPE();

}

ExploradorCPE.prototype.handler = function() {
	var obj = this;
	
	$('body').on('click', '#btn_explorar', function(event) {
		
		if ($("#frmBuscarCPE").valid()) {
			var empresa =  $('#listaEmpreCPE').val();
			$.ajax({
				url : "/SistemaFE/comprobanteelectronico/buscarcpe/validEmpresa",
				type : "POST",
				data : "empresa=" + empresa ,
				dataType : "json",
				beforeSend : function() {
					//Ladda.create(this).start();

				},
				success : function(data) {
					if (data.estado != "ok") {
						bootbox.alert({
							size : null,
							title : null,
							message : data.msg,
							onEscape : true,
							callback : function() {
							}
						});
					} else {
						obj.reloadDataTableExploradorCPE();
						$("#mostrarLstExploradorCPE").show();
					}
				},
				complete : function() {
					//laddaButton.stop();
					//laddaButton.remove();
					//btn_buscar_persona.ladda('stop');
				},
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
					} else {
					}
				}
			});
		}
    });
	
	
	$("#frmBuscarCPE").validate({
		rules : {
			listaEmpreCPE : {
				required : true,
				number : true,
				minlength : 11
			},
			frmBuscarCPESerieNro : {
				required : true
			},
			frmBuscarCPEMonto : {
				required : true

			}
		},
		messages : {
			listaEmpreCPE : {
				required : "Campo Requerido",
				number : "solo n&uacute;meros",
				minlength : "m&iacute;nimo 11 car&aacute;cteres"
			},
			frmBuscarCPESerieNro : {
				required : "Campo Requerido"

			},
			frmBuscarCPEMonto : {
				required : "Campo Requerido"

			}
		}
	});
	
}

ExploradorCPE.prototype.reloadDataTableExploradorCPE = function() {
	//validar si viene de multiempresa
	var empresa =  $('#listaEmpreCPE').val();
	var empresa2 =  $('#empresa').val();
	if (empresa == '' || empresa == null){
		empresas = empresa2
	}else{
		empresas = empresa
	}
	this.lstExploradorCPE.DataTable().ajax.url("/SistemaFE/comprobanteelectronico/buscarcpe/lista_exploradorCPE"+'?'+$('#frmBuscarCPE').serialize()+"&idDS="+empresa).load();
}

ExploradorCPE.prototype.listarExploradorCPE = function () {
    var obj = this;
//    if ( $("#mostrarLstExploradorCPE").css('display') == 'block' ){
    obj.lstExploradorCPE.DataTable({
// "bPaginate": true,
// "bSort": false,
// "bJQueryUI": true,
// "sPaginationType": "full_numbers",
// "oLanguage": {
// "oPaginate": {
// "sPrevious": "Anterior",
// "sNext": "Siguiente",
// "sLast": "Ultima",
// "sFirst": "Primera"
// }
// },
    	"sPaginationType": "simple_numbers",
//    	"scrollX": true,
//    	"sScrollX": "100%",
// "scrollY": 400,
// "SSCROLLXINNER": "101%",
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
// "iDisplayLength": 10,
        "paging": true,
        "Paginate" : true,
        // se creara otro metodo para obtener la lista desde el controlador
        "ajax": {
            "url": "/SistemaFE/comprobanteelectronico/buscarcpe/lista_exploradorCPE"+"?"+$('#frmBuscarCPE').serialize(),
            "type": "POST"
        },
        "columnDefs": [

        	{"targets": 0, "data": "tipoCpe"},
            {"targets": 1, "data": "numCpe"},
            {"targets": 2, "data": "fechaEmision"},
            {"targets": 3, "data": "montoTotal"},
            {
                "targets": 4,
                "data": "accion", "defaultContent": "",
                "className": "text-center",
                'orderable': false,
                "width": "100px",
                "render": function (data, type, full, meta) {
                    
                    return  "<button type='button' class='btn btn-success fa fa-file-excel-o msjBoton btn-sm dXML' attr-tipo='1' "+" attr-url='"+full.voucUrlXML+"'"+" attr-bd='"+full.filtroBd+"' title ='Descargar XML'></button>";
                }
            },
            {
                "targets": 5,
                "data": "accion", "defaultContent": "",
                "className": "text-center",
                'orderable': false,
                "width": "100px",
                "render": function (data, type, full, meta) {
                    
                    return  "<button type='button' class='btn btn-danger fa fa-file-pdf-o msjBoton btn-sm dPDF' attr-tipo='2' "+" attr-url='"+full.voucUrlPDF+"'"+" attr-bd='"+full.filtroBd+"' title ='Descargar PDF'></button></td>";
                }
            },
            {
                "targets": 6,
                "data": "accion", "defaultContent": "",
                "className": "text-center",
                'orderable': false,
                "width": "100px",
                "render": function (data, type, full, meta) {
                    
                    return  "<button type='button' class='btn btn-primary fa fa-file-text-o msjBoton btn-sm dCDR' attr-tipo='3' "+" attr-url='"+full.voucUrlCDR+"'"+" attr-bd='"+full.filtroBd+"' title ='Descargar CDR'></button></td>";
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
    
//    }
    
    $("#lstExploradorCPE_length").hide();
	$("#lstExploradorCPE_filter").hide();
	$("#lstExploradorCPE_info").hide();
	$("#lstExploradorCPE_paginate").hide();
	//funciones para descargar archivos del servidor
	$('body').on('click', '.dXML , .dCDR , .dPDF', function(event) {
    	//console.log("descargar xml");
		//var boton=$(this);
		//var nro=boton.attr( "attr-nro" );
		var urlFile=$(this).attr( "attr-url" );
		
		//var urlEncode=encodeURIComponent(urlFile);
		var tipoFile=$(this).attr( "attr-tipo" );
		var empresa =  $(this).attr( "attr-bd" );
		location.href="/SistemaFE/comprobanteelectronico/downloadExterno?file="+urlFile+"&tipo="+tipoFile+"&idDS="+empresa;
		
    });
    

}
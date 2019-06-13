function Cliente() {
	this.gMethods = system.globalMethods;
	this.objPerson=null;
	this.lstCliente = $('#lstCliente');
	
	$.fn.select2.defaults.set("theme", "bootstrap");
	var placeholder = "Seleccione";
	$(".select2-single").select2({
		placeholder: placeholder,
		width: null,
		containerCssClass: ':all:'
	});
}

Cliente.prototype.init = function() {
	this.handler();
	this.listarCliente();
}

Cliente.prototype.handler = function() {
	var obj=this;
    $('body').on('click', '#btn_clean', function(event) {
		$('#frmUserFiltroEstado').val('').trigger('change');
    })

	//PARA LOS CHECKSBOX 
	$("#btnSalirCliente").click(function(e){
		if ($("#newClienteRG").val()=="new"){
			$('#modalCliente').modal('hide');
		} else {
			bootbox.confirm("<label class='text-danger'>Se descartarán los cambios ¿Desea Salir?</label>",function(res){
				if (res) {
					location.href="/SistemaFE/cliente/";
				}
			});
		}
	});

	$('body').on('click', '#btn_search', function(event) {
    	obj.reloadDataTableCliente();
    });

	$('body').on('click', '.editar', function() {
		var boton=$(this);
		var idpers=boton.attr("attr-pers");
		bootbox.confirm("<label class='text-danger'>¿Esta seguro que desea modificar cliente?:</label>",function(res){
			if (res) {
				location.href="/SistemaFE/cliente/EditarCliente?idPerson="+idpers;				
//				$("#pers_vJudicialPerson").val(legadoc);					
			}
		});
	}); 

	// Boton ver detalle
	$('body').on('click', '.btnVerDetCliente', function() {
		var boton=$(this);
		var user=boton.attr( "attr-user" );
		var emple=boton.attr( "attr-emple" );
		var natu=boton.attr( "attr-natu" );
		var lega=boton.attr( "attr-lega" );
		$.ajax({
			url : "/SistemaFE/cliente/detallecliente/",
			type : "POST",
			data : {"emple":emple},  
			dataType : "json",
			beforeSend : function() {
				},
			success : function(data) {
				if (data.msg == "ok") {
					obj.gMethods.verPersona(data);
					$("#frmmodalEditarCliente").modal("show");
				}
			},
			error : function(xhr, statusText, errorThrown) {
				console.log("ocurrio un error");  
			}
		});
	});

	$('body').on('click', '.delete', function() {
		var boton=$(this);
		var user=boton.attr( "attr-user" );
		var emple=boton.attr( "attr-emple" );
		bootbox.confirm("<label class='text-danger'>¿Esta seguro que desea inhabilitar el usuario:</label>"+' '+user+" <label class='text-danger'>?</label>",function(res){
			if (res) {
				$.ajax({
					url : "/SistemaFE/cliente/EstadoCliente/",
					type : "POST",
					data : {"emple":emple},
					dataType : "json",
					beforeSend : function() {},
					success : function(data) {
						if (data.msg == "ok") {
							bootbox.alert({
					            size: null,
					            title: null,
						        message: "<label class='text-danger'>Se inhabilitó el usuario :</label>"+user,
						        callback: function () {
						                	location.href = "/SistemaFE/cliente/";
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
		
    $("#btnClienteGuardar").click(function() {
    	var l = Ladda.create(this);
    	if(obj.objPerson.validarPersona()){
    		l.start();
    		obj.objPerson.crearPersona(obj);
    	}
    });
}

Cliente.prototype.reloadDataTableCliente = function() {
	this.lstCliente.DataTable().ajax.url("/SistemaFE/cliente/lista_cliente"+'?'+$('#frm_filtrarCliente').serialize()).load();
}

Cliente.prototype.listarCliente = function () {
    var obj = this;
    obj.lstCliente.DataTable({
    	"sPaginationType" : "simple_numbers",
    	"scrollY" : "500px",
		"scrollX" : false,
		"sZeroRecords":    "No se encontraron resultados",
		"sSearch":         "Buscar:",
		"sScrollX" : "100%",
		"bScrollCollapse" : true,
		"sProcessing" : "Procesando...",
		"serverSide" : true,
		"order": [[1, 'asc']],
		"colReorder" : {
			"fixedColumnsLeft" : 1,
			"fixedColumnsRight" : 2
		},
        "pagingType": "numbers",
        "lengthMenu": [10,25,50,100],
        "pageLength": 10,
        "paging": true,
        "Paginate" : true,
        "ajax": {
            "url": "/SistemaFE/cliente/lista_cliente"+"?"+$('#frm_filtrarCliente').serialize(),
            "type": "POST"
        },
       
        "columnDefs": [
            {
            	
                "targets":  0, 
                "data": "sel", "defaultContent": "clieBident",
                "className": "text-center",
                "orderable": false,
                "render": function (data, type, full, meta) {
                    return "<input type='checkbox' class='flat' />";
                }
            },
            {"targets": 1, "data": "catd_vshortname"},
            {"targets": 2, "data": "pers_vnumdoc"},
            {"targets": 3, "data": "nombre"},
            {"targets": 4, "data": "mailVmail"},
            {"targets": 5, "data": "phonVphone"},
            {
                "targets": 6,
                "data": "accion", "defaultContent": "",
                "className": "text-center",
                "orderable": false,
                "width": "100px",
                "render": function (data, type, full, meta) {
                	var estado="";
                    if(full.State=="Activo"){
                   	 	return 	"<div class='badge' style='background-color: #15a01f;'>"+full.State+ "</div> ";
                    } else {
                    	return 	"<div class='badge bg-red'>"+full.State+ "</div>";
                    }
                   
                }
            },
            
            
            {
                "targets": 7,
                "data": "accion", "defaultContent": "",
                "className": "text-center",
                "orderable": false,
                "width": "100px",
                "render": function (data, type, full, meta) {
                	var estado="";
                    if(full.State!="Activo"){
                    	estado="disabled"
                    }     
                    return 	"<button type='button' class='btn btn-info fa fa-eye btn-sm btnVerDetCliente ladda-button' title ='Ver Detalle'" +
                    " attr-user='"+full.pers_vnumdoc+"'"+ " attr-emple='"+full.clieBident+"'+  attr-natu='"+full.natuBident+"'"+ " attr-lega='"+full.legaBusiname+"'"+
                    		" > </button> " +
                    		"<button type='button' class='fa fa-edit editar btn btn-warning btn-sm' id='btnEditar' title ='Editar' " +
                    		" attr-pers='"+full.persBident+"'"+""+estado+"> </button> " +
                            "<button type='button' class='fa fa-ban delete btn btn-danger btn-sm' id='btnDeshabilitar' title ='Inhabilitar' " +
                            " attr-user='"+full.pers_vnumdoc+"'"+" attr-emple='"+full.clieBident+"'"+
                            ""+estado+"> </button> "
                           ;
                }
            }

        ]
        ,
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
    
    $("#lstCliente_filter").hide();
    
   if($("#listaCatDetComp").val()=='01'){
	    obj.cargarCliente();
   }

    $('body').on('change', '#listaCatDetComp', function() {
    	    obj.cargarCliente();	
    });

} 

	/****************************************************************************/
	/******************************INSERT DE CLIENTE*****************************/
	/****************************************************************************/
Cliente.prototype.procesar = function(data) {
	var obj = this;
	var objrsp=JSON.parse(data);
	if($("#proccess").val()=="modif"){
		  swal({
				title:'Se actualizó correctamente',
				text: 'Listo.',
				type: 'success',
				confirmButtonColor: '#3085d6',
			    confirmButtonText: 'Ok',
				confirmButtonClass: 'btn btn-success',
				buttonsStyling: false,
				allowOutsideClick: false,
				allowEscapeKey : false
				}).then(function () {
					if($('#filtrarClienteRazonSocialCliente').length>0){
						$("#modalPersona").modal("hide");
						obj.cargarCliente(objrsp["persBident"]);
					}else{
						location.href = "/SistemaFE/cliente/";
					}
					  
				})

	}else{
		$.ajax({
			url : "/SistemaFE/cliente/InsertarCliente/",
			type : "POST",
			data : {
				"personId":objrsp["persBident"]
				},
			dataType : "json",
			beforeSend : function() {
			},
			success : function(data) {
				if (data.msg == "ok") {
					swal({
						title : 'Se creo un nuevo cliente',
						text : '',
						type : 'success',
						confirmButtonColor : '#3085d6',
						confirmButtonText : 'Ok',
						confirmButtonClass : 'btn btn-success',
						buttonsStyling : false,
						allowOutsideClick : false,
						allowEscapeKey : false
					}).then(function() {
						if($('#filtrarClienteRazonSocialCliente').length>0){
							$("#modalPersona").modal("hide");
							obj.cargarCliente(objrsp["persBident"]);
						}else{
							location.href = "/SistemaFE/cliente/";
						}
					})
				}else if(data.msg == "2"){
					swal({
						title : 'Ya existe el cliente registado',
						text : '',
						type : 'success',
						confirmButtonColor : '#3085d6',
						confirmButtonText : 'Ok',
						confirmButtonClass : 'btn btn-success',
						buttonsStyling : false,
						allowOutsideClick : false,
						allowEscapeKey : false
					}).then(function() {
						if($('#filtrarClienteRazonSocialCliente').length>0){
							$("#modalPersona").modal("hide");
							obj.cargarCliente(objrsp["persBident"]);
						}else{
							location.href = "/SistemaFE/cliente/";
						}
					})
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
    

Cliente.prototype.cargarCliente = function(idPersona){
	var	tipoDoc1=$("#listaCatDetComp").val();
	$.ajax({
		url : "/SistemaFE/registroventa/reloadClient/",
		type : "POST",
		data : {"idPerson":idPersona,"tipoDoc1":tipoDoc1},
		dataType : "json",
		beforeSend : function() {
		},
		success : function(data) {
			if (data.msg == "ok") {
				var template = $("#cboMasterPersonas").html();
                var content = $("#filtrarClienteNroC").empty();
                var html = Mustache.render(template, data);
                content.html(html);              
                $('#filtrarClienteNroC').val(data.idCliente);
                $('#filtrarClienteNroC').trigger('change');
                
			}else{
				bootbox.alert("<label class='text-danger'>ERROR : <br> Se produjo un error interno en los servicios</label>");
			}
		},
		error : function(xhr, statusText, errorThrown) {
			console.log("ocurrio un error");  
		}
	});
}

/****************************************************************************/
/******************************UPDATE DE CLIENTE*****************************/
/****************************************************************************/
Cliente.prototype.updateCliente = function() {
        	console.log("click");
        	$.ajax({
        		url : "ActualizarCliente",
        		type : "POST",
        		data : $("#frmCliente").serialize(),
        		dataType : "json",
        		beforeSend : function() {
        // $('#btnProccess').ladda().ladda('start');
        		},
        		success : function(data) {
        			if (data.msg == "ok") {
        				// Se añadio para el efecto de aviso que se guardo correctamente
        				// Luis S.
        				
                     swal({
        					title:'Se actualizó correctamente',
        					text: 'Listo.',
        					type: 'success',
        					confirmButtonColor: '#3085d6',
        				    confirmButtonText: 'Ok',
        					confirmButtonClass: 'btn btn-success',
        					buttonsStyling: false,
        					allowOutsideClick: false,
        					allowEscapeKey : false
        					}).then(function () {
        						  location.href = "/SistemaFE/cliente/";
        						 
        						  })
        					
        			}
        		},
        		error : function(xhr, statusText, errorThrown) {
        			console.log("ocurrio un error");  
        		}
        	});
}
function GrupoComercial() {
	this.lstGrupoComer = $('#lstGrupoComer');
	this.gMethods = system.globalMethods;
}

GrupoComercial.prototype.init = function() {
	this.handler();	
	this.listarGrupoComer();
	//this.listModulos();
}
GrupoComercial.prototype.handler = function() {
	var obj=this;
	
	$('body').on('click', '#btn_search', function(event) {
    	obj.reloadDataTableGrupoComer();
    });
	
	if ($("#fProcess").val() != "save") {
//		$("#grupocom_vname").attr("readonly", true);
//		$("#grupocom_vdescrip").attr("readonly", true);		
		
	}
	
	$("#btnSalir").click(function(e){
		bootbox.confirm("<label class='text-danger'>Se descartarán los cambios ¿Desea Salir?</label>",function(res){
			if (res) {
				location.href = "/SistemaFE/grupocomer/";
			}
		});
	});
	
	$("#btnProccess").click(function() {
		var l = Ladda.create(this);
		l.start();
		if ($("#frmGrupoComercial").valid()) {
			if ($("#fProcess").val() == "save") {
				obj.crearGrupoCom(this,l);
			} else {
				obj.updateGrupoCom();
			}
		} else {
			l.stop();
			// alert("Verificar campos requeridos");
			bootbox.alert("<label>Verificar campos requeridos</label>");
		}
	});
	
	$("#btnProccessMod").click(function() {
		var l = Ladda.create(this);
		l.start();
//		if ($("#frmGrupoComercial").valid()) {
				obj.asigModGrupoCom(this,l);
//		} else {
//			l.stop();
//			// alert("Verificar campos requeridos");
//			bootbox.alert("<label>Verificar campos requeridos</label>");
//		}
	});
	obj.gMethods.setValidatorDefaults();
	$("#frmGrupoComercial").validate({
		rules : {
			grupocom_vname : {
				required : true
			}
		}

	});
	

	$('body').on('click', '.btnEditarDetGC', function() {
		var boton=$(this);
		var idGC=boton.attr("attr-id");
		var nombreGC=boton.attr( "attr-nombre" );
		bootbox.confirm("<label class='text-danger'>¿Esta seguro que desea modificar el Grupo Comercial</label>"+' '+nombreGC+
		"<label class='text-danger'>?</label>",function(res){
			if (res) {
				location.href="/SistemaFE/grupocomer/EditarGrupoCom?idGC="+idGC;
			}
		});
	}); 

	$('body').on('click', '.btnAsigModGC', function() {
		var boton=$(this);
		var idGC=boton.attr( "attr-id" );
		var nombreGC=boton.attr( "attr-nombre" );
		bootbox.confirm("<label class='text-danger'>¿Esta seguro que desea Asignar Modulos al Grupo Comercial</label>"+' '+nombreGC+
				"<label class='text-danger'>?</label>",function(res){
					if (res) {
						location.href="/SistemaFE/grupocomer/AsignarMod?idGC="+idGC;
					}
				});
	});
	
		$('body').on('click', '.btnCambiarEstGC', function() {
			var boton=$(this);
			var idGC=boton.attr( "attr-id" );
			var nombreGC=boton.attr( "attr-nombre" );
			var estadoGC=boton.attr( "attr-estado" );
			var texto="";
			var textoRpta="";
			if(estadoGC=="0"){
            	texto="Habilitar";
            	textoRpta="habilitó";
            }else{
            	texto="Inhabilitar";
            	textoRpta="inhabilitó";
            }
			
			bootbox.confirm("<label class='text-danger'>¿Esta seguro que desea "+texto+" el Grupo Comercial:</label>"+' '+nombreGC+" <label class='text-danger'>?</label>",function(res){
				if (res) {
					$.ajax({
						url : "/SistemaFE/grupocomer/updateGC/",
						type : "POST",
						data : {
							"grupoComer_id":idGC,
							"estado":estadoGC
						},
						dataType : "json",
						beforeSend : function() {
						},
						success : function(data) {
							if (data.msg == "ok") {
								bootbox.alert({
					                size: null,
					                title: null,
					                message: "<label class='text-danger'>Se "+textoRpta+" el Grupo Comercial :</label>"+nombreGC,
					                callback: function () {
					                	location.href = "/SistemaFE/grupocomer/";
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
		
		$("#grupocom_vmodule").on( 'change', function() {
			var obj=$("#grupocom_vmodule").val();
		    console.log("ver :"+obj);
		    $('#grupocom_vmodule option').each(function(){
		    	console.log($(this).val());
		    	if(obj==""){
		    		$("#"+$(this).val()).show();
		    	}else{
		    		if($(this).val()==obj){
		    			$("#"+$(this).val()).show();
		    		}else{
		    			$("#"+$(this).val()).hide();
		    		}
		    	}
		    	});
		});
		
}


GrupoComercial.prototype.limpiar = function() {
	$("#grupocom_vname").val("");
	$("#grupocom_vdescrip").val("");
}

GrupoComercial.prototype.asigModGrupoCom = function(button,ladda) {
	var obj = this;
	var listaId = $('#arbolSeleccionable').jstree("get_checked");
	
	var idGC = $('#grupoComer_idAM').val();
	var json ={
			"idGC":idGC,
			"modAsig": listaId
	};
	
	
	$.ajax({
				url : "/SistemaFE/grupocomer/asigModGrupoCom",
				type : "POST",
				data : JSON.stringify(json),
				dataType : "json",
				contentType: "application/json; charset=utf-8",
				beforeSend : function() {},
				success : function(data) {
					if (data.msg == "ok") {
						ladda.stop();
						swal({
							title : 'Se asignaron correctamente los Modulos',
							text : '',
							type : 'success',
							confirmButtonColor : '#3085d6',
							confirmButtonText : 'Ok',
							confirmButtonClass : 'btn btn-success',
							buttonsStyling : false,
							allowOutsideClick : false
						}).then(function() {location.href = "/SistemaFE/grupocomer/";})
					}else{
						bootbox.alert("<label class='text-danger'>ERROR : <br> Ocurrio un error al procesar la Solicitud</label>");
						
					}
					
				},
				error : function(xhr, statusText, errorThrown) {
					// l.stop();
					ladda.stop();
					console.log("ocurrio un error");
				}
			});
	// })
}
GrupoComercial.prototype.crearGrupoCom = function(button,ladda) {
	var obj = this;
	$.ajax({
				url : "/SistemaFE/grupocomer/crearGrupoCom",
				type : "POST",
				data : $("#frmGrupoComercial").serialize(),
				dataType : "json",
				beforeSend : function() {},
				success : function(data) {
					if (data.msg == "ok") {
						ladda.stop();
						swal({
							title : data.obs,
							text : '',
							type : 'success',
							confirmButtonColor : '#3085d6',
							confirmButtonText : 'Ok',
							confirmButtonClass : 'btn btn-success',
							buttonsStyling : false,
							allowOutsideClick : false
						}).then(function() {location.href = "/SistemaFE/grupocomer/";})
					}else{
						bootbox.alert("<label class='text-danger'>ERROR : <br> Ocurrio un error al procesar la Solicitud</label>");
						
					}
					
				},
				error : function(xhr, statusText, errorThrown) {
					// l.stop();
					ladda.stop();
					console.log("ocurrio un error");
				}
			});
	// })
}
GrupoComercial.prototype.updateGrupoCom = function() {
	console.log("click");
	$.ajax({
		url : "/SistemaFE/grupocomer/updateGC/",
		type : "POST",
		data : $("#frmGrupoComercial").serialize(),
		dataType : "json",
		beforeSend : function() {
			// $('#btnProccess').ladda().ladda('start');
		},
		success : function(data) {
			if (data.msg == "ok") {
				// Se añadio para el efecto de aviso que se guardo correctamente
				// Luis S.
				swal({
					title : 'Se actualizó correctamente el G.C.',
					text : '',
					type : 'success',
					confirmButtonColor : '#3085d6',
					confirmButtonText : 'Ok',
					confirmButtonClass : 'btn btn-success',
					buttonsStyling : false,
					allowOutsideClick : false
				}).then(function() {
					location.href = "/SistemaFE/grupocomer/";
				})

			}
		},
		error : function(xhr, statusText, errorThrown) {
			console.log("ocurrio un error");
		}
	});
}

GrupoComercial.prototype.reloadDataTableGrupoComer = function() {
	this.lstGrupoComer.DataTable().ajax.url("/SistemaFE/grupocomer/lista_grupocomer"+'?'+$('#frm_filtrarGrupoCom').serialize()).load();
}

GrupoComercial.prototype.listarGrupoComer = function () {
    var obj = this;
    obj.lstGrupoComer.DataTable({
    	"sPaginationType": "simple_numbers",
    	"searching": false,
    	  "scrollY" : "500px",
    	"scrollX": true,
    	"sScrollX": "100%",
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
        "ajax": {
            "url": "/SistemaFE/grupocomer/lista_grupocomer"+"?"+$('#frm_filtrarGrupoCom').serialize(),
            "type": "POST"
        },
        "columnDefs": [
        	{"targets": 0, "data": "grupoCInd"},
            {"targets": 1, "data": "grupoCname"},
            {"targets": 2, "data": "grupoCdescr"},
            {
                "targets": 3,
                "data": "accion", "defaultContent": "",
                "className": "text-center",
                "orderable": false,
                "width": "100px",
                "render": function (data, type, full, meta) {
                	var estado="";
                    if(full.grupoCidEstado=="0"){
                    	 return 	"<div class='badge bg-red'>"+full.grupoCdescrEstado+ "</div>";
                    } else {
                    	 return 	"<div class='badge' style='background-color: #15a01f;' >"+full.grupoCdescrEstado+ "</div> ";
                    }
                   
                }
            },
            {
                "targets": 4,
                "data": "accion", "defaultContent": "",
                "className": "text-center",
                "orderable": false,
                "width": "100px",
                "render": function (data, type, full, meta) {
                	var estado="";
                	var tituloEstado="";
                	var boton="";
                    if(full.grupoCidEstado=="0"){
                    	estado="disabled";
                    	tituloEstado="Habilitar";
                    	boton="fa fa-check btn btn-success";
                    }else{
                    	tituloEstado="Inhabilitar";
                    	boton="fa fa-ban btn btn-danger";
                    }
                    
                    //https://fontawesome.com/v4.7.0/icons/
                    return 	"<button type='button' class='fa fa-edit editar btn btn-warning btn-sm btnEditarDetGC' title ='Modificar' attr-id='"+full.grupoCID+"'" + "' attr-nombre='"+full.grupoCname+"'" +
                    		""+estado+"> </button> " +
                    		"<button type='button' class='fa fa-key editar btn btn-info btn-sm btnAsigModGC'  title ='Asignar Modulos' attr-id='"+full.grupoCID+"'" + "' attr-nombre='"+full.grupoCname+"'" +
                            ""+estado+"> </button> " +
                            "<button type='button' class='"+boton+" btn-sm btnCambiarEstGC'  title ='"+tituloEstado+"' attr-id='"+full.grupoCID+"'" + "' attr-nombre='"+full.grupoCname+"'" + 
                            "' attr-estado='"+full.grupoCidEstado+"'" + "> </button> ";
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
    $("#lstEmpresa_filter").hide();
}


GrupoComercial.prototype.listModulos = function () {
	var id=$("#grupoComer_idAM").val();
	var obj=this;
	$.ajax({
		url : "/SistemaFE/grupocomer/obtenerModulos/",
		type : "POST",
		data : {
			"id":id
		},
		dataType : "json",
		beforeSend : function() {
		},
		success : function(data) {
			$('#arbolSeleccionable').jstree({
				'plugins' : [
					"checkbox"
				],
                'core': {
                    'data': data.json
                },
                'checkbox': {
                    //'three_state': true
                	tie_selection : false 
                },
            }).on('loaded.jstree', function() {
            	$("#arbolSeleccionable").jstree('open_all');
            		obj.reloadArbol();
            }).on("check_node.jstree uncheck_node.jstree", function(e, data) {
            		        obj.reloadArbol();
            		});
			
			
//			$('#arbol').jstree({
//				'plugins' : [
//					"types",
//					"json_data",
//					"dnd"
//				],
//                'core': {
//                    //'data': data.json
//                }
//            }).on('create_node.jstree', function(e, data) {
//                console.log('saved');
//            });
			
//			var data1 = [{
//			    "id": "p1",
//			    "parent": "#",
//			    "text": "Parent-1"
//			  }, {
//			    "id": "p2",
//			    "parent": "#",
//			    "text": "Parent-2"
//			  }, {
//			    "id": "c1",
//			    "parent": "p2",
//			    "text": "Child 1"
//			  }, {
//			    "id": "c2",
//			    "parent": "p2",
//			    "text": "Child 2"
//			  } ];
			
			$('#arbol').jstree({
				'plugins' : [
					"types",
					"json_data",
					"dnd"
				],
                'core': {
                	'check_callback': true
                	//'data': data1
                }
            }).on('create_node.jstree', function(e, data) {
                console.log('saved');
            }).on('loaded.jstree', function() {
            	$("#arbol").jstree('open_all');
            });
			$("#arbolSeleccionable").jstree('open_all');
			
			
//			$('#arbol').jstree().create_node('#', {
//			      "id": "p5",
//			      "text": "Parent-8740000"
//			    }, "last", function() {
//			    });
			
			
			
		},
		error : function(xhr, statusText, errorThrown) {
			console.log("ocurrio un error");  
		}
	});
	
}

GrupoComercial.prototype.reloadArbol = function() {
	$('#arbol').jstree(true).settings.core.data = null;
	$('#arbol').jstree(true).refresh();
	var selecionados = $('#arbolSeleccionable').jstree("get_checked").sort();
	for(var y=0;y<selecionados.length;y++){
		var id=selecionados[y];
		var termino=true;
		var a =  $('#arbolSeleccionable').jstree(true).get_node(id);
		var listaNodos=[];
		listaNodos[0]=id;
		listaNodos.push.apply(listaNodos, a.parents);
		console.log("ids: "+listaNodos +" size: "+listaNodos.length);
		for(var t=listaNodos.length-1;t>=0;t--){
			console.log("nodo["+t+"] = "+listaNodos[t]);
			if(listaNodos[t]=='#'){
				console.log("Estas en el nodo #");
			}else{
				var aux =  $('#arbolSeleccionable').jstree(true).get_node(listaNodos[t]);
				console.log("id : "+listaNodos[t]+" padre: "+aux.parent);
				if($('#arbol').jstree(true).get_node(listaNodos[t])){
		          console.log("Existe el nodo no se creara");
		        }else{
		          console.log("no Existe el nodo se creara padre: "+aux.parent+" hijo :"+listaNodos[t]);
					$('#arbol').jstree().create_node(aux.parent, {
		               "id": aux.id,
		               "text": aux.text,
		                "icon": aux.icon,
						"state": "open"
		            }, "last", function() {
		            });
		        }
			}
		}
	}
	$("#arbol").jstree('open_all');
}



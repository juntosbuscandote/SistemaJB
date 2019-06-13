/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//agregando validacion para el formulario de usuarios

/*$("#frmUsuario").validate({
 rules: {
 
 frmUsuarioNombreComp:{
 required : true,
 number:true,
 maxlength: 20,
 minlength:10
 },
 frmUsuarioCorreo:{
 required : true,
 email: true,
 maxlength: 20,
 minlength:10
 }
 },
 messages: {
 frmUsuarioNombreComp: {
 required: "Campo Requerido",
 number: "solo number",
 maxlenth: "maximo 20 ",
 minlength: "minimo 10"
 },
 frmUsuarioCorreo: {
 required: "Campo Requerido",
 email: "formato incorrecto",
 maxlenth: "maximo 20 ",
 minlength: "minimo 10"
 }
 }
 });
 */
//$("#agregar").on("click", function () {
//    document.getElementById("modalEmpresa").reset();
//});
//
//$("#ubigeo").on("click", function () {
//    document.getElementById("modalUbigeo").reset();
//});

$("#frmbussines").validate({
    rules: {

        busi_vbusiname: {
            required: true,
          
        },
        busi_vruc: {
            required: true,
            number: true,
             minlength: 200
        },
        busi_vaddress: {
            required: true
        },
        busi_vcodcountry: {
            required: true
        },
        busi_vemail: {
            required: true
        },
        busi_vphone: {
            required: true
        }
//        ,
//        frmEmpresaUbigeo: {
//            required: true
//        },
//        frmEmpresaTelefono: {
//            required: true,
//            number: true
//        },
//        frmEmpresaMonedaPrincipal: {
//            required: true
//        },
//        frmEmpresaMonedaSecundaria: {
//            required: true
//        }
    },
    messages: {

        busi_vruc: {
            required: "Campo Obligatorio",
            number: "Solo 11 Digitos",
            minlength: "Minimo 11 caracteres"
        },
        busi_vaddress: {
            required: "Campo Obligatorio"
        },
        busi_vcodcountry: {
            required: "Campo Obligatorio"
        },
        busi_vemail: {
            required: "Campo Obligatorio"
        },
        busi_vphone: {
            required: "Campo Obligatorio"
//        },
//        frmEmpresaPais: {
//            required: "Campo Obligatorio"
//        },
//        frmEmpresaUbigeo: {
//            required: "Campo Obligatorio"
//        },
//        frmEmpresaTelefono: {
//            required: "Campo Obligatorio",
//            number: "Solo N&uacute;meros"
//        },
//        frmEmpresaMonedaPrincipal: {
//            required: "Campo Obligatorio"
//        },
//        frmEmpresaMonedaSecundaria: {
//            required: "Campo Obligatorio"
//        }
    } }
});



//$(document).ready(function () {
//    $("#frmEmpresaDefinirSegunEmpresaBase").click(function () {
//        if ($(this).is(':checked')) {
//            document.getElementById("frmEmpresaCopiarDatosSegunEmpresaBase").disabled = true;
//            document.getElementById("frmEmpresaTipoEmresa").disabled = false;
//            document.getElementById("frmEmpresaEmpresaJalarPlanCuentas").disabled = false;
//            document.getElementById("frmEmpresaEmpresaJalarConceptosDetraccion").disabled = false;
//        } else {
//            document.getElementById("frmEmpresaCopiarDatosSegunEmpresaBase").disabled = false;
//            document.getElementById("frmEmpresaTipoEmresa").disabled = true;
//            document.getElementById("frmEmpresaEmpresa").disabled = true;
//            document.getElementById("frmEmpresaEmpresaJalarPlanCuentas").disabled = true;
//            document.getElementById("frmEmpresaEmpresaJalarAmarreCuentas").disabled = true;
//            document.getElementById("frmEmpresaEmpresaJalarDefinicionCuentas").disabled = true;
//            document.getElementById("frmEmpresaEmpresaJalarConceptosDetraccion").disabled = true;
//        }
//    });
//});

//$(document).ready(function () {
//    $("#frmEmpresaCopiarDatosSegunEmpresaBase").click(function () {
//        if ($(this).is(':checked')) {
//            document.getElementById("frmEmpresaDefinirSegunEmpresaBase").disabled = true;
//            document.getElementById("frmEmpresaEmpresa").disabled = false;
//        } else {
//            document.getElementById("frmEmpresaDefinirSegunEmpresaBase").disabled = false;
//            document.getElementById("frmEmpresaTipoEmresa").disabled = true;
//            document.getElementById("frmEmpresaEmpresa").disabled = true;
//            document.getElementById("frmEmpresaEmpresaJalarPlanCuentas").disabled = true;
//            document.getElementById("frmEmpresaEmpresaJalarAmarreCuentas").disabled = true;
//            document.getElementById("frmEmpresaEmpresaJalarDefinicionCuentas").disabled = true;
//            document.getElementById("frmEmpresaEmpresaJalarConceptosDetraccion").disabled = true;
//        }
//    });
//});


function valida(e) {
    tecla = (document.all) ? e.keyCode : e.which;

    //Tecla de retroceso para borrar, siempre la permite
    if (tecla == 8) {
        return true;
    }

    // Patron de entrada, en este caso solo acepta numeros
    patron = /[0-9]/;
    tecla_final = String.fromCharCode(tecla);
    return patron.test(tecla_final);
}
$(document).ready(function () {
    var table = $('#lstEmpresa').DataTable();
    $("#close-link").click(function () {
        $('#myModal').modal('toggle');
    });
    $("#edit").click(function () {
        $("#inputSuccess2").val("124521458745");
        alert(table.cell(this).data());
    });
    var handleDataTableButtons = function () {
        if ($("#datatable-buttons").length) {
            $("#datatable-buttons").DataTable({
                dom: "Bfrtip",
                buttons: [
                    {
                        extend: "copy",
                        className: "btn-sm"
                    },
                    {
                        extend: "csv",
                        className: "btn-sm"
                    },
                    {
                        extend: "excel",
                        className: "btn-sm"
                    },
                    {
                        extend: "pdfHtml5",
                        className: "btn-sm"
                    },
                    {
                        extend: "print",
                        className: "btn-sm"
                    },
                ],
                responsive: true
            });
        }
    };

    TableManageButtons = function () {
        "use strict";
        return {
            init: function () {
                handleDataTableButtons();
            }
        };
    }();

    $('#datatable').dataTable();

    $('#datatable-keytable').DataTable({
        keys: true
    });

    $('#datatable-responsive').DataTable();

    $('#datatable-scroller').DataTable({
        ajax: "js/datatables/json/scroller-demo.json",
        deferRender: true,
        scrollY: 380,
        scrollCollapse: true,
        scroller: true
    });

    $('#datatable-fixed-header').DataTable({
        fixedHeader: true
    });

    var $datatable = $('#datatable-checkbox');

    $datatable.dataTable({
        'order': [[1, 'asc']],
        'columnDefs': [
            {orderable: false, targets: [0]}
        ]
    });
    $datatable.on('draw.dt', function () {
        $('input').iCheck({
            checkboxClass: 'icheckbox_flat-green'
        });
    });

    TableManageButtons.init();
    $("#frmEmpresaGuardar").on("click", function () {
        $.ajax({
            url: "/SistemaERPContable/empresa/InsertarEmpresa",
            data: $("#frmEmpresa").serialize(),
            type: "POST",
            dataType: "json",
            success: function (data) {

            },
            error: function (xhr, statusText, errorThrown)
            {
                console.log("ocurrio un error");
            }
        });
    });


});


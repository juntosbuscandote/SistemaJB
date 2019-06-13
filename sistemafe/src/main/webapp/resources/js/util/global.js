var system = system || {};
system.globalMethods = system.globalMethods || (function ($) {
	var setValidatorDefaults = function setValidatorDefaults() {
		$.validator.setDefaults({
            errorElement: "small"
        });
        $.extend($.validator.messages, {
            required: "Campo requerido",
            maxlength: "Máximo {0} caracteres",
            minlength: "Mínimo {0} caracteres",
            digits: "Debe contener dígitos",
            email: "Formato incorrecto",
            emailmasivo: "Formato incorrecto. Ingrese uno o más correos separados por punto y coma (;)",
            espacioBlanco: "Campo requerido",
            number: "Campo numérico",
        });
        $.validator.addMethod('email', function (emailaddr, element) {
            var emailaddr = emailaddr.replace(/\s+/g, '');
            return this.optional(element) || 
            emailaddr.match(/^(([^<>()\[\]\.,;:\s@\"]+(\.[^<>()\[\]\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\.,;:\s@\"]+\.)+[^<>()[\]\.,;:\s@\"]{2,3})$/);
       });
       
        
	};
	
	var setSoloNumero = function setSoloNumero(){
//		 var valorllego = "";
//		 $('.tipodoc').change(function (){
//			 var valorllego = this.value;
//		     $("#pers_vnumdoc").val("");			
				 $('.solo-numero').keyup(function (){
//					var entrada = $("#pers_vdoctype").val();
//					  if(entrada=="0" || entrada =="10"){
//						  this.value = (this.value + '').replace(/^[A-Za]+$/g, '');	
//					  }else{
						  var expregnumeros = /[^0-9]/g;
					        this.value = (this.value + '').replace(expregnumeros, '');
//					  }
					  }); 
//		 });
	};
	
	
	var setAutocompletado = function setAutocompletado(){
		var $select2Enabled = $(".select2-enabled");
  		$select2Enabled.each(function() {
            $(this).select2({
            	dropdownParent: $(this).parents(".select2-parent")
            })
        });
	};
	
	var verPersona = function verPersona(data){
		$("#pers_vdoctype").val("");
		$("#pers_vnumdoc").val("");
		$("#natural_vname").val("");
		$("#natural_vlastnamefather").val("");
		$("#natural_vlastnamemother").val("");
		$("#natural_vtradename").val("");
		$("#natural_vtipoPerson").val("");
		$("#natural_vmail").val("");
		$("#natural_vphone").val("");
		$("#natural_vpais").val("");
		$("#natural_vlocalidad").val("");
		$("#natural_vaddress").val("");
		$("#legal_vbusiname").val("");
		$("#legal_vtradename").val("");
		$("#legal_vphone").val("");
		$("#legal_vpais").val("");
		$("#legal_vlocalidad").val("");
		$("#legal_vmail").val("");
		$("#legal_vaddress").val("");
		$("#legal_vtipoPerson").val("");
		$("#frmTipoPersonNatural").attr("disabled", true);
		$("#frmTipoPersonLegal").attr("disabled", true);
		
		$("#pers_vdoctype").val(data.persDoctype);
		$("#pers_vnumdoc").val(data.persNumdoc);
		if(data.tipoPerson=="N"){
			$("#frmTipoPersonNatural").prop("checked", true);
			$("#personNatural").show();
        	$("#personLegal").hide();
			$("#natural_vname").val(data.naturalName);
			$("#natural_vlastnamefather").val(data.naturalLastnamefather);
			$("#natural_vlastnamemother").val(data.naturalLastnameMother);
			$("#natural_vtradename").val(data.naturalTradename);
			$("#natural_vtipoPerson").val(data.naturalTipoPerson);
			$("#natural_vmail").val(data.naturalMail);
			$("#natural_vphone").val(data.naturalPhone);
			$("#natural_vpais").val(data.naturalPais);
			$("#natural_vlocalidad").val(data.naturalLocalidad);
			$("#natural_vaddress").val(data.naturalAddress);
		}else if(data.tipoPerson=="L"){
			$("#frmTipoPersonLegal").prop("checked", true);
			$("#personNatural").hide();
        	$("#personLegal").show();
			$("#legal_vbusiname").val(data.legalBusiname);
			$("#legal_vtradename").val(data.legalTradename);
			$("#legal_vphone").val(data.legalPhone);
			$("#legal_vpais").val(data.legalPais);
			$("#legal_vlocalidad").val(data.legalLocalidad);
			$("#legal_vmail").val(data.legalEmail);
			$("#legal_vaddress").val(data.legalAddress);
			$("#legal_vtipoPerson").val(data.legalTipoPerson);
		}
	};
	
	return {
        setValidatorDefaults: setValidatorDefaults,
        setAutocompletado: setAutocompletado,
        setSoloNumero: setSoloNumero,
        verPersona: verPersona,
    };
})(jQuery);
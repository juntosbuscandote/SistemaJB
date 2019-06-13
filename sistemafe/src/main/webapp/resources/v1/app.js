
function rucValido(ruc) {
    //11 dígitos y empieza en 10,15,16,17 o 20
    /*
    if (!(ruc >= 1e10 && ruc < 11e9
       || ruc >= 15e9 && ruc < 18e9
       || ruc >= 2e10 && ruc < 21e9))
        return false;

    for (var suma = 0, i = 0; i<11; i++, ruc = ruc/10|0)
        suma += (ruc % 10) * (i % 7 + (i/7|0) + 1);
    return suma % 11 === 0;
    */
    return true;
    suma = 0;
  	x = 6;
  	for (i=0; i<ruc.length-1;i++){
    	if ( i == 4 ) x = 8;
    	digito = ruc.charAt(i) - '0';
    	alert(ruc.charAt(i));
    	x--;
    	if ( i==0 ) suma += (digito*x);
    	else suma += (digito*x);
  	}

  	resto = suma % 11;
  	resto = 11 - resto;
  
  	if ( resto >= 10) resto = resto - 10;
  	if ( resto == ruc.charAt( ruc.length-1 ) - '0' ){
    	return true;
	} 

	return false;
}


new Vue({
	el: '#consulta_ruc',
	data: {
		fecha_actualizacion:'',
		url:'',
		encontrado:'',
		c_estado:'list-group-item',
		c_condicion:'list-group-item',
        new_ruc:'',
        razon_social:'',
        estado:'',
        condicion:'',
        ubigeo:'',
        departamento:'',
        provincia:'',
        distrito:'',
        direccion:''
	},
	methods: {
		validarInput: function(){
			var resultado=document.getElementById("resultado"),
				existente=document.getElementById("existente"),
				valido;
			if(this.new_ruc.length==11){

				resultado.classList.add("visible");

				//Es entero?    
			    if ((this.new_ruc = Number(this.new_ruc)) && this.new_ruc % 1 === 0 && rucValido(this.new_ruc)) { // ⬅️ ⬅️ ⬅️ ⬅️ Acá se comprueba
			      valido = "Válido";
			        resultado.classList.add("ok");
			        this.obtenerDatosSUNAT();
			        existente.classList.add("visible");
			    } else {
			        valido = "No válido";
			      resultado.classList.remove("ok");
			      existente.classList.remove("visible");
			    }
			        
			    resultado.innerText = "Formato: " + valido;
			}
			else{ 
				valido = "No válido";
			    resultado.classList.remove("ok");
			    existente.classList.remove("visible");
			}
		},
		obtenerDatosSUNAT: function(){
			
			this.departamento='dep';
			this.provincia='';
			this.distrito='';
			this.razon_social='';
			this.estado='';
			this.condicion='';
			this.direccion='';
			this.ubigeo='';
			this.fecha_actualizacion='';
			
			this.c_estado='list-group-item';
			this.c_condicion='list-group-item';

			//var Url_ubigeo='http://e-facturador.primaxkevin.com/public/api/ubigeo?dep=UCAYALI&prov=CORONEL%20PORTILLO&dist=CALLERIA';
			var url='http://apis.grupotecom.com/api/ConsultaRuc?ruc='+this.new_ruc;
			axios.get(url).then(async response => {
				
				if(response.data.success){
					

//					this.ruc=this.new_ruc;
					this.RUC=response.data.result.RUC;
					this.razon_social=response.data.result.RazonSocial;
					this.tipo_contribuyente=response.data.result.Tipo;
				 	this.nombre_comercial=response.data.result.NombreComercial;
					this.fecha_inscripcion=response.data.result.Inscripcion;
					this.estado=response.data.result.Estado;
					this.condicion=response.data.result.Condicion;
					this.ubigeo=response.data.result.Ubigeo;
					this.direccion=response.data.result.DireccionFiscal;
					this.departamento=response.data.result.Departamento;
					this.provincia=response.data.result.Provincia;
					this.distrito=response.data.result.Distrito;
//					empresa
					$("#pers_vnumdoc").val(this.RUC);
					$("#lega_businame").val(this.razon_social);
					$("#pers_vtradename").val(this.NombreComercial);			
					$("#addr_vaddress").val(this.direccion);
					$("#Estado").val(this.estado);
					$("#Condicion").val(this.condicion);
//					empresa
//					usuario
					$("#pers_vnumdoc").val(this.RUC);
					$("#legal_vbusiname").val(this.razon_social);
					$("#legal_vtradename").val(this.NombreComercial);
					$("#legal_vdepartamento").val(this.departamento);
					$("#legal_vprovincia").val(this.provincia);
					$("#legal_vdistrito").val(this.distrito);
					$("#legal_vaddress").val(this.direccion);
//					usuario
//					cliente
					$("#frmClienteNroDoc").val(this.RUC);
					$("#frmClienteRazSocCli").val(this.razon_social);
					$("#frmClienteNomComercial").val(this.NombreComercial);
					$("#listUbigeos").val(this.departamento);
					$("#listUbigeosprov").val(this.provincia);
					$("#listUbigeosdistr").val(this.distrito);
					$("#frmClienteDireccion").val(this.direccion);
//					cliente
					if(this.estado=='ACTIVO') //if(/ACTIVO/.test(this.estado))
					{	this.c_estado="list-group-item list-group-item-success";}
					else
					{	this.c_estado="list-group-item list-group-item-danger";}
					if(this.condicion=='HABIDO') //if(/HABIDO/.test(this.condicion))
					{	this.c_condicion="list-group-item list-group-item-success";}
					else
					{	this.c_condicion="list-group-item list-group-item-danger";}

				}
				else{
			    	resultado.classList.remove("ok");
			    	existente.classList.remove("visible");
			    	resultado.innerText = "RUC: No encontrado";
				}
			});
		}
	},
	mounted() {
		this.$refs.ruc.focus();
	}
});
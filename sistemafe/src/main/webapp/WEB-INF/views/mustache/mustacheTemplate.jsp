
<script type="text/template" id="cboMaster">
    {{#toption}}
    <option value="{{id}}" data-type="{{type}}"  attr-sym="{{moneda}}" attr-color="{{colorinput}}">{{des}}</option>
    {{/toption}}
</script>

<script type="text/template" id="cboMasterPres">
    <option value="remover1">Seleccione</option>
    {{#toption}}
    <option value="{{id}}" attr-stock="{{store}}" data-type="{{type}}">{{des}}</option>
    {{/toption}}
</script>

<script type="text/template" id="cboMasterP">
    <option value=""></option>
    {{#toption}}
    <option value="{{id}}" data-type="{{type}}">{{des}} - {{nomDesc}}</option>
    {{/toption}}
</script>

<script type="text/template" id="cboMasterPersonas">
    {{#toption}}
        <option value="{{bident}}" attr-tipdoc="{{persVdoctype}}" 
		 attr-numdoc="{{persVnumdoc}}" attr-nombre="{{nombre}}" attr-email="{{mailVmail}}" 
		 attr-direccion="{{direccionUbigeoPais}}">{{persVnumdocDes}} - {{nombres}}</option>
    {{/toption}}
</script>
<script type="text/template" id="cboMasterTipCambio">
    {{#toption}}
        <option value="{{id}}" attr-venta="{{venta}}">v: {{venta}}</option>
		<option value="{{id}}" attr-compra="{{compra}}">c: {{compra}}</option>
		<option value="{{id}}" attr-promedio="{{promedio}}">p: {{promedio}}</option>
    {{/toption}}
</script>

<script type="text/template" id="cboMasterSaldoAnterior">
    {{#toption}}
        <option value="{{id}}" attr-venta="{{saldAnterior}}">{{saldAnterior}}</option>
    {{/toption}}
</script>
<script type="text/template" id="cboMasterAlmacen">
    {{#toption}}
    <option value="{{id}}" data-type="{{type}}">{{des}}</option>
    {{/toption}}
</script>

<script type="text/template" id="cboMasterserie">
    {{#toption}}
    <option value="{{id}}" attr-venta="{{serie}}" attr-ventas="{{numDoc}}"  data-type="{{type}}">{{des}}</option>
    {{/toption}}
</script>

<script type="text/template" id="cboAnticipos">
    <option value=""></option>
    {{#toption}}
    <option value="{{saleBident}}" attr-fecha="{{saleTregistrationDate}}" attr-total="{{saleTotalAnticipo}}" 
	attr-totalDisponible="{{saleTotalDisponibleAnticipo}}" attr-serie="{{saleVserieVoucher}}" attr-numero="{{saleVnumberVoucher}}" >{{saleVserieVoucher}} - {{saleVnumberVoucher}}</option>
    {{/toption}}
</script>
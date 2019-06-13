package pe.am.spring.entity;
import java.sql.Timestamp;
import java.util.List;


public class DocElecBean {

    public String correoClienteFinal;
    public String tipoDocElectronico;
    public String nroDocElectronico;
    public String fechaEmision;
    public String firmaDigital;
    public String idCliente;
    public String descripcionEmisor;// apellido y nombres, denominacion ,  razonsocial
    public String informacionCliente;
    public String nombreComercialCliente;
    public String domicilioFiscalCliente;
    public String tipoDocEmisor;
    public String numDocEmisor;
    public String tipoDocCliente;
    public String nroDocCliente;
    public String nombreComercialEmisor;
    public String domicilioFiscalEmisor;
    public String ubigeoEmisor;
    public String direcCompletaEmisor;
    public String codPaisEmisor;
    public String distritoEmisor;
    public String departamentoEmisor;
    public String provinciaEmisor;
    public String urbEmisor;
    public String numRuc;
    public String fechaGenDocBaja;
    public String tipoNotaDebito;
    public String tipoNotaCredito;
    public String tipoDoc;
    public String numDoc;
    public String numCorrDocBaja;
    public String motBaja;
    public String descripcionAdquiriente;// apellido y nombres, denominacion ,  razonsocial
    public String direccionPaisAdquiriente;
    public String motivoSustento;
    public String identComunicacion;
    public String versionUBL;
    public String versionEstructDoc;
    
    public List<Item> listaItems;

    public class Item {

        String numItem;
        String numOrdenItem;
        String valorRefUnidItem;
        String unidadMedidaItem;
        String fechaGenDoc;
        String cantUnidItem;
        String codProducto;
        String descrDetallada;
        String valorUnitItem;
        String precioVentaItem;
        String afectIGVItem;
        String sistemaISCItem;
        String totalVentaGravada;
        String totalVentaInafecta;
        String totalVentaExonerada;
        String valorVentaItem;
    }

    public String getCorreoClienteFinal() {
        return correoClienteFinal;
    }

    public void setCorreoClienteFinal(String correoClienteFinal) {
        this.correoClienteFinal = correoClienteFinal;
    }

    public String getTipoDocElectronico() {
        return tipoDocElectronico;
    }

    public void setTipoDocElectronico(String tipoDocElectronico) {
        this.tipoDocElectronico = tipoDocElectronico;
    }

    public String getNroDocElectronico() {
        return nroDocElectronico;
    }

    public void setNroDocElectronico(String nroDocElectronico) {
        this.nroDocElectronico = nroDocElectronico;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getFirmaDigital() {
        return firmaDigital;
    }

    public void setFirmaDigital(String firmaDigital) {
        this.firmaDigital = firmaDigital;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getDescripcionEmisor() {
        return descripcionEmisor;
    }

    public void setDescripcionEmisor(String descripcionEmisor) {
        this.descripcionEmisor = descripcionEmisor;
    }

    public String getInformacionCliente() {
        return informacionCliente;
    }

    public void setInformacionCliente(String informacionCliente) {
        this.informacionCliente = informacionCliente;
    }

    public String getNombreComercialCliente() {
        return nombreComercialCliente;
    }

    public void setNombreComercialCliente(String nombreComercialCliente) {
        this.nombreComercialCliente = nombreComercialCliente;
    }

    public String getDomicilioFiscalCliente() {
        return domicilioFiscalCliente;
    }

    public void setDomicilioFiscalCliente(String domicilioFiscalCliente) {
        this.domicilioFiscalCliente = domicilioFiscalCliente;
    }

    public String getTipoDocEmisor() {
        return tipoDocEmisor;
    }

    public void setTipoDocEmisor(String tipoDocEmisor) {
        this.tipoDocEmisor = tipoDocEmisor;
    }

    public String getNumDocEmisor() {
        return numDocEmisor;
    }

    public void setNumDocEmisor(String numDocEmisor) {
        this.numDocEmisor = numDocEmisor;
    }

    public String getTipoDocCliente() {
        return tipoDocCliente;
    }

    public void setTipoDocCliente(String tipoDocCliente) {
        this.tipoDocCliente = tipoDocCliente;
    }

    public String getNroDocCliente() {
        return nroDocCliente;
    }

    public void setNroDocCliente(String nroDocCliente) {
        this.nroDocCliente = nroDocCliente;
    }

    public String getNombreComercialEmisor() {
        return nombreComercialEmisor;
    }

    public void setNombreComercialEmisor(String nombreComercialEmisor) {
        this.nombreComercialEmisor = nombreComercialEmisor;
    }

    public String getDomicilioFiscalEmisor() {
        return domicilioFiscalEmisor;
    }

    public void setDomicilioFiscalEmisor(String domicilioFiscalEmisor) {
        this.domicilioFiscalEmisor = domicilioFiscalEmisor;
    }

    public String getUbigeoEmisor() {
        return ubigeoEmisor;
    }

    public void setUbigeoEmisor(String ubigeoEmisor) {
        this.ubigeoEmisor = ubigeoEmisor;
    }

    public String getDirecCompletaEmisor() {
        return direcCompletaEmisor;
    }

    public void setDirecCompletaEmisor(String direcCompletaEmisor) {
        this.direcCompletaEmisor = direcCompletaEmisor;
    }

    public String getCodPaisEmisor() {
        return codPaisEmisor;
    }

    public void setCodPaisEmisor(String codPaisEmisor) {
        this.codPaisEmisor = codPaisEmisor;
    }

    public String getDistritoEmisor() {
        return distritoEmisor;
    }

    public void setDistritoEmisor(String distritoEmisor) {
        this.distritoEmisor = distritoEmisor;
    }

    public String getDepartamentoEmisor() {
        return departamentoEmisor;
    }

    public void setDepartamentoEmisor(String departamentoEmisor) {
        this.departamentoEmisor = departamentoEmisor;
    }

    public String getProvinciaEmisor() {
        return provinciaEmisor;
    }

    public void setProvinciaEmisor(String provinciaEmisor) {
        this.provinciaEmisor = provinciaEmisor;
    }

    public String getUrbEmisor() {
        return urbEmisor;
    }

    public void setUrbEmisor(String urbEmisor) {
        this.urbEmisor = urbEmisor;
    }

    public String getNumRuc() {
        return numRuc;
    }

    public void setNumRuc(String numRuc) {
        this.numRuc = numRuc;
    }

    public String getFechaGenDocBaja() {
        return fechaGenDocBaja;
    }

    public void setFechaGenDocBaja(String fechaGenDocBaja) {
        this.fechaGenDocBaja = fechaGenDocBaja;
    }

    public String getTipoNotaDebito() {
        return tipoNotaDebito;
    }

    public void setTipoNotaDebito(String tipoNotaDebito) {
        this.tipoNotaDebito = tipoNotaDebito;
    }

    public String getTipoNotaCredito() {
        return tipoNotaCredito;
    }

    public void setTipoNotaCredito(String tipoNotaCredito) {
        this.tipoNotaCredito = tipoNotaCredito;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(String numDoc) {
        this.numDoc = numDoc;
    }

    public String getNumCorrDocBaja() {
        return numCorrDocBaja;
    }

    public void setNumCorrDocBaja(String numCorrDocBaja) {
        this.numCorrDocBaja = numCorrDocBaja;
    }

    public String getMotBaja() {
        return motBaja;
    }

    public void setMotBaja(String motBaja) {
        this.motBaja = motBaja;
    }

    public String getDescripcionAdquiriente() {
        return descripcionAdquiriente;
    }

    public void setDescripcionAdquiriente(String descripcionAdquiriente) {
        this.descripcionAdquiriente = descripcionAdquiriente;
    }

    public String getDireccionPaisAdquiriente() {
        return direccionPaisAdquiriente;
    }

    public void setDireccionPaisAdquiriente(String direccionPaisAdquiriente) {
        this.direccionPaisAdquiriente = direccionPaisAdquiriente;
    }

    public String getMotivoSustento() {
        return motivoSustento;
    }

    public void setMotivoSustento(String motivoSustento) {
        this.motivoSustento = motivoSustento;
    }

    public String getIdentComunicacion() {
        return identComunicacion;
    }

    public void setIdentComunicacion(String identComunicacion) {
        this.identComunicacion = identComunicacion;
    }

    public String getVersionUBL() {
        return versionUBL;
    }

    public void setVersionUBL(String versionUBL) {
        this.versionUBL = versionUBL;
    }

    public String getVersionEstructDoc() {
        return versionEstructDoc;
    }

    public void setVersionEstructDoc(String versionEstructDoc) {
        this.versionEstructDoc = versionEstructDoc;
    }

    public List<Item> getListaItems() {
        return listaItems;
    }

    public void setListaItems(List<Item> listaItems) {
        this.listaItems = listaItems;
    }
    
    
    
}

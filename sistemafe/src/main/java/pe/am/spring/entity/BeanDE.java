package pe.am.spring.entity;
import java.util.List;

public class BeanDE {
	private DocumentoBean items;
	private List<DocumentoBean> detdocelec;
	private List<DocumentoBean> anticipos;
	private List<Leyenda> leyendas;

	public BeanDE() {
		super();
	}

	public DocumentoBean getItems() {
		return items;
	}

	public void setItems(DocumentoBean items) {
		this.items = items;
	}

	public List<DocumentoBean> getDetdocelec() {
		return detdocelec;
	}

	public void setDetdocelec(List<DocumentoBean> detdocelec) {
		this.detdocelec = detdocelec;
	}

	public List<DocumentoBean> getAnticipos() {
		return anticipos;
	}

	public void setAnticipos(List<DocumentoBean> anticipos) {
		this.anticipos = anticipos;
	}

	public List<Leyenda> getLeyendas() {
		return leyendas;
	}

	public void setLeyendas(List<Leyenda> leyendas) {
		this.leyendas = leyendas;
	}
}

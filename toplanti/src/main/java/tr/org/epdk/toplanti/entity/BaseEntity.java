package tr.org.epdk.toplanti.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity {

	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="version")
	private String version;
	
	@Column(name="aciklama")
	private String aciklama;
	
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getAciklama() {
		return aciklama;
	}

	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}

	public int getId() {
		return id;
	}
	
	
	
}

package tr.org.epdk.toplanti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="toplanti_odasi")
public class ToplantiOdasi extends BaseEntity {
	
	public int getKapasite() {
		return kapasite;
	}

	public void setKapasite(int kapasite) {
		this.kapasite = kapasite;
	}

	public Birim getBirim() {
		return birim;
	}

	public void setBirim(Birim birim) {
		this.birim = birim;
	}

	public Toplanti getToplanti() {
		return toplanti;		
	}

	public void setToplanti(Toplanti toplanti) {
		this.toplanti = toplanti;
	}

	@Column(name="kapasite")
	private int kapasite;
	
	@ManyToOne
	private Birim birim;
	
	@OneToOne
	private Toplanti toplanti;
	
}

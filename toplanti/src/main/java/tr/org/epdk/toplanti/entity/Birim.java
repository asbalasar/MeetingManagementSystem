package tr.org.epdk.toplanti.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="birim")
public class Birim extends BaseEntity{

	@Column(name="ad")
	private String ad;
	
	@Column(name="kat")
	private int kat;
	
	
	@OneToOne
	@JoinColumn(name="yoneticiId")
	private Kullanici yonetici;
	
	@OneToMany
	private List<ToplantiOdasi>toplantiOdalari;

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public int getKat() {
		return kat;
	}

	public void setKat(int kat) {
		this.kat = kat;
	}

	public Kullanici getYonetici() {
		return yonetici;
	}

	public void setYonetici(Kullanici yonetici) {
		this.yonetici = yonetici;
	}

	public List<ToplantiOdasi> getToplantiOdalari() {
		return toplantiOdalari;
	}

	public void setToplantiOdalari(List<ToplantiOdasi> toplantiOdalari) {
		this.toplantiOdalari = toplantiOdalari;
	}

	
}

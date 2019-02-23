package tr.org.epdk.toplanti.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="toplanti")
public class Toplanti extends BaseEntity {

	public Date getBaslangicSaati() {
		return baslangicSaati;
	}

	public void setBaslangicSaati(Date baslangicSaati) {
		this.baslangicSaati = baslangicSaati;
	}

	public Date getBitisSaati() {
		return bitisSaati;
	}

	public void setBitisSaati(Date bitisSaati) {
		this.bitisSaati = bitisSaati;
	}

	public String getKonu() {
		return konu;
	}

	public void setKonu(String konu) {
		this.konu = konu;
	}

	public Kullanici getDuzenleyen() {
		return duzenleyen;
	}

	public void setDuzenleyen(Kullanici duzenleyen) {
		this.duzenleyen = duzenleyen;
	}

	public List<Kullanici> getKatilimcilar() {
		return katilimcilar;
	}

	public void setKatilimcilar(List<Kullanici> katilimcilar) {
		this.katilimcilar = katilimcilar;
	}

	public ToplantiOdasi getToplantiOdasi() {
		return toplantiOdasi;
	}

	public void setToplantiOdasi(ToplantiOdasi toplantiOdasi) {
		this.toplantiOdasi = toplantiOdasi;
	}

	@Column(name="baslangicSaati")
	private Date baslangicSaati;
	
	@Column(name="bitisSaati")
	private Date bitisSaati;
	
	@Column(name="konu")
	private String konu;
	
	@ManyToOne
	private Kullanici duzenleyen;
	
	@OneToMany(mappedBy="id")
	private List<Kullanici> katilimcilar;
	
	@OneToOne
	private ToplantiOdasi toplantiOdasi;
	
}

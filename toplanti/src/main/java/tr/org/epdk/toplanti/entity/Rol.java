package tr.org.epdk.toplanti.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="rol")
public class Rol extends BaseEntity{
	
	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public List<Kullanici> getKullaniciList() {
		return kullaniciList;
	}

	public void setKullaniciList(List<Kullanici> kullaniciList) {
		this.kullaniciList = kullaniciList;
	}

	public List<Yetki> getYetkiList() {
		return yetkiList;
	}

	public void setYetkiList(List<Yetki> yetkiList) {
		this.yetkiList = yetkiList;
	}

	@Column(name="ad")
	private String ad;
	
	@OneToMany(mappedBy="id")
	private List<Kullanici> kullaniciList;
	
	@OneToMany(mappedBy="id")
	private List<Yetki> yetkiList;

	
}

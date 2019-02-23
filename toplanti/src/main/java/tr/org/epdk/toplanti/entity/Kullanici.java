package tr.org.epdk.toplanti.entity;

import java.util.Date;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="kullanici")
public class Kullanici extends BaseEntity {

	@Column(name="ad")
	private String ad;
	
	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	public String getTckn() {
		return Tckn;
	}

	public void setTckn(String Tckn) {
		this.Tckn = Tckn;
	}

	public Date getDogumTarihi() {
		return dogumTarihi;
	}

	public void setDogumTarihi(Date dogumTarihi) {
		this.dogumTarihi = dogumTarihi;
	}

	public String getDogumYeri() {
		return dogumYeri;
	}

	public void setDogumYeri(String dogumYeri) {
		this.dogumYeri = dogumYeri;
	}




	public List<Rol> getRol() {
		return rol;
	}

	public void setRol(List<Rol> rol) {
		this.rol = rol;
	}

	public Birim getBirim() {
		return birim;
	}

	public void setBirim(Birim birim) {
		this.birim = birim;
	}

	@Column(name="soyad")
	private String soyad;
	
	@Column(name="Tckn")
	private String Tckn;
	
	@Column(name="dogumTarihi")
	private Date dogumTarihi;
	
	@Column(name="dogumYeri")
	private String dogumYeri;
	
	@ManyToOne
	@JoinColumn (name="birim_id")
	private Birim birim;
	
	

	@ManyToMany
	private List<Rol> rol;
}


//public Toplanti getToplantiId() {
//return toplantiId;
//}
//
//public void setToplantiId(Toplanti toplantiId) {
//this.toplantiId = toplantiId;
//}
//
//public Toplanti getToplanti() {
//return toplanti;
//}
//
//public void setToplanti(Toplanti toplanti) {
//this.toplanti = toplanti;
//}

//@ManyToOne
//@JoinColumn(name="katilimciListesi")
//private Toplanti toplantiId;
//
//@OneToOne
//@JoinColumn(name="duzenleyen_id")
//private Toplanti toplanti;


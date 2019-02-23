package tr.org.epdk.toplanti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

import tr.org.epdk.toplanti.entity.BaseEntity;
 
@Entity
@Table(name="kullanici")
public class Kullanici  extends BaseEntity {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
 
    @Size(min=3, max=50)
    @Column(name = "ad", nullable = false)
    private String ad;
 
    @NotNull
    @DateTimeFormat(pattern="dd/MM/yyyy") 
    @Column(name = "joining_date", nullable = false)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate joiningDate;
    
    @Column(name = "adres")
    private String adres;
 
     
    @NotEmpty
    @Column(name = "ssn", unique=true, nullable = false)
    private String ssn;
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 

 
    public LocalDate getJoiningDate() {
        return joiningDate;
    }
 
    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }
 
 
    public String getSsn() {
        return ssn;
    }
 
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
 
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((ssn == null) ? 0 : ssn.hashCode());
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Kullanici))
            return false;
        Kullanici other = (Kullanici) obj;
        if (id != other.id)
            return false;
        if (ssn == null) {
            if (other.ssn != null)
                return false;
        } else if (!ssn.equals(other.ssn))
            return false;
        return true;
    }
 
    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + ad + ", joiningDate="
                + joiningDate + ", ssn=" + ssn + "]";
    }

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}
     
}

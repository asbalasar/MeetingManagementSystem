package tr.org.epdk.toplanti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="yetki")
public class Yetki extends BaseEntity{

	@Column(name="ad")
	private String ad;
	
	@ManyToOne
	private Rol rol;
	
}

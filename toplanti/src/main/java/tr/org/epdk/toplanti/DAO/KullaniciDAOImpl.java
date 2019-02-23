package tr.org.epdk.toplanti.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import tr.org.epdk.toplanti.entity.Kullanici;
 
 
@Repository("kullaniciDAO")
public class KullaniciDAOImpl extends AbstractDAO<Integer, Kullanici> implements KullaniciDAO {
 
    public Kullanici findById(int id) {
        return getByKey(id);
    }
 
    public void saveKullanici(Kullanici kullanici) {
        persist(kullanici);
    }
 
    public void deleteKullaniciByTckn(String Tckn) {
        Query query = getSession().createSQLQuery("delete from Kullanici where Tckn = :Tckn");
        query.setString(Tckn, "Tckn");
        query.executeUpdate();
    }
 
    @SuppressWarnings("unchecked")
    public List<Kullanici> findAllKullanici() {
        Criteria criteria = createEntityCriteria();
        return (List<Kullanici>) criteria.list();
    }
 
    public Kullanici findKullaniciByTckn(String Tckn) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("Tckn", Tckn));
        return (Kullanici) criteria.uniqueResult();
    }
}

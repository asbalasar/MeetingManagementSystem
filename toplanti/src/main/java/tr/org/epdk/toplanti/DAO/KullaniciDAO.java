package tr.org.epdk.toplanti.DAO;

import java.util.List;

import tr.org.epdk.toplanti.entity.Kullanici;
 
 
public interface KullaniciDAO {
 
    Kullanici findById(int id);
 
    void saveKullanici(Kullanici kullanici);
     
    void deleteKullaniciByTckn(String Tckn);
     
    List<Kullanici> findAllKullanici();
 
    Kullanici findKullaniciByTckn(String Tckn);
 
}
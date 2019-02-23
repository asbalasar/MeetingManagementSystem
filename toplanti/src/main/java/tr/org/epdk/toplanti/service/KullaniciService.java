package tr.org.epdk.toplanti.service;

import java.util.List;

import tr.org.epdk.toplanti.entity.Kullanici;


public interface KullaniciService {

   Kullanici findById(int id);
    
   void saveKullanici(Kullanici kullanici);
    
   void updateKullanici(Kullanici kullanici);
    
   void deleteKullaniciByTckn(String Tckn );

   List<Kullanici> findAllKullanici(); 
    
   Kullanici findKullaniciByTckn(String Tckn);

   boolean isKullaniciTcknUnique(Integer id, String Tckn);
    
}
package tr.org.epdk.toplanti.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tr.org.epdk.toplanti.DAO.KullaniciDAO;
import tr.org.epdk.toplanti.entity.Kullanici;
 
 
@Service("kullaniciService")
@Transactional
public class KullaniciServiceImpl implements KullaniciService {
 
    @Autowired
    private KullaniciDAO dao;
     
    public Kullanici findById(int id) {
        return dao.findById(id);
    }
 
    public void saveKullanici(Kullanici kullanici) {
        dao.saveKullanici(kullanici);
    }
 
    /*
     * Since the method is running with Transaction, No need to call hibernate update explicitly.
     * Just fetch the entity from db and update it with proper values within transaction.
     * It will be updated in db once transaction ends. 
     */
    public void updateKullanici(Kullanici kullanici) {
    	Kullanici entity = dao.findById(kullanici.getId());
        if(entity!=null){
            entity.setAd(kullanici.getAd());
            entity.setDogumTarihi(kullanici.getDogumTarihi());
            entity.setTckn(kullanici.getTckn());
        }
    }
 
    public void deleteKullaniciByTckn(String Tckn) {
        dao.deleteKullaniciByTckn(Tckn);
    }
     
    public List<Kullanici> findAllKullanici() {
        return dao.findAllKullanici();
    }
 
    public Kullanici findKullaniciByTckn(String Tckn) {
        return dao.findKullaniciByTckn(Tckn);
    }
 
    public boolean isKullaniciTcknUnique(Integer id, String Tckn) {
    	Kullanici kullanici = findKullaniciByTckn(Tckn);
        return ( kullanici == null || ((id != null) && (kullanici.getId() == id)));
    }
     
}

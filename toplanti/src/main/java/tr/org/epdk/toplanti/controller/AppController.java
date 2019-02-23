	package tr.org.epdk.toplanti.controller;

import java.util.List;
import java.util.Locale;
 
import javax.validation.Valid;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
import tr.org.epdk.toplanti.entity.Kullanici;
import tr.org.epdk.toplanti.service.KullaniciService;;
 
@Controller
@RequestMapping("/")
public class AppController {
 
    @Autowired
    KullaniciService service;
     
    @Autowired
    MessageSource messageSource;

    /*
     * This method will list all existing employees.
     */
    @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
    public String listKullanicilar(ModelMap model) {
 
        List<Kullanici> kullanicilar = service.findAllKullanici();
        model.addAttribute("kullanicilar", kullanicilar);
        return "allKullanicilar";
    }
 
    
    @RequestMapping(value = { "/new" }, method = RequestMethod.GET)
    public String newKullanici(ModelMap model) {
    	Kullanici kullanici = new Kullanici();
        model.addAttribute("kullanici", kullanici);
        model.addAttribute("edit", false);
        return "registration";
    }
 
    
    @RequestMapping(value = { "/new" }, method = RequestMethod.POST)
    public String saveKullanici(@Valid Kullanici kullanici, BindingResult result,
            ModelMap model) {
 
        if (result.hasErrors()) {
            return "registration";
        }
 
        /*
         * Preferred way to achieve uniqueness of field [Tckn] should be implementing custom @Unique annotation 
         * and applying it on field [Tckn] of Model class [Employee].
         * 
         * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors outside the validation
         * framework as well while still using internationalized messages.
         * 
         */
        if(!service.isKullaniciTcknUnique(kullanici.getId(), kullanici.getTckn())){
            FieldError TcknError =new FieldError("kullanici","Tckn",messageSource.getMessage("non.unique.Tckn", new String[]{kullanici.getTckn()}, Locale.getDefault()));
            result.addError(TcknError);
            return "registration";
        }
         
        service.saveKullanici(kullanici);
 
        model.addAttribute("success", "kullanici " + kullanici.getAd() + " registered successfully");
        return "success";
    }
 
 
    /*
     * This method will provide the medium to update an existing employee.
     */
    @RequestMapping(value = { "/edit-{Tckn}-kullanici" }, method = RequestMethod.GET)
    public String editKullanici(@PathVariable String Tckn, ModelMap model) {
        Kullanici kullanici = service.findKullaniciByTckn(Tckn);
        model.addAttribute("kullanici", kullanici);
        model.addAttribute("edit", true);
        return "registration";
    }
     
    /*
     * This method will be called on form submission, handling POST request for
     * updating employee in database. It also validates the user input
     */
    @RequestMapping(value = { "/edit-{Tckn}-kullanici" }, method = RequestMethod.POST)
    public String updateKullanici(@Valid Kullanici kullanici, BindingResult result,
            ModelMap model, @PathVariable String Tckn) {
 
        if (result.hasErrors()) {
            return "registration";
        }
 
        if(!service.isKullaniciTcknUnique(kullanici.getId(), kullanici.getTckn())){
            FieldError TcknError =new FieldError("kullanici","Tckn",messageSource.getMessage("non.unique.Tckn", new String[]{kullanici.getTckn()}, Locale.getDefault()));
            result.addError(TcknError);
            return "registration";
        }
 
        service.updateKullanici(kullanici);
 
        model.addAttribute("success", "Kullanici " + kullanici.getAd()  + " updated successfully");
        return "success";
    }
 
     
    /*
     * This method will delete an employee by it's Tckn value.
     */
    @RequestMapping(value = { "/delete-{Tckn}-kullanici" }, method = RequestMethod.GET)
    public String deleteKullanici(@PathVariable String Tckn) {
        service.deleteKullaniciByTckn(Tckn);
        return "redirect:/list";
    }
 
}

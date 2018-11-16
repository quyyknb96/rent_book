package quytn.eas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import quytn.eas.entity.Manager;
import quytn.eas.service.ManagerService;

import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private ManagerService managerService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getViewLogin(HttpSession session){
        if (session.getAttribute("userLogin") != null) {
            return "redirect:/home";
        } else {
            return "login";
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, Model model, Manager manager) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        String passwordMD5 = DatatypeConverter.printHexBinary(digest.digest(manager.getPassword().getBytes()));
        manager.setPassword(passwordMD5);
        Optional<Manager> optional = managerService.checkLogin(manager);
        if (optional.isPresent()) {
            session.setAttribute("userLogin", optional.get());
            return "redirect:/";
        } else {
            model.addAttribute("errorMessenger","Login fail. Wrong username or password. Please try agian");
            return "login";
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
}

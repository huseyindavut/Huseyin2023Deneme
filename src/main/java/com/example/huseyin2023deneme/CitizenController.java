package com.example.huseyin2023deneme;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


@RestController
public class CitizenController {
    @Autowired
    private CitizenRepository citizenRepostory;

    @Autowired
    HttpSession session;

    private Logger logger = LoggerFactory.getLogger(CitizenController.class);

    @GetMapping("/hello")
    public String hello() {
        return "Your controller is working";
    }

    @PostMapping("/saveCitizen")
    public void lagreKunde(Citizen citizen, HttpServletResponse response ) throws IOException {
        citizenRepostory.saveCitizen(citizen);

    }

    @GetMapping("/loginn")
    public boolean login(String username, String password) {
        if (citizenRepostory.loggInn(username, password)){
            session.setAttribute("huseyin",true);
            return true;
        }
        else{
            return false;
        }
    }

    @GetMapping("/logout")
    public void logOut(){
        session.removeAttribute("huseyin");
    }
    @GetMapping("/removeUnderage")
    public boolean removeUnderage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (session.getAttribute("huseyin") != null){
            try {
                List<Citizen> citizenList=citizenRepostory.getCitizenList();
                for (Citizen citizen : citizenList) {
                    if (calculateAge(LocalDate.parse(citizen.getDoB()), LocalDate.now())<18){
                        citizenRepostory.removeCitizen(citizen.getSSN());
                        System.out.println(citizen.getFirstName());
                    }
                }
                return true;
            }catch (Exception e){
                logger.error("Error in removing underage citizens from database");
                return false;
            }
        }else {
            return false;
        }
    }
    public static int calculateAge(LocalDate birthday, LocalDate currentDate) {
        if ((birthday!=null) && (currentDate!=null)){
            return Period.between(birthday, currentDate).getYears();
        }else {
            return 0;
        }
    }
    @GetMapping("/showCitizen")
    public List<Citizen> showCitizen(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Citizen> citizenList=citizenRepostory.getCitizenList();
        Collections.sort(citizenList, Comparator.comparing(Citizen::getSurname));
        return citizenList;
    }
}


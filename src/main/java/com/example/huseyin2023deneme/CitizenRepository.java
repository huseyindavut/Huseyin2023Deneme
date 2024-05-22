package com.example.huseyin2023deneme;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CitizenRepository {
    @Autowired
    private JdbcTemplate db;

    private Logger logger=LoggerFactory.getLogger(CitizenController.class);

    public boolean saveCitizen(Citizen citizen ) {
        String sql = "insert into Citizen(firstName,surname,DoB,SSN,phoneNr,email,city,street) values(?,?,?,?,?,?,?,?)";
        try {
            db.update(sql,citizen.getFirstName(),citizen.getSurname(),citizen.getDoB(),citizen.getSSN(),
                    citizen.getPhoneNr(),citizen.getEmail(),citizen.getCity(), citizen.getStreet());
            return true;
        }catch (Exception e){
            logger.error("An error occured when saving citizen to database : "+e);
            return false;
        }
    }

    public List<Citizen> getCitizenList() {
        String sql = "SELECT * FROM Citizen";
        try{
            return db.query(sql,new BeanPropertyRowMapper(Citizen.class));
        }
        catch(Exception e){
            logger.error("Feil i hent alle citizen "+e);
            return null;
        }
    }

    public boolean loggInn(String username,String x){
        String sql = "SELECT * FROM User_1 WHERE username = ?";
        try{
            List<User_1> users = db.query(sql,new BeanPropertyRowMapper(User_1.class),username);
            if(users != null){
                if(users.get(0).getPassword().equals(x)){
                    return true;
                }
            }
            return false;
        }
        catch(Exception e){
            return false;
        }
    }


    public boolean removeCitizen(String SNN) {
        String sql = "DELETE FROM Citizen WHERE SNN=?";
        try{
            db.update(sql,SNN);
            return true;
        }
        catch(Exception e){
            logger.error("Feil i slett en citizen"+e);
            return false;
        }
    }

}

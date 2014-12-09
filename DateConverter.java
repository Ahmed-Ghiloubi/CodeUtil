/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ahmed
 */
public class DateConverter {
    public static java.sql.Date DateToSqlDate(String dt){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date sqlDate = null ; 
        try { 
            Date parsed = format.parse(dt) ;
            sqlDate = new java.sql.Date(parsed.getTime()) ; 
        } catch (Exception ex) {
            return null ; 
        }
        return sqlDate ; 
    }
   
}

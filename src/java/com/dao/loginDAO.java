/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Alan
 */
public class loginDAO extends DAO{
    
    public boolean log(String user, String pass) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("SELECT user, pass FROM usuario WHERE user=? and pass=?;");
            st.setString(1, user);
            st.setString(2, pass);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error in login() -->" + e.getMessage());
            return false;
        } finally {
            this.Cerrar();
        }
    }
    
    
    
}

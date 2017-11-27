/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.dao.DAO;
import com.dao.loginDAO;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Alan
 */
@ManagedBean
@SessionScoped
public class loginBean {
    
    private static final long serialVersionUID = 1L;
    private String user;
    private String pass;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    public String login() throws Exception{
        loginDAO dao = new loginDAO();
        boolean resul = dao.log(user, pass);
        if (resul) {
            return "home.xhtml";
        }else{
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN,"Login invalido","Porfavor Reintenta"));
            return "index";
        }
    }
    
    public String close() throws Exception{
        DAO dao;
        try{
            dao = new DAO();
            dao.Cerrar();
            return "index";
        }catch(Exception e){
            throw e;
        }
    }
    
}

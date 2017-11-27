/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.dao.empresaDAO;
import com.model.empresa;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Alan
 */
@ManagedBean
@ViewScoped
public class empresaBean {

    private empresa empresa = new empresa();
    private List<empresa> lstempr;
    private String accion;

    public empresa getEmpr() {
        return empresa;
    }

    public void setEmpr(empresa empresa) {
        this.empresa = empresa;
    }

    public List<empresa> getLstempr() {
        return lstempr;
    }

    public void setLstempr(List<empresa> lstempr) {
        this.lstempr = lstempr;
    }
    
    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.limpiar();
        this.accion = accion;
    }
    
    public void operar() throws Exception {
        switch (accion) {
            case "Registrar":
                this.registrar();
                this.limpiar();
                break;
            case "Modificar":
                this.modificar();
                this.limpiar();
                break;
        }
    }

    private boolean isPostBack() {
        boolean rspt;
        rspt = FacesContext.getCurrentInstance().isPostback();
        return rspt;
    }

    public void limpiar() {
        this.empresa.setId_empresa(0);
        this.empresa.setNombre("");

    }

    private void registrar() throws Exception {
        empresaDAO dao;
        try {
            dao = new empresaDAO();
            dao.registrar(empresa);
            this.listar("V");
        } catch (Exception e) {
            throw e;
        }
    }

    private void modificar() throws Exception {
        empresaDAO dao;
        try {
            dao = new empresaDAO();
            dao.modificar(empresa);
            this.listar("V");
        } catch (Exception e) {
            throw e;
        }
    }

    public void listar(String valor) throws Exception {
        empresaDAO dao;
        try {
            if (valor.equals("F")) {
                if (isPostBack() == false) {
                    dao = new empresaDAO();
                    lstempr = dao.listar();
                }
            } else {
                dao = new empresaDAO();
                lstempr = dao.listar();
            }

        } catch (Exception e) {
            throw e;
        }
    }

    public void leerID(empresa tipo) throws Exception {
        empresaDAO dao;
        empresa temp;
        try {
            dao = new empresaDAO();
            temp = dao.leerID(tipo);
            if (temp != null) {
                this.empresa = temp;
                this.accion = "Modificar";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminar(empresa tipo) throws Exception {
        empresaDAO dao;
        try {
            dao = new empresaDAO();
            dao.eliminar(tipo);
            this.listar("V");
        } catch (Exception e) {
            throw e;
        }
    }

}

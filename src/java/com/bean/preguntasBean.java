/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.dao.preguntasDAO;
import com.model.empresa;
import com.model.preguntas;
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
public class preguntasBean {

    private preguntas preguntas = new preguntas();
    private empresa empresa = new empresa();
    private List<preguntas> lstpre, lstpreem;
    private String accion;

    public preguntas getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(preguntas preguntas) {
        this.preguntas = preguntas;
    }

    public List<preguntas> getLstpre() {
        return lstpre;
    }

    public void setLstpre(List<preguntas> lstpre) {
        this.lstpre = lstpre;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.limpiar();
        this.accion = accion;
    }

    public List<preguntas> getLstpreem() {
        return lstpreem;
    }

    public void setLstpreem(List<preguntas> lstpreem) {
        this.lstpreem = lstpreem;
    }

    public empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(empresa empresa) {
        this.empresa = empresa;
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
        this.preguntas.setNum_pregunta(0);
        this.preguntas.setId_empresa(0);
        this.preguntas.setCalidad(0);
        this.preguntas.setServicio(0);
        this.preguntas.setId_usuario("");
    }

    private void registrar() throws Exception {
        preguntasDAO dao;
        try {
            dao = new preguntasDAO();
            dao.registrar(preguntas);
            this.listar("V");
        } catch (Exception e) {
            throw e;
        }
    }

    private void modificar() throws Exception {
        preguntasDAO dao;
        try {
            dao = new preguntasDAO();
            dao.modificar(preguntas);
            this.listar("V");
        } catch (Exception e) {
            throw e;
        }
    }

    public void listar(String valor) throws Exception {
        preguntasDAO dao;
        try {
            if (valor.equals("F")) {
                if (isPostBack() == false) {
                    dao = new preguntasDAO();
                    lstpre = dao.listar();
                }
            } else {
                dao = new preguntasDAO();
                lstpre = dao.listar();
            }

        } catch (Exception e) {
            throw e;
        }
    }

    public void leerID(preguntas tipo) throws Exception {
        preguntasDAO dao;
        preguntas temp;
        try {
            dao = new preguntasDAO();
            temp = dao.leerID(tipo);
            if (temp != null) {
                this.preguntas = temp;
                this.accion = "Modificar";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminar(preguntas tipo) throws Exception {
        preguntasDAO dao;
        try {
            dao = new preguntasDAO();
            dao.eliminar(tipo);
            this.listar("V");
        } catch (Exception e) {
            throw e;
        }
    }

    public void listarCliente(int valor) throws Exception {
        preguntasDAO dao;
        try {
            dao = new preguntasDAO();
            lstpreem = dao.listarCliente(valor);
        } catch (Exception e) {
            throw e;
        }
    }

    public void Cliente(int valor) throws Exception {
        preguntasDAO dao;
        try {
            dao = new preguntasDAO();
            lstpreem = dao.Cliente(valor);
        } catch (Exception e) {
            throw e;
        }
    }

    public void listarClientes() throws Exception {
        preguntasDAO dao;
        try {
            dao = new preguntasDAO();
            lstpre = dao.listarClientes();
        } catch (Exception e) {
            throw e;
        }
    }

}

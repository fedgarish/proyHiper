/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.dao.usuarioDAO;
import com.model.usuario;
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
public class usuarioBean {

    private usuario usuario = new usuario();
    private List<usuario> lstusu;
    private String accion;

    public usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(usuario usuario) {
        this.usuario = usuario;
    }

    public List<usuario> getLstusu() {
        return lstusu;
    }

    public void setLstusu(List<usuario> lstusu) {
        this.lstusu = lstusu;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
        this.limpiar();
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
        this.usuario.setId_usuario("");
        this.usuario.setNombre("");
        this.usuario.setApellido("");
        this.usuario.setTelefono("");
        this.usuario.setMail("");
        this.usuario.setDireccion("");
        this.usuario.setUser("");
        this.usuario.setPass("");
    }

    private void registrar() throws Exception {
        usuarioDAO dao;
        try {
            dao = new usuarioDAO();
            dao.registrar(usuario);
            this.listar("V");
        } catch (Exception e) {
            throw e;
        }
    }

    private void modificar() throws Exception {
        usuarioDAO dao;
        try {
            dao = new usuarioDAO();
            dao.modificar(usuario);
            this.listar("V");
        } catch (Exception e) {
            throw e;
        }
    }

    public void listar(String valor) throws Exception {
        usuarioDAO dao;
        try {
            if (valor.equals("F")) {
                if (isPostBack() == false) {
                    dao = new usuarioDAO();
                    lstusu = dao.listar();
                }
            } else {
                dao = new usuarioDAO();
                lstusu = dao.listar();
            }

        } catch (Exception e) {
            throw e;
        }
    }

    public void leerID(usuario tipo) throws Exception {
        usuarioDAO dao;
        usuario temp;
        try {
            dao = new usuarioDAO();
            temp = dao.leerID(tipo);
            if (temp != null) {
                this.usuario = temp;
                this.accion = "Modificar";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminar(usuario tipo) throws Exception {
        usuarioDAO dao;
        try {
            dao = new usuarioDAO();
            dao.eliminar(tipo);
            this.listar("V");
        } catch (Exception e) {
            throw e;
        }
    }

}

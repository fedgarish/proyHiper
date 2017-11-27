/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alan
 */
public class usuarioDAO extends DAO {

    public void registrar(usuario tipo) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("INSERT INTO usuario(id_usuario, nombre, apellido, telefono, "
                    + "mail, direccion, user, pass) VALUES (?, ?, ?, ? ,?, ?, ?, ?);");
            st.setString(1, tipo.getId_usuario());
            st.setString(2, tipo.getNombre());
            st.setString(3, tipo.getApellido());
            st.setString(4, tipo.getTelefono());
            st.setString(5, tipo.getMail());
            st.setString(6, tipo.getDireccion());
            st.setString(7, tipo.getUser());
            st.setString(8, tipo.getPass());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    public List<usuario> listar() throws Exception {
        List<usuario> lista;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement st = getCn().prepareCall("SELECT * FROM usuario;");
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                usuario tipo = new usuario();
                tipo.setId_usuario(rs.getString("id_usuario"));
                tipo.setNombre(rs.getString("nombre"));
                tipo.setApellido(rs.getString("apellido"));
                tipo.setTelefono(rs.getString("telefono"));
                tipo.setMail(rs.getString("mail"));
                tipo.setDireccion(rs.getString("direccion"));
                tipo.setUser(rs.getString("user"));
                tipo.setPass(rs.getString("pass"));
                lista.add(tipo);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    public usuario leerID(usuario tipo) throws Exception {
        usuario tipos = null;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("SELECT id_usuario, nombre, apellido FROM empresa "
                    + "WHERE id_usuario = ?;");
            st.setString(1, tipo.getId_usuario());
            rs = st.executeQuery();
            while (rs.next()) {
                tipos = new usuario();
                tipos.setId_usuario(rs.getString("id_usuario"));
                tipos.setNombre(rs.getString("nombre"));
                tipos.setApellido(rs.getString("apellido"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return tipo;
    }

    public void modificar(usuario tipo) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("UPDATE usuario SET id_usuario=?, nombre=?, apellido=?, "
                    + "telefono=?, mail=?, direccion=?, user=?, pass=? WHERE id_usuario=?;");
            st.setString(1, tipo.getId_usuario());
            st.setString(2, tipo.getNombre());
            st.setString(3, tipo.getApellido());
            st.setString(4, tipo.getTelefono());
            st.setString(5, tipo.getMail());
            st.setString(6, tipo.getDireccion());
            st.setString(7, tipo.getUser());
            st.setString(8, tipo.getPass());
            st.setString(9, tipo.getId_usuario());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    public void eliminar(usuario tipo) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("DELETE FROM usuario WHERE id_usuario=?;");
            st.setString(1, tipo.getId_usuario());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }
    
}

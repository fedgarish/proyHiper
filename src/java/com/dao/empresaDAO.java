/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.empresa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alan
 */
public class empresaDAO extends DAO {

    public void registrar(empresa tipo) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("INSERT INTO empresa(id_empresa, nombre) VALUES (?, ?);");
            st.setInt(1, tipo.getId_empresa());
            st.setString(2, tipo.getNombre());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    public List<empresa> listar() throws Exception {
        List<empresa> lista;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement st = getCn().prepareCall("SELECT * FROM empresa;");
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                empresa tipo = new empresa();
                tipo.setId_empresa(rs.getInt("id_empresa"));
                tipo.setNombre(rs.getString("nombre"));
                lista.add(tipo);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    public empresa leerID(empresa tipo) throws Exception {
        empresa tipos = null;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("SELECT id_empresa, nombre FROM empresa WHERE id_empresa = ?;");
            st.setInt(1, tipo.getId_empresa());
            rs = st.executeQuery();
            while (rs.next()) {
                tipos = new empresa();
                tipos.setId_empresa(rs.getInt("id_empresa"));
                tipos.setNombre(rs.getString("nombre"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return tipo;
    }

    public void modificar(empresa tipo) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("UPDATE empresa SET id_empresa=?, nombre=? WHERE id_empresa=?;");
            st.setInt(1, tipo.getId_empresa());
            st.setString(2, tipo.getNombre());
            st.setInt(3, tipo.getId_empresa());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    public void eliminar(empresa tipo) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("DELETE FROM empresa WHERE id_empresa=?;");
            st.setInt(1, tipo.getId_empresa());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

}

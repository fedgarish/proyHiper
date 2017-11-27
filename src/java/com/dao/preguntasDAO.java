/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.preguntas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alan
 */
public class preguntasDAO extends DAO {

    public void registrar(preguntas tipo) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("INSERT INTO preguntas (num_pregunta, id_empresa, "
                    + "calidad, servicio, id_usuario) VALUES (?, ?, ?, ? ,?);");
            st.setInt(1, tipo.getNum_pregunta());
            st.setInt(2, tipo.getId_empresa());
            st.setInt(3, tipo.getCalidad());
            st.setInt(4, tipo.getServicio());
            st.setString(5, tipo.getId_usuario());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    public List<preguntas> listar() throws Exception {
        List<preguntas> lista;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement st = getCn().prepareCall("SELECT * FROM preguntas;");
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                preguntas tipo = new preguntas();
                tipo.setNum_pregunta(rs.getInt("num_pregunta"));
                tipo.setId_empresa(rs.getInt("id_empresa"));
                tipo.setCalidad(rs.getInt("calidad"));
                tipo.setServicio(rs.getInt("servicio"));
                tipo.setId_usuario(rs.getString("id_usuario"));
                lista.add(tipo);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    public preguntas leerID(preguntas tipo) throws Exception {
        preguntas tipos = null;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("SELECT * FROM preguntas WHERE num_pregunta = ?;");
            st.setString(1, tipo.getId_usuario());
            rs = st.executeQuery();
            while (rs.next()) {
                tipos = new preguntas();
                tipos.setNum_pregunta(rs.getInt("num_pregunta"));
                tipos.setId_empresa(rs.getInt("id_empresa"));
                tipos.setCalidad(rs.getInt("calidad"));
                tipos.setServicio(rs.getInt("servicio"));
                tipos.setId_usuario(rs.getString("id_usuario"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return tipo;
    }

    public void modificar(preguntas tipo) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("UPDATE preguntas SET num_pregunta=?, id_empresa=?, "
                    + "calidad=?, servicio=?, id_usuario=? WHERE num_pregunta=?;");
            st.setInt(1, tipo.getNum_pregunta());
            st.setInt(2, tipo.getId_empresa());
            st.setInt(3, tipo.getCalidad());
            st.setInt(4, tipo.getServicio());
            st.setString(5, tipo.getId_usuario());
            st.setInt(6, tipo.getNum_pregunta());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    public void eliminar(preguntas tipo) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("DELETE FROM preguntas WHERE num_pregunta=?;");
            st.setInt(1, tipo.getNum_pregunta());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    public List<preguntas> listarCliente(int numero) throws Exception {
        List<preguntas> lista;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement st = getCn().prepareCall("SELECT num_pregunta, id_empresa, "
                    + "calidad, servicio, id_usuario FROM preguntas where id_empresa=" + numero + ";");
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                preguntas cuenta = new preguntas();
                cuenta.setNum_pregunta(rs.getInt("id_cuenta"));
                cuenta.setId_empresa(rs.getInt("id_usuario"));
                cuenta.setCalidad(rs.getInt("saldo"));
                cuenta.setServicio(rs.getInt("id_cuenta"));
                cuenta.setId_usuario(rs.getString("id_usuario"));
                lista.add(cuenta);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    public List<preguntas> listarClientes() throws Exception {
        List<preguntas> lista;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement st = getCn().prepareCall("SELECT num_pregunta, id_empresa, "
                    + "calidad, servicio, id_usuario FROM preguntas;");
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                preguntas cuenta = new preguntas();
                cuenta.setNum_pregunta(rs.getInt("id_cuenta"));
                cuenta.setId_empresa(rs.getInt("id_usuario"));
                cuenta.setCalidad(rs.getInt("saldo"));
                cuenta.setServicio(rs.getInt("id_cuenta"));
                cuenta.setId_usuario(rs.getString("id_usuario"));
                lista.add(cuenta);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    public List<preguntas> Cliente(int numero) throws Exception {
        List<preguntas> lista;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement st = getCn().prepareCall("SELECT num_pregunta, id_empresa, "
                    + "calidad, servicio, id_usuario FROM preguntas where id_empresa=" + numero + ";");
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                preguntas cuenta = new preguntas();
                cuenta.setNum_pregunta(rs.getInt("id_cuenta"));
                cuenta.setId_empresa(rs.getInt("id_usuario"));
                cuenta.setCalidad(rs.getInt("saldo"));
                cuenta.setServicio(rs.getInt("id_cuenta"));
                cuenta.setId_usuario(rs.getString("id_usuario"));
                lista.add(cuenta);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }

}

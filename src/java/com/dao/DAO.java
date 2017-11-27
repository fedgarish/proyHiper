/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import java.sql.*;

/**
 *
 * @author Alan
 */
public class DAO {

    private Connection cn;

    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }

    public void Conectar() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://sql10.freesqldatabase.com:3306/sql10206977", "sql10206977", "P95uStxVmQ");
            System.out.println("Conexion exitosa");
        } catch (Exception e) {
            System.out.println("Conexion fallida");
            throw e;
        }
    }

    public void Cerrar() throws Exception {
        try {
            if (cn != null) {
                if (cn.isClosed() == false) {
                    cn.close();
                }
            }
        } catch (Exception e) {
            throw e;
        }

    }

}

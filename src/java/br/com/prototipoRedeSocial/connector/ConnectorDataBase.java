/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prototipoRedeSocial.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author kono
 */
public class ConnectorDataBase {
    
        public static Connection getConexao() throws SQLException{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/prototipoRedeSocial?zeroDateTimeBehavior=convertToNull","root","berinjela");
        }  catch (SQLException | ClassNotFoundException e) {
            throw new SQLException(e);
        }	
    }
    
}

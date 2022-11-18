package com.iam.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Classe utilizada para conectar e desconectar do banco de dados.
 */


public class Conexao {
  public static void main(String[] args) throws SQLException {
    Conexao conexao = new Conexao();
    Connection conn = conexao.conectar();
    conexao.desconectar(conn);
  }

  public Connection conectar(){
    Connection conn = null;
    try {
     Class.forName("com.mysql.cj.jdbc.Driver");
      conn = DriverManager.getConnection("jdbc:mysql://localhost/estudocaso_iam", "root", "123");
    } catch (SQLException ex) {
      System.out.println("Erro: Não conseguiu conectar no BD.");
    } catch (ClassNotFoundException ex) {
      System.out.println("Erro: Não encontrou o driver do BD.");
    }
	return conn;
  }

  public void desconectar(Connection conn) {
    try {
      if(conn != null && !conn.isClosed()) {
        conn.close();
       // System.out.println("Desconectou do banco de dados.");
      }
    } catch (SQLException ex) {
      System.out.println("Não conseguiu desconectar do BD.");
    }
  }
}
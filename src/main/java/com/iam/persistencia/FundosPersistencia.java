package com.iam.persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.iam.db.Conexao;

/**
 * Classe utilizada para demonstrar a consulta ao banco de dados.
 */
public class FundosPersistencia {
	
  public static void main(String[] args) {
    Conexao consultaBD = new Conexao();
    consultaBD.conectar();
  }

  
public String consulta(String perfil)  {
    Conexao conexao = new Conexao();
    Connection conn = conexao.conectar();
    String fundos = "";
    
    try {
      String consulta = "SELECT * FROM FUNDOS WHERE RISCO_FUNDO='" + perfil + "' AND DATA_ABERTURA_FUNDO <= CURDATE() AND (DATA_ENCERRAMENTO_FUNDO >= CURDATE() OR DATA_ENCERRAMENTO_FUNDO IS NULL); ";

      Statement stm = conn.createStatement();
      ResultSet resultado = stm.executeQuery(consulta);     
      
      while(resultado.next()) {
    	  String lstFundos = "";
    	  lstFundos+= "{\"COD_FUNDO\":\"" + resultado.getInt("COD_FUNDO") + "\",";
    	  lstFundos+= "\"NOME_FUNDO\":\"" +	resultado.getString("NOME_FUNDO") + "\",";
    	  lstFundos+= "\"CNPJ_FUNDO\":\"" +	resultado.getLong("CNPJ_FUNDO") + "\",";
    	  lstFundos+= "\"RISCO_FUNDO\":\"" +	resultado.getString("RISCO_FUNDO") + "\"}";
    	  lstFundos+= (resultado.isLast()) ? "" : "|,";    	  
    	  fundos+= lstFundos;
    	  
      }
      //System.out.println(fundos);
      return fundos + "";
      
    } catch (SQLException ex) {
      System.out.println("Não conseguiu consultar os dados.");
    } finally {
      conexao.desconectar(conn);
    }
	return null;
  }
}
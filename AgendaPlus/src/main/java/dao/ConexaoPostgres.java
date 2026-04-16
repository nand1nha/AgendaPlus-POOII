/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author 2024222760026
 */
public class ConexaoPostgres {
    private static Connection conexao;
    
    public static Connection obterConexsao() throws ClassNotFoundException, SQLException{
        // VARIAVEIS DE AMBIENTE
        String login = "postgres";
        String senha = "123456";
        String ip = "127.0.0.1:5432";
        String nomeBanco = "agendaplus";
        String url = "jdbc:postgresql://" + ip + "/" + nomeBanco;
        
        Class.forName("org.postgresql.Driver");
        conexao = DriverManager.getConnection(url, login, senha);
        
        return conexao;
        
    }
    
}

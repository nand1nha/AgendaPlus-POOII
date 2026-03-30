/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.ConexaoPostgres;
import java.sql.SQLException;

/**
 *
 * @author 2024222760026
 */
public class GerenciadorDominio {
    public GerenciadorDominio() throws ClassNotFoundException, SQLException {
        //TESTE
        ConexaoPostgres.obterConexsao();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import domain.Materia;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fsmar
 */
public class MateriaDAO {
    
    public List<Materia> listar() throws ClassNotFoundException, SQLException{
        Statement stmnt;
        stmnt = ConexaoPostgres.obterConexsao().createStatement();
        List<Materia> lista = new ArrayList();
        Materia mat;
        
        String sql = "SELECT * FROM materia";
        ResultSet res = stmnt.executeQuery(sql);
        
        while(res.next()){
            mat = new Materia(res.getInt("id"), res.getString("nome"), res.getString("descricao"), res.getString("nivel_dificuldade"));
            lista.add(mat);
        }
        
        return lista;
    }
}

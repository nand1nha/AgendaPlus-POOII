/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import domain.Materia;
import domain.TipoNivelDificuldade;
import java.sql.PreparedStatement;
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
    
    public void inserir(Materia mat) throws ClassNotFoundException, SQLException{
        
        String sql = "INSERT INTO materia (id,nome,descricao,nivel_dificuldade)  VALUES ( ?,?,?,? )";
        
        PreparedStatement pstmnt = ConexaoPostgres.obterConexsao().prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
        pstmnt.setString(1,mat.getDescricao());
        
        pstmnt.execute();
        
        ResultSet res = pstmnt.getGeneratedKeys();
        while(res.next()){
            int id = res.getInt(1);
            mat.setIdMateria(id);
        }
        
    }

    
    public List<Materia> listar() throws ClassNotFoundException, SQLException{
        Statement stmnt;
        stmnt = ConexaoPostgres.obterConexsao().createStatement();
        List<Materia> lista = new ArrayList();
        Materia mat;
        
        String sql = "SELECT * FROM materia";
        ResultSet res = stmnt.executeQuery(sql);
        
        while(res.next()){
            mat = new Materia(res.getInt("id"), res.getString("nome"), res.getString("descricao"), TipoNivelDificuldade.valueOf(res.getString("dificuldade")));
            lista.add(mat);
        }
        
        return lista;
    }
}

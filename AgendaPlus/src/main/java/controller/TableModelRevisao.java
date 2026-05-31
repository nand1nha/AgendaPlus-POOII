/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domain.Materia;
import domain.Revisao;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author fsmar
 */
public class TableModelRevisao extends AbstractTableModel{
    private List listaRevisoes = new ArrayList();

    @Override
    public int getRowCount() {
        return listaRevisoes.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        Revisao revisao = (Revisao) listaRevisoes.get(rowIndex);
        
        switch(columnIndex){
            case 0: return revisao.getSessaoEstudo().getMateria().getNome();
            case 1: return revisao.getSessaoEstudo().getDataEstudo();
            case 2: return revisao.getDataRevisao();
            case 3: return revisao.getStatus();
            
        }        
        return null;
    }

    @Override
    public String getColumnName(int column) {
        String nomes[] = {"Matéria", "Data de Estudo", "Revisão", "Status"};
        return nomes[column]; 
    }
    
    public Object getItem (int rowIndex) {
        return listaRevisoes.get(rowIndex);        
    }
    
    public void adicionar (Object item) {
        listaRevisoes.add(item);
        fireTableRowsInserted( listaRevisoes.size() - 1, listaRevisoes.size() - 1 );
        
    }
    
    public void remover (int indice) {
        listaRevisoes.remove(indice);
        fireTableRowsDeleted( indice, indice );
        
    }
    
    public void setLista(List<Object> novaLista) {
        if ( novaLista == null || novaLista.isEmpty()) {
            if ( !listaRevisoes.isEmpty() ) {
                listaRevisoes.clear();
                fireTableRowsDeleted(0,0);
            }
        } else {
            listaRevisoes = novaLista;
            fireTableRowsInserted( 0, listaRevisoes.size() - 1);
        }
           
    }
    
    public List<Object> getLista() {
        return listaRevisoes;
    }
}

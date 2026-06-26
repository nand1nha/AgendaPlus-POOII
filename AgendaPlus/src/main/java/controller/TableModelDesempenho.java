/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domain.Desempenho;
import domain.Materia;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author fsmar
 */
public class TableModelDesempenho extends AbstractTableModel{
    private List listaDesempenho = new ArrayList();

    @Override
    public int getRowCount() {
        return listaDesempenho.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        Desempenho desempenho = (Desempenho) listaDesempenho.get(rowIndex);
        
        switch(columnIndex){
            case 0: return desempenho.getMateria();
            case 1: return desempenho.getPercentualEvolucao();
            case 2: return desempenho.getMediaAcertos();
            case 3: return desempenho.getStatus();
            case 4: return desempenho.getProximaRevisao();
            
        }        
        return null;
    }

    @Override
    public String getColumnName(int column) {
        String nomes[] = {"Matéria", "Evolução(%)","Média de Acertos(%)", "Status", "Data da Revisão"};
        return nomes[column]; 
    }
    
    public Object getItem (int rowIndex) {
        return listaDesempenho.get(rowIndex);        
    }
    
    public void adicionar (Object item) {
        listaDesempenho.add(item);
        fireTableRowsInserted( listaDesempenho.size() - 1, listaDesempenho.size() - 1 );
        
    }
    
    public void remover (int indice) {
        listaDesempenho.remove(indice);
        fireTableRowsDeleted( indice, indice );
        
    }
    
    public void setLista(List<Object> novaLista) {
        if ( novaLista == null || novaLista.isEmpty()) {
            if ( !listaDesempenho.isEmpty() ) {
                listaDesempenho.clear();
                fireTableRowsDeleted(0,0);
            }
        } else {
            listaDesempenho = novaLista;
            fireTableRowsInserted( 0, listaDesempenho.size() - 1);
        }
           
    }
    
    public List<Object> getLista() {
        return listaDesempenho;
    }
}

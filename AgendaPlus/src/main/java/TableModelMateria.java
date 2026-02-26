
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 2024222760026
 */
public class TableModelMateria extends AbstractTableModel {
    
    private List listaMaterias = new ArrayList();

    @Override
    public int getRowCount() {
        return listaMaterias.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        Materia materias = (Materia) listaMaterias.get(rowIndex);
        
        switch(columnIndex){
            case 0: return materias.getNome();
            case 1: return materias.getDescricao();
            case 2: return materias.getDificuldade();
            
        }        
        return null;
    }

    @Override
    public String getColumnName(int column) {
        String nomes[] = {"Nome", "Descrição", "Dificuldade"};
        return nomes[column]; 
    }
    
    public Object getItem (int rowIndex) {
        return listaMaterias.get(rowIndex);        
    }
    
    public void adicionar (Object item) {
        listaMaterias.add(item);
        fireTableRowsInserted( listaMaterias.size() - 1, listaMaterias.size() - 1 );
        
    }
    
    public void remover (int indice) {
        listaMaterias.remove(indice);
        fireTableRowsDeleted( indice, indice );
        
    }
    
    public void setLista(List<Object> novaLista) {
        if ( novaLista == null || novaLista.isEmpty()) {
            if ( !listaMaterias.isEmpty() ) {
                listaMaterias.clear();
                fireTableRowsDeleted(0,0);
            }
        } else {
            listaMaterias = novaLista;
            fireTableRowsInserted( 0, listaMaterias.size() - 1);
        }
           
    }
    
    public List<Object> getLista() {
        return listaMaterias;
    }
    
}

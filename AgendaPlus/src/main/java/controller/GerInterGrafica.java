/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domain.Materia;
import java.awt.Frame;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import viewer.DlgCadMateria;
import viewer.DlgSessaoEstudo;
import viewer.FrmDesempenho;
import viewer.FrmRevisao;
import viewer.FrmTelaPrincipal;

/**
 *
 * @author 2024222760026
 */
public class GerInterGrafica {
    
    
    // ## SINGLETON ###
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmTelaPrincipal.class.getName());
    private static GerInterGrafica myInstance = new GerInterGrafica();
    private FrmTelaPrincipal princ;
    private DlgCadMateria janCadMateria;
    private DlgSessaoEstudo janSessaoEstudo;
    private FrmDesempenho janDesempenho;
    private FrmRevisao janRevisao;
    
    private GerenciadorDominio gerDominio;
    

    private GerInterGrafica() {
        try {
            gerDominio = new GerenciadorDominio();
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex,  "Inicialização", JOptionPane.ERROR_MESSAGE);
            System.exit(-1);
        }
    }

    public static GerInterGrafica getMyInstance() {
        return myInstance;
    }
    
    // ### FIM do SINGLETON

    public GerenciadorDominio getGerDominio() {
        return gerDominio;
    }

    
    private JDialog abrirJanela(java.awt.Frame parent, JDialog dlg, Class classe) {
        if (dlg == null){     
            try {
                dlg = (JDialog) classe.getConstructor(Frame.class, boolean.class).newInstance(parent,true);                                
            } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                JOptionPane.showMessageDialog(parent, "Erro ao abrir a janela " + classe.getName() + ". " + ex.getMessage() );
            } 
        }               
        dlg.setVisible(true); 
        return dlg;
    } 
    
    private JFrame abrirJanelaFrm(java.awt.Frame parent, JFrame frm, Class classe) {
        if (frm == null){     
            try {
                frm = (JFrame) classe.getConstructor().newInstance();                                
            } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                JOptionPane.showMessageDialog(parent, "Erro ao abrir a janela " + classe.getName() + ". " + ex.getMessage() );
            } 
        }               
        frm.setVisible(true); 
        return frm;
    } 
    
    public void abrirPrincipal(){
        if(princ == null){
            princ = new FrmTelaPrincipal();
        }
        princ.setVisible(true);
    }
    
    public void abrirCadMateria(){
        janCadMateria = (DlgCadMateria) abrirJanela(princ,janCadMateria,DlgCadMateria.class);
    }
    
    public void abrirSessaoEstudo(){
        janSessaoEstudo  = (DlgSessaoEstudo) abrirJanela(princ,janSessaoEstudo,DlgSessaoEstudo.class);
    }
    
    public void abrirDesempenho(){
        abrirJanelaFrm(princ,janDesempenho,FrmDesempenho.class).setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    public void abrirRevisao(){
        abrirJanelaFrm(princ,janRevisao,FrmRevisao.class).setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    public  void carregarComboMateria( JComboBox combo ){
        List<Materia> lista;
        try {
            lista = gerDominio.listarMateria();
            combo.setModel( new DefaultComboBoxModel(lista.toArray()));
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(princ, "Erro ao carregar materia " + ex);
        }
        
    }
    
     /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        GerInterGrafica.getMyInstance().abrirPrincipal();
    }
    
    
    
}

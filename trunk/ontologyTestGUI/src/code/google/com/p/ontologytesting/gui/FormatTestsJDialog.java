/*
 * FormatTestsJDialog.java
 *
 * Created on 27 de agosto de 2008, 8:54
 */

package code.google.com.p.ontologytesting.gui;

import java.awt.Dimension;

/**
 *
 * @author  sara.garcia
 */
public class FormatTestsJDialog extends javax.swing.JDialog {

    /** Creates new form FormatTestsJDialog */
    public FormatTestsJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        String formato="";
        int tab=GroupTestsJPanel.getSelectedTabed();
        descripcionEditorPane.setContentType("text/html");
        if(tab==0){
            formato = generarFormatoPermitidoInstanciacion();
        }else if(tab==1){
            formato = generarFormatoPermitidoRetrieval();
        }else if(tab==2){
            formato = generarFormatoPermitidoRealizacion();
        }else if(tab==3){
            formato = generarFormatoPermitidoSatisfactibilidad();
        }else if(tab==4){
            formato = generarFormatoPermitidoClasificacion();
        }else if(AddSPARQLJPanel.isSeleccionado()==true){
            formato = generarFormatoPermitidoSPARQL();
        }
        descripcionEditorPane.setText(formato);
        descripcionEditorPane.setEditable(false);
        this.setTitle("Formatos Permitidos");
    }

    private String generarFormatoPermitidoInstanciacion(){
        String formato="<html>" +
                "<h><b>FORMATOS PARA EL TEST DE INSTANCIACIÓN</h></b><br><br>" +
                "<b>CONSULTAS</b><br><br>" +
                "Clase,individuo<br>" +
                "Clase.individuo<br>" +
                "Clase(individuo)<br>" +
                "Clase individuo<br><br>" +
                "<b>RESULTADO ESPERADO</b><br><br>" +
                "True/False";
        return formato;
    }
    
    private String generarFormatoPermitidoRetrieval(){
        String formato="<html>" +
                "<h><b>FORMATOS PARA EL TEST DE RETRIEVAL</h></b><br><br>" +
                "<b>CONSULTAS</b><br><br>" +
                "Clase<br><br>" +
                "<b>RESULTADO ESPERADO</b><br><br>" +
                "Lista de individuos separados por coma, punto o un espacio en blanco";
        return formato;
    }
    
    private String generarFormatoPermitidoRealizacion(){
        String formato="<html>" +
                "<h><b>FORMATOS PARA EL TEST DE REALIZACION</h></b><br><br>" +
                "<b>CONSULTAS</b><br><br>" +
                "Indiviudo<br><br>" +
                "<b>RESULTADO ESPERADO</b><br><br>" +
                "Clase";
        return formato;
    }
    
    private String generarFormatoPermitidoSatisfactibilidad(){
        String formato="<html>" +
                "<h><b>FORMATOS PARA EL TEST DE SATISFACTIBILIDAD</h></b><br><br>" +
                "<b>CONSULTAS</b><br><br>" +
                "Individuo,Clase<br>" +
                "Individuo.Clase<br>" +
                "Individuo(Clase)<br>" +
                "Individuo Clase<br><br>" +
                "<b>RESULTADO ESPERADO</b><br><br>" +
                "True/False";
        return formato;
    }
    
    private String generarFormatoPermitidoClasificacion(){
        String formato="<html>" +
                "<h><b>FORMATOS PARA EL TEST DE CLASIFICACION</h></b><br><br>" +
                "<b>CONSULTAS</b><br><br>" +
                "Individuo<br><br>" +
                "<b>RESULTADO ESPERADO</b><br><br>" +
                "Lista de clases separados por coma, punto o un espacio en blanco";
        return formato;
    }
    
    private String generarFormatoPermitidoSPARQL(){
        this.setSize(new Dimension(600,600));
        String formato="<html>" +
                "<h><b>FORMATOS PARA EL TEST SPARQL</h></b><br><br>" +
                "<b>CONSULTAS</b><br><br>" +
                "Serán validas aquellas consultas que sean" +
                "gramaticalmente correctas siguiendo la sintaxis de SPARQL." +
                "Sólo estan permitidas consultas SELECT.<br><br>" +
                "<b>RESULTADO ESPERADO</b><br><br>" +
                "En caso de un SELECT simple, el resultado deberá de ser una lista " +
                "de objetos separados por coma, punto o espacio.<br><br>" +
                "En caso de un SELECT multiple el resultado deberá de especificar" +
                "en primer lugar el objeto al que se refiere en SELECT y entre " +
                "parentesis el resultado o la lista de resultados separados por " +
                "coma, punto o espacio que se espera obtener.<br><br>" +
                "Por ejemplo, para la consulta:<br><br>" +
                "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> <br>" +
                "SELECT ?subject ?object <br>" +
                "FROM 'ruta a la ontologia' <br>" +
                "WHERE {?subject rdfs:subClassOf ?object } <br><br>" +
                "El resultado se debe de mostrar de la siguient forma:<br><br>" +
                "subject(a,b,c) | subject(a b c) | subject(a.b.c) <br>" +
                "object(a,b,c) | object(a b c) | object(a.b.c)";    
        return formato;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        descripcionEditorPane = new javax.swing.JEditorPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane1.setViewportView(descripcionEditorPane);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 471, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 301, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JEditorPane descripcionEditorPane;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}

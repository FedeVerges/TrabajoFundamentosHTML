package detector_errores_html;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import java.util.regex.*;

/**
 *
 * @author Fundamentos de computación
 */
public class Detector_errores_HTML {

    /**
     * @param args the command line arguments
     */
    List<Linea> leer_html() {
        
        List<Linea> leer_archivo_html = new ArrayList<Linea>();
        try {
            JFileChooser fChooser = new JFileChooser("F:\\");//Cambiar por otro directorio 
            fChooser.showOpenDialog(null);
            File archivo = fChooser.getSelectedFile();
            FileInputStream fstream = new FileInputStream(archivo);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            
            String linea;
            while ((linea = br.readLine()) != null) {
                leer_archivo_html.add(new Linea(linea, linea.length()));
                
            }
            
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return leer_archivo_html;
    }
    /*
    List<Linea> ModificarHTML(List<Linea> archivo_HTML) {
        List<Linea> Modificar_archivo_HTML = new ArrayList();
        
        char[] linea;
        char[] bloqueB = {'-', '-'};
        String name;
        String[] nombres = {"Nombre", "Apellido", "DNI", "Cuil", "Correo_electronico", "Telefono", "Fecha_de_nacimiento", "Comentarios"};
        String lineaModificada = "-"; // linea del archivo html modificada. 
        String nuevo = "-"; // string auxiliar.
        File f = new File("pepito.html");
        
        FileWriter html = null;
        PrintWriter pw = null;
        String agregado;
        
        try {
            html = new FileWriter(f);
            pw = new PrintWriter(html);
            
            for (Linea l : archivo_HTML) {
                // copiar linea 

                if (l.get_linea().contains("<input")) {
                    
                    if (l.get_linea().contains("name")) {
                        for (int i = 0; i < l.get_largo(); i++) {
                            linea = l.get_linea().toCharArray();
                            for (i = 0; i < linea.length; i++) {
                                if (linea[i] == '=') {
                                    int inicio = i;
                                    while (linea[inicio] != '"') { // recorro la linea hasta encontrar las primeras comillas 
                                        inicio++;
                                    }
                                    while (linea[inicio + 1] != '"') { // recorro los caracteres que hay entre las comillas
                                        int indice = 0; // indice para que lo llene desde la posicion 0
                                        bloqueB[indice] = linea[inicio + 1];
                                        inicio++;
                                    }
                                    i = inicio; // actualizo el indice de la linea hasta las segundas comillas
                                    name = bloqueB.toString();
                                    // Controlar que name sea igual al arreglo de nombres 
                                    for (i = 0; i < nombres.length; i++) {
                                        if (name.equals(nombres[i])) {
                                            
                                            switch (name) {
                                                case "Nombre":
                                                    agregado = "pattern=\"<[a-zA-Z]{2-30}/>";
                                                    break;
                                                case "Apellido":
                                                    agregado = "pattern=\"<[a-zA-Z]{2-30}/>";
                                                    
                                                    break;
                                                case "DNI":
                                                    agregado = "pattern=\"<[0-9]{8}/>";
                                                    break;
                                                case "Cuil":
                                                    agregado = "pattern=\"<[0-99][0-9]{8}{0-9}/>";
                                                    break;
                                                case "Correo_electronico":
                                                    agregado = "pattern=\"<[a-zA-Z0-9]+([.][a-zA-Z0-9_-][+])*@[a-zA-Z]+([a-zA-Z][+])*.[a-zA-Z]+([.][a-zA-Z]){2-5}/>";
                                                    break;
                                                case "Telefono":
                                                    agregado = "pattern=\"<[0-9]{2-4}[0-9]{6-8}/>";
                                                    break;
                                                case "Fecha_de_nacimiento":
                                                    agregado = "pattern=\"< [0-31]/[0-12]/[1900-2018]/>";
                                                    break;
                                                case "Comentarios":
                                                    
                                                    agregado = "pattern=\"<[a-zA-Z0-9]/>";
                                                    break;
                                                default:
                                                    agregado = ">";
                                                    break;
                                                
                                            }
                                            nuevo = l.get_linea().replace(">", " "); // agregar el caso de imput en mas de una linea

                                            nuevo = nuevo.concat(agregado);
                                            
                                            lineaModificada = l.get_linea().replace((CharSequence) l, nuevo);
                                            
                                        }
                                        
                                    }
                                    
                                }
                                
                            }
                        }
                    }
                    pw.println(lineaModificada);
                    
                    Linea lineamodificada = new Linea(lineaModificada, lineaModificada.length());
                    Modificar_archivo_HTML.add(lineamodificada);
                } else {
                    pw.println(l.get_linea());
                    Modificar_archivo_HTML.add(l);
                }
                
            }
            
            System.out.println("impreso");
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            
            try {
                // Nuevamente aprovechamos el finally para 
                // asegurarnos que se cierra el fichero.
                if (null != html) {
                    html.close();
                }
            } catch (Exception e2) {
                System.out.println("no se pudo abrir");
                e2.printStackTrace();
            }
        }
        
        return Modificar_archivo_HTML;
    }
*/
    List<Error> publicidades(List<Linea> archivo_html
    ) {
        List<Error> errores_encontrados = new ArrayList<Error>();
        
        return errores_encontrados;
    }
    
    List<Error> comentarios(List<Linea> archivo_html
    ) {
        List<Error> errores_encontrados = new ArrayList<Error>();
        
        return errores_encontrados;
    }
    
    List<Error> estructura_codigo(List<Linea> archivo_html
    ) {
        List<Error> errores_encontrados = new ArrayList<Error>();
        
        return errores_encontrados;
    }
    
    List<Error> imagenes(List<Linea> archivo_html
    ) {
        List<Error> errores_encontrados = new ArrayList<Error>();
        
        return errores_encontrados;
    }
    
    List<Error> validacion_formularios(List<Linea> archivo_html) { 
        
        List<Error> errores_encontrados = new ArrayList<Error>();
        
        FileWriter fw = null;
        PrintWriter pw = null;
        
        List<String> html = new ArrayList();
        
        List<String> formattedHTML;        
        
        List<String> outputFile = new ArrayList<>();
        
        String nuevaLinea;
        File f = new File("Correcciones.html");
        // Deteccion de error 
        try {
            fw = new FileWriter(f);
            pw = new PrintWriter(fw);
            
            for (Linea l : archivo_html) {
                html.add(l.get_linea());
            }
            formattedHTML = Analizador.htmlFormatter(html);
            for (int i = 0; i < formattedHTML.size(); i++) {
                String s = formattedHTML.get(i);
                System.out.println(s);
                nuevaLinea = Analizador.lineAnalysis(s, i, errores_encontrados);
                outputFile.add(nuevaLinea);
            }
            for (String s : outputFile) {
                pw.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            
            try {
                // Nuevamente aprovechamos el finally para 
                // asegurarnos que se cierra el fichero.
                if (null != html) {
                    fw.close();
                }
            } catch (Exception e2) {
                System.out.println("no se pudo abrir");
                e2.printStackTrace();
            }
        }
        
        return errores_encontrados;
    }
    
}

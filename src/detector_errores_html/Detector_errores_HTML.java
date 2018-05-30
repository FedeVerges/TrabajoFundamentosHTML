package detector_errores_html;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;

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

    List<Error> publicidades(List<Linea> archivo_html) {
        List<Error> errores_encontrados = new ArrayList<Error>();

        return errores_encontrados;
    }

    List<Error> comentarios(List<Linea> archivo_html) {
        List<Error> errores_encontrados = new ArrayList<Error>();

        return errores_encontrados;
    }

    List<Error> estructura_codigo(List<Linea> archivo_html) {
        List<Error> errores_encontrados = new ArrayList<Error>();

        return errores_encontrados;
    }

    List<Error> imagenes(List<Linea> archivo_html) {
        List<Error> errores_encontrados = new ArrayList<Error>();

        return errores_encontrados;
    }

    List<Error> validacion_formularios(List<Linea> archivo_html) { // implementar 
        List<Error> errores_encontrados = new ArrayList<Error>();
        
        char[] caracteres;
        char[] bloqueA;
        char[] invalidos;

        // Deteccion de error 
        for (Linea l : archivo_html) {
            if (l.get_linea().contains("<input")) { // Convertimos a cadena de caracteres. Verficiar los atributos. 
                
                for(int i =0; i<caracteres.length;i++){
                    
                }
            }

        }

        return errores_encontrados;
    }

}

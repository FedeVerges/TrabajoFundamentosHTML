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

    List<Linea> ModificarHTML(List<Linea> archivo_HTML) {
        List<Linea> Modificar_archivo_HTML = new ArrayList();

        char[] linea;
        char[] bloqueB = null;
        String name;
        String[] nombres = {"Nombre", "Apellido", "DNI", "Cuil", "Correo_electronico", "Telefono", "Fecha_de_nacimiento", "Comentarios"};
        String lineaModificada = "-"; // linea del archivo html modificada. 
        String nuevo = "-"; // string auxiliar.

        FileWriter html = null;
        PrintWriter pw = null;
        String agregado;

        try {
            html = new FileWriter("c:/Escritorio/html.html");
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

                                                    nuevo = l.get_linea().replace(">", " "); // agregar el caso de imput en mas de una linea

                                                    nuevo = nuevo.concat(agregado);

                                                    lineaModificada = l.get_linea().replace((CharSequence) l, nuevo);

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
                                                    agregado = "pattern=\"<[a-zA-Z0-9]*/>";
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
                    Linea lineamodificada = new Linea(lineaModificada, lineaModificada.length());
                    Modificar_archivo_HTML.add(lineamodificada);
                } else {
                    Modificar_archivo_HTML.add(l);
                }
            }
        } catch (Exception e) {
        }

        return Modificar_archivo_HTML;
    }
    
    public void escribirHTML(List<Linea> Archivo){
        
    }

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

    List<Error> validacion_formularios(List<Linea> archivo_html
    ) { // implementar 
        List<Error> errores_encontrados = new ArrayList<Error>();

        char[] caracteres;
        char[] bloqueA = null;
        char[] invalidos = {'"', '=', '¿', '¡', ' ', '\''};
        char[] validos = {};

        // Deteccion de error 
        for (Linea l : archivo_html) {
            if (l.get_linea().contains("<input")) { // Convertimos a cadena de caracteres. Verficiar los atributos. 
                caracteres = l.get_linea().toCharArray();
                for (int i = 0; i < caracteres.length; i++) {
                    if (caracteres[i] == '=') {
                        int j = i;
                        while (caracteres[j] != '"') { // recorro la linea hasta encontrar el primer igual
                            j++;
                        }
                        if (caracteres[j + 1] == '"') { // control de atributos vacios

                            Error vacio = new Error(archivo_html.indexOf(l), "NO PUEDEN EXISTIR ATRIBUTOS VACIOS");
                        }
                        while (caracteres[j + 1] != '"') { // recorro los caracteres que hay entre las comillas
                            int indice = 0; // indice para que lo llene desde la posicion 0
                            bloqueA[indice] = caracteres[j]; // Asingno ese bloque de caracteres a un nuevo bloque para ser analizado.
                            indice++;
                            j++;
                        }
                        // Analisis del bloqueA
                        for (i = 0; i < bloqueA.length; i++) {
                            for (j = 0; j < invalidos.length; j++) {
                                if (bloqueA[i] == invalidos[j]) {
                                    /* se ha detectado un error */
                                    Error e = new Error(archivo_html.indexOf(l), "Error en input, caracteres no validos");
                                    errores_encontrados.add(e);
                                }
                            }
                        }

                    }
                    // aca habria que controlar lo que va despues del igual y antes del igual. 

                }
            }

        }

        return errores_encontrados;
    }

}

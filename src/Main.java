import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> archivos = new ArrayList<>();

        archivos.add("informe.pdf");
        archivos.add("documento.docx");
        archivos.add("notas.txt");
        archivos.add("imagen.jpg");

        for (String archivo : archivos) {

            LectorDocumento lector = null;

            if (archivo.toLowerCase().endsWith(".pdf")) {
                lector = new LectorPDF();

            } else if (archivo.toLowerCase().endsWith(".docx")) {
                lector = new LectorWord();

            } else if (archivo.toLowerCase().endsWith(".txt")) {
                lector = new LectorTextoPlano();
            }

            if (lector != null) {
                lector.abrirArchivo(archivo);

                String texto = lector.extraerTexto();

                System.out.println("Contenido: " + texto);
                System.out.println("----------------------");

            } else {
                System.out.println(
                        "Formato no compatible: " + archivo
                );
            }
        }
    }
}
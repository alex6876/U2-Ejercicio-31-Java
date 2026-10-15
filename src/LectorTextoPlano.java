public class LectorTextoPlano implements LectorDocumento {

    private String rutaArchivo = "";
    private String texto = "";

    @Override
    public void abrirArchivo(String ruta) {
        if (!ruta.toLowerCase().endsWith(".txt")) {
            System.err.println("El archivo no es compatible con TXT");
            return;
        }

        rutaArchivo = ruta;
        texto = "Texto extraído del archivo de texto plano";
        System.out.println("TXT abierto: " + rutaArchivo);
    }

    @Override
    public String extraerTexto() {
        return texto;
    }
}
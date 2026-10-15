public class LectorWord implements LectorDocumento {

    private String rutaArchivo = "";
    private String texto = "";

    @Override
    public void abrirArchivo(String ruta) {
        if (!ruta.toLowerCase().endsWith(".docx")) {
            System.err.println("El archivo no es compatible con Word");
            return;
        }

        rutaArchivo = ruta;
        texto = "Texto extraído del archivo Word";
        System.out.println("Word abierto: " + rutaArchivo);
    }

    @Override
    public String extraerTexto() {
        return texto;
    }
}
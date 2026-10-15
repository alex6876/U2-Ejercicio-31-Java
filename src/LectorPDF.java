public class LectorPDF implements LectorDocumento {

    private String rutaArchivo = "";
    private String texto = "";

    @Override
    public void abrirArchivo(String ruta) {
        if (!ruta.toLowerCase().endsWith(".pdf")) {
            System.err.println("El archivo no es compatible con PDF");
            return;
        }

        rutaArchivo = ruta;
        texto = "Texto extraído del archivo PDF";
        System.out.println("PDF abierto: " + rutaArchivo);
    }

    @Override
    public String extraerTexto() {
        return texto;
    }
}
public interface LectorDocumento {

    public abstract void abrirArchivo(String ruta);

    public abstract String extraerTexto();
}

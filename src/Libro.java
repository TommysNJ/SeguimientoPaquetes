public class Libro {
    private static int contador = 1;
    private String id;
    private int paginas;
    private String nombre;

    public Libro(int paginas, String nombre) {
        this.id = generarId();
        this.paginas = paginas;
        this.nombre = nombre;
    }

    private String generarId(){
        String id = String.format("%03d",contador);
        contador++;
        return "LD" + id;
    }

    public String getId() {
        return id;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "LIBRO " + "\nId: " + id + "\nPáginas: " + paginas + "\nNombre: "+ nombre + "\n\n";
    }
}


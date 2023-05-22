import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Lista{
    List<Libro> libros = new ArrayList<>();

    public void addLibro(Libro libro){
        libros.add(libro);
    }

    public boolean removeId(String id){
        for (int i=0 ; i < libros.size() ; i++){
            if (libros.get(i).getId().equalsIgnoreCase(id)) {
                libros.remove(libros.get(i));
                return true;
            }
        }
        return false;
    }

    public boolean removeNombre(String nombre){
        for (int i=0 ; i < libros.size() ; i++){
            if (libros.get(i).getNombre().equalsIgnoreCase(nombre)) {
                libros.remove(libros.get(i));
                return true;
            }
        }
        return false;
    }

    public Libro searchByName(String nombre) {
        for (Libro libro : libros) {
            if (libro.getNombre().equalsIgnoreCase(nombre)) {
                return libro;
            }
        }
        return null;
    }

    public Libro searchById(String id){
        libros.sort(Comparator.comparing(Libro::getId));

        int inicio = 0;
        int tope = libros.size() - 1;
        while (inicio <= tope) {
            int medio = (inicio + tope) / 2;
            Libro lb = libros.get(medio);
            int comparison = lb.getId().compareTo(id);
            if (comparison == 0) {
                return lb;
            } else if (comparison < 0) {
                inicio = medio + 1;
            } else {
                tope = medio - 1;
            }
        }
        return null;
    }

    public int totalPaginas (int indice, int suma){
        if (indice<libros.size()){
            return totalPaginas(indice+1,suma+libros.get(indice).getPaginas());
        } else {
            return suma;
        }
    }

    @Override
    public String toString() {
        return "***Lista***" + libros;
    }
}

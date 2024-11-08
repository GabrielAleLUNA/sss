
public class Libro {
    private String titulo;
    private String autor;
    private boolean prestado;
    private int cantidadCopiasDisponibles;

    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.prestado = false;
        this.cantidadCopiasDisponibles = 1;
        
    }

    public void incrementarCopiasDisponibles() {
        cantidadCopiasDisponibles++;
    }

    public void decrementarCopiasDisponibles() {
        cantidadCopiasDisponibles--;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }
    
    public int getCantidadCopiasDisponibles() {
        return cantidadCopiasDisponibles;
    }

    public boolean estaPrestado() {
        return prestado;
    }


}

import java.time.LocalDate;
import Usuarios.Usuario;



public class Prestamo {
    private static int contadorPrestamos = 0;
    private int idPrestamo;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private boolean devuelto;
    private Libro libro;
    private Usuario usuario;    

    public Prestamo(Usuario usuario, Libro libro) {
        this.idPrestamo = contadorPrestamos++;
        this.fechaPrestamo = LocalDate.now();
        this.fechaDevolucion = null;
        this.libro = libro;
        this.usuario = usuario;
        this.devuelto = false;
    }
    
    public int getIdPrestamo() {
        return idPrestamo;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public String getEstadoPrestamo() {
        if(devuelto == true) {
            return "DEVUELTO";
        } else {
            return "PENDIENTE";
        }
    }

    public Libro getLibro() {
        return libro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void devolver() {
        this.devuelto = true;
        this.fechaDevolucion = LocalDate.now();
    }

    
    
}

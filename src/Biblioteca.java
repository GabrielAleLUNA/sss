
import java.util.ArrayList;
import java.util.List;

import Usuarios.Docente;
import Usuarios.Estudiante;
import Usuarios.Usuario;
import java.time.LocalDate;



public class Biblioteca {
    private String nombre;
    private List<Usuario> usuarios;
    private List<Libro> libros;
    private List<Prestamo> prestamos;

    public Biblioteca(String nombre) {
        this.nombre = nombre;
        usuarios = new ArrayList<>();
        libros = new ArrayList<>();
        prestamos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }   

    public Docente registrarDocente(String nombre, int dni, LocalDate fechaIngreso) {
        for (Usuario usuario : usuarios) {
            if (usuario.getDni() == dni) {
                throw new IllegalArgumentException("Usuario con el mismo DNI ya existe.");
            }
        }
        Docente docente = new Docente(nombre, dni, fechaIngreso);
        usuarios.add(docente);
        return docente;
    }

    public Estudiante registrarEstudiante(String nombre, int dni) {
        for (Usuario usuario : usuarios) {
            if (usuario.getDni() == dni) {
                System.out.println("Usuario con el mismo DNI ya existe.");
            }
        }
        Estudiante Estudiante = new Estudiante(nombre, dni);
        usuarios.add(Estudiante);
        return Estudiante;
    }

    public Libro donarLibro(String titulo, String autor) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equals(titulo) && libro.getAutor().equals(autor)) {
                libro.incrementarCopiasDisponibles();
                return libro;
            }
        }
        Libro nuevoLibro = new Libro(titulo, autor);
        libros.add(nuevoLibro);
        return nuevoLibro;  
    }

    public Prestamo registrarPrestamo(Usuario usuario, Libro libro) {
        if (usuario.getCantidadPrestamos() >= usuario.getLimitePrestamos()) {
            System.out.println("El usuario ha alcanzado el límite de préstamos.");   
            return null;
        }
        if (libro.getCantidadCopiasDisponibles() <= 0) {
            System.out.println("No hay copias disponibles del libro.");   
            return null;
        }
        libro.decrementarCopiasDisponibles();
        usuario.incrementarCantidadPrestamos();
        usuario.incrementarCantidadPrestamosTotales();
        Prestamo nuevoPrestamo = new Prestamo(usuario, libro);  
        prestamos.add(nuevoPrestamo);
        System.out.println("Préstamo registrado exitosamente: " + usuario.getNombre() + " Libro prestado:  " + libro.getTitulo());
        return nuevoPrestamo;
    }

    public void devolverPrestamo(Prestamo prestamo) {
        prestamo.getLibro().incrementarCopiasDisponibles();
        prestamo.getUsuario().decrementarCantidadPrestamos();
        prestamo.devolver();
        System.out.println("Préstamo devuelto exitosamente: " + prestamo.getUsuario().getNombre() + " Libro devuelto: " + prestamo.getLibro().getTitulo()); 
    }

    public void mostrarPrestamos() {
        for (Prestamo prestamo : prestamos) {
            System.out.println("Prestamo: " + prestamo.getIdPrestamo());
            System.out.println( "Usuario: " + prestamo.getUsuario().getNombre()); 
            System.out.println( "libro: " + prestamo.getLibro().getTitulo() +" - " + prestamo.getLibro().getAutor());
            System.out.println( "Estado: " + prestamo.getEstadoPrestamo());
            System.out.println( "Fecha de Solicitud: " + prestamo.getFechaPrestamo());
            System.out.println( "Fecha de Devolucion: " + prestamo.getFechaDevolucion());              
            }       
    }

    public void mostrarPrestamosActivos() {
        for (Prestamo prestamo : prestamos) {
            if(prestamo.getEstadoPrestamo().equals("PENDIENTE")) {
                System.out.println("Prestamo: " + prestamo.getIdPrestamo());
                System.out.println( "Usuario: " + prestamo.getUsuario().getNombre()); 
                System.out.println( "libro: " + prestamo.getLibro().getTitulo() +" - " + prestamo.getLibro().getAutor());
                System.out.println( "Estado: " + prestamo.getEstadoPrestamo());
                System.out.println( "Fecha de Solicitud: " + prestamo.getFechaPrestamo());
                System.out.println( "Fecha de Devolucion: " + prestamo.getFechaDevolucion());              
            }       
        }           
    }

    public void mostrarUsuariosConPrestamos(int i) {
        for (Prestamo prestamo: prestamos) {
            if(prestamo.getUsuario().getCantidadPrestamosTotales() >= i) { 
                System.out.println("Usuario: " + prestamo.getUsuario().getNombre() + 
                " DNI: " + prestamo.getUsuario().getDni() + " IdPrestamo: " + prestamo.getIdPrestamo());
            }
        }
    
    }



   
    
  
}






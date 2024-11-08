package Usuarios;

public abstract class Usuario {  
    private String nombre;
    private int DNI;
    private int cantidadPrestamos;
    private int cantidadPrestamosTotales;
    

    public Usuario(String nombre, int DNI) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.cantidadPrestamos = 0;
        this.cantidadPrestamosTotales = 0;
        
    }
     
    public abstract int getLimitePrestamos();


    
    public void incrementarCantidadPrestamos() {
        this.cantidadPrestamos++;
    }

    public void decrementarCantidadPrestamos() {
        this.cantidadPrestamos--;
    }

    public void incrementarCantidadPrestamosTotales() {
        this.cantidadPrestamosTotales++;
    }

    public int getDni() {
        return DNI;    
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidadPrestamos() {
        return cantidadPrestamos;
    }

    public int getCantidadPrestamosTotales() {
        return cantidadPrestamosTotales;
    }



    

    
    @Override
    public String toString() {
        return "Usuario{" + "nombre= " + nombre + ", DNI=" + DNI + '}';
    }

    



    
}

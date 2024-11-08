package Usuarios;
public class Estudiante extends Usuario {
    private int limitePrestamos;   
    
    public Estudiante(String nombre, int DNI) {
        super(nombre, DNI);
        this.limitePrestamos = 2;
    }

    @Override
    public int getLimitePrestamos() {
        return limitePrestamos;
    }
}

    

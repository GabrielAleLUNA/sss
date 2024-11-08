package Usuarios;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Docente extends Usuario {
    private LocalDate fechaIngreso;
    private int limitePrestamos;    
        
    public Docente(String nombre, int DNI, LocalDate fechaIngreso) {
        super(nombre, DNI);
        this.fechaIngreso = fechaIngreso;
        this.limitePrestamos = calcularAntiguedad();
    }

    private int calcularAntiguedad() {
        int antiguedad = (int) ChronoUnit.YEARS.between(fechaIngreso, LocalDate.now());
        return antiguedad; 
        
    }
    
    @Override
    public int getLimitePrestamos() {
        return limitePrestamos;
    }

           
            
}

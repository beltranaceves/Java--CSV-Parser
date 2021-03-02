package ejercicio1;

import java.util.List;
import java.util.ArrayList;

public class CSV {
    List<Field> lista;
    CSV_Estado_Interfaz estado;
    public int indice;
    
    CSV() {
        lista = new ArrayList<>();
        estado = Estado_Inicial.getInstancia();
        indice = 0;
    }
    
    public void Mostrar() {
        for (int i = 0; i < lista.size(); i++) {
            lista.get(i).printField();
        }
    }
    
    public void aumentarIndice() {
        indice++;
    }
    
    public List<Field> Interpretar(String input) {
        estado.avanzar(input, indice, lista, this);
        return this.lista;
    }
    
    public void setEstado(CSV_Estado_Interfaz estado) {
        this.estado = estado;
    }
}

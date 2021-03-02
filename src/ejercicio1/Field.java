/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

import java.util.Objects;

/**
 *
 * @author Beltran
 * @param <T>
 */
public abstract class Field<T> {
    final T contenido;
    
    Field(T contenido) {
        this.contenido  = contenido;
    }
    
    public void printField() {
        System.out.println(contenido);
    }
    
    
        
//    T getContenido() {
//        return this.contenido;
//    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Field<?> other = (Field<?>) obj;
        if (!Objects.equals(this.contenido, other.contenido)) {
            return false;
        }
        return true;
    }
    
}

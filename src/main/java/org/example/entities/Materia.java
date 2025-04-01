package org.example.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter @Setter

public class Materia {
    private String nombre;
    private Set<Materia> correlativas;

    public Materia(String nombre, Set<Materia> materias) {
        this.nombre = nombre;
        this.correlativas = materias;
    }

    public Boolean verificarCorrelativas(Alumno alumno) {
        if (correlativas.isEmpty())
            return true;
        return correlativas.stream().allMatch(alumno::estaAprobada);
    }
}

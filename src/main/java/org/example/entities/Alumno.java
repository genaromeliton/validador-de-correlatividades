package org.example.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter

public class Alumno {
    private Set<Materia> materiasAprobadas;
    private String nombre;

    public Alumno(String nombre) {
        this.nombre = nombre;
        this.materiasAprobadas = Set.of();
    }

    public Boolean estaAprobada(Materia materia) {
        return materiasAprobadas.contains(materia);
    }
}

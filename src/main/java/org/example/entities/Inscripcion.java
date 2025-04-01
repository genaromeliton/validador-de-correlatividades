package org.example.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter

public class Inscripcion {
    private Set<Materia> materias;
    private Alumno alumno;

    public Inscripcion(Set<Materia> materias, Alumno alumno) {
        this.materias = materias;
        this.alumno = alumno;
    }

    public Boolean estaAprobada() {
        return materias.stream().allMatch(materia -> materia.verificarCorrelativas(alumno));
    }
}

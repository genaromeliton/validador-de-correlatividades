package org.example.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class InscripcionTest {
    // Alumno
    Alumno alumno = new Alumno("Rodrigo");


    //Materias sin correlativas
    Materia am1 = new Materia("Analisis Matematico 1", Set.of());
    Materia aga = new Materia("Algebra y Geometria Analitica", Set.of());
    Materia sypn = new Materia("Sistemas y Procesos de Negocios", Set.of());
    Materia ayed = new Materia("Algoritmos y Estructuras de Datos", Set.of());

    //Materias con correlativas
    Materia am2 = new Materia("Analisis Matematica 2", Set.of(am1, aga));
    Materia asi = new Materia(("Analisis de Sistemas"), Set.of(sypn, ayed));

    @Test
    @DisplayName("Un alumno sin materias aprobadas puede inscribirse a una inscripción sin materias correlativas")
    public void AlumnoSinAprobadasSeInscribeInscripcionSinCorrelativas() {
        Inscripcion inscripcion = new Inscripcion(Set.of(am1, aga, sypn, ayed), alumno);
        Assertions.assertTrue(inscripcion.estaAprobada());
    }

    @Test
    @DisplayName("Un alumno sin materias aprobadas no puede inscribirse a una inscripción con materias correlativas")
    public void AlumnoSinAprobadasSeInscribeInscripcionConCorrelativas() {
        Inscripcion inscripcion = new Inscripcion(Set.of(am2,asi), alumno);
        Assertions.assertFalse(inscripcion.estaAprobada());
    }

    @Test
    @DisplayName("Un alumno con materias aprobadas puede inscribirse a una inscripción sin materias correlativas")
    public void AlumnoConAprobadasSeInscribeInscripcionSinCorrelativas() {
        alumno.setMateriasAprobadas(Set.of(aga, am1));
        Inscripcion inscripcion = new Inscripcion(Set.of(sypn, ayed), alumno);
    }

    @Test
    @DisplayName("Un alumno con materias aprobadas puede inscribirse a una inscripción con materias correlativas")
    public void AlumnoConAprobadasSeInscribeConCorrelativas() {
        alumno.setMateriasAprobadas(Set.of(am1, aga, ayed, sypn));
        Inscripcion inscripcion = new Inscripcion((Set.of(am2, asi)), alumno);
    }
}
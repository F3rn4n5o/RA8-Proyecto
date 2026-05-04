package proyecto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

 enum TipoGeneracion {
    ALEATORIO, SELECCIONADAS, MIXTO
};

public class Examen {
    private String id;
    private Date fechaCreacion;
    private TipoGeneracion tipoGeneracion;
    private List<Pregunta> preguntas;

    public Examen(String id, TipoGeneracion tipoGeneracion) {
        this.id = id;
        this.tipoGeneracion = tipoGeneracion;
        this.fechaCreacion = new Date();
        this.preguntas = new ArrayList<>();
    }

    public void agregarPregunta(Pregunta p) {
        preguntas.add(p);
    }

    public void quitarPregunta(Pregunta p) {
        preguntas.remove(p);
    }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }
    public int getNumeroPreguntas() {
        return preguntas.size();
    }

      public String getId() {
        return id;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public TipoGeneracion getTipoGeneracion() {
        return tipoGeneracion;
    }

    @Override
    public String toString() {
        return   "Examen{id='" + id 
                +"', tipo=" + tipoGeneracion
                + ", preguntas=" + preguntas.size()
                + ", fecha=" + fechaCreacion + "}";
    }
}
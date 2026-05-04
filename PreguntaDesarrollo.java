package proyecto;

import java.util.List;

public class PreguntaDesarrollo extends Pregunta {

   private String respuestaModelo;

    public PreguntaDesarrollo(String codigo, Profesor autor, String curso, String grupo,
                              String modulo, String ra, String tema, String enunciado,
                              List<String> palabrasClave) {
        super(codigo, autor, curso, grupo, modulo, ra, tema, enunciado, palabrasClave);
    }

    public void setRespuestaModelo(String texto) {
        this.respuestaModelo = texto;
    }

    public String obtenerRespuestaModelo() {
        return respuestaModelo;
    }

    @Override
    public String mostrar() {
        StringBuilder sb = new StringBuilder();
        sb.append("[DESARROLLO] ").append(getEnunciado()).append("\n");
        sb.append("   Respuesta: ________________________________________________\n");
        sb.append("              ________________________________________________\n");
        if (respuestaModelo != null && !respuestaModelo.isEmpty()) {
            sb.append("   [Modelo]: ").append(respuestaModelo).append("\n");
        }
        return sb.toString();
    }








}
package proyecto;

import java.util.ArrayList;
import java.util.List;

public class PreguntaTipoTest extends Pregunta {

    
    private List<String> respuestas;
    private int correcta = -1;
    protected static final int NUM_RESPUESTA = 4;

    public PreguntaTipoTest(String codigo, Profesor autor, String curso, String grupo,
                            String modulo, String ra, String tema, String enunciado,
                            List<String> palabrasClave) {
        super(codigo, autor, curso, grupo, modulo, ra, tema, enunciado, palabrasClave);
        respuestas = new ArrayList<>();
        // Inicializar las 4 opciones vacías desde el principio
        for (int i = 0; i < NUM_RESPUESTA; i++) {
            respuestas.add("");
        }
    }

    public void setRespuesta(int index, String texto) {
        if (index < 0 || index >= NUM_RESPUESTA) {
            throw new IllegalArgumentException("Índice inválido. Solo se permiten " + NUM_RESPUESTA + " respuestas ");
        }
        respuestas.set(index, texto);
    }

    public void setCorrecta(int index) {
        if (index < 0 || index >= NUM_RESPUESTA) {
            throw new IllegalArgumentException("Índice inválido. Solo se permiten " + NUM_RESPUESTA + " respuestas )");
        }
        this.correcta = index;
    }

    public boolean esCorrecta(int index) {
        if (index < 0 || index >= NUM_RESPUESTA) {
            throw new IllegalArgumentException("Índice inválido. Solo se permiten " + NUM_RESPUESTA + " respuestas ");
        }
        return index == correcta;
    }

    public List<String> getRespuestas() {
        return respuestas;
    }

    public int getCorrecta() {
        return correcta;
    }

    @Override
    public String mostrar() {
        StringBuilder sb = new StringBuilder();
        sb.append("[TEST] ").append(getEnunciado()).append("\n");
        char letra = 'A';
        for (int i = 0; i < respuestas.size(); i++) {
            sb.append("   ").append(letra++).append(") ").append(respuestas.get(i));
            if (i == correcta) sb.append(" (*)");
            sb.append("\n");
        }
        return sb.toString();
    }
}

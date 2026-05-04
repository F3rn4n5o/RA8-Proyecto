package proyecto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GestorExamenes {

   
    public Examen generarExamenAleatorio(FiltroConsulta filtros, List<Pregunta> banco, int numPreg) {
        List<Pregunta> bancoFiltrado = aplicarFiltros(banco, filtros);
        Collections.shuffle(bancoFiltrado);

        Examen examen = new Examen("EX-" + System.currentTimeMillis(), TipoGeneracion.ALEATORIO);
        for (int i = 0; i < Math.min(numPreg, bancoFiltrado.size()); i++) {
            examen.agregarPregunta(bancoFiltrado.get(i));
        }
        return examen;
    }

    public Examen generarExamenSeleccionado(List<Pregunta> preguntas) {
        Examen examen = new Examen("EX-" + System.currentTimeMillis(), TipoGeneracion.SELECCIONADAS);
        for (Pregunta p : preguntas) {
            examen.agregarPregunta(p);
        }
        return examen;
    }

    // se excluyen del banco antes de mezclar aleatoriamente
    public Examen generarExamenMixto(FiltroConsulta filtros, List<Pregunta> seleccionadas,
                                     List<Pregunta> banco, int numAleatorias) {
        Examen examen = new Examen("EX-" + System.currentTimeMillis(), TipoGeneracion.MIXTO);

        for (Pregunta p : seleccionadas) {
            examen.agregarPregunta(p);
        }

        // Filtrar y excluir las ya seleccionadas para evitar duplicados
        List<Pregunta> bancoFiltrado = aplicarFiltros(banco, filtros);
        bancoFiltrado.removeAll(seleccionadas);
        Collections.shuffle(bancoFiltrado);

        for (int i = 0; i < Math.min(numAleatorias, bancoFiltrado.size()); i++) {
            examen.agregarPregunta(bancoFiltrado.get(i));
        }

        return examen;
    }

    public String exportarAImprimible(Examen examen) {
        StringBuilder sb = new StringBuilder();
        sb.append("========================================\n");
        sb.append("EXAMEN ID: ").append(examen.getId()).append("\n");
        sb.append("Tipo: ").append(examen.getTipoGeneracion()).append("\n");
        sb.append("Fecha: ").append(examen.getFechaCreacion()).append("\n");
        sb.append("Número de preguntas: ").append(examen.getNumeroPreguntas()).append("\n");
        sb.append("========================================\n\n");

        int i = 1;
        for (Pregunta p : examen.getPreguntas()) {
            sb.append(i++).append(". ").append(p.mostrar()).append("\n");
        }

        return sb.toString();
    }

    private List<Pregunta> aplicarFiltros(List<Pregunta> banco, FiltroConsulta filtros) {
        if (filtros == null) return new ArrayList<>(banco);

        List<Pregunta> resultado = new ArrayList<>();
        for (Pregunta p : banco) {
            if (filtros.getModulo() != null && !filtros.getModulo().isEmpty()
                    && !filtros.getModulo().equalsIgnoreCase(p.getModulo())) continue;
            if (filtros.getRa() != null && !filtros.getRa().isEmpty()
                    && !filtros.getRa().equalsIgnoreCase(p.getRa())) continue;
            if (filtros.getTema() != null && !filtros.getTema().isEmpty()
                    && !filtros.getTema().equalsIgnoreCase(p.getTema())) continue;
            if (filtros.getCurso() != null && !filtros.getCurso().isEmpty()
                    && !filtros.getCurso().equalsIgnoreCase(p.getCurso())) continue;
            // Filtro por tipo (test o desarrollo)
            if (filtros.getTipo() != null) {
                if (filtros.getTipo().equals("test") && !(p instanceof PreguntaTipoTest)) continue;
                if (filtros.getTipo().equals("desarrollo") && !(p instanceof PreguntaDesarrollo)) continue;
            }
            resultado.add(p);
        }
        return resultado;
    }
}
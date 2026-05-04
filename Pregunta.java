package proyecto;

import java.util.Date;
import java.util.List;

public  class Pregunta {
     private String codigo;
     private Profesor autor;
     private String curso;
     private String grupo;
     private String modulo;
     private String ra;
     private String tema;
     private String enunciado;
     private Date fechaCreacion;
     private List<String> palabrasClave;
   
  public Pregunta( String codigo, Profesor autor, String curso, String grupo,
                   String modulo, String ra, String tema, String enunciado,
                   List<String> palabrasClave) {
    this.codigo = codigo;
    this.autor = autor;
    this.curso = curso;
    this.grupo = grupo;
    this.modulo = modulo;
    this.ra = ra;
    this.tema = tema;
    this.enunciado = enunciado;
    this.palabrasClave = palabrasClave;
    this.fechaCreacion = new Date();
}

    public void modificar(Pregunta datos) {
        if (datos == null) throw new IllegalArgumentException("Los datos no pueden ser nulos");
        if (datos.enunciado != null)    this.enunciado    = datos.enunciado;
        if (datos.autor != null)        this.autor        = datos.autor;
        if (datos.tema != null)         this.tema         = datos.tema;
        if (datos.modulo != null)       this.modulo       = datos.modulo;
        if (datos.ra != null)           this.ra           = datos.ra;
        if (datos.curso != null)        this.curso        = datos.curso;
        if (datos.grupo != null)        this.grupo        = datos.grupo;
        if (datos.palabrasClave != null) this.palabrasClave = datos.palabrasClave;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Profesor getAutor() {
        return autor;
    }

    public void setAutor(Profesor autor) {
        this.autor = autor;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public List<String> getPalabrasClave() {
        return palabrasClave;
    }

    public void setPalabrasClave(List<String> palabrasClave) {
        this.palabrasClave = palabrasClave;
    }
    public String getCodigo() {
        return codigo;
    }
    public String mostrar() {
        return "codigo: " + codigo + ", enunciado: " + enunciado;
    }



   
}

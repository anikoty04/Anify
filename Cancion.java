public class Cancion {
    private String titulo;
    private String artista;
    private float duracion;
    private int reproducciones;
    private boolean contenidoExplicito;

    public Cancion (String titulo, String artista, int duracion, int reproducciones, boolean contenidoExplicito) {
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException ("Se necesita un título para la canción");
        }
        if (artista == null || artista.isBlank()) {
            throw new IllegalArgumentException ("Debe haber un artista asignado");
        }
        if (duracion < 0) {
            throw new IllegalArgumentException("La duración no puede ser negativa");
        }
        if (reproducciones < 0) {
            throw new IllegalArgumentException("Las reproducciones no pueden ser negativas");
        }
    }
}
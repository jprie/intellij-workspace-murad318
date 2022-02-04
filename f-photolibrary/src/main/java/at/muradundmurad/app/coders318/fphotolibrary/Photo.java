package at.muradundmurad.app.coders318.fphotolibrary;

import java.time.LocalDate;

public record Photo(String title, Photographer photographer, LocalDate date, String pathToFile,
                    String comment, byte[] imageBytes) {
}

package at.muradundmurad.app.coders318.fphotolibrary;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;

public class PhotoController {

    private static final Logger logger = LoggerFactory.getLogger(PhotoController.class);
    @FXML
    private TextField titleTextField;
    @FXML
    private TextField pathToFileTextField;
    @FXML
    private DatePicker datePicker;
    @FXML
    private TextArea commentTextArea;
    @FXML
    private ChoiceBox<Photographer> photographerChoiceBox;
    @FXML
    private ImageView imageView;
    @FXML
    private TableView<Photo> photoTableView;
    @FXML
    private TableColumn<Photo, String> titleColumn;
    @FXML
    private TableColumn<Photo, String> photographerColumn;
    @FXML
    private TableColumn<Photo, LocalDate> dateColumn;
    @FXML
    private TableColumn<Photo, Integer> sizeColumn;

    private final ObjectProperty<Photo> selectedPhoto = new SimpleObjectProperty<>();


    @FXML
    private void onAddButtonClick(ActionEvent actionEvent) {

        String title = titleTextField.getText();
        String pathToFile = pathToFileTextField.getText();
        LocalDate date = datePicker.getValue();
        Photographer photographer = photographerChoiceBox.getValue();
        String comment = commentTextArea.getText();

        if (!isValidInput(title, pathToFile, date, photographer, comment)) {
            logger.error("Photo not added");
            System.out.println("photo not added");
            return;
        }

        // Lese bytes aus gewählter Foto-Datei ein
        Path path = Path.of(pathToFile);
        try {
            InputStream inputStream = Files.newInputStream(path);
            byte[] imageBytes = inputStream.readAllBytes();
            Photo photo = new Photo(title, photographer, date, pathToFile, comment, imageBytes);
            PhotoLibrary.photos.add(photo);
            System.out.println("Added photo: " + photo);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private boolean isValidInput(String title, String pathToFile, LocalDate date, Photographer photographer, String comment) {

        if (!title.isBlank() && !pathToFile.isBlank() && date != null && photographer != null) {
            return true;
        }
        logger.debug("Validation: {}, {}, {}, {}, {}", title, date, photographer, pathToFile, comment);
        return false;
    }

    @FXML
    private void onClearButtonClick(ActionEvent actionEvent) {
        titleTextField.setText("");
        pathToFileTextField.setText("");
        datePicker.setValue(null);
        commentTextArea.setText("");
        photographerChoiceBox.setValue(null);
        imageView.setImage(null);
        logger.info("Cleared form");
    }

    @FXML
    private void onFileChooserButtonClick(ActionEvent actionEvent) {

        FileChooser fileChooser = new FileChooser();
        // Öffnet einen Öffnen-Dialog
        File file = fileChooser.showOpenDialog(getCurrentStage());

        // Bild-Datei im ImageView anzeigen
        try {
            imageView.setImage(new Image(new FileInputStream(file)));
            pathToFileTextField.setText(file.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("File " + file.getAbsolutePath() + " not found");
        }
    }

    // Liefert die Stage an die Sie den Dialog anhängen wollen
    private Stage getCurrentStage() {

        return (Stage) titleTextField.getScene().getWindow();
    }


    @FXML
    private void initialize() {

        Path pathToImages = Path.of("f-photolibrary/src/main/resources/at/muradundmurad/app/coders318/fphotolibrary/images");
        try {
            imageView.setImage(new Image(Files.newInputStream(pathToImages.resolve("IMG_4404.jpg"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        photographerChoiceBox.setItems(PhotoLibrary.photographers);

        initTable();

    }

    private void initTable() {
        // Tabelle
        photoTableView.setItems(PhotoLibrary.photos);
        titleColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Photo, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Photo, String> photoStringCellDataFeatures) {
                return new SimpleStringProperty(photoStringCellDataFeatures.getValue().title());
            }
        });

        photographerColumn.setCellValueFactory((dataFeatures) -> createPhotographerName(dataFeatures.getValue().photographer()));

        dateColumn.setCellValueFactory((dataFeatures) -> new SimpleObjectProperty<>(dataFeatures.getValue().date()));

        sizeColumn.setCellValueFactory((dataFeatures) -> new SimpleObjectProperty<Integer>(dataFeatures.getValue().imageBytes().length));

        photoTableView.getSelectionModel().selectedItemProperty().addListener((o, ov, nv) -> selectedPhoto.set(nv));

        selectedPhoto.addListener((o, ov, nv) -> fillForm(nv));
    }

    private void fillForm(Photo photo) {

        titleTextField.setText(photo.title());
        photographerChoiceBox.setValue(photo.photographer());
        datePicker.setValue(photo.date());
        pathToFileTextField.setText(photo.pathToFile());
        commentTextArea.setText(photo.comment());
        imageView.setImage(new Image(new ByteArrayInputStream(photo.imageBytes())));
    }

    private ObservableValue<String> createPhotographerName(Photographer photographer) {
        return photographer == null ? new SimpleObjectProperty<>() : new SimpleObjectProperty<>(photographer.getFirstName() + " " + photographer.getLastName());
    }


}
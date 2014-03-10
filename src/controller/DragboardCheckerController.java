package controller;

import checker.UrlContextChecker;
import checker.StringContextChecker;
import checker.ContextChecker;
import checker.FileContextChecker;
import checker.HtmlContextChecker;
import checker.ImageContextChecker;
import checker.RtfContextChecker;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;

/**
 * Controller for FXML
 * 
 * @author tomo
 */
public class DragboardCheckerController implements Initializable {
    @FXML
    private ImageView dropHereImage;
    @FXML
    private ListView<DataFormatInfo> dataFormatListView;
    @FXML
    private CheckBox stringCheck;
    @FXML
    private TextArea stringText;
    @FXML
    private CheckBox urlCheck;
    @FXML 
    private TextArea urlText;
    @FXML
    private CheckBox filesCheck;
    @FXML
    private TextArea filesText;
    @FXML
    private CheckBox rtfCheck;
    @FXML
    private TextArea rtfText;    
    @FXML
    private CheckBox imageCheck;
    @FXML
    private ImageView imageView;
    @FXML
    private CheckBox htmlCheck;
    @FXML
    private TextArea htmlText;
    
    private List<ContextChecker> contextCheckers;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initContextCheckers();
        this.dataFormatListView.setCellFactory(p -> new DataFormatCell());
        this.dropHereImage.setOnDragOver(e -> {
            e.acceptTransferModes(TransferMode.ANY);
            e.consume();
        });
        this.dropHereImage.setOnDragDropped(e -> {
            Dragboard db = e.getDragboard();
            this.contextCheckers.forEach(checker -> checker.check(db));
            setDataFormatListView(db);
            e.setDropCompleted(true);
        });
    }    

    private void initContextCheckers() {
        this.contextCheckers = Arrays.asList(
            new StringContextChecker(this.stringCheck, this.stringText)
          , new UrlContextChecker(this.urlCheck, this.urlText)
          , new FileContextChecker(this.filesCheck, this.filesText)
          , new RtfContextChecker(this.rtfCheck, this.rtfText)
          , new ImageContextChecker(this.imageCheck, this.imageView)
          , new HtmlContextChecker(this.htmlCheck, this.htmlText)
        );
    }

    private void setDataFormatListView(Dragboard db) {
        List<DataFormatInfo> list = db.getContentTypes().stream().map(df -> {
            return new DataFormatInfo(df, db.getContent(df).toString());
        }).collect(Collectors.toList());
        this.dataFormatListView.setItems(FXCollections.observableArrayList(list));
    }
}

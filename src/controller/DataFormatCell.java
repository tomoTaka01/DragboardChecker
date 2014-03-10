package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

/**
 * ListCell for DataFormat 
 * 
 * @author tomo
 */
public class DataFormatCell extends ListCell<DataFormatInfo>{
    GridPane root;
    Label dataFormatLabel;
    Text dataFormatText;
    Label contentLabel;
    Text contentText;
    Label idsLabel;
    ListView idsListView;
    ObservableList<String> idsList;
    
    public DataFormatCell() {
        init();
    }
    @Override
    protected void updateItem(DataFormatInfo info, boolean empty) {
        super.updateItem(info, empty);
        if (empty) {
            setText(null);
            setGraphic(null);
        } else {
            this.dataFormatText.setText(info.getDataFormat());
            this.contentText.setText(info.getContent());
            this.idsList.setAll(info.getIdentifiersList());
            setGraphic(root);
        }
    }
    private void init() {
        this.root = new GridPane();
        this.root.setPadding(new Insets(2));
        this.root.setHgap(2);
        this.root.setVgap(2);
        this.dataFormatLabel = new Label("Data Format:");
        this.dataFormatLabel.setPrefWidth(100);
        this.dataFormatText = new Text();
        this.dataFormatText.prefWidth(400);
        this.contentLabel = new Label("Content:");
        this.contentText = new Text();
        this.idsLabel = new Label("Identifires");        
        this.idsList = FXCollections.observableArrayList();
        this.idsListView = new ListView(this.idsList);
        this.idsListView.setPrefHeight(70);
        this.idsListView.setPrefWidth(500);        
        this.root.add(this.dataFormatLabel, 0, 0);
        this.root.add(this.dataFormatText, 1, 0);
        this.root.add(this.contentLabel, 0, 1);
        this.root.add(this.contentText, 1, 1);
        this.root.add(this.idsLabel, 0, 2);
        this.root.add(this.idsListView, 0, 3, 2, 1);
    }
}

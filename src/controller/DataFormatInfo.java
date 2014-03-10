package controller;

import java.util.List;
import java.util.stream.Collectors;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.input.DataFormat;

/**
 * Data for DataFormat 
 * 
 * @author tomo
 */
public class DataFormatInfo {
    private StringProperty dataFormatProp;
    private StringProperty contentProp;
    private List<String> identifiersList;    

    public DataFormatInfo(DataFormat dataFormat, String content) {
        this.dataFormatProp = new SimpleStringProperty(dataFormat.toString());
        this.contentProp = new SimpleStringProperty(content);
        this.identifiersList = 
            dataFormat.getIdentifiers().stream().collect(Collectors.toList());
    }
    public String getDataFormat(){
        return this.dataFormatProp.getValue();
    }
    public String getContent() {
        return this.contentProp.getValue();
    }
    public List<String> getIdentifiersList() {
        return this.identifiersList;
    }
}

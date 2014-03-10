package checker;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.input.Dragboard;

/**
 * Dragboard contents checker base
 * 
 * @author tomo
 * @param <T>
 */
public abstract class ContextChecker<T extends Node> {
    protected BooleanProperty checkboxProp;
    protected T node;
    
    public ContextChecker(CheckBox checkbox, T node) {
        this.checkboxProp = new SimpleBooleanProperty(false);
        checkbox.selectedProperty().bind(this.checkboxProp);
        this.node = node;
    }
    
    abstract public void check(Dragboard db);    
}

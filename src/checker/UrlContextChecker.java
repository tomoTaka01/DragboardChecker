package checker;

import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.input.Dragboard;

/**
 * Dragboard contents checker for URL
 * 
 * @author tomo
 */
public class UrlContextChecker extends ContextChecker<TextArea> {

    public UrlContextChecker(CheckBox checkbox, TextArea node) {
        super(checkbox, node);
    }

    @Override
    public void check(Dragboard db) {
        if (db.hasUrl()) {
            super.checkboxProp.set(true);
            super.node.setText(db.getUrl());
        } else {
            super.checkboxProp.set(false);
            super.node.clear();
        }
    }
    
}

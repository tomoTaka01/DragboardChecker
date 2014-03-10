package checker;

import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.input.Dragboard;

/**
 * Dragboard contents checker for String
 * 
 * @author tomo
 */
public class StringContextChecker extends ContextChecker<TextArea>{

    public StringContextChecker(CheckBox checkbox, TextArea node) {
        super(checkbox, node);
    }

    @Override
    public void check(Dragboard db) {
        if (db.hasString()) {
            super.checkboxProp.set(true);
            super.node.setText(db.getString());
        } else {
            super.checkboxProp.set(false);
            super.node.clear();
        }
    }
    
}

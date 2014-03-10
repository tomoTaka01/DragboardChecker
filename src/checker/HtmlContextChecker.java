package checker;

import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.input.Dragboard;

/**
 * Dragboard contents checker for HTML
 * 
 * @author tomo
 */
public class HtmlContextChecker extends ContextChecker<TextArea> {

    public HtmlContextChecker(CheckBox checkbox, TextArea node) {
        super(checkbox, node);
    }

    @Override
        public void check(Dragboard db) {
        if (db.hasHtml()) {
            super.checkboxProp.set(true);
            super.node.setText(db.getHtml());
        } else {
            super.checkboxProp.set(false);
            super.node.clear();
        }
    }    
}

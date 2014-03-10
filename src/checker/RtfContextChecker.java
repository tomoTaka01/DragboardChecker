package checker;

import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.input.Dragboard;

/**
 * Dragboard contents checker for RTF
 * 
 * @author tomo
 */
public class RtfContextChecker extends ContextChecker<TextArea>{

    public RtfContextChecker(CheckBox checkbox, TextArea node) {
        super(checkbox, node);
    }

    @Override
    public void check(Dragboard db) {
        if (db.hasRtf()) {
            super.checkboxProp.set(true);
            super.node.setText(db.getRtf());
        } else {
            super.checkboxProp.set(false);
            super.node.clear();
        }
    }
    
}

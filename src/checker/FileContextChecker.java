package checker;

import java.util.stream.Collectors;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.input.Dragboard;

/**
 * Dragboard contents checker for Files
 * 
 * @author tomo
 */
public class FileContextChecker extends ContextChecker<TextArea>{

    public FileContextChecker(CheckBox checkbox, TextArea node) {
        super(checkbox, node);
    }

    @Override
    public void check(Dragboard db) {
        if (db.hasFiles()) {
            super.checkboxProp.set(true);            
            super.node.setText(
                db.getFiles().stream().map(Object::toString)
                    .collect(Collectors.joining(System.lineSeparator()))
            );
        } else {
            super.checkboxProp.set(false);
            super.node.clear();
        }
    }
    
}

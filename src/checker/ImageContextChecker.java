package checker;

import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.Dragboard;

/**
 * Dragboard contents checker for Image
 * 
 * @author tomo
 */
public class ImageContextChecker extends ContextChecker<ImageView>{

    public ImageContextChecker(CheckBox checkbox, ImageView node) {
        super(checkbox, node);
    }

    @Override
    public void check(Dragboard db) {
        if (db.hasImage()) {
            super.checkboxProp.set(true);
            super.node.setImage(db.getImage());
        } else {
            super.checkboxProp.set(false);
            super.node.setImage(new Image("resources/noImage.png"));
        }
    }
    
}

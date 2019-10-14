package seedu.address.ui.diary;

import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.parser.ParserDateUtil;
import seedu.address.model.diary.photo.Photo;
import seedu.address.ui.UiPart;
import seedu.address.ui.components.PersonCard;

/**
 *
 */
public class DiaryGalleryCard extends UiPart<AnchorPane> {

    private static final String FXML = "diary/DiaryGalleryCard.fxml";

    private final Photo photo;
    private final Index displayIndex;

    @FXML
    private Label photoIndexLabel;
    @FXML
    private Label photoDescriptionLabel;
    @FXML
    private Label photoDateLabel;
    @FXML
    private ImageView photoImageView;

    public DiaryGalleryCard(Photo photo, Index displayIndex) {
        super(FXML);
        this.photo = photo;
        this.displayIndex = displayIndex;
        initialiseGalleryCard();
    }

    void bindImageViewWidth(ReadOnlyDoubleProperty galleryWidth) {
        double aspectRatio = photo.getImage().getWidth() / photo.getImage().getHeight();
        photoImageView.fitWidthProperty().addListener(((observable, oldValue, newValue) -> {
            photoImageView.setFitHeight(newValue.doubleValue() / aspectRatio);
        }));
        photoImageView.fitWidthProperty().bind(galleryWidth);
    }

    private void initialiseGalleryCard() {
        photoIndexLabel.setText(displayIndex.getOneBased() + "");
        photoDescriptionLabel.setText(photo.getDescription());
        photoDateLabel.setText(ParserDateUtil.getDisplayTime(photo.getDateTaken()));
        photoImageView.setImage(photo.getImage());
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof PersonCard)) {
            return false;
        }

        // state check
        DiaryGalleryCard card = (DiaryGalleryCard) other;
        return photo.equals(card.photo)
                && displayIndex.equals(card.displayIndex);
    }
}
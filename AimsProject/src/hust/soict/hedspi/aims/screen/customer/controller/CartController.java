package hust.soict.hedspi.aims.screen.customer.controller;
import hust.soict.hedspi.aims.cart.Cart;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import hust.soict.hedspi.aims.media.Media;

public class CartController{
	private Cart cart;
	@FXML
    private TableView<Media> tblMedia;
    @FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private Label costLabel;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;
    
    public CartController(Cart cart) {
    	this.cart = cart;
    }

    @FXML
    void btnPlayPressed(ActionEvent event) {

    }

    @FXML
    void btnRemovePressed(ActionEvent event) {

    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {

    }
    @FXML
    public void initialize() {
    	colMediaId.setCellValueFactory(new PropertyValueFactory<>("id"));
    	 colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
         colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
         colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));
         if(cart.getItemsOrdered() != null) {
        	 tblMedia.setItems(cart.getItemsOrdered());
         }
    }
}

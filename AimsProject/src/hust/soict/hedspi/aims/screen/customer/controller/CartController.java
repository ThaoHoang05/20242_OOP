package hust.soict.hedspi.aims.screen.customer.controller;
import hust.soict.hedspi.aims.cart.Cart;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;

import java.io.IOException;

import javax.naming.LimitExceededException;
import javax.swing.JOptionPane;

public class CartController{
	private Cart cart;
	private Store store;
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
    
    @FXML
    private RadioButton radioBtnFilterId;
    
    @FXML
    private RadioButton radioBtnFilterTitle;
    
    @FXML
    private TextField tfFilter;

    public CartController(Cart cart, Store store) {
    	this.cart = cart;
    	this.store = store;
    }

    @FXML
    void btnPlayPressed(ActionEvent event) {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	if(media != null) {
    	if (media instanceof Playable) {
            if (((Playable)media).getLength() > 0) {
                JOptionPane.showMessageDialog(null, "Now playing: " + media.getTitle(), "Playing ", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "This DVD has no content!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    	}
    }

    @FXML
    void btnRemovePressed(ActionEvent event) throws LimitExceededException {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	if (media != null) {
            cart.removeMedia(media);
            tblMedia.setItems(cart.getItemsOrdered()); // Cập nhật lại danh sách hiển thị
        }

    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
    	try{
            final String VIEW_STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
            FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource(VIEW_STORE_FXML_FILE_PATH));
            fxmlloader.setController(new ViewStoreController(store, cart));
            Parent root = fxmlloader.load();
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Store");
            stage.show();
            
        }catch(IOException e){
            e.printStackTrace();
        }
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
         btnPlay.setVisible(false);
         btnRemove.setVisible(false);
         
         tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
        	 public void changed(ObservableValue<? extends Media> observable,Media oldValue, Media newValue) {
        		 updateButtonBar(newValue);
        	 }
        	 
         });
         tfFilter.textProperty().addListener(new ChangeListener<String>(){
        	 public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        		 showFilteredMedia(newValue);
        	 }
         });
         costLabel.setText(cart.totalCost()+"$");
         	
    }
    void updateButtonBar(Media media) {
    	if(media == null) {
    		btnPlay.setVisible(false);
    		btnRemove.setVisible(false);
    	}else {
    		btnRemove.setVisible(true);
    		if(media instanceof Playable) {
    			btnPlay.setVisible(true);
    		}else {
    			btnPlay.setVisible(false);
    		}
    	}
    }
    void showFilteredMedia(String value) {
    	if (value == null || value.trim().isEmpty()) {
            if (cart.getItemsOrdered() != null) {
                tblMedia.setItems(cart.getItemsOrdered());
            }
            return; // Thoát khỏi hàm
        }
        
        // Xử lý khi có giá trị filter
        RadioButton selectButton = (RadioButton) filterCategory.getSelectedToggle();
        
        // Kiểm tra null safety cho selectButton
        if (selectButton == null) {
            return;
        }
        try {
            if (selectButton.getText().equals("By ID")) {
                int id = Integer.parseInt(value.trim());
                System.out.println(id);
                tblMedia.setItems(cart.filter(media -> media.getId() == id));
            } else if (selectButton.getText().equals("By Title")) {
                // Sử dụng contains() thay vì equals() để tìm kiếm linh hoạt hơn
                String searchValue = value.trim().toLowerCase();
                tblMedia.setItems(cart.filter(media -> 
                    media.getTitle() != null && 
                    media.getTitle().toLowerCase().contains(searchValue)
                ));
            }
        } catch (NumberFormatException e) {
            // Nếu parse ID thất bại, hiển thị danh sách rỗng
            if (selectButton.getText().equals("By Id")) {
                tblMedia.setItems(FXCollections.observableArrayList());
            }
        } catch (Exception e) {
            System.out.println("Error in filtering: " + e.getMessage());
            // Fallback: hiển thị tất cả items
            if (cart.getItemsOrdered() != null) {
                tblMedia.setItems(cart.getItemsOrdered());
            }
        }
        
    }
    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
    	JOptionPane.showMessageDialog(null,"Thanh toan thanh cong!", "Thong bao",JOptionPane.INFORMATION_MESSAGE);
    	
    }
}

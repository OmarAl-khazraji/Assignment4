package application;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.util.Scanner;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;



public class AirlineController implements Initializable {
	
		@FXML
	    private RadioButton RidoAirline;

	    @FXML
	    private ToggleGroup Airport;

	    @FXML
	    private RadioButton RadioAirlineNumber;

	    @FXML
	    private RadioButton RadioDeparture;

	    @FXML
	    private RadioButton RadioArrival;

	    @FXML
	    private ChoiceBox<String> ChoiceAirline;
	    

	    @FXML
	    private ChoiceBox<String> ChoiceAirlineNumber;
	  

	    @FXML
	    private ChoiceBox<String> ChoiceDeparture;

	    @FXML
	    private ChoiceBox<String> ChoiceArrival;
	  
	    
	    @FXML
	    private ListView<String> listVew;
	    Path f = Paths.get("C:\\Users\\omarh\\eclipse-workspace\\Assignment4\\Filght.txt");
	    ObservableList<Flight> data=FXCollections.observableArrayList(new Flight("a", "b", "c", "d"));
	    String [] array = new String [4];
	    BufferedReader br;
	    InputStream ist;
	    Flight f1;
	    String x;

	    @FXML
	    private Button search;

	    @FXML
	    private Button Close;
	    
	    @FXML
	    void OnChoiceAirline(MouseEvent event) {
	    	
	    	
	    	
	    	
	    	
	    	
	    }

	    @FXML
	    void OnChoiceArrival(MouseEvent event) {
	    	
	    	
	    }

	    @FXML
	    void onAirlineNumber(ActionEvent event) {
	    	if (RadioAirlineNumber.isSelected()== true) {
	    		ChoiceAirline.setDisable(true);
	    		ChoiceDeparture.setDisable(true);
	    		ChoiceAirlineNumber.setDisable(false);
	    		ChoiceArrival.setDisable(true);
	    		
			}
	    }
	   
	    @FXML
	    void onChoiceAirlineNumber(MouseEvent event) {
	    
	    	
	    }

	    @FXML
	    void onChoiceDeparture(MouseEvent event) {

	    }

	    @FXML
	    void onClose(ActionEvent event) {
	    	Platform.exit();

	    }
	    
	    @FXML
	    void onRadioArrival(ActionEvent event) {
	    	if (RadioArrival.isSelected()== true) {
	    		ChoiceAirline.setDisable(true);
	    		ChoiceDeparture.setDisable(true);
	    		ChoiceAirlineNumber.setDisable(true);
	    		ChoiceArrival.setDisable(false);
	    		
			}
	    }

	    @FXML
	    void onRadioDeparture(ActionEvent event) {
	    	if (RadioDeparture.isSelected()== true) {
	    		ChoiceAirline.setDisable(true);
	    		ChoiceDeparture.setDisable(false);
	    		ChoiceAirlineNumber.setDisable(true);
	    		ChoiceArrival.setDisable(true);
	    		
			}

	    }

	    @FXML
	    void onRidoAirline(ActionEvent event) {
	    	if (RidoAirline.isSelected()== true) {
	    		ChoiceAirline.setDisable(false);
	    		ChoiceDeparture.setDisable(true);
	    		ChoiceAirlineNumber.setDisable(true);
	    		ChoiceArrival.setDisable(true);
	    		
			}

	    }
	  
	    
	    @FXML
	    void onSearch(ActionEvent event) {
	    	try {
	    		ist = new BufferedInputStream(Files.newInputStream(f));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	br=new BufferedReader(new InputStreamReader(ist));
	    	String choice;
	    	//airline
	    	if (RidoAirline.isSelected()) {
				choice = ChoiceAirline.getSelectionModel().getSelectedItem();
				try {
					x = br.readLine();
					listVew.getItems().clear();
					while (x!=null) {
						array=x.split(",");
						if (choice.equals(array[0])) {
							f1= new Flight(array[0],array[1],array[2],array[3]);
							listVew.getItems().addAll(f1.ToString());
							
							
						}
						x=br.readLine();
					}
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	    	//Number
	    	else if (RadioAirlineNumber.isSelected()) {
				choice = ChoiceAirlineNumber.getSelectionModel().getSelectedItem();
				try {
					x = br.readLine();
					listVew.getItems().clear();
					while (x!=null) {
						array=x.split(",");
						if (choice.equals(array[1])) {
							f1= new Flight(array[0],array[1],array[2],array[3]);
							listVew.getItems().addAll(f1.ToString());
							//listVew.getItems().addAll(array[0]+array[1]+array[2]+array[3]);
							
						}
						x=br.readLine();
					}
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	    	//Departure
	    	else if (RadioDeparture.isSelected()) {
				choice = ChoiceDeparture.getSelectionModel().getSelectedItem();
				try {
					x = br.readLine();
					listVew.getItems().clear();
					while (x!=null) {
						array=x.split(",");
						if (choice.equals(array[2])) {
							f1= new Flight(array[0],array[1],array[2],array[3]);
							listVew.getItems().addAll(f1.ToString());
							//listVew.getItems().addAll(array[0]+array[1]+array[2]+array[3]);
							
						}
						x=br.readLine();
					}
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	    		
	    	//Arriavil
	    	else if (RadioArrival.isSelected()) {
				choice = ChoiceArrival.getSelectionModel().getSelectedItem();
				try {
					x = br.readLine();
					listVew.getItems().clear();
					while (x!=null) {
						array=x.split(",");
						if (choice.equals(array[3])) {
							f1= new Flight(array[0],array[1],array[2],array[3]);
							listVew.getItems().addAll(f1.ToString());
							//listVew.getItems().addAll(array[0]+array[1]+array[2]+array[3]);
							
						}
						x=br.readLine();
					}
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	    		
	    	
	    	
	    
	    
	    
	    
	  //private ObservableList<Filght> data = FXCollections.observableArrayList(new Filght("a","b","c","d"));
	    
	    private ObservableList<String> airline = FXCollections.observableArrayList("Air Canada","Air India");
	    private ObservableList<String> airnum = FXCollections.observableArrayList("AC102","AC104","AC107","AC113","AI011");
	    private ObservableList<String> deper = FXCollections.observableArrayList("YVR","YYR","YVR");
	    private ObservableList<String> arriv = FXCollections.observableArrayList("YYZ","YVZ","NRT");
	   
	    @Override
		public void initialize(URL arg0, ResourceBundle arg1) {
	    	
	    	//Airline type
	    	
	    	ChoiceAirline.getItems().addAll(airline);
		    ChoiceAirline.setValue("Select Airline");
		   
			
			//AirLine number
			ChoiceAirlineNumber.setValue("Select Airline Number");
			ChoiceAirlineNumber.getItems().addAll(airnum);
			
			//Departure Airport
			ChoiceDeparture.getItems().addAll(deper);
			ChoiceDeparture.setValue("Select Departure Airport");
			//Arrival
			ChoiceArrival.getItems().addAll(arriv);
			ChoiceArrival.setValue("Select Arrive Airport");
			//list view
			listVew.getItems().add("Airline \t\t "+"AirlineNo \t"+"Departure \t"+"Arrival");
			
		}
	    
	    @FXML
	    void OnlistVew(ActionEvent event) {

	    }
	  
	    
	   

}

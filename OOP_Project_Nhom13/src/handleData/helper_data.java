package handleData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import com.jfoenix.controls.JFXTextArea;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class helper_data {
   public static String read_data(String filename){
                String result = new String();
            // arr for saving the result
            try {
                BufferedReader reader = new BufferedReader(new FileReader(filename));
                StringBuilder jsonBuilder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    jsonBuilder.append(line);
                }
                reader.close();
                String jsonS = jsonBuilder.toString();
                result = jsonS;
                // Parse JSON array to an array of objects
                
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
           return result;
   }
   public static void updateUser(String currentActivity,String dataName,Label nameLabel,  ListView<String> connectListView,JFXTextArea infoText,Label idLabel,ArrayList<characterNKS> character, ArrayList<diTichTrenVietnam> ditichVN, ArrayList<festival> festivalsArr,ArrayList<dynasty> dynastiesArr,ArrayList<eventnks> eventArr){
      if (currentActivity == "characters") {
                characterNKS charac = new characterNKS();
                character = charac.display();
                for (characterNKS cha : character) {
                    if (cha.getName().equals(dataName)) {
                        nameLabel.setText(dataName);
                        idLabel.setText(cha.getId());
                        ObservableList<String> observableList = FXCollections.observableArrayList();
                        for (String connect : cha.getConnect()) {
                            observableList.add(connect);
                        }
                        connectListView.setItems(observableList);
                        // list detail
                        infoText.setText(cha.toString());
                        break;
                    }
                }
            } else if (currentActivity == "ditichvietnam") {
                int count = 10;
                diTichTrenVietnam charac = new diTichTrenVietnam();
                ditichVN = charac.display();
                for (diTichTrenVietnam cha : ditichVN) {
                    if (cha.getName().equals(dataName)) {
                        nameLabel.setText(dataName);
                        idLabel.setText(cha.getSrc());
                        ObservableList<String> observableList = FXCollections.observableArrayList();
                        count = count < ditichVN.size() ? count : ditichVN.size();
                        System.out.print(ditichVN.size());
                        for (int i = 1; i < count; i++) {
                            observableList.add(ditichVN.get(i).getName());
                        }
                        connectListView.setItems(observableList);
                        // list detail
                        infoText.setText(cha.toString());
                        break;
                    }
                }
            }else if (currentActivity == "festival"){
                int count = 10;
                festival charac = new festival();
                festivalsArr = charac.display();
                for (festival cha : festivalsArr) {
                    if (cha.getName().equals(dataName)) {
                        nameLabel.setText(dataName);
                        idLabel.setText(cha.getId());
                        ObservableList<String> observableList = FXCollections.observableArrayList();
                        count = count < festivalsArr.size() ? count : festivalsArr.size();
                        System.out.print(festivalsArr.size());
                        for (int i = 1; i < count; i++) {
                            observableList.add(festivalsArr.get(i).getName());
                        }
                        connectListView.setItems(observableList);
                        // list detail
                        infoText.setText(cha.toString());
                        break;
                    }
                }
            }else if(currentActivity=="dynasty"){
                    dynasty charac = new dynasty();
                dynastiesArr = charac.display();
                for (dynasty cha : dynastiesArr) {
                    if (cha.getName().equals(dataName)) {
                        nameLabel.setText(dataName);
                        idLabel.setText(cha.getName());
                        ObservableList<String> observableList = FXCollections.observableArrayList();
                        for (String connect : cha.getConnect()) {
                            observableList.add(connect);
                        }
                        connectListView.setItems(observableList);
                        // list detail
                        infoText.setText(cha.toString());
                        break;
                    }
                }
            }else{
                     eventnks charac = new eventnks();
                eventArr = charac.display();
                for (eventnks cha : eventArr) {
                    if (cha.getName().equals(dataName)) {
                        nameLabel.setText(dataName);
                        idLabel.setText(cha.getName());
                        ObservableList<String> observableList = FXCollections.observableArrayList();
                        for (String connect : cha.getConnect()) {
                            observableList.add(connect);
                        }
                        connectListView.setItems(observableList);
                        // list detail
                        infoText.setText(cha.toString());
                        break;
                    }
                }
            }
        }
}

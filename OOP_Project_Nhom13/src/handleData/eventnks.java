package handleData;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import controller.action;

public class eventnks implements action {
    private String name;
    private String id;
    private String info;
    private String[] connect;
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public String getId() {
        return id;
    }
    public String getInfo() {
        return info;
    }
    public String[] getConnect() {
        return connect;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setInfo(String info) {
        this.info = info;
    }
    public void setConnect(String[] connect) {
        this.connect = connect;
    }
    @Override
    public ArrayList<eventnks> search(String name_search) {
          Gson gson = new GsonBuilder().create();
            // arr for saving the result
            ArrayList<eventnks> arr = new ArrayList<>();
            try {
                String json = helper_data.read_data("E:\\code\\oop_Project\\src\\data\\Eventnks-1.json");
                // Parse JSON array to an array of objects
                eventnks[] objects = gson.fromJson(json, eventnks[].class);
                for(eventnks object : objects){
                    if(object.getName().contains(name_search) || object.getInfo().contains(name_search) || object.getId().contains(name_search)){
                        arr.add(object);
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return arr;
        }
    @Override
    public ArrayList<eventnks> binary_search(String purpose) {
       return search(purpose);
    }
    @Override
    public ArrayList<eventnks> display() {
       return search("");
    }
    @Override 
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Tên : ").append(name).append("\n")
               .append("Mô tả : ").append(info);
        return builder.toString();
    }
}

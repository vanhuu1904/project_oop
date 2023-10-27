package handleData;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import controller.action;

// crawl from http://ditichlichsu-vanhoahanoi.com/
// only in hanoi
public class ditichHaNoi implements action {
    private String name;
    private String district;
    private String info;
    private String imagine;
    private String category;
    private String id;
    public ditichHaNoi(String nam, String distric , String contents, String img, String classify, String srcStr){
        this.name = nam;
        this.district = distric;
        this.category = classify;
        this.imagine = img;
        this.info = contents;
        this.id=srcStr;
    }
    public String getSrc(){
        return this.id;
    }
    public String getCategory(){
          return this.category;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String nameDetail){
        this.name = nameDetail;
    }

    public String getDistrict(){
        return this.district;
    }
    public void setDistrict(String locationDetail){
        this.district = locationDetail;
    }
    public String getinfo(){
        return this.info ;
    }
    public void setinfo(String infoDetail){
       this.info = infoDetail;
    }
    public String getImagine(){
        return this.imagine;
    }
    public void setImagine(String urlImagine){
        this.imagine = urlImagine;
    }
    
    @Override
    public ArrayList<ditichHaNoi> search(String name_search) {
          Gson gson = new GsonBuilder().create();
            // arr for saving the result
            ArrayList<ditichHaNoi> arr = new ArrayList<>();
            try {
                String json = helper_data.read_data("E:\\code\\oop_Project\\src\\data\\ditichHaNoi.json");
                // Parse JSON array to an array of objects
                ditichHaNoi[] objects = gson.fromJson(json, ditichHaNoi[].class);
                for(ditichHaNoi object : objects){
                    if(object.getName().contains(name_search) || object.getCategory().contains(name_search) || object.getinfo().contains(name_search)){
                        arr.add(object);
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return arr;
    }
    @Override
    public ArrayList<?> binary_search(String purpose) {
       return search(purpose);
    }
    @Override
    public ArrayList<?> display() {
      return search("");
    }
}

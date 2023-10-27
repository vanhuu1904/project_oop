package handleData;

import controller.action;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;

    public class diTichTrenVietnam implements action {
        private String name;
        private String district;
        private String province;
        private String content;
        private String category;
        // year of certification
        private String yearEs;
        private String src; 

        public diTichTrenVietnam(String nam, String provi, String distric, String contents, String classify, String srcStr,
                String year) {
            this.name = nam;
            this.province = provi;
            this.district = distric;
            this.category = classify;
            this.content = contents;
            this.src = srcStr;
            this.yearEs = year;
        }
        public diTichTrenVietnam(){
            
        }

        public String getProvince() {
            return this.province;
        }

        public String getYear() {
            return this.yearEs;
        }

        public void setYear(String year) {
            this.yearEs = year;

        }

        public String getSrc() {
            return this.src;
        }

        public String getCategory() {
            return this.category;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String nameDetail) {
            this.name = nameDetail;
        }

        public String getDistrict() {
            return this.district;
        }

        public void setDistrict(String locationDetail) {
            this.district = locationDetail;
        }

        public String getContent() {
            return this.content;
        }

        public void setContent(String ContentDetail) {
            this.content = ContentDetail;
        }

        @Override
        public ArrayList<diTichTrenVietnam> search(String name_search) {
            Gson gson = new GsonBuilder().create();
            // arr for saving the result
            ArrayList<diTichTrenVietnam> arr = new ArrayList<>();
            
            try {
                String json = helper_data.read_data("E:\\code\\oop_Project\\src\\data\\dataDitichVietName.json");
                // Parse JSON array to an array of objects
                diTichTrenVietnam[] objects = gson.fromJson(json, diTichTrenVietnam[].class);
                for(diTichTrenVietnam object : objects){
                    if(object.getName().contains(name_search) || object.getCategory().contains(name_search)){
                        arr.add(object);
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return arr;
        }

        @Override
        public ArrayList<diTichTrenVietnam> binary_search(String purpose) {
            return search(purpose);
        }

        @Override
        public ArrayList<diTichTrenVietnam> display() {
           return search("");
        }
        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
        builder.append("Tỉnh: ").append(province).append("\n")
                .append("Quận: ").append(district).append("\n")
                .append("Phân Loại: ").append(category).append("\n")
                .append("Năm Công Nhận: ").append(yearEs).append("\n")
                .append("Mô Tả: ").append(content).append("\n");
              

        return builder.toString();
        }
        
    }

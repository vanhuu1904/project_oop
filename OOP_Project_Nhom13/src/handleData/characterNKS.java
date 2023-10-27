package handleData;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import controller.action;


public class characterNKS extends ParentObject implements action{
    private String thuy_Hieu;
    private String ke_Nhiem;
    private String tien_Nhiem;
    private String than_Mau;
    private String ten_Day_Du;
    private String Sinh;
    private String id;
    private String tai_Vi;
    private String hau_Due;
    private String than_Phu;
    private String [] connect;
    private String info;
    public void setTien_Nhiem(String tien_Nhiem) {
        this.tien_Nhiem = tien_Nhiem;
    }
    public void setMat(String mat) {
        this.mat = mat;
    }
    public void setThan_Mau(String than_Mau) {
        this.than_Mau = than_Mau;
    }
    public void setInfo(String info) {
        this.info = info;
    }
    private String mat;
    public String getTien_Nhiem() {
        return tien_Nhiem;
    }
    public String getMat() {
        return mat;
    }
    public String getThan_Mau() {
        return than_Mau;
    }
    public String getInfo() {
        return info;
    }
    public void setThuy_Hieu(String thuy_Hieu) {
        this.thuy_Hieu = thuy_Hieu;
    }
    public void setKe_Nhiem(String ke_Nhiem) {
        this.ke_Nhiem = ke_Nhiem;
    }
    public void setTen_Day_Du(String ten_Day_Du) {
        this.ten_Day_Du = ten_Day_Du;
    }
    public void setSinh(String Sinh) {
        this.Sinh = Sinh;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setTai_Vi(String tai_Vi) {
        this.tai_Vi = tai_Vi;
    }
    public void setHau_Due(String hau_Due) {
        this.hau_Due = hau_Due;
    }
    public void setThan_Phu(String than_Phu) {
        this.than_Phu = than_Phu;
    }
    public void setConnect(String[] connect) {
        this.connect = connect;
    }
    public String getThuy_Hieu() {
        return thuy_Hieu;
    }
    public String getKe_Nhiem() {
        return ke_Nhiem;
    }
    public String getTen_Day_Du() {
        return ten_Day_Du;
    }
    public String getSinh() {
        return Sinh;
    }
    public String getId() {
        return id;
    }
    public String getTai_Vi() {
        return tai_Vi;
    }
    public String getHau_Due() {
        return hau_Due;
    }
    public String getThan_Phu() {
        return than_Phu;
    }
    public String[] getConnect() {
        return connect;
    }
    @Override
    public ArrayList<characterNKS> search(String name_search) {
        name_search = name_search.toLowerCase();
        Gson gson = new GsonBuilder().create();
            // arr for saving the result
            ArrayList<characterNKS> arr = new ArrayList<>();
            try {
                // BufferedReader reader = new BufferedReader(new FileReader("E:\\code\\oop_Project\\src\\data\\characterNKS_2.json"));
                // StringBuilder jsonBuilder = new StringBuilder();
                // String line;
                // while ((line = reader.readLine()) != null) {
                //     jsonBuilder.append(line);
                // }
                // reader.close();
                // String json = jsonBuilder.toString();
                String json = helper_data.read_data("src\\data\\characterNKS_2.json");

                // Parse JSON array to an array of objects
                characterNKS[] objects = gson.fromJson(json, characterNKS[].class);
                for(characterNKS object : objects){
                    if(object.getName().toLowerCase().contains(name_search) ){
                        arr.add(object);
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return arr;
    }
    @Override
    public ArrayList<characterNKS> binary_search(String purpose) {
       return search(purpose);
    }
    @Override
    public ArrayList<characterNKS> display() {
       return search("");
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Thụy hiệu: ").append(thuy_Hieu).append("\n")
                .append("Kế nhiệm: ").append(ke_Nhiem).append("\n")
                .append("Tên đầy đủ: ").append(ten_Day_Du).append("\n")
                .append("Sinh: ").append(Sinh).append("\n")
                .append("Name: ").append(name).append("\n")
                .append("ID: ").append(id).append("\n")
                .append("Tại vị: ").append(tai_Vi).append("\n")
                .append("Hậu duệ: ").append(hau_Due).append("\n")
                .append("Thân phụ: ").append(than_Phu).append("\n")
                .append("Mô Tả: ").append(info);

        return builder.toString();
    }
}

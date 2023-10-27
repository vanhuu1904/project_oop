package handleData;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import controller.action;
import java.util.ArrayList;

public class festival implements action {
    private String name;
    private String start_date_lunar_calendar;
    private String location;
    private String held_for_first_time;
    private String related_character;
    private String detail;
    private String id;

    public String getId() {
        return id;
    }
    public festival(String name,String id, String start_date_lunar_calendar, String location, String held_for_first_time,
            String related_character, String detail) {
        this.name = name;
        this.start_date_lunar_calendar = start_date_lunar_calendar;
        this.location = location;
        this.held_for_first_time = held_for_first_time;
        this.related_character = related_character;
        this.detail = detail;
        this.id = id;
    }
    public festival(){}

    public String getName() {
        return this.name;
    }

    public String getStartDateLunarCalendar() {
        return this.start_date_lunar_calendar;
    }

    public String getLocation() {
        return this.location;
    }

    public String getHeldForFirstTime() {
        return this.held_for_first_time;
    }

    public String getRelatedCharacter() {
        return this.related_character;
    }

    public String getDetail() {
        return this.detail;
    }
@Override
    public ArrayList<festival> search(String keyword) {
        Gson gson = new GsonBuilder().create();
        ArrayList<festival> result = new ArrayList<>();

        try {
            String json = helper_data.read_data("E:\\code\\oop_Project\\src\\data\\festival.json");

            festival[] festivals = gson.fromJson(json, festival[].class);
            for (festival festival : festivals) {
                if (festival.getName().toLowerCase().contains(keyword.toLowerCase()) ||
                        festival.getStartDateLunarCalendar().toLowerCase().contains(keyword.toLowerCase()) ||
                        festival.getLocation().toLowerCase().contains(keyword.toLowerCase()) ||
                        festival.getHeldForFirstTime().toLowerCase().contains(keyword.toLowerCase()) ||
                        festival.getRelatedCharacter().toLowerCase().contains(keyword.toLowerCase()) ||
                        festival.getDetail().toLowerCase().contains(keyword.toLowerCase())) {
                    result.add(festival);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
    @Override
    public ArrayList<festival> binary_search(String purpose) {
       return search(purpose);
    }
    @Override
    public ArrayList<festival> display() {
       return search("");
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
    builder.append("Địa Điểm: ").append(location).append("\n")
            .append("Tổ Chức Lần Đầu Vào: ").append(held_for_first_time).append("\n")
            .append("Diễn Ra Hằng Năm Vào: ").append(start_date_lunar_calendar).append("\n")
            .append("Với Sự Tham Gia Của: ").append(related_character).append("\n")
            .append("Mô Tả: ").append(detail).append("\n");
          
    return builder.toString();
    }
}


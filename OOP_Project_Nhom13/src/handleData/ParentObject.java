package handleData;

// import java.util.ArrayList;

// import com.google.gson.Gson;
// import com.google.gson.GsonBuilder;

// import controller.action;
// import src.di_tich_lich_su.ditichHaNoi;
// import src.helper.helper_data;

public class ParentObject  {
    protected String name;
    protected static String dataSource;
    public String getName() {
        return name;
    }

    public static void setDataSource(String newDataSource) {
        dataSource = newDataSource;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getDataSource() {
        return dataSource;
    }
   
}

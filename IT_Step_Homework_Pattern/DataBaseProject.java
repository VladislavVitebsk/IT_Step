package IT_Step_Homework_PatternSingleton;

class DatabaseHelper{
    private String data;
    private static DatabaseHelper databaseConnection;
    private DatabaseHelper(){
        System.out.println("Подключение к БД");
    }
    public static DatabaseHelper getConnection(){
        if (databaseConnection == null)
            databaseConnection = new DatabaseHelper();
        return databaseConnection;
    }

    public String selectData(){
        return data;
    }
    public void insertData(String d){
        System.out.println("Новые данные: " + d + " внесены в БД");
        data = d;
    }
}
public class DataBaseProject {
    public static void main(String[] args) {
        //DatabaseHelper connection = new DatabaseHelper();
        DatabaseHelper.getConnection().insertData("123");
        System.out.println("Выборка данных из БД: " + DatabaseHelper.getConnection().selectData());
    }
}

package AppPackage;

public class Application {
    public static void main(String[] args) {
        DatabaseProvider databaseProvider = new DatabaseProvider();
        System.out.println(databaseProvider.GetDepartments());
    }
}

import java.sql.*;
import java.util.Scanner;

public class MainApp {

    private static final String URL = "jdbc:postgresql://localhost:5432/db_sql";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Введите Фамилию Имя или пустую строку для получения всех данных: ");

            while (true) {
                String fio = scanner.nextLine();
                if (fio.isEmpty()) {
                    break;
                }

                System.out.print("Введите возраст: ");
                int age = Integer.parseInt(scanner.nextLine());

                try (PreparedStatement pstmt = conn.prepareStatement("INSERT INTO user_data (FIO, age) VALUES (?, ?)")) {
                    pstmt.setString(1, fio);
                    pstmt.setInt(2, age);
                    pstmt.executeUpdate();
                }
            }

            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT FIO, age FROM user_data;")) {
                System.out.println("\nВсе введенные данные:");
                while (rs.next()) {
                    System.out.println("Фамилия Имя: " + rs.getString("FIO") + ", Возраст: " + rs.getInt("age"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

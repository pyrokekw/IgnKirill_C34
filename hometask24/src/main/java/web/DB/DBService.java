package web.DB;

import web.classes.Route;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBService {

    private static String URL = "jdbc:postgresql://localhost:5432/routes_db";
    private static String user = "postgres";
    private static String password = "postgres";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL,user,password);
    }

    public static void addRoute(Route route) throws SQLException {
        String sql = "INSERT INTO routes (name, description, length) VALUES (?, ?, ?)";
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, route.getName());
        statement.setString(2, route.getDescription());
        statement.setDouble(3, route.getLength());
        statement.execute();

        try (ResultSet rs = statement.getGeneratedKeys()) {
            if (rs.next()) {
                route.setId(rs.getInt(1));
            }
        }

    }

    public static List<Route> getAllRoutes() throws SQLException {
        List<Route> routes = new ArrayList<>();
        String sql = "Select * from routes order by votes desc";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Route route = new Route();
                route.setId(rs.getInt("id"));
                route.setName(rs.getString("name"));
                route.setDescription(rs.getString("description"));
                route.setLength(rs.getDouble("length"));
                route.setVotes(rs.getInt("votes"));
                routes.add(route);
            }
        }
        return routes;

    }

    public static boolean voteForRoute(int routeId, String employeeId) throws SQLException {
        String checkSql = "SELECT 1 FROM votes WHERE route_id = ? AND employee_id = ?";
        String insertSql = "INSERT INTO votes (route_id, employee_id) VALUES (?, ?)";
        String updateSql = "UPDATE routes SET votes = votes + 1 WHERE id = ?";

        try (Connection conn = getConnection()) {
            conn.setAutoCommit(false);

            // Проверка существования голоса
            try (PreparedStatement checkStmt = conn.prepareStatement(checkSql)) {
                checkStmt.setInt(1, routeId);
                checkStmt.setString(2, employeeId);
                if (checkStmt.executeQuery().next()) {
                    return false;
                }
            }

            // Добавление голоса
            try (PreparedStatement insertStmt = conn.prepareStatement(insertSql)) {
                insertStmt.setInt(1, routeId);
                insertStmt.setString(2, employeeId);
                insertStmt.executeUpdate();
            }

            // Обновление счетчика
            try (PreparedStatement updateStmt = conn.prepareStatement(updateSql)) {
                updateStmt.setInt(1, routeId);
                updateStmt.executeUpdate();
            }

            conn.commit();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }
}

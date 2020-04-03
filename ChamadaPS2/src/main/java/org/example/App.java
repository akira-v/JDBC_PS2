package org.example;
import java.sql.*;


public class App
{
    public static void main( String[] args ) {

        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

            String db = "xd";
            String url = "jdbc:mysql://dorime.dlinkddns.com:32775/" + db;
            String user = "root";
            String psw = "root";

            //como não consegui setar o localhost, estou usando o de um amigo.

            conn = DriverManager.getConnection(url, user, psw);

            String sql = "SELECT * FROM presenca";
            PreparedStatement pstn = conn.prepareStatement(sql);
            ResultSet rs = pstn.executeQuery();
            Statement statement = conn.createStatement();

            statement.executeUpdate("INSERT INTO presenca VALUES (1,000000, 0000, 00001)");

            while (rs.next()) {
                int tia = rs.getInt("tia");
                Time hr_entrada = rs.getTime("hr_entrada");
                Time hr_saida = rs.getTime("hr_saida");
                System.out.println("Tia: " + tia + "// Horário de entrada: " + hr_entrada +  "// Horário de saída :" + hr_saida);
            }

            rs.close();
            conn.close();


        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Falha na carga do Driver JDBC.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Falha de conexão com a base de dados.");
            e.printStackTrace();
        }
    }


}


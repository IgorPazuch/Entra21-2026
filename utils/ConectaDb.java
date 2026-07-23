package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConectaDb {

    private static final String URL = "jdbc:mysql://localhost:3306/bd_aula";

    private static final String USER = "root";

    private static final String PASSWORD = "@1@senac2021";

    public static Connection conectar() {

        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (Exception e) {

            System.out.println("Erro na conexão.");
            e.printStackTrace();

            return null;
        }

    }

}
package simple_dao.dao;

import simple_dao.entity.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientJDBCDao implements ClientDAO{

    @Override
    public void addClient (Client client){
        Connection connection = null;

        connection = getConnection();
        PreparedStatement statement = null;


        try {
            statement = connection.prepareStatement("INSERT INTO clients(name, age, phone) VALUES (?, ?, ?)");

            statement.setString(1, client.getName());
            statement.setInt(2, client.getAge());
            statement.setString(3, client.getPhone());

            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if(connection != null && statement != null){
                try {
                    connection.close();
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            }
        }
    }

    @Override
    public Client getById(int id){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        connection = getConnection();

        try {
            preparedStatement = connection.prepareStatement("SELECT cl.name, cl.age, cl.phone FROM clients as cl WHERE cl.id = ?");
            preparedStatement.setInt(1, id);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                String name = resultSet.getString("cl.name");
                int age = resultSet.getInt("cl.age");
                String phone = resultSet.getString("cl.phone");
                Client client = new Client();
                client.setName(name);
                client.setAge(age);
                client.setPhone(phone);
                return  client;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            if(connection != null && preparedStatement != null && resultSet != null){
                try {
                    connection.close();
                    preparedStatement.close();
                    resultSet.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
     public List<Client> getAllClients(){
        List<Client> allClients = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        connection = getConnection();

        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM clients");

            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                long id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String phone = resultSet.getString("phone");
                Client client = new Client();
                client.setId(id);
                client.setName(name);
                client.setAge(age);
                client.setPhone(phone);
                allClients.add(client);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            if(connection != null && preparedStatement != null && resultSet != null){
                try {
                    connection.close();
                    preparedStatement.close();
                    resultSet.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return allClients;
    }

    @Override
    public void updateAge (int age, int clientId){
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        connection = getConnection();

        try {
            preparedStatement = connection.prepareStatement("UPDATE clients SET age = ? WHERE id = ?");

            preparedStatement.setInt(1, age);
            preparedStatement.setInt(2, clientId);

            int updatedValues = preparedStatement.executeUpdate();

            System.out.println("Values updated: " + updatedValues);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            if(connection != null && preparedStatement != null){
                try {
                    connection.close();
                    preparedStatement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    @Override
    public void updatePhone (String phone, int clientId){
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        connection = getConnection();

        try {
            preparedStatement = connection.prepareStatement("UPDATE clients SET phone = ? WHERE id = ?");

            preparedStatement.setString(1, phone);
            preparedStatement.setInt(2, clientId);

            int updatedValues = preparedStatement.executeUpdate();

            System.out.println("Updated values: " + updatedValues);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            if(connection != null && preparedStatement != null){
                try {
                    connection.close();
                    preparedStatement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    @Override
    public void remove(String name){
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        connection = getConnection();

        try {
            preparedStatement = connection.prepareStatement("DELETE FROM clients WHERE name = ?");
            preparedStatement.setString(1, name);

            int deletedValues = preparedStatement.executeUpdate();

            System.out.println("Deleted values: " + deletedValues);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            if(connection != null && preparedStatement != null){
                try {
                    connection.close();
                    preparedStatement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }


    private Connection getConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/carshop", "root", "root");
            return connection;
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}

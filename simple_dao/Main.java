package simple_dao;

import simple_dao.dao.CarDAO;
import simple_dao.dao.ClientDAO;
import simple_dao.dao.DAOFactory;
import simple_dao.dao.IDAOFactory;
import simple_dao.entity.Car;
import simple_dao.entity.Client;

import java.util.List;

/**
 * Created by Asus on 31.01.2018.
 */
public class Main {

    public static void main(String[] args) {
        IDAOFactory factory = DAOFactory.getInstance();
//        CarDAO carDAO = factory.getCarDAO();
//
//        carDAO.remove("Chevrolet");

//        System.out.println(car.getId() + " " + car.getMark()
//                    + " " + car.getModel() + " " + car.getPrice());

        ClientDAO clientDAO = factory.getClientDAO();

        clientDAO.addClient(new Client("Peter", 25 , "0667884545"));
//        - adding


        List<Client> clients = clientDAO.getAllClients();
        for (Client elem : clients) {
            System.out.println(elem.getId() + " " + elem.getName() + " " + elem.getAge() + " " + elem.getPhone());
        }
//        - getting all clients

        Client secondClient = clientDAO.getById(2);
        System.out.println(secondClient.getName() + " " + secondClient.getAge() + " " + secondClient.getPhone());
//        -getting info on the second client

        clientDAO.updateAge(28, 4);
        //-updating age

        clientDAO.updatePhone("066123456", 2);
        //-updating phone

        clientDAO.remove("John");
        //-removing values

    }

}

package simple_dao.dao;

import simple_dao.entity.Client;

import java.util.List;

/**
 * Created by Asus on 31.01.2018.
 */
public interface ClientDAO {

    void addClient(Client client);

    Client getById(int id);

    List<Client> getAllClients();

    void updateAge (int age, int clientId);

    void updatePhone (String phone, int clientId);

    void remove(String name);
}

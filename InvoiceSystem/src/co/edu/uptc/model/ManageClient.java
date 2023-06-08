package co.edu.uptc.model;

import co.edu.uptc.pojo.Client;

import java.util.ArrayList;

import java.util.List;

public class ManageClient {

    private List<Client> clients;
    private ModelManager modelManager;

    public ManageClient(ModelManager modelManager) {
        this.modelManager = modelManager;
        clients = new ListUptc<>();
        ValidateRules.getInstance().setClients(clients);
    }

    public void addClient(Client client) {
        if (searchClient(client.getIdNumber()) != null) {
            modelManager.presenter.notifyError("No se puede agregar, el cliente ya existe");
        } else {
            clients.add(client.clone());
            modelManager.presenter.notifySuccession("Cliente añadido correctamente");
            showClients();
        }
        System.out.println(clients.size());
    }

    public Client searchClient(String id) {
        for (Client actClient : clients) {
            if (actClient.getIdNumber().equals(id)) {
                return actClient;
            }
        }
        return null;
    }

    public Client searchClientForEdit(int uniqueId) {
        for (Client cl : clients) {
            if (cl.getUniqueId() == uniqueId) {
                return cl;
            }
        }
        return null;
    }

    public boolean editClient(Client client) {
        boolean validation = ValidateRules.getInstance().editClient(client);
        Client cl = searchClientForEdit(client.getUniqueId());
        if (validation && cl != null) {
            cl.setDocumentType(client.getDocumentType());
            cl.setIdNumber(client.getIdNumber());
            return true;
        } else {
            modelManager.presenter.notifyError("El cliente no se puede editar, esta referenciado en una factura");
        }
        showClients();
        return false;
    }

    public void deleteClient(Client client) {
        boolean validation = ValidateRules.getInstance().deleteClient(client);
        Client cl = searchClient(client.getIdNumber());
        if (validation && cl != null) {
            clients.remove(cl);
        } else {
            modelManager.presenter.notifyError("El cliente no se puede borrar, esta referenciado en una factura");
        }
        showClients();
    }

    public List<String> showReferencedClients(){
        System.out.println("++++CLIENTES REFERENCIADOS++++++");
        showClients();
        return ValidateRules.getInstance().countReferencedInvoices();
    }

    public void deleteSelectedClients(){
       List<Client> clientsToDelete = ValidateRules.getInstance().deleteAllClients();
       clients.removeAll(clientsToDelete);
        System.out.println("Metodo de Clientes borrados");
        showClients();
    }


    public void showClients() {
        for (Client cli : clients) {
            System.out.println(cli);
        }
    }

    public List<Client> getClients() {
        ArrayList<Client> clientsAux = new ArrayList<>();
        for (Client cl : clients) {
            clientsAux.add(cl.clone());
        }
        return clientsAux;
    }


}

package com.nk.models.bo;

import com.nk.models.dao.ClienteDAO;
import com.nk.models.dto.ClienteDTO;
import java.util.List;

public class ClienteBO implements IBusinessObject<ClienteDTO, Integer> {

    private ClienteDAO clienteDAO;

    @Override
    public boolean registrar(ClienteDTO t) {
        return clienteDAO.create(t);
    }

    @Override
    public ClienteDTO buscar(Integer key) {
        return clienteDAO.read(key);
    }

    @Override
    public List<ClienteDTO> listar() {
        return clienteDAO.readAll();
    }

    @Override
    public boolean actualizar(ClienteDTO t) {
        return clienteDAO.update(t);
    }

    @Override
    public boolean eliminar(Integer key) {
        return clienteDAO.delete(key);
    }

    public void setClienteDAO(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

}

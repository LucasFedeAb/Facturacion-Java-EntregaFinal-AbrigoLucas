package com.facturacion.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.facturacion.models.entity.Client;
import com.facturacion.repositories.ClientRepository;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    
    public List<Client> getAllClients() {
		return clientRepository.findAll();
	}
	
	public Client getClientByDni(Integer dni) {
		return clientRepository.findById(dni).orElse(null);
	}
	
	public Client getClientById(Integer id) {
		return clientRepository.findById(id).orElse(null);
	}

	public Client createClient(Client client) {
	    Integer dni = client.getDni();
	    if (dni == null || dni <= 0 ) {
	    	throw new RuntimeException("El DNI no puede ser nulo ni menor a 0.");
	    }
	    // Verificar si el cliente ya existe en la base de datos
	    Client existingClient = clientRepository.findById(dni).orElse(null);
	    try {
	    	if (existingClient != null) {
	    		throw new RuntimeException("El cliente con DNI " + dni + " ya existe en la base de datos.");
		    } else {
		        client.setId(dni);
		        return clientRepository.save(client);
		    }
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

    public Client updateClientByDni(Integer dni, Client client) {
    	try {
			if (clientRepository.existsById(dni)) {
				client.setDni(dni);
				client.setId(client.getDni());
				return clientRepository.save(client);
			}
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
    	return null;
    }
    
	public boolean deleteClientByDNI(Integer dni) {
		try {
			clientRepository.deleteById(dni);
			return true;
		} catch (EmptyResultDataAccessException e) {
			return false;
		}
	}
}


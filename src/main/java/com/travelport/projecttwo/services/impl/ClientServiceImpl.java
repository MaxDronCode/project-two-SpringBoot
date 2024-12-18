package com.travelport.projecttwo.services.impl;

import com.travelport.projecttwo.repository.IClientRepository;
import com.travelport.projecttwo.repository.entities.ClientEntity;
import com.travelport.projecttwo.services.IClientService;
import com.travelport.projecttwo.services.domainModels.ClientDomain;
import com.travelport.projecttwo.services.mappings.ClientMappings;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientServiceImpl implements IClientService {

    private final IClientRepository clientRepository;

    public ClientServiceImpl(IClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<ClientDomain> getAllClients() {
        List<ClientEntity> clientEntityList = clientRepository.findAll();
        List<ClientDomain> clientDomainList = new ArrayList<>(List.of());

        clientEntityList.forEach(clientEntity -> {
            var clientDomain = ClientMappings.toDomain(clientEntity);
            clientDomainList.add(clientDomain);
        });

        return clientDomainList;
    }
}

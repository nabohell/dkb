package com.dkbcodefactory.assignment.client;

import com.dkbcodefactory.assignment.account.AccountTypeService;
import com.dkbcodefactory.assignment.events.ClientCreatedEvent;
import com.dkbcodefactory.assignment.events.CreateAccountEvent;
import com.dkbcodefactory.assignment.models.AccountType;
import com.dkbcodefactory.assignment.models.Client;
import com.dkbcodefactory.assignment.client.ClientRepo;
import com.dkbcodefactory.assignment.models.message.CreateAccountEventPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepo clientRepo;



    @Autowired
    ApplicationEventPublisher publisher;

    public Client save(Client client) {

        clientRepo.saveAndFlush(client);
        publisher.publishEvent(new ClientCreatedEvent(client));
        return client;
    }

    public Boolean exist(String phoneNumber) {
        return clientRepo.existsByPhoneNumber(phoneNumber);
    }

    public Optional<Client> getClientById(Long clientId) {
        return this.clientRepo.findById(clientId);
    }

    public void createAccount(Client client, AccountType accountType) {
        this.publisher.publishEvent(new CreateAccountEvent(new CreateAccountEventPayload(client, accountType)));
    }
}

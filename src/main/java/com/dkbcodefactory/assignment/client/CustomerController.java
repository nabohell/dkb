package com.dkbcodefactory.assignment.client;

import com.dkbcodefactory.assignment.account.AccountTypeService;
import com.dkbcodefactory.assignment.errors.InvalidRequestException;
import com.dkbcodefactory.assignment.errors.NotFoundException;
import com.dkbcodefactory.assignment.models.AccountType;
import com.dkbcodefactory.assignment.models.Client;
import com.dkbcodefactory.assignment.models.message.AccountAction;
import com.dkbcodefactory.assignment.models.message.CreateAccountRequest;
import com.dkbcodefactory.assignment.models.message.RegisterCustomerRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("customers")
public class CustomerController {
    @Autowired
    ClientService clientService;

    @Autowired
    AccountTypeService accountTypeService;

    @PostMapping()
    public ResponseEntity register(@RequestBody RegisterCustomerRequest registerCustomerRequest) {
        validate(registerCustomerRequest);
        Client client = requestToClient(registerCustomerRequest);
        return ResponseEntity.ok(clientService.save(client));
    }

    @PostMapping("/{id}/accounts")
    public ResponseEntity createAccount(@RequestBody CreateAccountRequest createAccountRequest, @PathVariable("id") Long id) {
        Client client = this.clientService.getClientById(id).orElseThrow(()->  new NotFoundException("Client not found"));

        if (createAccountRequest.getAccountType() == null) {
            throw  new InvalidRequestException("AccountType is not provided");
        }

        AccountType accountType = this.accountTypeService.getAccountTypeByName(createAccountRequest.getAccountType());
        if(accountType == null) {
            throw  new InvalidRequestException("AccountType is not supported");
        }
        this.clientService.createAccount(client, accountType);

        return ResponseEntity.ok().build();
    }

    private void validate(RegisterCustomerRequest request) {
        if (request.getCountry() == null || request.getCountry().length() == 0) {
            throw new InvalidRequestException("Country can't be empty");
        }

        if (!validatePhoneNumber(request.getPhoneNumber())) {
            throw new InvalidRequestException("Invalid PhoneNumber");
        }

        if (request.getAddressLine1() == null || request.getAddressLine1().length() == 0) {
            throw new InvalidRequestException("Address can't be empty");
        }

        if (request.getFirstName() == null || request.getFirstName().length() == 0) {
            throw new InvalidRequestException("FirstName can't be empty");
        }

        if (request.getMiddleName() == null || request.getMiddleName().length() == 0) {
            throw new InvalidRequestException("MiddleName can't be empty");
        }

        if (request.getLastName() == null || request.getLastName().length() == 0) {
            throw new InvalidRequestException("LastName can't be empty");
        }

        if (request.getPostalCode() == null || request.getPostalCode().length() == 0) {
            throw new InvalidRequestException("PostalCode can't be empty");
        }
    }

    private boolean validatePhoneNumber(String phoneNumber) {
        if( phoneNumber == null || phoneNumber.length() == 0) {
           return false;
        }

        if(clientService.exist(phoneNumber)){
            return false;
        }

        return true;
    }

    private Client requestToClient(RegisterCustomerRequest request) {
        Client client = new Client();
        client.setAddressLine1(request.getAddressLine1());
        client.setAddressLine2(request.getAddressLine2());
        client.setAddressLine3(request.getAddressLine3());
        client.setCountry(request.getCountry());
        client.setFirstName(request.getFirstName());
        client.setLastName(request.getLastName());
        client.setMiddleName(request.getMiddleName());
        client.setPhoneNumber(request.getPhoneNumber());
        client.setPostalCode(request.getPostalCode());
        return client;
    }

    // TODOL:// clean
    public static void main(String args[]) {
        Client client = new Client();
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(client);
            System.out.println("ResultingJSONstring = " + json);
            //System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}

# Bank Account Toy Coding Challenge

This Assignment solution of the "Bank Account Toy Coding Challenge", written using Springboot and mysql database.
###### Prerequisites
* docker v2.5+
* docker-compose version 1.27+

## Run the app using docker-compose
navigate to project directory and run the following

    docker-compose up -d
###### Port

    9001

# REST API

The REST API to the solution app is described below.

###API docs 
    localhost:9001/swagger-ui.html

### Deposit money into a specified bank account
##### Request
POST /accounts
###### Payload
    {
      "action": "DEPOSIT",
      "iban": "DE88000011110000000012",
      "amount": 50
    }
### Response
    status: 200

### Transfer some money across two bank accounts
##### Request
POST /accounts
###### Payload
    {
      "action": "DEPOSIT",
      "iban": "DE88000011110000000012",
      "targetIban": "DE88000011110000000011",
      "amount": 50
    }
##### Response
    status 200

### Show current balance of the specific bank account
##### Request
POST /accounts
###### Payload
    {
      "action": "BALANCE",
      "iban": "DE88000011110000000012"
    }
##### Response
    {
      "balance": 100
    }

### Filter accounts by account type
##### Request
GET /accounts
###### Params
    - type (*required) : possible values [current, saving, loan]
    - iban (optional)
    - pageSize (optional) default 20
    - pageNumber (optional) default 0

##### Response
      {
          "content": 
          [
            // list of accounts
            {
            "accountType": "saving",
            "clientNo": 2,
            "clientName": "nassar abc abc",
            "iban": "DE88000011110000000012",
            "currency": "eur",
            "balance": 80,
            "active": true
            }
          ],
          "pageable": {
            "sort": {
            "empty": true,
            "sorted": false,
            "unsorted": true
            },
            "offset": 0,
            "pageNumber": 0,
            "pageSize": 20,
            "paged": true,
            "unpaged": false
          },
          "totalPages": 1,
          "totalElements": 1,
          "last": true,
          "size": 20,
        "number": 0,
        "sort": {
          "empty": true,
          "sorted": false,
          "unsorted": true
        },
        "numberOfElements": 1,
        "first": true,
        "empty": false
    }
### Show a transaction history
##### Request
GET /transactions
###### Params
    - iban (*required)
    - pageSize (optional) default 20
    - pageNumber (optional) default 0
##### Response
    {
          "content": 
          [
            {
              "iban": "DE88000011110000000012",
              "amount": 50,
              "date": "2022-04-11T22:02:06.000+00:00",
              "transactionType": "CREDIT"
            },
            {
              "iban": "DE88000011110000000012",
              "amount": 50,
              "date": "2022-04-12T19:56:50.000+00:00",
              "transactionType": "CREDIT"
            },
            {
              "iban": "DE88000011110000000012",
              "amount": 20,
              "date": "2022-04-12T20:34:31.000+00:00",
              "transactionType": "DEPT"
            }
          ],
          "pageable": {
            "sort": {
            "empty": true,
            "sorted": false,
            "unsorted": true
            },
            "offset": 0,
            "pageNumber": 0,
            "pageSize": 20,
            "paged": true,
            "unpaged": false
          },
          "totalPages": 1,
          "totalElements": 1,
          "last": true,
          "size": 20,
        "number": 0,
        "sort": {
          "empty": true,
          "sorted": false,
          "unsorted": true
        },
        "numberOfElements": 1,
        "first": true,
        "empty": false
    }


## Create Account
##### Request
POST /customers/{id}/accounts
#### Payload
    {
     "accountType": "saving"
    }

### Response
    status 200

## account lock
##### Request
PUT /accounts/{id}
###### Payload
    {
        "action": "LOCK"
    }

### Response
    status 200
## account unlock
##### Request
PUT /accounts/{id}
###### Payload
    {
        "action": "UNLOCK"
    }

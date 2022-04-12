package com.dkbcodefactory.assignment.errors;

import javax.persistence.criteria.CriteriaBuilder;

public class InvalidRequestException extends RuntimeException{
    public InvalidRequestException() { super();}
    public InvalidRequestException(String msg) {super(msg);}
}

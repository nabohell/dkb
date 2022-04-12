package com.dkbcodefactory.assignment.client;

import com.dkbcodefactory.assignment.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepo extends JpaRepository <Client, Long> {

    Boolean existsByPhoneNumber(String phoneNumber);
}

package com.phoenix.crypto.dao;

import com.phoenix.crypto.entity.Crypto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CryptoDao extends JpaRepository<Crypto, Integer> {

}

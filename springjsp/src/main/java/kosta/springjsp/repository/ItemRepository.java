package kosta.springjsp.repository;

import kosta.springjsp.domain.email.Email;

import java.util.List;
import java.util.Optional;

public interface ItemRepository {

    Email save(Email email);

    List<Email> findAll();

}
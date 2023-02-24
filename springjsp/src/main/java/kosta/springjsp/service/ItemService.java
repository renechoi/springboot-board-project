package kosta.springjsp.service;

import kosta.springjsp.domain.email.Email;

import java.util.List;

public interface ItemService {
    Email save(Email email);

    List<Email> findItems();
}

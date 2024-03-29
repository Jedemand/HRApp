package com.astontech.hr.repositories;

import com.astontech.hr.domain.Element;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ElementRepository extends CrudRepository<Element, Integer> {

    Element findByElementName(String elementName);
    List<Element> findAllByElementName(String elementName);

    long countByElementName(String elementName);

}

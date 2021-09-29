package com.astontech.hr.repositories;

import com.astontech.hr.domain.Element;
import com.astontech.hr.domain.ElementType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ElementTypeRepository extends CrudRepository<ElementType, Integer> {


    ElementType findElementTypeByElementTypeName(String elementTypeName);
    List<ElementType> findAllByElementTypeNameEquals(String elementTypeName);

    long countDistinctByElementTypeName(String elementTypeName);

    @Query("select e.elementList from ElementType e where e.elementTypeName = ?1")
    List<Element> findElementList(String elementTypeName);

}

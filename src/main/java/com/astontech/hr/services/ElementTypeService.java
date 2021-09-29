package com.astontech.hr.services;

import com.astontech.hr.domain.Element;
import com.astontech.hr.domain.ElementType;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ElementTypeService {

    Iterable<ElementType> listAllElementTypes();

    ElementType getElementTypeById(Integer Id);

    ElementType saveElementType(ElementType ElementType);

    Iterable<ElementType> saveElementTypeList(Iterable<ElementType> ElementTypeIterable);

    void deleteElementType(Integer id);


    //customs

    ElementType findElementTypeByElementTypeName(String elementTypeName);
    List<ElementType> findAllByElementTypeNameEquals(String elementTypeName);

    long countDistinctByElementTypeName(String elementTypeName);

    @Query("select e.elementList from ElementType e where e.elementTypeName = ?1")
    List<Element> findElementList(String elementTypeName);
}

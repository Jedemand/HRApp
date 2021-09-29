package com.astontech.hr.services.impl;

import com.astontech.hr.domain.Element;
import com.astontech.hr.domain.ElementType;
import com.astontech.hr.repositories.ElementTypeRepository;
import com.astontech.hr.services.ElementTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElementTypeServiceImpl implements ElementTypeService {
    @Autowired
    private ElementTypeRepository elementTypeRepository;

    @Override
    public Iterable<ElementType> listAllElementTypes() {
        return elementTypeRepository.findAll();
    }

    @Override
    public ElementType getElementTypeById(Integer Id) {
        return elementTypeRepository.findOne(Id);
    }

    @Override
    public ElementType saveElementType(ElementType elementType) {
        return elementTypeRepository.save(elementType);
    }

    @Override
    public Iterable<ElementType> saveElementTypeList(Iterable<ElementType> elementTypeIterable) {
        return elementTypeRepository.save(elementTypeIterable);
    }

    @Override
    public void deleteElementType(Integer id) {
        elementTypeRepository.delete(id);
    }

    @Override
    public ElementType findElementTypeByElementTypeName(String elementTypeName) {
        return elementTypeRepository.findElementTypeByElementTypeName(elementTypeName);
    }

    @Override
    public List<ElementType> findAllByElementTypeNameEquals(String elementTypeName) {
        return elementTypeRepository.findAllByElementTypeNameEquals(elementTypeName);
    }

    @Override
    public long countDistinctByElementTypeName(String elementTypeName) {
        return elementTypeRepository.countDistinctByElementTypeName(elementTypeName);
    }

    @Override
    public List<Element> findElementList(String elementTypeName) {
        return elementTypeRepository.findElementList(elementTypeName);
    }
}

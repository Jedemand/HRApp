package services;

import com.astontech.hr.Application;
import com.astontech.hr.domain.Element;
import com.astontech.hr.domain.ElementType;
import com.astontech.hr.repositories.ElementRepository;
import com.astontech.hr.services.ElementService;
import com.astontech.hr.services.ElementTypeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
@WebAppConfiguration
public class ElementTypeServiceTest {
    
    @Autowired
    private ElementTypeService elementTypeService;


    @Autowired
    private ElementService elementService;

    @Test
    public void testFindElementTypeName(){
        ElementType findName = new ElementType("Laptop");
        elementTypeService.saveElementType(findName);

        ElementType foundName = elementTypeService.findElementTypeByElementTypeName("Laptop");

        assertEquals(findName.getElementTypeName(), foundName.getElementTypeName());
    }

    @Test
    public void testFindAllBy(){
        ElementType findName = new ElementType("Laptop");
        elementTypeService.saveElementType(findName);
        ElementType findName2 = new ElementType("Laptop");
        elementTypeService.saveElementType(findName2);
        ElementType findName3 = new ElementType("Laptop");
        elementTypeService.saveElementType(findName3);
        ElementType findName4 = new ElementType("Phone");
        elementTypeService.saveElementType(findName4);



        List<ElementType> laptopList = elementTypeService.findAllByElementTypeNameEquals("Laptop");

        for(ElementType elementType: laptopList){
            System.out.println(elementType.getElementTypeName());
        }

        assertEquals(3, laptopList.size());
    }

    @Test
    public void testCountDistinctByElementTypeName(){
        ElementType findName = new ElementType("Laptop");
        elementTypeService.saveElementType(findName);
        ElementType findName2 = new ElementType("Laptop");
        elementTypeService.saveElementType(findName2);
        ElementType findName3 = new ElementType("Desktop");
        elementTypeService.saveElementType(findName3);
        ElementType findName4 = new ElementType("Tablet");
        elementTypeService.saveElementType(findName4);


        assertEquals(2, elementTypeService.countDistinctByElementTypeName("Laptop"));
    }

    @Test
    public void testFindElementList(){
        ElementType findElements = new ElementType("Work");


        List<Element> workElements = new ArrayList<>();
        Element phone = new Element("Phone");
        workElements.add(phone);
        Element computer = new Element("Computer");
        workElements.add(computer);
        Element car = new Element("Car");
        workElements.add(car);

        findElements.setElementList(workElements);

        elementTypeService.saveElementType(findElements);

        List<Element> testList = elementTypeService.findElementList("Work");
        for(Element element: testList){
            System.out.println(element.getElementName());
        }

        assertEquals(findElements.getElementList().size(), elementTypeService.findElementList("Work").size());
    }
}

package respositories;

import com.astontech.hr.configuration.RepositoryConfiguration;
import com.astontech.hr.domain.Element;
import com.astontech.hr.domain.ElementType;
import com.astontech.hr.repositories.ElementRepository;
import com.astontech.hr.repositories.ElementTypeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})
public class ElementTypeRepositoryTest {
    @Autowired
    private ElementTypeRepository elementTypeRepository;

    @Autowired
    private ElementRepository elementRepository;

    @Test
    public void testFindElementTypeName(){
        ElementType findName = new ElementType("Laptop");
        elementTypeRepository.save(findName);

        ElementType foundName = elementTypeRepository.findElementTypeByElementTypeName("Laptop");

        assertEquals(findName.getElementTypeName(), foundName.getElementTypeName());
    }

    @Test
    public void testFindAllBy(){
        ElementType findName = new ElementType("Laptop");
        elementTypeRepository.save(findName);
        ElementType findName2 = new ElementType("Laptop");
        elementTypeRepository.save(findName2);
        ElementType findName3 = new ElementType("Laptop");
        elementTypeRepository.save(findName3);
        ElementType findName4 = new ElementType("Phone");
        elementTypeRepository.save(findName4);



        List<ElementType> laptopList = elementTypeRepository.findAllByElementTypeNameEquals("Laptop");

        for(ElementType elementType: laptopList){
            System.out.println(elementType.getElementTypeName());
        }

        assertEquals(3, laptopList.size());
    }

    @Test
    public void testCountDistinctByElementTypeName(){
        ElementType findName = new ElementType("Laptop");
        elementTypeRepository.save(findName);
        ElementType findName2 = new ElementType("Laptop");
        elementTypeRepository.save(findName2);
        ElementType findName3 = new ElementType("Desktop");
        elementTypeRepository.save(findName3);
        ElementType findName4 = new ElementType("Tablet");
        elementTypeRepository.save(findName4);


        assertEquals(2, elementTypeRepository.countDistinctByElementTypeName("Laptop"));
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

        elementTypeRepository.save(findElements);

        List<Element> testList = elementTypeRepository.findElementList("Work");
        for(Element element: testList){
            System.out.println(element.getElementName());
        }

        assertEquals(findElements.getElementList().size(), elementTypeRepository.findElementList("Work").size());
    }
}

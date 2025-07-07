import org.example.DTO.SearchDTO;
import org.example.entity.CarEntity;
import org.example.entity.enums.Brand;
import org.example.service.CarService;

public class MainApp {

    private static final CarService service = new CarService();

    public static void main(String[] args) {

        /*
        CarEntity car1 = new CarEntity(Brand.BMW, 10000, 1000, 2019);
        CarEntity car2 = new CarEntity(Brand.AUDI, 15000, 3000, 2020);
        CarEntity car3 = new CarEntity(Brand.CHEVROLET, 20000, 5000, 2017);
        CarEntity car4 = new CarEntity(Brand.LEXUS, 11000, 2000, 2019);

        service.save(car1);
        service.save(car2);
        service.save(car3);
        service.save(car4);
         */

        SearchDTO searchDTO = new SearchDTO(null, null, null,null,null,null);
        System.out.println(service.search(searchDTO));
    }
}

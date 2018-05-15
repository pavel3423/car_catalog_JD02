package by.htp.car_catalog.web.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.htp.car_catalog.domain.Car;
import by.htp.car_catalog.service.CarService;

import static by.htp.car_catalog.web.util.WebConstantDeclaration.*;

import java.util.List;

@Controller
@RequestMapping("brand/{brand}/{model}")
public class CarViewAction {

    private final String CAR_NOT_FOUND = "Car not found: ";

    @Autowired
    private CarService carService;

    public void setCarService(CarService carService) {
	this.carService = carService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String carView(@PathVariable("brand") String brand, @PathVariable("model") String modelCar, Model model) {

	List<Car> cars = carService.readByBrandAndModel(brand, modelCar);

	if (!cars.isEmpty()) {

	    model.addAttribute(REQUEST_PARAM_CARS, cars);
	    return PAGE_CAR_VIEW;
	} else {

	    model.addAttribute(REQUEST_MSG, CAR_NOT_FOUND + brand + " " + modelCar);
	    return PAGE_USER_ERROR;
	}
    }

}
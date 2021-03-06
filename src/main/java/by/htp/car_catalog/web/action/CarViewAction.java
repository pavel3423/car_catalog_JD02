package by.htp.car_catalog.web.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.htp.car_catalog.domain.Car;
import by.htp.car_catalog.service.CarService;
import by.htp.car_catalog.web.util.exception.IOException.UnknownCommandException;

import static by.htp.car_catalog.web.util.WebConstantDeclaration.*;

@Controller
@RequestMapping("/{brand}/{model}")
public class CarViewAction {

    @Autowired
    @Qualifier(value = "carService")
    private CarService carService;

    @RequestMapping(method = RequestMethod.GET)
    public String carView(@PathVariable("brand") String brand, @PathVariable("model") String modelCar, Model model)
	    throws UnknownCommandException {

	if (carService.checkModel(brand, modelCar)) {
	    Car car = carService.readByBrandAndModel(brand, modelCar);
	    model.addAttribute(REQUEST_PARAM_CAR, car);
	    return PAGE_CAR_VIEW;
	}
	throw new UnknownCommandException();
    }
}

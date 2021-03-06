package by.htp.car_catalog.service.impl;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import by.htp.car_catalog.dao.CarDao;
import by.htp.car_catalog.dao.ModelCarDao;
import by.htp.car_catalog.domain.Car;
import by.htp.car_catalog.domain.ModelCar;
import by.htp.car_catalog.service.CarService;
import by.htp.car_catalog.service.util.uploadFile.FileEditor;
import by.htp.car_catalog.service.util.uploadFile.UploadedFile;

@Component(value = "carService")
public class CarServiceImpl implements CarService {

    @Autowired
    @Qualifier(value = "fileEditor")
    private FileEditor fileEditor;

    @Autowired
    private CarDao carDao;

    @Autowired
    private ModelCarDao modelDao;

    @Override
    public Car readByBrandAndModel(String brand, String model) {

	return carDao.findByModelID_BrandID_BrandAndModelID_Model(brand, model);
    }

    @Override
    public boolean checkModel(String brand, String model) {
	ModelCar modelCar = modelDao.findByBrandID_brandAndModel(brand, model);
	return modelCar != null;
    }

    @Override
    public Car createCar(String brand, String model) {
	ModelCar modelCar = modelDao.findByBrandID_brandAndModel(brand, model);
	return carDao.save(new Car(0, modelCar));
    }

    @Override
    public Car editCar(Car car, Map<String, String> params, UploadedFile uploadedFile) throws IOException {
	car.setYear(Integer.parseInt(params.get("year")));
	car.setPrice(Integer.parseInt(params.get("price")));
	car.setBodyType(params.get("bodyType"));
	car.setLength(Integer.parseInt(params.get("length")));
	car.setWidth(Integer.parseInt(params.get("width")));
	car.setHeight(Integer.parseInt(params.get("height")));
	car.setBase(Integer.parseInt(params.get("base")));
	car.setNumberOfDoors(Integer.parseInt(params.get("numberOfDoors")));
	car.setClearance(Integer.parseInt(params.get("clearance")));
	car.setTrunk(Integer.parseInt(params.get("trunk")));
	car.setVolumeOfTheTank(Integer.parseInt(params.get("volumeOfTheTank")));
	car.setNumberOfPlaces(Integer.parseInt(params.get("numberOfPlaces")));

	if (uploadedFile.length() > 0) {
	    fileEditor.deleteFile(car.getImage());
	    car.setImage(fileEditor.saveFile(uploadedFile));
	}

	carDao.save(car);

	return car;
    }

}

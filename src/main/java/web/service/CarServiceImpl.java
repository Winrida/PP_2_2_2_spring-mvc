package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService{
    private List<Car> carList = setList();

    public List<Car> setList() {
        carList = new ArrayList<>();

        carList.add(new Car("Honda", "N-Box", "White"));
        carList.add(new Car("Toyota", "Mirai", "Blue"));
        carList.add(new Car("DeLorean", "DMC-12", "Silver"));
        carList.add(new Car("Porsche", "911", "Yellow"));
        carList.add(new Car("Datsun", "280Z", "Black"));

        return carList;
    }

    public List<Car> getList() {
        return carList;
    }

    public List<Car> showByCount(int count) {
        return carList.stream().limit(count).collect(Collectors.toList());
    }

}

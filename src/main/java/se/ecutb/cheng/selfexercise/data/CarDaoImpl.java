package se.ecutb.cheng.selfexercise.data;

import org.springframework.stereotype.Component;
import se.ecutb.cheng.selfexercise.entity.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CarDaoImpl implements CarDao {
    List<Car> carList = new ArrayList<>();

    @Override
    public Optional<Car> findById(int id){
        return carList.stream()
                .filter(car -> car.getId() == id)
                .findFirst();
    }

    @Override
    public Optional<Car> findByRegNumber(String regNumber){
        return carList.stream()
                .filter(car -> car.getRegNumber().equals(regNumber))
                .findFirst();
    }

    @Override
    public List<Car> findAll(){return carList;}

    @Override
    public boolean save(Car car){return carList.add(car);}

    @Override
    public Car update(Car car){
        Car original = findById(car.getId()).get();
        original.setBrand(car.getBrand());
        original.setRegNumber(car.getRegNumber());
        original.setMode(car.getMode());
        original.setRegDate(car.getRegDate());
        return original;
    }

    @Override
    public boolean delete(int id){
        Car car = findById(id).get();
        return carList.remove(car);
    }
}

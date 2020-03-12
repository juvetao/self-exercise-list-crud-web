package se.ecutb.cheng.selfexercise.data;

import se.ecutb.cheng.selfexercise.entity.Car;

import java.util.List;
import java.util.Optional;

public interface CarDao {
    Optional<Car> findById(int id);

    Optional<Car> findByRegNumber(String regNumber);

    List<Car> findAll();

    boolean save(Car car);

    Car update(Car car);

    boolean delete(int id);
}

package se.ecutb.cheng.selfexercise.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Car {
    private int id;
    private String regNumber;
    private String brand;
    private String mode;
    private LocalDate regDate;
    public static int counter = 0;

//    public Car(int id, String regNumber, String brand, String mode, LocalDate regDate) {
//        this.id = counter++;
//        this.regNumber = regNumber;
//        this.brand = brand;
//        this.mode = mode;
//        this.regDate = regDate;
//    }

    public Car(String regNumber, String brand, String mode, LocalDate regDate) {
        this.id = counter++;
        this.regNumber = regNumber;
        this.brand = brand;
        this.mode = mode;
        this.regDate = regDate;
    }

    public Car(){}

    public int getId() {
        return id;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id &&
                Objects.equals(regNumber, car.regNumber) &&
                Objects.equals(brand, car.brand) &&
                Objects.equals(mode, car.mode) &&
                Objects.equals(regDate, car.regDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, regNumber, brand, mode, regDate);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Car{");
        sb.append("id=").append(id);
        sb.append(", regNumber='").append(regNumber).append('\'');
        sb.append(", brand='").append(brand).append('\'');
        sb.append(", mode='").append(mode).append('\'');
        sb.append(", regDate=").append(regDate);
        sb.append('}');
        return sb.toString();
    }
}

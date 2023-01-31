package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private List<Car> makeCars() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Молния", "Красный", "Я - уникальный сплав скорости и аэродинамики!"));
        cars.add(new Car("Док Хадсон", "Синий", "Удачной рыбалки."));
        cars.add(new Car("Салли", "Голубой", "Знаменитые гонщики просто так не катаются?"));
        cars.add(new Car("Мэтр", "Коричневый", "Все эти ухабы на дороге - вот ради чего стоит жить."));
        cars.add(new Car("Филмор", "Зеленый", "Пресвятые фары, чувак!"));
        return cars;
    }
    @Override
    public List<Car> getCarsByCount(Integer count) {
        if ((count != null) && (count > 0) && (count < 5)) {
            return makeCars().subList(0, count);
        }

        return makeCars();
    }
}

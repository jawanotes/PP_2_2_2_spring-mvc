package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

/***
 * Nikita Nesterenko:
 * makeCars(); - данные в этом бине могут быть статичны, а у тебя пересоздаются постоянно
 *      сделай статик иницилизацию листа
 *
 * if ((count != null) && (count > 0) && (count < 5)) { - такое нагроможденное условие избыточно
 *      , оставь каунт меньше 5 или используй вообще Math.min
 *
 * валидация проходит на этапе контроллера в целом, а не в сервисе
 *      , но это щас не важно - считай что у тебя постоянно корректные данные
 */
@Service
public class CarServiceImpl implements CarService {
    private static final List<Car> carsList = makeCars();

    private static List<Car> makeCars() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Молния", "Красный", "Я - уникальный сплав скорости и аэродинамики!"));
        cars.add(new Car("Док Хадсон", "Синий", "Удачной рыбалки."));
        cars.add(new Car("Салли", "Голубой", "Знаменитые гонщики просто так не катаются?"));
        cars.add(new Car("Мэтр", "Коричневый", "Все эти ухабы на дороге - вот ради чего стоит жить."));
        cars.add(new Car("Филмор", "Зеленый", "Пресвятые фары, чувак!"));
        return cars;
    }

    /***
     * Harin K.
     * Валидация перенесена в контроллер
     */
    @Override
    public List<Car> getCarsByCount(Integer count) {
/*        if ((count != null) && (count > 0) && (count < 5)) {
            return carsList.subList(0, count);
        }

        return carsList;*/
        return carsList.subList(0, Math.min(count, 5));
    }
}

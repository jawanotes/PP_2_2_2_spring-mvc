package web.model;

import org.springframework.stereotype.Component;

@Component
public class Car {
    String name;
    String color;
    String sentence;

    public Car() {
    }

    public Car(String name, String color, String sentence) {
        this.name = name;
        this.color = color;
        this.sentence = sentence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }
}

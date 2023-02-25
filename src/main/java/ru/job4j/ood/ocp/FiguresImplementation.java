package ru.job4j.ood.ocp;

import java.util.List;

public class FiguresImplementation {

    private interface Drawable {
        String draw();
    }

    private static class Rectangle implements Drawable {

        @Override
        public String draw() {
            return "...";
        }

    }

    private static class Line implements Drawable {

        @Override
        public String draw() {
            return ",,,";
        }

    }

    public static void main(String[] args) {
        List<Drawable> rectangles = List.of(new Rectangle(), new Line());
        rectangles.forEach(Drawable::draw);
    }
}

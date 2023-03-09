package ru.job4j.ood.isp.menu;

public class SimpleMenuPrinter implements MenuPrinter {

    private static final String INDENT = "----";

    @Override
    public void print(Menu menu) {
        StringBuilder text = new StringBuilder();
        menu.forEach(itemInfo -> {
            String[] layers = itemInfo.getNumber().split("\\.");
            if (layers.length > 1) {
                text.append(INDENT.repeat(layers.length - 1)).append(" ");
            }
            text.append(itemInfo.getName()).append(" ");
            text.append(itemInfo.getNumber());
            System.out.println(text);
            text.setLength(0);
        });
    }
}

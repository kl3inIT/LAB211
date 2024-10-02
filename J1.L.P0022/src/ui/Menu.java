package ui;

import util.Validation;

import java.util.ArrayList;

public class Menu {

    private final String menuTitle;
    private final ArrayList<String> optionList;

    public Menu(String menuTitle) {
        this.optionList = new ArrayList<>();
        this.menuTitle = menuTitle;
    }

    public void addNewOption(String newOption) {
        optionList.add(newOption);
    }

    public void printMenu() {
        if (optionList.isEmpty()) {
            System.out.println("There are no option in the menu");
            return;
        }
        System.out.println("\n------------------------------------");
        System.out.println(menuTitle);
        for (String option : optionList) {
            System.out.println(option);
        }
    }

    public int getChoice() {
        int maxOption = optionList.size();
        String inputMsg = "Choose [1 -> " + maxOption + "]: ";
        String errorMsg = "You are required to choose the option from 1 to " + maxOption;
        return Validation.getAnInteger(inputMsg, errorMsg, 1, maxOption);
    }
}

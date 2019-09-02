package com.monarch;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IngredientsOptomised {

    //ex[FATGHEE, FATBUTTER, CARBROTI, FIBERFISH, CARBRICE, FIBERBROCOLI]

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Input no of days: ");
        int noOfDays= input.nextInt();

        System.out.println("Input Ingrediants");
        List<String> ingredientsList = new ArrayList<>();

        int fatCount = 0;
        int fiberCount = 0;
        int carbCount = 0;

        for(Integer i = 0; i<noOfDays && i >= 0; i++) {
            System.out.print("Ingredient " + i+" = ");
            String temp=input.next();
            ingredientsList.add(temp);

            if(checkIngredients(temp, "fat")) {
                fatCount++;
            }
            else if(checkIngredients(temp, "fiber")){
                fiberCount++;
            }
            else if (checkIngredients(temp, "carb")){
                carbCount++;
            }

            if (fatCount == 2 && (fiberCount ==1 || carbCount ==1)){

                removeElements(ingredientsList,i,"\nMeal 1 Completed =");

                fatCount =fatCount-2;
                if (fiberCount == 1){
                    fiberCount--;
                }
                else{
                    carbCount--;
                }
            }
            else if (fiberCount == 2 && (fatCount ==1 || carbCount ==1)){

                removeElements(ingredientsList,i,"\nMeal 2 Completed =");

                fiberCount =fiberCount-2;
                if (fatCount == 1){
                    fatCount--;
                }
                else{
                    carbCount--;
                }
            }
            else if (carbCount == 2 && (fatCount ==1 || fiberCount ==1)){

                removeElements(ingredientsList,i,"\nMeal 3 Completed =");

                carbCount =carbCount-2;
                if (fatCount == 1){
                    fatCount--;
                }
                else{
                    fiberCount--;
                }
            }
        }

        System.out.println("Final List = "+ingredientsList);
        System.out.println("Fat Count = " +fatCount );
        System.out.println("Fiber Count = " +fiberCount );
        System.out.println("Carb Count = " +carbCount );

    }

    private static boolean checkIngredients(String temp, String ingredientName) {
        return temp.toLowerCase().contains(ingredientName);
    }

    private static void removeElements(List<String> ingredientsList, Integer index, String msg) {
        System.out.println(msg + ingredientsList.subList(index - 2, index + 1));
        ingredientsList.subList(index - 2, index + 1).clear();
        System.out.println("New List = " + ingredientsList);
    }
}

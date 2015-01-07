package net.robbytu.hanze.kantine;

import java.io.DataInputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Dylan on 7-1-2015.
 */
public class Main
{
    public static CanteenSimulation canteenSimulation;
    public static ArrayList<Article> articles;

    public static void main(String[] args)
    {

        Scanner scanner = new Scanner(System.in);
        System.out.println("How many articles do you want to add?");

        int amountOfArticles = scanner.nextInt();
        articles = new ArrayList<Article>();
        scanner.nextLine();
        for(int i = 0; i < amountOfArticles; i++)
        {
            System.out.println("Article Name: ");
            String name = scanner.nextLine();
            System.out.println("Article Price: ");
            double price = scanner.nextDouble();
            articles.add(new Article(name, price));
            scanner.nextLine();
        }

        for(Article article : articles)
        {
            System.out.println(article.getName() + " costs: " + article.getPrice());
        }




        canteenSimulation = new CanteenSimulation();
    }

}

import java.util.Scanner;

/**
 * Created by Carla Nayeli on 11/22/2016.
 */
public class fae {

    public static void main (String[] args){

        //Dead tree

        Scanner one = new Scanner(System.in);
        System.out.println("Hello there. What's your name?");
        String username = one.next();

        System.out.println("Do you see that tree right there? \n" +
                "It's dying and I really need to keep it alive. \n" +
                "The water from the Pond of Wonders can keep it alive. \n" +
                "Would you mind helping me save the tree? \n" +
                "I would really appreciate it. \n" +
                "Will you join me in my quest?");

        Scanner two = new Scanner(System.in);
        System.out.println("Press A for yes. \n" +
                "Press B for no.");
        char escort = two.next().charAt(0);
        if (escort == 'A' || escort == 'a'){
            System.out.println("Thank you so much. That's really kind of you!");
        } else {
            System.exit(0);
        }

        System.out.println("I don't really like going on adventures by myself. \n" +
                "I feel like it's that could be very dangerous. \n" +
                "The pond is not very far from here. \n" +
                "we just have to follow that path over there");

        //Cave

        System.out.println("Wow look " + username);
        System.out.println("do you see the cave \n" +
                "It's a lot scarier looking then I imagined \n" +
                "Are you sure you don't mind going inside?");

        Scanner three = new Scanner(System.in);
        System.out.println("Press A for 'Of course I don't mind going inside.' \n" +
                "Press B for 'Wow, no thanks this seems like a bad idea.'");
        char cave = three.next().charAt(0);
        if (cave == 'A' || cave == 'a'){
            System.out.println("Thank you so much!!! \n" +
                    "I'm so lucky that I ran into you. \n" +
                    "I wouldn't feel safe going in alone.");
        } else {
            System.exit(0);
        }

        //Sees water

        System.out.println("I see the water over there. This is so exciting \n" +
                "Here, I'm going to put it in this cup. \n" +
                "I can't wait to get back to my tree.");

        System.out.println("All that walking made you tired. \n" +
                "You could really go for a drink. \n" +
                "What do you do?");

        Scanner four = new Scanner(System.in);
        System.out.println("Press A to continue helping the fae. \n" +
                "Press B to steal the water to drink it yourself.");
        char drink = four.next().charAt(0);
        if (drink == 'A' || drink == 'a'){
            System.out.println("Let's go!!! \n" +
                    "I'm so tired, I'm ready to get back now");
        } else {
            System.exit(0);
        }

        System.out.println("You make your way back to the tree. \n" +
                "It has been a really long day. \n" +
                "You and the fae both can't wait to see the tree heal.");

        Scanner five = new Scanner(System.in);
        System.out.println("Press A to give the tree the water \n" +
                "Press B so the fae give the tree the water.");
        char revive = five.next().charAt(0);
        if (revive == 'A' || revive == 'a'){
            System.out.println("Here you go tree!!!");
        } else {
            System.out.println("I'm glad we made it back in time!");
        }

        //Happy Three

        System.out.println("GAME OVER!");





    }


}


package at.appdevs.basics;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Dog dog = new Dog("Bello", "wuff");
        Dog equalDog = new Dog("Bello", "wuff");

        if (dog instanceof Object) {
            System.out.println("Tatsächlich ein Object");
        }


        Object o;

        if (dog instanceof Dog) {
            System.out.println("Ist ein Dog");
        }

        // Ziel: beide Dogs sollen equals-gleich sein
        if (dog.equals(equalDog)) {
            System.out.println("Sind equals gleich");
        } else {
            System.out.println("Sind nicht equals gleich.");
        }

        if (null == null) {
            System.out.println("null==null");
        }

        Dog strolchi = new Dog("Strolchi", "wau");

        if (strolchi.equals(dog)) {
            System.out.println("Sind gleich");
        } else {
            System.out.println("Strolchi ist NICHT Bello");
        }

        // Nur eine Referenz (zeigt ins Nirvana)
        Object obj1;
        // Eine Referenz die auf ein Objekt (vom Typ Object zeigt)
        Object obj2 = new Object();

        Dog dogObj = new Dog("Pluto", "kläff");

        // Object-Referenz die auf ein Dog-Objekt zeigt
        Object objRefDog = new Dog("Rufus", "wauau");

        dogObj.getBarkSound();

//        objRefDog.setName("Brutus");

//        String str = "Johannes";
        Object objRefString = "Johannes";

        Object[] objRefArray = new Object[] {objRefDog, objRefString};


        // herausfinden welches Objekt steckt hinter der Object-Referenz
        if (objRefArray[0] instanceof Dog) {

            Dog dogRef = (Dog)objRefArray[0];
            dogRef.getBarkSound();
        }

        // Möglichkeit 1: Durch Array iterieren und Typ überprüfen
        for (Object obj : objRefArray) {


//            if (obj instanceof Dog) {
//                System.out.println("is a dog");
//                Dog myDogRef = (Dog) obj;
//                myDogRef.getBarkSound();
//                System.out.println(myDogRef.toString());
//            }
//            if (obj instanceof String) {
//                String string = (String)obj;
//                char c = string.charAt(2);
//                System.out.println(string.toString());
//            }

            System.out.println(obj.toString());
        }






    }
}

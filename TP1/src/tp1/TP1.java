/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;

import java.io.*;
import java.util.*;

/**
 * Solution du TP n°1
 * @author Ahlem Embarek 
 * version 1.0
 */
public class TP1 {

    static Scanner input = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws IOException {
        gestion_menu();
    }

    /**
     * Cette fonction permet la lecure d'un entier entré au clavier
     * 
     * @param prompt message diffusé qui permet à l'utilisateur de comprendre ce qu'il doit faire
     * @return entier qui represente le nombre lu à partir du clavier
     */
    
    public static int getInt(String prompt) {
        System.out.print(prompt + " ");
        int entier = input.nextInt();
        input.nextLine(); // Se débarrasser de cette ligne
        return entier;
    }
    
    /**
     * Cette fonction permet le remplissage d'un tableau de n elements à partir du clavier
     * 
     * @param n la taille du tableau à remplir
     * @return tab[] le tableau remplie à parti rdu clavier
    **/
    
    public static int[] RemplirTab(int n) {
        int i;
        int[] tab = new int[n];
        for (i = 0; i < tab.length; i++) {
            tab[i] = getInt("       Entrée n°" + (i + 1));
        }
        return tab;
    }
    
    /**
     * cette fonction affiche le contenu d'un tableau donné en entrée
     * le contenu est affiché sur une meme ligne
     * tous les elements du tableau sont separé l'un de l'autre par un |
     * 
     * @param tab le tableau à afficher
    **/
    
    public static void AfficherTab(int tab[]) {
        System.out.print("| ");
        for (int i = 0; i < tab.length; ++i) {
            System.out.print(tab[i] + " | ");
        }
        System.out.println("");
        System.out.println("");
    }
    
    /**
     * Cette fonction donne le tableau inverse d'un tableau donné en entrée
     * par exemple si on prend le tableau |5|19|7|32|1|
     * le resultat de son inversion est |1|32|7|19|5|
     * 
     * @param tab le tableau à inverser
     * @return sab[] le tableau resulatant de l'operation d'inversion
    **/
    
    public static int[] InverserTab(int tab[]) {
        int n = tab.length;
        int[] sab = new int[n];
        for (int i = 0; i < tab.length; i++) {
            sab[i] = tab[n - 1];
            n--;
        }
        return sab;
    }
    
    /**
     * Cette fonction effectue un tri à bulle à un tableau donné en entrée
     * Son principe :
     * L'algorithme parcourt le tableau et compare les éléments consécutifs.
     * Lorsque deux éléments consécutifs ne sont pas dans l'ordre, ils sont échangés.
     * Et ansi de suite jusqu'à ce que tous les elements du tableau sont dans l'ordre.
     * 
     * @param tab le tableau à trier
     * @return tab le tableau trié
    **/
    
    public static int[] TriBulles(int tab[]) {
        boolean tab_in_order = false;
        int taille, temp;
        taille = tab.length;
        while (!tab_in_order) {
            tab_in_order = true;
            for (int i = 0; i < taille - 1; i++) {
                if (tab[i] > tab[i + 1]) {
                    temp = tab[i];
                    tab[i] = tab[i + 1];
                    tab[i + 1] = temp;
                    tab_in_order = false;
                }
            }
            taille--;
        }
        return tab;
    }
    
    /**
     * Cette fonction calcule la somme de deux tableaux de même taille.
     * Si les 2 tableaux ne sont pas de même taille une exception est generée.
     * 
     * @param T le premier tableau qui sera sommer
     * @param S le deuxieme tableau pour effectuer l'operation de la somme
     * @return R[] le taleau resulatant de la somme des deux tableaux T et S
    **/
    
    public static int[] SomVector(int T[], int S[]) {
        int n = T.length, m = S.length;
        int[] R = new int[n];
        if (n == m) {
            for (int i = 0; i < n; i++) {
                R[i] = T[i] + S[i];
            }
        }
        return R;
    }
    
    /**
     * Cette fonction calcule en même temps le min et le max d'un tableau donné en entrée
     * 
     * @param tab le tableau à traiter
    **/
    
    public static void MaxMin(int tab[]) {
        int min, max, n = tab.length;
        int[] S = new int[n];
        S = TriBulles(tab);
        min = S[0];
        System.out.println("Le minimum de ce tableau est : " + min);
        max = S[n - 1];
        System.out.println("La maximum de ce tableau est : " + max);
    }
    
    /**
     * Cette fonction represente un menu d'excution
     * Ce menu rend notre execution bien organisée et plus lisible
     * 
    **/
    
    public static void gestion_menu() throws IOException {
        int cas, n = 0, m = 0;
        int[] tab;
        int[] sab;
        BufferedReader syl1 = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("1-Tri du tableau");
        System.out.println("2-La somme de deux tableaux");
        System.out.println("3-Inverser les elements d'un tableau");
        System.out.println("4-Max, Min d'un tableau");
        System.out.println("5-Application d'une formule aux elements du tableau");
        System.out.println("6-Quitter");
        System.out.println("");
        System.out.println("");
        System.out.print("        Veuillez entrer votre choix :      ");
        cas = Integer.parseInt(syl1.readLine());
        switch (cas) {
            case 1: {
                System.out.println("*----------------------*");
                System.out.println("    Tri du tableau");
                System.out.println("*----------------------*");
                System.out.println();
                n = getInt("Donnez le nombre d'entrées du tableau :");
                tab = new int[n];
                tab = RemplirTab(n);
                AfficherTab(TriBulles(tab));
                gestion_menu();
            }
            break;
            case 2: {
                System.out.println("*------------------------*");
                System.out.println("La somme des deux tableau");
                System.out.println("*------------------------*");
                n = getInt("Donner la taille du premier tableau :");
                tab = new int[n];
                tab = RemplirTab(n);
                m = getInt("Donner la taille du deuxiemme tableau :");
                sab = new int[m];
                sab = RemplirTab(m);
                System.out.println("Le tableau resultant est : ");
                AfficherTab(SomVector(tab, sab));
                gestion_menu();
            }
            break;
            case 3: {
                System.out.println("*---------------------------------*");
                System.out.println("Inverser les elements d'un tableau");
                System.out.println("*---------------------------------*");
                System.out.println("");
                System.out.println("");
                n = getInt("Donnez le nombre d'entrées du tableau :");
                tab = new int[n];
                tab = RemplirTab(n);
                AfficherTab(InverserTab(tab));
                gestion_menu();
            }
            break;
            case 4: {
                n = getInt("Donnez le nombre d'entrées du tableau :");
                tab = new int[n];
                tab = RemplirTab(n);
                System.out.println("*--------------------------------------*");
                MaxMin(tab);
                System.out.println("*--------------------------------------*");
                gestion_menu();
            }
            break;
            case 5: {
            }
            break;
            case 6: {
                System.out.println("Merci d'avoir utiliser mon programme !");
            }
        }
    }
}

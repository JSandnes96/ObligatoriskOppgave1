package no.oslomet.cs.algdat.Oblig1;

////// Løsningsforslag Oblig 1 - 2019 ////////////////////////

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.NoSuchElementException;


public class Oblig1 {
    private Oblig1() {
    }

    ///// Oppgave 1 //////////////////////////////////////
    public static int maks(int[] a)
    {
        if (a.length < 1)
            throw new java.util.NoSuchElementException("Tabellen er tom");

        for (int i = 0; i < a.length-1; i++ ){
            if(a[i]>a[i+1]){
                int verdi = a[i];
                a[i] = a[i+1];
                a[i+1] = verdi;
            }
        }
        return a[a.length-1];
    }

    public static int ombyttinger(int[] a)
    {
        int teller = 0;

        if (a.length < 1)
            throw new java.util.NoSuchElementException("Tabellen er tom");

        for (int i = 0; i < a.length-1; i++ ){
            if(a[i]>a[i+1]){
                int verdi = a[i];
                a[i] = a[i+1];
                a[i+1] = verdi;
                teller++;
            }
        }
        return teller;
    }

    ///// Oppgave 2 //////////////////////////////////////
    public static int antallUlikeSortert(int[] a) {

        int antallUlike = 1; //maa starte på en siden det alltid vil vaere en ulik med mindre arrayet er tomt

        for (int i = 0; i < a.length-1; i++ ){

            if(a[i+1]>a[i]){
                antallUlike++;
            }

            if(a[i] > a[i+1])
                throw new IllegalStateException("Tabellen må være sortert stigende");
        }

        if(a.length == 0){
            antallUlike = 0; //Hvis arrayet er tomt er det 0 ulike
        }

        return antallUlike;
    }


    ///// Oppgave 3 //////////////////////////////////////
    public static int antallUlikeUsortert(int[] a) {

        int antallUlike = a.length; //starter med å anta at alle er ulike
        for(int i = 0; i<a.length-1; i++){
            for(int j = i+1; j<a.length; j++){
                if(a[i] == a[j]) {
                    antallUlike--;
                    break;
                }
            }
        }
        return antallUlike;
    }

    ///// Oppgave 4 //////////////////////////////////////
    public static void delsortering(int[] a) {

        for (int i = 0; i < a.length-1; i++){
            for(int j = i+1; j < a.length; j++){
                if(i % 2 == 0 && j % 2 != 0){
                    int midlertidig = a[i];
                    a[i] = a[j];
                    a[j] = midlertidig;
                }
            }
        }
    }

    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a) {
        System.out.println("\nUrotert er: " + Arrays.toString(a));

        //DENNE SKRIVER UT SAMME ARRAY PÅ NYTT
        /*for(int i = 0; i < a.length; i++){
            char siste = a[a.length-1];
            int j;
            for (j = a.length-1; j> 0; j--){
                a[j]=a[j-1];
            }
            a[0] = siste;
        }*/

        //DENNE SKRIVER UT RIKTIG MEN HAR LAGD NYTT ARRAY :(

        char[] b = new char[a.length];

        for(int i = 0; i <= a.length-1; i++){
            b[(i+1) % a.length ] = a[i];
        }

        System.out.println("\nRotert er: " + Arrays.toString(b));
    }

    ///// Oppgave 6 //////////////////////////////////////
    public static void rotasjon(char[] a, int k) {

        char[] b = new char[a.length];

        for(int i = 0; i <= a.length-1; i++){
            b[(i+k) % a.length ] = a[i];
        }

        System.out.println("\nRotert er: " + Arrays.toString(b));
    }

    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    public static String flett(String s, String t) {
        //KOPIERT RETT FRA OPPG 1b i 1.3.11

        int k = Math.min(a.length(), b.length());  // lengden på den korteste
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < k; i++)
        {
            s.append(a.charAt(i)).append(b.charAt(i));
        }

        s.append(a.substring(k)).append(b.substring(k));

        return s.toString();
    }

    /// 7b)
    public static String flett(String... s) {
        throw new NotImplementedException();
    }

    ///// Oppgave 8 //////////////////////////////////////
    public static int[] indekssortering(int[] a) {
        int[] indeks = new int[a.length];
        int indeks-tall = a[0];
        int minste = a[0];

        for(int i = 0; i<a.length-1; i++){
            for(int j = 0; j<a.length; j++){
                if (a[i]<minste){
                    indeks-tall = i;
                }
            }
            indeks[i] = indeks-tall;
        }
    }


    ///// Oppgave 9 //////////////////////////////////////
    public static int[] tredjeMin(int[] a) {

        int n = a.length; //Lengden av arrayet

        if (n < 3){ //Arrayet må ha minst 3 verdier
            throw new NoSuchElementException("Arrayet må ha minst 3 verdier!");
        }

        int minst = 0; //Posisjonen til minste
        int nestMinst = 1; //Posisjonen til 2. minste
        int tredjeMinst = 2; //Posisjonen til 3. minste

        if (a[nestMinst] < a[minst]){
            minst = 1;
            nestMinst = 0;
        }

        if (a[tredjeMinst] < a[minst]){
            int midlertidig = tredjeMinst;
            tredjeMinst = minst;
            minst = midlertidig;
        }

        if (a[tredjeMinst] < a[nesMinst]){
            int midlertidig = tredjeMinst;
            tredjeMinst = nestMinst;
            nestMinst = midlertidig;
        }

        int minsteVerdi = a[minst];  //minste verdi
        int nestMinsteVerdi = a[nestMinst];   //nest minste verdi
        int tredjeMinsteVerdi = a[tredjeMinst];   //tredje minste verdi

        for (int i = 3; i < a.length; i++){
            int verdi = a[i];

            if (verdi < tredjeMinsteVerdi){
                if (verdi < nestMinsteVerdi){
                    if (verdi < minsteVerdi){

                        //Kan hende disse må endres litt på. Rekkefølge osv

                        tredjeMinst = nestMinst;
                        tredjeMinsteVerdi = nestMinsteVerdi;

                        nestMinst = minst;
                        nestMinsteVerdi = minsteVerdi;

                        minst = i;
                        minsteVerdi = verdi;

                    }
                    else{ //her er verdi >= maksverdi && verdi < nestmaksverdi

                        tredjeMinst = nestMinst;
                        tredjeMinsteVerdi = nestMinsteVerdi;

                        nestMinst = i;
                        nestMinsteVerdi = verdi;

                    }
                }
                else{ // når verdi >= nestmaksverdi && verdi < tredjemaksverdi
                    tredjeMinst = i;
                    tredjeMinsteVerdi = verdi;
                }
            }
        }
        return new int[] {minst, nestMinst, tredjeMinst};
    }

    ///// Oppgave 10 //////////////////////////////////////
    public static int bokstavNr(char bokstav) {
        throw new NotImplementedException();
    }

    public static boolean inneholdt(String a, String b) {
        throw new NotImplementedException();
    }

}  // Oblig1

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
        /* Initialize left and right indexes */
        int venstre = 0;
        int hoyre = a.length - 1;
        while (venstre < hoyre)
        {
            /* Increment left index while we see 0 at left */
            while (a[venstre]%2 == 1 && venstre < hoyre)
                venstre++;

            /* Decrement right index while we see 1 at right */
            while (a[hoyre]%2 == 0 && venstre < hoyre)
                hoyre--;

            if (venstre < hoyre)
            {
                /* Swap arr[left] and arr[right]*/
                int midlertidig = a[venstre];
                a[venstre] = a[hoyre];
                a[hoyre] = midlertidig;
                venstre++;
                hoyre--;
            }
        }

    }

    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a) {

        if (a.length > 0) {
            char siste = a[a.length - 1];
            for(int i = a.length-1; i > 0; i--){
                a[i] = a[i-1];
            }
            a[0] = siste;
        }

    }

    ///// Oppgave 6 //////////////////////////////////////
    public static void rotasjon(char[] a, int k) {

        //KOPIERT FRA 1.3.13 OPPG 4

        int n = a.length;
        if (n < 2) return;                 // tomt eller en verdi, ingen rotasjon
        if ((k %= n) < 0) k += n;

        if (k <= (n+1)/2)  // forskyver k enheter mot høyre
        {
            char[] b = Arrays.copyOfRange(a, n - k, n);         // opretter hjelpetabell
            for (int i = n - 1; i >= k; i--) a[i] = a[i - k];   // forskyver k enheter
            System.arraycopy(b, 0, a, 0, k);                    // kopierer
        }
        else  // forskyver mot venstre n - k enheter mot venstre
        {
            char[] b = Arrays.copyOfRange(a, 0, n - k);         // oppretter hjelpetabell
            for (int i = 0; i < k; i++) a[i] = a[i + n - k];    // forskyver
            System.arraycopy(b, 0, a, k, n - k);                // kopierer
        }


    }

    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    public static String flett(String s, String t) {

        String ny = "";

        for(int i = 0; i< s.length(); i++){
            ny= ny + s.charAt(i);
            if(i<t.length()){
                ny = ny + t.charAt(i);
            }
        }

        if(s.length()<t.length()){
            ny = ny + t.substring(s.length());
        }

        return ny;
    }

    /// 7b)
    public static String flett(String... s) {

    }

    ///// Oppgave 8 //////////////////////////////////////
    public static int[] indekssortering(int[] a) {
        int[] indeks = new int[a.length];
        int[] sortert = a.clone();

        for(int i = 0 ; i < sortert.length;i++)
        {
            for(int j = i+1 ; j< sortert.length;j++)
            {
                if(sortert[i] > sortert[j])
                {
                    int temp = sortert[i];
                    sortert[i] = sortert[j];
                    sortert[j] = temp;
                }
            }
        }

        int indeksen = 0;

        for(int i = 0 ; i < a.length;i++)
        {
            for(int j = 0; j<a.length; j++) {
                if (sortert[i] == a[j]) {
                    indeksen = j;
                }
            }
            indeks[i] = indeksen;
        }

        return indeks;
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

    }

    public static boolean inneholdt(String a, String b) {

    }

}  // Oblig1

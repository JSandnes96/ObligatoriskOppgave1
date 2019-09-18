////// Løsningsforslag Oblig 1 - 2019 ////////////////////////

//STUDENT: JØRGEN SANDNES
//STUDENTNUMMER: S331423

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;


public class Oblig1 {
    private Oblig1() {
    }

    ///// Oppgave 1 //////////////////////////////////////
    public static int maks(int[] a) {
        if (a.length < 1) //sjekker om tabellen er tom, kaster exception om den er det
            throw new java.util.NoSuchElementException("Tabellen er tom");

        for (int i = 0; i < a.length - 1; i++) { //For lokke gjennom tabellen
            if (a[i] > a[i + 1]) { //Hvis en verdi er storre enn verdien til hoyre for seg bytter de plass
                int verdi = a[i];  //lagrer verdien i a med indeks i som en ny int.
                a[i] = a[i + 1];   //Setter verdien i a med indeks i lik verdien til a+1 (da denne er mindre)
                a[i + 1] = verdi;  //Setter saa verdien i a med indeks i+1 til den verdien a[i] orginalt hadde
            }
        }
        return a[a.length - 1]; //Returnerer siste elementet i arrayet
    }


    //Akkurat det samme som maks, bare at det her legges inn en teller som okes hver gang det skjer en ombytting.
    public static int ombyttinger(int[] a) {
        int teller = 0;

        if (a.length < 1)
            throw new java.util.NoSuchElementException("Tabellen er tom");

        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                int verdi = a[i];
                a[i] = a[i + 1];
                a[i + 1] = verdi;
                teller++;
            }
        }
        return teller; //Returnerer telleren her, ikke siste elementet i arrayet som i maks-metoden.
    }

    ///// Oppgave 2 //////////////////////////////////////
    public static int antallUlikeSortert(int[] a) {

        int antallUlike = 1; //maa starte på en siden det alltid vil vaere en ulik med mindre arrayet er tomt

        for (int i = 0; i < a.length - 1; i++) { //For lokke gjennom arrayet

            if (a[i + 1] > a[i]) { //Hvis det neste tallet er storre enn det forige i arrayet oker antall ulike.
                antallUlike++;     //Ma vaere > for aa unnga at den teller like verdier som to ulike
            }

            if (a[i] > a[i + 1])   //Sjekker at ikke verdien til a[i] er storre enn neste verdi i arrayet. Hvis den er det er ikke arrayet sortert stigende
                throw new IllegalStateException("Tabellen må være sortert stigende"); //Kaster exception hvis arrayet ikke er sortert stigende
        }

        if (a.length == 0) { //sjekker om arrayet er tomt
            antallUlike = 0; //Hvis arrayet er tomt er det 0 ulike
        }

        return antallUlike; //returnerer antall ulike
    }


    ///// Oppgave 3 //////////////////////////////////////
    public static int antallUlikeUsortert(int[] a) {

        int antallUlike = a.length; //starter med å anta at alle er ulike
        for (int i = 0; i < a.length - 1; i++) { //For lokke
            for (int j = i + 1; j < a.length; j++) { //For lokke inne i forlokka, som starter pa verdien etter a[i]
                if (a[i] == a[j]) { //Ser om den finner noen verdier senere i arrayet som er lik a[i]
                    antallUlike--; //Hvis den gjor det trekkes det fra en pa antall ulike
                    break; //Gar ut av for lokka
                }
            }
        }
        return antallUlike; //Returnerer antall ulike
    }

    ///// Oppgave 4 //////////////////////////////////////
    public static void delsortering(int[] a) {
        int teller = 0; //Oppretter en teller med verdien 0

        for (int i = 0; i < a.length; i++) { //for lokke
            if (a[i] % 2 != 0) { //Hvis det er oddetall
                int midlertidig = a[teller]; //Setter en midlertidig verdi lik verdien til a[teller]
                a[teller] = a[i]; //Setter verdien til a[teller] lik verdien til a[i]
                a[i] = midlertidig; //Setter verdien til a[i] lik den midlertidigie verdien, altsa lik den tidligere verdien til a[teller]
                teller++; //oker verdien til teller
            }
        }
        if (teller == a.length || teller == 0) { //Hvis telleren enten er lik arrayets storrelse eller 0, sorterer den bare arrayet.
            Arrays.sort(a); //Siden det da kun er oddetall eller partall
        } else { //Ellers sorterer den forst oddetallene ogsa partallene
            Arrays.sort(a, 0, teller); //sorterer oddetallene, intervallet fra fra a[0] og til a[teller] (antall oddetall) i arrayet.
            Arrays.sort(a, teller, a.length); ////sorterer partallene, intervallet fra fra a[teller] og til slutten av arrayet.
        }

    }

    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a) {

        if (a.length > 0) { //Sjekker at arrayet ikke er tomt.
            char siste = a[a.length - 1]; //Oppretter en char-parameter som er lik siste verdi i arrayet
            for (int i = a.length - 1; i > 0; i--) { //for lokke
                a[i] = a[i - 1]; //Setter ny verdi for a[i]. Den nye verdien er a[i-1] altsa verdien som ligger foran a[i] i arrayet
            }
            a[0] = siste; //a[0] er na "tomt", sa da setter man siste variablen her.
        }

    }

    ///// Oppgave 6 //////////////////////////////////////
    public static void rotasjon(char[] a, int k) {

        int n = a.length;                  //int lik lengden til arrayet
        if (n < 2) return;                 // hvis arrayet er tomt eller en verdi, ingen rotasjon
        if ((k %= n) < 0) k += n;

        if (k <= (n + 1) / 2)  // forskyver k enheter mot høyre
        {
            char[] b = Arrays.copyOfRange(a, n - k, n);         // opretter hjelpetabell
            for (int i = n - 1; i >= k; i--) a[i] = a[i - k];   // forskyver k enheter
            System.arraycopy(b, 0, a, 0, k);                    // kopierer
        } else  // forskyver mot venstre n - k enheter mot venstre
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

        for (int i = 0; i < s.length(); i++) {
            ny = ny + s.charAt(i);
            if (i < t.length()) {
                ny = ny + t.charAt(i);
            }
        }

        if (s.length() < t.length()) {
            ny = ny + t.substring(s.length());
        }

        return ny;
    }

    /// 7b)
    public static String flett(String... s) {
        if (s.length < 0) {
            return "";
        }

        int lengste = 0;
        for (String s1 : s) {
            if (lengste < s1.length()) {
                lengste = s1.length();
            }
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < lengste; i++) {

            for (int j = 0; j < s.length; j++) {
                if (i < s[j].length()) {
                    result.append(s[j].charAt(i));
                }
            }


        }
        return result.toString();
    }

    ///// Oppgave 8 //////////////////////////////////////
    public static int[] indekssortering(int[] a) {
        int[] indeks = new int[a.length];
        int[] sortert = a.clone();

        for (int i = 0; i < sortert.length; i++) {
            for (int j = i + 1; j < sortert.length; j++) {
                if (sortert[i] > sortert[j]) {
                    int temp = sortert[i];
                    sortert[i] = sortert[j];
                    sortert[j] = temp;
                }
            }
        }

        int indeksen = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
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

        if (n < 3) { //Arrayet må ha minst 3 verdier
            throw new NoSuchElementException("Arrayet må ha minst 3 verdier!");
        }

        int minst = 0; //Posisjonen til minste
        int nestMinst = 1; //Posisjonen til 2. minste
        int tredjeMinst = 2; //Posisjonen til 3. minste

        if (a[nestMinst] < a[minst]) {
            minst = 1;
            nestMinst = 0;
        }

        if (a[tredjeMinst] < a[minst]) {
            int midlertidig = tredjeMinst;
            tredjeMinst = minst;
            minst = midlertidig;
        }

        if (a[tredjeMinst] < a[nestMinst]) {
            int midlertidig = tredjeMinst;
            tredjeMinst = nestMinst;
            nestMinst = midlertidig;
        }

        int minsteVerdi = a[minst];  //minste verdi
        int nestMinsteVerdi = a[nestMinst];   //nest minste verdi
        int tredjeMinsteVerdi = a[tredjeMinst];   //tredje minste verdi

        for (int i = 3; i < a.length; i++) {
            int verdi = a[i];

            if (verdi < tredjeMinsteVerdi) {
                if (verdi < nestMinsteVerdi) {
                    if (verdi < minsteVerdi) {

                        //Kan hende disse må endres litt på. Rekkefølge osv

                        tredjeMinst = nestMinst;
                        tredjeMinsteVerdi = nestMinsteVerdi;

                        nestMinst = minst;
                        nestMinsteVerdi = minsteVerdi;

                        minst = i;
                        minsteVerdi = verdi;

                    } else { //her er verdi >= maksverdi && verdi < nestmaksverdi

                        tredjeMinst = nestMinst;
                        tredjeMinsteVerdi = nestMinsteVerdi;

                        nestMinst = i;
                        nestMinsteVerdi = verdi;

                    }
                } else { // når verdi >= nestmaksverdi && verdi < tredjemaksverdi
                    tredjeMinst = i;
                    tredjeMinsteVerdi = verdi;
                }
            }
        }
        return new int[]{minst, nestMinst, tredjeMinst};
    }

    ///// Oppgave 10 //////////////////////////////////////

    public static boolean inneholdt(String a, String b) {



        //FUNKER MEN GÅR FOR SAKTE
        char[] hjelp = new char[b.length()];

        for(int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            if (b.indexOf(c) == -1) {
                return false;
            }
            else{
                hjelp[i] = c;
                b = b.replaceFirst(a.charAt(i) + "", "");
            }
        }
        return true;

        /*char[] aArray = a.toCharArray();
        char[] bArray = b.toCharArray();

        Arrays.sort(aArray);
        Arrays.sort(bArray);

        for(int i = 0; i<aArray.length; i++){
            for(int j = 0; j<bArray.length; j++){
                if(aArray[i] == bArray[j]){
                    char midlertidig = bArray[i];
                    bArray[i] = bArray[j];
                    bArray[j] = midlertidig;
                    break;
                }
                else{
                    return false;
                }
            }
        }
        return true;*/





    }
}

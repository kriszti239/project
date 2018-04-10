package mestint;
import java.util.ArrayList;
import java.util.Arrays;
/* Mesterséges intelligencia önálló beadandó munka: Három kannibál és három misszionárius kíván átkelni egy széles folyón, és ehhez csak egy kétszemélyes csónakot használhatnak. 
Ha a kannibálok valamely parton létszámfölénybe kerülnek, akkor megeszik az ott található misszionáriust vagy misszionáriusokat. 
A kannibálok a jó falatok reményében gondolkodás nélkül teljesítik nekik kiadott parancsokat. 
Adja meg a misszionáriusok számára biztonságos átkelés lépéseit!*/
class Muveletek {
    public static ArrayList<char[]> rakovetkezok_meghatarozasa(char[] szulo, int csonak, int k, int m) {
        ArrayList<char[]> rakovetkezok = new ArrayList<>();
        char[][] atadando = new char[6][7];
        int j;
        if (csonak == 0) {
            if (m >= 2) {
                for (j = 0; j < k; j++) {
                    atadando[0][j] = 'K';
                }
                for (int a = 0; a < m - 2; a++) {
                    atadando[0][j++] = 'M';
                }
                atadando[0][6] = '1';
                rakovetkezok.add(atadando[0]);
            }
            if (m >= 1 && k >= 1) {
                for (j = 0; j < k - 1; j++) {
                    atadando[1][j] = 'K';
                }
                for (int a = 0; a < m - 1; a++) {
                    atadando[1][j++] = 'M';
                }
                atadando[1][6] = '1';
                rakovetkezok.add(atadando[1]);
            }
            if (k >= 2) {
                for (j = 0; j < k - 2; j++) {
                    atadando[2][j] = 'K';
                }
                for (int a = 0; a < m; a++) {
                    atadando[2][j++] = 'M';
                }
                atadando[2][6] = '1';
                rakovetkezok.add(atadando[2]);

            }
            if (k >= 1 && (k < 3 || m < 3)) {
                for (j = 0; j < k - 1; j++) {
                    atadando[3][j] = 'K';
                }
                for (int a = 0; a < m; a++) {
                    atadando[3][j++] = 'M';
                }
                atadando[3][6] = '1';
                rakovetkezok.add(atadando[3]);
            }
            if (m >= 1 && (k < 3 || m < 3)) {
                for (j = 0; j < k; j++) {
                    atadando[4][j] = 'K';
                }
                for (int a = 0; a < m - 1; a++) {
                    atadando[4][j++] = 'M';
                }
                atadando[4][6] = '1';
                rakovetkezok.add(atadando[4]);
            }
        } else {
            if (m == 0 && k == 0) {
                atadando[0][0] = 'A';
                rakovetkezok.add(atadando[0]);
                return rakovetkezok;
            }
            if (m <= 1) {
                for (j = 0; j < k; j++) {
                    atadando[1][j] = 'K';
                }
                for (int a = 0; a < m + 2; a++) {
                    atadando[1][j++] = 'M';
                }
                atadando[1][6] = '0';
                rakovetkezok.add(atadando[1]);
            }
            if (m <= 2) {
                for (j = 0; j < k; j++) {
                    atadando[2][j] = 'K';
                }
                for (int a = 0; a < m + 1; a++) {
                    atadando[2][j++] = 'M';
                }
                atadando[2][6] = '0';
                rakovetkezok.add(atadando[2]);

            }
            if (k <= 1) {
                for (j = 0; j < k + 2; j++) {
                    atadando[3][j] = 'K';
                }
                for (int a = 0; a < m; a++) {
                    atadando[3][j++] = 'M';
                }
                atadando[3][6] = '0';
                rakovetkezok.add(atadando[3]);
            }
            if (k <= 2) {
                for (j = 0; j < k + 1; j++) {
                    atadando[4][j] = 'K';
                }
                for (int a = 0; a < m; a++) {
                    atadando[4][j++] = 'M';
                }
                atadando[4][6] = '0';
                rakovetkezok.add(atadando[4]);
            }
            if (k <= 2 && m <= 2) {
                for (j = 0; j < k + 1; j++) {
                    atadando[5][j] = 'K';
                }
                for (int a = 0; a < m + 1; a++) {
                    atadando[5][j++] = 'M';
                }
                atadando[5][6] = '0';
                rakovetkezok.add(atadando[5]);
            }
        }
        return rakovetkezok;
    }
}
public class kannibal_misszionarius {
    public static void main(String[] args) {
        char[] szulo = {'K', 'K', 'K', 'M', 'M', 'M','0'};
        ArrayList<char[]> rakovetkezok = new ArrayList<>();
        ArrayList<char[]> perem = new ArrayList<>();
        perem.add(szulo);
        ArrayList<char[]> zar = new ArrayList<>();  
        int csonak = 0; // 0 ha bal oldalon van a csónak
        while (perem.size() > 0) {
            int k = 0;
            int m = 0;
            for (int i = 0; i < szulo.length; i++) {
                if (szulo[i] == 'K') {
                    k++;
                } else if (szulo[i] == 'M') {
                    m++;
                }
            }          
            int flag = 0;
            for (int i = 0; i < zar.size(); i++) {
                char[] vizsgalando = zar.get(i);
                flag = 0;
                if (vizsgalando.length == szulo.length) {
                    for (int l = 0; l < vizsgalando.length; l++) {
                        if (vizsgalando[l] != szulo[l]) {
                            flag = 1;
                        }
                    }
                    if (flag == 0) {
                        perem.remove(perem.size() - 1);
                        if (perem.size() != 0) {
                            szulo = perem.get(perem.size() - 1);
                            i = 0;
                        }
                        k = 0;
                        m = 0;
                        for (int j = 0; j < szulo.length; j++) {
                            if (szulo[j] == 'K') {
                                k++;
                            } else if (szulo[j] == 'M') {
                                m++;
                            }
                        }
                    }
                } else {
                    flag = 1;
                }
            }
            vissza:
            if ((k > m && m != 0)||( m <= 2 && m > k)) {
                perem.remove(perem.size() - 1);
                if (perem.size() != 0) {
                    szulo = perem.get(perem.size() - 1);
                    break vissza;
                }
                k = 0;
                m = 0;
                for (int j = 0; j < szulo.length; j++) {
                    if (szulo[j] == 'K') {
                        k++;
                    } else if (szulo[j] == 'M') {
                        m++;
                    }
                }
            } else {
                if (szulo[0] == 'A') {
                    break;
                }
                if (szulo[6]=='0') {
                    csonak = 0;
                } else {
                    csonak = 1;
                }
                rakovetkezok = Muveletek.rakovetkezok_meghatarozasa(szulo, csonak, k, m);
                if(zar.add(szulo));
                perem.remove(perem.size() - 1);
                for (int i = 0; i < rakovetkezok.size(); i++) {
                    perem.add(rakovetkezok.get(i));
                }
                szulo = perem.get(perem.size() - 1);
            }
        }
        char allapot = '1';
        ArrayList<char[]> megoldas = new ArrayList<>();
        int j = 0;
        for(int i=zar.size()-1;i>=0;i--){
            char[] elem = zar.get(i);
            if(elem[elem.length-1] == allapot){
                megoldas.add(elem);
            }
            else{
                continue;
            }
            if(allapot == '1') allapot = '0';
            else allapot = '1';
        }
        System.out.println("Alapallapot: K K K M M M");
        System.out.println();
        int x = 1;
        for(int i = megoldas.size()-2;i>=0;i--){
            System.out.print((x++)+". lépés: ");
            int k = 0;
            int m = 0;
            char[] elem = megoldas.get(i);
            for (j = 0; j < elem.length; j++) {
                if (elem[j] == 'K') {
                    k++;
                } 
                else if (elem[j] == 'M') {
                     m++;
                }
            }
            char[] masikpart = new char[6];
            for(j=0;j<3-k;j++){
                masikpart[j] = 'K';
            }
            for(int l = 0;l<3-m;l++){
                masikpart[j++] = 'M';
            }
            if(elem[elem.length-1] == '1'){
                System.out.print("1. part: ");
                for(j= 0;j<elem.length-1;j++){
                    System.out.print(elem[j]+" ");
                }
                System.out.print("2. part: ");
                for(j=0;j<masikpart.length;j++){
                    System.out.print(masikpart[j]+ " ");
                }
            }
            else{
                System.out.print("1. part: ");
                for(j= 0;j<elem.length-1;j++){
                    System.out.print(elem[j]+" ");
                }
                System.out.print("2. part: ");
                for(j=0;j<masikpart.length;j++){
                    System.out.print(masikpart[j]+ " ");
                }
            }
            System.out.println();
            System.out.println();
        }
    }
}
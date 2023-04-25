import java.io.*;
import java.util.ArrayList;

public class Main {
    // 1.   Реализовать функцию возведения числа а в степень b. a, b ∈ Z. Сводя количество выполняемых действий к минимуму.
//    Пример 1: а = 3, b = 2, ответ: 9
//    Пример 2: а = 2, b = -2, ответ: 0.25
//    Пример 3: а = 3, b = 0, ответ: 1
//    Пример 4: а = 0, b = 0, ответ: не определено
//    Пример 5
//    входные данные находятся в файле input.txt в виде
//    b 3
//    a 10
//    Результат нужно сохранить в файле output.txt
//1000

    public static void main(String[] args) {
        String patch="inputData.txt";
        save(patch);

    }

    public static ArrayList<String> loading(String file) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            String line;
            ArrayList<String> result = new ArrayList<>();

            while ((line = br.readLine()) != null) {
                String[] token_a = line.split(" ");
                int a = Integer.parseInt(token_a[1]);
                String line2 = br.readLine();
                String[] token_b = line2.split(" ");
                int b = Integer.parseInt(token_b[1]);
                double multi = powRec(a, b);
                result.add(Double.toString(multi));
            }
            return result;
        }catch (FileNotFoundException fileNotFoundException){
            System.out.println("File not found !");
            return null;
        }
        catch (IOException ioException) {
            System.out.println("I/O error");
            return  null;
        }
    }

    public static double powRec(int a, int b){
        if(b==0) return  1;
        if(b<0)  powRec(1/a,-b);
        double res=powRec(a,b/2);
        return b%2==0? res*res : res*res*a;
    }

    public static void save(String file)  {
        ArrayList<String> res=loading(file);
        String fileName="output.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String value : res) {
                writer.write(value + "\n");
            }
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }catch (NullPointerException nullPointerException){
            System.out.println(nullPointerException.getMessage());
        }
    }
}

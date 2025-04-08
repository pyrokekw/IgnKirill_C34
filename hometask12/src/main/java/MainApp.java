import java.io.*;

public class MainApp {

    public static void main(String[] args) {

        String fileName = "play.txt";
        String romeoFile = "Romeo.txt";
        String gulietaFile = "Gulieta.txt";
        try (BufferedReader inputStream = new BufferedReader(new FileReader(fileName));
             BufferedWriter romeoStream = new BufferedWriter(new FileWriter(romeoFile));
             BufferedWriter gulietaStream = new BufferedWriter(new FileWriter(gulietaFile))) {

            String line;
            BufferedWriter currentWriter = null;

            while ((line = inputStream.readLine()) != null) {
                if (line.startsWith("Romeo:")){
                    currentWriter = romeoStream;
                } else if (line.startsWith("Gulieta:")) {
                    currentWriter = gulietaStream;
                }

                if (currentWriter != null){
                    currentWriter.write(line);
                    currentWriter.newLine();
                }
            }

            System.out.println("Файл разделен!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }

}


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Task39 {
    static int nooffilewords = 0;
    static Node node = null;
    static BinaryTree bt = new BinaryTree();
    static int noofwords = 0;
    static Word nodeData[] = new Word[154];
    static int wordsrepeated[] = new int[154];

    public static void main(String[] args) {
        try {
            Task39.readFromFile("daffodils.txt");
        } catch (Exception e) {
            e.getMessage();
        }
        // System.out.println("----------Reverse order------------");
        // bt.showReverseorder(node);
        System.out.println("-----------Frequency reverse order-----------");
        bt.frequencyReverse();

    }

    public static void readFromFile(String fileName) throws Exception {
        File file = new File(fileName);

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = "";
            String[] words = null;
            int i = 0;

            while ((line = br.readLine()) != null) {
                line = line.toLowerCase().replaceAll("[,':;.?]", "");
                words = line.split(" ");
                for (String word1 : words) {
                    Task39.nooffilewords++;
                    node = bt.insert(node, new Word(word1));
                    // w[i] = new Word(word1); i++;
                }
            }
        }
        bt.showReverseorder(node);
    }
}

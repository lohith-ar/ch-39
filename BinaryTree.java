
public class BinaryTree {
    static int temp[] = new int[Task39.nooffilewords];
    static int i = 0;


    public Node createNode(Word word) {
        Node node = new Node();
        node.word = word;
        node.left = null;
        node.right = null;
        return node;
    }

    public Node insert(Node node, Word word) {
        if (node == null) {
            node = createNode(word); 
            return node; 
        }
        if (node.word.getWord().compareTo(word.getWord()) == 0) {
            node.word.setWordsRepeated();
            return node;
        } else {
            if (word.getWord().compareTo(node.word.getWord()) < 0) {
                node.left = insert(node.left, word);
            } else if (word.getWord().compareTo(node.word.getWord()) > 0) {
                node.right = insert(node.right, word);
            } else if (word.getWord().compareTo(node.word.getWord()) == 0) {
                node = insert(node, word);
            } else
                return node;
        }
        return node;
    }

    public void showReverseorder(Node node) {
        if (node != null) {
            showReverseorder(node.right);
            // System.out.println(node.word.getWord() + "  " + node.word.getWordsRepeated()); 
            Task39.noofwords++;
            Task39.nodeData[i] = node.word;  
            Task39.wordsrepeated[i] = node.word.getWordsRepeated(); i++;  
            showReverseorder(node.left);

        }
    }


    public void frequencyReverse() {
        // System.out.println(Task39.nooffilewords);
        for(int j=0; j< Task39.noofwords;j++){
        for(int i=0; i< Task39.noofwords-1 ; i++){
            if(Task39.wordsrepeated[i]< Task39.wordsrepeated[i+1]){
                int temp = Task39.wordsrepeated[i];
                Task39.wordsrepeated[i] = Task39.wordsrepeated[i+1];
                Task39.wordsrepeated[i+1] = temp;
                Word tmp = Task39.nodeData[i];
                Task39.nodeData[i] = Task39.nodeData[i+1];
                Task39.nodeData[i+1] = tmp;

            }           
        }}
        for( int i=0; i<Task39.noofwords; i++){
            System.out.println(Task39.nodeData[i].getWord()+ " " + Task39.wordsrepeated[i]);
        }
    }

  

}

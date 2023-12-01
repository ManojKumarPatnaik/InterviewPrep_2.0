package Amazon;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
https://www.youtube.com/watch?v=oXEPfYaMOwI

requirements:

/a/b/c/

ls: /a
    should show all the folders and file inside this directory path only.
    ex: /a/b, /a/c/d, /a/mark.xml  output: b, c, mark.xml

mkdir:
/a/b/c  if b and c does not exist it should create the them in the path

add file:
file path, data (if file path does not exisit, it should create and then insert the data else it append the data to the file)

read: file_path
if there is no file present, throw file not found exception

delete:



 */
public class FileSystemImpl {

    TrieNode rootNode;

   public FileSystemImpl() {

       rootNode = new TrieNode();
    }

    private List<String> ls(String filePath) {


       return null;
    }

    private void mkdir(String filePath) {

       /*   /a/b/c  */
       String[] nodes = filePath.split("/");
       TrieNode startNode = rootNode;
      for(int i=1; i<nodes.length; i++) {

          if(!startNode.children.containsKey(nodes[i])){

              TrieNode newNode = new TrieNode();
              startNode.children.put(nodes[i], newNode);
          }
          startNode = startNode.children.get(nodes[i]);
      }
    }

    private void addContent(String filePath, String content) {

    }

    private void readContent(String filePath) {

    }



    class TrieNode{

        String content;
        Map<String,TrieNode> children;


        TrieNode() {
            content = null;
            children = new HashMap<>();
        }
    }

    public  static void main(String args[]){



        FileSystemImpl fs = new FileSystemImpl();
        fs.mkdir("/a/b/c");
        fs.mkdir("/a/b/d/e");
        if(fs.rootNode != null){

        };

    }
}

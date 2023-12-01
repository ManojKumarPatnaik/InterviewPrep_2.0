package Amazon;

public class LLD_FileDesing {
}

/*
Logical and Maintainable

Imagine that you need to write code in a high level language like java, that does things similar to the find command.
I would like you to focus on 2 uses cases at first.

    Find all files over 5 MB somewhere under a directory.
    Find all XML files somewhere under a directory.
    ...
    ...
    AND OR find files > 5 Mb OR extension is XML

((file > 5Mb) or (file < 1Mb)) and (file ends in XML)

I would like you to create a library that lets me do this easily.
Keep in mind that these are just 2 uses cases and that the library should be flexible.



requirement:

class FileTree{

   String name;
   String Type;
   boolean isDirectory;
   int size;
   List<FileTree> childrens;
}

FilterNode{

    sizeGreaterThan - 4MB
    sizeL
    dsfs
    sizeequal = 7mb

}


Filter{


}

SizeFilter{

    GREATER, LESSER_THAN, EQUALS
}

// example
List<File> find(FileTree startLocation, Filter sizeFilter, List<File> output) {

    if(!startLocation.isDirectory) {


            boolean fileMatched =  filter(startLocation.size, sizeFilter, output);
            if(fileMatched) {
               output.add(startLocation);


        }
    } else {

        while(FileTree childsNode: startLocation.childrens) {

            find(childsNode, sizeFilter);
        }
    }
}


class Filter{




   boolean filter(FileTree file) {




   }
}



SizeFilter extends Filter{



boolean filter(FileTree file) {


}




}








 */
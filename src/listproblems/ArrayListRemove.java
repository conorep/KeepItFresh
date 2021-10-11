package listproblems;

import java.util.*;


/**
 * This class tests removing a specified string from an ArrayList and times
 * various approaches
 */
public class ArrayListRemove {

    public static void main(String[] args) {

        ArrayList<String> bases =
                new ArrayList(Arrays.asList(new String[] {"binary", "hex", "decimal",
                        "binary", "binary","hex","binary"}));

        removeAllString(bases,"binary");
        System.out.println("Expected: [hex, decimal, hex] --->   " + bases);
    }

    /**
     * Removes all occurrences of the given string from the given list.
     *
     * @param list list of strings
     * @param remove string to remove
     */
    public static void removeAllString(ArrayList<String> list, String remove){
        long start = System.nanoTime();

        // Option 1 use removeAll method
//        ArrayList<String> toRemove = new ArrayList<>();
//        toRemove.add(remove);
//        list.removeAll(toRemove);

//        list.removeAll(Collections.singleton(remove)); <------ Collections.singleton slows stuff a bunch


        // Option 2 use the remove method from iterator
//        Iterator<String> it = list.iterator();
//        while(it.hasNext())
//        {
//          // if next element equals the string to remove
//          if(it.next().equals(remove))
//          {
//              it.remove();
//          }
//        }


        // Option 3 use a for index loop
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i).equals(remove))
            {
                list.remove(i); // <--- remove object at index
                i--; // <--- move back one because the list shrinks
            }
        }

//        for (String removeStr : list) <--- concurrent modification exception - no can do.
//        {
//            if (removeStr.equals(remove))
//            {
//                list.remove(removeStr);
//            }
//        }


        // Which option seems fastest?
        System.out.println("Elapsed Time: " + (System.nanoTime() - start) + " nanoseconds");
    }

}

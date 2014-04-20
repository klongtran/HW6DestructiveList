import acm.program.ConsoleProgram;

/**
 * Created by Khanh-Long on 4/12/14.
 */
public class Testing extends ConsoleProgram {

    public void run() {
        DestructiveList<String> instance = new DestructiveList<>();
        instance.add("A");
        instance.add("A");
        instance.add("B");
        instance.add("C");
        instance.add("C");
        instance.add("C");
        instance.add("C");
        instance.add("C");
        instance.add("C");
        instance.add("B");
        instance.add("B");
        instance.add("A");
//        instance.add("E");
//        instance.add("E");
//        instance.add("E");
//        instance.add("F");
//        instance.add("F");

        println(instance.toString());
        println(instance.size());

        instance.removeGroupsOf(2);
        println(instance.toString());
        println(instance.size());
        println(instance.checkForGroupSize(2) + "\n");

        instance.removeGroupsOf(2);
        println(instance.toString());
        println(instance.size());
        println(instance.checkForGroupSize(2) + "\n");

//        instance.removeGroupsOf(3);
//        println(instance.toString());
//        println(instance.size());
//        println(instance.checkForGroupSize(3) + "\n");
    }
}

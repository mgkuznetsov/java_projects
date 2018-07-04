
public class MainClass {
	public static void main(String[] args)
    {
        HashMap<String, Integer>map = new HashMap<>();
        map.add("this",1 );
        map.add("coder",2 );
        map.add("this",4 );
        map.add("hi",5 );
        System.out.println(map.getSize());
        System.out.println(map.remove("this"));
        System.out.println(map.remove("this"));
        System.out.println(map.getSize());
        System.out.println(map.isEmpty());
    }
}

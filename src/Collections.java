import java.util.*;

/**
 * Created by Levchenko Maksym on 11.06.2019.
 */
public class Collections {


    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        String[] string = {"2", "1", "3", "4"};
        List<String> list2 = new ArrayList(Arrays.asList(string));
        List<String> list3 = new ArrayList<>(list1);
        list2.addAll(list2.size() / 2, list3);
        list2.sort(Comparator.reverseOrder());
        System.out.println(list2);
        Iterator<String> iter = list2.iterator();
        while (iter.hasNext()) {
            iter.next();
            iter.next();
            iter.remove();

        }
        for (int i = 0; iter.hasNext(); i++) {
            iter.next();
            if (1 % 2 != 0) {
                iter.next();
                iter.remove();
                i++;
                System.out.println(iter);

            }


        }
        Set<String> set1 = new HashSet<>();
        set1.add("hi");
        set1.add("hello");
        set1.add("mynameisMaksim");
        set1.addAll(list1);
        set1.addAll(list2);
        for (String s : set1) {
            System.out.println(set1);
        }
        ;

        Set<String> set2 = new LinkedHashSet<>();
        set2.addAll(list2);
        set2.addAll(list3);
        System.out.println(set2);
        Map<Integer, String> map1 = new LinkedHashMap<>();
        map1.put(1, "January");
        map1.put(2, "February");
        map1.put(3, "March");
        map1.put(4, "April");
        map1.put(5, "May");
        map1.put(6, "June");
        map1.put(7, "July");
        map1.put(8, "August");
        map1.put(9, "September");
        map1.put(10, "October");
        map1.put(11, "November");
        map1.put(12, "December");
        System.out.println(map1.get(1) + " " + map1.get(12));
        map1.replace(6, "VACATION");
        Map<Integer, String> map2 = new HashMap<>(map1);
        for (Map.Entry<Integer, String> e : map2.entrySet()) {
            System.out.println(e);
        }
        System.out.println(map1);
        System.out.println(map2);

        Map<String, String> map3 = new HashMap<>();
        map3.put("Levchenko Maksym", "Skype:andrewct2");
        for (Map.Entry<String, String> item : map3.entrySet()) {
            System.out.println(item);
        }
    }
}

class User {

    String name;
    int age;
    int phone;
    HashSet<User> userSet1 = new HashSet<>();

    public HashSet<User> getUserSet1() {
        return userSet1;
    }

    public void setUserSet1(HashSet<User> userSet1) {
        this.userSet1 = userSet1;
    }

    public User(String name, int age, int phone) {
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    User user = new User("Mike", 34, 235);
    User user1 = new User("Mike", 34, 235);
    User user3 = new User("Mike", 35, 235);


}

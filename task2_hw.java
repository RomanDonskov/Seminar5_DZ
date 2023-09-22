import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class task2_hw {
    public static void main(String[] args){
        String data = "Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, " + 
                       "Анна Крутова, Иван Юрин, Петр Лыков, Павел Чернов, Петр Чернышов, "+
                       "Мария Федорова, Марина Светлова, Мария Савина, Мария Рыкова, Марина Лугова, "+
                       "Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов";
        String[] names = data.split(", ");
        Map<String, Integer> map = new HashMap<>();
        
        for (String name: names){
             String nam = name.split(" ")[0];
             int pov = map.getOrDefault(nam, 0);
             pov++;
             map.put(nam, pov);
        }

        Map<Integer, List<String>> res = new TreeMap<>(Comparator.reverseOrder());
        for (Map.Entry<String, Integer> entry: map.entrySet()){
            String name = entry.getKey();
            int pov = entry.getValue();
            if (res.containsKey(pov)){
                List<String> list = res.get(pov);
                list.add(name);
            }
        else {
            List<String> list = new ArrayList<>();
            list.add(name);
            res.put(pov, list);
        }
        }
    System.out.println(res);

    }
}
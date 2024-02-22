package IT_Step_Homework;
import java.util.ArrayList;
import java.util.List;

public class NestedDataStructure {

    private List<List<List<String>>> data = new ArrayList<>();

    public void addElement(String element, int outerIndex, int innerIndex) {
        if (outerIndex >= data.size()) {
            data.add(new ArrayList<>());
        }
        List<List<String>> outerList = data.get(outerIndex);

        if (innerIndex >= outerList.size()) {
            outerList.add(new ArrayList<>());
        }
        List<String> innerList = outerList.get(innerIndex);
        innerList.add(element);
    }

    public void removeElement(int outerIndex, int innerIndex, int elementIndex) {
        if (outerIndex < data.size()) {
            List<List<String>> outerList = data.get(outerIndex);
            if (innerIndex < outerList.size()) {
                List<String> innerList = outerList.get(innerIndex);
                if (elementIndex < innerList.size()) {
                    innerList.remove(elementIndex);
                }
            }
        }
    }

    public void printData() {
        for (List<List<String>> outerList : data) {
            for (List<String> innerList : outerList) {
                for (String element : innerList) {
                    System.out.println(element);
                }
            }
        }
    }

    public static void main(String[] args) {
        NestedDataStructure nestedDataStructure = new NestedDataStructure();
        nestedDataStructure.addElement("Element 1", 0, 0);
        nestedDataStructure.addElement("Element 2", 0, 1);
        nestedDataStructure.addElement("Element 3", 1, 0);

        nestedDataStructure.printData();

        nestedDataStructure.removeElement(0, 0, 1);

        nestedDataStructure.printData();
    }
}
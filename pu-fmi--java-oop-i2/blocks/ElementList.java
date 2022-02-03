package blocks;

import java.util.ArrayList;

public  class ElementList extends Element {
    ElementListEnum listType = ElementListEnum.Unordered;
    final String LIST_ELEMENT="li";
    ArrayList<Element> listElements = new ArrayList<>();
    String name="ul";

    public static void listTypeChecker(ElementList list){
        if(list.listType.equals(ElementListEnum.Ordered)){
            list.name="ol";
        }
    }
    public void addElement(Element element){
        this.stringBuilderArrayList.add(stringBuilderArrayList.size()-1,HtmlFactory.convertToOpeningTag(this.LIST_ELEMENT));
        for ( String word : element.stringBuilderArrayList){
            this.stringBuilderArrayList.add(stringBuilderArrayList.size()-1,word);
        }
        this.stringBuilderArrayList.add(stringBuilderArrayList.size()-1,HtmlFactory.convertToClosingTag(this.LIST_ELEMENT));
    }

    public String getName(){
        return this.name;
    }
}

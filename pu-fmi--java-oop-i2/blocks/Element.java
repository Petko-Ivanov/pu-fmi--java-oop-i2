package blocks;

import java.util.ArrayList;

public  class Element {
    String name;
    ElementText textContent;
    ElementAttribute elementAttribute;
    ArrayList<Element> elementCollection= new ArrayList<>();

    ArrayList<String> stringBuilderArrayList = new ArrayList<>();
    StringBuilder sb= new StringBuilder();


    public  String getName(){
        return this.name;
    }
    public  String getTextContent(){
        return this.textContent.getText();
    }
    public  void addElement(Element element){
        for ( String word : element.stringBuilderArrayList){
            this.stringBuilderArrayList.add(stringBuilderArrayList.size()-1,word);
        }
    }

    public  String render(){
        for(String e : stringBuilderArrayList){
            sb.append(e);
        }
        return sb.toString();
    }
    public  String renderAsTSV(){
        for (int i=0;i<elementCollection.size();i++){
            sb.append(elementCollection.get(i));
            if(i+1<elementCollection.size()){
                if(elementCollection.get(i+1).name.equals("lang")){
                    sb.append("#");
                }
                if(elementCollection.get(i+1).name.equals("bg")){
                    sb.append("!");
                }
                if(elementCollection.get(i+1).name.equals("div")){
                    sb.append("~");
                }
                if(elementCollection.get(i+1).name.equals("h1")||elementCollection.get(i+1).name.equals("h2")){
                    sb.append("~~");
                }
            }
        }
        return sb.toString();
    }
}

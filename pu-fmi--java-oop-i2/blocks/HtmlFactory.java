package blocks;

import java.util.ArrayList;

import static blocks.ElementList.listTypeChecker;

public  class HtmlFactory extends ElementFactory {


    @Override
    public Element createNewElement(String name) {
        Element element = new Element();
        element.name=name;
        makeElementsHtml(element);
        return element;
    }

    @Override
    public Element createNewElement(String name,String content) {
        Element element = new Element();
        element.name=name;
        element.textContent=createTextElement(content);
        makeElementsHtml(element);
        element.addElement(createTextElement(content));
        element.elementCollection.add(element);
        return element;
    }

    @Override
    public Element createNewElement(String name, ElementAttribute attribute) {
        Element element = new Element();
        element.name=name;
        element.elementAttribute=attribute;
        makeElementsHtmlWithAttributes(element,attribute);
        element.elementCollection.add(element);
        return element;
    }

    @Override
    public Table createTable(String tableName, int row, int col) {
        Table table = new Table();
        table.name=tableName;
        table.tableRow=row;
        table.tableCol=col;
        generateTableWithName(tableName,table,row,col);
        table.elementCollection.add(table);
        return table;
    }

    @Override
    public Table createTable(int row, int col) {
        Table table= new Table();
        table.tableRow=row;
        table.tableCol=col;
        generateTableWithNoName(table,row,col);
        table.elementCollection.add(table);
        return table;
    }

    @Override
    public ElementText createTextElement(String content) {
        ElementText text = new ElementText();
        text.text=content;
        text.stringBuilderArrayList.add(content);
        return text;
    }

    @Override
    public ElementList createList() {
        ElementList list = new ElementList();
        list.name="ul";
        list.elementCollection.add(list);
        makeElementsHtml(list);
        return list;
    }

    @Override
    public ElementList createList(ElementListEnum listType) {
        ElementList list = new ElementList();
        list.listType=listType;
        list.name="ul";
        listTypeChecker(list);
        list.elementCollection.add(list);
        makeElementsHtml(list);
        return list;
    }

    @Override
    public ElementList createList(ElementListEnum listType, ArrayList<Element> collection) {
        ElementList list=new ElementList();
        list.listType=listType;
        list.name="ul";
        listTypeChecker(list);
        list.listElements=collection;
        list.elementCollection.add(list);
        makeElementsHtml(list);
        return list;
    }

    @Override
    public ElementAttribute createAttribute(String name, String value) {
        ElementAttribute attribute = new ElementAttribute();
        attribute.name=name;
        attribute.value=value;
        return attribute;
    }

    public static String convertToOpeningTag(String name){
        return "<"+name+">";
    }
    public static String convertToClosingTag(String name){
        return "</"+name+">";
    }

    public static void makeElementsHtml(Element element){
        String elementOpeningTag=convertToOpeningTag(element.getName());
        String elementClosingTag=convertToClosingTag(element.getName());

        element.stringBuilderArrayList.add(elementOpeningTag);
        element.stringBuilderArrayList.add(elementClosingTag);
    }

    private void generateTableWithNoName(Table table,int row , int col){
        table.stringBuilderArrayList.add("<table>");
        generateTable(table,row,col);
    }

    private void generateTableWithName(String name,Table table,int row , int col){
        table.stringBuilderArrayList.add("<table name='"+name+"'>");
        generateTable(table,row,col);
    }

    private void generateTable(Table table,int row , int col){
        for (int i=0;i<row;i++){
            table.stringBuilderArrayList.add("<tr>");
            for (int j=0;j<col;j++){
                table.stringBuilderArrayList.add("<td>");
                table.stringBuilderArrayList.add("</td>");
            }
            table.stringBuilderArrayList.add("</tr>");
        }
        table.stringBuilderArrayList.add("</table>");
    }

    private void makeElementsHtmlWithAttributes(Element element, ElementAttribute attribute){
        String elementOpeningTag = "<"+element.getName()+" "+attribute.getName()+"='"+attribute.getValue()+"'>";
        String elementClosingTag=convertToClosingTag(element.getName());
        element.stringBuilderArrayList.add(elementOpeningTag);
        element.stringBuilderArrayList.add(elementClosingTag);
    }


}

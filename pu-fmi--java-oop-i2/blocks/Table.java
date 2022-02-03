package blocks;

public  class Table extends Element {
    int tableRow;
    int tableCol;


    public  void addElement(Element element, int row, int col){
        int rowCounter=0;
        int colCounter=0;
        for ( int i=0;i<stringBuilderArrayList.size();i++){
            if(stringBuilderArrayList.get(i).equals("<tr>")){
                rowCounter++;
            }
            if(rowCounter==row){

                if(colCounter==col){
                    for(String word :element.stringBuilderArrayList){
                        this.stringBuilderArrayList.add(i+1,word);

                    }
                    return;
                }
                colCounter++;
            }

        }


    }
}
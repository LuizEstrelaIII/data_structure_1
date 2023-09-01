public class ParentesesValidator {
    private String parentese = "(";
    private String parenteseFechado = ")";
    private String colchete = "[";
    private String colcheteFechado = "]";
    private String chave = "{";
    private String chaveFechado = "}";
    private StackArray stack;
    private String[] expression;
    
    public ParentesesValidator(String[] expression){
        this.expression = expression;
    }  

      public boolean isValid() {
        StackArray stack = new StackArray(6);

        for (int i = 0; i < expression.length; i++) {
            String character = expression[i];
            if (isOpen(character)) {
                stack.push(character);
            } else {
                if (stack.isEmpty()) {
                    return false; 
                }
                String aberto = getOpen(character);
                if (!stack.pop().equals(aberto)) {
                    return false; 
                }
            }
        
    }
    return stack.isEmpty();
}        

    
    boolean isOpen(String character){
        return character == parentese || character == colchete || character == chave;
    }
    
    public String getOpen(String closeCharacter){
        
        if(closeCharacter == parenteseFechado){
            return parentese;
        }
        if(closeCharacter == colcheteFechado){
            return colchete;
        }
        if(closeCharacter == chaveFechado){
            return chave;
        }
        else{
            return null;
        }
    }
}

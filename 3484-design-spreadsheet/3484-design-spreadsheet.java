class Spreadsheet {
    int [][] grid;
    public Spreadsheet(int rows) {
        grid = new int[rows][26];
    }
    
    public void setCell(String cell, int value) {
        int[] pos = parseCell(cell);
        grid[pos[0]][pos[1]] = value;
    }
    
    public void resetCell(String cell) {
        int[] pos = parseCell(cell);
        grid[pos[0]][pos[1]] = 0;
    }
    
    public int getValue(String formula) {
        String[] parts = formula.substring(1).split("\\+");
        //substring(1) => "A1+7" and split("\\+") => "A1" and "7"
        return getOperand(parts[0]) + getOperand(parts[1]); 
    }
    public int getOperand(String operand){
        if(Character.isDigit(operand.charAt(0))) return Integer.parseInt(operand);

        int[] pos = parseCell(operand);
        return grid[pos[0]][pos[1]];
    }

    public int[] parseCell(String cell){
        char colchar = cell.charAt(0);
        int col = colchar-'A';
        int row = Integer.parseInt(cell.substring(1)) - 1; // acc to ques 1-Index
        return new int[]{row,col};
    }
    
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */
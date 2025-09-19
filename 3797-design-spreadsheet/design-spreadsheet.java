class Spreadsheet {
    private HashMap<String,Integer> hm;

    public Spreadsheet(int rows) {
        hm = new HashMap<>();
    }

    public void setCell(String cell, int value) {
        hm.put(cell, value);
    }

    public void resetCell(String cell) {
        hm.remove(cell); 
    }

    public int getValue(String formula) {
        

        String[] parts = formula.substring(1).split("\\+");
        int sum = 0;

        for (String part : parts) {
            part = part.trim(); 
            int value;
            try {
                value = Integer.parseInt(part);
            } catch (NumberFormatException e) {
                value = hm.getOrDefault(part, 0);
            }
            sum += value;
        }

        return sum;
    }
}

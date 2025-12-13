class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        
        List<Coupon>arr = new ArrayList<>();
        List<String>sort = Arrays.asList("electronics","grocery","pharmacy","restaurant");
        for(int i = 0 ; i < code.length ; i++){
            String str = code[i];
            if(str.matches("[a-zA-Z0-9_]+") && isActive[i] && sort.indexOf(businessLine[i])>=0){
                arr.add(new Coupon(str,businessLine[i]));
            }

        }
        Collections.sort(arr, (c1, c2) -> {
    int p1 = sort.indexOf(c1.businessLine);
    int p2 = sort.indexOf(c2.businessLine);

    if (p1 == p2) {
        return c1.code.compareTo(c2.code);
    }

    return Integer.compare(p1, p2);
});
        List<String>res = new ArrayList<>();
        for(int i = 0 ; i < arr.size() ; i++){
            res.add(arr.get(i).code);
        }
        return res;
    }
}
class Coupon {
    String code;
    String businessLine;

    Coupon(String code, String businessLine) {
        this.code = code;
        this.businessLine = businessLine;
    }
}

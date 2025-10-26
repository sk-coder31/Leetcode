class Bank {
    HashMap<Integer,Long>hm;
    public Bank(long[] balance) {
        hm = new HashMap<>();
        for(int i = 1; i <= balance.length ; i++){
            hm.put(i,balance[i-1]);
        }
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if(!hm.containsKey(account1) || !hm.containsKey(account2)){
            return false;
        }
        if(account1 == account2){
            long balance = hm.get(account1);
            if(balance >= money){
                return true;
            }else{
                return false;
            }
        }
        
        long account1_balance = hm.get(account1);
        long account2_balance = hm.get(account2);
        if((account1_balance - money)>=0){
            hm.put(account1,account1_balance-money);
            hm.put(account2,account2_balance+money);
            return true;
        }else{
            return false;
        }
    }
    
    public boolean deposit(int account, long money) {
        if(!hm.containsKey(account)){
            return false;
        }
        hm.put(account,hm.get(account)+money);
        return true;
    }
    
    public boolean withdraw(int account, long money) {
        if(!hm.containsKey(account)){
            return false;
        }
        long account_balance = hm.get(account);
        if((account_balance - money)>=0){
            hm.put(account,account_balance-money);
            return true;
        }
        return false;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */
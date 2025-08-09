class TopVotedCandidate {
    int n;
    int[] persons;
    int[] times;
    HashMap<Integer,Integer>hm = new HashMap<>();
    TreeMap<Integer,Integer>time_leader;
    public TopVotedCandidate(int[] persons, int[] times) {
        this.persons = persons;
        this.times = times;
        this.n = persons.length;
        this.time_leader = new TreeMap<>();
        int lead = persons[0];
        
        for(int i = 0 ; i < this.n ; i++){
            hm.put(persons[i],hm.getOrDefault(persons[i],0)+1);
            if(hm.get(persons[i])>=hm.get(lead)){
                lead = persons[i];
            }
            
            time_leader.put(times[i],lead);
        }
        
    }
    public int q(int t) {
    return time_leader.floorEntry(t).getValue();
}

}

